package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Category;
import com.capgemini.molveno.repository.CategoryRepository;
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
public class CategoryServiceTest {
    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void index() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void allTest() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Appetizers"));
        list.add(new Category("Salads"));
        list.add(new Category("Pizza"));

        when(categoryRepository.findById(1)).thenReturn(Optional.of(list.get(0)));
        when(categoryRepository.findById(2)).thenReturn(Optional.of(list.get(1)));
        when(categoryRepository.findById(3)).thenReturn(Optional.of(list.get(2)));

        //verify that the list in the repository has been created and that there are two items
        assertThat(categoryService.read(1), is(notNullValue()));
        assertThat(categoryService.read(2), is(notNullValue()));
        assertThat(categoryService.read(3), is(notNullValue()));
        assertNull(categoryService.read(4));

        //verify that the read method has been invoked only one time
        verify(categoryRepository, times(1)).findById(1);
        verify(categoryRepository, times(1)).findById(2);
    }

    @Test
    public void getTest() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Appetizers"));
        list.add(new Category("Salads"));
        list.add(new Category("Pizza"));

        when(categoryRepository.findAll()).thenReturn(list);


        //verify that the list in the repository has been created
        assertThat(categoryService.all(), is(notNullValue()));

        //verify that the findAll method has been invoked only one time
        verify(categoryRepository, times(1)).findAll();

        //check whether the size is indeed two
        assertEquals(3, categoryService.all().size());
    }

    @Test
    public void createTest() {
        Category unit = new Category("Appetizers");
        unit.setId(1);

        when(categoryRepository.save(any(Category.class))).thenReturn(unit);

        //verify that the item has been created
        assertThat(categoryService.create(unit), is(notNullValue()));

        //verify that the save method has been invoked only one time
        verify(categoryRepository, times(1)).save(Mockito.any(Category.class));

        //verify that the delete method has never been invoked
        verify(categoryRepository, never()).deleteById(Mockito.any(Integer.class));

        assertEquals(1, categoryService.create(unit));

    }

    @Test
    public void updateTest() {
        Category unit = new Category("Appetizers");
        unit.setId(1);
        Category update = new Category("Salads");
        update.setId(1);

        when(categoryRepository.findById(1)).thenReturn(Optional.of(unit));
        when(categoryRepository.save(Mockito.any(Category.class))).then(AdditionalAnswers.returnsFirstArg());

        //check whether the first item has been placed in the correct place
        assertEquals("Appetizers", categoryService.read(1).getName());

        //update newItem to newItem2
        categoryService.update(update);

        //check whether name has stayed the same
        assertEquals("Salads", categoryService.read(1).getName());
    }

    @Test
    public void deleteTest() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Appetizers"));
        list.add(new Category("Salads"));
        list.add(new Category("Pizza"));

        //okay these two lines are a bit pointless, but fun anyway
        when(categoryRepository.findAll()).thenReturn(list);
        assertEquals(3, categoryService.all().size());

        //this is the real deal
        categoryService.delete(1);

        //assert that deletebyid is invoked only once
        verify(categoryRepository, times(1)).deleteById(1);
    }
}
