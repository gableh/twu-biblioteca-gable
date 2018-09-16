package com.twu.biblioteca.controllers;

import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.controllers.libraryitem.BookController;
import com.twu.biblioteca.controllers.libraryitem.MovieController;

import java.io.IOException;

public class LibraryController {

    private MovieController movieController;
    private BookController bookController;

    public LibraryController() {
        movieController = new MovieController();
        bookController = new BookController();
    }

    public void handle(OptionListEnum parsedInput) throws IOException {
        if (parsedInput.belongsToLibraryItemType(LibraryItemTypes.MOVIE)) {
            movieController.handle(parsedInput);
        } else if (parsedInput.belongsToLibraryItemType(LibraryItemTypes.BOOK)) {
            bookController.handle(parsedInput);
        }
    }
}
