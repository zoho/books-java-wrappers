/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for payment.
 */

public class Payment {
    private String paymentId = "";
    private String paymentNumber = "";
    private String invoiceId = "";
    private String invoicePaymentId = "";
    private String paymentMode = "";
    private String description = "";
    private String date = "";
    private String referenceNumber = "";
    private double exchangeRate = 0.00;
    private double amount = 0.00;
    private double taxAmountWithheld = 0.00;
    private boolean isSingleInvoicePayment;


    private String billId = "";
    private String billPaymentId = "";
    private String paidThroughAccountId = "";
    private String paidThroughAccountName = "";
    private boolean isSingleBillPayment;


    private String vendorId = "";
    private String vendorName = "";
    private String paidThrough = "";
    private double amountApplied = 0.00;


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
     * set the payment number.
     *
     * @param paymentNumber Number of the payment.
     */

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    /**
     * get the payment number.
     *
     * @return Returns the number of the payment.
     */

    public String getPaymentNumber() {
        return paymentNumber;
    }

    /**
     * set the invoice id.
     *
     * @param invoiceId ID of the invoice.
     */

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * get the invoice id.
     *
     * @return Returns the ID of the invoice.
     */

    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * set the invoice payment id.
     *
     * @param invoicePaymentId ID of the invoice payment.
     */

    public void setInvoicePaymentId(String invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
    }

    /**
     * get the invoice payment id.
     *
     * @return Returns the ID of the invoice payment.
     */

    public String getInvoicePaymentId() {
        return invoicePaymentId;
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
     * @param date Date of the payment has been created.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date of the payment has been made.
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
     * set the amount.
     *
     * @param amount Amount of the payment.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the amount of the payment.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * set the tax amount withheld.
     *
     * @param taxAmountWithheld Amount withheld for the tax.
     */

    public void setTaxAmountWithheld(double taxAmountWithheld) {
        this.taxAmountWithheld = taxAmountWithheld;
    }

    /**
     * get the tax amount withheld.
     *
     * @return Returns the amount withheld for the tax.
     */

    public double getTaxAmountWithheld() {
        return taxAmountWithheld;
    }

    /**
     * set is single invoice payment.
     *
     * @param isSingleInvoicePayment To determine whether the invoice is single payment or not.
     */

    public void setIsSingleInvoicePayment(boolean isSingleInvoicePayment) {
        this.isSingleInvoicePayment = isSingleInvoicePayment;
    }

    /**
     * get is single invoice payment.
     *
     * @return Returns true if the invoice is single payment else returns false.
     */

    public boolean isSingleInvoicePayment() {
        return isSingleInvoicePayment;
    }


    /**
     * set the bill id.
     *
     * @param billId ID fo the bill.
     */

    public void setBillId(String billId) {
        this.billId = billId;
    }

    /**
     * get the bill id.
     *
     * @return Returns the ID fo the bill.
     */

    public String getBillId() {
        return billId;
    }

    /**
     * set the bill payment id.
     *
     * @param billPaymentId ID fo the bill payment.
     */

    public void setBillPaymentId(String billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    /**
     * get the bill payment id.
     *
     * @return Returns the ID fo the bill payment.
     */

    public String getBillPaymentId() {
        return billPaymentId;
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
     * @return Returns the Name of the cash/ bank account the payment is made.
     */

    public String getPaidThroughAccountName() {
        return paidThroughAccountName;
    }

    /**
     * set is single bill payment.
     *
     * @param isSingleBillPayment To determine whether the bill is single payment or not.
     */

    public void setIsSingleBillPayment(boolean isSingleBillPayment) {
        this.isSingleBillPayment = isSingleBillPayment;
    }

    /**
     * get is single bill payment.
     *
     * @return Returns true if the bill is single payment else returns false.
     */

    public boolean isSingleBillPayment() {
        return isSingleBillPayment;
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
     * set the paid through.
     *
     * @param paidThrough Paid through the account.
     */

    public void setPaidThrough(String paidThrough) {
        this.paidThrough = paidThrough;
    }

    /**
     * get the paid through.
     *
     * @return Returns the paid through the account.
     */

    public String getPaidThrough() {
        return paidThrough;
    }

    /**
     * set the amount applied.
     *
     * @param amountApplied Amount applied for the payment.
     */

    public void setAmountApplied(double amountApplied) {
        this.amountApplied = amountApplied;
    }

    /**
     * get the amount applied.
     *
     * @return Returns the amount applied for the payment.
     */

    public double getAmountApplied() {
        return amountApplied;
    }


}
