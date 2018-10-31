package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Film;
import com.capgemini.molveno.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("film_api_controller")
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    private FilmService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Film> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Film getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Film add(@RequestBody Film film) {
        int id = service.create(film);
        film.setId(id);
        return film;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Film update(@RequestBody Film film) {
        return service.update(film);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }
}
