/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to create an object for to contacts.
 */

public class ToContact {
    private String firstName = "";
    private boolean selected = true;
    private String phone = "";
    private String email = "";
    private String contactPersonId = "";
    private String lastName = "";
    private String salutation = "";
    private String mobile = "";


    /**
     * set the first name.
     *
     * @param firstName First name of the contact person.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get the first name.
     *
     * @return Returns the first name of the contact person.
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * set is selected.
     *
     * @param selected To specify the contact person is selected or not.
     */

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * get is selected.
     *
     * @return Returns true if the contact person is selected else returns false.
     */

    public boolean isSelected() {
        return selected;
    }

    /**
     * set the phone number.
     *
     * @param phone Phone number of the contact person.
     */

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * get the phone number.
     *
     * @return Returns the phone number of the contact person.
     */

    public String getPhone() {
        return phone;
    }

    /**
     * set the email.
     *
     * @param email Email of the contact person.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get the email.
     *
     * @return Returns the email of the contact person.
     */

    public String getEmail() {
        return email;
    }

    /**
     * set the contact person id.
     *
     * @param contactPersonId ID of the contact person.
     */

    public void setContactPersonId(String contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    /**
     * get the contact person id.
     *
     * @return Returns the ID of the contact person.
     */

    public String getContactPersonId() {
        return contactPersonId;
    }

    /**
     * set the last name.
     *
     * @param lastName Last name of the contact person.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get the last name.
     *
     * @return Returns the last name of the contact person.
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * set the salutation.
     *
     * @param salutation Salutation of the contact person.
     */

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * get the salutation.
     *
     * @return Returns the salutation of the contact person.
     */

    public String getSalutation() {
        return salutation;
    }

    /**
     * set the mobile number.
     *
     * @param mobile Mobile number of the contact person.
     */

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * get the mobile number.
     *
     * @return Returns the mobile number of the contact person.
     */

    public String getMobile() {
        return mobile;
    }
}
