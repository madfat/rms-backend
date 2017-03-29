package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Fathoni on 3/27/2017.
 */
@Data
@Entity
@Table(name = "lookup")
public class Lookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "data_code", columnDefinition = "nvarchar(45)")
    private String dataCode;

    @Column(name = "data_desc", columnDefinition = "nvarchar(255)")
    private String dataDesc;

    @Column(name = "data_type", columnDefinition = "nvarchar(45)")
    private String dataType;
}
