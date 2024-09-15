package com.projeto.farmacia.repository;

import com.projeto.farmacia.entity.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaleDAO extends MongoRepository<Sale, String> {
}
