package com.capgemini.molveno.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Unit {
    @Id
    private int id;
    private String name;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
