package com.twu.biblioteca.object;

import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.ui.UI;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

public class Library {
    LibraryItem[] collection;

    public Library(LibraryItem[] items) {
        this.collection = items;
    }

    public LibraryItem[] getAvailableItems() {
        return Arrays.stream(collection).filter(x -> !x.getCheckedOut()).toArray(LibraryItem[]::new);
    }

    public LibraryItem[] findItemByTitle(String title) {
        return Arrays.stream(collection).filter(x -> x.getTitle().equals(title)).toArray(LibraryItem[]::new);
    }

    public LibraryItem[] requestItem(String title) throws IOException {
        return this.findItemByTitle(title);
    }

    public void alterItem(LibraryItem[] items, UIEnum fail, UIEnum success,
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
