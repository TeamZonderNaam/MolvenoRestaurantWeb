package com.capgemini.molveno.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemTest {
    private MenuItem menuItem1;

    private Ingredient cheese = new Ingredient("cheese", 2.5, new Unit(1));
    private Ingredient basil = new Ingredient("basil", 0.05, new Unit(2));
    private Ingredient tomatoSauce = new Ingredient("tomato sauce", 0.5, new Unit(1));

    private Serving cheeseServing = new Serving(cheese, 0.5);
    private Serving basilServing = new Serving(basil, 150);
    private Serving tomatoSauceServing = new Serving(tomatoSauce, 0.2);

    @Before
    public void init() {
        this.menuItem1 = new MenuItem("pizza", 10,1);
    }

    @Test
    public void testGetCostPrice() {
        List<Serving> servingList = new ArrayList<>();
        menuItem1.setServings(servingList);
        //check if price is zero

        assertEquals(0, menuItem1.getCostPrice());

        servingList.add(cheeseServing);
        servingList.add(basilServing);
        servingList.add(tomatoSauceServing);

        assertEquals(8.85, menuItem1.getCostPrice());

        //add more servings
        servingList.add(cheeseServing);
        servingList.add(basilServing);

        assertEquals(17.6, menuItem1.getCostPrice());

        //change numbers of units of a serving
        cheeseServing.setNumberOfUnits(1);

        assertEquals(20.1, menuItem1.getCostPrice());

    }
}
