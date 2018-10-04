package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Customer;
import com.capgemini.molveno.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("person_api_controller")
@RequestMapping("/api/person")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Customer> get() {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Customer getSingle(@PathVariable(name="id") int id) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer add(@RequestBody Customer customer) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer update(@RequestBody Customer customer) {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody Customer customer) {
        return false;
    }
}
