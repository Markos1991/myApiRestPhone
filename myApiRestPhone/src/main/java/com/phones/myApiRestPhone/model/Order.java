package com.phones.myApiRestPhone.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
	
	// Attributes
	
	// Primary key
	@Id
	private String orderId;

	private User currentUser;
	
	private List<Phone> phones;
	
	private double price;
	
	private StatusOrder status;
	
	// Builders
	
	public Order() {
		//this.orderId = "";
		this.price = 0;
		this.currentUser = new User();
		this.phones = new ArrayList<Phone>();
		this.status = StatusOrder.CREATING;
	}
	
	public Order(String orderId, User currentUser, List<Phone> phones, double price, StatusOrder status) {
		this.orderId = orderId;
		this.currentUser = currentUser;
		this.phones = phones;
		this.price = price;
		this.status = status;
	}
	
	// Getters & Setters methods
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public void setCurrentUser(JSONObject currentUser) {
		User newCurrentUser = new User();
		newCurrentUser.setEmail(currentUser.getString("email"));
		newCurrentUser.setFirstName(currentUser.getString("firstName"));
		newCurrentUser.setLastName(currentUser.getString("lastName"));
		this.currentUser = newCurrentUser;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public void setPhones(JSONArray phones) {
		List<Phone> orderPhones = new ArrayList<Phone>();
		JSONObject jsonPhone;
		for(int i = 0; i < phones.length(); i++) {
			jsonPhone = phones.getJSONObject(i);
			orderPhones.add(new Phone(jsonPhone.getString("ref"), jsonPhone.getString("name"), 
					jsonPhone.getString("image"), jsonPhone.getDouble("price"), jsonPhone.getString("des")));
		}
		this.phones = orderPhones;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public StatusOrder getStatus() {
		return status;
	}

	public void setStatus(StatusOrder status) {
		this.status = status;
	}
	
	public String showOrder() {
		String infoPhones = "";
		for (Phone o:this.phones)
			infoPhones += "\t \t - " + o.overviewPhone() + "\t \t" + o.getPrice() + "€ \n";
		
		String info = "ORDER INFORMATION \n" 
				+ "\t Order number: " + this.orderId + "\n" 
				+ "\t User information: \n" + this.currentUser.toString()
				+ "\t Shopping cart: \n" + infoPhones 
				+ "\t Total amount: " + this.price + "€ \n";
		return info;
	}
	
	
}
