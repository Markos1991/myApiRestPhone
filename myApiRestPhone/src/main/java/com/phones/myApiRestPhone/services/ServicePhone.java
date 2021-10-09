package com.phones.myApiRestPhone.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phones.myApiRestPhone.model.Phone;
import com.phones.myApiRestPhone.repository.PhoneRepository;

@Service
public class ServicePhone implements PhoneService {

	// Attributes
	@Autowired
	private PhoneRepository daoPhone;
	
	
	// Methods
	
	@Override
	public List<Phone> catalog() {
		return daoPhone.findAll();
	}


	public boolean findById(String ref) {
		return daoPhone.existsById(ref);
	}
	
	

}
