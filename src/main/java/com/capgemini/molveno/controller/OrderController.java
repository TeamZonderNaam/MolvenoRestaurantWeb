package com.capgemini.molveno.controller;
import com.capgemini.molveno.model.Order;
import com.capgemini.molveno.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Order");
        return "data/order/index";
    }
}