/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for vendor payment.
 */

public class VendorPayment {
    private String paymentId = "";
    private String vendorId = "";
    private String vendorName = "";
    private String paymentMode = "";
    private String description = "";
    private String date = "";
    private String referenceNumber = "";
    private double exchangeRate = 0.00;
    private double amount = 0.00;
    private String currencySymbol = "";
    private String paidThroughAccountId = "";
    private String paidThroughAccountName = "";

    private double balance = 0.00;

    private List<Bill> bills = new ArrayList<Bill>();


    /**
     * set the payment id.
     *
     * @param paymentId ID of the payment.
     */

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * get the payment id.
     *
     * @return Returns the ID of the payment.
     */

    public String getPaymentId() {
        return paymentId;
    }

    /**
     * set the vendor id.
     *
     * @param vendorId ID of the vendor.
     */

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * get the vendor id.
     *
     * @return Returns the ID of the vendor.
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
     * @return Returns the name of the vendor.
     */

    public String getVendorName() {
        return vendorName;
    }

    /**
     * set the payment mode.
     *
     * @param paymentMode Mode of the payment.
     */

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     * get the payment mode.
     *
     * @return Returns the mode of the payment.
     */

    public String getPaymentMode() {
        return paymentMode;
    }

    /**
     * set the description.
     *
     * @param description Description of the payment.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the payment.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the date.
     *
     * @param date Date the payment is made.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date the payment is made.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number of the payment.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number of the payment.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate exchange rate of the currency.
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
     * set the amount.
     *
     * @param amount Payment amount made to the vendor.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the payment amount made to the vendor.
     */

    public double getAmount() {
        return amount;
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
     * @return Returns the symbol of the currency.
     */

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * set the paid through account id.
     *
     * @param paidThroughAccountId ID of the cash/ bank account the payment is made.
     */

    public void setPaidThroughAccountId(String paidThroughAccountId) {
        this.paidThroughAccountId = paidThroughAccountId;
    }

    /**
     * get the paid through account id.
     *
     * @return Returns the ID of the cash/ bank account the payment is made.
     */

    public String getPaidThroughAccountId() {
        return paidThroughAccountId;
    }

    /**
     * set the paid through account name.
     *
     * @param paidThroughAccountName Name of the cash/ bank account the payment is made.
     */

    public void setPaidThroughAccountName(String paidThroughAccountName) {
        this.paidThroughAccountName = paidThroughAccountName;
    }

    /**
     * get the paid through account name.
     *
     * @return Returns the name of the cash/ bank account the payment is made.
     */

    public String getPaidThroughAccountName() {
        return paidThroughAccountName;
    }


    /**
     * set the balance.
     *
     * @param balance Balance of the payment.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get the balance.
     *
     * @return Returns the balance of the payment.
     */

    public double getBalance() {
        return balance;
    }


    /**
     * set the bills.
     *
     * @param bills Bills of the payment.
     */

    public void setBills(List<Bill> bills) throws Exception {
        this.bills = bills;
    }

    /**
     * get the bills.
     *
     * @return Returns list of Bill object.
     */

    public List<Bill> getBills() {
        return bills;
    }


    /**
     * Convert VendorPayment object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("vendor_id", vendorId);
        jsonObject.put("payment_mode", paymentMode);
        jsonObject.put("description", description);
        jsonObject.put("date", date);
        jsonObject.put("reference_number", referenceNumber);
        jsonObject.put("exchange_rate", exchangeRate);
        jsonObject.put("amount", amount);
        jsonObject.put("paid_through_account_id", paidThroughAccountId);

        if (bills != null) {
            JSONArray billsArr = new JSONArray();

            for (int i = 0; i < bills.size(); i++) {
                JSONObject bill = new JSONObject();

                bill.put("bill_id", bills.get(i).getBillId());
                bill.put("amount_applied", bills.get(i).getAmountApplied());

                billsArr.put(bill);

            }
            jsonObject.put("bills", billsArr);
        }

        return jsonObject;
    }
}
