package com.model;

public class Customer {

	private String id;
	private String name;
	private String address;
	private String zipCode;
	private String city;
	private String country;

	public Customer() {
	}

	public Customer(String id, String name, String address, String zipCode, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" |Customer = ");
		sb.append(" ID = " + this.id);
		sb.append(" NAME = " + this.name);
		sb.append(" ADDRESS = " + this.address);
		sb.append(" ZIPCODE = " + this.zipCode);
		sb.append(" CITY = " + this.city);
		sb.append(" COUNTRY = " + this.country);
		sb.append(" | ");
		return sb.toString();
	}

}
