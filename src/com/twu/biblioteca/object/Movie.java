package com.twu.biblioteca.object;

import com.twu.biblioteca.LibraryItem;

public class Movie implements LibraryItem {
    private String directorName;
    private int yearReleased;
    private String title;
    private Boolean isCheckedOut;
    private int rating;

    public Movie(String title, String directorName, int yearReleased, int rating) {
        this.title = title;
        this.directorName = directorName;
        this.yearReleased = yearReleased;
        this.rating = rating;
        this.isCheckedOut = false;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public boolean getCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getDirectorName() {
        return directorName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
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
