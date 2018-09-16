package com.twu.biblioteca.storetest;

import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.store.BookStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookStoreTest {
    @Test
    public void getShouldReturnAListOfBooks() {
        BookStore bookStore = new BookStore();

        Object[] books = bookStore.get();

        assertEquals(Book.class, books[0].getClass());
    }
}
