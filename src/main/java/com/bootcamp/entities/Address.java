package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Fathoni on 3/27/2017.
 */

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "address", columnDefinition = "nvarchar(255)")
    private String address;

    @Column(name = "active_ind")
    private Boolean activeInd=false;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActiveInd() {
        return activeInd;
    }

    public void setActivend(Boolean activeInd) {
        this.activeInd = activeInd;
    }

    public Address (){}
    public void finalize () throws Throwable{}
}
