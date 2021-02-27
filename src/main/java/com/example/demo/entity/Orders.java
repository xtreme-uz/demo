package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Accounts accounts;

    private Integer standardQty;
    private Integer posterQty;
    private Integer glossyQty;
    private Integer total;

    @Column(name = "occurred_at")
    @Temporal(TemporalType.DATE)
    private Date date;

    private Double standardAmountUsd;
    private Double glossyAmountUsd;
    private Double posterAmountUsd;
    private Double totalAmountUsd;

    private String ordersListFile;

}
