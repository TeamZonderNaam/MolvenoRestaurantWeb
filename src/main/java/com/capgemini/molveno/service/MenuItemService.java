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
    public MenuItem create(@RequestBody MenuItem menuItem) {
        this.menuItemRepository.save(menuItem); //the function in PersonService returns an int
        return menuItem;
    }

    public Iterable<MenuItem> all(){ //in the other example this returns a collection
        return this.menuItemRepository.findAll();
    }

    public MenuItem read(final int id) { //in PersonService this method uses the Optional<> value, and this is also used in PersonRepository
        return this.menuItemRepository.findById(id);
    }

    public void update(MenuItem changedItem) { //returns a menu-item in person-example
        menuItemRepository.save(changedItem); //this method returns a void, but in person-example it should return a person
    }

    public void delete(int id) {
        this.menuItemRepository.deleteById(id);

    }


}
