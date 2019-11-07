package com.sbt.javaschool.rnd;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestModule {
    @Test
    public void isMan() {
        Person man = new Person(true, "Alexander", 42);
        Person woman = new Person(false, "Ekaterina", 22);

        assertTrue(man.isMan());
        assertFalse(woman.isMan());
    }

    @Test
    public void getSpouseName() {
        Person alexander = new Person(true, "Alexander", 25);
        Person ekaterina = new Person(false, "Ekaterina", 22);
        Person sergei = new Person(true, "Sergei", 27);
        alexander.marry(ekaterina);

        assertEquals(alexander.getSpouseName(), ekaterina.getName());
        assertEquals(ekaterina.getSpouseName(), alexander.getName());
        assertEquals(sergei.getSpouseName(), "—");
    }

    @Test
    public void increaseAge() {
        Person alexander = new Person(true, "Alexander", 25);
        alexander.increaseAge();

        assertEquals(alexander.getAge(), 26);
    }

    @Test
    public void marry() {
        Person sergei = new Person(false, "Sergei", 10);
        Person ekaterina = new Person(false, "Ekaterina", 22);
        Person alexander = new Person(true, "Alexander", 42);
        Person victoria = new Person(false, "Victoria", 20);
        Person anton = new Person(true, "Anton", 86);
        Person olga = new Person(false, "Olga", 18);

        assertFalse(sergei.marry(olga));
        assertFalse(sergei.marry(alexander));
        assertFalse(victoria.marry(olga));
        assertTrue(alexander.marry(ekaterina));
        assertTrue(victoria.marry(anton));

    }

    @Test
    public void divorce() {
        Person alexander = new Person(true, "Alexander", 25);
        Person ekaterina = new Person(false, "Ekaterina", 22);
        Person sergei = new Person(true, "Sergei", 27);
        alexander.marry(ekaterina);

        assertFalse(sergei.divorce());
        assertTrue(ekaterina.divorce());
        assertTrue(alexander.divorce());
        assertFalse(alexander.divorce());
        assertFalse(ekaterina.divorce());
    }
}
