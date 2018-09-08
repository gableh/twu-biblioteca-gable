package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.object.Library;
import com.twu.biblioteca.store.BookStore;
import org.junit.Test;

public class LibraryTest {
    @Test
    public void getCollectionShouldReturnAllAvailableLibraryBooks() {
        Book b1 = new Book("t1", "a1", 1993);
        Book b2 = new Book("t2", "a2", 1994);
        Book b3 = new Book("t3", "a3", 1995);
        Book b4 = new Book("t4", "a4", 1996);

        BookStore bookstore = new BookStore();

        Library library = new Library(bookstore);

        Book[] libraryBooks = library.getAvailableBooks();
        assertEquals(libraryBooks[0], b1);
        assertEquals(libraryBooks[1], b2);
        assertEquals(libraryBooks[2], b3);
        assertEquals(libraryBooks[3], b4);
    }

    @Test
    public void findBooksByTitleShouldReturnAllBooksWithTitle() {
        BookStore bookstore = new BookStore();

        Library library = new Library(bookstore);

        Book[] books = library.findBooksByTitle("t1");

        for (int i = 0; i < books.length; i++) {
            assertEquals("t1", books[i].getTitle());
        }
    }
}
