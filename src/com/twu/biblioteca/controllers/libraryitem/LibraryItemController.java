package com.twu.biblioteca.controllers.libraryitem;

import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.ui.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class LibraryItemController {
    BufferedReader br;

    LibraryItemController() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract void handle(OptionListEnum parsedInput) throws IOException;

    String getTitle(LibraryItemTypes libraryItemType) throws IOException {
        UI.displaySystemMessage(UIEnum.USER_INPUT_ITEM, libraryItemType.getValue());
        return br.readLine();
    }
}
