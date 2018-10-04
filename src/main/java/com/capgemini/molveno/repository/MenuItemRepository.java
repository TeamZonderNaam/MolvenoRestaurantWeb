package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {
//    private static int menuItemId;
//    private Map<Integer, MenuItem> menuItems = new HashMap<>();
//
//    @PostConstruct
//    public void addSomeItemsToGetStarted() {
//        for(int i = 1; i < 6; i++) {
//            MenuItem item = new MenuItem();
//            item.setCategory("Food");
//            this.save(item);
//        }
//        this.menuItems.get(1).setName("Fresh Meat Dumpling");
//        this.menuItems.get(2).setName("Fried Wonton");
//        this.menuItems.get(3).setName("Beancurd Soup");
//        this.menuItems.get(4).setName("Peking Duck");
//        this.menuItems.get(5).setName("Hot Plate");
//        this.menuItems.get(1).setPrice(3.5);
//        this.menuItems.get(2).setPrice(4);
//        this.menuItems.get(3).setPrice(4.5);
//        this.menuItems.get(4).setPrice(14.5);
//        this.menuItems.get(5).setPrice(21.5);
//        this.menuItems.get(1).setNumber(1);
//        this.menuItems.get(2).setNumber(2);
//        this.menuItems.get(3).setNumber(15);
//        this.menuItems.get(4).setNumber(23);
//        this.menuItems.get(5).setNumber(45);
//    }
//
//    public MenuItem save(MenuItem newItem) {
//        if (this.menuItems.containsKey(newItem.getId())) {
//            this.menuItems.put(newItem.getId(), newItem);
//        } else {
////            newItem.setId(++menuItemId);
//            this.menuItems.put(newItem.getId(), newItem);
//        }
//        return newItem;
//    }
//
//    public Collection<MenuItem> findAll() {
//        return menuItems.values();
//    }
//
//    public Optional<MenuItem> findById(int id) {
//        MenuItem found = this.menuItems.get(id);
//        return Optional.of(found);
//    }
//
//    public void deleteById(int id) {
//        this.menuItems.remove(id);
//    }
}
