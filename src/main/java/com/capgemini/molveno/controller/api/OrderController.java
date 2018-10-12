package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Order;
import com.capgemini.molveno.model.Serving;
import com.capgemini.molveno.model.ServingOrder;
import com.capgemini.molveno.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("order_api")
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Order> get() {
        return this.orderService.all();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getSingle(@PathVariable int id) {
        return this.orderService.read(id);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order add(@RequestBody Order order) {
        this.orderService.create(order);
        return order;
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order update(@PathVariable int id, @RequestBody Order order) {
        return this.orderService.update(id, order);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable int id) {
        this.orderService.delete(id);
        return "{}";
    }


    @PostMapping(value = "/add/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addToOrder(@PathVariable("id") int id, @RequestBody MenuItem item) {
        orderService.addMenuItem(id, item);
        System.out.println("Got Order");
        return "{}";
    }
}
