package com.volvo.ohs;

import com.volvo.ohs.proxy.ProductProxy;
import com.volvo.ohs.proxy.UserProxy;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AppContext {

	private AppContext() {
		//Prevent instantiation
	}
	
	private static final ManagedChannel userChannel = 
			ManagedChannelBuilder.forAddress("localhost", Configuration.USER_CHANNEL_PORT)
			.usePlaintext()
			.build();

	private static final ManagedChannel productChannel = 
			ManagedChannelBuilder.forAddress("localhost", Configuration.PRODUCT_CHANNEL_PORT)
			.usePlaintext().build();

	public static ProductProxy productGrpcProxy() {
		return new ProductProxy(productChannel);
	}

	public static UserProxy userGrpcProxy() {
		return new UserProxy(userChannel);
	}
}
