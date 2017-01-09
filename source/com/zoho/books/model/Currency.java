/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for currency.
 */

public class Currency {
    private String currencyId = "";
    private String currencyCode = "";
    private String currencyName = "";
    private String currencySymbol = "";
    private int pricePrecision = 2;
    private String currencyFormat = "";
    private boolean isBaseCurrency = false;
    private double exchangeRate = 0.00;
    private String effectiveDate = "";


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
     * @param currencyCode Standard code to identify the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the standard code to identify the currency.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the currency name.
     *
     * @param currencyName Standard name to identify the currency.
     */

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    /**
     * get the currency name.
     *
     * @return Returns the standard name to identify the currency.
     */

    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * set the currency symbol.
     *
     * @param currencySymbol Standard symbol that the currency can be represented with.
     */

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * get the currency symbol.
     *
     * @return Returns the standard symbol that the currency can be represented with.
     */

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * set the price precision.
     *
     * @param pricePrecision Number of decimal places for the currency.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * get the price precision.
     *
     * @return Returns the number of decimal places for the currency.
     */

    public int getPricePrecision() {
        return pricePrecision;
    }

    /**
     * set the currency format.
     *
     * @param currencyFormat Format in which the currency to be displayed.
     */

    public void setCurrencyFormat(String currencyFormat) {
        this.currencyFormat = currencyFormat;
    }

    /**
     * get the currency format.
     *
     * @return Returns the format in which the currency to be displayed.
     */

    public String getCurrencyFormat() {
        return currencyFormat;
    }

    /**
     * set is base currency.
     *
     * @param isBaseCurrency Whether this is the base currency or not.
     */

    public void setIsBaseCurrency(boolean isBaseCurrency) {
        this.isBaseCurrency = isBaseCurrency;
    }

    /**
     * get is base currency.
     *
     * @return Returns true if the currency is base else returns false.
     */

    public boolean isBaseCurrency() {
        return isBaseCurrency;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate Exchange rate for the currency.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchange rate.
     *
     * @return Returns the exchange rate for the currency.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * set the effective date.
     *
     * @param effectiveDate Date which the exchange rate is applicable for the currency.
     */

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * get the effective date.
     *
     * @return Returns the date which the exchange rate is applicable for the currency.
     */

    public String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Convert Currency object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("currency_code", currencyCode);
        jsonObject.put("currency_symbol", currencySymbol);
        jsonObject.put("price_precision", pricePrecision);
        jsonObject.put("currency_format", currencyFormat);

        return jsonObject;
    }
}
