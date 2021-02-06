package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionDTO implements DTO {

    private Long id;

    private String name;

//    private List<SalesRepDTO> salesReps;

}
