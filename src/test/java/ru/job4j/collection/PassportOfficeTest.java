package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void whenNoCitizenThenTrue() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        boolean result = office.add(citizen);
        assertTrue(result);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenHasCitizenThenFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        var result = office.add(citizen);
        assertFalse(result);
    }
}
