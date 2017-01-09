/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for from emails.
 */

public class FromEmail {
    private String userName = "";
    private boolean selected = true;
    private String email = "";

    private boolean isOrgEmailId;


    /**
     * set the user name.
     *
     * @param userName Name of the user.
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * get the user name.
     *
     * @return Returns name of the user.
     */

    public String getUserName() {
        return userName;
    }

    /**
     * set is selected.
     *
     * @param selected To specify if the user is selected or not.
     */

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * get is selected.
     *
     * @return Returns true if the user is selected else return false.
     */

    public boolean isSelected() {
        return selected;
    }

    /**
     * set the email.
     *
     * @param email Email of the user.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get the email.
     *
     * @return Returns the email of the user.
     */

    public String getEmail() {
        return email;
    }

    /**
     * Get the email is from org email id or not.
     *
     * @return Returns true if the email is from org email id.
     */

    public boolean isOrgEmailId() {
        return isOrgEmailId;
    }

    /**
     * Set the email id is org email id or not.
     *
     * @param isOrgEmailId True or false to set the email id is org email id or not.
     */

    public void setOrgEmailId(boolean isOrgEmailId) {
        this.isOrgEmailId = isOrgEmailId;
    }


}
