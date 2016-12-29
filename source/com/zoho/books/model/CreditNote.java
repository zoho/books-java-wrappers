/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for credit notes.
 */

public class CreditNote {

    private String creditnoteId = "";
    private String creditnoteNumber = "";
    private String status = "";
    private String referenceNumber = "";
    private String date = "";
    private double total = 0.00;
    private double balance = 0.00;
    private String customerId = "";
    private String customerName = "";
    private String currencyId = "";
    private String currencyCode = "";
    private double exchangeRate = 0.00;
    private String lastModifiedTime = "";
    private String source = "";
    private boolean isEmailed = true;


    private String createdTime = "";

    private int pricePrecision = 0;
    private String templateId = "";
    private double subTotal = 0.00;
    private double totalCreditsUsed = 0.00;
    private double totalRefundedAmount = 0.00;
    private String notes = "";
    private String terms = "";


    private String refundMode = "";
    private double amount = 0.00;
    private String fromAccountId = "";

    private String[] contactPersons = {};

    private List<LineItem> lineItems = new ArrayList<LineItem>();

    private List<Tax> taxes = new ArrayList<Tax>();

    private Address billingAddress = new Address();

    private Address shippingAddress = new Address();

    private List<EmailHistory> emailHistory = new ArrayList<EmailHistory>();


    /**
     * set the creditnote id.
     *
     * @param creditnoteId ID of the creditnote.
     */

    public void setCreditnoteId(String creditnoteId) {
        this.creditnoteId = creditnoteId;
    }

    /**
     * get the creditnote id.
     *
     * @return Returns the creditnote id.
     */

    public String getCreditnoteId() {
        return creditnoteId;
    }

    /**
     * set the creditnote number.
     *
     * @param creditnoteNumber Number of the creditnote.
     */

    public void setCreditnoteNumber(String creditnoteNumber) {
        this.creditnoteNumber = creditnoteNumber;
    }

    /**
     * get the creditnote number.
     *
     * @return Returns the creditnote number.
     */

    public String getCreditnoteNumber() {
        return creditnoteNumber;
    }

    /**
     * set the status.
     *
     * @param status Status of the creditnote.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the creditnote.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number of the creditnote.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number of the creditnote.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the date.
     *
     * @param date The date the credit note is created.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the created date of the creditnote.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the total.
     *
     * @param total Total of the creditnote.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the creditnote.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the balance.
     *
     * @param balance Balance of the creditnote.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get the balance.
     *
     * @return Returns the balance of the creditnote.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer the credit note has to be created.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the customer id of the creditnote.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the customer name.
     *
     * @param customerName Name of the customer the credit note has to be created.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the customer name of the creditnote.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the currency id of the creditnote.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the currency code.
     *
     * @param currencyCode Code of the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the currency code of the creditnote.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate Exchange rate of the currency.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchange rate.
     *
     * @return Returns the exchange rate of the currency.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time of the creditnote.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time of the creditnote.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * set the source.
     *
     * @param source Source of the creditnote.
     */

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * get the source.
     *
     * @return Returns the source of the creditnote.
     */

    public String getSource() {
        return source;
    }

    /**
     * set is emailed.
     *
     * @param isEmailed Whether the creditnote is emailed or not.
     */

    public void setIsEmailed(boolean isEmailed) {
        this.isEmailed = isEmailed;
    }

    /**
     * get is emailed.
     *
     * @return Returns true if the creditnote is emailed else returns false.
     */

    public boolean isEmailed() {
        return isEmailed;
    }


    /**
     * set the created time.
     *
     * @param createdTime Created time of the creditnote.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the creditnote.
     */

    public String getCreatedTime() {
        return createdTime;
    }


    /**
     * set the price precision.
     *
     * @param pricePrecision Price Precision of the creditnote.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * get the price precision.
     *
     * @return Returns the price precision of the creditnote.
     */

    public int getPricePrecision() {
        return pricePrecision;
    }

    /**
     * set the template id.
     *
     * @param templateId ID of the template.
     */

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * get the template id.
     *
     * @return Returns the template id of the templates.
     */

    public String getTemplateId() {
        return templateId;
    }

    /**
     * set the sub total.
     *
     * @param subTotal Sub total of the creditnote.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the creditnote.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set the total credits used.
     *
     * @param totalCreditsUsed Total credits used for the creditnote.
     */

    public void setTotalCreditsUsed(double totalCreditsUsed) {
        this.totalCreditsUsed = totalCreditsUsed;
    }

    /**
     * get the total credits used.
     *
     * @return Returns the total credits used for the creditnote.
     */

