package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Created by nabila.azam on 3/23/2017.
 */
//@Data
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

    public Employee(String firstName, String lastName, String gender, String phone,
                    Date dob, String maritalStatus, String email, String grade, String location, Date hiredDate,
                    String employmentStatus){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.dob =  dob;
        this.maritalStatus = maritalStatus;
        this.email = email;
        this.grade = grade;
        this.location = location;
        this.hiredDate = hiredDate;
        this.employmentStatus = employmentStatus;
    }

    public void finalize() throws Throwable {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getJobFamily() {
        return jobFamily;
    }

    public void setJobFamily(String jobFamily) {
        this.jobFamily = jobFamily;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(Date retiredDate) {
        this.retiredDate = retiredDate;
    }

    public Date getSuspendedDate() {
        return suspendedDate;
    }

    public void setSuspendedDate(Date suspendedDate) {
        this.suspendedDate = suspendedDate;
    }

    public Boolean getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Boolean activeInd) {
        this.activeInd = activeInd;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<GradeHistory> getGradeHistories() {
        return gradeHistories;
    }

    public void setGradeHistories(List<GradeHistory> gradeHistories) {
        this.gradeHistories = gradeHistories;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<EmpHistory> getEmpHistories() {
        return empHistories;
    }

    public void setEmpHistories(List<EmpHistory> empHistories) {
        this.empHistories = empHistories;
    }
}
