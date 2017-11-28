/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for tax.
 */

public class Tax {

    private String taxId = "";
    private String taxName = "";
    private double taxAmount = 0.00;
    private String taxType = "";
    private boolean deleted = false;
    private double taxPercentage = 0.00;


    /**
     * set the tax id.
     *
     * @param taxId ID of the tax.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * get the tax id.
     *
     * @return Returns the ID of the tax.
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * set the tax name.
     *
     * @param taxName Name of the tax to be created.
     */

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * get the tax name.
     *
     * @return Returns the name of the tax to be created.
     */

    public String getTaxName() {
        return taxName;
    }

    /**
     * set the tax amount.
     *
     * @param taxAmount Amount of the tax.
     */

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * get the tax amount.
     *
     * @return Returns the amount of the tax to be created.
     */

    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * set the tax type.
     *
     * @param taxType Type to determine whether it is a simple or compound tax.
     */

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    /**
     * get the tax type.
     *
     * @return Returns the type to determine whether it is a simple or compound tax.
     */

    public String getTaxType() {
        return taxType;
    }

    /**
     * set is deleted.
     *
     * @param deleted To specify the tax is deleted or not.
     */

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * get is deleted.
     *
     * @return Returns true if the tax is deleted else returns false.
     */

    public boolean isDeleted() {
        return deleted;
    }

    /**
     * set the tax percentage.
     *
     * @param taxPercentage Number of percentage taxable.
     */

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * get the tax percentage.
     *
     * @return Returns the number of percentage taxable.
     */

    public double getTaxPercentage() {
        return taxPercentage;
    }


    /**
     * Convert Tax object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("tax_name", taxName);
        jsonObject.put("tax_percentage", taxPercentage);
        jsonObject.put("tax_type", taxType);

        return jsonObject;
    }
}
