package com.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.SuccessResponse;
import com.service.CustomerService;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {
	
	private final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public SuccessResponse saveCustomer(@Valid @RequestBody Customer customer) {
		LOG.info("save customer controller started");
		SuccessResponse successResponse =  customerService.saveCustomer(customer);
		LOG.info("save customer controller started");
		return successResponse;
	}

}
