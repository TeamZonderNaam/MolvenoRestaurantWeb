package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("timeslotcontroller")
@RequestMapping("/timeslot")
public class TimeslotController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Timeslots");
        return "data/reservation/index";
    }
}
