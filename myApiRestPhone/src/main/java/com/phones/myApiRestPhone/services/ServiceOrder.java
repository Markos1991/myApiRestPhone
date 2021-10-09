package com.phones.myApiRestPhone.services;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phones.myApiRestPhone.model.Order;
import com.phones.myApiRestPhone.model.Phone;
import com.phones.myApiRestPhone.model.StatusOrder;
import com.phones.myApiRestPhone.repository.OrderRepository;

@Service
public class ServiceOrder implements OrderService {
	
	@Autowired
	private OrderRepository daoOrder;

	@Override
	public Order validate(ServicePhone servicePhone, JSONObject order) {

		Order newOrder = mapNewOrderData(order);
		double price = checkAndCalcutePricePhoneOrder(servicePhone, newOrder.getPhones());
		if (price == -1 || price == 0)
			newOrder.setStatus(StatusOrder.INCORRECT);
		else {
			newOrder.setStatus(StatusOrder.VALIDATED);
			newOrder.setPrice(price);
		}
		return newOrder;
	}

	@Override
	public String addValidatedOrder(JSONObject order) {
		Order orderToAdd = mapOrderData(order);
		daoOrder.insert(orderToAdd);
		return orderToAdd.showOrder();
	}
	
	
	
	
	
	// Private methods
	
	private double checkAndCalcutePricePhoneOrder(ServicePhone servicePhone, List<Phone> phones) {
		double price = 0;
		for (Phone oPhone:phones) {
			if (!servicePhone.findById(oPhone.getRef()))
				return -1;
			price += oPhone.getPrice();
		}
		return price;
	}
	
    private Order mapNewOrderData(JSONObject jsdonOrder) {
    	Order rOrder = new Order();
    	rOrder.setCurrentUser(jsdonOrder.getJSONObject("currentUser"));
    	rOrder.setPhones(jsdonOrder.getJSONArray("phones"));
    	rOrder.setStatus(StatusOrder.CREATING);
    	return rOrder;
    }
    
    private Order mapOrderData(JSONObject jsdonOrder) {
    	Order rOrder = new Order();
    	//rOrder.setOrderId(jsdonOrder.getString("ref"));
    	rOrder.setCurrentUser(jsdonOrder.getJSONObject("currentUser"));
    	rOrder.setPhones(jsdonOrder.getJSONArray("phones"));
    	rOrder.setStatus(StatusOrder.statusOrderFromString(jsdonOrder.getString("status")));
    	rOrder.setPrice(jsdonOrder.getDouble("price"));
    	return rOrder;
    }

}
