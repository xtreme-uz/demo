package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO implements DTO {

    private Long id;
    private String name;
    private String website;
    private String primaryContactPerson;
    private SalesRepDTO salesId;

}
