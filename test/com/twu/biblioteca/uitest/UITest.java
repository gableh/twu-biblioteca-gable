package com.twu.biblioteca.uitest;

import com.twu.biblioteca.constants.LibraryItemTypes;
import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.object.Book;
import com.twu.biblioteca.object.LibraryItem;
import com.twu.biblioteca.ui.UI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UITest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void itShouldDisplayAWelcomeMessage() {
        UI.displaySystemMessage(UIEnum.WELCOME_MESSAGE);
        assertEquals("Welcome!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAnOptionListMessage() {
        UI.displaySystemMessage(UIEnum.OPTION_LIST);
        assertEquals("List of available options.\n" +
                "1. Login\n" +
                "2. List Books\n" +
                "3. List Movies\n" +
                "4. Checkout Book\n" +
                "5. Checkout Movie\n" +
                "6. Return Book\n" +
                "7. Return Movie\n" +
                "8. whoami\n" +
                "9. Logout\n" +
                "10. Quit\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAnInvalidOptionMessage() {
        UI.displaySystemMessage(UIEnum.OPTION_INVALID);
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAReturnFailMessage() {
        UI.displaySystemMessage(UIEnum.RETURN_FAIL, LibraryItemTypes.BOOK.getValue());
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayACheckoutFailMessage() {
        UI.displaySystemMessage(UIEnum.CHECKOUT_FAIL, LibraryItemTypes.BOOK.getValue());
        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAReturnSuccessMessage() {
        UI.displaySystemMessage(UIEnum.RETURN_SUCCESS, LibraryItemTypes.BOOK.getValue());
        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayACheckoutSuccessMessage() {
        UI.displaySystemMessage(UIEnum.CHECKOUT_SUCCESS, LibraryItemTypes.BOOK.getValue());
        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayAUserInputMessage() {
        UI.displaySystemMessage(UIEnum.USER_INPUT);
        assertEquals("What would you like to do?\n", outContent.toString());
    }


    @Test
    public void displayMessageShouldDisplayLibraryItemsAsString() {
        LibraryItem book1 = new Book("book2", "author", 1993);
        LibraryItem book2 = new Book("book2", "author", 1993);
        LibraryItem book3 = new Book("book3", "author", 1993);

        LibraryItem[] items = {book1, book2, book3};

        UI.displayItems(items);
        assertEquals("Currently available for checkout:\n" +
                "------------------------\n" +
                "Title: book2, Author: author, Year Published: 1993\n" +
                "Title: book2, Author: author, Year Published: 1993\n" +
                "Title: book3, Author: author, Year Published: 1993\n" +
                "------------------------\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayNotLoggedInMessage() {
        UI.displaySystemMessage(UIEnum.NOT_LOGGED_IN);
        assertEquals("You need to login first!\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayWrongOwnerMessage() {
        UI.displaySystemMessage(UIEnum.WRONG_OWNER);
        assertEquals("You do not own this book or are not logged in\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayInvalidCredentialsMessage() {
        UI.displaySystemMessage(UIEnum.INVALID_CREDENTIALS);
        assertEquals("Invalid Credentials\n", outContent.toString());
    }

    @Test
    public void itShouldDisplayInvalidUserMessage() {
        UI.displaySystemMessage(UIEnum.INVALID_USER);
        assertEquals("Login Id must be of type xxx-xxxx\n", outContent.toString());
    }
}
