package com.capgemini.molveno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("reservationmanagementcontroller")
@RequestMapping("/reservationmanagement")
public class ReservationManagementController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Reservation Management");
        return "data/reservationmanagement/index";
    }
}
