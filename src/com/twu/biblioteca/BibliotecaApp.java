package com.twu.biblioteca;

import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.object.Movie;
import com.twu.biblioteca.object.Library;
import com.twu.biblioteca.store.BookStore;
import com.twu.biblioteca.store.MovieStore;
import com.twu.biblioteca.ui.UI;
import com.twu.biblioteca.ui.UIEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BibliotecaApp {

    private static boolean hasNotQuit = true;
    private String userInput;
    private String bookTitle;
    private String movieTitle;
    private BufferedReader br;

    public void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        BookStore bookStore = new BookStore();
        MovieStore movieStore = new MovieStore();
        Library library = new Library(bookStore, movieStore);

        UI.displaySystemMessage(UIEnum.WELCOME_MESSAGE);

        while (hasNotQuit) {

            UI.displaySystemMessage(UIEnum.OPTION_LIST);
            UI.displaySystemMessage(UIEnum.USER_INPUT);
            userInput = br.readLine();

            if (userInput.equalsIgnoreCase(OptionListEnum.LISTBOOK.getValue())) {
                LibraryItem[] books = library.getAvailableItems(LibraryItemTypes.BOOK);
                UI.displayItems(books);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.LISTMOVIE.getValue())) {
                LibraryItem[] movies = library.getAvailableItems(LibraryItemTypes.MOVIE);
                UI.displayItems(movies);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.RETURNBOOK.getValue())) {
                LibraryItem[] books = requestItem(library, LibraryItemTypes.BOOK);
                alterItem(books, UIEnum.RETURN_FAIL, UIEnum.RETURN_SUCCESS, LibraryItem::returnItem, LibraryItemTypes.BOOK);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.CHECKOUTBOOK.getValue())) {
                LibraryItem[] books = requestItem(library, LibraryItemTypes.BOOK);
                alterItem(books, UIEnum.CHECKOUT_FAIL, UIEnum.CHECKOUT_SUCCESS, LibraryItem::checkoutItem, LibraryItemTypes.BOOK);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.RETURNMOVIE.getValue())) {
                LibraryItem[] movies = requestItem(library, LibraryItemTypes.MOVIE);
                alterItem(movies, UIEnum.RETURN_FAIL, UIEnum.RETURN_SUCCESS, LibraryItem::returnItem, LibraryItemTypes.MOVIE);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.CHECKOUTMOVIE.getValue())) {
                LibraryItem[] movies = requestItem(library, LibraryItemTypes.MOVIE);
                alterItem(movies, UIEnum.CHECKOUT_FAIL, UIEnum.CHECKOUT_SUCCESS, LibraryItem::checkoutItem, LibraryItemTypes.MOVIE);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.QUIT.getValue())) {
                hasNotQuit = false;

            } else {
                UI.displaySystemMessage(UIEnum.OPTION_INVALID);
            }
        }
    }

    private LibraryItem[] requestItem(Library library, LibraryItemTypes type) throws IOException {
        UI.displaySystemMessage(UIEnum.USER_INPUT_ITEM, type.getValue());
        movieTitle = br.readLine();
        return library.findItemByTitle(movieTitle, type);
    }

    private void alterItem(LibraryItem[] items, UIEnum fail, UIEnum success,
                           Function<LibraryItem, Boolean> alter, LibraryItemTypes type) {
        if (items.length > 1) {
            // Display multiple items found, possible additional filtering by author
        } else if (items.length == 0) {
            UI.displaySystemMessage(fail, type.getValue());
        } else {
            UI.displaySystemMessage(alter.apply(items[0]) ? success : fail, type.getValue());
        }
    }
}
