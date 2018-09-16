package com.twu.biblioteca;

import com.twu.biblioteca.constants.OptionListEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class OptionListEnumTest {
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
    public void itShouldParseCheckoutBookCommand() {
        OptionListEnum e = OptionListEnum.parse("Checkout Book");
        assertEquals(OptionListEnum.CHECKOUTBOOK, e);
    }

    @Test
    public void itShouldParseCheckoutMovieCommand() {
        OptionListEnum e = OptionListEnum.parse("Checkout Movie");
        assertEquals(OptionListEnum.CHECKOUTMOVIE, e);
    }

    @Test
    public void itShouldParseListBooksCommand() {
        OptionListEnum e = OptionListEnum.parse("List Books");
        assertEquals(OptionListEnum.LISTBOOK, e);
    }

    @Test
    public void itShouldParseListMoviesCommand() {
        OptionListEnum e = OptionListEnum.parse("List Movies");
        assertEquals(OptionListEnum.LISTMOVIE, e);
    }

    @Test
    public void itShouldParseReturnBookCommand() {
        OptionListEnum e = OptionListEnum.parse("Return Book");
        assertEquals(OptionListEnum.RETURNBOOK, e);
    }

    @Test
    public void itShouldParseReturnMovieCommand() {
        OptionListEnum e = OptionListEnum.parse("Return Movie");
        assertEquals(OptionListEnum.RETURNMOVIE, e);
    }

    @Test
    public void itShouldParseQuitCommand() {
        OptionListEnum e = OptionListEnum.parse("Quit");
        assertEquals(OptionListEnum.QUIT, e);
    }
    @Test
    public void itShouldParseCaseInsensitiveCommand() {
        OptionListEnum e = OptionListEnum.parse("rEtUrN mOvIe");
        assertEquals(OptionListEnum.RETURNMOVIE, e);
    }
    @Test
    public void itShouldCommandByIntegerOrder() {
        OptionListEnum e = OptionListEnum.parse("1");
        assertEquals(OptionListEnum.LISTBOOK, e);
    }
}