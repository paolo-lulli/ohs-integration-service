package com.volvo.ohs.helper;

import java.util.HashMap;
import java.util.Optional;

import org.json.JSONObject;

public class Json {
	private Json() {
		//
	}

	public static JSONObject fromIds(String userPid, String orderId, String supplierPid) {
		var map = new HashMap<String, String>();
		map.put("userPid", userPid);
		map.put("orderPid", orderId);
		map.put("supplierPid", supplierPid);

		return new JSONObject(map);
	}
}
