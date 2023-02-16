package com.volvo.ohs.csv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

public class ProcessedOrdersCache {
	public static final ProcessedOrdersCache INSTANCE = new ProcessedOrdersCache();
	private final List<JSONObject> objectList =  Collections.synchronizedList(new ArrayList<>());

	private ProcessedOrdersCache() {
		//
	}
	
	public void add(JSONObject object) {
		objectList.add(object);
	}

	public List<JSONObject> getProcessedOrders() {
		return objectList;
	}
	
	public void clear() {
		objectList.clear();
	}
	
}
