package com.capgemini.molveno.model;

public class Table {
    private int number;
    private int ID;
    private int numberPersons;
    private TableStatus status;
    //dit zou een list moeten worden
    private Reservation reservation;
    private TableShape shape;

    public Table() {

    }

    public Table(int number, int numberOfPersons, TableShape shape) {
        this.number = number; // Controle dat dit nummer uniek is?
        this.numberPersons = numberOfPersons;
        this.status = TableStatus.AVAILABLE;
        this.shape = shape;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberPersons() {
        return numberPersons;
    }

    public void setNumberPersons(int numberPersons) {
        this.numberPersons = numberPersons;
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
