package com.twu.biblioteca;

public class Book {
    private String author_name;
    private int year_published;
    private String title;
    private Boolean isCheckedOut;

    Book(String title, String author_name, int year_published) {
        this.title = title;
        this.author_name = author_name;
        this.year_published = year_published;
        this.isCheckedOut = false;
    }

    int getYearPublished() {
        return year_published;
    }

    String getAuthorName() {
        return author_name;
    }

    Boolean getCheckedOut() {
        return isCheckedOut;
    }

    String getTitle() { return title; }

    boolean checkout() {
        if(!this.isCheckedOut) {
            this.isCheckedOut = true;
            return true;
        }
        return false;
    }

    boolean returnBook() {
        if(this.isCheckedOut) {
            this.isCheckedOut = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;

        boolean hasSameAuthor = this.author_name.equals(other.author_name);
        boolean hasSameTitle = this.title.equals(other.title);
        boolean hasSameYearPublished = this.year_published == other.year_published;

        return hasSameAuthor && hasSameTitle && hasSameYearPublished;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author_name +
                ", Year Published: " + year_published;
    }
}
