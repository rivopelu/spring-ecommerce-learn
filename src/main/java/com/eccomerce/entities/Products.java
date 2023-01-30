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
public class Products implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private String image;
    @JoinColumn
    @ManyToOne
    private Categories categories;
    private BigDecimal price;
    private Double stock;
}
