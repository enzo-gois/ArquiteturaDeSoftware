package com.projeto.farmacia.repository;

import com.projeto.farmacia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, String> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
