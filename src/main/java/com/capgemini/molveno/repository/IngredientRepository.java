package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class IngredientRepository {
    // Public used for testing
    public static int id = 1;
    private Map<Integer, Ingredient> store = new HashMap<>();

    @PostConstruct
    public void init() {
        Unit unit1 = new Unit("Kilogram");
        unit1.setId(0);
        Unit unit2 = new Unit("Liter");
        unit1.setId(1);

        Ingredient ingredient1 = new Ingredient("Flour", 10.0, unit1);
        Ingredient ingredient2 = new Ingredient("Cheese", 13.0, unit1);
        Ingredient ingredient3 = new Ingredient("Tomato", 5.0, unit1);
        save(ingredient1);
        save(ingredient2);
        save(ingredient3);
    }

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
