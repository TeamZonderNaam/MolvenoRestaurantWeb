package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MenuItemRepository {
    private static int menuItemId; //klopt dit zo?
    private Map<Integer, MenuItem> menuItems = new HashMap<>();

    //make new Hashmap with every new repository
//    public MenuItemRepository() {
//        this.menuItems = new HashMap<>();
//    }

    public MenuItem save(MenuItem newItem) {
        newItem.setId(++menuItemId);
        this.menuItems.put(newItem.getId(), newItem);
        return newItem;
    }

    public Collection<MenuItem> findAll() {
        return menuItems.values();
    }

    public Optional<MenuItem> findById(int id) {
        MenuItem found = this.menuItems.get(id);
        return Optional.of(found);
    }

    public void deleteById(int id) {
        this.menuItems.remove(id);
    }
}
