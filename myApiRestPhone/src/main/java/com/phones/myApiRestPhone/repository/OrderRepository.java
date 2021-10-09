package com.phones.myApiRestPhone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.phones.myApiRestPhone.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
