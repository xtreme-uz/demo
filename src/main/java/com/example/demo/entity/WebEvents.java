package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date date;

    private String channel;


}