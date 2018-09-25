package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class IngredientRepository {
    private static int id = 0;
    private Map<Integer, Ingredient> store = new HashMap<>();

    public Ingredient save(Ingredient ingredient) {
        store.put(id++, ingredient);
        ingredient.setId(id);
        return ingredient;
    }

    public Iterable<Ingredient> findAll() {
        return store.values();
    }

    public Optional<Ingredient> findById(final int id) {
        Optional<Ingredient> optional = Optional.empty();

        if (store.containsKey(id)) {
            optional = Optional.of(store.get(id));
        }

        return optional;
    }

    public void deleteById(final int id) {
        if (store.containsKey(id)) {
            store.remove(id);
        }
    }
}
