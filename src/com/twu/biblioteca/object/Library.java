package com.twu.biblioteca.object;

import com.twu.biblioteca.store.BookStore;

import java.util.Arrays;

public class Library {

    private Book[] collection;

    public Library (BookStore bookstore) {
        this.collection = bookstore.get();
    }

    public Book[] getAvailableBooks() {
        return Arrays.stream(collection).filter(x -> !x.getCheckedOut()).toArray(Book[]::new);
    }
    public Book[] findBooksByTitle(String bookTitle){
        return Arrays.stream(collection).filter(x -> x.getTitle().equals(bookTitle)).toArray(Book[]::new);
    }
}
