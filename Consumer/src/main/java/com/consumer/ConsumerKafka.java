package com.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.model.Customer;
import com.service.ConsumerService;

@Component
public class ConsumerKafka {

	@Autowired
	private ConsumerService consumerService;

	@KafkaListener(topics = { "${kafka.topic}" }) 
	public void onMessage(ConsumerRecord<String, Customer> customer) {
		consumerService.save(customer.value());
	}
}