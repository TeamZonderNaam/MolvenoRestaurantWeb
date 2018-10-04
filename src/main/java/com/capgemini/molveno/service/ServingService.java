package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Serving;
import com.capgemini.molveno.repository.ServingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServingService {
    @Autowired
    private ServingRepository servingRepository;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private IngredientService ingredientService;

    public int create(Serving serving) {
        Serving created = servingRepository.save(serving);
        return created.getId();
    }

    public List<Serving> all() {
        Iterable<Serving> iterable = servingRepository.findAll();
        List<Serving> servings = new ArrayList<>();
        iterable.forEach(servings::add);
        return servings;
    }

    public Serving read(final int id) {
        Optional<Serving> serving = servingRepository.findById(id);
        if (serving.isPresent()) {
            return serving.get();
        }

        return null;
    }

    public Serving update(int id, Serving serving) {
        Optional<Serving> oldServing = servingRepository.findById(id);
        if (oldServing.isPresent()) {
            if (serving.getIngredient() != null) {
                oldServing.get().setIngredient(serving.getIngredient());
            }
            if (serving.getNumberOfUnits() != 0) {
                oldServing.get().setNumberOfUnits(serving.getNumberOfUnits());
            }
        }

        Serving saved = servingRepository.save(oldServing.get());
        Ingredient ingredient = ingredientService.read(saved.getIngredient().getId());
        System.out.println("New ingredient:"+ingredient);
        saved.setIngredient(ingredient);

        return saved;
    }

    public void delete(final int id) {
        servingRepository.deleteById(id);
    }


    public List<Serving> allForMenuItem(final int id) {
        MenuItem item = menuItemService.read(id);
        if (item != null) {
            return item.getServings();
        } else {
            return new ArrayList<>();
        }
    }

    public Serving createForMenuItem(int id, Serving serving) {
        this.create(serving);

        MenuItem item = menuItemService.read(id);
        if (item != null) {
            item.getServings().add(serving);
            menuItemService.update(id, item);

            int ingredientId = serving.getIngredient().getId();
            serving.setIngredient(
                ingredientService.read(ingredientId)
            );

            return serving;
        } else {
            return null;
        }
    }
}
