package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Fathoni on 3/27/2017.
 */
@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "address", columnDefinition = "nvarchar(255)")
    private String address;

    @Column(name = "active_ind")
    private Boolean active_ind=false;

    public Address (){}
    public void finalize () throws Throwable{}
}
