package com.twu.biblioteca.object;

import com.twu.biblioteca.LibraryItem;
import com.twu.biblioteca.LibraryItemTypes;
import com.twu.biblioteca.store.BookStore;
import com.twu.biblioteca.store.MovieStore;

import java.util.Arrays;

public class Library {

    private Book[] bookCollection;
    private Movie[] movieCollection;
    LibraryItem[] collection;
    public Library (BookStore bookstore, MovieStore movieStore) {
        this.bookCollection = bookstore.get();
        this.movieCollection = movieStore.get();
    }

    public LibraryItem[] getAvailableItems(LibraryItemTypes type) {
        setCollectionByType(type);
        return Arrays.stream(collection).filter(x -> !x.getCheckedOut()).toArray(LibraryItem[]::new);
    }

    public LibraryItem[] findItemByTitle(String title, LibraryItemTypes type){
        setCollectionByType(type);
        return Arrays.stream(collection).filter(x -> x.getTitle().equals(title)).toArray(LibraryItem[]::new);
    }

    private void setCollectionByType(LibraryItemTypes type) {
        switch (type) {
            case BOOK:
                collection = bookCollection;
                break;
            case MOVIE:
                collection = movieCollection;
                break;
        }
    }
}
