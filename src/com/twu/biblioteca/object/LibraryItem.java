package com.twu.biblioteca.object;

public interface LibraryItem {
    static boolean checkoutItem(LibraryItem item) {
        if (!item.getCheckedOut()) {
            item.setCheckedOut(true);
            return true;
        }
        return false;
    }

    static boolean returnItem(LibraryItem item) {
        if (item.getCheckedOut()) {
            item.setCheckedOut(false);
            return true;
        }
        return false;
    }

    boolean getCheckedOut();

    void setCheckedOut(boolean bool);

    String getTitle();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();

}
