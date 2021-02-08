package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "region")
public class Region extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
//    @OrderBy("id desc")
    private List<SalesRep> salesReps;

}
