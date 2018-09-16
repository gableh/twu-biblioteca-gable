package com.twu.biblioteca.objecttest;

import com.twu.biblioteca.object.LibraryItem;
import com.twu.biblioteca.object.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryItemTest {
    @Test
    public void itShouldbeAbleToCheckoutAndReturnALibraryItem() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        assertEquals(false, book2.getCheckedOut());
        LibraryItem.checkoutItem(book2);
        assertEquals(true, book2.getCheckedOut());
        LibraryItem.returnItem(book2);
        assertEquals(false, book2.getCheckedOut());
    }

    @Test
    public void itShouldReturnTrueIfCheckoutSuccess() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        assertEquals(true, LibraryItem.checkoutItem(book2));
    }
    @Test
    public void itShouldReturnFalseIfCheckoutFailed() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        LibraryItem.checkoutItem(book2);
        assertEquals(false, LibraryItem.checkoutItem(book2));
    }

    @Test
    public void itShouldReturnTrueIfReturnFailed() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        assertEquals(false, LibraryItem.returnItem(book2));
    }
    @Test
    public void itShouldReturnFalseIfReturnSuccess() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        LibraryItem.checkoutItem(book2);
        assertEquals(true, LibraryItem.returnItem(book2));
    }
}
