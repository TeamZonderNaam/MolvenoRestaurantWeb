package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    // create
    public Table create(Table newTable) {
        return this.tableRepository.save(newTable);
    }

    // list
    public Iterable<Table> getAll() {
        return this.tableRepository.findAll();
    }

    // findByNumber
    //public Optional<Table> findByNumber(long id) {
        //return this.tableRepository.findById(id);
    //}

    // updateByNumber
    //public Table updateByNumber(int number, Table newTable) {
        //return this.tableRepository.;
    //}

    // deleteById
    public void deleteById(long id) {
        this.tableRepository.deleteById(id);
    }
}
