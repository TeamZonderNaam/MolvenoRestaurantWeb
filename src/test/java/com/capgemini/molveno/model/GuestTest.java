package com.capgemini.molveno.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestTest {
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;
    private Guest guest4;

    @Before
    public void init() {
        this.guest1 = new Guest();
        this.guest2 = new Guest();
        this.guest3 = new Guest();
        this.guest4 = new Guest();

        guest1.setName("Sophie Villerius");
        guest2.setFirstName("Jacky");
        guest2.setLastName("Cheung");
        guest3.setLastName("Van Dijk");
        guest4.setFirstName("Anouk");
    }

    @Test
    public void getNameTest() {
        assertEquals("Sophie Villerius", guest1.getName());
        assertEquals("Jacky Cheung", guest2.getName());
        assertEquals("Van Dijk", guest3.getName());
        assertEquals("Anouk", guest4.getName());
    }
}
