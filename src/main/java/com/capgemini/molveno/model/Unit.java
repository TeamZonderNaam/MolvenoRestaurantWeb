package com.capgemini.molveno.model;

public class Unit {
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
