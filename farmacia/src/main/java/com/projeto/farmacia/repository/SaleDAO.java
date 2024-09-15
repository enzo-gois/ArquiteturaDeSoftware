package com.projeto.farmacia.repository;

import com.projeto.farmacia.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDAO extends JpaRepository<Sale, String> {
}
