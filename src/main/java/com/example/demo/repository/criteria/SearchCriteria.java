package com.example.demo.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria implements Serializable {

    private static final long serialVersionUID = 2405172041950251807L;

    private String key;

    private String operation;

    private Object value;

}
