package com.example.demo.web.rest.vm;

import lombok.Data;

@Data
public class AccountsCreateVM {

    private String name;
    private String website;
    private String primaryContactPerson;
    private Long salesId;
}
