package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController("table_api_controller")
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
    public Iterable<Table> read() {
        return this.tableService.readAll();
    }

    @GetMapping(value = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Table readById(@PathVariable long id) {
        return this.tableService.readById(id);
    }

    @PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Table updateById(@PathVariable long id, @RequestBody Table newTable) {
        return this.tableService.updateById(id, newTable);
    }

    @DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable long id) {
        this.tableService.deleteById(id);
    }
}
