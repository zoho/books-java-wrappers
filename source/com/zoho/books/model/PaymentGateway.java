/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for payment gateway.
 */

public class PaymentGateway {
    private String gatewayName = "";
    private String identifier = "";
    private String additionalField1 = "";
    private String additionalField2 = "";
    private String additionalField3 = "";
    private String currencyId = "";
    private String currencyCode = "";
    private String supportedCurrencies = "";
    private boolean enabled = false;
    private boolean configured = false;


    private String nameFormatted = "";
    private String name = "";
    private String paymentType = "";


    /**
     * set the gateway name.
     *
     * @param gatewayName Name of the payment gateway associated with the invoice. E.g. paypal, google_check_out.
     */

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    /**
     * get the gateway name.
     *
     * @return Returns the name of the payment gateway associated with the invoice.
     */

    public String getGatewayName() {
        return gatewayName;
    }

    /**
     * set the identifier.
     *
     * @param identifier Identifier of the payment gateway.
     */

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * get the identifier.
     *
     * @return Returns the identifier of the payment gateway.
     */

    public String getIdentifier() {
        return identifier;
    }

    /**
     * set the additional field1.
     *
     * @param additionalField1 Paypal payment method.
     */

    public void setAdditionalField1(String additionalField1) {
        this.additionalField1 = additionalField1;
    }

    /**
     * get the additional field1.
     *
     * @return Returns the paypal payment method.
     */

    public String getAdditionalField1() {
        return additionalField1;
    }

    /**
     * set the additional field2.
     *
     * @param additionalField2 Paypal payment method.
     */

    public void setAdditionalField2(String additionalField2) {
        this.additionalField2 = additionalField2;
    }

    /**
     * get the additional field2.
     *
     * @return Returns the paypal payment method.
     */

    public String getAdditionalField2() {
        return additionalField2;
    }

    /**
     * set the additional field3.
     *
     * @param additionalField3 Paypal payment method.
     */

    public void setAdditionalField3(String additionalField3) {
        this.additionalField3 = additionalField3;
    }

    /**
     * get the additional field3.
     *
     * @return Returns the paypal payment method.
     */

    public String getAdditionalField3() {
        return additionalField3;
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
     * set the supported currencies.
     *
     * @param supportedCurrencies Supported currencies for the payment gateway.
     */

    public void setSupportedCurrencies(String supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    /**
     * get the supported currencies.
     *
     * @return Returns the supported currencies for the payment gateway.
     */

    public String getSupportedCurrencies() {
        return supportedCurrencies;
    }

    /**
     * set is enabled.
     *
     * @param enabled To determine whether the payment gateway is enabled or disabled.
     */

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * get is enabled.
     *
     * @return Returns true if the payment gateway is enable else returns false.
     */

    public boolean isEnabled() {
        return enabled;
    }

    /**
     * set is configured.
     *
     * @param configured To determine whether the payment gateway is configured or not.
     */

    public void setConfigured(boolean configured) {
        this.configured = configured;
    }

    /**
     * get is configured.
     *
     * @return Returns true if the payment gateway is configured else returns false.
     */

    public boolean isConfigured() {
        return configured;
    }


    /**
     * set the name format.
     *
     * @param nameFormatted Format of the gateway name.
     */

    public void setNameFormatted(String nameFormatted) {
        this.nameFormatted = nameFormatted;
    }

    /**
     * get the name format.
     *
     * @return Returns the format of the gateway name.
     */

    public String getNameFormatted() {
        return nameFormatted;
    }

    /**
     * set the name.
     *
     * @param name Name of the gateway.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name.
     *
     * @return Returns the name of the gateway.
     */

    public String getName() {
        return name;
    }

    /**
     * set the payment type.
     *
     * @param paymentType Type of the payment gateway.
     */

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * get the payment type.
     *
     * @return Returns the type of the payment gateway.
     */

    public String getPaymentType() {
        return paymentType;
    }


    /**
     * Convert PaymentGateway object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (gatewayName != null && !gatewayName.equals("")) {
            jsonObject.put("gateway_name", gatewayName);
        }

        if (additionalField1 != null && !additionalField1.equals("")) {
            jsonObject.put("additional_field1", additionalField1);
        }

        return jsonObject;
    }

}
