package ru.netology.manager;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    Repository repository;

    @InjectMocks
    ManagerItem manager;
    Smartphone first = new Smartphone(1, "Nokia 7plus", 17990, "Finland");
    Smartphone second = new Smartphone(2, "Samsung S10", 40000, "Korea");
    Smartphone third = new Smartphone(3, "Google Pixel 3", 50000, "U.S.A");
    Book one = new Book(1, "Дунайский лоцман", 450, "Ж.Верн");
    Book two = new Book(2, "Двенадцать стульев", 200, "И.Ильф,Е.Петров");
    Book three = new Book(3, "Шерлок Холмс", 360, "А.К.Дойл");


    @Test
    void addSmartphone() {
        Product[] returned = new Product[]{first};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addBook() {
        Product[] returned = new Product[]{one};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{one};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addAllSmartphone() {
        Product[] returned = new Product[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{third, second, first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addAllBook() {
        Product[] returned = new Product[]{one, two, three};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{three, two, one};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void findByNameSmartphone() {
        String nameSmartphone = "Nokia 7plus";
        Product[] returned = new Product[]{first};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy(nameSmartphone);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByNameBook() {
        String nameBook = "Дунайский лоцман";
        Product[] returned = new Product[]{one};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{one};
        Product[] actual = manager.searchBy(nameBook);
        assertArrayEquals(expected, actual);
    }


    @Test
    void findByAuthor() {
        String author = "И.Ильф,Е.Петров";
        Product[] returned = new Product[]{two};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{two};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByManufactured() {
        String manufactured = "U.S.A";
        Product[] returned = new Product[]{third};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy(manufactured);
        assertArrayEquals(expected, actual);
    }

    @Test
    void bookNameNotFind() {
        String nameBook = "Война и мир";
        Product[] returned = new Product[]{one};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(nameBook);
        assertArrayEquals(expected, actual);
    }

    @Test
    void smartphoneNameNotFind() {
        String nameSmartphone = "Motorola";
        Product[] returned = new Product[]{third};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(nameSmartphone);
        assertArrayEquals(expected, actual);
    }
}