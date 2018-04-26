package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil<T> {

	public Object convertJsonToObj(String json, Class<T> cls) {
		Object obj = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			obj = mapper.readValue(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String convertObjectToJson(Object obj) {

		String json = null;

		try {
			ObjectMapper objmapper = new ObjectMapper();
			json = objmapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
