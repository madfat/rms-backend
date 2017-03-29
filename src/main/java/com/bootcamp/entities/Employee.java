package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Created by nabila.azam on 3/23/2017.
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "first_name", columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender", columnDefinition = "nvarchar(45)")
    private String gender;

    @Column(name = "marital_status", columnDefinition = "nvarchar(45)")
    private String maritalStatus;

    @Column(name = "phone", columnDefinition = "nvarchar(45)")
    private String phone;

    @Column(name = "email", columnDefinition = "nvarchar(45)")
    private String email;

    @Column(name="grade", columnDefinition = "nvarchar(45)")
    private String grade;

    @Column(name = "location", columnDefinition = "nvarchar(45)")
    private String location;

    @Column(name = "hired_date")
    private Date hiredDate;

    @Column(name = "employment_status", columnDefinition = "nvarchar(45)")
    private String employmentStatus;

    @Column(name = "nationality", columnDefinition = "nvarchar(45)")
    private String nationality;

    @Column(name = "business_unit", columnDefinition = "nvarchar(45)")
    private String businessUnit;

    @Column(name = "division", columnDefinition = "nvarchar(45)")
    private String division;

    @Column(name = "job_family", columnDefinition = "nvarchar(45)")
    private String jobFamily;

    @Column(name = "stream", columnDefinition = "nvarchar(45)")
    private String stream;

    @Column(name = "job_title", columnDefinition = "nvarchar(45)")
    private String jobTitle;

//    @Column(name = "reporting_manager", columnDefinition = "nvarchar(45)")
//    private Long reportingManager;

    @Column(name = "retired_date")
    private Date retiredDate;

    @Column(name = "suspended_date")
    private Date suspendedDate;

    @Column(name = "active_ind")
    private Boolean activeInd=false;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Dependent> dependents;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Location> locations;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<GradeHistory> gradeHistories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<EmpHistory> empHistories;

    public Employee(){
    }

    public void finalize() throws Throwable {
    }
}
