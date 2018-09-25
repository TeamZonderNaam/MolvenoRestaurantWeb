package com.capgemini.molveno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        model.put("hello", "World");
        return new ModelAndView("index", model);
    }
}
