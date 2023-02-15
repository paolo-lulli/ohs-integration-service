package com.volvo.ohs.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Output {
	private Object object;
	
	public Output(Object o) {
		this.object = o;
	}
	
	public boolean toFile(String fileName) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){
			out.write(object.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
