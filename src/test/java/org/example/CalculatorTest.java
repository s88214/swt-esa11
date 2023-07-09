package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator c;

    @BeforeEach
    void setUp() {
        c = new Calculator();
    }

    @Test
    void add() {
        assertEquals(42, c.add(21,21));
    }

    @Test
    void div() {
        assertEquals(21, c.div(42,2));
    }
    @Test
    void divZero() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {c.div(42,0);
        });
    }

}