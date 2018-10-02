package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MenuItemRepositoryTest {
    private MenuItem menuItem1 = new MenuItem("pizza", 10,1);
    private MenuItem menuItem2 = new MenuItem("pasts", 20,2);
    private MenuItem menuItem3 = new MenuItem("fish", 30,3);
    private MenuItem menuItem4 = new MenuItem("meat", 40,4);

    private MenuItemRepository menuItemRepository;

    @Before
    public void init() {
        menuItemRepository = new MenuItemRepository();
    }

    @Test
    public void testSave() {
        Collection<MenuItem> newRepository = menuItemRepository.findAll();
        //check if you start with an empty repository
        assertTrue(newRepository.isEmpty());

        menuItemRepository.save(menuItem1);
        menuItemRepository.save(menuItem2);
        menuItemRepository.save(menuItem3);
        menuItemRepository.save(menuItem4);

        //check if the repository is filled and has the right size
        assertEquals(4, newRepository.size());
        assertNotEquals(5, newRepository.size());
        assertFalse(newRepository.isEmpty());

        List<MenuItem> newList = new ArrayList<MenuItem>(newRepository);

        assertEquals(newList.get(0).getId(),(1));
        assertEquals(newList.get(1).getId(),(2));
        assertEquals(newList.get(2).getId(),(3));
        assertEquals(newList.get(3).getId(),(4));
    }

    @Test
    public void testFindAll() { //these two methods are now circular
        Collection<MenuItem> newRepository = menuItemRepository.findAll();
        //check if you start with an empty repository
        assertTrue(newRepository.isEmpty());

        MenuItem menuItemcreated1 = menuItemRepository.save(menuItem1);
        MenuItem menuItemcreated2 = menuItemRepository.save(menuItem2);
        MenuItem menuItemcreated3 = menuItemRepository.save(menuItem3);
        MenuItem menuItemcreated4 = menuItemRepository.save(menuItem4);

        //check if the repository is filled and has the right size
        assertEquals(4, newRepository.size());
        assertNotEquals(5, newRepository.size());
        assertFalse(newRepository.isEmpty());

        List<MenuItem> newList = new ArrayList<MenuItem>(newRepository);

        assertEquals(menuItemcreated1.getId(),(1));
        assertEquals(menuItemcreated2.getId(),(2));
        assertEquals(menuItemcreated3.getId(),(3));
        assertEquals(menuItemcreated4.getId(),(4));

        assertEquals(newList.get(0).getId(),menuItemcreated1.getId());
        assertEquals(newList.get(1).getId(),menuItemcreated2.getId());
        assertEquals(newList.get(2).getId(),menuItemcreated3.getId());
        assertEquals(newList.get(3).getId(),menuItemcreated4.getId());
    }

    @Test
    public void testFindById() {
        Collection<MenuItem> newRepository = menuItemRepository.findAll();

        MenuItem menuItemcreated1 = menuItemRepository.save(menuItem1);
        MenuItem menuItemcreated2 = menuItemRepository.save(menuItem2);
        MenuItem menuItemcreated3 = menuItemRepository.save(menuItem3);
        MenuItem menuItemcreated4 = menuItemRepository.save(menuItem4);

        assertEquals(menuItemcreated1.getId(),(1));
        assertEquals(menuItemcreated2.getId(),(2));
        assertEquals(menuItemcreated3.getId(),(3));
        assertEquals(menuItemcreated4.getId(),(4));

        Optional<MenuItem> item1 = menuItemRepository.findById(menuItemcreated1.getId());

        assertNotNull(item1.get());
        assertTrue(item1.isPresent());
        assertSame(item1.get().getId(),menuItemcreated1.getId());
        //this one doesn't work
        assertEquals(menuItemRepository.findById(1),Optional.of(menuItemcreated1));
    }

    @Test
    public void testDeleteById() {

        Collection<MenuItem> newRepository = menuItemRepository.findAll();

        MenuItem menuItemcreated1 = menuItemRepository.save(menuItem1);
        MenuItem menuItemcreated2 = menuItemRepository.save(menuItem2);
        MenuItem menuItemcreated3 = menuItemRepository.save(menuItem3);
        MenuItem menuItemcreated4 = menuItemRepository.save(menuItem4);

        assertEquals(menuItemcreated1.getId(),(1));
        assertEquals(menuItemcreated2.getId(),(2));
        assertEquals(menuItemcreated3.getId(),(3));
        assertEquals(menuItemcreated4.getId(),(4));

        menuItemRepository.deleteById(1);

//        assertNull(menuItemRepository.findById(1));
        List<MenuItem> newList = new ArrayList<MenuItem>(newRepository);

        Optional<MenuItem> item2 = menuItemRepository.findById(menuItemcreated2.getId());

        //kijken of item2 nu op plaats 1 staat
        assertEquals(newList.get(0),menuItemcreated2);

        assertNotNull(item2.get());
        assertTrue(item2.isPresent());
        assertSame(item2.get().getId(),menuItemcreated2.getId());
        assertEquals(menuItemRepository.findById(2),Optional.of(menuItemcreated2));

    }
}
