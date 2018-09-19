package com.twu.biblioteca.ui;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.LibraryItem;

public class UI {

    public static void displaySystemMessage(UIEnum msg, String... varArgs) {
        displayGeneralSystemMessage(msg, varArgs);
        displayUserSystemMessage(msg, varArgs);
        displayAlterSystemMessage(msg, varArgs);
    }

    public static void displayItems(LibraryItem[] items) {
        System.out.println("Currently available for checkout:");
        System.out.println("------------------------");
        for (LibraryItem item : items) {
            System.out.println(item);
        }
        System.out.println("------------------------");
    }

    private static void displayUserSystemMessage(UIEnum msg, String... varArgs) {
        switch (msg) {
            case NOT_LOGGED_IN:
                System.out.println("You need to login first!");
                break;
            case ALREADY_LOGGED_IN:
                System.out.println("You are already logged in!");
                break;
            case WRONG_OWNER:
                System.out.println("You do not own this book or are not logged in");
                break;
            case INVALID_CREDENTIALS:
                System.out.println("Invalid Credentials");
                break;
            case WHOAMI:
                System.out.println("Your credentials are:\n" + varArgs[0]);
                break;
            case INVALID_USER:
                System.out.println("Login Id must be of type xxx-xxxx");
                break;
            case LOGIN_PROMPT:
                System.out.println("Please enter login id:");
                break;
            case PASSWORD_PROMPT:
                System.out.println("Please enter password:");
                break;
        }
    }

    private static void displayAlterSystemMessage(UIEnum msg, String... varArgs) {
        switch (msg) {
            case RETURN_FAIL:
                System.out.println("That is not a valid " + varArgs[0] + " to return.");
                break;
            case CHECKOUT_FAIL:
                System.out.println("That " + varArgs[0] + " is not available.");
                break;
            case RETURN_SUCCESS:
                System.out.println("Thank you for returning the " + varArgs[0] + ".");
                break;
            case CHECKOUT_SUCCESS:
                System.out.println("Thank you! Enjoy the " + varArgs[0] + ".");
                break;
        }
    }

    private static void displayGeneralSystemMessage(UIEnum msg, String... varArgs) {
        switch (msg) {
            case WELCOME_MESSAGE:
                System.out.println("Welcome!");
                break;
            case OPTION_LIST:
                System.out.println("List of available options.");
                for (OptionListEnum e : OptionListEnum.values()) {
                    System.out.println(e.getOrdinal() + ". " + e.getValue());
                }
                break;
            case OPTION_INVALID:
                System.out.println("Select a valid option!");
                break;
            case USER_INPUT:
                System.out.println("What would you like to do?");
                break;
            case USER_INPUT_ITEM:
                System.out.println("Please enter a " + varArgs[0] + " title.");
                break;
        }
    }
}
