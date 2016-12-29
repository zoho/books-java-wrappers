/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * VendorCredit class is used to create an object for vendor credits.
 *
 * @author ramesh-2099
 */

public class VendorCredit {

    private String vendorCreditId;
    private String vendorCreditNumber;
    private String status;
    private String referenceNumber;
    private String date;
    private double total;
    private double balance;
    private String vendorId;
    private String vendorName;
    private String currencyId;
    private String currencyCode;
    private String createdTime;
    private String lastModifiedTime;


    private double exchangeRate;
    private int pricePrecision;
    private double subTotal;
    private double totalCreditsUsed;
    private double totalRefundedAmount;
    private String notes;


    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private List<Tax> taxes = new ArrayList<Tax>();
    private List<Comment> comments = new ArrayList<Comment>();
    private List<VendorCreditRefund> vendorCreditRefunds = new ArrayList<VendorCreditRefund>();
    private List<BillsCredited> billsCredited = new ArrayList<BillsCredited>();


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
     * @param vendorCreditId ID of the vendor credit.
     */

    public void setVendorCreditId(String vendorCreditId) {
        this.vendorCreditId = vendorCreditId;
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
     * Get the status.
     *
     * @return Returns the status.
     */

    public String getStatus() {
        return status;
    }

    /**
     * Set the status.
     *
     * @param status Status of the vendor credit.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the reference number.
     *
     * @return Returns the reference number.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Set the reference number.
     *
     * @param referenceNumber Reference number of the vendor credit.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * Get the vendor credit date.
     *
     * @return Returns the vendor credit date.
     */

    public String getDate() {
        return date;
    }

    /**
     * Set the vendor credit date.
     *
     * @param date Vendor credit date.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the vendor credit total.
     *
     * @return Returns the vendor credit total.
     */

    public double getTotal() {
        return total;
    }

    /**
     * Set the vendor credit total.
     *
     * @param total Vendor credit total.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Get the balance.
     *
     * @return Returns the balance.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Set the balance.
     *
     * @param balance Vendor credit balance.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Get the vendor id.
     *
     * @return Returns the vendor id.
     */

    public String getVendorId() {
        return vendorId;
    }

    /**
     * Set the vendor id.
     *
     * @param vendorId ID of the vendor.
     */

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * Get the vendor name.
     *
     * @return Returns the vendor name.
     */

    public String getVendorName() {
        return vendorName;
    }

    /**
     * Set the vendor name.
     *
     * @param vendorName Name of the vendor.
     */

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * Get the currency id.
     *
     * @return Returns the currency id.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * Set the currency id.
     *
     * @param currencyId ID of the currency.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * Get the currency code.
     *
     * @return Returns the currency code.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Set the currency code.
     *
     * @param currencyCode Code of the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Get the created time.
     *
     * @return Returns the created time.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * Set the created time.
     *
     * @param createdTime Created time for the vendor credit.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Get the last modified time.
     *
     * @return Returns the last modified time.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * Set the last modified time.
     *
     * @param lastModifiedTime Last modified time of the vendor credit.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * Get the exchange rate.
     *
     * @return Returns the exchange rate.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Set the exchange rate.
     *
     * @param exchangeRate Exchange rate for the currency.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * Get the price precision.
     *
     * @return Returns the price precision.
     */

    public int getPricePrecision() {
        return pricePrecision;
    }

    /**
     * Set the price precision.
     *
     * @param pricePrecision Price precision for the vendor credit.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * Get the sub total.
     *
     * @return Returns the sub total.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * Set the sub total.
     *
     * @param subTotal Sub total of the vendor credit.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Get the total credit used.
     *
     * @return Returns the total credits used.
     */

    public double getTotalCreditsUsed() {
        return totalCreditsUsed;
    }

    /**
     * Set the total credits used.
     *
     * @param totalCreditsUsed Total credits used.
     */

    public void setTotalCreditsUsed(double totalCreditsUsed) {
        this.totalCreditsUsed = totalCreditsUsed;
    }

    /**
     * Get the total refund amount.
     *
     * @return Returns the total refund amount.
     */

    public double getTotalRefundedAmount() {
        return totalRefundedAmount;
    }

    /**
     * Set the total refund amount.
     *
     * @param totalRefundedAmount Total refund amount for the vendor credit.
     */

    public void setTotalRefundedAmount(double totalRefundedAmount) {
        this.totalRefundedAmount = totalRefundedAmount;
    }

    /**
     * Get the notes.
     *
     * @return Returns the notes.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * Set the notes.
     *
     * @param notes Notes for the vendor credit.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Get the line items.
     *
     * @return Returns List of LineItem object.
     */

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * Set the list of line items.
     *
     * @param lineItems List of LineItem object.
     */

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Get the list of taxes.
     *
     * @return Returns List of Tax object.
     */

    public List<Tax> getTaxes() {
        return taxes;
    }

    /**
     * Set the list of taxes.
     *
     * @param taxes List of Tax object.
     */

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    /**
     * Get the list of comments.
     *
     * @return Returns List of Comment object.
     */

    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Set the list of comments.
     *
     * @param comments List of Comment object.
     */

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Get the list of vendor credit refunds.
     *
     * @return Returns List of VendorCreditRefund object.
     */

    public List<VendorCreditRefund> getVendorCreditRefunds() {
        return vendorCreditRefunds;
    }

    /**
     * Set the list of vendor credit refunds.
     *
     * @param vendorCreditRefunds List of VendorCreditRefund object.
     */

    public void setVendorCreditRefunds(List<VendorCreditRefund> vendorCreditRefunds) {
        this.vendorCreditRefunds = vendorCreditRefunds;
    }

    /**
     * Get the list of bills credited.
     *
     * @return Returns List of BillsCredited object.
     */

    public List<BillsCredited> getBillsCredited() {
        return billsCredited;
    }

    /**
     * Set the list of bills credited.
     *
     * @param billsCredited List of BillsCredited object.
     */

    public void setBillsCredited(List<BillsCredited> billsCredited) {
        this.billsCredited = billsCredited;
    }


    /**
     * Convert the VendorCredit into JSONObject.
     *
     * @return Returns the JSONObject.
     * @throws Exception
     */

    public JSONObject toJSON() throws Exception {

        JSONObject jsonObject = new JSONObject();

        if (vendorId != null) {
            jsonObject.put("vendor_id", vendorId);
        }
        if (vendorCreditNumber != null) {
            jsonObject.put("vendor_credit_number", vendorCreditNumber);
        }
        if (referenceNumber != null) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if (date != null) {
            jsonObject.put("date", date);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (notes != null) {
            jsonObject.put("notes", notes);
        }

        if (lineItems != null) {
            JSONArray lineitems = new JSONArray();

            for (int i = 0; i < lineItems.size(); i++) {
                lineitems.put(lineItems.get(i).toJSON());
            }

            jsonObject.put("line_items", lineitems);
        }

        return jsonObject;

    }


}
