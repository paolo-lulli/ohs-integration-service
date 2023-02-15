package com.volvo.ohs.grpc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.volvo.ohs.protobuf.product.ProductServiceGrpc;

import io.grpc.Channel;

public class ProductClient {
	  private final ProductServiceGrpc.ProductServiceBlockingStub blockingStub;
	  
	  public ProductClient(Channel channel) {
		  blockingStub = ProductServiceGrpc.newBlockingStub(channel);
	  }

}
