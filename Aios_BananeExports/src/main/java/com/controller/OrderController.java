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

import com.dao.OrderDAO;
import com.exception.InvalidBananaQuantityException;
import com.exception.InvalidDateException;
import com.model.Order;

@RestController
@RequestMapping("/bananas")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderDAO orderDAO;

	@GetMapping({ "/orders" })
	public List<Order> getAll() {
		LOGGER.info("START - getAll()");
		return orderDAO.getAll();
	}

	@GetMapping({ "/orders/{id}" })
	public List<Order> getByCustomer(@PathVariable(value = "id") String id) {
		LOGGER.info("START - getByCustomer()");
		return orderDAO.getOrderByCustomer(id);
	}

	@PostMapping({ "/orders" })
	public Order createOrder(@RequestBody Order order) {
		LOGGER.info("START - createOrder() = " + order.toString());
		try {
			return orderDAO.createOrder(order);
		} catch (InvalidDateException e) {
			LOGGER.error(
					"La date de livraison doit être, au minimum, une semaine dans le futur par rapport à la date du jour.");
			e.printStackTrace();
		} catch (InvalidBananaQuantityException e) {
			LOGGER.error("La quantité de bananes demandé doit être compris entre 0 et 10 000 ou un multiple de 25");
			e.printStackTrace();
		}
		return order;
	}

	@PutMapping({ "/orders/{id}" })
	public Order updateOrder(@PathVariable(value = "id") String id, @Valid @RequestBody Order order)
			throws InvalidDateException, InvalidBananaQuantityException {
		LOGGER.info("START - updateOrder() = " + order.toString());
		return orderDAO.updateOrder(order);
	}

	@DeleteMapping({ "/orders/{id}" })
	public boolean deleteOrder(@RequestBody Order order) {
		LOGGER.info("START - deleteOrder() = " + order.toString());
		return orderDAO.removeOrder(order);
	}
}
