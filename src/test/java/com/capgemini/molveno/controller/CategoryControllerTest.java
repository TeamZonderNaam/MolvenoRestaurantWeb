package com.capgemini.molveno.controller;

import com.capgemini.molveno.controller.api.CategoryController;
import com.capgemini.molveno.model.Category;
import com.capgemini.molveno.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {
    @InjectMocks
    private CategoryController controller;

    @Mock
    private CategoryService categoryService;

    private List<Category> categorys;

    private MockMvc mockMvc;

    @Before
    public void index() {
        categorys = new ArrayList<>();
        categorys.add(new Category("Gram"));
        categorys.add(new Category("Liter"));
        categorys.add(new Category("Kilogram"));


        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(categoryService.all()).thenReturn(categorys);

        when(categoryService.read(Mockito.intThat(id -> id == 0))).thenReturn(categorys.get(0));
        when(categoryService.read(Mockito.intThat(id -> id == 1))).thenReturn(categorys.get(1));
        when(categoryService.read(Mockito.intThat(id -> id > 1))).thenReturn(null);

        when(categoryService.create(Mockito.any(Category.class))).thenReturn(0);
        when(categoryService.update(Mockito.any(Category.class))).then(AdditionalAnswers.returnsFirstArg());
    }

    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(
                get("/api/category/").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(categorys.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(categorys.get(0).getName()))
                .andExpect(jsonPath("$[1].id").value(categorys.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(categorys.get(1).getName()))
                .andExpect(jsonPath("$[2].id").value(categorys.get(2).getId()))
                .andExpect(jsonPath("$[2].name").value(categorys.get(2).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void getSingleTest() throws Exception {
        this.mockMvc.perform(
            get("/api/category/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(categorys.get(1).getId()))
                .andExpect(jsonPath("$.name").value(categorys.get(1).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categorys.get(0));

        this.mockMvc.perform(
                post("/api/category/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(categorys.get(0).getId()))
                .andExpect(jsonPath("$.name").value(categorys.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void putTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categorys.get(0));

        this.mockMvc.perform(
                put("/api/category/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(categorys.get(0).getId()))
                .andExpect(jsonPath("$.name").value(categorys.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categorys.get(0));

        this.mockMvc.perform(
                delete("/api/category/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
