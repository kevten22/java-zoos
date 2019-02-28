package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "telephone")
    @JsonIgnoreProperties("telephone")
    private Set<Telephone> telephones = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "zoo")
    private Set<Animal> animals;

    public Zoo(){

    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public Set<Telephone> getTelephones() {
        return telephones;
    }
    public void setTelephones(Set<Telephone> telephones) {
        this.telephones = telephones;
    }
}
