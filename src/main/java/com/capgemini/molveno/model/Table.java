package com.capgemini.molveno.model;

import javax.persistence.*;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private int numberOfPersons;
    private TableShape shape;
    private TableStatus status;

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

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public TableShape getShape() {
        return shape;
    }

    public void setShape(TableShape shape) {
        this.shape = shape;
    }


}
