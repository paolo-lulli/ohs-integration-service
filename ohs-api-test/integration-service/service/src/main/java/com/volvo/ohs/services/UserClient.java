package com.volvo.ohs.services;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.google.protobuf.StringValue;
import com.volvo.ohs.protobuf.user.CreateUserRequest;
import com.volvo.ohs.protobuf.user.ShippingAddress;
import com.volvo.ohs.protobuf.user.UserResponse;
import com.volvo.ohs.protobuf.user.UserServiceGrpc;

import io.grpc.Channel;

@Component
public class UserClient{
	  private final UserServiceGrpc.UserServiceBlockingStub blockingStub;
	  
	  public UserClient(Channel channel) {
		  blockingStub = UserServiceGrpc.newBlockingStub(channel);
	  }
	  
	  public Optional<String> createUser(String fullname, String surname, String address, String email) {
	        CreateUserRequest userRequest = CreateUserRequest.newBuilder()
	                .setEmail(email)
	                .setAddress(ShippingAddress.newBuilder().setCountry(StringValue.newBuilder().setValue(address)).build())
	                .setFullName(StringValue.newBuilder().setValue(fullname))
	                .build();
		  UserResponse user = blockingStub.createUser(userRequest);
		  return (null == user) ? Optional.of(user.getPid()) : Optional.empty();
	  }
}
