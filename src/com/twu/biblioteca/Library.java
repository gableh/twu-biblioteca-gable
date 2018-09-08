package com.twu.biblioteca;

public class Library {

    private Book[] collection;

    public Library (Book[] initialBooks) {
        this.collection = initialBooks;
    }

    public Book[] getBooks() {
        return collection;
    }
}
