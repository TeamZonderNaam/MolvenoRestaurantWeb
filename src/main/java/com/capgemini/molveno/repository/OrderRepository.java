package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

//    private static int lastID = 1;
//    private Map<Integer, Order> orders = new HashMap<>();
//
//
//    @PostConstruct
//    public void add() {
//        int index = 1;
//        for(int i =0; i < 5; i++){
//            Order order = new Order();
//            ArrayList<MenuItem> items = new ArrayList<>();
//
//            order.setStatus(OrderStatus.OPEN);
//
//            MenuItem menuItem = new MenuItem();
//            menuItem.setName("Fried Wonton");
//            menuItem.setNumber(22);
//            menuItem.setPrice(4);
//            items.add(menuItem);
//            //newOrder.setItems(items);
//            order.setItems(items);
//
//            Table table = new Table();
//            table.setNumber(12);
//            table.setNumberOfPersons(8);
//            table.setStatus(TableStatus.AVAILABLE);
//
//            //newOrder.setTable(table);
//            order.setTable(table);
//            order.setId(index++);
//            this.save(order);
//        }
//    }
//
//    public Map<Integer, Order> getOrders() {
//        return orders;
//    }
//
//    public Order save(Order newOrder){
//        //newOrder.setOrderNumber(lastID++);
//        if (orders.containsKey(newOrder.getId())) {
//            orders.put(newOrder.getId(), newOrder);
//        } else {
//            orders.put(lastID, newOrder);
//            newOrder.setId(lastID);
//            lastID++;
//        }
//        return this.orders.put(newOrder.getId(), newOrder);
//    }
//
//    //read all orders
//    public Collection<Order> findAll() {
//        return this.orders.values();
//    }
//
//    //read 1 order
//    public Order findById(final int id) {
//        Order findOneOrder = this.orders.get(id);
//        return findOneOrder;
//    }
//
//    //Update
//    public Order update(int id, Order update){
//        Order updateOrder = this.findById(id);
//        updateOrder.setTable(update.getTable());
//        updateOrder.setStatus(update.getStatus());
//        updateOrder.setId(update.getId());
//        updateOrder.setItems(update.getItems());
//        return updateOrder;
//    }
//    //delete order
//    public void deleteById(final int id) {
//        this.orders.remove(id);
//    }
}
