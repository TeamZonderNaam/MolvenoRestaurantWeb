package com.capgemini.molveno.service;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.repository.MenuItemRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuItemServiceTest {
    @InjectMocks
    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemRepository;

    private MockMvc mockMvc;

    @Before
    public void configure() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(menuItemService).build();
    }

    @Test
    public void createMenuItemTest() throws Exception {
        MenuItem newItem = new MenuItem();
        newItem.setId(1);
        newItem.setName("dumplings");

        when(menuItemRepository.save(Mockito.any(MenuItem.class))).thenReturn(newItem);

        assertEquals()
    }
}

