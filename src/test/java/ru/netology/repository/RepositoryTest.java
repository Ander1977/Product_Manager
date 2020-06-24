package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repository = new Repository();
    Smartphone first = new Smartphone(1, "Nokia 7plus", 17990, "Finland");
    Smartphone second = new Smartphone(2, "Samsung S10", 40000, "Korea");
    Smartphone third = new Smartphone(3, "Google Pixel 3", 50000, "U.S.A");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind = 2;
        Product expected = second;
        Product actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldIdNotFind() {
        int idToFind = 4;
        repository.findById(idToFind);
        Product expected = null;
        Product actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldIdToRemoveNotFind() {
        int idToRemove = 4;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }


}