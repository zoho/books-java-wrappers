/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for invoice settings.
 */

public class InvoiceSetting {
    private boolean autoGenerate = true;
    private String prefixString = "";
    private long startAt = 0;
    private String nextNumber = "";
    private int quantityPrecision = 0;
    private String discountType = "";
    private boolean isDiscountBeforeTax = false;
    private String referenceText = "";
    private String notes = "";
    private String terms = "";
    private boolean isShippingChargeRequired = false;
    private boolean isAdjustmentRequired = false;
    private boolean isOpenInvoiceEditable = false;
    private boolean warnConvertToOpen = false;
    private boolean warnCreateCreditnotes = false;
    private String attachExpenseReceiptToInvoice = "";
    private String invoiceItemType = "";
    private boolean isShowInvoiceSetup = false;
    private boolean isSalesPersonRequired = false;


    private boolean discountEnabled = false;
    private String defaultTemplateId = "";


    /**
     * set auto generate.
     *
     * @param autoGenerate Boolean to enable or disable auto number generation.
     */

    public void setAutoGenerate(boolean autoGenerate) {
        this.autoGenerate = autoGenerate;
    }

    /**
     * get auto generate.
     *
     * @return Returns true if the auto number generation is enabled elase returns false.
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
     * @return Returns the prefix string for entity auto number generation.
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
     * @return Returns the type of discounts applicable for invoice with either entity level or item level or no discount.
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
     * @return Returns true if the invoice is discount before tax else returns false.
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
     * set is shipping charge required.
     *
     * @param isShippingChargeRequired To determine whether shipping charges to be included in invoice.
     */

    public void setIsShippingChargeRequired(boolean isShippingChargeRequired) {
        this.isShippingChargeRequired = isShippingChargeRequired;
    }

    /**
     * get is shipping charge required.
     *
     * @return Returns true if the shipping charges to be included in invoice else returns false.
     */

    public boolean isShippingChargeRequired() {
        return isShippingChargeRequired;
    }

    /**
     * set is adjustment required.
     *
     * @param isAdjustmentRequired To determine whether adjustments are required for invoices.
     */

    public void setIsAdjustmentRequired(boolean isAdjustmentRequired) {
        this.isAdjustmentRequired = isAdjustmentRequired;
    }

    /**
     * get is adjustment required.
     *
     * @return Returns true if the adjustments are required for invoices else returns false.
     */

    public boolean isAdjustmentRequired() {
        return isAdjustmentRequired;
    }

    /**
     * set is open invoice editable.
     *
     * @param isOpenInvoiceEditable To determine whether sent invoices can be edited.
     */

    public void setIsOpenInvoiceEditable(boolean isOpenInvoiceEditable) {
        this.isOpenInvoiceEditable = isOpenInvoiceEditable;
    }

    /**
     * get is open invoice editable.
     *
     * @return Returns true if the sent invoices can be edited else returns false.
     */

    public boolean isOpenInvoiceEditable() {
        return isOpenInvoiceEditable;
    }

    /**
     * set warn convert to open.
     *
     * @param warnConvertToOpen To enable warning while converting a draft invoice to sent status.
     */

    public void setWarnConvertToOpen(boolean warnConvertToOpen) {
        this.warnConvertToOpen = warnConvertToOpen;
    }

    /**
     * get warn convert to open.
     *
     * @return Returns true if the draft invoice to sent status is enable else returns false.
     */

    public boolean warnConvertToOpen() {
        return warnConvertToOpen;
    }

    /**
     * set warn create creditnotes.
     *
     * @param warnCreateCreditnotes To enable warning while creating a creditnote.
     */

    public void setWarnCreateCreditnotes(boolean warnCreateCreditnotes) {
        this.warnCreateCreditnotes = warnCreateCreditnotes;
    }

    /**
     * get warn create creditnotes.
     *
     * @return Returns true if enable warning while creating a creditnote else returns false.
     */

    public boolean warnCreateCreditnotes() {
        return warnCreateCreditnotes;
    }

    /**
     * set the attach expense receipt to invoice.
     *
     * @param attachExpenseReceiptToInvoice Expense receipt attached to the invoice.
     */

    public void setAttachExpenseReceiptToInvoice(String attachExpenseReceiptToInvoice) {
        this.attachExpenseReceiptToInvoice = attachExpenseReceiptToInvoice;
    }

    /**
     * get the attach expense receipt to invoice.
     *
     * @return Returns the expense receipt attached to the invoice.
     */

    public String getAttachExpenseReceiptToInvoice() {
        return attachExpenseReceiptToInvoice;
    }

    /**
     * set the invoice item type.
     *
     * @param invoiceItemType Select between the type of line item for invoice with either product or project or both.
     */

    public void setInvoiceItemType(String invoiceItemType) {
        this.invoiceItemType = invoiceItemType;
    }

    /**
     * get the invoice item type.
     *
     * @return Returns the type of line item for invoice with either product or project or both.
     */

    public String getInvoiceItemType() {
        return invoiceItemType;
    }

    /**
     * set is show invoice setup.
     *
     * @param isShowInvoiceSetup To determine whether the invoice setup is show or not.
     */

    public void setIsShowInvoiceSetup(boolean isShowInvoiceSetup) {
        this.isShowInvoiceSetup = isShowInvoiceSetup;
    }

    /**
     * get is show invoice setup.
     *
     * @return Returns true if the invoice setup is show else returns false.
     */

    public boolean isShowInvoiceSetup() {
        return isShowInvoiceSetup;
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
     * @return Returns true if the field for sales person is required else returns false.
     */

    public boolean isSalesPersonRequired() {
        return isSalesPersonRequired;
    }


    /**
     * set discount enabled.
     *
     * @param discountEnabled To enable or disable discounts.
     */

    public void setDiscountEnabled(boolean discountEnabled) {
        this.discountEnabled = discountEnabled;
    }

    /**
     * get discount enabled.
     *
     * @return Returns true if the discounts are enabled else returns false.
     */

    public boolean isDiscountEnabled() {
        return discountEnabled;
    }

    /**
     * set the default template id.
     *
     * @param defaultTemplateId ID of the default template.
     */

    public void setDefaultTemplateId(String defaultTemplateId) {
        this.defaultTemplateId = defaultTemplateId;
    }

    /**
     * get the default template id.
     *
     * @return Returns the id of the default template.
     */

    public String getDefaultTemplateId() {
        return defaultTemplateId;
    }


    /**
     * Convert InvoiceSetting object into JSONObject.
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
        //jsonObject.put("discount_enabled", discountEnabled);
        jsonObject.put("reference_text", referenceText);
        //jsonObject.put("default_template_id", defaultTemplateId);
        jsonObject.put("notes", notes);
        jsonObject.put("terms", terms);
        jsonObject.put("is_shipping_charge_required", isShippingChargeRequired);
        jsonObject.put("is_adjustment_required", isAdjustmentRequired);
        jsonObject.put("invoice_item_type", invoiceItemType);
        jsonObject.put("is_show_invoice_setup", isShowInvoiceSetup);
        jsonObject.put("discount_type", discountType);
        jsonObject.put("warn_convert_to_open", warnConvertToOpen);
        jsonObject.put("warn_create_creditnotes", warnCreateCreditnotes);
        jsonObject.put("is_open_invoice_editable", isOpenInvoiceEditable);
        jsonObject.put("is_sales_person_required", isSalesPersonRequired);

        return jsonObject;
    }

}
