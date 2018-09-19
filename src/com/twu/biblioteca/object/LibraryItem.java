package com.twu.biblioteca.object;

import com.twu.biblioteca.constants.UIEnum;
import com.twu.biblioteca.controllers.UserController;

public interface LibraryItem {
    static UIEnum checkoutItem(LibraryItem item) {
        User user = UserController.getCurrentUser();
        if (!item.getCheckedOut() && user != null) {
            item.setCheckedOut(user.getLoginId());
            return UIEnum.CHECKOUT_SUCCESS;
        }
        if (user == null) {
            return UIEnum.NOT_LOGGED_IN;
        }
        return UIEnum.CHECKOUT_FAIL;
    }

    static UIEnum returnItem(LibraryItem item) {

        if (item.getCheckedOut() && UserController.isOwner(item)) {
            item.setCheckedOut(null);
            return UIEnum.RETURN_SUCCESS;
        }
        if (UserController.getCurrentUser() == null) {
            return UIEnum.NOT_LOGGED_IN;
        }
        if (item.getCheckedOut() && !UserController.isOwner(item)) {
            return UIEnum.WRONG_OWNER;
        }
        return UIEnum.RETURN_FAIL;
    }

    boolean getCheckedOut();

    void setCheckedOut(String id);

    String getTitle();

    String checkedOutBy();

    @Override
    boolean equals(Object obj);

    @Override
    String toString();

}
