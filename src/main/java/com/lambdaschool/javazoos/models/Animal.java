package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalid;

    private String animaltype;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "zooanimals",
        joinColumns = {@JoinColumn(name = "animalid")},
        inverseJoinColumns = {@JoinColumn(name = "zooid")})
    @JsonIgnoreProperties("animal")
    private Set<Zoo> zoos;

    public Animal() {

    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<Zoo> getZoos() {
        return zoos;
    }

    public void setZoos(Set<Zoo> zoos) {
        this.zoos = zoos;
    }
}
