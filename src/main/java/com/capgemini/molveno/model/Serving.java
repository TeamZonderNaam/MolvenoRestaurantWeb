package com.capgemini.molveno.model;

import javax.persistence.*;

@Entity
public class Serving {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Ingredient ingredient;

    private double numberOfUnits;

    public Serving() {
    }

    public Serving(Ingredient ingredient, double numberOfUnits){
        this.ingredient = ingredient;
        this.numberOfUnits = numberOfUnits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(double numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
}
