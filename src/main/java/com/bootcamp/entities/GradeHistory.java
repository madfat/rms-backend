package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Fathoni on 3/27/2017.
 */
@Data
@Entity
@Table(name = "grade_history")
public class GradeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "grade", columnDefinition = "nvarchar(45)")
    private String grade;

    @Column(name = "dev_stage")
    private Integer devStage;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public GradeHistory(){}
    public void finalize() throws Throwable{}

}
