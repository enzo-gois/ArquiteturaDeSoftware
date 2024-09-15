package com.projeto.farmacia.repository;

import com.projeto.farmacia.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductDAO extends MongoRepository<Product, String> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
