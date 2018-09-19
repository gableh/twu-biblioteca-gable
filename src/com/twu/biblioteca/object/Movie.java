package com.twu.biblioteca.object;

import com.twu.biblioteca.constants.LibraryItemTypes;

public class Movie implements LibraryItem {
    private String directorName;
    private int yearReleased;
    private String title;
    private String isCheckedOut;
    private int rating;

    private LibraryItemTypes type;

    public Movie(String title, String directorName, int yearReleased, int rating) {
        this.title = title;
        this.directorName = directorName;
        this.yearReleased = yearReleased;
        this.rating = rating;
        this.isCheckedOut = null;
        this.type = LibraryItemTypes.MOVIE;

    }

    public LibraryItemTypes getItemType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getYearReleased() {
        return yearReleased;
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

    public String getDirectorName() {
        return directorName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;

        boolean hasSameDirector = this.directorName.equals(other.directorName);
        boolean hasSameTitle = this.title.equals(other.title);
        boolean hasSameYearReleased = this.yearReleased == other.yearReleased;

        return hasSameDirector && hasSameTitle && hasSameYearReleased;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Director: " + directorName +
                ", Year Released: " + yearReleased +
                ", Rating: " + rating;
    }
}
