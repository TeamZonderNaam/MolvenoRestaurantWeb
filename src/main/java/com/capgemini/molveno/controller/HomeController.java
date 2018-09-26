package com.capgemini.molveno.controller;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private IngredientService service;

    @RequestMapping("/")
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();

        Iterable<Ingredient> ingredients = service.all();
        model.put("hello", "World!");

        return new ModelAndView("index", model);
    }

    @RequestMapping("/ingredient")
    public ModelAndView ingredient() {
        Unit unit = new Unit("Kilogram");
        Ingredient ingredient1 = new Ingredient("Flour", 10.0, unit);
        Ingredient ingredient2 = new Ingredient("Cheese", 13.0, unit);
        Ingredient ingredient3 = new Ingredient("Tomato", 5.0, unit);
        service.create(ingredient1);
        service.create(ingredient2);
        service.create(ingredient3);

        return new ModelAndView("ingredient");
    }
}
