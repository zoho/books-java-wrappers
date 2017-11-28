/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for tax group.
 */

public class TaxGroup {
    private String taxGroupId = "";
    private String taxGroupName = "";
    private double taxGroupPercentage = 0.00;

    private List<Tax> taxes = new ArrayList<Tax>();


    /**
     * set the tax group id.
     *
     * @param taxGroupId ID of the tax group.
     */

    public void setTaxGroupId(String taxGroupId) {
        this.taxGroupId = taxGroupId;
    }

    /**
     * get the tax group id.
     *
     * @return Returns the ID of the tax group.
     */

    public String getTaxGroupId() {
        return taxGroupId;
    }

    /**
     * set the tax group name.
     *
     * @param taxGroupName Name of the tax group.
     */

    public void setTaxGroupName(String taxGroupName) {
        this.taxGroupName = taxGroupName;
    }

    /**
     * get the tax group name.
     *
     * @return Returns the name of the tax group.
     */

    public String getTaxGroupName() {
        return taxGroupName;
    }

    /**
     * set the tax group percentage.
     *
     * @param taxGroupPercentage Percentage of the tax group.
     */

    public void setTaxGroupPercentage(double taxGroupPercentage) {
        this.taxGroupPercentage = taxGroupPercentage;
    }

    /**
     * get the tax group percentage.
     *
     * @return Returns the percentage of the tax group.
     */

    public double getTaxGroupPercentage() {
        return taxGroupPercentage;
    }


    /**
     * set the taxes.
     *
     * @param taxes Taxes of the tax group.
     */

    public void setTaxes(List<Tax> taxes) throws Exception {
        this.taxes = taxes;
    }

    /**
     * get the taxes.
     *
     * @return Returns list of Tax object.
     */

    public List<Tax> getTaxes() {
        return taxes;
    }

}
