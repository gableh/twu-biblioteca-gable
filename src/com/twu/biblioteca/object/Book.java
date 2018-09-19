package com.twu.biblioteca.object;

import com.twu.biblioteca.constants.LibraryItemTypes;

public class Book implements LibraryItem {
    private String authorName;
    private int yearPublished;
    private String title;
    private String isCheckedOut;
    private LibraryItemTypes type;

    public Book(String title, String author_name, int year_published) {
        this.title = title;
        this.authorName = author_name;
        this.yearPublished = year_published;
        this.isCheckedOut = null;
        this.type = LibraryItemTypes.BOOK;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public LibraryItemTypes getItemType() {
        return type;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean getCheckedOut() {
        return isCheckedOut != null;
    }

    public void setCheckedOut(String userId) {
        isCheckedOut = userId;
    }

    public String checkedOutBy() {
        return isCheckedOut;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
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
