package com.phones.myApiRestPhone.services;

import java.util.List;

import com.phones.myApiRestPhone.model.Phone;

public interface PhoneService {

	public List<Phone> catalog();
	
	public  boolean findById(String ref);

}
