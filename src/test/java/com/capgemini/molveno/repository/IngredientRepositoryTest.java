package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

        Ingredient created = repository.save(ingredient1);
        assertThat(created.getId()).isEqualTo(0);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Name 1");
        ingredient2.setPricePerUnit(1.0);
        ingredient2.setUnit(gramUnit);

        created = repository.save(ingredient2);
        assertThat(created.getId()).isEqualTo(1);
    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testDeleteById() {

    }
}
