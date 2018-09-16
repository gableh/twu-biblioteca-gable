package com.twu.biblioteca;

import com.twu.biblioteca.constants.ControllerTypes;
import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.controllers.LibraryController;
import com.twu.biblioteca.ui.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private boolean hasNotQuit = true;
    private String userInput;
    private BufferedReader br;

    public void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        LibraryController libraryController = new LibraryController();

        UI.displaySystemMessage(UIEnum.WELCOME_MESSAGE);

        while (hasNotQuit) {

            UI.displaySystemMessage(UIEnum.OPTION_LIST);
            UI.displaySystemMessage(UIEnum.USER_INPUT);
            userInput = br.readLine();

            OptionListEnum parsedInput = OptionListEnum.parse(userInput);

            if (parsedInput == null) {
                UI.displaySystemMessage(UIEnum.OPTION_INVALID);
            } else if (parsedInput.belongsToControllerType(ControllerTypes.LibraryItem)) {
                libraryController.handle(parsedInput);
            } else if (parsedInput == OptionListEnum.QUIT) {
                hasNotQuit = false;
            }
        }
    }
}
