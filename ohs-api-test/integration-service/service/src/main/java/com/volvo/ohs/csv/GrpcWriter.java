package com.volvo.ohs.csv;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.volvo.ohs.Configuration;
import com.volvo.ohs.helper.Output;

public class GrpcWriter <T> implements ItemWriter<T> { 
	private static final ProcessedOrdersCache ORDERS_CACHE = ProcessedOrdersCache.INSTANCE;
	
    @Override
    public void write(List<? extends T> items) throws Exception {
        
    	items.stream().forEach(new RowConsumer<>());
        
        saveToFileAndEmptyCache();
    }

	private void saveToFileAndEmptyCache() {
        new Output(ORDERS_CACHE.getProcessedOrders()).toFile(Configuration.PROCESSED_ORDER_JSON_FILE);
        ORDERS_CACHE.clear();
	}
}


