package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Timeslot;
import com.capgemini.molveno.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController("timeslot_api_controller")
@RequestMapping("/api/timeslot")
public class TimeslotController {
    @Autowired
    private TimeslotService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Timeslot> get() {
        return service.all();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Timeslot getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public Timeslot create(@RequestBody Timeslot timeslot) {
        int id = service.create(timeslot);
        return service.read(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Timeslot update(@PathVariable int id, @RequestBody Timeslot timeslot) {
        return service.update(id, timeslot);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
