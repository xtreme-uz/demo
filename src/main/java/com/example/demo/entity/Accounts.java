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
@Table(name = "accounts")
public class Accounts extends BaseEntity {

    private String name;
    private String website;
    private String primaryContactPerson;

    @ManyToOne
    @JoinColumn(name="sales_rep_id", referencedColumnName = "id")
    private SalesRep salesId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private List<Orders> orders;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<WebEvents> webEvents;

}
