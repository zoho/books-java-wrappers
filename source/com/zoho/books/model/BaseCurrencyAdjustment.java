/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for base currency adjustment.
 */

public class BaseCurrencyAdjustment {
    private String adjustmentDate = "";
    private double exchangeRate = 0.00;
    private String currencyId = "";
    private String description = "";
    private String adjustmentDateFormatted = "";
    private String currencyCode = "";
    private String baseCurrencyAdjustmentId = "";

    private String notes = "";

    private double gainOrLoss = 0.00;


    private List<Account> accounts = new ArrayList<Account>();


    /**
     * set the adjustment date.
     *
     * @param adjustmentDate Date of adjustment.
     */

    public void setAdjustmentDate(String adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    /**
     * get the adjustment date.
     *
     * @return Returns the adjustment date.
     */

    public String getAdjustmentDate() {
        return adjustmentDate;
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
     * set the currency id.
     *
     * @param currencyId ID of currency for which we need to post adjustment.
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
     * set the description.
     *
     * @param description Description of the base currency adjustment.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the adjustment date format.
     *
     * @param adjustmentDateFormatted Format of the base currency adjustment.
     */

    public void setAdjustmentDateFormatted(String adjustmentDateFormatted) {
        this.adjustmentDateFormatted = adjustmentDateFormatted;
    }

    /**
     * get the adjustment date format.
     *
     * @return Returns the base currency adjustment format.
     */

    public String getAdjustmentDateFormatted() {
        return adjustmentDateFormatted;
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
     * set the base currency adjustment id.
     *
     * @param baseCurrencyAdjustmentId ID of the base currency adjustment.
     */

    public void setBaseCurrencyAdjustmentId(String baseCurrencyAdjustmentId) {
        this.baseCurrencyAdjustmentId = baseCurrencyAdjustmentId;
    }

    /**
     * get the base currency adjustment id.
     *
     * @return Returns the base currency adjustment id.
     */

    public String getBaseCurrencyAdjustmentId() {
        return baseCurrencyAdjustmentId;
    }


    /**
     * set the notes.
     *
     * @param notes Notes for base currency adjustment.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the notes for base currency adjustment.
     */

    public String getNotes() {
        return notes;
    }


    /**
     * set the gain or loss.
     *
     * @param gainOrLoss Gain or loss for base currency adjustment.
     */

    public void setGainOrLoss(double gainOrLoss) {
        this.gainOrLoss = gainOrLoss;
    }

    /**
     * get the gain or loss.
     *
     * @return Returns the gain or loss for base currency adjustment.
     */

    public double getGainOrLoss() {
        return gainOrLoss;
    }


    /**
     * set list af accounts.
     *
     * @param accounts list of account.
     */

    public void setAccounts(List<Account> accounts) throws Exception {
        this.accounts = accounts;
    }

    /**
     * get list af accounts.
     *
     * @return Returns list of account object.
     */

    public List<Account> getAccounts() {
        return accounts;
    }


    /**
     * Convert BaseCurrencyAdjustment object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (currencyId != null) {
            jsonObject.put("currency_id", currencyId);
        }

        if (adjustmentDate != null) {
            jsonObject.put("adjustment_date", adjustmentDate);
        }

        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }

        if (notes != null) {
            jsonObject.put("notes", notes);
        }

        return jsonObject;
    }


}
