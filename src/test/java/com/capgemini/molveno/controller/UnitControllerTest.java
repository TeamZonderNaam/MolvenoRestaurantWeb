package com.capgemini.molveno.controller;

import com.capgemini.molveno.controller.api.UnitController;
import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.UnitRepository;
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
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitControllerTest {
    @InjectMocks
    private UnitController controller;

    @Mock
    private UnitRepository unitRepository;

    private List<Unit> units;

    private MockMvc mockMvc;

    @Before
    public void index() {
        units = new ArrayList<>();
        units.add(new Unit("Gram"));
        units.add(new Unit("Liter"));
        units.add(new Unit("Kilogram"));


        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(unitRepository.findAll()).thenReturn(units);

        when(unitRepository.findById(Mockito.intThat(id -> id == 0))).thenReturn(Optional.of(units.get(0)));
        when(unitRepository.findById(Mockito.intThat(id -> id == 1))).thenReturn(Optional.of(units.get(0)));
        when(unitRepository.findById(Mockito.intThat(id -> id > 1))).thenReturn(Optional.empty());

        when(unitRepository.save(Mockito.any(Unit.class))).then(AdditionalAnswers.returnsFirstArg());
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
                .andExpect(jsonPath("$[2].name").value(units.get(2).getName()));
    }
}
