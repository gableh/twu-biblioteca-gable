package com.twu.biblioteca.store;

import com.twu.biblioteca.object.Movie;

public class MovieStore {
    public static Movie[] get() {
        Movie m1 = new Movie("movie1", "d1", 1993, 5);
        Movie m2 = new Movie("movie2", "d2", 1994, 6);
        Movie m3 = new Movie("movie3", "d3", 1995, 7);
        Movie m4 = new Movie("movie4", "d4", 1996, 8);

        Movie[] movies = {m1, m2, m3, m4};
        return movies;
    }
}
