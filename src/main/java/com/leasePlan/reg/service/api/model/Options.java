package com.leasePlan.reg.service.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sequence")
    private int sequence;

    @Column(name = "feature")
    private String feature;

    @Column(name = "price")
    private int price;

    @ManyToMany(mappedBy = "options")
    private Set<Vehicle> vehicles;
}
