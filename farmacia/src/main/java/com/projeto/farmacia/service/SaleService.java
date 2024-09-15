package com.projeto.farmacia.service;

import com.projeto.farmacia.entity.Customer;
import com.projeto.farmacia.entity.Product;
import com.projeto.farmacia.entity.Sale;
import com.projeto.farmacia.dto.RequestSale;
import com.projeto.farmacia.repository.CustomerDAO;
import com.projeto.farmacia.repository.ProductDAO;
import com.projeto.farmacia.repository.SaleDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ProductDAO productDAO;

    public List<Sale> list() {
        return this.saleDAO.findAll();
    }

    public void create(RequestSale requestSale) {

        Customer customer = customerDAO.findById(requestSale.idCustomer())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID"));
        Product product = productDAO.findById(requestSale.idProduct())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        Sale sale = new Sale(requestSale, customer, product);
        this.saleDAO.save(sale);
    }

    @Transactional
    public Sale update(String id, RequestSale requestSale) {

        Sale existingSale = this.saleDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sale ID"));

        Customer customer = customerDAO.findById(requestSale.idCustomer())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID"));
        Product product = productDAO.findById(requestSale.idProduct())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        existingSale.setCustomer(customer);
        existingSale.setProduct(product);
        existingSale.setSaleDate(requestSale.saleDate());
        existingSale.setAmountValue(requestSale.amountValue());

        return existingSale;
    }

    public void remove(String id) {
        this.saleDAO.deleteById(id);
    }
}
