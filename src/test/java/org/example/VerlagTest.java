package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerlagTest {
    Verlag v;

    @BeforeEach
    void setUp() {
        v = new Verlag();
    }

    @Test
    void berechneKurzenString() {
        assertEquals(1.0, v.berechneHonorar("1234567890"));
    }
    @Test
    void berechneSehrKurzenString() {
        assertEquals(0.1, v.berechneHonorar("1"));
    }
    @Test
    void berechneLeererString() {
        assertEquals(0, v.berechneHonorar(""));
    }
    @Test
    void berechneLangerString() {
        assertEquals(13.4, v.berechneHonorar("abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz"));
    }
    @Test
    void berechneNULL() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {v.berechneHonorar(null);
                });
    }

    @Test
    void zaehleBilderNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {v.zaehleBilder(null);
                });
    }
    @Test
    void zaehleBilder0() {
        assertEquals(0, v.zaehleBilder("dies ist kein Bild"));
    }
    @Test
    void zaehleBilder2() {
        assertEquals(2, v.zaehleBilder("dies sind zwei Bilder picTure Picture"));
    }

}