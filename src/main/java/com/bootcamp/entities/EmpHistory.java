package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Fathoni on 3/27/2017.
 */
@Data
@Entity
@Table(name = "emp_history")
public class EmpHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "employer", columnDefinition = "nvarchar(45)")
    private String employer;

    @Column(name = "job_desc", columnDefinition = "nvarchar(MAX)")
    private String jobDesc;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "active_ind")
    private Boolean activeInd=false;

    public EmpHistory(){}
    public void finalize () throws Throwable{}
}
