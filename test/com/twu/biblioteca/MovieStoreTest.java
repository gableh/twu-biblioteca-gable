package com.twu.biblioteca;

import com.twu.biblioteca.object.Movie;
import com.twu.biblioteca.store.MovieStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieStoreTest {
    @Test
    public void getShouldReturnAListOfBooks() {
        MovieStore movieStore = new MovieStore();

        Object[] movies = movieStore.get();

        assertEquals(Movie.class, movies[0].getClass());
    }
}
