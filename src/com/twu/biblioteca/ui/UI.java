package com.twu.biblioteca.ui;

import com.twu.biblioteca.object.Book;

public class UI {
    public static void displaySystemMessage(UIEnum msg) {
        switch (msg) {
            case WELCOME_MESSAGE:
                System.out.println("Welcome!");
                break;
            case OPTION_LIST:
                System.out.println("List of available options.");
                System.out.println("1. List Books");
                System.out.println("2. Checkout Book");
                System.out.println("3. Return Book");
                System.out.println("4. Quit");
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
            case USER_INPUT:
                System.out.println("What would you like to do?");
                break;
            case USER_INPUT_BOOK:
                System.out.println("Please enter a book title.");
                break;
        }
    }

    public static void displayBooks(Book[] books) {
        System.out.println("List of Available Books:");
        System.out.println("------------------------");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("------------------------");
    }
}
