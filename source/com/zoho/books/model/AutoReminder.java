/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for auto reminder.
 */

public class AutoReminder {
    private String autoreminderId = "";
    private boolean isEnabled = false;
    private String type = "";
    private String addressType = "";
    private int numberOfDays = 0;
    private String subject = "";
    private String body = "";
    private int order = 0;


    private String paymentReminderId = "";
    private String notificationType = "";


    private List<Invoice> invoices = new ArrayList<Invoice>();

    private List<Customer> customers = new ArrayList<Customer>();

    private List<Organization> organizations = new ArrayList<Organization>();


    /**
     * set the auto reminder id.
     *
     * @param autoreminderId ID of the auto reminder.
     */

    public void setAutoreminderId(String autoreminderId) {
        this.autoreminderId = autoreminderId;
    }

    /**
     * get the auto reminder id.
     *
     * @return Returns the auto reminder id.
     */

    public String getAutoreminderId() {
        return autoreminderId;
    }

    /**
     * set the is enabled.
     *
     * @param isEnabled To determine whether the payment reminder has been enabled or not.
     */

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * get the is enabled.
     *
     * @return Returns true the reminder is enabled else the reminder is disabled.
     */

    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * set the type.
     *
     * @param type Type to determine whether the email has to be sent before or after the due date of invoice.
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * get the type.
     *
     * @return Returns the Type to determine whether the email has to be sent before or after the due date of invoice.
     */

    public String getType() {
        return type;
    }

    /**
     * set the address type.
     *
     * @param addressType Notification type for the payment reminder with option to reminder you, your customer or both.
     */

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * get the address type.
     *
     * @return Returns the Notification type for the payment reminder with option to reminder you, your customer or both.
     */

    public String getAddressType() {
        return addressType;
    }

    /**
     * set the number of days.
     *
     * @param numberOfDays Number of days before or after, the payment reminder email has to be sent.
     */

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     * get the number of days.
     *
     * @return Returns the number of days before or after, the payment reminder email has to be sent.
     */

    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * set the subject of the email.
     *
     * @param subject Subject of the email.
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * get the subject of the email.
     *
     * @return Returns the subject of the email.
     */

    public String getSubject() {
        return subject;
    }

    /**
     * set the body of the email.
     *
     * @param body Message content or body of the email to be sent.
     */

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * get the body of the email.
     *
     * @return Returns the Message content or body of the email to be sent.
     */

    public String getBody() {
        return body;
    }

    /**
     * set the order of the reminder.
     *
     * @param order Order of the reminder.
     */

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * get the order of the reminder.
     *
     * @return Returns the order of the reminder.
     */

    public int getOrder() {
        return order;
    }


    /**
     * set the payment reminder id.
     *
     * @param paymentReminderId ID of the payment reminder.
     */

    public void setPaymentReminderId(String paymentReminderId) {
        this.paymentReminderId = paymentReminderId;
    }

    /**
     * get the payment reminder id.
     *
     * @return Returns the payment reminder id.
     */

    public String getPaymentReminderId() {
        return paymentReminderId;
    }

    /**
     * set the notification type.
     *
     * @param notificationType Type of the notification.
     */

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    /**
     * get the notification type.
     *
     * @return Returns the type of the notification.
     */

    public String getNotificationType() {
        return notificationType;
    }


    /**
     * set list of invoice.
     *
     * @param invoices List of invoice object.
     */

    public void setInvoice(List<Invoice> invoices) throws Exception {
        this.invoices = invoices;
    }

    /**
     * get list of invoice.
     *
     * @return Returns list of invoice object.
     */

    public List<Invoice> getInvoice() {
        return invoices;
    }


    /**
     * set list of customer.
     *
     * @param customers List of customer object.
     */

    public void setCustomer(List<Customer> customers) throws Exception {
        this.customers = customers;
    }

    /**
     * get list of customer.
     *
     * @return Returns list of customer object.
     */

    public List<Customer> getCustomer() {
        return customers;
    }


    /**
     * set list of organization.
     *
     * @param organizations List of organization object.
     */

    public void setOrganization(List<Organization> organizations) throws Exception {
        this.organizations = organizations;
    }

    /**
     * get list of organization.
     *
     * @return Returns list of organization object.
     */

    public List<Organization> getOrganization() {
        return organizations;
    }


    /**
     * Convert AutoReminder object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("is_enabled", isEnabled);
        jsonObject.put("type", type);
        jsonObject.put("address_type", addressType);
        jsonObject.put("number_of_days", numberOfDays);
        jsonObject.put("subject", subject);
        jsonObject.put("body", body);

        return jsonObject;
    }


}
