/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for journal.
 */

public class Journal {
    private String journalId = "";
    private String entryNumber = "";
    private String referenceNumber = "";
    private String notes = "";
    private String currencyId = "";
    private String currencyCode = "";
    private String currencySymbol = "";
    private String journalDate = "";
    private double lineItemTotal = 0.00;
    private double total = 0.00;
    private int pricePrecision = 0;
    private String createdTime = "";
    private String lastModifiedTime = "";

    private List<LineItem> lineItems = new ArrayList<LineItem>();


    /**
     * set the journal id.
     *
     * @param journalId ID of the journal.
     */

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    /**
     * get the journal id.
     *
     * @return Returns the id of the journal.
     */

    public String getJournalId() {
        return journalId;
    }

    /**
     * set the entry number.
     *
     * @param entryNumber Entry number of the journal.
     */

    public void setEntryNumber(String entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * get the entry number.
     *
     * @return Returns the entry number of the journal.
     */

    public String getEntryNumber() {
        return entryNumber;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number for the journal.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number for the journal.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the notes.
     *
     * @param notes Notes for the journal.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the notes for the journal.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency which the journal associated with.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the id of the currency which the journal associated with.
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
     * set the currency symbol.
     *
     * @param currencySymbol Symbol for the currency.
     */

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * get the currency symbol.
     *
     * @return Returns the symbol for the currency.
     */

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * set the journal date.
     *
     * @param journalDate Date on which the journal to be recorded.
     */

    public void setJournalDate(String journalDate) {
        this.journalDate = journalDate;
    }

    /**
     * get the journal date.
     *
     * @return Returns the date on which the journal to be recorded.
     */

    public String getJournalDate() {
        return journalDate;
    }

    /**
     * set the line item total.
     *
     * @param lineItemTotal Total of the line item.
     */

    public void setLineItemTotal(double lineItemTotal) {
        this.lineItemTotal = lineItemTotal;
    }

    /**
     * get the line item total.
     *
     * @return Returns the total of the line item.
     */

    public double getLineItemTotal() {
        return lineItemTotal;
    }

    /**
     * set the total.
     *
     * @param total Total amount for the journal.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total for the journal.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the price precision.
     *
     * @param pricePrecision Price precision for the journal.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * get the price precision.
     *
     * @return Returns the price precision for the journal.
     */

    public int getPricePrecision() {
        return pricePrecision;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time for the journal.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time for the journal.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time for the journal.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time for the journal.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }


    /**
     * set the line items.
     *
     * @param lineItems Line items for the journal.
     */

    public void setLineItems(List<LineItem> lineItems) throws Exception {
        this.lineItems = lineItems;
    }

    /**
     * get the line items.
     *
     * @return Returns list of LineItem object.
     */

    public List<LineItem> getLineItems() {
        return lineItems;
    }


    /**
     * Convert Journal object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (journalDate != null && !journalDate.equals("")) {
            jsonObject.put("journal_date", journalDate);
        }
        if (referenceNumber != null && !referenceNumber.equals("")) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if (notes != null && !notes.equals("")) {
            jsonObject.put("notes", notes);
        }


        if (lineItems != null) {
            JSONArray lineItem = new JSONArray();

            for (int i = 0; i < lineItems.size(); i++) {
                lineItem.put(lineItems.get(i).toJSON());
            }
            jsonObject.put("line_items", lineItem);
        }

        return jsonObject;
    }


}
