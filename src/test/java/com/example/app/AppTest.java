package com.example.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testBookCreation() {

        Book book = new Book(
                101,
                "Java Programming",
                "James Gosling"
        );

        assertEquals(101, book.getId());
    }

    @Test
    public void testBookToString() {

        Book book = new Book(
                102,
                "Maven Essentials",
                "John Doe"
        );

        String expected =
                "Book ID: 102 | Name: Maven Essentials | Author: John Doe";

        assertEquals(expected, book.toString());
    }
}
