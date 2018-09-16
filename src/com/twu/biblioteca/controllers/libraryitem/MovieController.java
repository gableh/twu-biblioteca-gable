package com.twu.biblioteca.controllers.libraryitem;

import com.twu.biblioteca.LibraryItem;
import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.object.Library;
import com.twu.biblioteca.store.MovieStore;
import com.twu.biblioteca.ui.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieController extends LibraryItemController {
    private Library library;

    public MovieController() {
        MovieStore movieStore = new MovieStore();
        br = new BufferedReader(new InputStreamReader(System.in));
        library = new Library(movieStore.get());
    }

    public void handle(OptionListEnum parsedInput) throws IOException {
        if (parsedInput == OptionListEnum.LISTMOVIE) {
            Book[] books = (Book[]) library.getAvailableItems();
            UI.displayItems(books);
        } else if (parsedInput == OptionListEnum.RETURNMOVIE) {
            String title = super.getTitle(LibraryItemTypes.MOVIE);
            Book[] books = (Book[]) this.library.requestItem(title);
            this.library.alterItem(books, UIEnum.RETURN_FAIL, UIEnum.RETURN_SUCCESS, LibraryItem::returnItem, LibraryItemTypes.MOVIE);
        } else if (parsedInput == OptionListEnum.CHECKOUTMOVIE) {
            String title = super.getTitle(LibraryItemTypes.MOVIE);
            LibraryItem[] books = library.requestItem(title);
            this.library.alterItem(books, UIEnum.CHECKOUT_FAIL, UIEnum.CHECKOUT_SUCCESS, LibraryItem::checkoutItem, LibraryItemTypes.MOVIE);
        }
    }
}
