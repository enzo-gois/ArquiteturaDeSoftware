package com.projeto.farmacia.controllers;

import com.projeto.farmacia.entity.Customer;
import com.projeto.farmacia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return this.customerService.list();
    }

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) {
        this.customerService.create(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        customer.setId(id);
        return this.customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        this.customerService.remove(id);
    }
}
