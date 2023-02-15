package com.volvo.ohs.csv;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.volvo.ohs.grpc.dto.AddressDto;
import com.volvo.ohs.grpc.dto.ProductDto;
import com.volvo.ohs.grpc.dto.UserDto;

//1 reads a csv 
//2 parses the information into user and product object
//3 for user objects, use the user service to save the data
//4 for product objects, use the product service to save the data
//5 for every row processed, write out the following values ( userPid , orderPid and supplierPid ) from the row to a new file called:  processed-orders.json

/*
Infos from CSV:
id,first_name,last_name,email,
supplier_pid,credit_card_number,credit_card_type,
order_id,
product_pid,
shipping_address,
country,
date_created,quantity,
full_name,order_status

*/
public class GrpcEntitiesWriter <T> implements ItemWriter<T> { 
    @Override
    public void write(List<? extends T> items) throws Exception { 
        for (T item : items) { 
        	var row = (SingleRowDto) item;
            UserDto user = UserDto.builder()
            .withFullName(row.getFullName())
            .withEmail(row.getEmail())
            .withAddresses(Arrays.asList(new AddressDto(row.getCountry(), row.getShippingAddress())))
            .build();
            
            var product = ProductDto.builder()
            		.withName("Name Unknown")
            		.withPid(row.getProductPid())
            		.build();
            
            if ((null == user) || (null == product)) {
            	System.out.println("Serialization error"); 
            } else {
            	System.out.println(user);
            }
        } 
    }
}


