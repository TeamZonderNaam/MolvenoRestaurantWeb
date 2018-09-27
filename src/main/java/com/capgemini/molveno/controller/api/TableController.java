package com.capgemini.molveno.controller.api;

import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/table")
public class TableController {
    @Autowired
    private TableService tableService;

    @PostMapping
    public Table create(@RequestBody Table newTable) {
        this.tableService.create(newTable);
        return newTable;
    }

    @GetMapping
    public Collection<Table> list() {
        return this.tableService.list();
    }

    @GetMapping("find/{number}")
    public Table findByNumber(@PathVariable int number) {
        return this.tableService.findByNumber(number);
    }

    @PutMapping("update/{number}")
    public Table updateByNumber(@PathVariable int number, @RequestBody Table newTable) {
        return this.tableService.updateByNumber(number, newTable);

    }

    @DeleteMapping("delete/{number}")
    public Table deleteByNumber(@PathVariable int number) {
        return this.tableService.deleteByNumber(number);
    }
}
