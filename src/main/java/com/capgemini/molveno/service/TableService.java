package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    // create
    public Table create(Table newTable) {
        return this.tableRepository.save(newTable);
    }

    // list
    public Collection<Table> list() {
        return this.tableRepository.findAll();
    }

    // findByNumber
    public Table findByNumber(int number) {
        return this.tableRepository.findByNumber(number);
    }

    // updateByNumber
    public Table updateByNumber(int number, Table newTable) {
        return this.tableRepository.updateByNumber(number, newTable);
    }

    // deleteByNumber
    public Table deleteByNumber(int number) {
        return this.tableRepository.deleteByNumber(number);
    }
}
