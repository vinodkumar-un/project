package com.fs.beans;


public class MessageWriter {
	private IMessageProducer messageProducer;

	public void writeMessage(String message) {
		String cmsg = null;

		cmsg = messageProducer.convert(message);
		System.out.println(cmsg);
	}
	
	public void setMessageProducer(IMessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}
}







