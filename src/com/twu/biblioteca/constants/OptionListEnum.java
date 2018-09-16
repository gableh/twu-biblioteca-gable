package com.twu.biblioteca.constants;

public enum OptionListEnum {
    QUIT("Quit", ControllerTypes.UI),
    LISTBOOK("List Books", ControllerTypes.LibraryItem, LibraryItemTypes.BOOK),
    LISTMOVIE("List Movies", ControllerTypes.LibraryItem, LibraryItemTypes.MOVIE),
    CHECKOUTBOOK("Checkout Book", ControllerTypes.LibraryItem, LibraryItemTypes.BOOK),
    RETURNBOOK("Return Book", ControllerTypes.LibraryItem, LibraryItemTypes.BOOK),
    CHECKOUTMOVIE("Checkout Movie", ControllerTypes.LibraryItem, LibraryItemTypes.MOVIE),
    RETURNMOVIE("Return Movie", ControllerTypes.LibraryItem, LibraryItemTypes.MOVIE);

    private final String value;
    private final LibraryItemTypes libraryItemType;
    private final ControllerTypes controllerType;

    OptionListEnum(String name, ControllerTypes controllerType) {
        this.value = name;
        this.controllerType = controllerType;
        this.libraryItemType = null;
    }

    OptionListEnum(String name, ControllerTypes controllerType, LibraryItemTypes itemType) {
        this.value = name;
        this.controllerType = controllerType;
        this.libraryItemType = itemType;
    }

    public boolean belongsToLibraryItemType(LibraryItemTypes itemType) {
        return this.libraryItemType == itemType;
    }

    public boolean belongsToControllerType(ControllerTypes itemType) {
        return this.controllerType == itemType;
    }

    public static OptionListEnum parse(String input) {
        for (OptionListEnum e : OptionListEnum.values()) {
            if (input.equalsIgnoreCase(e.value)) {
                return e;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}

