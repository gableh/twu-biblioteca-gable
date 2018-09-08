package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookStoreTest {
    @Test
    public void getShouldReturnAListOfBooks() {
        Book book1 = new Book("book2", "author", 1993);
        Book book2 = new Book("book2", "author", 1993);
        Book book3 = new Book("book3", "author", 1993);

        BookStore bookStore = new BookStore();

        Object[] books = bookStore.get();

        assertEquals(Book.class, books[0].getClass());
    }
}
