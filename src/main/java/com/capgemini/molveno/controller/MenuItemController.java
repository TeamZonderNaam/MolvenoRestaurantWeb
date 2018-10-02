package com.capgemini.molveno.controller;

import com.capgemini.molveno.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @RequestMapping("/")
    public ResponseEntity<String> index() {
//        return new ModelAndView("index.html");
        return new ResponseEntity<String>("?????", HttpStatus.OK);
    }
}
