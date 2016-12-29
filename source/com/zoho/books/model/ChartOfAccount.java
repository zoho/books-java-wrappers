/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for chart of account.
 */

public class ChartOfAccount {
    private String accountId = "";
    private String accountName = "";
    private String accountType = "";
    private String accountTypeFormatted = "";
    private String description = "";


    private boolean isActive = false;
    private boolean isUserCreated = false;
    private boolean isInvolvedInTransaction = false;
    private boolean isSystemAccount = false;
    private double currentBalance = 0.00;


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
     * set the account type.
     *
     * @param accountType Type of the account.
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
     * set the account type format.
     *
     * @param accountTypeFormatted Format of the account type.
     */

    public void setAccountTypeFormatted(String accountTypeFormatted) {
        this.accountTypeFormatted = accountTypeFormatted;
    }

    /**
     * get the account type format.
     *
     * @return Returns the format of the account type.
     */

    public String getAccountTypeFormatted() {
        return accountTypeFormatted;
    }

    /**
     * set the account description.
     *
     * @param description Description of the account type.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the account description.
     *
     * @return Returns the description of the account.
     */

    public String getDescription() {
        return description;
    }


    /**
     * set is active.
     *
     * @param isActive Is the account is active or not.
     */

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * get is active.
     *
     * @return Returns true if the account is active else returns false.
     */

    public boolean isActive() {
        return isActive;
    }

    /**
     * set is user created.
     *
     * @param isUserCreated Is the user created or not.
     */

    public void setIsUserCreated(boolean isUserCreated) {
        this.isUserCreated = isUserCreated;
    }

    /**
     * get is user created.
     *
     * @return Returns true if the user is created else returns false.
     */

    public boolean isUserCreated() {
        return isUserCreated;
    }

    /**
     * set is involved in transaction.
     *
     * @param isInvolvedInTransaction Is the account involved in transaction.
     */

    public void setIsInvolvedInTransaction(boolean isInvolvedInTransaction) {
        this.isInvolvedInTransaction = isInvolvedInTransaction;
    }

    /**
     * get is involved in transaction.
     *
     * @return Returns true if the account involved in transaction else returns false.
     */

    public boolean isInvolvedInTransaction() {
        return isInvolvedInTransaction;
    }

    /**
     * set is system account.
     *
     * @param isSystemAccount Is the account is system generated.
     */

    public void setIsSystemAccount(boolean isSystemAccount) {
        this.isSystemAccount = isSystemAccount;
    }

    /**
     * get is system account.
     *
     * @return Returns true if the account is system generated else returns false.
     */

    public boolean isSystemAccount() {
        return isSystemAccount;
    }

    /**
     * set the current balance.
     *
     * @param currentBalance Current balance of the account.
     */

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * get the current balance.
     *
     * @return Returns the current balance of the account.
     */

    public double getCurrentBalance() {
        return currentBalance;
    }


    /**
     * Convert ChartOfAccount object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("account_name", accountName);
        jsonObject.put("account_type", accountType);
        jsonObject.put("description", description);

        return jsonObject;
    }

}
