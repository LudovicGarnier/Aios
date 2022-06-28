package com.model;

import java.util.Date;

/*
 * delivery date > 1 semaine à partir de now
 * bananaQuantity > 0 et < 10000 et %25
 * price = 25 euros/kg
 */
public class Order {

	private String id;
	private Customer customer;
	private Date deliveryDate;
	private int bananaQuantity;
	private double price;

	public Order() {
	}

	public Order(String id, Customer customer, Date deliveryDate, int bananaQuantity) {
		super();
		this.id = id;
		this.customer = customer;
		this.deliveryDate = deliveryDate;
		this.bananaQuantity = bananaQuantity;
		this.price = bananaQuantity * 2.5;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getBananaQuantity() {
		return bananaQuantity;
	}

	public void setBananaQuantity(int bananaQuantity) {
		this.bananaQuantity = bananaQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" |ORDER = ");
		sb.append(" ID = " + this.id);
		sb.append(" CUSTOMER = " + this.customer.toString());
		sb.append(" DELIVERY DATE = " + this.deliveryDate);
		sb.append(" QUANTITY = " + this.bananaQuantity);
		sb.append(" PRICE = " + this.price);
		sb.append(" | ");
		return sb.toString();
	}
}
