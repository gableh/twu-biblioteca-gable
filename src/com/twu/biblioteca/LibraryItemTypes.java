package com.twu.biblioteca;

public enum LibraryItemTypes {
    BOOK("book"),
    MOVIE("movie");

    private final String value;

    LibraryItemTypes(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
