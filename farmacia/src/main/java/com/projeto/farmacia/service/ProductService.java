package com.projeto.farmacia.service;

import com.projeto.farmacia.entity.Product;
import com.projeto.farmacia.repository.ProductDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Transactional
    public Product update(Product product) {
        Product prod = this.productDAO.findById(product.getId()).get();

        prod.setId(product.getId());
        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());

        return prod;
    }

    public void remove(String id) {this.productDAO.deleteById(id);}

    public List<Product> findByName(String name) {
        return this.productDAO.findByNameContainingIgnoreCase(name);
    }

}
