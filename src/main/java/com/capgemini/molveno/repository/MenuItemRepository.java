package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MenuItemRepository {
    private static int menuItemId;
    private Map<Integer, MenuItem> menuItems = new HashMap<>();

    @PostConstruct
    public void addSomeItemsToGetStarted() {
        for(int i = 1; i < 6; i++) {
            MenuItem item = new MenuItem();
            item.setName("item " + i);
            item.setCategory("Food");
            this.save(item);
        }
    }

    public MenuItem save(MenuItem newItem) {
        if (this.menuItems.containsKey(newItem.getId())) {
            this.menuItems.put(newItem.getId(), newItem);
        } else {
            newItem.setId(++menuItemId);
            this.menuItems.put(newItem.getId(), newItem);
        }
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
