package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "web_events")
public class WebEvents extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Accounts account;

    @Column(name = "occurred_at")
    private String date;
    private String channel;


}