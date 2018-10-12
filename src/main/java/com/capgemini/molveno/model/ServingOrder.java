package com.capgemini.molveno.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class ServingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private MenuItem menuItem;

    private double numberOfMenuItems;

    public ServingOrder(){

    }

    public ServingOrder(MenuItem menuItem, double numberOfMenuItems){
        this.menuItem = menuItem;
        this.numberOfMenuItems = numberOfMenuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public double getNumberOfMenuItems() {
        return numberOfMenuItems;
    }

    public void setNumberOfMenuItems(double numberOfMenuItems) {
        this.numberOfMenuItems = numberOfMenuItems;
    }
}
