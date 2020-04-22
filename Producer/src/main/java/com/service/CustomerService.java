package com.service;

import com.model.Customer;
import com.model.SuccessResponse;

public interface CustomerService {
	SuccessResponse saveCustomer(Customer customer);
}
