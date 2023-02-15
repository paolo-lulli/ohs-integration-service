package com.volvo.ohs.proxy;

import java.util.Optional;

import com.google.protobuf.StringValue;
import com.volvo.ohs.dto.UserDto;
import com.volvo.ohs.protobuf.user.CreateUserRequest;
import com.volvo.ohs.protobuf.user.ShippingAddress;
import com.volvo.ohs.protobuf.user.UserServiceGrpc;

import io.grpc.Channel;

public class UserProxy {
	private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

	public UserProxy(Channel channel) {
		blockingStub = UserServiceGrpc.newBlockingStub(channel);
	}

	public Optional<String> createUser(UserDto dto) {
		CreateUserRequest userRequest = CreateUserRequest.newBuilder()
				.setEmail(dto.getEmail())
				.setAddress(ShippingAddress.newBuilder()
				.setCountry(StringValue.newBuilder()
						.setValue(dto.getAddresses().isEmpty() ? null : dto.getAddresses().get(0).getAddress()))
						.build())
				.setFullName(StringValue.newBuilder().setValue(dto.getFullName())).build();
		var user = blockingStub.createUser(userRequest);

		return (null != user) ? Optional.of(user.getPid()) : Optional.empty();
	}
}
