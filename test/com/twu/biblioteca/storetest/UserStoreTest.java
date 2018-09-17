package com.twu.biblioteca.storetest;

import com.twu.biblioteca.object.User;
import com.twu.biblioteca.store.UserStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserStoreTest {
    @Test
    public void getShouldReturnAListOfUsers() {
        UserStore userStore = new UserStore();

        Object[] users = userStore.get();

        assertEquals(User.class, users[0].getClass());
    }
}
