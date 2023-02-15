package com.volvo.ohs.csv;

import java.util.Arrays;
import java.util.UUID;
import java.util.function.Consumer;

import com.volvo.ohs.AppContext;
import com.volvo.ohs.dto.AddressDto;
import com.volvo.ohs.dto.ProductDto;
import com.volvo.ohs.dto.UserDto;
import com.volvo.ohs.helper.Json;
import com.volvo.ohs.proxy.ProductProxy;
import com.volvo.ohs.proxy.UserProxy;

public class RowConsumer <T> implements Consumer<T> {
	private static final ProductProxy PRODUCT_PROXY = AppContext.productGrpcProxy();
	private static final UserProxy USER_PROXY = AppContext.userGrpcProxy();
	private final ProcessedOrdersCache ORDERS_CACHE = ProcessedOrdersCache.INSTANCE;

	@Override
	public void accept(T singleRowDto) {
		var row = (SingleRowDto)singleRowDto;
		var supplierPid = row.getSupplierPid();
		var orderId = row.getOrderId();

		if (null == supplierPid || supplierPid.isEmpty()) {
			//empty supplierPid
			return;
		}
		if (null == orderId || orderId.isEmpty()) {
			//empty orderId
			return;
		}

		var user = loadUser(row);
		var product = loadProduct(row);

		if ((null == user) || (null == product)) {
			// user or product is null
			return;
		} else {
			var userPid = USER_PROXY.createUser(user);
			var productPid = PRODUCT_PROXY.createProduct(product);

			if (userPid.isEmpty() || productPid.isEmpty()) {
				throw new IllegalStateException("Error calling gRPC services");
			}

			ORDERS_CACHE.add(Json.fromIds(userPid.get(), orderId, supplierPid));
		}

	}

	private ProductDto loadProduct(SingleRowDto row) {
		String randomName = "Random name" + UUID.randomUUID().toString();
		return ProductDto.builder().withName(randomName).withPid(row.getProductPid()).build();
	}

	private UserDto loadUser(SingleRowDto row) {
		return UserDto.builder().withFullName(row.getFullName()).withEmail(row.getEmail())
				.withAddresses(Arrays.asList(new AddressDto(row.getCountry(), row.getShippingAddress()))).build();
	}
}
