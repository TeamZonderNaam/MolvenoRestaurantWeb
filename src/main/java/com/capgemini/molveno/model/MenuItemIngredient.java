//package com.capgemini.molveno.model;
//
//import javax.persistence.*;
//import javax.persistence.Table;
//import java.awt.*;
//import java.util.List;
//
//@Entity
//@Table(name = "MENU_ITEM_INGREDIENT")
//public class MenuItemIngredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="MENU_ITEM_INGREDIENT_ID")
//    private long id;
//
//    @ManyToOne(cascade = CascadeType.ALL)
////    @MapsId
//    @JoinColumn(name = "MENU_ITEM_ID")
//    private MenuItem menuItem;
//
//    @ManyToOne(cascade = CascadeType.ALL)
////    @MapsId
//    @JoinColumn(name = "INGREDIENT_ID")
//    private Ingredient ingredient;
//
//    @Column(name="NUMBER_OF_UNITS")
//    private double numberOfUnits;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public MenuItem getMenuItem() {
//        return menuItem;
//    }
//
//    public void setMenuItem(MenuItem menuItem) {
//        this.menuItem = menuItem;
//    }
//
//
//    public Ingredient getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(Ingredient ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    public double getNumberOfUnits() {
//        return numberOfUnits;
//    }
//
//    public void setNumberOfUnits(double numberOfUnits) {
//        this.numberOfUnits = numberOfUnits;
//    }
//}
