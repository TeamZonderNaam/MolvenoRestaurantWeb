package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceTest {
    @Autowired
    private IngredientRepository repository;

    public int create(Ingredient ingredient) {
        Ingredient created = repository.save(ingredient);
        return created.getId();
    }

    public Iterable<Ingredient> all() {
        return repository.findAll();
    }

    public Ingredient read(final int id) {
        Optional<Ingredient> ingredient = repository.findById(id);
        if (ingredient.isPresent()) {
            return ingredient.get();
        }

        return null;
    }

    public Ingredient update(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
