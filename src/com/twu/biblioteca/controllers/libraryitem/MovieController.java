package com.twu.biblioteca.controllers.libraryitem;

import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.Library;
import com.twu.biblioteca.object.LibraryItem;
import com.twu.biblioteca.store.MovieStore;
import com.twu.biblioteca.ui.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieController extends LibraryItemController {
    private Library library;

    public MovieController() {
        br = new BufferedReader(new InputStreamReader(System.in));
        library = new Library(MovieStore.get());
    }

    public void handle(OptionListEnum parsedInput) throws IOException {
        if (parsedInput == OptionListEnum.LISTMOVIE) {
            LibraryItem[] movies =library.getAvailableItems();
            UI.displayItems(movies);
        } else if (parsedInput == OptionListEnum.RETURNMOVIE) {
            String title = super.getTitle(LibraryItemTypes.MOVIE);
            LibraryItem[] movies = this.library.requestItem(title);
            this.library.alterItem(movies, UIEnum.RETURN_FAIL, LibraryItem::returnItem, LibraryItemTypes.MOVIE);
        } else if (parsedInput == OptionListEnum.CHECKOUTMOVIE) {
            String title = super.getTitle(LibraryItemTypes.MOVIE);
            LibraryItem[] books = library.requestItem(title);
            this.library.alterItem(books, UIEnum.CHECKOUT_FAIL, LibraryItem::checkoutItem, LibraryItemTypes.MOVIE);
        }
    }
}
