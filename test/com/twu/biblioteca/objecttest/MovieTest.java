package com.twu.biblioteca.objecttest;

import com.twu.biblioteca.object.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {
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
    public void itShouldReturnDirectorName() {
        Movie movie = new Movie("Movie1", "Director1", 1993, 3);
        assertEquals("Director1", movie.getDirectorName());
    }

    @Test
    public void itShouldReturnYearReleased() {
        Movie movie = new Movie("Movie1", "Director1", 1993, 3);
        assertEquals(1993, movie.getYearReleased());
    }

    @Test
    public void itShouldBeAbleToCompareWithEachOther() {
        Movie movie1 = new Movie("Movie1", "Director1", 1993, 3);
        Movie movie2 = new Movie("Movie1", "Director1", 1993, 3);
        Movie movie3 = new Movie("Movie2", "Director2", 1993, 3);

        assertEquals(movie1, movie2);
        assertNotEquals(movie2, movie3);
    }

    @Test
    public void itShouldPrintAProperlyFormattedMovieString() {
        Movie movie1 = new Movie("Movie1", "Director1", 1993, 3);
        assertEquals("Title: Movie1, Director: Director1, Year Released: 1993, Rating: 3", movie1.toString());
    }
}
