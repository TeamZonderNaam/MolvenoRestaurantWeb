package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Ingredient> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Ingredient getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Ingredient add(@RequestBody Ingredient ingredient) {
        int id = service.create(ingredient);
        ingredient.setId(id);
        return ingredient;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ingredient update(@RequestBody Ingredient ingredient) {
        return service.update(ingredient);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }
}
