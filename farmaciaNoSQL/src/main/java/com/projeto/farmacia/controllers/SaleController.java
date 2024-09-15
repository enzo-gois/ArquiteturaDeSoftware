package com.projeto.farmacia.controllers;

import com.projeto.farmacia.entity.Sale;
import com.projeto.farmacia.dto.RequestSale;
import com.projeto.farmacia.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return this.saleService.list();
    }

    @PostMapping
    public void saveSale(@Valid @RequestBody RequestSale requestSale) {
        this.saleService.create(requestSale);
    }

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable("id") String id, @RequestBody RequestSale requestSale) {
        return this.saleService.update(id, requestSale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable String id) {
        this.saleService.remove(id);
    }
}
