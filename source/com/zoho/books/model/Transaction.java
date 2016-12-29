/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for transaction.
 */

public class Transaction {
    private String categorizedTransactionId = "";
    private String transactionType = "";
    private String transactionId = "";
    private String transactionDate = "";
    private String transactionTypeFormatted = "";
    private String accountId = "";
    private String customerId = "";
    private String payee = "";
    private String description = "";
    private String entryNumber = "";
    private String currencyId = "";
    private String currencyCode = "";
    private String debitOrCredit = "";
    private String offsetAccountName = "";
    private String referenceNumber = "";
    private String reconcileStatus = "";
    private double debitAmount = 0.00;
    private double creditAmount = 0.00;


    private String paymentMode = "";
    private String date = "";
    private double amount = 0.00;
    private String status = "";
    private String statusFormatted = "";

    private String source = "";
    private String importedTransactionId = "";

    private String fromAccountId = "";
    private String fromAccountName = "";
    private String toAccountId = "";
    private String toAccountName = "";
    private String customerName = "";
    private double exchangeRate = 0.00;

    private List<Transaction> associateTransactions = new ArrayList<Transaction>();


    /**
     * set the categorize transaction id.
     *
     * @param categorizedTransactionId ID of the categorized transaction.
     */

    public void setCategorizedTransactionId(String categorizedTransactionId) {
        this.categorizedTransactionId = categorizedTransactionId;
    }

    /**
     * get the categorize transaction id.
     *
     * @return Returns the ID of the categorized transaction.
     */

    public String getCategorizedTransactionId() {
        return categorizedTransactionId;
    }

    /**
     * set the transaction type.
     *
     * @param transactionType Type of the transaction.
     */

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * get the transaction type.
     *
     * @return Returns the type of the transaction.
     */

    public String getTransactionType() {
        return transactionType;
    }

    /**
     * set the transaction id.
     *
     * @param transactionId ID of the transaction.
     */

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * get the transaction id.
     *
     * @return Returns the id of the transaction.
     */

    public String getTransactionId() {
        return transactionId;
    }

    /**
     * set the transaction date.
     *
     * @param transactionDate Date in which the transaction made.
     */

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * get the transaction date.
     *
     * @return Returns the date in which the transaction made.
     */

    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * set the transaction type format.
     *
     * @param transactionTypeFormatted Format of the transaction type.
     */

    public void setTransactionTypeFormatted(String transactionTypeFormatted) {
        this.transactionTypeFormatted = transactionTypeFormatted;
    }

    /**
     * get the transaction type format.
     *
     * @return Returns the format of the transaction type.
     */

    public String getTransactionTypeFormatted() {
        return transactionTypeFormatted;
    }

    /**
     * set the account id.
     *
     * @param accountId ID of the account.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * get the account id.
     *
     * @return Returns the ID of the account.
     */

