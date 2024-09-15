package com.projeto.farmacia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.farmacia.entity.Customer;

public interface CustomerDAO extends MongoRepository<Customer, String> {
}
