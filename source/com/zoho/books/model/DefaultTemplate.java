/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for default templates.
 */

public class DefaultTemplate {
    private String invoiceTemplateId = "";
    private String invoiceTemplateName = "";
    private String estimateTemplateId = "";
    private String estimateTemplateName = "";
    private String creditnoteTemplateId = "";
    private String creditnoteTemplateName = "";
    private String invoiceEmailTemplateId = "";
    private String invoiceEmailTemplateName = "";
    private String estimateEmailTemplateId = "";
    private String estimateEmailTemplateName = "";
    private String creditnoteEmailTemplateId = "";
    private String creditnoteEmailTemplateName = "";


    /**
     * set the invoice template id.
     *
     * @param invoiceTemplateId ID of the invoice template.
     */

    public void setInvoiceTemplateId(String invoiceTemplateId) {
        this.invoiceTemplateId = invoiceTemplateId;
    }

    /**
     * get the invoice template id.
     *
     * @return Returns the invoice template id.
     */

    public String getInvoiceTemplateId() {
        return invoiceTemplateId;
    }

    /**
     * set the invoice template name.
     *
     * @param invoiceTemplateName Name of the invoice template.
     */

    public void setInvoiceTemplateName(String invoiceTemplateName) {
        this.invoiceTemplateName = invoiceTemplateName;
    }

    /**
     * get the invoice template name.
     *
     * @return Returns the invoice template name.
     */

    public String getInvoiceTemplateName() {
        return invoiceTemplateName;
    }

    /**
     * set the estimate template id.
     *
     * @param estimateTemplateId ID of the estimate template.
     */

    public void setEstimateTemplateId(String estimateTemplateId) {
        this.estimateTemplateId = estimateTemplateId;
    }

    /**
     * get the estimate template id.
     *
     * @return Returns the estimate template id.
     */

    public String getEstimateTemplateId() {
        return estimateTemplateId;
    }

    /**
     * set the estimate template name.
     *
     * @param estimateTemplateName Name of the estimate template.
     */

    public void setEstimateTemplateName(String estimateTemplateName) {
        this.estimateTemplateName = estimateTemplateName;
    }

    /**
     * get the estimate template name.
     *
     * @return Returns the estimate template name.
     */

    public String getEstimateTemplateName() {
        return estimateTemplateName;
    }

    /**
     * set the creditnote template id.
     *
     * @param creditnoteTemplateId ID of the creditnote template.
     */

    public void setCreditnoteTemplateId(String creditnoteTemplateId) {
        this.creditnoteTemplateId = creditnoteTemplateId;
    }

    /**
     * get the creditnote template id.
     *
     * @return Returns the creditnote template id.
     */

    public String getCreditnoteTemplateId() {
        return creditnoteTemplateId;
    }

    /**
     * set the creditnote template name.
     *
     * @param creditnoteTemplateName Name of the creditnote template.
     */

    public void setCreditnoteTemplateName(String creditnoteTemplateName) {
        this.creditnoteTemplateName = creditnoteTemplateName;
    }

    /**
     * get the creditnote template name.
     *
     * @return Returns the creditnote template name.
     */

    public String getCreditnoteTemplateName() {
        return creditnoteTemplateName;
    }

    /**
     * set the invoice email template id.
     *
     * @param invoiceEmailTemplateId ID of the invoice email template.
     */

    public void setInvoiceEmailTemplateId(String invoiceEmailTemplateId) {
        this.invoiceEmailTemplateId = invoiceEmailTemplateId;
    }

    /**
     * get the invoice email template id.
     *
     * @return Returns the invoice email template id.
     */

    public String getInvoiceEmailTemplateId() {
        return invoiceEmailTemplateId;
    }

    /**
     * set the invoice email template name.
     *
     * @param invoiceEmailTemplateName Name of the invoice email template.
     */

    public void setInvoiceEmailTemplateName(String invoiceEmailTemplateName) {
        this.invoiceEmailTemplateName = invoiceEmailTemplateName;
    }

    /**
     * get the invoice email template name.
     *
     * @return Returns the invoice email template name.
     */

    public String getInvoiceEmailTemplateName() {
        return invoiceEmailTemplateName;
    }

    /**
     * set the estimate email template id.
     *
     * @param estimateEmailTemplateId ID of the estimate email template.
     */

    public void setEstimateEmailTemplateId(String estimateEmailTemplateId) {
        this.estimateEmailTemplateId = estimateEmailTemplateId;
    }

    /**
     * get the estimate email template id.
     *
     * @return Returns the estimate email template id.
     */

    public String getEstimateEmailTemplateId() {
        return estimateEmailTemplateId;
    }

    /**
     * set the estimate email template name.
     *
     * @param estimateEmailTemplateName Name of the estimate email template.
     */

    public void setEstimateEmailTemplateName(String estimateEmailTemplateName) {
        this.estimateEmailTemplateName = estimateEmailTemplateName;
    }

    /**
     * get the estimate email template name.
     *
     * @return Returns the estimate email template name.
     */

    public String getEstimateEmailTemplateName() {
        return estimateEmailTemplateName;
    }

    /**
     * set the creditnote email template id.
     *
     * @param creditnoteEmailTemplateId ID of the creditnote email template.
     */

    public void setCreditnoteEmailTemplateId(String creditnoteEmailTemplateId) {
        this.creditnoteEmailTemplateId = creditnoteEmailTemplateId;
    }

    /**
     * get the creditnote email template id.
     *
     * @return Returns the creditnote email template id.
     */

    public String getCreditnoteEmailTemplateId() {
        return creditnoteEmailTemplateId;
    }

    /**
     * set the creditnote email template name.
     *
     * @param creditnoteEmailTemplateName Name of the creditnote email template.
     */

    public void setCreditnoteEmailTemplateName(String creditnoteEmailTemplateName) {
        this.creditnoteEmailTemplateName = creditnoteEmailTemplateName;
    }

    /**
     * get the creditnote email template name.
     *
     * @return Returns the creditnote email template name.
     */

    public String getCreditnoteEmailTemplateName() {
        return creditnoteEmailTemplateName;
    }


    /**
     * Convert the DefaultTemplate object into JSONObject.
     *
     * @return Returns the JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (invoiceTemplateId != null) {
            jsonObject.put("invoice_template_id", invoiceTemplateId);
        }

        if (estimateTemplateId != null) {
            jsonObject.put("estimate_template_id", estimateTemplateId);
        }

        if (creditnoteTemplateId != null) {
            jsonObject.put("creditnote_template_id", creditnoteTemplateId);
        }

        if (invoiceEmailTemplateId != null) {
            jsonObject.put("invoice_email_template_id", invoiceEmailTemplateId);
        }

        if (estimateEmailTemplateId != null) {
            jsonObject.put("estimate_email_template_id", estimateEmailTemplateId);
        }

        if (creditnoteEmailTemplateId != null) {
            jsonObject.put("creditnote_email_template_id", creditnoteEmailTemplateId);
        }

        return jsonObject;
    }
}
