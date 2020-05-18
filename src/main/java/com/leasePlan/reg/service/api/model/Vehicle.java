package com.leasePlan.reg.service.api.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@ToString
@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "aid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    @Column(name = "makeName")
    private String makeName;
    @Column(name = "modelName")
    private String modelName;
    @Column(name = "modelEdition")
    private String modelEdition;
    @Column(name = "price")
    private int price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Options> options;
}
