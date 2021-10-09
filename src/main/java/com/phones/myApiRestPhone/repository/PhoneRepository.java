package com.phones.myApiRestPhone.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.phones.myApiRestPhone.model.Phone;

public interface PhoneRepository extends MongoRepository<Phone, String>{
	
}
