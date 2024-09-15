package com.projeto.farmacia.service;

import com.projeto.farmacia.entity.Customer;
import com.projeto.farmacia.repository.CustomerDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> list() {
        return this.customerDAO.findAll();
    }

    public void create(Customer customer) {
        this.customerDAO.save(customer);
    }

    @Transactional
    public Customer update(Customer customer) {
        Customer cust = this.customerDAO.findById(customer.getId()).get();

        cust.setId(customer.getId());
        cust.setName(customer.getName());
        cust.setPhone(customer.getPhone());
        cust.setAddress(customer.getAddress());
        cust.setEmail(customer.getEmail());

        return cust;
    }

    public void remove(String id) {this.customerDAO.deleteById(id);}

}
