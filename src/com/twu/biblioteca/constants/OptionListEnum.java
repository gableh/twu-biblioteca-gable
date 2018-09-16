package com.twu.biblioteca.constants;

public enum OptionListEnum {
    LISTBOOK("List Books", ControllerTypes.LibraryItem, LibraryItemTypes.BOOK),
    LISTMOVIE("List Movies", ControllerTypes.LibraryItem, LibraryItemTypes.MOVIE),
    CHECKOUTBOOK("Checkout Book", ControllerTypes.LibraryItem, LibraryItemTypes.BOOK),
    CHECKOUTMOVIE("Checkout Movie", ControllerTypes.LibraryItem, LibraryItemTypes.MOVIE),
    RETURNBOOK("Return Book", ControllerTypes.LibraryItem, LibraryItemTypes.BOOK),
    RETURNMOVIE("Return Movie", ControllerTypes.LibraryItem, LibraryItemTypes.MOVIE),
    QUIT("Quit", ControllerTypes.UI);

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
        try {
            int parsedInt = Integer.parseInt(input);
            for (OptionListEnum e : OptionListEnum.values()) {
                if (e.getOrdinal() == parsedInt) {
                    return e;
                }
            }
        } catch (NumberFormatException exception){
            for (OptionListEnum e : OptionListEnum.values()) {
                if (input.equalsIgnoreCase(e.value)) {
                    return e;
                }
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }

    public int getOrdinal() {
        return ordinal() + 1;
    }
}

