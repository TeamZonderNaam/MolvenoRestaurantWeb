package com.capgemini.molveno.controller;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService service;

    @RequestMapping("/")
    public ModelAndView ingredient() {

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
        return new ModelAndView("ingredient/edit", model);
    }
}
