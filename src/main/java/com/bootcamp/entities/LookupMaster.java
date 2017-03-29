package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Fathoni on 3/27/2017.
 */
@Data
@Entity
@Table(name = "lookup_master")
public class LookupMaster {

    @Id
    @Column(name = "type", columnDefinition = "nvarchar(45)", unique = true)
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    private List<Lookup> lookups;

    public LookupMaster(){}
    public void finalize() throws Throwable{}
}
