/* $Id$ */

package com.zoho.books.model;

/**
 * BillsCredited class is used to create an object for bills credited for vendor credit.
 *
 * @author ramesh-2099
 */

public class BillsCredited {

    private String vendorCreditId;
    private String billId;
    private String vendorCreditBillId;
    private String date;
    private String billNumber;
    private String vendorCreditNumber;
    private double amount;


    /**
     * Get the vendor credit id.
     *
     * @return Returns the vendor credit id.
     */

    public String getVendorCreditId() {
        return vendorCreditId;
    }

    /**
     * Set the vendor credit id.
     *
     * @param vendorCreditId ID of vendor credit.
     */

    public void setVendorCreditId(String vendorCreditId) {
        this.vendorCreditId = vendorCreditId;
    }

    /**
     * Get the bill id.
     *
     * @return Returns the bill id.
     */

    public String getBillId() {
        return billId;
    }

    /**
     * Set the bill id.
     *
     * @param billId ID of the bill.
     */

    public void setBillId(String billId) {
        this.billId = billId;
    }

    /**
     * Get the vendor credit bill id.
     *
     * @return Returns the vendor credit bill id.
     */

    public String getVendorCreditBillId() {
        return vendorCreditBillId;
    }

    /**
     * Set the vendor credit bill id.
     *
     * @param vendorCreditBillId Id of the vendor credit bill.
     */

    public void setVendorCreditBillId(String vendorCreditBillId) {
        this.vendorCreditBillId = vendorCreditBillId;
    }

    /**
     * Get the date.
     *
     * @return Returns the date.
     */

    public String getDate() {
        return date;
    }

    /**
     * Set the date.
     *
     * @param date Date of the vendor credit bill.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the bill number.
     *
     * @return Returns the bill number.
     */

    public String getBillNumber() {
        return billNumber;
    }

    /**
     * Set the bill number.
     *
     * @param billNumber Number of the bill.
     */

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * Get the vendor credit number.
     *
     * @return Returns the vendor credit number.
     */

    public String getVendorCreditNumber() {
        return vendorCreditNumber;
    }

    /**
     * Set the vendor credit number.
     *
     * @param vendorCreditNumber Number of the vendor credit.
     */

    public void setVendorCreditNumber(String vendorCreditNumber) {
        this.vendorCreditNumber = vendorCreditNumber;
    }

    /**
     * Get the amount.
     *
     * @return Returns the amount.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * Set the amount.
     *
     * @param amount Amount of the vendor credit bill.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
