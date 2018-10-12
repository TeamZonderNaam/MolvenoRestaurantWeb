package com.capgemini.molveno.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int numberOfPersons;
    private int numberOfChildSeats;
    private LocalDate date;
    private LocalTime startTime;
    private int hours;
    @ManyToMany
    private List<Table> tables;
    private boolean parkingSpaceNeeded;

    public Reservation() {
        this.hours = 2;
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

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getNumberOfChildSeats() {
        return numberOfChildSeats;
    }

    public void setNumberOfChildSeats(int numberOfChildSeats) {
        this.numberOfChildSeats = numberOfChildSeats;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return startTime.plusHours(this.hours);
    }

    public int getHours() {
        return hours;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public boolean isParkingSpaceNeeded() {
        return parkingSpaceNeeded;
    }

    public void setParkingSpaceNeeded(boolean parkingSpaceNeeded) {
        this.parkingSpaceNeeded = parkingSpaceNeeded;
    }
}
