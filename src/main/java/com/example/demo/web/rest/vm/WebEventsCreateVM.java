package com.example.demo.web.rest.vm;

import lombok.Data;

@Data
public class WebEventsCreateVM {

    private Long account;
    private String date;
    private String channel;

}