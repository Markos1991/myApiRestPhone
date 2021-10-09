package com.phones.myApiRestPhone.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phones.myApiRestPhone.model.Order;
import com.phones.myApiRestPhone.model.Phone;
import com.phones.myApiRestPhone.services.ServiceOrder;
import com.phones.myApiRestPhone.services.ServicePhone;


@RestController
@RequestMapping("/api") 
public class PhoneRestController {
	
	// Attributes
	
	@Autowired
	private ServicePhone servicePhone;
	
	@Autowired
	private ServiceOrder serviceOrder;
	
	
	// Methods 
	
    @GetMapping(value="/phonesCatalog")
    public List<Phone> catalog(){
        return servicePhone.catalog();
    }

    @PostMapping(value="/validateOrder")
    public Order validateOrder(@RequestBody String order){
    	JSONObject jsdonOrder = new JSONObject(order);
        return serviceOrder.validate(servicePhone, jsdonOrder);
    }
    
    @PostMapping(value="/addOrder")
    public String addOrder(@RequestBody JSONObject order){
    	JSONObject jsdonOrder = new JSONObject(order);
        String info = serviceOrder.addValidatedOrder(jsdonOrder);
    	System.out.println(info);
        return info;
    }
    
    

}
