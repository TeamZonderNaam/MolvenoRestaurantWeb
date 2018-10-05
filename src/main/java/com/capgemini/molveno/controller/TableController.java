package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("tablecontroller")
@RequestMapping("/table")
public class TableController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Table");
        return "data/table/index";
    }
}
