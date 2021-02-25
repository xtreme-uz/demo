package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO implements DTO{

    private Long id;
    private AccountsDTO accounts;
    private Integer standardQty;
    private Integer posterQty;
    private Integer glossyQty;
    private Integer total;
    private String date;
    private Double standardAmountUsd;
    private Double glossyAmountUsd;
    private Double posterAmountUsd;
    private Double totalAmountUsd;
    private String image;
}