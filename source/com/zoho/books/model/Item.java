/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for item.
 */

public class Item {
    private String itemId = "";
    private String name = "";
    private String status = "";
    private String description = "";
    private double rate = 0.00;
    private String unit = "";
    private String accountId = "";
    private String accountName = "";
    private String taxId = "";
    private String taxName = "";
    private double taxPercentage = 0.00;
    private String taxType = "";


    /**
     * set the item id.
     *
     * @param itemId ID of the item.
     */

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * get the item id.
     *
     * @return Returns the item id.
     */

    public String getItemId() {
        return itemId;
    }

    /**
     * set the name.
     *
     * @param name Name of the item.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name.
     *
     * @return Returns the item name.
     */

    public String getName() {
        return name;
    }

    /**
     * set the status.
     *
     * @param status Status of the item.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the item status.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set the description.
     *
     * @param description Description of the item.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the item description.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the rate.
     *
     * @param rate Price of the item.
     */

    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * get the rate.
     *
     * @return Returns the price of the item.
     */

    public double getRate() {
        return rate;
    }

    /**
     * set the unit.
     *
     * @param unit Unit of the item.
     */

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * get the unit.
     *
     * @return Returns the unit of the item.
     */

    public String getUnit() {
        return unit;
    }

    /**
     * set the account id.
     *
     * @param accountId ID of the account to which the item has to be associated with.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * get the account id.
     *
     * @return Returns the id of the account to which the item has to be associated with.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * set the account name.
     *
     * @param accountName Name of the account to which the item has to be associated with.
     */

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * get the account name.
     *
     * @return Returns the name of the account to which the item has to be associated with.
     */

    public String getAccountName() {
        return accountName;
    }

    /**
     * set the tax id.
     *
     * @param taxId ID of the tax to be associated to the item.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * get the tax id.
     *
     * @return Returns the id of the tax to be associated to the item.
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * set the tax name.
     *
     * @param taxName Name of the tax to be associated.
     */

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * get the tax name.
     *
     * @return Returns the name of the tax to be associated.
     */

    public String getTaxName() {
        return taxName;
    }

    /**
     * set the tax percentage.
     *
     * @param taxPercentage Percentage of the tax to be associated.
     */

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * get the tax percentage.
     *
     * @return Returns the percentage of the tax to be associated.
     */

    public double getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * set the tax type.
     *
     * @param taxType Type of the tax to be associated.
     */

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    /**
     * get the tax type.
     *
     * @return Returns the type of the tax to be associated.
     */

    public String getTaxType() {
        return taxType;
    }


    /**
     * Convert Item object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", name);
        jsonObject.put("description", description);
        jsonObject.put("rate", rate);
        jsonObject.put("account_id", accountId);
        jsonObject.put("tax_id", taxId);

        return jsonObject;

    }
}
