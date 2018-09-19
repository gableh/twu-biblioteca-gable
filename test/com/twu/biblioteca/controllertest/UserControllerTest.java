package com.twu.biblioteca.controllertest;

import com.twu.biblioteca.constants.OptionListEnum;
import com.twu.biblioteca.controllers.UserController;
import com.twu.biblioteca.controllers.libraryitem.MovieController;
import com.twu.biblioteca.store.UserStore;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;
    private MovieController movieController;

    @BeforeClass
    public static void setUpClass() {
        UserController.logout();

    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        movieController = new MovieController();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void itShouldHandleLoginCommand() throws IOException {
        assertEquals(null, UserController.getCurrentUser());
        login();
        assertEquals(UserStore.get()[0].toString(), UserController.getCurrentUser().toString());
    }

    @Test
    public void itShouldHandleLogoutCommand() throws IOException {
        login();
        assertEquals(UserStore.get()[0].toString(), UserController.getCurrentUser().toString());
        UserController.handle(OptionListEnum.LOGOUT);
        assertEquals(null, UserController.getCurrentUser());
    }

    @Test
    public void itShouldHandleInvalidInput() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("invalid\n".getBytes());
        System.setIn(in);
        UserController.init();
        UserController.handle(OptionListEnum.LOGIN);
        assertEquals(null, UserController.getCurrentUser());
        assertEquals("Login Id must be of type xxx-xxxx\n", outContent.toString());
    }

    private void login() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("aaa-aaaa\nd1\n".getBytes());
        System.setIn(in);
        UserController.init();
        UserController.handle(OptionListEnum.LOGIN);
    }
}