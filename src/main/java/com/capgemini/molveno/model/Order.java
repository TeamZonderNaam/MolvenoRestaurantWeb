package com.capgemini.molveno.model;

import java.util.List;

public class Order {
    private List<MenuItem> items;
    private Table table;
    private int orderNumber;
    //it would be ideal if you could set this property for every individual order of the order
    private boolean prepared;
    //this variable should be composed of the separate prices of every menu-order
    private int totalPrice;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean getPrepared() {
        return prepared;
    }

    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}
