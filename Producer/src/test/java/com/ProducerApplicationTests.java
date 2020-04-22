package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Customer;
import com.model.SuccessResponse;
import com.producer.ProducerKafka;
import com.service.CustomerServiceImpl;

@SpringBootTest
class ProducerApplicationTests {
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	@Mock
	private ProducerKafka producerKafka;

	@Test
	public void CustomerServiceImplTest() {
		Customer customer = new Customer(); 
		doNothing().when(producerKafka).sendMessage(customer);
	    SuccessResponse resp = customerServiceImpl.saveCustomer(customer);
	    verify(producerKafka, times(1)).sendMessage(customer);
	    assertEquals("success", resp.getStatus());
	    assertEquals("customer details saved success", resp.getMessage());
	}
}
