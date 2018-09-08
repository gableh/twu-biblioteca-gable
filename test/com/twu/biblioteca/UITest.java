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
        UI.displayMessage(UIEnum.WELCOME_MESSAGE);
        assertEquals("Welcome!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAnOptionListMessage() {
        UI.displayMessage(UIEnum.OPTION_LIST);
        assertEquals("List of available options.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAnInvalidOptionMessage() {
        UI.displayMessage(UIEnum.OPTION_INVALID);
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAReturnFailMessage() {
        UI.displayMessage(UIEnum.RETURN_FAIL);
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayACheckoutFailMessage() {
        UI.displayMessage(UIEnum.CHECKOUT_FAIL);
        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAReturnSuccessMessage() {
        UI.displayMessage(UIEnum.RETURN_SUCCESS);
        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayACheckoutSuccessMessage() {
        UI.displayMessage(UIEnum.CHECKOUT_SUCCESS);
        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

}
