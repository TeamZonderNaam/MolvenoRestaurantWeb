package com.capgemini.molveno.model;

import javax.persistence.*;
import java.time.LocalDateTime;
<<<<<<< HEAD
@Entity
public class Reservation {
    //een reservering heeft klantgegevens, aantal personen, een tafelnummer, kinderzitjes nodig, parkeerplaats nodig en een tijd (begintijd en tijdsduur)

    @ManyToOne
    private Customer customer;
=======
import java.util.List;

@Entity
public class Reservation {
    //een reservering heeft klantgegevens, aantal personen, een tafelnummer, kinderzitjes nodig, parkeerplaats nodig en een tijd (begintijd en tijdsduur)
>>>>>>> Reservation
    private boolean parkingSpaceNeeded;
    private int numberOfChildSeats;
    private int numberOfPersons;
    //dit zou eigenlijk een list moeten worden
<<<<<<< HEAD

    @ManyToOne
    private Table reservedTable;
    private LocalDateTime startReservation;
    private int totalTimeInMinutes;
    @Id
    @GeneratedValue
    private int ID;
=======
    private LocalDateTime startReservation;
    private int totalTimeInMinutes;

    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
    private List<Table> tables;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
>>>>>>> Reservation

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isParkingSpaceNeeded() {
        return parkingSpaceNeeded;
    }

    public void setParkingSpaceNeeded(boolean parkingSpaceNeeded) {
        this.parkingSpaceNeeded = parkingSpaceNeeded;
    }

    public int getNumberOfChildSeats() {
        return numberOfChildSeats;
    }

    public void setNumberOfChildSeats(int numberOfChildSeats) {
        this.numberOfChildSeats = numberOfChildSeats;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public List<Table> getTables() {
        return tables;
    }

<<<<<<< HEAD
    public void setReservedTable(Table reservedTable) {
        this.reservedTable = reservedTable;
=======
    public void setTables(List<Table> tables) {
        this.tables = tables;
>>>>>>> Reservation
    }

    public LocalDateTime getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(LocalDateTime startReservation) {
        this.startReservation = startReservation;
    }

    public int getTotalTimeInMinutes() {
        return totalTimeInMinutes;
    }

    public void setTotalTimeInMinutes(int totalTimeInMinutes) {
        this.totalTimeInMinutes = totalTimeInMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }
}
