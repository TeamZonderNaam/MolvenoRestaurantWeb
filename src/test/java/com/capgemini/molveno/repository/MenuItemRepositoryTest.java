package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
    public void save() {
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

//        List repositoryList = new ArrayList(newRepository);
//
//        assertNull(repositoryList.get(3));
    }

    @Test
    public void findAll() { //these two methods are now circular
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
    }
}
