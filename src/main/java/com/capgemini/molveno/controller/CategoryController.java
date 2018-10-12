package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("categorycontroller")
@RequestMapping("/category")
public class CategoryController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Category");
        return "data/category/index";
    }
}
