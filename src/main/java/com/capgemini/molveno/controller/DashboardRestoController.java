package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("dashboardrestocontroller")
@RequestMapping("/dashboardresto")
public class DashboardRestoController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Dashboard");
        return "data/dashboardresto/index";
    }
}



