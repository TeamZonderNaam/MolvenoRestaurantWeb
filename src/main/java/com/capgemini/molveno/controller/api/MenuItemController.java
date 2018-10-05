package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Serving;
import com.capgemini.molveno.service.MenuItemService;
import com.capgemini.molveno.service.ServingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("menu_api_controller")
@RequestMapping ("/api/menuItem")
public class MenuItemController {
    @Autowired
    private MenuItemService service;

    @Autowired
    private ServingService servingService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuItem> get() {
        return service.all();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public MenuItem getSingle(@PathVariable(name="id") int id) {
        MenuItem item = service.read(id);
        return item;
    }

    @PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public MenuItem create(@RequestBody MenuItem item) {
        int id = service.create(item);
        item.setId(id);
        if (item != null && item.getServings() != null) {
            List<Serving> servingList = new ArrayList<>();
            for (Serving serving : item.getServings()) {
                Serving newServing = servingService.read(serving.getId());
                servingList.add(newServing);
            }
            item.setServings(servingList);
        }

        // Can't use the following line, will give a JsonMappingException on the getCostPrice()
//        MenuItem read = service.read(id);
        return item;
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
