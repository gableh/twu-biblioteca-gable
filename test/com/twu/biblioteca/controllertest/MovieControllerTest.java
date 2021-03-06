package com.twu.biblioteca.controllertest;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.controllers.UserController;
import com.twu.biblioteca.controllers.libraryitem.MovieController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MovieControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;
    private MovieController movieController;

    @Before
    public void setUp() {
        UserController.logout();
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
    public void itShouldHandleListMovie() throws IOException {
        movieController.handle(OptionListEnum.LISTMOVIE);
        assertEquals(outContent.toString(), "Currently available for checkout:\n" +
                "------------------------\n" +
                "Title: movie1, Director: d1, Year Released: 1993, Rating: 5\n" +
                "Title: movie2, Director: d2, Year Released: 1994, Rating: 6\n" +
                "Title: movie3, Director: d3, Year Released: 1995, Rating: 7\n" +
                "Title: movie4, Director: d4, Year Released: 1996, Rating: 8\n" +
                "------------------------\n");
    }

    @Test
    public void itShouldHandleCheckoutMovieWhenUserNotLoggedIn() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("movie1\nmovie1\n".getBytes());
        System.setIn(in);
        movieController = new MovieController();
        movieController.handle(OptionListEnum.CHECKOUTMOVIE);
        assertEquals("Please enter a movie title.\n" +
                "You need to login first!\n", outContent.toString());
    }
}
