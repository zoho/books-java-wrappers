/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for invoices credited.
 */

public class InvoicesCredited {
    private String creditnoteId = "";
    private String invoiceId = "";
    private String creditnoteInvoiceId = "";
    private String date = "";
    private String invoiceNumber = "";
    private String creditnoteNumber = "";
    private double creditedAmount = 0.00;


    /**
     * set the creditnote id.
     *
     * @param creditnoteId ID of the creditnote.
     */

    public void setCreditnoteId(String creditnoteId) {
        this.creditnoteId = creditnoteId;
    }

    /**
     * get the creditnote id.
     *
     * @return Returns the creditnote id.
     */

    public String getCreditnoteId() {
        return creditnoteId;
    }

    /**
     * set the invoice id.
     *
     * @param invoiceId ID of the invoice.
     */

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * get the invoice id.
     *
     * @return Returns the invoice id.
     */

    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * set the creditnote invoice id.
     *
     * @param creditnoteInvoiceId ID of the creditnote invoice.
     */

    public void setCreditnoteInvoiceId(String creditnoteInvoiceId) {
        this.creditnoteInvoiceId = creditnoteInvoiceId;
    }

    /**
     * get the creditnote invoice id.
     *
     * @return Returns the creditnote invoice id.
     */

    public String getCreditnoteInvoiceId() {
        return creditnoteInvoiceId;
    }

    /**
     * set the date.
     *
     * @param date Date of the invoices credited.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date of the invoices credited.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the invoice number.
     *
     * @param invoiceNumber Number of the invoice.
     */

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * get the invoice number.
     *
     * @return Returns the number of the invoice.
     */

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * set the creditnote number.
     *
     * @param creditnoteNumber Number of the creditnote.
     */

    public void setCreditnoteNumber(String creditnoteNumber) {
        this.creditnoteNumber = creditnoteNumber;
    }

    /**
     * get the creditnote number.
     *
     * @return Returns the number of the creditnote.
     */

    public String getCreditnoteNumber() {
        return creditnoteNumber;
    }

    /**
     * set the credited amount.
     *
     * @param creditedAmount Credited amount for the invoice.
     */

    public void setCreditedAmount(double creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    /**
     * get the credited amount.
     *
     * @return Returns the credited amount for the invoice.
     */

    public double getCreditedAmount() {
        return creditedAmount;
    }


}
