package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.model.Customer;

@Service
public class CustomerDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAO.class);

	public static Map<String, Customer> customers = new HashMap<>();

	static {
		initCustomers();
	}

	public Customer getCustomerById(String id) {
		return customers.get(id);
	}

	private static void initCustomers() {
		customers.put("1", new Customer("1", "John", "15 abbey road", "123456", "London", "England"));
		customers.put("2", new Customer("2", "Prince", "25 Studio avenue", "MI454", "Mineapolis", "USA"));
		customers.put("3", new Customer("3", "Wolfgang", "65 Opern Strasse", "45671", "Salzburg", "Ostereich"));
		customers.put("4", new Customer("4", "Michael", "18 beat street", "45455", "Neverland", "USA"));
		customers.put("5", new Customer("5", "Bruno", "45 stadium street", "78964", "San Diego", "USA"));

	}

	public Customer createCustomer(Customer customer) {
		LOGGER.info("START - createCustomer()");
		return customers.put(customer.getId(), customer);
	}

	public Customer updateCustomer(Customer customer) {
		LOGGER.info("START - updateCustomer()");
		return customers.put(customer.getId(), customer);
	}

	public Customer removeCustomer(Customer customer) {
		LOGGER.info("START - removeCustomer()");
		return customers.remove(customer.getId());
	}

	public List<Customer> getAll() {
		LOGGER.info("START - getAll()");
		Collection<Customer> customerColl = customers.values();
		List<Customer> customerList = new ArrayList<>();
		customerList.addAll(customerColl);
		return customerList;
	}
}
