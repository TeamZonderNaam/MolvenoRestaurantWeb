package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.IngredientRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IngredientServiceTest {
    @InjectMocks
    private IngredientService ingredientService;

    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private UnitService unitService;

    @Before
    public void index() {
        MockitoAnnotations.initMocks(this);

        List<Unit> list = new ArrayList<>();
        list.add(new Unit("Kilogram"));
        list.add(new Unit("Gram"));
        list.add(new Unit("Liter"));

        when(unitService.read(2)).thenReturn(list.get(1));
    }

    @Test
    public void allTest() {
        Unit unit = new Unit("Gram");
        unit.setId(2);
        List<Ingredient> list = new ArrayList<>();
        list.add(new Ingredient("Ingredient 1", 1D, unit));
        list.add(new Ingredient("Ingredient 2", 2D, unit));
        list.add(new Ingredient("Ingredient 3", 3D, unit));

        when(ingredientRepository.findById(1)).thenReturn(Optional.of(list.get(0)));
        when(ingredientRepository.findById(2)).thenReturn(Optional.of(list.get(1)));
        when(ingredientRepository.findById(3)).thenReturn(Optional.of(list.get(2)));

        //verify that the list in the repository has been created and that there are two items
        assertThat(ingredientService.read(1), is(notNullValue()));
        assertThat(ingredientService.read(2), is(notNullValue()));
        assertThat(ingredientService.read(3), is(notNullValue()));
        assertNull(ingredientService.read(4));

        //verify that the read method has been invoked only one time
        verify(ingredientRepository, times(1)).findById(1);
        verify(ingredientRepository, times(1)).findById(2);
    }

    @Test
    public void getTest() {
        Unit unit = new Unit("Gram");
        unit.setId(2);
        List<Ingredient> list = new ArrayList<>();
        list.add(new Ingredient("Ingredient 1", 1D, unit));
        list.add(new Ingredient("Ingredient 2", 2D, unit));
        list.add(new Ingredient("Ingredient 3", 3D, unit));

        when(ingredientRepository.findAll()).thenReturn(list);


        //verify that the list in the repository has been created
        assertThat(ingredientService.all(), is(notNullValue()));

        //verify that the findAll method has been invoked only one time
        verify(ingredientRepository, times(1)).findAll();

        //check whether the size is indeed two
        assertEquals(3, ingredientService.all().size());
    }

    @Test
    public void createTest() {
        Unit unit = new Unit("Gram");
        unit.setId(2);
        Ingredient ingredient = new Ingredient("Ingredient 1", 1D, unit);
        ingredient.setId(1);

        when(ingredientRepository.save(any(Ingredient.class))).thenReturn(ingredient);

        //verify that the item has been created
        assertThat(ingredientService.create(ingredient), is(notNullValue()));

        //verify that the save method has been invoked only one time
        verify(ingredientRepository, times(1)).save(Mockito.any(Ingredient.class));

        //verify that the delete method has never been invoked
        verify(ingredientRepository, never()).deleteById(Mockito.any(Integer.class));

        assertEquals(1, ingredientService.create(ingredient));

    }

    @Test
    public void updateTest() {
        Unit unit = new Unit("Gram");
        unit.setId(2);
        Ingredient ingredient = new Ingredient("Ingredient 1", 1D, unit);
        ingredient.setId(1);
        Ingredient update = new Ingredient("Ingredient 1 Updated", 1D, unit);
        update.setId(1);

        when(ingredientRepository.findById(1)).thenReturn(Optional.of(ingredient));
        when(ingredientRepository.save(Mockito.any(Ingredient.class))).then(AdditionalAnswers.returnsFirstArg());

        //check whether the first item has been placed in the correct place
        assertEquals("Ingredient 1", ingredientService.read(1).getName());

        //update newItem to newItem2
        ingredientService.update(1, update);

        //check whether name has stayed the same
        assertEquals("Ingredient 1 Updated", ingredientService.read(1).getName());
    }

    @Test
    public void deleteTest() {
        Unit unit = new Unit("Gram");
        unit.setId(2);
        List<Ingredient> list = new ArrayList<>();
        list.add(new Ingredient("Ingredient 1", 1D, unit));
        list.add(new Ingredient("Ingredient 2", 2D, unit));
        list.add(new Ingredient("Ingredient 3", 3D, unit));

        //okay these two lines are a bit pointless, but fun anyway
        when(ingredientRepository.findAll()).thenReturn(list);
        assertEquals(3, ingredientService.all().size());

        //this is the real deal
        ingredientService.delete(1);

        //assert that deletebyid is invoked only once
        verify(ingredientRepository, times(1)).deleteById(1);
    }
}
