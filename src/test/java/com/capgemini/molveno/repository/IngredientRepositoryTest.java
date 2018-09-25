package com.capgemini.molveno.repository;

import com.capgemini.molveno.MolvenoApplication;
import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MolvenoApplication.class})
@WebMvcTest
public class IngredientRepositoryTest {
    private IngredientRepository repository = new IngredientRepository();

    private Unit gramUnit = new Unit("Gram");
    private Unit literUnit = new Unit("Liter");

    @Test
    public void testSave() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Test Name");
        ingredient.setPricePerUnit(0.0);
        ingredient.setUnit(literUnit);

        for (int i = 0; i < 10; i ++) {
            Ingredient saved = repository.save(ingredient);
            assertThat(saved.getId()).isEqualTo(i + 1);
        }
    }

    @Test
    public void testFindAll() {

    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testDeleteById() {

    }
}
