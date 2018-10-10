package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Category;
import com.capgemini.molveno.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController ("category_api_controller")
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Category> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Category getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Category add(@RequestBody Category category) {
        int id = service.create(category);
        category.setId(id);
        return category;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }
}
