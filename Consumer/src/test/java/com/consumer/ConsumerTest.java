package com.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.utils.Utils;

@SpringBootTest
public class ConsumerTest {

	@Autowired
	private Utils utils;
	
	@Test
	public  void maskCustomerNumberTest() {
		String customerNumber = "C000000001";
		String maskedCustomerNumber = utils.maskData(customerNumber, customerNumber.length() - 4, true);
	assertEquals("C00000****", maskedCustomerNumber);
	}
	
	@Test
	public  void maskEmailTest() {
		String email = "maheshmanchala92@gmail.com";
		String maskedEmail = utils.maskData(email, 4, false);
		assertEquals("****shmanchala92@gmail.com", maskedEmail);
	}
	@Test
	public  void maskBirthDateTest() {
		String birthDate = "05-07-1992";
		String maskedBirthDate = utils.maskData(birthDate, 4, false);
		assertEquals("****7-1992", maskedBirthDate);
	}

}
