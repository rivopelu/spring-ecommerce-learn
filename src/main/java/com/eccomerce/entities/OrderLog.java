package com.eccomerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@Entity
public class OrderLog implements Serializable {
    @Id
    private String id;
    @JoinColumn
    @ManyToOne
    private Order order;
    @JoinColumn
    @ManyToOne
    private User user;
    private Integer logType;
    private String logMessage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

}
