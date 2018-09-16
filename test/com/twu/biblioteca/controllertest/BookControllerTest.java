package com.twu.biblioteca.controllertest;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.controllers.libraryitem.BookController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BookControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;
    private BookController bookController;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        ByteArrayInputStream in = new ByteArrayInputStream("t1\nt1\n".getBytes());
        System.setIn(in);
        bookController = new BookController();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn( originalIn );
    }

    @Test
    public void itShouldHandleListBook() throws IOException {
        bookController.handle(OptionListEnum.LISTBOOK);
        assertEquals(outContent.toString(), "Currently available for checkout:\n" +
                "------------------------\n" +
                "Title: t1, Author: a1, Year Published: 1993\n" +
                "Title: t2, Author: a2, Year Published: 1994\n" +
                "Title: t3, Author: a3, Year Published: 1995\n" +
                "Title: t4, Author: a4, Year Published: 1996\n" +
                "------------------------\n");
    }
    @Test
    public void itShouldHandleCheckoutBook() throws IOException {
        bookController.handle(OptionListEnum.CHECKOUTBOOK);
        assertEquals("Please enter a book title.\n" +
                "Thank you! Enjoy the book.\n", outContent.toString());
    }
    @Test
    public void itShouldHandleReturnBook() throws IOException {
        bookController.handle(OptionListEnum.CHECKOUTBOOK);
        bookController.handle(OptionListEnum.RETURNBOOK);
        assertEquals("Please enter a book title.\n" +
                "Thank you! Enjoy the book.\n" +
                "Please enter a book title.\n" +
                "Thank you for returning the book.\n", outContent.toString());
    }
}
