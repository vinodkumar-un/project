package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	private String generateStr(int endIndex) {
		return UUID.randomUUID().toString().replace("-", "")
				.substring(0, endIndex);
	}

	public String generatePwd() {
		return generateStr(6);
	}

	public String generateToken() {
		return generateStr(8);
	}

}
