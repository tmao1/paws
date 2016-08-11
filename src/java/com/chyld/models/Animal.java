package com.chyld.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by localadmin on 8/11/16.
 */
@Entity
@Table(name = "animals")
@Access(AccessType.PROPERTY)
public class Animal {
    private int id;
    private String name;
    private Date birthday;
    private Date placement;
    private Sex sex;
    private Species species;

    public Animal(String name, Date birthday, Date placement, Sex sex, Species species) {
        this.name = name;
        this.birthday = birthday;
        this.placement = placement;
        this.sex = sex;
        this.species = species;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "placement")
    public Date getPlacement() {
        return placement;
    }

    public void setPlacement(Date placement) {
        this.placement = placement;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "species", nullable = false)
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
