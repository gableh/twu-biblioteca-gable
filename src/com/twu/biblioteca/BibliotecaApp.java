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
                Book[] books = library.getAvailableBooks();
                UI.displayItems(books);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.LISTMOVIE.getValue())) {
                Movie[] movies = library.getAvailableMovies();
                UI.displayItems(movies);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.RETURNBOOK.getValue())) {
                LibraryItem[] books = requestBook(library);
                alterItem(books, UIEnum.RETURN_FAIL, UIEnum.RETURN_SUCCESS, LibraryItem::returnItem);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.CHECKOUTBOOK.getValue())) {
                LibraryItem[] books = requestBook(library);
                alterItem(books, UIEnum.CHECKOUT_FAIL, UIEnum.CHECKOUT_SUCCESS, LibraryItem::checkoutItem);

            } else if (userInput.equalsIgnoreCase(OptionListEnum.QUIT.getValue())) {
                hasNotQuit = false;

            } else {
                UI.displaySystemMessage(UIEnum.OPTION_INVALID);
            }
        }
    }

    private Book[] requestBook(Library library) throws IOException {
        UI.displaySystemMessage(UIEnum.USER_INPUT_BOOK);
        bookTitle = br.readLine();
        return library.findBooksByTitle(bookTitle);
    }

    private void alterItem(LibraryItem[] items, UIEnum fail, UIEnum success, Function<LibraryItem, Boolean> alter) {
        if (items.length > 1) {
            // Display multiple items found, possible additional filtering by author
        } else if (items.length == 0) {
            UI.displaySystemMessage(fail);
        } else {
            UI.displaySystemMessage(alter.apply(items[0]) ? success : fail);
        }
    }
}
