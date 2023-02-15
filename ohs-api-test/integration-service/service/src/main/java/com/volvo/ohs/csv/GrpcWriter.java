package com.volvo.ohs.csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.batch.item.ItemWriter;

import com.volvo.ohs.AppContext;
import com.volvo.ohs.Configuration;
import com.volvo.ohs.dto.AddressDto;
import com.volvo.ohs.dto.ProductDto;
import com.volvo.ohs.dto.UserDto;
import com.volvo.ohs.helper.Json;
import com.volvo.ohs.helper.Output;
import com.volvo.ohs.proxy.ProductProxy;
import com.volvo.ohs.proxy.UserProxy;

public class GrpcWriter <T> implements ItemWriter<T> { 
	
	public static final ProductProxy productProxy = AppContext.productGrpcProxy();
	public static final UserProxy userProxy = AppContext.userGrpcProxy();
	

    @Override
    public void write(List<? extends T> items) throws Exception { 
    	var objectsList = new ArrayList<>(items.size());
        for (T item : items) { 
        	processItems(objectsList, item);
        } 
        //
        var jsonArray = new JSONArray(objectsList);
        new Output(jsonArray).toFile(Configuration.PROCESSED_ORDER_JSON_FILE);
    }


	private void processItems(ArrayList<Object> objectsList, T item) {
		var row = (SingleRowDto) item;
		var supplierPid = row.getSupplierPid();
		var orderId = row.getOrderId();
		
		if (null == supplierPid || supplierPid.isEmpty()) {
			throw new IllegalStateException("empty supplierPid");
		}
		if (null == orderId || orderId.isEmpty()) {
			throw new IllegalStateException("empty orderId");
		}

		var user = loadUser(row);
		var product = loadProduct(row);
		
		if ((null == user) || (null == product)) {
			throw new IllegalStateException("Could not map row to Dto");
		} else {
			var userPid = userProxy.createUser(user);
			var productPid = productProxy.createProduct(product);
			
			if (userPid.isEmpty() || productPid.isEmpty()) {
				throw new IllegalStateException("Error calling gRPC services");
			}
			
			var jsonObject = Json.fromIds(userPid.get(), orderId, supplierPid);  
			objectsList.add(jsonObject);
		}

	}


	private ProductDto loadProduct(SingleRowDto row) {
		return ProductDto.builder()
				.withName("Name Unknown")
				.withPid(row.getProductPid())
				.build();
	}

	private UserDto loadUser(SingleRowDto row) {
		return UserDto.builder()
		.withFullName(row.getFullName())
		.withEmail(row.getEmail())
		.withAddresses(Arrays.asList(new AddressDto(row.getCountry(), row.getShippingAddress())))
		.build();
	}
}


