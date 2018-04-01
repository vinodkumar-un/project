package com.fs.util;

import com.fs.beans.HTMLMessageProducerImpl;
import com.fs.beans.IMessageProducer;
import com.fs.beans.PDFMessageProducerImpl;

public class MessageProducerFactory {
	public static IMessageProducer createMessageProducer(String type) {
		IMessageProducer messageProducer = null;

		if (type.equals("html")) {
			messageProducer = new HTMLMessageProducerImpl();
		} else if (type.equals("pdf")) {
			messageProducer = new PDFMessageProducerImpl();
		}

		return messageProducer;
	}
}
