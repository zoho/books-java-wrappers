/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for contact person.
 */

public class ContactPerson {


    private String contactPersonId = "";
    private String salutation = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String phone = "";
    private String mobile = "";
    private boolean isPrimaryContact = false;

    private String contactId = "";

    private boolean isAddedInPortal;
    private boolean canInvite;


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
     * @return Returns the contact person id.
     */

    public String getContactPersonId() {
        return contactPersonId;
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

    /**
     * set is primary contact.
     *
     * @param isPrimaryContact Whether this is the primary contact of the contact person or not.
     */

    public void setIsPrimaryContact(boolean isPrimaryContact) {
        this.isPrimaryContact = isPrimaryContact;
    }

    /**
     * get is primary contact.
     *
     * @return Returns true if the contact is primary else return false.
     */

    public boolean isPrimaryContact() {
        return isPrimaryContact;
    }


    /**
     * set the contact id.
     *
     * @param contactId ID of the contact.
     */

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     * get the contact id.
     *
     * @return Returns the contact id.
     */

    public String getContactId() {
        return contactId;
    }


    /**
     * Get the contact person is added in portal or not.
     *
     * @return Returns true if the contact person is added in portal else returns false.
     */

    public boolean isAddedInPortal() {
        return isAddedInPortal;
    }

    /**
     * Set the contact person is added in portal or not.
     *
     * @param isAddedInPortal True or false to set the contact person is added in portal.
     */

    public void setAddedInPortal(boolean isAddedInPortal) {
        this.isAddedInPortal = isAddedInPortal;
    }

    /**
     * Get the contact person can be invite again or not.
     *
     * @return Returns true if the contact person can be invite again else returns false.
     */

    public boolean isCanInvite() {
        return canInvite;
    }

    /**
     * Set the contact person can be invite again.
     *
     * @param canInvite True or false to set the contact person can be invite again or not.
     */

    public void setCanInvite(boolean canInvite) {
        this.canInvite = canInvite;
    }

    /**
     * Convert the ContactPerson object into JSONObject.
     *
     * @return Returns the JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (contactId != null && !contactId.equals("")) {
            jsonObject.put("contact_id", contactId);
        }

        if(contactPersonId != null && !contactPersonId.equals(""))
        {
            jsonObject.put("contact_person_id", contactPersonId);
        }

        if (salutation != null) {
            jsonObject.put("salutation", salutation);
        }

        if (firstName != null) {
            jsonObject.put("first_name", firstName);
        }

        if (lastName != null) {
            jsonObject.put("last_name", lastName);
        }

        if (email != null) {
            jsonObject.put("email", email);
        }

        if (phone != null) {
            jsonObject.put("phone", phone);
        }

        if (mobile != null) {
            jsonObject.put("mobile", mobile);
        }
        if ((Boolean) isPrimaryContact != null) {
            jsonObject.put("is_primary_contact", isPrimaryContact);
        }


        return jsonObject;
    }

}
