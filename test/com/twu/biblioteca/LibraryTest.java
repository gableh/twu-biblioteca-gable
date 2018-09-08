package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LibraryTest {
    @Test
    public void getCollectionShouldReturnAllLibraryBooks() {
        Book b1 = new Book("t1", "a1", 1993);
        Book b2 = new Book("t2", "a2", 1994);
        Book b3 = new Book("t3", "a3", 1995);
        Book b4 = new Book("t4", "a4", 1996);

        Book[] books = {b1, b2, b3, b4};

        Library library = new Library(books);

        Book[] libraryBooks = library.getBooks();
        assertEquals(libraryBooks[0], b1);
        assertEquals(libraryBooks[1], b2);
        assertEquals(libraryBooks[2], b3);
        assertEquals(libraryBooks[3], b4);

    }
}
