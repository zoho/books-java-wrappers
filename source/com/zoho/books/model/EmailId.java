/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for email ids.
 */

public class EmailId {
    private boolean isSelected = false;
    private String email = "";


    /**
     * set is selected.
     *
     * @param isSelected Whether the email is selected or not.
     */

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * get is selected.
     *
     * @return Returns true if the email is selected else return false.
     */

    public boolean isSelected() {
        return isSelected;
    }

    /**
     * set the email.
     *
     * @param email Email for the user.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get the email.
     *
     * @return Returns the email for the user.
     */

    public String getEmail() {
        return email;
    }
}
