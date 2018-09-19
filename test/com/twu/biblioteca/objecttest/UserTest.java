package com.twu.biblioteca.objecttest;

import com.twu.biblioteca.object.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new User("aaa-aaaa", "d1", "me",
                "me@me.com", "43242432");
    }

    @Test
    public void itShouldReturnLoginId() {
        assertEquals("aaa-aaaa", user.getLoginId());
    }

    @Test
    public void itShouldReturnPassword() {
        assertEquals("d1", user.getPassword());
    }
}
