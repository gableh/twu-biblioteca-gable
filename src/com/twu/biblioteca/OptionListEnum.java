package com.twu.biblioteca;

public enum OptionListEnum {
    QUIT("Quit"),
    LISTBOOK("List Books"),
    LISTMOVIE("List Movies"),
    CHECKOUTBOOK("Checkout Book"),
    RETURNBOOK("Return Book"),
    CHECKOUTMOVIE("Checkout Movie"),
    RETURNMOVIE("Return Movie");

    private final String value;

    OptionListEnum(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}

