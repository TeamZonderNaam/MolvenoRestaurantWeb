package com.capgemini.molveno.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double pricePerUnit;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Unit unit;


    public Ingredient() {
    }

    public Ingredient(String name, double pricePerUnit, Unit unit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
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

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", unit=" + unit +
                '}';
    }
}
