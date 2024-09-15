package com.projeto.farmacia.entity;

import com.projeto.farmacia.dto.RequestSale;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name="sale")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

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

	@Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "amount_value", nullable = false)
    private BigDecimal amountValue;

    public Sale(RequestSale requestSale, Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
        this.saleDate = requestSale.saleDate();
        this.amountValue = requestSale.amountValue();
    }

}
