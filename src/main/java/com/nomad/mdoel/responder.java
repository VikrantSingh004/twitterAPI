package com.nomad.mdoel;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class responder {
	public static  String objToJson(User user) throws JsonProcessingException {
		StringBuffer sb = new StringBuffer();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString( user );
		return json;
	}
}
