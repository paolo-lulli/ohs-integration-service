package com.volvo.ohs.csv;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

//1 reads a csv 
//2 parses the information into user and product object
//3 for user objects, use the user service to save the data
//4 for product objects, use the product service to save the data
//5 for every row processed, write out the following values ( userPid , orderPid and supplierPid ) from the row to a new file called:  processed-orders.json

public class GrpcEntitiesWriter <T> implements ItemWriter<T> { 
    @Override
    public void write(List<? extends T> items) throws Exception { 
        for (T item : items) { 
            System.out.println(item); 
        } 
    }
}


