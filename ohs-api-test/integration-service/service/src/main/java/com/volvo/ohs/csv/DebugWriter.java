package com.volvo.ohs.csv;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
 
public class DebugWriter<T> implements ItemWriter<T> { 
    @Override
    public void write(List<? extends T> items) throws Exception { 
        for (T item : items) { 
            System.out.println(item); 
        } 
    }
}