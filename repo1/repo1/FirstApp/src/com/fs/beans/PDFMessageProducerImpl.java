package com.fs.beans;

public class PDFMessageProducerImpl implements IMessageProducer {

	@Override
	public String convert(String message) {
		return "<pdf>" + message + "</pdf>";
	}

}
