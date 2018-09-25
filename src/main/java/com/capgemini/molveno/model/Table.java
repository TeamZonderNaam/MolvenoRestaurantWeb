package com.capgemini.molveno.model;

public class Table {
    private int number;
    private int numberOfPersons;
    private TableShape shape;
    private TableStatus status;
    private Reservation reservation; // Dit moet een collection worden.

    public void Table(int number, int numberOfPersons, TableShape shape) {
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
