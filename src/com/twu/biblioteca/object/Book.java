package com.twu.biblioteca.object;

import com.twu.biblioteca.LibraryItem;

public class Book implements LibraryItem {
    private String authorName;
    private int yearPublished;
    private String title;
    private Boolean isCheckedOut;

    public Book(String title, String author_name, int year_published) {
        this.title = title;
        this.authorName = author_name;
        this.yearPublished = year_published;
        this.isCheckedOut = false;
    }

    public static boolean checkout(Book book) {
        if(!book.isCheckedOut) {
            book.isCheckedOut = true;
            return true;
        }
        return false;
    }

    public static boolean returnBook(Book book) {
        if(book.isCheckedOut) {
            book.isCheckedOut = false;
            return true;
        }
        return false;
    }


    public int getYearPublished() {
        return yearPublished;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean getCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getTitle() { return title; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;

        boolean hasSameAuthor = this.authorName.equals(other.authorName);
        boolean hasSameTitle = this.title.equals(other.title);
        boolean hasSameYearPublished = this.yearPublished == other.yearPublished;

        return hasSameAuthor && hasSameTitle && hasSameYearPublished;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + authorName +
                ", Year Published: " + yearPublished;
    }
}
