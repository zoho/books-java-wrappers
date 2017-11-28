/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * VendorCredit refund class is used to create an object for vendor credit refund.
 *
 * @author ramesh-2099
 */

public class VendorCreditRefund {

    private String vendorCreditRefundId;
    private String vendorCreditId;
    private String date;
    private String refundMode;
    private String referenceNumber;
    private String description;
    private double amountBcy;
    private double amountFcy;
    private String vendorCreditNumber;
    private String vendorName;

    private String customerName;
    private String accountId;
    private String accountName;

    private double amount;
    private double exchangeRate;


    /**
     * Get the vendor credit refund id.
     *
     * @return Returns the vendor credit refund id.
     */

    public String getVendorCreditRefundId() {
        return vendorCreditRefundId;
    }

    /**
     * Set the vendor credit refund id.
     *
     * @param vendorCreditRefundId ID of the vendor credit refund id.
     */

    public void setVendorCreditRefundId(String vendorCreditRefundId) {
        this.vendorCreditRefundId = vendorCreditRefundId;
    }

    /**
     * Get the vendor credit id.
     *
     * @return Returns the vendor credit id.
     */

    public String getVendorCreditId() {
        return vendorCreditId;
    }

    /**
     * Set the vendor credit id.
     *
     * @param vendorCreditId ID of the vendor credit.
     */

    public void setVendorCreditId(String vendorCreditId) {
        this.vendorCreditId = vendorCreditId;
    }

    /**
     * Get the date.
     *
     * @return Returns the date.
     */

    public String getDate() {
        return date;
    }

    /**
     * Set the date.
     *
     * @param date Vendor credit refund date.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the refund mode.
     *
     * @return Returns the refund mode.
     */

    public String getRefundMode() {
        return refundMode;
    }

    /**
     * Set the refund mode.
     *
     * @param refundMode Mode of the refund.
     */

    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }

    /**
     * Get the reference number.
     *
     * @return Returns the reference number.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Set the reference number.
     *
     * @param referenceNumber Reference number for the vendor credit refund.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * Get the description.
     *
     * @return Returns the description.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * @param description Description for the vendor credit refund.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the amount in BCY.
     *
     * @return Returns the amount in BCY.
     */

    public double getAmountBcy() {
        return amountBcy;
    }

    /**
     * Set the amount in BCY.
     *
     * @param amountBcy Amount in BCY.
     */

    public void setAmountBcy(double amountBcy) {
        this.amountBcy = amountBcy;
    }

    /**
     * Get the amount in FCY.
     *
     * @return Returns the amount in FCY.
     */

    public double getAmountFcy() {
        return amountFcy;
    }

    /**
     * Set the amount in FCY.
     *
     * @param amountFcy Amount in FCY.
     */

    public void setAmountFcy(double amountFcy) {
        this.amountFcy = amountFcy;
    }

    /**
     * Get the vendor credit number.
     *
     * @return Returns the vendor credit number.
     */

    public String getVendorCreditNumber() {
        return vendorCreditNumber;
    }

    /**
     * Set the vendor credit number.
     *
     * @param vendorCreditNumber Vendor credit number.
     */

    public void setVendorCreditNumber(String vendorCreditNumber) {
        this.vendorCreditNumber = vendorCreditNumber;
    }

    /**
     * Get the vendor name.
     *
     * @return Returns the vendor name.
     */

    public String getVendorName() {
        return vendorName;
    }

    /**
     * Set the vendor name.
     *
     * @param vendorName Name of the vendor.
     */

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * Get the customer name.
     *
     * @return Returns the customer name.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the customer name.
     *
     * @param customerName Name of the customer.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    /**
     * Get the account id.
     *
     * @return Returns the account id.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * Set the account id.
     *
     * @param accountId ID of the account.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Get the account name.
     *
     * @return Returns the account name.
     */

    public String getAccountName() {
        return accountName;
    }

    /**
     * Set the account name.
     *
     * @param accountName Name of the account.
     */

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    /**
     * Get the amount.
     *
     * @return Returns the amount.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * Set the amount.
     *
     * @param amount Amount of the vendor credit.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Get the exchange rate.
     *
     * @return Returns the exchange rate.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Set the exchange rate.
     *
     * @param exchangeRate Exchange rate of the currency.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * Convert the VendorCredit object into JSONObject.
     *
     * @return Returns the JSONObject.
     * @throws Exception
     */

    public JSONObject toJSON() throws Exception {

        JSONObject jsonObject = new JSONObject();

        if (date != null) {
            jsonObject.put("date", date);
        }
        if (refundMode != null) {
            jsonObject.put("refund_mode", refundMode);
        }
        if (referenceNumber != null) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if ((Double) amount != null) {
            jsonObject.put("amount", amount);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (accountId != null) {
            jsonObject.put("account_id", accountId);
        }
        if (description != null) {
            jsonObject.put("description", description);
        }

        return jsonObject;
    }


}
