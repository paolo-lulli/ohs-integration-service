package com.volvo.ohs.services;

import com.volvo.ohs.protobuf.product.ProductServiceGrpc;

import io.grpc.Channel;

public class ProductClient {
	  private final ProductServiceGrpc.ProductServiceBlockingStub blockingStub;
	  
	  public ProductClient(Channel channel) {
		  blockingStub = ProductServiceGrpc.newBlockingStub(channel);
	  }

}
