package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "region")
public class Region extends BaseEntity {

    private String name;

    private String image;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<SalesRep> salesReps;

}
