package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/menuItem") //camel case?

public class MenuItemController {
    @Autowired
    private MenuItemService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MenuItem> get() {
        return service.all();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public MenuItem getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public MenuItem create(@RequestBody MenuItem item) {
        int id = service.create(item);
        //set id of item
        return item;
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem update(@RequestBody MenuItem item) {
        return service.update(item);
    }

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody MenuItem item) {
        service.delete(item.getId());
    }
}
