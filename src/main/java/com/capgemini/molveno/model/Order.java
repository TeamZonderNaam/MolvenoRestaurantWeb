package com.capgemini.molveno.model;

import com.capgemini.molveno.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @OneToMany
    private List<ServingOrder> servingOrders;

    @ManyToOne(cascade=CascadeType.ALL)
    private Table table;

    //it would be ideal if you could set this property for every individual order of the order
    private OrderStatus status;
    //this variable should be composed of the separate prices of every menu-order
    private int totalPrice;

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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
}
