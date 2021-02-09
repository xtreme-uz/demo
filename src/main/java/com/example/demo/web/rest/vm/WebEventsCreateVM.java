package com.example.demo.web.rest.vm;

import lombok.Data;

import java.util.Date;

@Data
public class WebEventsCreateVM {

    private Long account;
    private Date date;
    private String channel;

}