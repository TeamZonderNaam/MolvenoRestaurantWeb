package com.capgemini.molveno.controller;

import com.capgemini.molveno.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller("menuguestcontroller")
@RequestMapping("/guest/menu")
public class MenuItemGuestController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Menu");
        return "data/menu/guest";
    }
}
