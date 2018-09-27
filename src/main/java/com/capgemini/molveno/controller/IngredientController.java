package com.capgemini.molveno.controller;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    private static boolean done = false;
    private static List<Unit> units = new ArrayList<>();

    @Autowired
    private IngredientService service;

    @RequestMapping("/")
    public ModelAndView ingredient() {
        if(!done) {
            Unit unit1 = new Unit("Kilogram");
            unit1.setId(0);
            Unit unit2 = new Unit("Liter");
            unit1.setId(1);
            units.add(unit1);
            units.add(unit2);

            Ingredient ingredient1 = new Ingredient("Flour", 10.0, unit1);
            Ingredient ingredient2 = new Ingredient("Cheese", 13.0, unit1);
            Ingredient ingredient3 = new Ingredient("Tomato", 5.0, unit1);
            service.create(ingredient1);
            service.create(ingredient2);
            service.create(ingredient3);
            done = true;
        }

        return new ModelAndView("ingredient/index");
    }
    @RequestMapping("/add")
    public ModelAndView add() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("ingredient/add", model);
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        Map<String, Object> model = new HashMap<>();
        model.put("ingredient", service.read(id));
        model.put("units", units);
        return new ModelAndView("ingredient/edit", model);
    }
}
