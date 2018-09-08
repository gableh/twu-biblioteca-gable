package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void itShouldReturnAuthorName() {
        Book book = new Book("book1","author", 1993);
        assertEquals("author", book.getAuthorName());
    }

    @Test
    public void itShouldReturnYearPublished() {
        Book book = new Book("book2", "author", 1993);
        assertEquals(1993, book.getYearPublished());
    }

    @Test
    public void itShouldBeAbleToCompareWithEachOther() {
        Book book1 = new Book("book2", "author", 1993);
        Book book2 = new Book("book2", "author", 1993);
        Book book3 = new Book("book3", "author", 1993);
        assertEquals(book1, book2);
        assertNotEquals(book2, book3);
    }

}
