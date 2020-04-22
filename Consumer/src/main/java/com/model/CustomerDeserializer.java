package com.model;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerDeserializer implements Deserializer<Customer> {

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
	}

	@Override
	public Customer deserialize(String arg0, byte[] arg1) {
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = null;
		try {
			customer = mapper.readValue(arg1, Customer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}
