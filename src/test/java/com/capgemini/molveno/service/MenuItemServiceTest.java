package com.capgemini.molveno.service;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.repository.MenuItemRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuItemServiceTest {
    @InjectMocks
    private MenuItemService service;

    @Mock
    private MenuItemRepository repository;

    @Before
    public void configure() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createMenuItemTest() throws Exception {
        MenuItem newItem = new MenuItem();

        newItem.setId(1);
        newItem.setName("dumplings");

        when(repository.save(Mockito.any(MenuItem.class))).thenReturn(newItem);

        //verify that the item has been created
        assertThat(service.create(newItem), is(notNullValue()));

        //verify that the save method has been invoked only one time
        verify(repository, times(1)).save(Mockito.any(MenuItem.class));

        //verify that the delete method has never been invoked
        verify(repository, never()).deleteById(Mockito.any(Integer.class));

        assertEquals(1, service.create(newItem));
    }

    @Test
    public void allMenuItemTest() throws Exception {
        MenuItem newItem = new MenuItem();
        newItem.setId(1);
        newItem.setName("dumplings");
        MenuItem newItem2 = new MenuItem();
        newItem.setId(2);
        newItem.setName("pizza");

        List<MenuItem> newItems = new ArrayList<>();

        newItems.add(newItem);
        newItems.add(newItem2);

        when(repository.findAll()).thenReturn(newItems);

        //verify that the list in the repository has been created
        assertThat(service.all(), is(notNullValue()));

        //verify that the findAll method has been invoked only one time
        verify(repository, times(1)).findAll();

        //check whether the size is indeed two
        assertEquals(2, service.all().size());
    }

    @Test
    public void readMenuItemTest() {
        MenuItem newItem = new MenuItem();
        newItem.setId(1);
        newItem.setName("dumplings");
        MenuItem newItem2 = new MenuItem();
        newItem.setId(2);
        newItem.setName("pizza");

        List<MenuItem> newItems = new ArrayList<>();

        newItems.add(newItem);
        newItems.add(newItem2);

        //the below code doesn't work maybe because findById should return an optional?
        when(repository.findById(1)).thenReturn(Optional.of(newItem));
        when(repository.findById(2)).thenReturn(Optional.of(newItem2));

        //verify that the list in the repository has been created and that there are two items
        assertThat(service.read(1), is(notNullValue()));
        assertThat(service.read(2), is(notNullValue()));
        assertNull(service.read(3));

        //verify that the read method has been invoked only one time
        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).findById(2);
    }

    @Test
    public void updateMenuItemTest() {
        MenuItem newItem = new MenuItem();
        newItem.setId(1);
        newItem.setName("dumplings");
        newItem.setCategory("Food");
        newItem.setNumber(22);
        newItem.setPrice(14.0);
        MenuItem newItem2 = new MenuItem();
        newItem2.setName("pizza");

        when(repository.findById(1)).thenReturn(Optional.of(newItem));
        when(repository.save(Mockito.any(MenuItem.class))).then(AdditionalAnswers.returnsFirstArg());

        //check whether the first item has been placed in the correct place
        assertEquals("dumplings", service.read(1).getName());

        //update newItem to newItem2
        service.update(1, newItem2);

        //check whether the name has changed
        assertEquals("pizza", service.read(1).getName());

        //check whether category hsa stayed the same
        assertEquals("Food", service.read(1).getCategory());
    }

    @Test
    public void deleteMenuItemTest() {
        MenuItem newItem = new MenuItem();
        newItem.setId(1);
        newItem.setName("dumplings");
        MenuItem newItem2 = new MenuItem();
        newItem.setId(2);
        newItem.setName("pizza");

        List<MenuItem> newItems = new ArrayList<>();

        newItems.add(newItem);
        newItems.add(newItem2);

        //okay these two lines are a bit pointless, but fun anyway
        when(repository.findAll()).thenReturn(newItems);
        assertEquals(2, service.all().size());

        //this is the real deal
        service.delete(1);

        //assert that deletebyid is invoked only once
        verify(repository, times(1)).deleteById(1);
    }
}

