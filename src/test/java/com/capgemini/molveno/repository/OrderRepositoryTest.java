package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Order;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import java.util.ArrayList;

public class OrderRepositoryTest {
    private Order order = new Order();
    //private OrderRepository orderRepository = new OrderRepository();
    //private Iterable<Order> newOrder = orderRepository.findAll();
    private ArrayList<MenuItem> menu1 = new ArrayList<>();

    public void setOrder(){
//        MenuItem menuItem1 = new MenuItem();
//        MenuItem menuItem2 = new MenuItem();
//
//        menu1.add(menuItem1);
//        menu1.add(menuItem2);
//
//        order.setItems(menu1);
//        order.setId(5);
//        return order.getItems().size();
    }

    @Test
    public void save(){
       // assertTrue(newOrder.isEmpty());
        this.setOrder();
        assertEquals(2, this.menu1.size());
//        Assertions.assertNotEquals(1, order.getItems().size());
    }

    @Test
    public void delete(){
        this.setOrder();
        assertEquals(2, this.menu1.size());

        //orderRepository.deleteById(5);
//        assertEquals(1, order.getItems().size());
    }
}
