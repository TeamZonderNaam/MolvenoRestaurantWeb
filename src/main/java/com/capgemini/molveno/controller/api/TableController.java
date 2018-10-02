package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Table create(@RequestBody Table newTable) {
        this.tableService.create(newTable);
        return newTable;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Table> list() {
        return this.tableService.getAll();
    }

//    @GetMapping(value = "find/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Table findByNumber(@PathVariable int number) {
//        return this.tableService.findByNumber(number);
//    }
//
//    @PutMapping(value = "update/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Table updateByNumber(@PathVariable int number, @RequestBody Table newTable) {
//        return this.tableService.updateByNumber(number, newTable);
//    }

    @DeleteMapping("delete/{number}")
    public void deleteById(@PathVariable long id) {
        this.tableService.deleteById(id);
    }
}
