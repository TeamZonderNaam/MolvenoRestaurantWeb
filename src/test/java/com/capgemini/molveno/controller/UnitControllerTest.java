package com.capgemini.molveno.controller;

import com.capgemini.molveno.controller.api.UnitController;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.UnitRepository;
import com.capgemini.molveno.service.UnitService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitControllerTest {
    @InjectMocks
    private UnitController controller;

    @Mock
    private UnitService unitService;

    private List<Unit> units;

    private MockMvc mockMvc;

    @Before
    public void index() {
        units = new ArrayList<>();
        units.add(new Unit("Gram"));
        units.add(new Unit("Liter"));
        units.add(new Unit("Kilogram"));


        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(unitService.all()).thenReturn(units);

        when(unitService.read(Mockito.intThat(id -> id == 0))).thenReturn(units.get(0));
        when(unitService.read(Mockito.intThat(id -> id == 1))).thenReturn(units.get(1));
        when(unitService.read(Mockito.intThat(id -> id > 1))).thenReturn(null);

        when(unitService.create(Mockito.any(Unit.class))).thenReturn(0);
        when(unitService.update(Mockito.any(Unit.class))).then(AdditionalAnswers.returnsFirstArg());
    }

    @Test
    public void getAllTest() throws Exception {
        this.mockMvc.perform(
                get("/api/unit/").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(units.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(units.get(0).getName()))
                .andExpect(jsonPath("$[1].id").value(units.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(units.get(1).getName()))
                .andExpect(jsonPath("$[2].id").value(units.get(2).getId()))
                .andExpect(jsonPath("$[2].name").value(units.get(2).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void getSingleTest() throws Exception {
        this.mockMvc.perform(
            get("/api/unit/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(units.get(1).getId()))
                .andExpect(jsonPath("$.name").value(units.get(1).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(units.get(0));

        this.mockMvc.perform(
                post("/api/unit/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(units.get(0).getId()))
                .andExpect(jsonPath("$.name").value(units.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void putTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(units.get(0));

        this.mockMvc.perform(
                put("/api/unit/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(units.get(0).getId()))
                .andExpect(jsonPath("$.name").value(units.get(0).getName()))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(units.get(0));

        this.mockMvc.perform(
                delete("/api/unit/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
