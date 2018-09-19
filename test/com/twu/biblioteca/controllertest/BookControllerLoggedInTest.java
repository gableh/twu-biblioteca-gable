package com.twu.biblioteca.controllertest;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.controllers.UserController;
import com.twu.biblioteca.controllers.libraryitem.BookController;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BookControllerLoggedInTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;
    private BookController bookController;

    @BeforeClass
    public static void setUpClass() throws IOException {
        UserController.logout();
        ByteArrayInputStream in = new ByteArrayInputStream("aaa-aaaa\nd1\n".getBytes());
        System.setIn(in);
        UserController.init();
        UserController.handle(OptionListEnum.LOGIN);
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void itShouldHandleCheckoutBookWhenUserLoggedIn() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("t1\nt1\n".getBytes());
        System.setIn(in);
        bookController = new BookController();
        bookController.handle(OptionListEnum.CHECKOUTBOOK);
        assertEquals("Please enter a book title.\n" +
                "Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void itShouldHandleReturnBookWhenUserLoggedIn() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("t1\nt1\n".getBytes());
        System.setIn(in);
        bookController = new BookController();
        bookController.handle(OptionListEnum.CHECKOUTBOOK);
        bookController.handle(OptionListEnum.RETURNBOOK);
        assertEquals("Please enter a book title.\n" +
                "Thank you! Enjoy the book.\n" +
                "Please enter a book title.\n" +
                "Thank you for returning the book.\n", outContent.toString());
    }
}
