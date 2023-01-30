package com.eccomerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Cart implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Products products;
    @JoinColumn
    @ManyToOne
    private User user;
    private Double quantity;
    private BigDecimal price;
    private BigDecimal amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedDate;
}
