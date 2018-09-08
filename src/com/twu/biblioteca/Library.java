package com.twu.biblioteca;

public class Library {

    private Book[] collection;

    public Library (BookStore bookstore) {
        this.collection = bookstore.get();
    }

    public Book[] getBooks() {
        return collection;
    }
}
