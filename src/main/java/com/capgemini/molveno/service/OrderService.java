package com.capgemini.molveno.service;

import com.capgemini.molveno.enums.OrderStatus;
import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Order;
import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.model.TableStatus;
import com.capgemini.molveno.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public int create(Order order) {
        Order created = repository.save(order);
        return created.getId();
    }

    @PostConstruct
    public void add() {
        int index = 1;
        for(int i =0; i < 5; i++){
            Order order = new Order();
            ArrayList<MenuItem> items = new ArrayList<>();

            order.setStatus(OrderStatus.OPEN);

            MenuItem menuItem = new MenuItem();
            menuItem.setName("Fried Wonton");
            menuItem.setNumber(22);
            menuItem.setPrice(4);
            items.add(menuItem);
            //newOrder.setItems(items);
            order.setItems(items);

            Table table = new Table();
            table.setNumber(12);
            table.setNumberOfPersons(8);
            table.setStatus(TableStatus.AVAILABLE);

            //newOrder.setTable(table);
            order.setTable(table);
            order.setId(index++);
            this.repository.save(order);
        }
    }

    public List<Order> all() {
        Iterable<Order> source = this.repository.findAll();
        List<Order> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

    public Optional<Order> read(final int id) {
        Optional<Order> order = repository.findById(id);
        return order;
    }

    public Order update(Order order) {
        return this.repository.save(order);
    }

    public void delete(final int id) {
        this.repository.deleteById(id);
    }
}
