package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Serving;
import com.capgemini.molveno.service.ServingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serving")
public class ServingController {
    @Autowired
    private ServingService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Serving> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Serving getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Serving add(@RequestBody Serving serving) {
        int id = service.create(serving);
        serving.setId(id);
        return serving;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Serving update(@PathVariable int id, @RequestBody Serving serving) {
        return service.update(id, serving);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }


    @RequestMapping(value = "/for/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Serving> getFor(@PathVariable("id") final int id) {
        return service.allForMenuItem(id);
    }

    @RequestMapping(value = "/for/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Serving addFor(@PathVariable("id") final int id, @RequestBody Serving serving) {
        return service.createForMenuItem(id, serving);
    }
}
