package com.capgemini.molveno.model;

public class Ingredient {
    private int id;
    private String name;
    private double pricePerUnit;
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
