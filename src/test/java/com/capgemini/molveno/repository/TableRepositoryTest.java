package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Table;
import com.capgemini.molveno.model.TableShape;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnit4.class)
public class TableRepositoryTest {

    private TableRepository tableRepository = new TableRepository();

   @Test
    public void testSave() {
        int tableNumber = 10;
        Table newTable = new Table(tableNumber, 10, TableShape.ROUND);
        Table savedTable = tableRepository.save(newTable);

        assertEquals(tableNumber, savedTable.getNumber());
    }

    // No further unit tests needed.
}
