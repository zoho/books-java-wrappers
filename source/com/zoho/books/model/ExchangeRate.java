/* $Id$ */

package com.zoho.books.model;


import org.json.JSONObject;

/**
 * This class is used to make an object for exchange rate.
 */

public class ExchangeRate {
    private String exchangeRateId = "";
    private String currencyId = "";
    private String currencyCode = "";
    private String effectiveDate = "";
    private double rate = 0.00;


    /**
     * set the exchange rate id.
     *
     * @param exchangeRateId ID of the exchange rate.
     */

    public void setExchangeRateId(String exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    /**
     * get the exchange rate id.
     *
     * @return Returns the exchange rate id.
     */

    public String getExchangeRateId() {
        return exchangeRateId;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency for which exchange rate is created.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the id of the currency for which exchange rate is created.
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
     * set the rate.
     *
     * @param rate Rate of exchange for the currency with respect to base currency.
     */

    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * get the rate.
     *
     * @return Returns the rate of exchange for the currency with respect to base currency.
     */

    public double getRate() {
        return rate;
    }


    /**
     * Convert ExchangeRate object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("effective_date", effectiveDate);
        jsonObject.put("rate", rate);

        return jsonObject;
    }


}
