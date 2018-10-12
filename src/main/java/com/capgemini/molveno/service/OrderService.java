package com.capgemini.molveno.service;

import com.capgemini.molveno.enums.OrderStatus;
import com.capgemini.molveno.model.*;
import com.capgemini.molveno.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private TableService tableService;

    @Autowired
    private ServingOrderService servingService;

    public int create(Order order) {
        if (order.getTable() != null) {
            int number = order.getTable().getNumber();
            order.setTable(
                    tableService.readByNumber(number)
            );
            Order created = repository.save(order);
            return created.getId();
        }
        return -1;
    }

    public List<Order> all() {
        Iterable<Order> source = this.repository.findAll();
        List<Order> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

    public Order read(final int id) {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    public Order update(int id, Order changedOrder) {
        Optional<Order> oldOrder = repository.findById(id);
        if (oldOrder.isPresent()) {
            if (changedOrder.getTable() != null && !oldOrder.get().getTable().equals(changedOrder.getTable())) {
                int number = changedOrder.getTable().getNumber();
                oldOrder.get().setTable(
                        tableService.readByNumber(number)
                );
//                oldOrder.get().setTable(changedOrder.getTable());
            }
            if (changedOrder.getStatus() != null) {
                oldOrder.get().setStatus(changedOrder.getStatus());
            }
            if (changedOrder.getServingOrders() != null) {
                oldOrder.get().setServingOrders(changedOrder.getServingOrders());
            }
        }
        return this.repository.save(oldOrder.get());
    }

    public void delete(final int id) {
        this.repository.deleteById(id);
    }

    public void addMenuItem(int orderId, MenuItem item) {
        Order order = read(orderId);
        if (order == null) {
            order = new Order();
            // TODO: For now :C
            order.setTable(tableService.readByNumber(2));
            order.setStatus(OrderStatus.OPEN);
            create(order);
        }

        if (order.getServingOrders() == null) {
            order.setServingOrders(new ArrayList<>());
        }

        ServingOrder foundServing = null;
        for (ServingOrder serving : order.getServingOrders()) {
            if (serving.getMenuItem() != null && serving.getMenuItem().getId() == item.getId()) {
                foundServing = serving;
            }
        }

        if (foundServing == null) {
            foundServing = new ServingOrder(item, 1);
            servingService.create(foundServing);

            order.getServingOrders().add(foundServing);
            update(order.getId(), order);
        } else {
            double newCount = foundServing.getNumberOfMenuItems() + 1;
            foundServing.setNumberOfMenuItems(newCount);
            servingService.update(foundServing.getId(), foundServing);
        }
    }
}
