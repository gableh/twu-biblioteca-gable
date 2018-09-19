package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class Bibliotestca {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void itShouldQuit() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("quit\n".getBytes());
        System.setIn(in);
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.run();
        assertEquals("Welcome!\n" +
                "List of available options.\n" +
                "1. Login\n" +
                "2. List Books\n" +
                "3. List Movies\n" +
                "4. Checkout Book\n" +
                "5. Checkout Movie\n" +
                "6. Return Book\n" +
                "7. Return Movie\n" +
                "8. whoami\n" +
                "9. Logout\n" +
                "10. Quit\n" +
                "What would you like to do?\n", outContent.toString());
    }
    @Test
    public void itShouldHandleRubbishInput() throws IOException {
        //Need to include the quit command here, otherwise it will stall on the while loop
        ByteArrayInputStream in = new ByteArrayInputStream("rubbish\nquit\n".getBytes());
        System.setIn(in);
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.run();
        assertEquals("Welcome!\n" +
                "List of available options.\n" +
                "1. Login\n" +
                "2. List Books\n" +
                "3. List Movies\n" +
                "4. Checkout Book\n" +
                "5. Checkout Movie\n" +
                "6. Return Book\n" +
                "7. Return Movie\n" +
                "8. whoami\n" +
                "9. Logout\n" +
                "10. Quit\n" +
                "What would you like to do?\n" +
                "Select a valid option!\n" +
                "List of available options.\n" +
                "1. Login\n" +
                "2. List Books\n" +
                "3. List Movies\n" +
                "4. Checkout Book\n" +
                "5. Checkout Movie\n" +
                "6. Return Book\n" +
                "7. Return Movie\n" +
                "8. whoami\n" +
                "9. Logout\n" +
                "10. Quit\n" +
                "What would you like to do?\n", outContent.toString());
    }
}
