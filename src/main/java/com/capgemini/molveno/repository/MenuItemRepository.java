package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Order;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class MenuItemRepository {


    private Map<Integer, MenuItem> menuItems = new HashMap<>();

//    @PostConstruct
//    public void add() {
//        int index = 1;
//        for(int i =0; i < 5; i++){
//            Order order = new Order();
//            order.setOrderNumber(index++);
//           // this.save(order);
//        }
//    }
}
