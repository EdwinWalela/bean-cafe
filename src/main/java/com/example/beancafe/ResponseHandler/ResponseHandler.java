package com.example.beancafe.ResponseHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("data", responseObj);
		map.put("message", message);
		return new ResponseEntity<Object>(map,status);
	}
}
