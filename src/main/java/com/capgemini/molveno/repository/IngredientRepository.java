package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class IngredientRepository {
    // Public used for testing
    public static int id = 1;
    private Map<Integer, Ingredient> store = new HashMap<>();

    public Ingredient save(Ingredient ingredient) {
        if (store.containsKey(ingredient.getId())) {
            store.put(ingredient.getId(), ingredient);
        } else {
            store.put(id, ingredient);
            ingredient.setId(id);
            id ++;
        }

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
