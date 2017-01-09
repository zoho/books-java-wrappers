/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for manual reminder.
 */

public class ManualReminder {
    private String manualreminderId = "";
    private String type = "";
    private String subject = "";
    private String body = "";
    private boolean ccMe = false;

    private List<Invoice> invoices = new ArrayList<Invoice>();

    private List<Customer> customers = new ArrayList<Customer>();

    private List<Organization> organizations = new ArrayList<Organization>();


    /**
     * set the manual reminder id.
     *
     * @param manualreminderId ID of the manual reminder.
     */

    public void setManualreminderId(String manualreminderId) {
        this.manualreminderId = manualreminderId;
    }

    /**
     * get the manual reminder id.
     *
     * @return Returns the ID of the manual reminder.
     */

    public String getManualreminderId() {
        return manualreminderId;
    }

    /**
     * set the type.
     *
     * @param type Type of the manual reminder.
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * get the type.
     *
     * @return Returns the Type of the manual reminder.
     */

    public String getType() {
        return type;
    }

    /**
     * set the subject.
     *
     * @param subject Subject of the email.
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * get the subject.
     *
     * @return Returns the subject of the email.
     */

    public String getSubject() {
        return subject;
    }

    /**
     * set the body.
     *
     * @param body Message content or body of the email to be sent.
     */

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * get the body.
     *
     * @return Returns the message content or body of the email to be sent.
     */

    public String getBody() {
        return body;
    }

    /**
     * set cc me.
     *
     * @param ccMe To send a carbon copy of the email back to you.
     */

    public void setCcMe(boolean ccMe) {
        this.ccMe = ccMe;
    }

    /**
     * get cc me.
     *
     * @return Returns true if the carbon copy of the email is back to you else returns false.
     */

    public boolean isCcMe() {
        return ccMe;
    }


    /**
     * set the invoices.
     *
     * @param invoices Invoices for the manual reminder.
     */

    public void setInvoice(List<Invoice> invoices) throws Exception {
        this.invoices = invoices;
    }

    /**
     * get the invoices.
     *
     * @return Returns list of Invoice object.
     */

    public List<Invoice> getInvoice() {
        return invoices;
    }


    /**
     * set the customers.
     *
     * @param customers Customers for the manual reminder.
     */

    public void setCustomer(List<Customer> customers) throws Exception {
        this.customers = customers;
    }

    /**
     * get the customers.
     *
     * @return Returns list of Customer object.
     */

    public List<Customer> getCustomer() {
        return customers;
    }


    /**
     * set the organizations.
     *
     * @param organizations Organizations for the manual reminder.
     */

    public void setOrganization(List<Organization> organizations) throws Exception {
        this.organizations = organizations;
    }

    /**
     * get the organizations.
     *
     * @return Returns list of Organization object.
     */

    public List<Organization> getOrganization() {
        return organizations;
    }


    /**
     * Convert ManualReminder object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("subject", subject);
        jsonObject.put("body", body);
        jsonObject.put("cc_me", ccMe);

        return jsonObject;
    }
}
