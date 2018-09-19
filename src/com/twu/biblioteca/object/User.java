package com.twu.biblioteca.object;

public class User {
    private String loginId;
    private String password;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    public User(String loginId, String password, String name, String emailAddress, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name:" + name + "\n" +
                "EmailAddress:" + emailAddress + "\n" +
                "PhoneNumber:" + phoneNumber + "\n";
    }
}
