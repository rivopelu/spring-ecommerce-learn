package com.eccomerce.entities;

import com.eccomerce.models.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Order implements Serializable {
    @Id
    private String id;
    private String number;
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn
    @ManyToOne
    private User user;
    private String shippingAddress;
    private BigDecimal amount;
    private BigDecimal shippingPrice;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

}
