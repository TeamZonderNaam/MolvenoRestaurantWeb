package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Order;
import com.capgemini.molveno.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public Collection<Order> get() {
        return this.orderRepository.findAll();
    }

    @GetMapping("{id}")
    public Order getSingle(@PathVariable int id) {
        return this.orderRepository.findById(id);
    }

    @PostMapping
    public Order add(@RequestBody Order order) {
        this.orderRepository.save(order);
        return order;
    }

    @PutMapping("{id}")
    public Order update(@PathVariable("id") int orderNumber, @RequestBody Order order) {
        return this.orderRepository.update(orderNumber, order);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id, @RequestBody Order order) {
        if (id >= 0 && id <= this.orderRepository.getOrders().size()) {
            this.orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
