package com.dao;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.exception.InvalidBananaQuantityException;
import com.exception.InvalidDateException;
import com.model.Order;

/*
 * delivery date > 1 semaine à partir de now
 * bananaQuantity > 0 et < 10000 et %25
 * price = 25 euros/kg
 */
@Service
public class OrderDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class);

	private static Map<String, Order> orders = new HashMap<>();

	static {
		initOrders();
	}

	private static void initOrders() {
		orders.put("1", new Order("1", CustomerDAO.customers.get("1"), new Date(), 12));
		orders.put("2", new Order("12", CustomerDAO.customers.get("1"), new Date(), 12));
		orders.put("3", new Order("45", CustomerDAO.customers.get("3"), new Date(), 12));
		orders.put("4", new Order("99", CustomerDAO.customers.get("4"), new Date(), 12));
		orders.put("5", new Order("67", CustomerDAO.customers.get("5"), new Date(), 12));

	}

	public List<Order> getOrderByCustomer(String id) {
		List<Order> orders = new ArrayList<>();
		OrderDAO.orders.forEach((k, v) -> {
			if (id.equals(v.getCustomer().getId())) {
				orders.add(v);
			}
		});
		return orders;
	}

	public Order createOrder(Order order) throws InvalidDateException, InvalidBananaQuantityException {
		LOGGER.info("START - createOrder()");
		if (!isCorrectDate(order.getDeliveryDate())) {
			throw new InvalidDateException();
		}
		if (order.getBananaQuantity() < 0 || order.getBananaQuantity() > 10000) {
			throw new InvalidBananaQuantityException();
		}
		if (order.getBananaQuantity() % 25 != 0) {
			throw new InvalidBananaQuantityException();
		}
		order.setPrice(order.getBananaQuantity() * 2.5);
		return orders.put(order.getId(), order);
	}

	public Order updateOrder(Order order) {
		LOGGER.info("START - updateOrder()");
		return orders.put(order.getId(), order);
	}

	public boolean removeOrder(Order order) {
		LOGGER.info("START - removeOrder()");
		return orders.remove(order.getId(), order);
	}

	public List<Order> getAll() {
		LOGGER.info("START - getAll()");
		Collection<Order> ordersColl = orders.values();
		List<Order> orderList = new ArrayList<>();
		orderList.addAll(ordersColl);
		return orderList;
	}

	@SuppressWarnings("deprecation")
	private boolean isCorrectDate(Date deliveryDate) {
		LOGGER.info("START - isCorrectDate()");
		Date now = new Date();
		LocalDate nowLocalDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDay());
		int nowWeekOfYear = nowLocalDate.get(WeekFields.of(Locale.FRANCE).weekOfYear());

		LocalDate deliveryLocalDate = LocalDate.of(deliveryDate.getYear(), deliveryDate.getMonth(),
				deliveryDate.getDay());
		int deliveryWeekOfYear = deliveryLocalDate.get(WeekFields.of(Locale.FRANCE).weekOfYear());

		return nowWeekOfYear < deliveryWeekOfYear;
	}
}
