package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("unitcontroller")
@RequestMapping("/unit")
public class UnitController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Unit");
        return "data/unit/index";
    }
}
