package com.volvo.ohs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.volvo.ohs.helper.Json;
import com.volvo.ohs.helper.Output;

public class OutputTest {
	
	@Test
	public void jsonFile() throws IOException {
		String filename = System.getProperty("java.io.tmpdir") + "/" + UUID.randomUUID().toString();
		JSONObject json = Json.fromIds("1", "2", "3");
		var jsonString = json.toString();
		new Output(json).toFile(filename);
		File file = new File(filename);
		String written = Files.readString(file.toPath());
		
		assert written.equals(jsonString);
	}
}
