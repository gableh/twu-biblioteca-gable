package com.twu.biblioteca;

public class BookStore {



    public static Book[] get() {
        Book b1 = new Book("t1", "a1", 1993);
        Book b2 = new Book("t2", "a2", 1994);
        Book b3 = new Book("t3", "a3", 1995);
        Book b4 = new Book("t4", "a4", 1996);

        Book[] books = {b1, b2, b3, b4};
        return books;
    }
}
