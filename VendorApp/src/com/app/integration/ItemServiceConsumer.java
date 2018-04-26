package com.app.integration;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ItemServiceConsumer {

	public static void main(String[] args) {
		String url = "http://localhost:8080/VendorApp/rest/itemService/saveItem";
		Client client = Client.create();
		WebResource resource = client.resource(url);
		ClientResponse responce = resource.get(ClientResponse.class);
		String msg = responce.getEntity(String.class);
		System.out.println(msg);
	}

}
