package com.projeto.farmacia.controllers;

import com.projeto.farmacia.entity.Product;
import com.projeto.farmacia.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Cacheable
    public List<Product> getAllProducts() {
        return this.productService.list();
    }

    @PostMapping
    public void saveProduct(@Valid @RequestBody Product product) {
        this.productService.create(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        product.setId(id);
        return this.productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        this.productService.remove(id);
    }

    @GetMapping("/filter")
    public List<Product> filterProductsByName(@RequestParam String name) {
        return this.productService.findByName(name);
    }

}
