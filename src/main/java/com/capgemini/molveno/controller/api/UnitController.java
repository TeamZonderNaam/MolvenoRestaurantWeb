package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController ("unit_api_controller")
@RequestMapping("/api/unit")
public class UnitController {
    @Autowired
    private UnitService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Unit> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Unit getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Unit add(@RequestBody Unit unit) {
        int id = service.create(unit);
        unit.setId(id);
        return unit;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Unit update(@RequestBody Unit unit) {
        return service.update(unit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }
}
