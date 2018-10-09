package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Unit;
import org.springframework.boot.test.context.TestComponent;

import java.util.*;

@TestComponent
public class UnitRepositoryStub implements UnitRepository {
    private Map<Integer, Unit> map;
    private int id;

    public UnitRepositoryStub() {
        map = new HashMap<>();
        id = 1;
    }

    @Override
    public <S extends Unit> S save(S s) {
        if (existsById(s.getId())) {
            map.put(s.getId(), s);
        } else {
            map.put(id, s);
            s.setId(id);
            id ++;
        }

        return s;
    }

    @Override
    public <S extends Unit> Iterable<S> saveAll(Iterable<S> iterable) {
        List<S> arr = new ArrayList<>();
        for (S s : iterable) {
            arr.add(save(s));
        }
        return arr;
    }

    @Override
    public Optional<Unit> findById(Integer integer) {
        for (Map.Entry<Integer, Unit> entry: map.entrySet()) {
            if (entry.getKey().equals(integer)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        for (Map.Entry<Integer, Unit> entry: map.entrySet()) {
            if (entry.getKey().equals(integer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Unit> findAll() {
        return map.values();
    }

    @Override
    public Iterable<Unit> findAllById(Iterable<Integer> iterable) {
        List<Unit> arr = new ArrayList<>();
        for (Map.Entry<Integer, Unit> entry: map.entrySet()) {
            for(Integer id : iterable) {
                if (entry.getKey().equals(id)) {
                    arr.add(entry.getValue());
                }
            }
        }

        return arr;
    }

    @Override
    public long count() {
        return map.values().size();
    }

    @Override
    public void deleteById(Integer integer) {
        map.remove(integer);
    }

    @Override
    public void delete(Unit unit) {
        map.remove(unit);
    }

    @Override
    public void deleteAll(Iterable<? extends Unit> iterable) {
        for (Unit u : iterable) {
            delete(u);
        }
    }

    @Override
    public void deleteAll() {
        map.clear();
    }
}
