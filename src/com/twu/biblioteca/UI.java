package com.twu.biblioteca;

class UI {
    static void displaySystemMessage(UIEnum msg) {
        switch (msg) {
            case WELCOME_MESSAGE:
                System.out.println("Welcome!");
                break;
            case OPTION_LIST:
                System.out.println("List of available options.");
                System.out.println("1. List Books");
                System.out.println("2. Quit");
                break;
            case OPTION_INVALID:
                System.out.println("Select a valid option!");
                break;
            case RETURN_FAIL:
                System.out.println("That is not a valid book to return.");
                break;
            case CHECKOUT_FAIL:
                System.out.println("That book is not available.");
                break;
            case RETURN_SUCCESS:
                System.out.println("Thank you for returning the book.");
                break;
            case CHECKOUT_SUCCESS:
                System.out.println("Thank you! Enjoy the book.");
                break;
        }
    }

    static void displayMessage(Object obj) {
        System.out.println(obj.toString());
    }
}
