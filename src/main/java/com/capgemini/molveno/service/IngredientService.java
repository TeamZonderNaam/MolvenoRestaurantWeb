package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository repository;

    @Autowired
    private UnitService unitService;

    public int create(Ingredient ingredient) {
        Ingredient created = repository.save(ingredient);
        // The returned value of the repository doesn't contain the unit name
        // So get it with the unitService
        created.setUnit(
            unitService.read(created.getUnit().getId())
        );
        return created.getId();
    }

    public List<Ingredient> all() {
        Iterable<Ingredient> iterable = repository.findAll();
        List<Ingredient> ingredients = new ArrayList<>();
        iterable.forEach(ingredients::add);
        return ingredients;
    }

    public Ingredient read(final int id) {
        Optional<Ingredient> ingredient = repository.findById(id);
        if (ingredient.isPresent()) {
            return ingredient.get();
        }

        return null;
    }

    public Ingredient update(int id, Ingredient ingredient) {
        Optional<Ingredient> oldIngredient = repository.findById(id);
        if (oldIngredient.isPresent()) {
            if (ingredient.getName() != null) {
                oldIngredient.get().setName(ingredient.getName());
            }
            if (ingredient.getPricePerUnit() != 0) {
                oldIngredient.get().setPricePerUnit(ingredient.getPricePerUnit());
            }
            if (ingredient.getUnit() != null) {
                oldIngredient.get().setUnit(ingredient.getUnit());
            }
        }
        return repository.save(oldIngredient.get());
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
