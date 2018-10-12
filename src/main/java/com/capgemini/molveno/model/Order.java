package com.capgemini.molveno.model;

import com.capgemini.molveno.enums.OrderStatus;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @OneToMany
    private List<ServingOrder> servingOrders;

    @ManyToOne(cascade=CascadeType.ALL)
    private Table table;

    //it would be ideal if you could set this property for every individual order of the order
    private OrderStatus status;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<ServingOrder> getServingOrders() {
        return servingOrders;
    }

    public void setServingOrders(List<ServingOrder> servingOrders) {
        this.servingOrders = servingOrders;
    }

    @Transient
    public double getMenuCostPrice() {
        double cost = 0;
        if (this.servingOrders != null) {
            for (ServingOrder servingOrder : this.servingOrders) {
                cost += servingOrder.getNumberOfMenuItems() * servingOrder.getMenuItem().getPrice();
            }
        }
        return cost;
    }

    private List<MenuItem> getItemsOnCategory(String category) {
        List<MenuItem> items = new ArrayList<>();

        if (this.servingOrders != null) {
            for (ServingOrder order : this.servingOrders) {
                MenuItem item = order.getMenuItem();
                if (item.getCategory().getName().equals(category)) {
                    items.add(item);
                }
            }
            return items;
        }

        return null;
    }

    @Transient
    public List<MenuItem> getFoodItems() {
        return getItemsOnCategory("Food");
    }

    @Transient
    public List<MenuItem> getDrinkItems() {
        return getItemsOnCategory("Drinks");
    }
}
