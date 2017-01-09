/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for invoice payment.
 */

public class InvoicePayment {
    private String invoicePaymentId = "";
    private String paymentId = "";
    private String invoiceId = "";
    private double amountUsed = 0.00;

    private double amountApplied = 0.00;


    /**
     * set the invoice payment id.
     *
     * @param invoicePaymentId ID of the invoice payment.
     */

    public void setInvoicePaymentId(String invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
    }

    /**
     * get the invoice payment id.
     *
     * @return Returns the id of the invoice payment.
     */

    public String getInvoicePaymentId() {
        return invoicePaymentId;
    }

    /**
     * set the payment id.
     *
     * @param paymentId ID of the payment from which credit has to be applied.
     */

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * get the payment id.
     *
     * @return Returns the id of the payment from which credit has to be applied.
     */

    public String getPaymentId() {
        return paymentId;
    }

    /**
     * set the invoice id.
     *
     * @param invoiceId ID of the invoice applied to the payments.
     */

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * get the invoice id.
     *
     * @return Returns the id of the invoice applied to the payments.
     */

    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * set the amount used.
     *
     * @param amountUsed Amount used to the invoice.
     */

    public void setAmountUsed(double amountUsed) {
        this.amountUsed = amountUsed;
    }

    /**
     * get the amount used.
     *
     * @return Returns the amount used to the invoice.
     */

    public double getAmountUsed() {
        return amountUsed;
    }


    /**
     * set the amount applied.
     *
     * @param amountApplied Amount applied to the invoice.
     */

    public void setAmountApplied(double amountApplied) {
        this.amountApplied = amountApplied;
    }

    /**
     * get the amount applied.
     *
     * @return Returns the amount applied to the invoice.
     */

    public double getAmountApplied() {
        return amountApplied;
    }
}
