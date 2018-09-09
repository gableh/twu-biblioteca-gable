package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;

import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.object.Library;
import com.twu.biblioteca.store.BookStore;
import com.twu.biblioteca.store.MovieStore;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
    private BookStore bookStore;
    private MovieStore movieStore;
    private Library library;
    @Before
    public void setup() {
        bookStore = new BookStore();
        movieStore = new MovieStore();
        library = new Library(bookStore, movieStore);
    }

    @Test
    public void getCollectionShouldReturnAllAvailableLibraryItems() {
        Book b1 = new Book("t1", "a1", 1993);
        Book b2 = new Book("t2", "a2", 1994);
        Book b3 = new Book("t3", "a3", 1995);
        Book b4 = new Book("t4", "a4", 1996);

        LibraryItem[] libraryBooks = library.getAvailableItems(LibraryItemTypes.BOOK);
        assertEquals(libraryBooks[0], b1);
        assertEquals(libraryBooks[1], b2);
        assertEquals(libraryBooks[2], b3);
        assertEquals(libraryBooks[3], b4);
    }

    @Test
    public void findItemByTitleShouldReturnAllItemsWithTitle() {
        LibraryItem[] books = library.findItemByTitle("t1", LibraryItemTypes.BOOK);

        for (int i = 0; i < books.length; i++) {
            assertEquals("t1", books[i].getTitle());
        }
    }
}
