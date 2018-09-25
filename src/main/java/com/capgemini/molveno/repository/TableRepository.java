package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Table;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TableRepository {
    Map<Integer, Table> tables = new HashMap<>();

    // Create
    public Table save(Table newTable) {
        tables.put(newTable.getNumber(), newTable);
        return newTable;
    }

    // Read
    public Collection<Table> findAll() {
        return this.tables.values();
    }

    // Read per number
    public Table findByNumber(int number) {
        return this.tables.get(number);
    }

    // Update
    public Table updateByNumber(int number, Table newTable) {
        Table oldTable = findByNumber(number);
        oldTable.setNumber(newTable.getNumber());
        oldTable.setNumberOfPersons(newTable.getNumberOfPersons());
        oldTable.setShape(newTable.getShape());
        oldTable.setStatus(newTable.getStatus());
        return oldTable; // How to deal with reservations?
    }

    // Delete
    public Table deleteByNumber(int number) {
        return this.tables.remove(number);
    }
}
