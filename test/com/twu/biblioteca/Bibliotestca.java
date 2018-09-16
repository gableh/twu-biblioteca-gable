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
    public void itShouldHandleRubbishInput() throws IOException {
        //Need to include the quit command here, otherwise it will stall on the while loop
        ByteArrayInputStream in = new ByteArrayInputStream("rubbish\nquit\n".getBytes());
        System.setIn(in);
        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.run();
        assertEquals("Welcome!\n" +
                "List of available options.\n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. Checkout Book\n" +
                "4. Checkout Movie\n" +
                "5. Return Book\n" +
                "6. Return Movie\n" +
                "7. Quit\n" +
                "What would you like to do?\n" +
                "Select a valid option!\n" +
                "List of available options.\n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. Checkout Book\n" +
                "4. Checkout Movie\n" +
                "5. Return Book\n" +
                "6. Return Movie\n" +
                "7. Quit\n" +
                "What would you like to do?\n", outContent.toString());
    }
}
