package com.capgemini.molveno.service;

import com.capgemini.molveno.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.molveno.repository.MenuItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.Optional;

@Service

public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @PostMapping
    public int create(@RequestBody MenuItem menuItem) {
        MenuItem created = this.menuItemRepository.save(menuItem);
        return created.getId();
    }

    public Iterable<MenuItem> all(){
        return this.menuItemRepository.findAll();
    }

    public MenuItem read(final int id) {
        Optional<MenuItem> item = this.menuItemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    public MenuItem update(MenuItem changedItem) {
        return menuItemRepository.save(changedItem);
    }

    public void delete(int id) {
        this.menuItemRepository.deleteById(id);

    }


}
