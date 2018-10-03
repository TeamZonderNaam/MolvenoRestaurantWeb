package com.capgemini.molveno.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("ingredient_controller")
@RequestMapping("/ingredient")
public class IngredientController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Ingredient");
        return "data/ingredient/index";
    }
}
