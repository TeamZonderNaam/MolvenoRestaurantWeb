package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.ServingOrder;
import com.capgemini.molveno.service.ServingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/api/servingOrder")
public class ServingOrderController {
    @Autowired
    private ServingOrderService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServingOrder> get() {
        return service.all();
    }

    @RequestMapping(value = "/food", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServingOrder> getFood() {
        return service.allFoodItems();
    }

    @RequestMapping(value = "/drinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServingOrder> getDrinks() {
        return service.allDrinkItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ServingOrder getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ServingOrder add(@RequestBody ServingOrder servingOrder) {
        int id = service.create(servingOrder);
        servingOrder.setId(id);
        return servingOrder;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServingOrder update(@PathVariable int id, @RequestBody ServingOrder servingOrder) {
        return service.update(id, servingOrder);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }


    @RequestMapping(value = "/for/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServingOrder> getFor(@PathVariable("id") final int id) {
        return service.allForOrder(id);
    }

    @RequestMapping(value = "/food/for/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServingOrder> getFoodFor(@PathVariable("id") final int id) {
        return service.allFoodForOrder(id);
    }

    @RequestMapping(value = "/drinks/for/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServingOrder> getDrinksFor(@PathVariable("id") final int id) {
        return service.allDrinksForOrder(id);
    }

    @RequestMapping(value = "/for/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServingOrder addFor(@PathVariable("id") final int id, @RequestBody ServingOrder serving) {
        return service.createForOrder(id, serving);
    }
}
