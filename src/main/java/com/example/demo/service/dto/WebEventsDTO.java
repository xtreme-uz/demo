package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebEventsDTO implements DTO{

    private Long id;
    private AccountsDTO account;
    private Date date;
    private String channel;

}
