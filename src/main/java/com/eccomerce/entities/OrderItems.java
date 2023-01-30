package com.eccomerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class OrderItems implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Order order;
    @JoinColumn
    @ManyToOne
    private Products products;
    private String description;
    private Double quantity;
    private BigDecimal price;
    private BigDecimal amount;

}
