package com.phones.myApiRestPhone.services;


import org.json.JSONObject;

import com.phones.myApiRestPhone.model.Order;

public interface OrderService {
	
	public Order validate(ServicePhone servicePhone, JSONObject order);
	
	public String addValidatedOrder(JSONObject order);

}
