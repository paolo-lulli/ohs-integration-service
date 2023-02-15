package com.volvo.ohs;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
 
@SpringBootApplication
public class IntegrationServiceApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(IntegrationServiceApplication.class, args);
        //OrderServiceS
        //com.volvo.
        //com.volvo.ohs.services.SomeService
        
        //Order.CreateOrderRequest
        
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
        
        //1 reads a csv 
        //2 parses the information into user and product object
        //3 for user objects, use the user service to save the data
        //4 for product objects, use the product service to save the data
        //5 for every row processed, write out the following values ( userPid , orderPid and supplierPid ) from the row to a new file called:  processed-orders.json
        
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8082)
                .usePlaintext()
                .build();
        
       // PRODUCT: 50052
        /*
        CreateUserRequest userRequest = User.CreateUserRequest.newBuilder()
        .setEmail("")
        .setAddress(ShippingAddress.newBuilder().setCountry(StringValue.newBuilder().setValue("")).build())
        .setFullName(StringValue.newBuilder().setValue(""))
        .build();
        */
        
        //UserServiceBlockingStub
        
        
    }
}
