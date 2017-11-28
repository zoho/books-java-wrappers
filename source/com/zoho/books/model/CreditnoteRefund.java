/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for creditnote refund.
 */

public class CreditnoteRefund {
    private String creditnoteRefundId = "";
    private String creditnoteId = "";
    private String date = "";
    private String refundMode = "";
    private String referenceNumber = "";
    private String creditnoteNumber = "";
    private String customerName = "";
    private String description = "";
    private double amountBcy = 0.00;
    private double amountFcy = 0.00;

    private double amount = 0.00;
    private double exchangeRate = 0.00;
    private String fromAccountId = "";
    private String fromAccountName = "";


    /**
     * set the creditnote refund id.
     *
     * @param creditnoteRefundId ID of the creditnote refund.
     */

    public void setCreditnoteRefundId(String creditnoteRefundId) {
        this.creditnoteRefundId = creditnoteRefundId;
    }

    /**
     * get the creditnote refund id.
     *
     * @return Returns the creditnote refund id.
     */

    public String getCreditnoteRefundId() {
        return creditnoteRefundId;
    }

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
     * @return Returns the date the credit note is created.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the refund mode.
     *
     * @param refundMode Mode of refund for the credit note refund amount.
     */

    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }

    /**
     * get the refund mode.
     *
     * @return Returns the mode of refund for the credit note refund amount.
     */

    public String getRefundMode() {
        return refundMode;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number for the refund recorded.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number for the refund recorded.
     */

    public String getReferenceNumber() {
        return referenceNumber;
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
     * set the customer name.
     *
     * @param customerName Name of the customer.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the customer name.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the description.
     *
     * @param description Description for the refund recorded.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description for the refund recorded.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the amount bcy.
     *
     * @param amountBcy Bcy amount for the refund.
     */

    public void setAmountBcy(double amountBcy) {
        this.amountBcy = amountBcy;
    }

    /**
     * get the amount bcy.
     *
     * @return Returns the bcy amount for the refund.
     */

    public double getAmountBcy() {
        return amountBcy;
    }

    /**
     * set the amount fcy.
     *
     * @param amountFcy Fcy amount for the refund.
     */

    public void setAmountFcy(double amountFcy) {
        this.amountFcy = amountFcy;
    }

    /**
     * get the amount fcy.
     *
     * @return Returns the fcy amount for the refund.
     */

    public double getAmountFcy() {
        return amountFcy;
    }


    /**
     * set the amount.
     *
     * @param amount Amount refunded from the credit note.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the amount refunded from the credit note.
     */

    public double getAmount() {
        return amount;
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
     * @return Returns the account id from which credit note is refunded.
     */

    public String getFromAccountId() {
        return fromAccountId;
    }

    /**
     * set the from account name.
     *
     * @param fromAccountName The account from which credit note is refunded.
     */

    public void setFromAccountName(String fromAccountName) {
        this.fromAccountName = fromAccountName;
    }

    /**
     * get the from account name.
     *
     * @return Returns the account name from which credit note is refunded.
     */

    public String getFromAccountName() {
        return fromAccountName;
    }


    /**
     * Convert CreditnoteRefund object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("date", date);
        jsonObject.put("refund_mode", refundMode);
        jsonObject.put("reference_number", referenceNumber);
        jsonObject.put("amount", amount);
        jsonObject.put("exchange_rate", exchangeRate);
        jsonObject.put("from_account_id", fromAccountId);

        return jsonObject;
    }
}
