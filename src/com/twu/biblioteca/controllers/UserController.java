package com.twu.biblioteca.controllers;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.LibraryItem;
import com.twu.biblioteca.object.User;
import com.twu.biblioteca.store.UserStore;
import com.twu.biblioteca.ui.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {
    private static User currentUser;
    private static User[] users = UserStore.get();
    private static BufferedReader br;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void handle(OptionListEnum parsedInput) throws IOException {
        if (parsedInput == OptionListEnum.LOGIN) {
            if (currentUser == null) {
                authenticateUser();
            } else {
                UI.displaySystemMessage(UIEnum.ALREADY_LOGGED_IN);
            }
        } else if (parsedInput == OptionListEnum.LOGOUT) {
            if (currentUser != null) {
                currentUser = null;
            } else {
                UI.displaySystemMessage(UIEnum.NOT_LOGGED_IN);
            }
        } else if (parsedInput == OptionListEnum.WHOAMI) {
            if (currentUser != null) {
                UI.displaySystemMessage(UIEnum.WHOAMI, currentUser.toString());
            } else {
                UI.displaySystemMessage(UIEnum.NOT_LOGGED_IN);
            }
        }
    }

    private static void authenticateUser() throws IOException {
        String loginId = br.readLine();
        if (!isValid(loginId)) {
            UI.displaySystemMessage(UIEnum.INVALID_USER);
            return;
        }
        String password = br.readLine();
        for (User user : users) {
            if (user.getLoginId().equals(loginId) && user.getPassword().equals(password)) {
                currentUser = user;
            }
        }
        if (currentUser == null) {
            UI.displaySystemMessage(UIEnum.INVALID_CREDENTIALS);
        }
    }

    private static boolean isValid(String loginId) {
        return loginId.matches("[a-zA-Z0-9]{3}-[a-zA-Z0-9]{4}");
    }

    public static boolean isOwner(LibraryItem item) {
        return currentUser != null && item.checkedOutBy().equals(currentUser.getLoginId());
    }

    public static void logout() {
        currentUser = null;
    }
}
