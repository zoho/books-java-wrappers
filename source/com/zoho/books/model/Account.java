/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for account.
 */

public class Account {
    private String accountId = "";
    private String accountName = "";
    private double bcyBalance = 0.00;
    private String bcyBalanceFormatted = "";
    private double fcyBalance = 0.00;
    private String fcyBalanceFormatted = "";
    private double adjustedBalance = 0.00;
    private String adjustedBalanceFormatted = "";
    private double gainOrLoss = 0.00;
    private String gainOrLossFormatted = "";
    private int glSpecificType = 0;


    private String accountSplitId = "";
    private String debitOrCredit = "";
    private double exchangeRate = 0.00;
    private String currencyId = "";
    private String currencyCode = "";
    private double bcyAmount = 0.00;
    private double amount = 0.00;


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
     * set the bcy balance.
     *
     * @param bcyBalance Bcy balance of the account.
     */

    public void setBcyBalance(double bcyBalance) {
        this.bcyBalance = bcyBalance;
    }

    /**
     * get the bcy balance.
     *
     * @return Returns the bcy balance.
     */

    public double getBcyBalance() {
        return bcyBalance;
    }

    /**
     * set the bcy balance format.
     *
     * @param bcyBalanceFormatted Format of the bcy balance.
     */

    public void setBcyBalanceFormatted(String bcyBalanceFormatted) {
        this.bcyBalanceFormatted = bcyBalanceFormatted;
    }

    /**
     * get the bcy balance format.
     *
     * @return Returns the bcy balance format.
     */

    public String getBcyBalanceFormatted() {
        return bcyBalanceFormatted;
    }

    /**
     * set the fcy balance.
     *
     * @param fcyBalance Fcy balance of the account.
     */

    public void setFcyBalance(double fcyBalance) {
        this.fcyBalance = fcyBalance;
    }

    /**
     * get the fcy balance.
     *
     * @return Returns the fcy balance.
     */

    public double getFcyBalance() {
        return fcyBalance;
    }

    /**
     * set the fcy balance format.
     *
     * @param fcyBalanceFormatted Format of the Fcy balance.
     */

    public void setFcyBalanceFormatted(String fcyBalanceFormatted) {
        this.fcyBalanceFormatted = fcyBalanceFormatted;
    }

    /**
     * get the fcy balance format.
     *
     * @return Returns the fcy balance format.
     */

    public String getFcyBalanceFormatted() {
        return fcyBalanceFormatted;
    }

    /**
     * set the adjusted balance.
     *
     * @param adjustedBalance Adjusted balance of the account.
     */

    public void setAdjustedBalance(double adjustedBalance) {
        this.adjustedBalance = adjustedBalance;
    }

    /**
     * get the adjusted balance.
     *
     * @return Returns the adjusted balance.
     */

    public double getAdjustedBalance() {
        return adjustedBalance;
    }

    /**
     * set the adjusted balance format.
     *
     * @param adjustedBalanceFormatted Format of the Adjusted balance.
     */

    public void setAdjustedBalanceFormatted(String adjustedBalanceFormatted) {
        this.adjustedBalanceFormatted = adjustedBalanceFormatted;
    }

    /**
     * get the adjusted balance format.
     *
     * @return Returns the adjusted balance format.
     */

    public String getAdjustedBalanceFormatted() {
        return adjustedBalanceFormatted;
    }

    /**
     * set the gain or loss.
     *
     * @param gainOrLoss Gain or loss of the account.
     */

    public void setGainOrLoss(double gainOrLoss) {
        this.gainOrLoss = gainOrLoss;
    }

    /**
     * get the gain or loss.
     *
     * @return Returns gain or loss of the account.
     */

    public double getGainOrLoss() {
        return gainOrLoss;
    }

    /**
     * set the gain or loss format.
     *
     * @param gainOrLossFormatted Format of the gain or loss.
     */

    public void setGainOrLossFormatted(String gainOrLossFormatted) {
        this.gainOrLossFormatted = gainOrLossFormatted;
    }

    /**
     * get the gain or loss format.
     *
     * @return Returns the gain or loss format.
     */

    public String getGainOrLossFormatted() {
        return gainOrLossFormatted;
    }

    /**
     * set the gl specific type.
     *
     * @param glSpecificType Gl specific type of the account.
     */

    public void setGlSpecificType(int glSpecificType) {
        this.glSpecificType = glSpecificType;
    }

    /**
     * get the gl specific type.
     *
     * @return Returns the gl specific type of the account.
     */

    public int getGlSpecificType() {
        return glSpecificType;
    }


    /**
     * set the account split id.
     *
     * @param accountSplitId Split ID of the account.
     */

    public void setAccountSplitId(String accountSplitId) {
        this.accountSplitId = accountSplitId;
    }

    /**
     * get the account split id.
     *
     * @return Returns the account split id.
     */

    public String getAccountSplitId() {
        return accountSplitId;
    }

    /**
     * set the debit or credit.
     *
     * @param debitOrCredit Debit or credit of the account.
     */

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    /**
     * get the debit or credit.
     *
     * @return Returns the debit or credit of the account.
     */

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate Exchange rate of the account.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchange rate.
     *
     * @return Returns the exchange rate of the account.
     */

    public double getExchangeRate() {
        return exchangeRate;
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
     * set the bcy amount.
     *
     * @param bcyAmount Bcy amount of the account.
     */

    public void setBcyAmount(double bcyAmount) {
        this.bcyAmount = bcyAmount;
    }

    /**
     * get the bcy amount.
     *
     * @return Returns the bcy amount of the account.
     */

    public double getBcyAmount() {
        return bcyAmount;
    }

    /**
     * set the amount.
     *
     * @param amount Amount of the account.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the amount of the account.
     */

    public double getAmount() {
        return amount;
    }


    /**
     * Convert Account object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (accountId != null && !accountId.equals("")) {
            jsonObject.put("account_id", accountId);
        }
        if (debitOrCredit != null && !debitOrCredit.equals("")) {
            jsonObject.put("debit_or_credit", debitOrCredit);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (currencyId != null && !currencyId.equals("")) {
            jsonObject.put("currency_id", currencyId);
        }
        if ((Double) amount != null) {
            jsonObject.put("amount", amount);
        }

        return jsonObject;
    }

}
