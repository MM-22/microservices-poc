package com.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.model.SuccessResponse;
import com.producer.ProducerKafka;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private ProducerKafka producerKafka;

	@Override
	public SuccessResponse saveCustomer(Customer customer) {
		LOG.info("save customer service started");
		producerKafka.sendMessage(customer);
		LOG.info("save customer service completed");
		return new SuccessResponse("success","customer details saved success");
	}
}