package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenArgumentLessZero() {
        int n = -2;
        Fact.calc(n);
    }

    @Test
    public void when5then360() {
        int n = 5;
        int expected = 120;
        int fact = Fact.calc(n);
        assertThat(fact, is(expected));
    }
}
