package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by nabila.azam on 3/23/2017.
 */
@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "branch_office", columnDefinition = "nvarchar(45)")
    private String branchOffice;

    @Column(name = "relocation_start")
    private Date relocationStartDate;

    @Column(name = "relocation_end")
    private Date relocationEndDate;

    public Location(){}
    public void finalize() throws Throwable{}
}
