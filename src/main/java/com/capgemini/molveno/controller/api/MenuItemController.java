package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api/menuItem")
public class MenuItemController {
    @Autowired
    private MenuItemService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuItem> get() {
        return service.all();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public MenuItem getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public MenuItem create(@RequestBody MenuItem item) {
        int id = service.create(item);
        return service.read(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem update(@PathVariable int id, @RequestBody MenuItem item) {
        return service.update(id, item);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
