package com.kroger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfigClient {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.kroger.wsdl");
		return marshaller;
	}
	@Bean
	public CustomerClient customerClient(Jaxb2Marshaller marshaller) {
		CustomerClient client = new CustomerClient();
		client.setDefaultUri("http://localhost:9098/soapws/customers.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
