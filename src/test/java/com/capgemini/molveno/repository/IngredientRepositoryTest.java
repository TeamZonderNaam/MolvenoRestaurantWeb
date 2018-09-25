package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class IngredientRepositoryTest {
    private IngredientRepository repository = new IngredientRepository();

    private Unit gramUnit = new Unit("Gram");
    private Unit literUnit = new Unit("Liter");

    @Before
    public void init() {
        IngredientRepository.id = 0;
    }

    @Test
    public void testSave() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Test Name");
        ingredient.setPricePerUnit(0.0);
        ingredient.setUnit(literUnit);

        for (int i = 0; i < 10; i ++) {
            Ingredient saved = repository.save(ingredient);
            assertThat(saved.getId()).isEqualTo(i);
        }
    }

    @Test
    public void testFindAll() {
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Name 1");
        ingredient1.setPricePerUnit(1.0);
        ingredient1.setUnit(gramUnit);

        Ingredient created1 = repository.save(ingredient1);
        assertThat(created1.getId()).isEqualTo(0);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Name 1");
        ingredient2.setPricePerUnit(1.0);
        ingredient2.setUnit(gramUnit);

        Ingredient created2 = repository.save(ingredient2);
        assertThat(created2.getId()).isEqualTo(1);


        Iterable<Ingredient> iterableAll = repository.findAll();
        List<Ingredient> all = new LinkedList<>();
        iterableAll.forEach(all::add);

        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0).getId()).isEqualTo(created1.getId());
        assertThat(all.get(1).getId()).isEqualTo(created2.getId());
    }

    @Test
    public void testFindById() {
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Name 1");
        ingredient1.setPricePerUnit(1.0);
        ingredient1.setUnit(gramUnit);

        Ingredient created1 = repository.save(ingredient1);
        assertThat(created1.getId()).isEqualTo(0);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Name 1");
        ingredient2.setPricePerUnit(1.0);
        ingredient2.setUnit(gramUnit);

        Ingredient created2 = repository.save(ingredient2);
        assertThat(created2.getId()).isEqualTo(1);

        Optional<Ingredient> item = repository.findById(created1.getId());
        assertThat(item.isPresent()).isTrue();
        assertThat(item.get()).isNotNull();

        assertThat(item.get().getId()).isEqualTo(created1.getId());
    }

    @Test
    public void testDeleteById() {

    }
}
