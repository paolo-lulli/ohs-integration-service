package com.volvo.ohs.proxy;

import java.util.Optional;

import com.google.protobuf.StringValue;
import com.volvo.ohs.dto.ProductDto;
import com.volvo.ohs.protobuf.product.CreateProductRequest;
import com.volvo.ohs.protobuf.product.ProductResponse;
import com.volvo.ohs.protobuf.product.ProductServiceGrpc;

import io.grpc.Channel;

public class ProductProxy {
	  private final ProductServiceGrpc.ProductServiceBlockingStub blockingStub;
	  
	  public ProductProxy(Channel channel) {
		  blockingStub = ProductServiceGrpc.newBlockingStub(channel);
	  }
	  
	  public Optional<String> createProduct(ProductDto dto) {
		  CreateProductRequest productRequest = CreateProductRequest.newBuilder()
		  .setName("Not Mapped")
		  .setPid( StringValue.newBuilder().setValue(dto.getPid()).build())
		  .build();
		  
		  ProductResponse product = blockingStub.createProduct(productRequest);
		  
		  return (null != product) ? Optional.of(product.getPid()) : Optional.empty();
	  }
}
