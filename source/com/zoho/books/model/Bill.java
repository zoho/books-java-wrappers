/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for bill.
 */

public class Bill {
    private String billNumber = "";
    private String billPaymentId = "";
    private String billId = "";
    private double total = 0.00;
    private double balance = 0.00;
    private double amountApplied = 0.00;
    private String date = "";
    private String dueDate = "";


    private String vendorId = "";
    private String vendorName = "";
    private double unusedCreditsPayableAmount = 0.00;
    private String status = "";
    private String referenceNumber = "";
    private String dueByDays = "";
    private String dueInDays = "";
    private String currencyId = "";
    private String currencyCode = "";
    private String currencySymbol = "";
    private int pricePrecision = 0;
    private double exchangeRate = 0.00;
    private double subTotal = 0.00;
    private double taxTotal = 0.00;
    private double paymentMade = 0.00;
    private String createdTime = "";
    private String lastModifiedTime = "";
    private int source = 0;
    private String referenceId = "";
    private String notes = "";
    private String terms = "";
    private String attachmentName = "";

    private String dueDays = "";


    private List<LineItem> lineItems = new ArrayList<LineItem>();

    private List<Tax> taxes = new ArrayList<Tax>();

    private Address billingAddress = new Address();

    private List<Payment> payments = new ArrayList<Payment>();


    /**
     * set the bill number.
     *
     * @param billNumber The bill number.
     */

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * get the bill number.
     *
     * @return Returns the bill number.
     */

    public String getBillNumber() {
        return billNumber;
    }

    /**
     * set the bill payment id.
     *
     * @param billPaymentId ID of the bill payment.
     */

