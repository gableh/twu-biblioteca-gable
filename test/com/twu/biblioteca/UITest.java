package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UITest {

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
    public void itShouldDisplayAWelcomeMessage() {
        UI.displaySystemMessage(UIEnum.WELCOME_MESSAGE);
        assertEquals("Welcome!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAnOptionListMessage() {
        UI.displaySystemMessage(UIEnum.OPTION_LIST);
        assertEquals("List of available options.\n1. List Books\n2. Quit\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAnInvalidOptionMessage() {
        UI.displaySystemMessage(UIEnum.OPTION_INVALID);
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAReturnFailMessage() {
        UI.displaySystemMessage(UIEnum.RETURN_FAIL);
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayACheckoutFailMessage() {
        UI.displaySystemMessage(UIEnum.CHECKOUT_FAIL);
        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAReturnSuccessMessage() {
        UI.displaySystemMessage(UIEnum.RETURN_SUCCESS);
        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayACheckoutSuccessMessage() {
        UI.displaySystemMessage(UIEnum.CHECKOUT_SUCCESS);
        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAUserInputMessage() {
        UI.displaySystemMessage(UIEnum.USER_INPUT);
        assertEquals("What would you like to do?\n", outContent.toString());
    }


    @Test
    public void displayMessageShouldDisplayObjAsString() {
        Book book1 = new Book("book2", "author", 1993);
        Book book2 = new Book("book2", "author", 1993);
        Book book3 = new Book("book3", "author", 1993);

        Book[] books = {book1, book2, book3};

        UI.displayBooks(books);
        assertEquals("List of Available Books:\n" +
                "------------------------\n" +
                "Title: book2, Author: author, Year Published: 1993\n" +
                "Title: book2, Author: author, Year Published: 1993\n" +
                "Title: book3, Author: author, Year Published: 1993\n" +
                "------------------------\n" , outContent.toString());
    }
}
