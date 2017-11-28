/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for bank account.
 */

public class BankAccount {
    private String accountId = "";
    private String accountName = "";
    private String accountNumber = "";
    private String accountType = "";
    private String currencyId = "";
    private String currencyCode = "";
    private int uncategorizedTransactions = 0;
    private boolean isActive = true;
    private double balance = 0.00;
    private String bankName = "";
    private String routingNumber = "";
    private boolean isPrimaryAccount = false;
    private boolean isPaypalAccount = false;
    private String paypalEmailAddress = "";
    private String description = "";


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
     * @return Returns the account id.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * set the account name.
     *
     * @param accountName Unique name to identify the account.
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
     * set the account number.
     *
     * @param accountNumber Bank/Credit Card account number.
     */

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * get the account number.
     *
     * @return Returns the account number.
     */

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * set the account type.
     *
     * @param accountType Type of account to be created.
     */

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * get the account type.
     *
     * @return Returns the account type.
     */

    public String getAccountType() {
        return accountType;
    }

    /**
     * set the currency id.
     *
     * @param currencyId Currency in which this account is created.
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
     * @param currencyCode Currency code in which this account is created.
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
     * set the uncategorized transactions.
     *
     * @param uncategorizedTransactions uncategorized transactions for this account.
     */

    public void setUncategorizedTransactions(int uncategorizedTransactions) {
        this.uncategorizedTransactions = uncategorizedTransactions;
    }

    /**
     * get the uncategorized transactions.
     *
     * @return Returns the uncategorized transactions.
     */

    public int getUncategorizedTransactions() {
        return uncategorizedTransactions;
    }

    /**
     * set is active.
     *
     * @param isActive A boolean value to make this account is active.
     */

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * get is active.
     *
     * @return Returns true if the account is active else return false.
     */

    public boolean isActive() {
        return isActive;
    }

    /**
     * set the balance.
     *
     * @param balance Balance of the account.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get the balance.
     *
     * @return Returns the balnce.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * set the bank name.
     *
     * @param bankName Bank Name in which the account originally exist.
     */

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * get the bank name.
     *
     * @return Returns the bank name.
     */

    public String getBankName() {
        return bankName;
    }

    /**
     * set the routing number of the bank.
     *
     * @param routingNumber Unique routing number of the bank.
     */

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    /**
     * get the routing number of the bank.
     *
     * @return Returns the routing number of the bank.
     */

    public String getRoutingNumber() {
        return routingNumber;
    }

    /**
     * set is primary account.
     *
     * @param isPrimaryAccount A boolean value to make the account primary.
     */

    public void setIsPrimaryAccount(boolean isPrimaryAccount) {
        this.isPrimaryAccount = isPrimaryAccount;
    }

    /**
     * get is primary account.
     *
     * @return Returns true if the account is primary else returns false.
     */

    public boolean isPrimaryAccount() {
        return isPrimaryAccount;
    }

    /**
     * set is paypal account.
     *
     * @param isPaypalAccount A boolean value to specify if it is a paypal account.
     */

    public void setIsPaypalAccount(boolean isPaypalAccount) {
        this.isPaypalAccount = isPaypalAccount;
    }

    /**
     * get is paypal account.
     *
     * @return Returns true if the account is paypal account else returns false.
     */

    public boolean isPaypalAccount() {
        return isPaypalAccount;
    }

    /**
     * set the paypal email address.
     *
     * @param paypalEmailAddress Email address of the PayPal account.
     */

    public void setPaypalEmailAddress(String paypalEmailAddress) {
        this.paypalEmailAddress = paypalEmailAddress;
    }

    /**
     * get the paypal email address.
     *
     * @return Returns the paypal email address.
     */

    public String getPaypalEmailAddress() {
        return paypalEmailAddress;
    }

    /**
     * set the description.
     *
     * @param description Optional description for the account.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description for the account.
     */

    public String getDescription() {
        return description;
    }


    /**
     * Convert BankAccount object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (accountName != null) {
            jsonObject.put("account_name", accountName);
        }

        if (accountType != null) {
            jsonObject.put("account_type", accountType);
        }

        if (accountNumber != null) {
            jsonObject.put("account_number", accountNumber);
        }

        if (currencyId != null) {
            jsonObject.put("currency_id", currencyId);
        }

        if (description != null) {
            jsonObject.put("description", description);
        }

        if (bankName != null) {
            jsonObject.put("bank_name", bankName);
        }

        if (routingNumber != null) {
            jsonObject.put("routing_number", routingNumber);
        }

        if ((Boolean) isPrimaryAccount != null) {
            jsonObject.put("is_primary_account", isPrimaryAccount);
        }

        if ((Boolean) isPaypalAccount != null) {
            jsonObject.put("is_paypal_account", isPaypalAccount);
        }

        if (paypalEmailAddress != null) {
            jsonObject.put("paypal_email_address", paypalEmailAddress);
        }

        return jsonObject;
    }

}
