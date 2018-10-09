package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.UnitRepositoryStub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class UnitServiceTest {
    @InjectMocks
    private UnitService unitService;

    @Before
    public void index() {
        UnitRepositoryStub unitRepository = new UnitRepositoryStub();
        unitService.setRepository(unitRepository);
    }

    @Test
    public void allTest() {
        assertEquals(0, unitService.all().size());

        unitService.create(new Unit("Kilogram"));
        unitService.create(new Unit("Gram"));
        unitService.create(new Unit("Liter"));

        assertEquals(3, unitService.all().size());
    }

    @Test
    public void getTest() {
        unitService.create(new Unit("Kilogram"));
        unitService.create(new Unit("Gram"));
        unitService.create(new Unit("Liter"));

        Unit unit = unitService.read(1);
        assertEquals(1, unit.getId());
        assertEquals("Kilogram", unit.getName());

        unit = unitService.read(2);
        assertEquals(2, unit.getId());
        assertEquals("Gram", unit.getName());

        unit = unitService.read(3);
        assertEquals(3, unit.getId());
        assertEquals("Liter", unit.getName());

    }

    @Test
    public void createTest() {
        Unit unit = new Unit("Meter");
        int a = unitService.create(unit);
        assertEquals(1, 1);
        assertEquals(1, unit.getId());
    }

    @Test
    public void updateTest() {
        Unit unit = new Unit("Meter");
        Unit update = new Unit("Liter");
        int newId = unitService.create(unit);
        update.setId(newId);

        update = unitService.update(update);

        assertEquals(unit.getId(), update.getId());
        assertNotEquals(unit.getName(), update.getName());
    }

    @Test
    public void deleteTest() {
        Unit unit = new Unit("Meter");
        int newId = unitService.create(unit);

        assertEquals(1, unitService.all().size());
        unitService.delete(newId);
        assertEquals(0, unitService.all().size());
    }
}
