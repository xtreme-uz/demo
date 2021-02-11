package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDTO implements DTO {

    private Long id;

    private String username;

    private String password;

    private String img;

}
