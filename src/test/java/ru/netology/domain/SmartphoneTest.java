package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone second = new Smartphone(2, "Samsung S10", 40000, "Korea");

    @Test
    void nameSmartphoneIsTrue() {
        assertTrue(second.matches("Samsung S10"));
    }

    @Test
    void nameSmartphoneIsFalse() {
        assertFalse(second.matches("Motorola"));
    }

    @Test
    void manufacturedSmartphoneIsTrue() {
        assertTrue(second.matches("Korea"));
    }

    @Test
    void manufacturedSmartphoneIsFalse() {
        assertFalse(second.matches("China"));
    }

}