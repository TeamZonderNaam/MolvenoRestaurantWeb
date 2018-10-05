package com.capgemini.molveno.model;

import javax.persistence.*;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int number;

    private int numberOfPersons;
    private TableShape shape;

    public Table() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public TableShape getShape() {
        return shape;
    }

    public void setShape(TableShape shape) {
        this.shape = shape;
    }
}
