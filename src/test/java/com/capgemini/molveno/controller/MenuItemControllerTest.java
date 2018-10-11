package com.capgemini.molveno.controller;

import com.capgemini.molveno.controller.api.MenuItemController;
import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Serving;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.service.MenuItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MenuItemControllerTest {
    @InjectMocks
    private MenuItemController controller;

    @Mock
    private MenuItemService service;

    private List<MenuItem> items;
    private List<Unit> units;
    private List<Serving> servings;

    private MockMvc mockMvc;

    @Before
    public void configure() {
        items = new ArrayList<>();

        MenuItem newItem = new MenuItem();
        newItem.setName("pizza");
        MenuItem newItem2 = new MenuItem();
        newItem2.setName("dumplings");

        items.add(newItem);
        items.add(newItem2);

        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(service.all()).thenReturn(items);

        when(service.read(1)).thenReturn(items.get(0));

        when(service.create(Mockito.any(MenuItem.class))).thenReturn(0);
        when(service.update(Mockito.anyInt(), Mockito.any(MenuItem.class))).then(AdditionalAnswers.returnsSecondArg());
    }

    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(
                get("/api/menuItem/").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(items.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(items.get(0).getName()))
                .andExpect(jsonPath("$[1].id").value(items.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(items.get(1).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void getSingleTest() throws Exception {
        this.mockMvc.perform(
                get("/api/menuItem/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(items.get(0).getId()))
                .andExpect(jsonPath("$.name").value(items.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items.get(0));

        this.mockMvc.perform(
                post("/api/menuItem/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(items.get(0).getId()))
                .andExpect(jsonPath("$.name").value(items.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void putTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items.get(0));

        this.mockMvc.perform(
                put("/api/menuItem/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(items.get(0).getId()))
                .andExpect(jsonPath("$.name").value(items.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items.get(0));

        this.mockMvc.perform(
                delete("/api/menuItem/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
