package com.capgemini.molveno.model;

import javax.persistence.*;

@Entity
public class Table {
    private int number;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private int numberOfPersons;
    private TableStatus status;
    //dit zou een list moeten worden
    @ManyToOne
    private Reservation reservation;
    private TableShape shape;

    public Table() {

    }

    public Table(int number, int numberOfPersons, TableShape shape) {
        this.number = number; // Controle dat dit nummer uniek is?
        this.numberOfPersons = numberOfPersons;
        this.status = TableStatus.AVAILABLE;
        this.shape = shape;
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

    public void setNumberOfPersons(int numberPersons) {
        this.numberOfPersons = numberPersons;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public TableShape getShape() {
        return shape;
    }

    public void setShape(TableShape shape) {
        this.shape = shape;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
