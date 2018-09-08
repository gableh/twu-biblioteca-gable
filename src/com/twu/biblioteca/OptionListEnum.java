package com.twu.biblioteca;

public enum OptionListEnum {
    QUIT("Quit"),
    LISTBOOK("List Books");

    private final String value;

    OptionListEnum(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}

