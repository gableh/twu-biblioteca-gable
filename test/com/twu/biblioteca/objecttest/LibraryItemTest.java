package com.twu.biblioteca.objecttest;

import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.object.LibraryItem;
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
    public void itShouldReturnCHECKOUTSUCCESSIfCheckoutSuccess() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        assertEquals(UIEnum.CHECKOUT_SUCCESS, LibraryItem.checkoutItem(book2));
    }
    @Test
    public void itShouldReturnFalseIfCheckoutFailed() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        LibraryItem.checkoutItem(book2);
        assertEquals(UIEnum.CHECKOUT_FAIL, LibraryItem.checkoutItem(book2));
    }

    @Test
    public void itShouldReturnTrueIfReturnFailed() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        assertEquals(UIEnum.RETURN_FAIL, LibraryItem.returnItem(book2));
    }
    @Test
    public void itShouldReturnFalseIfReturnSuccess() {
        LibraryItem book2 = new Book("book2", "author", 1993);
        LibraryItem.checkoutItem(book2);
        assertEquals(UIEnum.RETURN_SUCCESS, LibraryItem.returnItem(book2));
    }
}
