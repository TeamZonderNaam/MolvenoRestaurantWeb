package com.capgemini.molveno.controller;

import com.capgemini.molveno.controller.api.IngredientController;
import com.capgemini.molveno.controller.api.UnitController;
import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.service.IngredientService;
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
public class IngredientControllerTest {
    @InjectMocks
    private IngredientController controller;

    @Mock
    private IngredientService ingredientService;

    private List<Ingredient> ingredients;

    private MockMvc mockMvc;

    @Before
    public void index() {
        Unit unit = new Unit("Gram");
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Ingredient 1", 1D, unit));
        ingredients.add(new Ingredient("Ingredient 2", 2D, unit));
        ingredients.add(new Ingredient("Ingredient 3", 3D, unit));


        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(ingredientService.all()).thenReturn(ingredients);

        when(ingredientService.read(1)).thenReturn(ingredients.get(0));
        when(ingredientService.read(2)).thenReturn(ingredients.get(1));
        when(ingredientService.read(3)).thenReturn(ingredients.get(2));
        when(ingredientService.read(Mockito.intThat(id -> id > 2))).thenReturn(null);

        when(ingredientService.create(Mockito.any(Ingredient.class))).thenReturn(0);
        when(ingredientService.update(Mockito.anyInt(), Mockito.any(Ingredient.class))).then(AdditionalAnswers.returnsSecondArg());
    }

    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(
                get("/api/ingredient/").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(ingredients.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(ingredients.get(0).getName()))
                .andExpect(jsonPath("$[0].pricePerUnit").value(ingredients.get(0).getPricePerUnit()))
                .andExpect(jsonPath("$[0].unit.id").value(ingredients.get(0).getUnit().getId()))
                .andExpect(jsonPath("$[0].unit.name").value(ingredients.get(0).getUnit().getName()))
                .andExpect(jsonPath("$[1].id").value(ingredients.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(ingredients.get(1).getName()))
                .andExpect(jsonPath("$[1].pricePerUnit").value(ingredients.get(1).getPricePerUnit()))
                .andExpect(jsonPath("$[1].unit.id").value(ingredients.get(1).getUnit().getId()))
                .andExpect(jsonPath("$[1].unit.name").value(ingredients.get(1).getUnit().getName()))
                .andExpect(jsonPath("$[2].id").value(ingredients.get(2).getId()))
                .andExpect(jsonPath("$[2].name").value(ingredients.get(2).getName()))
                .andExpect(jsonPath("$[2].pricePerUnit").value(ingredients.get(2).getPricePerUnit()))
                .andExpect(jsonPath("$[2].unit.id").value(ingredients.get(2).getUnit().getId()))
                .andExpect(jsonPath("$[2].unit.name").value(ingredients.get(2).getUnit().getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ingredients.get(0));

        this.mockMvc.perform(
                post("/api/ingredient/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(ingredients.get(0).getId()))
                .andExpect(jsonPath("$.name").value(ingredients.get(0).getName()))
                .andExpect(jsonPath("$.pricePerUnit").value(ingredients.get(0).getPricePerUnit()))
                .andExpect(jsonPath("$.unit.id").value(ingredients.get(0).getUnit().getId()))
                .andExpect(jsonPath("$.unit.name").value(ingredients.get(0).getUnit().getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void putTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ingredients.get(0));

        this.mockMvc.perform(
                put("/api/ingredient/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(ingredients.get(0).getId()))
                .andExpect(jsonPath("$.name").value(ingredients.get(0).getName()))
                .andExpect(jsonPath("$.pricePerUnit").value(ingredients.get(0).getPricePerUnit()))
                .andExpect(jsonPath("$.unit.id").value(ingredients.get(0).getUnit().getId()))
                .andExpect(jsonPath("$.unit.name").value(ingredients.get(0).getUnit().getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ingredients.get(0));

        this.mockMvc.perform(
                delete("/api/ingredient/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
