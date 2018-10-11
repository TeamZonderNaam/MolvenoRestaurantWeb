package com.capgemini.molveno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem {
    private String name;
    private double price;
    private int number;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Category category;

    @OneToMany
    private List<Serving> servings;

    private double menuItemMargin;

    public MenuItem(String name, double price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    //empty constructor for easy constructing of menu items
    public MenuItem() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Serving> getServings() {
        return servings;
    }

    public void setServings(List<Serving> servings) {
        this.servings = servings;
    }

    public double getMenuItemMargin() {
        return menuItemMargin;
    }

    public void setMenuItemMargin(double menuItemMargin) {
        this.menuItemMargin = menuItemMargin;
    }

    @Transient
    public double getCostPrice() {
        double cost = 0;
        if (this.servings != null) {
            for (Serving serving : this.servings) {
                cost += serving.getNumberOfUnits() * serving.getIngredient().getPricePerUnit();
            }
        }
        return cost;
    }

    @Transient double getSellingPrice() {
        return (this.getCostPrice() + (this.getCostPrice() * this.menuItemMargin)/100);
    }
}
