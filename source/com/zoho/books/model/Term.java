/* $Id$ */

package com.zoho.books.model;

/**
 * this class is used to create a Term object.
 */

public class Term {
    private String invoiceTerms = "";
    private String estimateTerms = "";
    private String creditnoteTerms = "";


    /**
     * set the invoice terms.
     *
     * @param invoiceTerms Terms of the invoice.
     */

    public void setInvoiceTerms(String invoiceTerms) {
        this.invoiceTerms = invoiceTerms;
    }

    /**
     * get the invoice terms.
     *
     * @return Returns teh terms of the invoice.
     */

    public String getInvoiceTerms() {
        return invoiceTerms;
    }

    /**
     * set the estimate terms.
     *
     * @param estimateTerms Terms of the estimate.
     */

    public void setEstimateTerms(String estimateTerms) {
        this.estimateTerms = estimateTerms;
    }

    /**
     * get the estimate terms.
     *
     * @return Returns teh terms of the estimate.
     */

    public String getEstimateTerms() {
        return estimateTerms;
    }

    /**
     * set the creditnote terms.
     *
     * @param creditnoteTerms Terms of the creditnote.
     */

    public void setCreditnoteTerms(String creditnoteTerms) {
        this.creditnoteTerms = creditnoteTerms;
    }

    /**
     * get the creditnote terms.
     *
     * @return Returns teh terms of the creditnote.
     */

    public String getCreditnoteTerms() {
        return creditnoteTerms;
    }
}
