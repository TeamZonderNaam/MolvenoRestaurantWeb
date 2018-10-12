package com.capgemini.molveno.service;

import com.capgemini.molveno.exception.NotFoundException;
import com.capgemini.molveno.exception.NumberAlreadyExistsException;
import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    // create
    public Table create(Table newTable) {
        // Check if the table number is unique
        if (uniqueNumber(newTable.getNumber())) {
            return this.tableRepository.save(newTable);
        } else {
            throw new NumberAlreadyExistsException();
        }
    }

    // read
    public Iterable<Table> readAll() {
        return this.tableRepository.findAll();
    }

    // read by id
    public Table readById(long id) {
        Optional<Table> table = tableRepository.findById(id);
        if (table.isPresent()) {
            return table.get();
        } else {
            return null;
        }
    }

    // read by number
    public Table readByNumber(int number) {
        Iterable<Table> tables = readAll();
        for (Table table : tables) {
            if (table.getNumber() == number) {
                return table;
            }
        }
        return null;
    }

    // check if number is unique
    public boolean uniqueNumber(int number) {
        return (readByNumber(number) == null);
    }

    // updateById
    public Table updateById(long id, Table newTable) {
        if (tableRepository.existsById(id) == false) {
            throw new NotFoundException();
        } else {
            Table oldTable = readById(id);
            if (newTable.getNumber() == 0) {

            }
            if (newTable.getNumber() != 0 && newTable.getNumber() != oldTable.getNumber())
                if (uniqueNumber(newTable.getNumber())) {
                    oldTable.setNumber(newTable.getNumber());
                } else {
                    throw new NumberAlreadyExistsException();
                }
            if (newTable.getNumberOfPersons() != 0 && newTable.getNumberOfPersons() != oldTable.getNumberOfPersons()) {
                oldTable.setNumberOfPersons(newTable.getNumberOfPersons());
            }
            if (newTable.getShape() != null && newTable.getShape() != oldTable.getShape()) {
                oldTable.setShape(newTable.getShape());
            }
            return this.tableRepository.save(oldTable);
        }
    }

    // deleteById
    public void deleteById(long id) {
        this.tableRepository.deleteById(id);
    }
}
