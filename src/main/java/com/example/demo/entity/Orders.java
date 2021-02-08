package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String date;

    private Double standardAmountUsd;
    private Double glossyAmountUsd;
    private Double posterAmountUsd;
    private Double totalAmountUsd;


}
