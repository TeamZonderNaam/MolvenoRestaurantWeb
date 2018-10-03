package com.capgemini.molveno.service;

import com.capgemini.molveno.MolvenoApplication;
import com.capgemini.molveno.model.Unit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MolvenoApplication.class)
public class UnitServiceTest {
    @Autowired
    private UnitService unitService;

    // We need to keep a reference of the IDs because we currently add this data to a real database.
    // We will later mock this database and this will not be needed
    private List<Integer> ids = new ArrayList<>();

    @Before
    public void init() {
        int unit1 = unitService.create(new Unit("Kilogram"));
        int unit2 = unitService.create(new Unit("Liter"));
        ids.add(unit1);
        ids.add(unit2);
    }

    @After
    public void after() {
        ids.forEach(unitService::delete);
    }

    @Test
    public void testCreate() {

    }

    @Test
    public void testAll() {
//        List<Unit> units = unitService.all();
//        assertThat(units).hasSize(2);
    }

    @Test
    public void testRead() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}
