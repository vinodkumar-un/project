package com.fs.beans;

public class HTMLMessageProducerImpl implements IMessageProducer {

	@Override
	public String convert(String message) {
		String s = " with body. ";
		return  "<html><body>" + message + "</body></html>";
	}

}
