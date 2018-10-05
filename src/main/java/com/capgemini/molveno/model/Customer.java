package com.capgemini.molveno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
<<<<<<< HEAD
=======
import javax.persistence.GenerationType;
>>>>>>> Reservation
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
<<<<<<< HEAD
    private String phoneNumber;
    private String emailAddress;
    @Id
    @GeneratedValue
    private int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
=======
>>>>>>> Reservation

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
