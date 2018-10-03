package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Reservation;
import com.capgemini.molveno.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reservation> get() {
        return service.all();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Reservation getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public Reservation create(@RequestBody Reservation reservation) {
        int id = service.create(reservation);
        return service.read(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation update(@PathVariable int id, @RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
