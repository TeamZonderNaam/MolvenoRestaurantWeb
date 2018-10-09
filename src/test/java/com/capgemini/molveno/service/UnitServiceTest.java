package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Unit;
import com.capgemini.molveno.repository.UnitRepository;
import com.capgemini.molveno.repository.UnitRepositoryStub;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitServiceTest {
    @InjectMocks
    private UnitService unitService;

    @Mock
    private UnitRepository unitRepository;

    @Before
    public void index() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void allTest() {
        List<Unit> list = new ArrayList<>();
        list.add(new Unit("Kilogram"));
        list.add(new Unit("Gram"));
        list.add(new Unit("Liter"));

        when(unitRepository.findById(1)).thenReturn(Optional.of(list.get(0)));
        when(unitRepository.findById(2)).thenReturn(Optional.of(list.get(1)));
        when(unitRepository.findById(3)).thenReturn(Optional.of(list.get(2)));

        //verify that the list in the repository has been created and that there are two items
        assertThat(unitService.read(1), is(notNullValue()));
        assertThat(unitService.read(2), is(notNullValue()));
        assertThat(unitService.read(3), is(notNullValue()));
        assertNull(unitService.read(4));

        //verify that the read method has been invoked only one time
        verify(unitRepository, times(1)).findById(1);
        verify(unitRepository, times(1)).findById(2);
    }

    @Test
    public void getTest() {
        List<Unit> list = new ArrayList<>();
        list.add(new Unit("Kilogram"));
        list.add(new Unit("Gram"));
        list.add(new Unit("Liter"));

        when(unitRepository.findAll()).thenReturn(list);


        //verify that the list in the repository has been created
        assertThat(unitService.all(), is(notNullValue()));

        //verify that the findAll method has been invoked only one time
        verify(unitRepository, times(1)).findAll();

        //check whether the size is indeed two
        assertEquals(3, unitService.all().size());
    }

    @Test
    public void createTest() {
        Unit unit = new Unit("Meter");
        unit.setId(1);

        when(unitRepository.save(any(Unit.class))).thenReturn(unit);

        //verify that the item has been created
        assertThat(unitService.create(unit), is(notNullValue()));

        //verify that the save method has been invoked only one time
        verify(unitRepository, times(1)).save(Mockito.any(Unit.class));

        //verify that the delete method has never been invoked
        verify(unitRepository, never()).deleteById(Mockito.any(Integer.class));

        assertEquals(1, unitService.create(unit));

    }

    @Test
    public void updateTest() {
        Unit unit = new Unit("Meter");
        unit.setId(1);
        Unit update = new Unit("Liter");
        update.setId(1);

        when(unitRepository.findById(1)).thenReturn(Optional.of(unit));
        when(unitRepository.save(Mockito.any(Unit.class))).then(AdditionalAnswers.returnsFirstArg());

        //check whether the first item has been placed in the correct place
        assertEquals("Meter", unitService.read(1).getName());

        //update newItem to newItem2
        unitService.update(update);

        //check whether name has stayed the same
        assertEquals("Liter", unitService.read(1).getName());
    }

    @Test
    public void deleteTest() {
        List<Unit> list = new ArrayList<>();
        list.add(new Unit("Kilogram"));
        list.add(new Unit("Gram"));
        list.add(new Unit("Liter"));

        //okay these two lines are a bit pointless, but fun anyway
        when(unitRepository.findAll()).thenReturn(list);
        assertEquals(3, unitService.all().size());

        //this is the real deal
        unitService.delete(1);

        //assert that deletebyid is invoked only once
        verify(unitRepository, times(1)).deleteById(1);
    }
}
