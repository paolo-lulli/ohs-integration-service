package com.volvo.ohs;

import com.volvo.ohs.grpc.ProductClient;
import com.volvo.ohs.grpc.UserClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AppContext {
	private static final int USER_CHANNEL_PORT = 8082;
	private static final int PRODUCT_CHANNEL_PORT = 50052;

	private AppContext() {
		// Prevent instantiation
	}
	
	private static final ManagedChannel userChannel = ManagedChannelBuilder.forAddress("localhost", USER_CHANNEL_PORT)
			.usePlaintext()
			.build();

	private static final ManagedChannel productChannel = ManagedChannelBuilder.forAddress("localhost", PRODUCT_CHANNEL_PORT)
			.usePlaintext().build();

	public static ProductClient productClient() {
		return new ProductClient(productChannel);
	}

	public static UserClient userClient() {
		return new UserClient(userChannel);
	}
}
