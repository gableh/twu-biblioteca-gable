package com.twu.biblioteca.store;

import com.twu.biblioteca.object.User;

public class UserStore {
    public static User[] get() {
        User u1 = new User("aaa-aaaa", "d1", "aaa", "aaa@c.com", "1231413");
        User u2 = new User("bbb-bbbb", "d2", "bbb", "bbb@c.com", "2231413");
        User u3 = new User("ccc-cccc", "d3", "ccc", "ccc@c.com", "3231413");
        User u4 = new User("ddd-dddd", "d4", "ddd", "ddd@c.com", "4231413");

        User[] users = {u1, u2, u3, u4};
        return users;
    }
}
