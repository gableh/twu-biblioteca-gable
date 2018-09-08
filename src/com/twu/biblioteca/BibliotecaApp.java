package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private static boolean hasNotQuit = true;
    private String userInput;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BookStore bookstore = new BookStore();
        Library library = new Library(bookstore);

        UI.displaySystemMessage(UIEnum.WELCOME_MESSAGE);

        while (hasNotQuit) {
            UI.displaySystemMessage(UIEnum.OPTION_LIST);
            UI.displaySystemMessage(UIEnum.USER_INPUT);
            userInput = br.readLine();
            if (userInput.equals(OptionListEnum.LISTBOOK.getValue())) {
                Book[] books = library.getAvailableBooks();
                UI.displayBooks(books);
            } else if (userInput.equals(OptionListEnum.QUIT.getValue())) {
                hasNotQuit = false;
            } else {
                UI.displaySystemMessage(UIEnum.OPTION_INVALID);
            }
        }
    }
}
