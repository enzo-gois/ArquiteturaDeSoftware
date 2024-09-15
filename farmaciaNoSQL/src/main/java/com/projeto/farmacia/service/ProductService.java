package com.projeto.farmacia.service;

import com.projeto.farmacia.entity.Product;
import com.projeto.farmacia.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> list() {
        return this.productDAO.findAll();
    }

    public void create(Product product) {
        this.productDAO.save(product);
    }

    public Product update(Product product) {
        Optional<Product> optionalProd = this.productDAO.findById(product.getId());

        if (optionalProd.isPresent()) {
            Product prod = optionalProd.get();
            prod.setId(product.getId());
            prod.setName(product.getName());
            prod.setDescription(product.getDescription());
            prod.setPrice(product.getPrice());
            return prod;
        }

        return null;
    }

    public void remove(String id) {
        this.productDAO.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return this.productDAO.findByNameContainingIgnoreCase(name);
    }
}
