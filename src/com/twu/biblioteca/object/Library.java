package com.twu.biblioteca.object;

import com.twu.biblioteca.store.BookStore;
import com.twu.biblioteca.store.MovieStore;

import java.util.Arrays;

public class Library {

    private Book[] bookCollection;
    private Movie[] movieCollection;

    public Library (BookStore bookstore, MovieStore movieStore) {
        this.bookCollection = bookstore.get();
        this.movieCollection = movieStore.get();
    }

    public Book[] getAvailableBooks() {
        return Arrays.stream(bookCollection).filter(x -> !x.getCheckedOut()).toArray(Book[]::new);
    }
    public Movie[] getAvailableMovies() {
        return Arrays.stream(movieCollection).filter(x -> !x.getCheckedOut()).toArray(Movie[]::new);
    }
    public Book[] findBooksByTitle(String bookTitle){
        return Arrays.stream(bookCollection).filter(x -> x.getTitle().equals(bookTitle)).toArray(Book[]::new);
    }
    public Movie[] findMoviesByTitle(String movieTitle){
        return Arrays.stream(movieCollection).filter(x -> x.getTitle().equals(movieTitle)).toArray(Movie[]::new);
    }
}
