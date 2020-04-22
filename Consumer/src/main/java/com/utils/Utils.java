package com.utils;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repository.Customer;

@Component
public class Utils {

	public String getJsonString(Customer customer) {
		ObjectMapper Obj = new ObjectMapper();
		try {
			return Obj.writeValueAsString(customer);
		} catch (IOException e) {
			throw new RuntimeException("Unable to parse Customer object to Json String");
		}
	}

	public Customer maskCustomerDetails(com.model.Customer customer) {
		String customerNumber = customer.getCustomerNumber();
		String customerNumberMasked = maskData(customerNumber, customerNumber.length() - 4, true);
		String email = customer.getEmail();
		String emailMasked = maskData(email, 4, false);
		String birthDate = customer.getBirthdate();
		String birthDateMasked = maskData(birthDate, 4, false);

		Customer customer2 = new Customer(customerNumberMasked, customer.getFirstName(), customer.getLastName(),
				birthDateMasked, customer.getCountry(), customer.getCountryCode(), customer.getMobileNumber(),
				emailMasked, customer.getCustomerStatus(), customer.getAddress());
		return customer2;
	}

	public String maskData(String ss, int i, boolean last) {
			if (last) {
				return ss.subSequence(0, i) + "****";
			} else {
				return "****" + ss.subSequence(i, ss.length());
			}
	}

}
