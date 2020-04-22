package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.repository.CustomerRepository;
import com.utils.Utils;


@Transactional
@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private Utils utils;

	@Override
	public void save(Customer customer) {
		com.repository.Customer customer2 = utils.maskCustomerDetails(customer);
		try {
			customerRepository.save(customer2);
			customerRepository.insertAuditLog(customer2.getCustomerNumber(), utils.getJsonString(customer2));
		} catch (Exception e) {
			customerRepository.insertErrorLog(e.getClass().toString(), e.getMessage(), utils.getJsonString(customer2));
		}
	}
	
}
