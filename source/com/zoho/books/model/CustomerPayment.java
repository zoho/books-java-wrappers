/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for customer payment.
 */

public class CustomerPayment {

    private String paymentId = "";
    private String customerId = "";
    private String customerName = "";
    private String paymentMode = "";
    private String date = "";
    private String accountId = "";
    private String accountName = "";
    private double exchangeRate = 0.00;
    private double amount = 0.00;
    private double bankCharges = 0.00;
    private String taxAccountId = "";
    private String taxAccountName = "";
    private double taxAmountWithheld = 0.00;
    private String description = "";
    private String referenceNumber = "";
    private boolean isSingleInvoicePayment = false;

    private String paymentNumber = "";
    private String invoiceNumbers = "";
    private double bcyAmount = 0.00;
    private double unusedAmount = 0.00;
    private double bcyUnusedAmount = 0.00;


    private List<Invoice> invoices = new ArrayList<Invoice>();


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
     * @return Returns the payment id.
     */

    public String getPaymentId() {
        return paymentId;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the customer id.
     */

    public String getCustomerId() {
        return customerId;
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
     * set the payment mode.
     *
     * @param paymentMode Mode of payment for the amount received.
     */

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     * get the payment mode.
     *
     * @return Returns the mode of payment for the amount received.
     */

    public String getPaymentMode() {
        return paymentMode;
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
     * set the account id.
     *
     * @param accountId ID of the cash/ bank account the payment has to be deposited.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * get the account id.
     *
     * @return Returns the account id.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * set the account name.
     *
     * @param accountName Name of the account.
     */

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * get the account name.
     *
     * @return Returns the account name.
     */

    public String getAccountName() {
        return accountName;
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
     * @param amount Payment amount made by the customer.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the payment amount made by the customer.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * set the bank charges.
     *
     * @param bankCharges Bank charges incurred.
     */

    public void setBankCharges(double bankCharges) {
        this.bankCharges = bankCharges;
    }

    /**
     * get the bank charges.
     *
     * @return Returns the bank charges incurred.
     */

    public double getBankCharges() {
        return bankCharges;
    }

    /**
     * set the tax account id.
     *
     * @param taxAccountId ID of the tax account, in case of withholding tax.
     */

    public void setTaxAccountId(String taxAccountId) {
        this.taxAccountId = taxAccountId;
    }

    /**
     * get the tax account id.
     *
     * @return Returns the id of the tax account, in case of withholding tax.
     */

    public String getTaxAccountId() {
        return taxAccountId;
    }

    /**
     * set the tax account name.
     *
     * @param taxAccountName Name of the tax account, in case of withholding tax.
     */

    public void setTaxAccountName(String taxAccountName) {
        this.taxAccountName = taxAccountName;
    }

    /**
     * get the tax account name.
     *
     * @return Returns the name of the tax account, in case of withholding tax.
     */

    public String getTaxAccountName() {
        return taxAccountName;
    }

    /**
     * set the tax amount withheld.
     *
     * @param taxAmountWithheld Amount withheld for tax.
     */

    public void setTaxAmountWithheld(double taxAmountWithheld) {
        this.taxAmountWithheld = taxAmountWithheld;
    }

    /**
     * get the tax amount withheld.
     *
     * @return Returns the amount withheld for tax.
     */

    public double getTaxAmountWithheld() {
        return taxAmountWithheld;
    }

    /**
     * set the description.
     *
     * @param description Description for the customer payment.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description for the customer payment.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number for the customer payment.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number for the customer payment.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set is single invoice payment.
     *
     * @param isSingleInvoicePayment Whether is this a single invoice payment or not.
     */

    public void setIsSingleInvoicePayment(boolean isSingleInvoicePayment) {
        this.isSingleInvoicePayment = isSingleInvoicePayment;
    }

    /**
     * get is single invoice payment.
     *
     * @return Returns true if the payment is single invoice else returns false.
     */

    public boolean isSingleInvoicePayment() {
        return isSingleInvoicePayment;
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
     * set the invoice numbers.
     *
     * @param invoiceNumbers Numbers of the invoice.
     */

    public void setInvoiceNumbers(String invoiceNumbers) {
        this.invoiceNumbers = invoiceNumbers;
    }

    /**
     * get the invoice numbers.
     *
     * @return Returns the numbers of the invoice.
     */

    public String getInvoiceNumbers() {
        return invoiceNumbers;
    }

    /**
     * set the bcy amount.
     *
     * @param bcyAmount Bcy amount of the payment.
     */

    public void setBcyAmount(double bcyAmount) {
        this.bcyAmount = bcyAmount;
    }

    /**
     * get the bcy amount.
     *
     * @return Returns the bcy amount of the payment.
     */

    public double getBcyAmount() {
        return bcyAmount;
    }

    /**
     * set the unused amount.
     *
     * @param unusedAmount Unused amount of the payment.
     */

    public void setUnusedAmount(double unusedAmount) {
        this.unusedAmount = unusedAmount;
    }

    /**
     * get the unused amount.
     *
     * @return Returns the unused amount of the payment.
     */

    public double getUnusedAmount() {
        return unusedAmount;
    }

    /**
     * set the bcy unused amount.
     *
     * @param bcyUnusedAmount Bcy unused amount of the payment.
     */

    public void setBcyUnusedAmount(double bcyUnusedAmount) {
        this.bcyUnusedAmount = bcyUnusedAmount;
    }

    /**
     * get the bcy unused amount.
     *
     * @return Returns the bcy unused amount of the payment.
     */

    public double getBcyUnusedAmount() {
        return bcyUnusedAmount;
    }


    /**
     * set the invoice.
     *
     * @param invoices List of invoices for the payment.
     */

    public void setInvoices(List<Invoice> invoices) throws Exception {
        this.invoices = invoices;
    }

    /**
     * get the invoice.
     *
     * @return Returns list of Invoice object.
     */

    public List<Invoice> getInvoices() {
        return invoices;
    }


    /**
     * Convert CustomerPayment object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (customerId != null && !customerId.equals("")) {
            jsonObject.put("customer_id", customerId);
        }

        if (invoices != null) {
            JSONArray invoice = new JSONArray();

            for (int i = 0; i < invoices.size(); i++) {
                JSONObject inv = new JSONObject();

                inv.put("invoice_id", invoices.get(i).getInvoiceId());
                inv.put("amount_applied", invoices.get(i).getAmountApplied());
                inv.put("tax_amount_withheld", invoices.get(i).getTaxAmountWithheld());

                invoice.put(inv);
            }

            jsonObject.put("invoices", invoice);
        }

        if (paymentMode != null && !paymentMode.equals("")) {
            jsonObject.put("payment_mode", paymentMode);
        }
        if (paymentNumber != null && !paymentNumber.equals("")) {
            jsonObject.put("payment_number", paymentNumber);
        }
        if (date != null && !date.equals("")) {
            jsonObject.put("date", date);
        }
        if (referenceNumber != null && !referenceNumber.equals("")) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if ((Double) amount != null) {
            jsonObject.put("amount", amount);
        }
        if ((Double) bankCharges != null) {
            jsonObject.put("bank_charges", bankCharges);
        }
        if (accountId != null && !accountId.equals("")) {
            jsonObject.put("account_id", accountId);
        }
        if (description != null && !description.equals("")) {
            jsonObject.put("description", description);
        }

        return jsonObject;
    }
}
