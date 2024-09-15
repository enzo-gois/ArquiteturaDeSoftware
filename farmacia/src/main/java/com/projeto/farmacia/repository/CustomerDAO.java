package com.projeto.farmacia.repository;

import com.projeto.farmacia.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, String> {
}
