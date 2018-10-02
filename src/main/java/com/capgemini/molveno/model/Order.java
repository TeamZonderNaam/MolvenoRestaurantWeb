package com.capgemini.molveno.model;

import com.capgemini.molveno.enums.OrderStatus;

import java.util.List;


public class Order {
    private List<MenuItem> items;
    private Table table;
    private int Id;
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

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}
