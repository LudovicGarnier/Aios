package com.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDAO;
import com.model.Customer;

@RestController
@RequestMapping("/bananas")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerDAO customerDAO;

	@GetMapping({ "/customers" })
	public List<Customer> getAll() {
		LOGGER.info("START - getAll()");
		return customerDAO.getAll();
	}

	@PostMapping({ "/customers" })
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		LOGGER.info("START - createCustomer()");
		return customerDAO.createCustomer(customer);
	}

	@PutMapping({ "/customers/{id}" })
	public Customer updateCustomer(@PathVariable(value = "id") String id, @Valid @RequestBody Customer customer) {
		LOGGER.info("START - updateCustomer()");
		return customerDAO.updateCustomer(customer);
	}

	@DeleteMapping({ "/customers/{id}" })
	public Customer deleteCustomer(@RequestBody Customer customer) {
		LOGGER.info("START - deleteCustomer()");
		return customerDAO.removeCustomer(customer);
	}
}
