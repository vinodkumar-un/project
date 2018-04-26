package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CodecUtil {

	/*
	 * this method is converting readable into unreadable
	 */
	public String doEncode(String normalString) {
		byte[] barr = Base64.encodeBase64(normalString.getBytes());
		return new String(barr);
	}

	/*
	 * this method is converting unreadable(encoding) into readable(decoding)
	 * format
	 */
	public String doDecode(String encodeString) {
		byte[] ebarr = Base64.decodeBase64(encodeString.getBytes());
		return new String(ebarr);
	}

}
