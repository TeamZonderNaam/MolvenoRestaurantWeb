package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Guest;
import com.capgemini.molveno.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: refactor the URLS from person to Guest

@RestController("person_api_controller")
@RequestMapping("/api/person")
public class GuestController {
    @Autowired
    private GuestService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Guest> get() {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Guest getSingle(@PathVariable(name="id") int id) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Guest add(@RequestBody Guest guest) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Guest update(@RequestBody Guest guest) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody Guest guest) {
        return false;
    }
}
