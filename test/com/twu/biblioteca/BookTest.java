package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void itShouldReturnAuthorName() {
        Book book = new Book("author", 1993);
        assertEquals("author", book.getAuthorName());
    }

    @Test
    public void itShouldReturnYearPublished() {
        Book book = new Book("author", 1993);
        assertEquals(1993, book.getYearPublished());
    }

}
