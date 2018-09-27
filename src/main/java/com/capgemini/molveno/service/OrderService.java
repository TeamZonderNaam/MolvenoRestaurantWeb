package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Order;
import com.capgemini.molveno.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public int create(Order order) {
        Order created = repository.save(order);
        return created.getOrderNumber();
    }

    public Collection<Order> all() {
        return this.repository.findAll();
    }

    public Order read(final int id) {
        Order order = repository.findById(id);
        return order;
    }

    public Order update(Order order) {
        return this.repository.save(order);
    }

    public void delete(final int id) {
        this.repository.deleteById(id);
    }
}
