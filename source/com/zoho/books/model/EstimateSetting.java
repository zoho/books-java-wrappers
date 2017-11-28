/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for estimate settings.
 */

public class EstimateSetting {
    private boolean autoGenerate = true;
    private String prefixString = "";
    private long startAt = 0;
    private String nextNumber = "";
    private int quantityPrecision = 0;
    private String discountType = "";
    private boolean isDiscountBeforeTax = false;
    private String referenceText = "";
    private String defaultTemplateId = "";
    private String notes = "";
    private String terms = "";
    private boolean termsToInvoice = false;
    private boolean notesToInvoice = false;
    private boolean warnEstimateToInvoice = false;
    private boolean isSalesPersonRequired = false;


    /**
     * set auto generate.
     *
     * @param autoGenerate To enable or disable auto number generation.
     */

    public void setAutoGenerate(boolean autoGenerate) {
        this.autoGenerate = autoGenerate;
    }

    /**
     * get auto generate.
     *
     * @return Returns true if the auto number generation is enable else returns false.
     */

    public boolean isAutoGenerate() {
        return autoGenerate;
    }

    /**
     * set the prefix string.
     *
     * @param prefixString Prefix string for entity auto number generation.
     */

    public void setPrefixString(String prefixString) {
        this.prefixString = prefixString;
    }

    /**
     * get the prefix string.
     *
     * @return Returns the Prefix string for entity auto number generation.
     */

    public String getPrefixString() {
        return prefixString;
    }

    /**
     * set the start at number.
     *
     * @param startAt Number at which the auto number generation should begin with.
     */

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    /**
     * get the start at number.
     *
     * @return Returns the number at which the auto number generation should begin with.
     */

    public long getStartAt() {
        return startAt;
    }

    /**
     * set the next number.
     *
     * @param nextNumber Number that will be next updated while creating an entity.
     */

    public void setNextNumber(String nextNumber) {
        this.nextNumber = nextNumber;
    }

    /**
     * get the next number.
     *
     * @return Returns the number that will be next updated while creating an entity.
     */

    public String getNextNumber() {
        return nextNumber;
    }

    /**
     * set the quantity precision.
     *
     * @param quantityPrecision Number of decimal places to be configured for quantity.
     */

    public void setQuantityPrecision(int quantityPrecision) {
        this.quantityPrecision = quantityPrecision;
    }

    /**
     * get the quantity precision.
     *
     * @return Returns the number of decimal places to be configured for quantity.
     */

    public int getQuantityPrecision() {
        return quantityPrecision;
    }

    /**
     * set the discount type.
     *
     * @param discountType Select between the type of discounts applicable for invoice with either entity level or item level or no discount.
     */

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * get the discount type.
     *
     * @return Returns the discount type of the applicable invoice.
     */

    public String getDiscountType() {
        return discountType;
    }

    /**
     * set is discount before tax.
     *
     * @param isDiscountBeforeTax Used to specify how the discount has to applied. Either before or after the calculation of tax.
     */

    public void setIsDiscountBeforeTax(boolean isDiscountBeforeTax) {
        this.isDiscountBeforeTax = isDiscountBeforeTax;
    }

    /**
     * get is discount before tax.
     *
     * @return Returns true if the discount is befor tax else returns false.
     */

    public boolean isDiscountBeforeTax() {
        return isDiscountBeforeTax;
    }

    /**
     * set the reference text.
     *
     * @param referenceText Label for the reference number.
     */

    public void setReferenceText(String referenceText) {
        this.referenceText = referenceText;
    }

    /**
     * get the reference text.
     *
     * @return Returns the label for the reference number.
     */

    public String getReferenceText() {
        return referenceText;
    }

    /**
     * set the default template id.
     *
     * @param defaultTemplateId ID of the template that has been used as default template for an entity.
     */

    public void setDefaultTemplateId(String defaultTemplateId) {
        this.defaultTemplateId = defaultTemplateId;
    }

    /**
     * get the default template id.
     *
     * @return Returns the id of the template that has been used as default template for an entity.
     */

    public String getDefaultTemplateId() {
        return defaultTemplateId;
    }

    /**
     * set the notes.
     *
     * @param notes Notes to the customer.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the notes to the customer.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * set the terms.
     *
     * @param terms Terms and conditions.
     */

    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * get the terms.
     *
     * @return Returns the terms and conditions.
     */

    public String getTerms() {
        return terms;
    }

    /**
     * set terms to invoice.
     *
     * @param termsToInvoice To determine whether terms and conditions field is to be copied from estimate to invoice.
     */

    public void setTermsToInvoice(boolean termsToInvoice) {
        this.termsToInvoice = termsToInvoice;
    }

    /**
     * get terms to invoice.
     *
     * @return Returns true if the terms copied from estimate to invoice else returns false.
     */

    public boolean isTermsToInvoice() {
        return termsToInvoice;
    }

    /**
     * set notes to invoice.
     *
     * @param notesToInvoice To determine whether customer notes field is to be copied from estimate to invoice.
     */

    public void setNotesToInvoice(boolean notesToInvoice) {
        this.notesToInvoice = notesToInvoice;
    }

    /**
     * get notes to invoice.
     *
     * @return Returns true if the notes copied from estimate to invoice else returns false.
     */

    public boolean isNotesToInvoice() {
        return notesToInvoice;
    }

    /**
     * set warn estimate to invoice.
     *
     * @param warnEstimateToInvoice To warn estimate to invoice conversion.
     */

    public void setWarnEstimateToInvoice(boolean warnEstimateToInvoice) {
        this.warnEstimateToInvoice = warnEstimateToInvoice;
    }

    /**
     * get warn estimate to invoice.
     *
     * @return Returns true if the warn estimate to invoice conversion else returns false.
     */

    public boolean warnEstimateToInvoice() {
        return warnEstimateToInvoice;
    }

    /**
     * set is salesperson required.
     *
     * @param isSalesPersonRequired To determine whether a field for sales person is required.
     */

    public void setIsSalesPersonRequired(boolean isSalesPersonRequired) {
        this.isSalesPersonRequired = isSalesPersonRequired;
    }

    /**
     * get is salesperson required.
     *
     * @return Returns true if the salesperson is required else returns false.
     */

    public boolean isSalesPersonRequired() {
        return isSalesPersonRequired;
    }


    /**
     * Convert EstimateSetting object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("auto_generate", autoGenerate);
        jsonObject.put("prefix_string", prefixString);
        jsonObject.put("start_at", startAt);
        jsonObject.put("next_number", nextNumber);
        jsonObject.put("quantity_precision", quantityPrecision);
        jsonObject.put("reference_text", referenceText);
        //jsonObject.put("default_template_id", defaultTemplateId);
        jsonObject.put("notes", notes);
        jsonObject.put("terms", terms);
        jsonObject.put("terms_to_invoice", termsToInvoice);
        jsonObject.put("notes_to_invoice", notesToInvoice);
        jsonObject.put("warn_estimate_to_invoice", warnEstimateToInvoice);
        jsonObject.put("discount_type", discountType);
        jsonObject.put("is_sales_person_required", isSalesPersonRequired);

        return jsonObject;
    }


}
