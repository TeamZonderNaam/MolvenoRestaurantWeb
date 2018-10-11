package com.capgemini.molveno.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;


@Entity
public class Serving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
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

    @Transient
    public double getServingPrice() {
        return (numberOfUnits * ingredient.getPricePerUnit());
    }
}
