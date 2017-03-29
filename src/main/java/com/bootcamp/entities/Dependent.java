package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by nabila.azam on 3/23/2017.
 */
@Data
@Entity
@Table(name = "dependent")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "gender", columnDefinition = "nvarchar(45)")
    private String gender;

    @Column(name = "type", columnDefinition = "nvarchar(45)")
    private String type;

    @Column(name = "first_name", columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "active_ind")
    private Boolean activeInd;

    public Dependent(){}
    public void finalize() throws Throwable{}
}