    public String getAccountId() {
        return accountId;
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
     * @return Returns the ID of the customer.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the payee.
     *
     * @param payee Payee of the transaction.
     */

    public void setPayee(String payee) {
        this.payee = payee;
    }

    /**
     * get the payee.
     *
     * @return Returns the payee of the transaction.
     */

    public String getPayee() {
        return payee;
    }

    /**
     * set the description.
     *
     * @param description Description of the transaction.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the transaction.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the entry number.
     *
     * @param entryNumber Entry number of the transaction.
     */

    public void setEntryNumber(String entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * get the entry number.
     *
     * @return Returns the entry number of the transaction.
     */

    public String getEntryNumber() {
        return entryNumber;
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
     * @return Returns the ID of the currency.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the currency code.
     *
     * @param currencyCode Standard code of the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the standard code of the currency.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the debit or credit.
     *
     * @param debitOrCredit The transaction made from debit or credit.
     */

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    /**
     * get the debit or credit.
     *
     * @return Returns the debit or credit for the transaction.
     */

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    /**
     * set the offset account name.
     *
     * @param offsetAccountName Name of the offset account for the transaction.
     */

    public void setOffsetAccountName(String offsetAccountName) {
        this.offsetAccountName = offsetAccountName;
    }

    /**
     * get the offset account name.
     *
     * @return Returns the name of the offset account for the transaction.
     */

    public String getOffsetAccountName() {
        return offsetAccountName;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number of the transaction.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number of the transaction.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the reconcile status.
     *
     * @param reconcileStatus Reconcile status of the transaction.
     */

    public void setReconcileStatus(String reconcileStatus) {
        this.reconcileStatus = reconcileStatus;
    }

    /**
     * get the reconcile status.
     *
     * @return Returns the reconcile status of the transaction.
     */

    public String getReconcileStatus() {
        return reconcileStatus;
    }

    /**
     * set the debit amount.
     *
     * @param debitAmount Debited amount for the transaction.
     */

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * get the debit amount.
     *
     * @return Returns the debit amount for the transaction.
     */

    public double getDebitAmount() {
        return debitAmount;
    }

    /**
     * set the credit amount.
     *
     * @param creditAmount Credited amount for the transaction.
     */

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * get the credit amount.
     *
     * @return Returns the credit amount for the transaction.
     */

    public double getCreditAmount() {
        return creditAmount;
    }


    /**
     * set the payment mode.
     *
     * @param paymentMode Payment mode of the transaction.
     */

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     * get the payment mode.
     *
     * @return Returns the payment mode of the transaction.
     */

    public String getPaymentMode() {
        return paymentMode;
    }

    /**
     * set the date.
     *
     * @param date Date of the transaction.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date of the transaction.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the amount.
     *
     * @param amount Amount of the transaction.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the amount of the transaction.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * set the status.
     *
     * @param status Status of the transaction.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the transaction.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set the status format.
     *
     * @param statusFormatted Status format of the transaction.
     */

    public void setStatusFormatted(String statusFormatted) {
        this.statusFormatted = statusFormatted;
    }

    /**
     * get the status format.
     *
     * @return Returns the status format of the transaction.
     */

    public String getStatusFormatted() {
        return statusFormatted;
    }


    /**
     * set the source of the transaction.
     *
     * @param source Source of the transaction.
     */

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * get the source.
     *
     * @return Returns the source of the transaction.
     */

    public String getSource() {
        return source;
    }

    /**
     * set the imported transaction id.
     *
     * @param importedTransactionId ID of the imported transaction.
     */

    public void setImportedTransactionId(String importedTransactionId) {
        this.importedTransactionId = importedTransactionId;
    }

    /**
     * get the imported transaction id.
     *
     * @return Returns the ID of the imported transaction.
     */

    public String getImportedTransactionId() {
        return importedTransactionId;
    }


    /**
     * set the from account id.
     *
     * @param fromAccountId The account ID from which money will be transferred.
     */

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    /**
     * get the from account id.
     *
     * @return Returns the account ID from which money will be transferred.
     */

    public String getFromAccountId() {
        return fromAccountId;
    }

    /**
     * set the from account name.
     *
     * @param fromAccountName The account Name from which money will be transferred.
     */

    public void setFromAccountName(String fromAccountName) {
        this.fromAccountName = fromAccountName;
    }

    /**
     * get the from account name.
     *
     * @return Returns the account Name from which money will be transferred.
     */

    public String getFromAccountName() {
        return fromAccountName;
    }

    /**
     * set the to account id.
     *
     * @param toAccountId ID of the account to which the money gets transferred.
     */

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    /**
     * get the to account id.
     *
     * @return Returns the ID of the account to which the money gets transferred.
     */

    public String getToAccountId() {
        return toAccountId;
    }

    /**
     * set the to account name.
     *
     * @param toAccountName Name of the account to which the money gets transferred.
     */

    public void setToAccountName(String toAccountName) {
        this.toAccountName = toAccountName;
    }

    /**
     * get the to account name.
     *
     * @return Returns the Name of the account to which the money gets transferred.
     */

    public String getToAccountName() {
        return toAccountName;
    }

    /**
     * set the customer name.
     *
     * @param customerName Name of the customer or vendor.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the name of the customer or vendor.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate The foreign currency exchange rate value.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchange rate.
     *
     * @return Returns the foreign currency exchange rate value.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }


    /**
     * set the assciate transactions.
     *
     * @param associateTransactions List of associate Transaction object.
     */

    public void setAssociateTransactions(List<Transaction> associateTransactions) throws Exception {
        this.associateTransactions = associateTransactions;
    }

    /**
     * get the associate transactions.
     *
     * @return Returns list of Transaction object.
     */

    public List<Transaction> getAssociateTransactions() {
        return associateTransactions;
    }


    /**
     * Convert Transaction object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("from_account_id", fromAccountId);
        jsonObject.put("to_account_id", toAccountId);
        jsonObject.put("transaction_type", transactionType);
        jsonObject.put("amount", amount);
        //jsonObject.put("payment_mode", paymentMode);
        jsonObject.put("date", date);
        jsonObject.put("reference_number", referenceNumber);
        jsonObject.put("description", description);
        //jsonObject.put("customer_id", customerId);
        if (currencyId != null && !currencyId.equals("")) {
            jsonObject.put("currency_id", currencyId);
        }

        return jsonObject;
    }


}