    public double getTotalCreditsUsed() {
        return totalCreditsUsed;
    }

    /**
     * set the total refunded amount.
     *
     * @param totalRefundedAmount Total refunded amount of the creditnote.
     */

    public void setTotalRefundedAmount(double totalRefundedAmount) {
        this.totalRefundedAmount = totalRefundedAmount;
    }

    /**
     * get the total refunded amount.
     *
     * @return Returns the total refunded amount of the creditnote.
     */

    public double getTotalRefundedAmount() {
        return totalRefundedAmount;
    }

    /**
     * set the notes.
     *
     * @param notes Notes of the creditnote.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the notes of the creditnote.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * set the terms.
     *
     * @param terms Terms of the creditnote.
     */

    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * get the terms.
     *
     * @return Returns the terms of the creditnote.
     */

    public String getTerms() {
        return terms;
    }


    /**
     * set the refund mode.
     *
     * @param refundMode Refund mode of the creditnote.
     */

    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }

    /**
     * get the refund mode.
     *
     * @return Returns the refund mode of the credit note.
     */

    public String getRefundMode() {
        return refundMode;
    }

    /**
     * set the amount.
     *
     * @param amount Amount of the creditnote.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the amount of the credit note.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * set the from account id.
     *
     * @param fromAccountId The account from which credit note is refunded.
     */

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    /**
     * get the from account id.
     *
     * @return Returns the from account id of the credit note.
     */

    public String getFromAccountId() {
        return fromAccountId;
    }


    /**
     * set the contact persons.
     *
     * @param contactPersons Contact person(s) for whom credit note has to be sent.
     */

    public void setContactPersons(String[] contactPersons) throws Exception {
        this.contactPersons = contactPersons;
    }

    /**
     * get the contact persons.
     *
     * @return Returns array of contact persons of the credit note.
     */

    public String[] getContactPersons() {
        return contactPersons;
    }


    /**
     * set the line items.
     *
     * @param lineItems Line items of the creditnote.
     */

    public void setLineItems(List<LineItem> lineItems) throws Exception {
        this.lineItems = lineItems;
    }

    /**
     * get the line items.
     *
     * @return Returns list of LineItem object.
     */

    public List<LineItem> getLineItems() {
        return lineItems;
    }


    /**
     * set the taxes.
     *
     * @param taxes Taxes of the creditnote.
     */

    public void setTaxes(List<Tax> taxes) throws Exception {
        this.taxes = taxes;
    }

    /**
     * get the taxes.
     *
     * @return Returns list of Tax object.
     */

    public List<Tax> getTaxes() {
        return taxes;
    }


    /**
     * set the billing address.
     *
     * @param billingAddress BillingAddress of the creditnote.
     */

    public void setBillingAddress(Address billingAddress) throws Exception {
        this.billingAddress = billingAddress;
    }

    /**
     * get the billing address.
     *
     * @return Returns a BillingAddress object.
     */

    public Address getBillingAddress() {
        return billingAddress;
    }


    /**
     * set the shipping address.
     *
     * @param shippingAddress ShippingAddress of the creditnote.
     */

    public void setShippingAddress(Address shippingAddress) throws Exception {
        this.shippingAddress = shippingAddress;
    }

    /**
     * get the shipping address.
     *
     * @return Returns a ShippingAddress object.
     */

    public Address getShippingAddress() {
        return shippingAddress;
    }


    /**
     * set the email history.
     *
     * @param emailHistory Email history of the creditnote.
     */

    public void setEmailHistory(List<EmailHistory> emailHistory) throws Exception {
        this.emailHistory = emailHistory;
    }

    /**
     * get the email history.
     *
     * @return Returns list of EmailHistory object.
     */

    public List<EmailHistory> getEmailHistory() {
        return emailHistory;
    }


    /**
     * Convert CreditNote object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("customer_id", customerId);

        if (contactPersons != null) {
            JSONArray contactPerson = new JSONArray();

            for (int i = 0; i < contactPersons.length; i++) {
                contactPerson.put(contactPersons[i]);
            }
            jsonObject.put("contact_persons", contactPerson);
        }

        jsonObject.put("creditnote_number", creditnoteNumber);
        jsonObject.put("template_id", templateId);
        jsonObject.put("date", date);
        jsonObject.put("exchange_rate", exchangeRate);

        if (lineItems != null && !lineItems.isEmpty()) {
            JSONArray li = new JSONArray();

            for (int i = 0; i < lineItems.size(); i++) {
                li.put(lineItems.get(i).toJSON());
            }
            jsonObject.put("line_items", li);
        }

        return jsonObject;
    }

}
