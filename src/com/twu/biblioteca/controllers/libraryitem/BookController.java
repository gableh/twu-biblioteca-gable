package com.twu.biblioteca.controllers.libraryitem;

import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.Library;
import com.twu.biblioteca.object.LibraryItem;
import com.twu.biblioteca.store.BookStore;
import com.twu.biblioteca.ui.UI;

import java.io.IOException;

public class BookController extends LibraryItemController {
    private Library library;

    public BookController() {
        super();
        library = new Library(BookStore.get());
    }

    public void handle(OptionListEnum parsedInput) throws IOException {

        if (parsedInput == OptionListEnum.LISTBOOK) {
            LibraryItem[] books = library.getAvailableItems();
            UI.displayItems(books);
        } else if (parsedInput == OptionListEnum.RETURNBOOK) {
            String title = super.getTitle(LibraryItemTypes.BOOK);
            LibraryItem[] books = this.library.requestItem(title);
            this.library.alterItem(books, UIEnum.RETURN_FAIL, LibraryItem::returnItem, LibraryItemTypes.BOOK);
        } else if (parsedInput == OptionListEnum.CHECKOUTBOOK) {
            String title = super.getTitle(LibraryItemTypes.BOOK);
            LibraryItem[] books = library.requestItem(title);
            this.library.alterItem(books, UIEnum.CHECKOUT_FAIL, LibraryItem::checkoutItem, LibraryItemTypes.BOOK);
        }
    }
}
