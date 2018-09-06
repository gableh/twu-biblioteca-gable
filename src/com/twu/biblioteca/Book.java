package com.twu.biblioteca;

public class Book {
    private String author_name;
    private int year_published;

    public Book(String author_name, int year_published) {
        this.author_name = author_name;
        this.year_published = year_published;
    }

    public int getYearPublished() {
        return year_published;
    }

    public String getAuthorName() {
        return author_name;
    }
}
