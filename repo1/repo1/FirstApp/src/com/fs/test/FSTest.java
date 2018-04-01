package com.fs.test;

import java.io.IOException;

import com.fs.beans.IMessageProducer;
import com.fs.beans.MessageWriter;
import com.fs.util.AppFactory;

public class FSTest {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		AppFactory appFactory = new AppFactory();
		MessageWriter writer = (MessageWriter) appFactory
				.getObject("MessageWriter.class");
		IMessageProducer messageProducer = (IMessageProducer) appFactory
				.getObject("IMessageProducer.class");
		writer.setMessageProducer(messageProducer);

		writer.writeMessage("Welcome to Spring!!!");
	}
}
