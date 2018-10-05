package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("reservationcontroller")
@RequestMapping("/reservation")
public class ReservationController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Reserve a Table");
        return "data/reservation/index";
    }
}
