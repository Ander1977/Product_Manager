package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book two = new Book(2,"Двенадцать стульев", 200, "И.Ильф,Е.Петров");

    @Test
    void nameBookIsTrue() {
        assertTrue(two.matches("Двенадцать стульев"));
    }

    @Test
    void nameBookIsFalse() {
        assertFalse(two.matches("Двадцать кресел"));
    }

    @Test
    void authorBookIsTrue() {
        assertTrue(two.matches("И.Ильф,Е.Петров"));
    }

    @Test
    void authorBookIsFalse() {
        assertFalse(two.matches("Р.Киплинг"));
    }


}