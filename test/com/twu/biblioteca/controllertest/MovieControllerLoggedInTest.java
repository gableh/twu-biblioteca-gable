package com.twu.biblioteca.controllertest;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.controllers.UserController;
import com.twu.biblioteca.controllers.libraryitem.MovieController;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MovieControllerLoggedInTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;
    private MovieController movieController;

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
        movieController = new MovieController();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void itShouldHandleCheckoutMovieWhenUserLoggedIn() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("movie1\nmovie1\n".getBytes());
        System.setIn(in);
        movieController = new MovieController();
        movieController.handle(OptionListEnum.CHECKOUTMOVIE);
        assertEquals("Please enter a movie title.\n" +
                "Thank you! Enjoy the movie.\n", outContent.toString());
    }

    @Test
    public void itShouldHandleReturnMovieWhenUserLoggedIn() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("movie1\nmovie1\n".getBytes());
        System.setIn(in);
        movieController = new MovieController();
        movieController.handle(OptionListEnum.CHECKOUTMOVIE);
        movieController.handle(OptionListEnum.RETURNMOVIE);
        assertEquals("Please enter a movie title.\n" +
                "Thank you! Enjoy the movie.\n" +
                "Please enter a movie title.\n" +
                "Thank you for returning the movie.\n", outContent.toString());
    }
}
