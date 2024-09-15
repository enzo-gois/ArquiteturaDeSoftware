package com.projeto.farmacia.entity;

import com.projeto.farmacia.dto.RequestSale;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDateTime getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDateTime saleDate) {
		this.saleDate = saleDate;
	}

	public BigDecimal getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(BigDecimal amountValue) {
		this.amountValue = amountValue;
	}

	@Id
    private String id;

    @DBRef
    private Customer customer;

    @DBRef
    private Product product;

    private LocalDateTime saleDate;
    private BigDecimal amountValue;

    public Sale(Customer customer, Product product, LocalDateTime saleDate, BigDecimal amountValue) {
        this.customer = customer;
        this.product = product;
        this.saleDate = saleDate;
        this.amountValue = amountValue;
    }

}
