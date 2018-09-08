package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private static boolean hasNotQuit = true;
    private String userInput;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        UI.displayMessage(UIEnum.WELCOME_MESSAGE);
        while (hasNotQuit) {
            UI.displayMessage(UIEnum.OPTION_LIST);
            userInput = br.readLine();
            if (userInput.equals(OptionListEnum.LISTBOOK.getValue())) {
                // list books.
            } else if (userInput.equals(OptionListEnum.QUIT.getValue())) {
                hasNotQuit = false;
            } else {
                UI.displayMessage(UIEnum.OPTION_INVALID);
            }
        }
    }
}
