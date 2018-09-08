package com.twu.biblioteca;

import com.twu.biblioteca.object.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void itShouldReturnAuthorName() {
        Book book = new Book("book1", "author", 1993);
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

    @Test
    public void itShouldPrintAProperlyFormattedBookString() {
        Book book1 = new Book("book2", "author", 1993);
        assertEquals("Title: book2, Author: author, Year Published: 1993", book1.toString());
    }

    @Test
    public void itShouldbeAbleToCheckoutAndReturnABook() {
        Book book2 = new Book("book2", "author", 1993);
        assertEquals(false, book2.getCheckedOut());
        Book.checkout(book2);
        assertEquals(true, book2.getCheckedOut());
        Book.returnBook(book2);
        assertEquals(false, book2.getCheckedOut());
    }

    @Test
    public void itShouldReturnTrueIfCheckoutSuccess() {
        Book book2 = new Book("book2", "author", 1993);
        assertEquals(true, Book.checkout(book2));
    }
    @Test
    public void itShouldReturnFalseIfCheckoutFailed() {
        Book book2 = new Book("book2", "author", 1993);
        Book.checkout(book2);
        assertEquals(false, Book.checkout(book2));
    }

    @Test
    public void itShouldReturnTrueIfReturnFailed() {
        Book book2 = new Book("book2", "author", 1993);
        assertEquals(false, Book.returnBook(book2));
    }
    @Test
    public void itShouldReturnFalseIfReturnSuccess() {
        Book book2 = new Book("book2", "author", 1993);
        Book.checkout(book2);
        assertEquals(true, Book.returnBook(book2));
    }

}
