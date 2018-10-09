package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UnitService {
    private UnitRepository repository;

    @Autowired
    public void setRepository(UnitRepository repository) {
        this.repository = repository;
    }

    public int create(Unit unit) {
        Unit created = repository.save(unit);
        return created.getId();
    }

    public List<Unit> all() {
        Iterable<Unit> iterable = repository.findAll();
        List<Unit> units = new ArrayList<>();
        iterable.forEach(units::add);
        return units;
    }

    public Unit read(final int id) {
        Optional<Unit> unit = repository.findById(id);
        if (unit.isPresent()) {
            return unit.get();
        }

        return null;
    }

    public Unit update(Unit unit) {
        return repository.save(unit);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