    public void setBillPaymentId(String billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    /**
     * get the bill payment id.
     *
     * @return Returns the bill payment id.
     */

    public String getBillPaymentId() {
        return billPaymentId;
    }

    /**
     * set the bill id.
     *
     * @param billId ID of the bill.
     */

    public void setBillId(String billId) {
        this.billId = billId;
    }

    /**
     * get the bill id.
     *
     * @return Returns the bill id.
     */

    public String getBillId() {
        return billId;
    }

    /**
     * get the bill id.
     *
     * @return Returns the bill id.
     */

    public String getId() {
        return billId;
    }

    /**
     * set the total.
     *
     * @param total Total of the bill.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the bill.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the balance.
     *
     * @param balance Balance of the bill.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get the balance.
     *
     * @return Returns the balance of the bill.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * set the amount applied.
     *
     * @param amountApplied Amount applied of the bill.
     */

    public void setAmountApplied(double amountApplied) {
        this.amountApplied = amountApplied;
    }

    /**
     * get the amount applied.
     *
     * @return Returns the amount applied of the bill.
     */

    public double getAmountApplied() {
        return amountApplied;
    }

    /**
     * set the date.
     *
     * @param date The date the bill was created.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the amount applied.
     *
     * @return Returns the date the bill was created.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the due date.
     *
     * @param dueDate Date bill is due.
     */

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * get the due date.
     *
     * @return Returns the date bill is due.
     */

    public String getDueDate() {
        return dueDate;
    }


    /**
     * set the vendor id.
     *
     * @param vendorId ID of the vendor the bill has to be created.
     */

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * get the vendor id.
     *
     * @return Returns the vendor id the bill has to be created.
     */

    public String getVendorId() {
        return vendorId;
    }

    /**
     * set the vendor name.
     *
     * @param vendorName Name of the vendor.
     */

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * get the vendor name.
     *
     * @return Returns the vendor name.
     */

    public String getVendorName() {
        return vendorName;
    }

    /**
     * set the unused credits payable amount.
     *
     * @param unusedCreditsPayableAmount Amount of the unused credits.
     */

    public void setUnusedCreditsPayableAmount(double unusedCreditsPayableAmount) {
        this.unusedCreditsPayableAmount = unusedCreditsPayableAmount;
    }

    /**
     * get the unused credits payable amount.
     *
     * @return Returns the unused credits payable amount of the bill.
     */

    public double getUnusedCreditsPayableAmount() {
        return unusedCreditsPayableAmount;
    }

    /**
     * set the status.
     *
     * @param status Status of the bill.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the bill.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number of the bill.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number of the bill.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the due by days.
     *
     * @param dueByDays Due by days of the bill.
     */

    public void setDueByDays(String dueByDays) {
        this.dueByDays = dueByDays;
    }

    /**
     * get the due by days.
     *
     * @return Returns the due by days of the bill.
     */

    public String getDueByDays() {
        return dueByDays;
    }

    /**
     * set the due in days.
     *
     * @param dueInDays Due in days of the bill.
     */

    public void setDueInDays(String dueInDays) {
        this.dueInDays = dueInDays;
    }

    /**
     * get the due in days.
     *
     * @return Returns the due in days of the bill.
     */

    public String getDueInDays() {
        return dueInDays;
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
     * @return Returns the currency id.
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
     * @return Returns the currency code.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the currency symbol.
     *
     * @param currencySymbol Symbol of the currency.
     */

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * get the currency symbol.
     *
     * @return Returns the currency symbol.
     */

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * set the price precision.
     *
     * @param pricePrecision Price precision of the bill.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * get the price precision.
     *
     * @return Returns the price precision.
     */

    public int getPricePrecision() {
        return pricePrecision;
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
     * set the sub total.
     *
     * @param subTotal Sub total of the bill.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the bill.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set the tax total.
     *
     * @param taxTotal Tax total of the bill.
     */

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * get the tax total.
     *
     * @return Returns the tax total of the bill.
     */

    public double getTaxTotal() {
        return taxTotal;
    }

    /**
     * set the payment made.
     *
     * @param paymentMade Payment made for the bill.
     */

    public void setPaymentMade(double paymentMade) {
        this.paymentMade = paymentMade;
    }

    /**
     * get the payment made.
     *
     * @return Returns the payment made of the bill.
     */

    public double getPaymentMade() {
        return paymentMade;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time of the bill.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the bill.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time of the bill.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time of the bill.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * set the source.
     *
     * @param source Source of the bill.
     */

    public void setSource(int source) {
        this.source = source;
    }

    /**
     * get the source.
     *
     * @return Returns the source of the bill.
     */

    public int getSource() {
        return source;
    }

    /**
     * set the reference id.
     *
     * @param referenceId ID of the reference.
     */

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * get the reference id.
     *
     * @return Returns the reference id of the bill.
     */

    public String getReferenceId() {
        return referenceId;
    }

    /**
     * set the notes.
     *
     * @param notes Notes of the bill.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the notes of the bill.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * set the terms.
     *
     * @param terms Terms of the bill.
     */

    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * get the terms.
     *
     * @return Returns the terms of the bill.
     */

    public String getTerms() {
        return terms;
    }

    /**
     * set the attachment name.
     *
     * @param attachmentName Name of the attachment for the bill.
     */

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * get the terms.
     *
     * @return Returns the attachment name of the bill.
     */

    public String getAttachmentName() {
        return attachmentName;
    }


    /**
     * set the due days.
     *
     * @param dueDays Due days for the bill.
     */

    public void setDueDays(String dueDays) {
        this.dueDays = dueDays;
    }

    /**
     * get the due days.
     *
     * @return Returns the due days of the bill.
     */

    public String getDueDays() {
        return dueDays;
    }


    /**
     * set list of line items.
     *
     * @param lineItems List of lineitem object.
     */

    public void setLineItems(List<LineItem> lineItems) throws Exception {
        this.lineItems = lineItems;
    }

    /**
     * get list of line item.
     *
     * @return Returns list of lineitem object.
     */

    public List<LineItem> getLineItems() {
        return this.lineItems;
    }


    /**
     * set list of tax.
     *
     * @param taxes List of tax object.
     */

    public void setTaxes(List<Tax> taxes) throws Exception {
        this.taxes = taxes;
    }

    /**
     * get list of tax.
     *
     * @return Returns list of tax object.
     */

    public List<Tax> getTaxes() {
        return this.taxes;
    }


    /**
     * set the billing address.
     *
     * @param billingAddress BillingAddress object.
     */

    public void setBillingAddress(Address billingAddress) throws Exception {
        this.billingAddress = billingAddress;
    }

    /**
     * get the billing address.
     *
     * @return Returns the BillingAddress object.
     */

    public Address getBillingAddress() {
        return this.billingAddress;
    }


    /**
     * set list of payment.
     *
     * @param payments List of payment object.
     */

    public void setPayments(List<Payment> payments) throws Exception {
        this.payments = payments;
    }

    /**
     * get list of payemnt.
     *
     * @return Returns list of payment object.
     */

    public List<Payment> getPayments() {
        return payments;
    }


    /**
     * Convert Bill object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("vendor_id", vendorId);
        jsonObject.put("bill_number", billNumber);
        jsonObject.put("reference_number", referenceNumber);
        jsonObject.put("date", date);
        jsonObject.put("due_date", dueDate);
        jsonObject.put("exchange_rate", exchangeRate);

        if (lineItems != null) {
            JSONArray li = new JSONArray();
            for (int i = 0; i < lineItems.size(); i++) {
                li.put(lineItems.get(i).toJSON());
            }
            jsonObject.put("line_items", li);
        }

        jsonObject.put("notes", notes);
        jsonObject.put("terms", terms);

        return jsonObject;
    }

}
