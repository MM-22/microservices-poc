package com.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.model.Customer;

@Component
public class ProducerKafka {
	
	private final Logger LOG = LoggerFactory.getLogger(ProducerKafka.class);

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;

	@Autowired
	Environment env;

	public void sendMessage(Customer customer) {
		
		LOG.info("sendMessage method started");
		
		ListenableFuture<SendResult<String, Customer>> future = kafkaTemplate.send(env.getProperty("kafka.topic"),
				"customer", customer);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Customer>>() {

			@Override
			public void onFailure(Throwable ex) {
				LOG.info("onFailure method started");
			}

			@Override
			public void onSuccess(SendResult<String, Customer> result) {
				LOG.info("onSuccess method started");
			}
		});
		LOG.info("sendMessage method completed");
	}
}
