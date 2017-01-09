/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for estimate.
 */

public class Estimate {

    private String estimateId = "";
    private String estimateNumber = "";
    private String date = "";
    private String referenceNumber = "";
    private String status = "";
    private String customerId = "";
    private String customerName = "";
    private String currencyCode = "";
    private double exchangeRate = 0.00;
    private double discount = 0.00;
    private boolean isDiscountBeforeTax = true;
    private String discountType = "";

    private String currencyId = "";
    private String acceptedDate = "";
    private String declinedDate = "";
    private String expiryDate = "";

    private double shippingCharge = 0.00;
    private double adjustment = 0.00;
    private String adjustmentDescription = "";
    private double subTotal = 0.00;
    private double total = 0.00;
    private double taxTotal = 0.00;
    private int pricePrecision = 0;

    private String notes = "";
    private String terms = "";
    private String templateId = "";
    private String templateName = "";
    private String createdTime = "";
    private String lastModifiedTime = "";
    private String salespersonId = "";
    private String salespersonName = "";


    private String[] contactPersons = {};

    private List<LineItem> lineItems = new ArrayList<LineItem>();

    private List<Tax> taxes = new ArrayList<Tax>();

    private Address billingAddress = new Address();

    private Address shippingAddress = new Address();

    private List<CustomField> customFields = new ArrayList<CustomField>();


    private boolean isViewedByClient;
    private String clientViewedTime;
    private String currencySymbol;
    private String templateType;
    private boolean allowPartialPayments;
    private boolean acceptRetainer;
    private String retainerPercentage;


    private List<PaymentGateway> paymentGateways = new ArrayList<PaymentGateway>();


    private String taxId;
    private String taxAuthorityId;
    private String taxExemptionId;


    /**
     * set the estimate id.
     *
     * @param estimateId ID of the estimate.
     */

    public void setEstimateId(String estimateId) {
        this.estimateId = estimateId;
    }

    /**
     * get the estimate id.
     *
     * @return Returns the estimate id.
     */

    public String getEstimateId() {
        return estimateId;
    }

    /**
     * set the estimate number.
     *
     * @param estimateNumber Mandatory if auto number generation is disabled.
     */

    public void setEstimateNumber(String estimateNumber) {
        this.estimateNumber = estimateNumber;
    }

    /**
     * get the estimate number.
     *
     * @return Returns the estimate number.
     */

    public String getEstimateNumber() {
        return estimateNumber;
    }

    /**
     * set the date.
     *
     * @param date The date the estimate is created.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date the estimate is created.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number for the estimate.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number for the estimate.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the status.
     *
     * @param status Status of the estimate.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the estimate.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the customer id.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the customer name.
     *
     * @param customerName Name of the customer.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the customer name.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the currency code.
     *
     * @param currencyCode Standard code for the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the currency  code.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate Exchange rate of the currency.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchange rate.
     *
     * @return Returns the exchange rate of the currency.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * set the discount.
     *
     * @param discount Discount applied to the invoice. It can be either in % or in amount. e.g. 12.5% or 190.
     */

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * get the discount.
     *
     * @return Returns the discount of the invoice.
     */

    public double getDiscount() {
        return discount;
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
     * set the discount type.
     *
     * @param discountType How the discount is specified. Allowed values are entity_level or item_level.
     */

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * get the discount type.
     *
     * @return Returns the discount type.
     */

    public String getDiscountType() {
        return discountType;
    }


    /**
     * set the currency id.
     *
     * @param currencyId Standard id of the currency.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the currency id.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the accepted date.
     *
     * @param acceptedDate Accepted date of the estimate.
     */

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    /**
     * get the accepted date.
     *
     * @return Returns the accepted date.
     */

    public String getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * set the declined date.
     *
     * @param declinedDate Declined date of the estimate.
     */

    public void setDeclinedDate(String declinedDate) {
        this.declinedDate = declinedDate;
    }

    /**
     * get the declined date.
     *
     * @return Returns the declined date.
     */

    public String getDeclinedDate() {
        return declinedDate;
    }

    /**
     * set the expiry date.
     *
     * @param expiryDate Date the estimate is valid upto.
     */

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * get the expiry date.
     *
     * @return Returns the expiry date.
     */

    public String getExpiryDate() {
        return expiryDate;
    }


    /**
     * set the shipping charge.
     *
     * @param shippingCharge Shipping charges applied to the invoice.
     */

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    /**
     * get the shipping charge.
     *
     * @return Returns the shipping charges applied to the invoice.
     */

    public double getShippingCharge() {
        return shippingCharge;
    }

    /**
     * set the adjustment.
     *
     * @param adjustment Adjustments made to the invoice.
     */

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }

    /**
     * get the adjustment.
     *
     * @return Returns the adjustments made to the invoice.
     */

    public double getAdjustment() {
        return adjustment;
    }

    /**
     * set the adjustment description.
     *
     * @param adjustmentDescription Customize the adjustment description. E.g. Rounding off.
     */

    public void setAdjustmentDescription(String adjustmentDescription) {
        this.adjustmentDescription = adjustmentDescription;
    }

    /**
     * get the adjustment description.
     *
     * @return Returns Customize the adjustment description.
     */

    public String getAdjustmentDescription() {
        return adjustmentDescription;
    }

    /**
     * set the sub total.
     *
     * @param subTotal Sub total of the estimate.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the estimate.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set the total.
     *
     * @param total Total of the estimate.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the estimate.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the tax total.
     *
     * @param taxTotal Tax total of the estimate.
     */

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * get the tax total.
     *
     * @return Returns the tax total of the estimate.
     */

    public double getTaxTotal() {
        return taxTotal;
    }

    /**
     * set the price precision.
     *
     * @param pricePrecision Price precision of the estimate.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * get the price precision.
     *
     * @return Returns the price precision of the estimate.
     */

    public int getPricePrecision() {
        return pricePrecision;
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
     * @return Returns the notes of the customer.
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
     * set the template id.
     *
     * @param templateId ID of the pdf template associated with the estimate.
     */

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * get the template id.
     *
     * @return Returns the id of the pdf template associated with the estimate.
     */

    public String getTemplateId() {
        return templateId;
    }

    /**
     * set the template name.
     *
     * @param templateName Name of the pdf template associated with the estimate.
     */

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * get the template name.
     *
     * @return Returns the name of the pdf template associated with the estimate.
     */

    public String getTemplateName() {
        return templateName;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time of the estimate.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the estimate.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time of the estimate.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time of the estimate.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * set the salesperson id.
     *
     * @param salespersonId ID of the salesperson.
     */

    public void setSalespersonId(String salespersonId) {
        this.salespersonId = salespersonId;
    }

    /**
     * get the salesperson id.
     *
     * @return Returns the salesperson id.
     */

    public String getSalespersonId() {
        return salespersonId;
    }

    /**
     * set the salesperson name.
     *
     * @param salespersonName Name of the salesperson.
     */

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    /**
     * get the salesperson name.
     *
     * @return Returns the salesperson name.
     */

    public String getSalespersonName() {
        return salespersonName;
    }


    /**
     * set the contact persons.
     *
     * @param contactPersons Array of contact person(s) for whom estimate has to be sent.
     */

    public void setContactPersons(String[] contactPersons) throws Exception {
        this.contactPersons = contactPersons;
    }

    /**
     * get the contact persons.
     *
     * @return Returns the array of contact persons.
     */

    public String[] getContactPersons() {
        return contactPersons;
    }


    /**
     * set the line items.
     *
     * @param lineItems Line items of an estimate.
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
     * set the taxes.
     *
     * @param taxes Taxes of an estimate.
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


    /**
     * set the billing address.
     *
     * @param billingAddress Billing address of an estimate.
     */

    public void setBillingAddress(Address billingAddress) throws Exception {
        this.billingAddress = billingAddress;
    }

    /**
     * get the billing address.
     *
     * @return Returns a BillingAddress object.
     */

    public Address getBillingAddress() {
        return billingAddress;
    }


    /**
     * set the shipping address.
     *
     * @param shippingAddress Shipping address of an estimate.
     */

    public void setShippingAddress(Address shippingAddress) throws Exception {
        this.shippingAddress = shippingAddress;
    }

    /**
     * get the shipping address.
     *
     * @return Returns a ShippingAddress object.
     */

    public Address getShippingAddress() {
        return shippingAddress;
    }


    /**
     * set the custom fields.
     *
     * @param customFields Custom fields for an estimate.
     */

    public void setCustomFields(List<CustomField> customFields) throws Exception {
        this.customFields = customFields;
    }

    /**
     * get the custom fields.
     *
     * @return Returns list of CustomField object.
     */

    public List<CustomField> getCustomFields() {
        return customFields;
    }


    /**
     * Get the estimate is viewed by client or not.
     *
     * @return Returns true if the estimate is viewed by client else returns false.
     */

    public boolean isViewedByClient() {
        return isViewedByClient;
    }

    /**
     * Set the estimate is viewed by client or not.
     *
     * @param isViewedByClient True or false to set the estimate is viewed by client.
     */

    public void setIsViewedByClient(boolean isViewedByClient) {
        this.isViewedByClient = isViewedByClient;
    }

    /**
     * Get the client viewed time.
     *
     * @return Returns the client viewed time.
     */

    public String getClientViewedTime() {
        return clientViewedTime;
    }

    /**
     * Set the client viewed time.
     *
     * @param clientViewedTime Estimate viewed time by the client.
     */

    public void setClientViewedTime(String clientViewedTime) {
        this.clientViewedTime = clientViewedTime;
    }

    /**
     * Get the currency symbol.
     *
     * @return Returns the currency symbol.
     */

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * Set the currency symbol.
     *
     * @param currencySymbol Symbol of the currency.
     */

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    /**
     * Get the template type.
     *
     * @return Returns the template type.
     */

    public String getTemplateType() {
        return templateType;
    }

    /**
     * Set the template type.
     *
     * @param templateType Type of the tmplate.
     */

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    /**
     * Get the estimate allows partial payment or not.
     *
     * @return Returns true if the estimate allows partial payment else returns false.
     */

    public boolean isAllowPartialPayments() {
        return allowPartialPayments;
    }

    /**
     * Set the estimate allows partial payment or not.
     *
     * @param allowPartialPayments True or false to set the estimate allows the partial payments or not.
     */

    public void setAllowPartialPayments(boolean allowPartialPayments) {
        this.allowPartialPayments = allowPartialPayments;
    }

    /**
     * Get the estimate is accept retainer or not.
     *
     * @return Returns true if the estimate is accept retainer.
     */

    public boolean isAcceptRetainer() {
        return acceptRetainer;
    }

    /**
     * Set the estimate is accept retainer or not.
     *
     * @param acceptRetainer True or false to set the estimate is accept retainer or not.
     */

    public void setAcceptRetainer(boolean acceptRetainer) {
        this.acceptRetainer = acceptRetainer;
    }

    /**
     * Get the retainer percentage.
     *
     * @return Returns the retainer percentage.
     */

    public String getRetainerPercentage() {
        return retainerPercentage;
    }

    /**
     * Set the retainer percentage.
     *
     * @param retainerPercentage Percentage of the retainer.
     */

    public void setRetainerPercentage(String retainerPercentage) {
        this.retainerPercentage = retainerPercentage;
    }


    /**
     * Get the list of payment gateways for the estimate.
     *
     * @return Returns list of PaymentGateway Object.
     */

    public List<PaymentGateway> getPaymentGateways() {
        return paymentGateways;
    }

    /**
     * Set the list of payment gateways for the estimate.
     *
     * @param paymentGateways List of PaymentGateway object.
     */

    public void setPaymentGateways(List<PaymentGateway> paymentGateways) {
        this.paymentGateways = paymentGateways;
    }


    /**
     * Get the tax id(US Edition only).
     *
     * @return Returns the tax id(US Edititon only).
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * Set the tax id(US Edition only).
     *
     * @param taxId Tax id for US Edition.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * Get tax authority id(US Edition only).
     *
     * @return Returns the tax authority id(US Edititon only).
     */

    public String getTaxAuthorityId() {
        return taxAuthorityId;
    }

    /**
     * Set the tax authority id(US Edititon only).
     *
     * @param taxAuthorityId Tax authority id for US edition.
     */

    public void setTaxAuthorityId(String taxAuthorityId) {
        this.taxAuthorityId = taxAuthorityId;
    }

    /**
     * Get the tax exemption id(US Edititon only).
     *
     * @return Returns the tax exemption id(US Edititon only).
     */

    public String getTaxExemptionId() {
        return taxExemptionId;
    }

    /**
     * Set the tax exemption id(US Edititon only).
     *
     * @param taxExemptionId Tax exemption id for US Edition.
     */

    public void setTaxExemptionId(String taxExemptionId) {
        this.taxExemptionId = taxExemptionId;
    }


    /**
     * Convert Estimate object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (contactPersons != null) {
            JSONArray contactPerson = new JSONArray();

            for (int i = 0; i < contactPersons.length; i++) {
                contactPerson.put(contactPersons[i]);
            }
            jsonObject.put("contact_persons", contactPerson);
        }
        if (estimateNumber != null && !estimateNumber.equals("")) {
            jsonObject.put("estimate_number", estimateNumber);
        }
        if (templateId != null && !templateId.equals("")) {
            jsonObject.put("template_id", templateId);
        }
        if (referenceNumber != null && !referenceNumber.equals("")) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if (customerId != null && !customerId.equals("")) {
            jsonObject.put("customer_id", customerId);
        }
        if (date != null && !date.equals("")) {
            jsonObject.put("date", date);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if ((Double) discount != null) {
            jsonObject.put("discount", discount);
        }
        if (notes != null && !notes.equals("")) {
            jsonObject.put("notes", notes);
        }
        if ((Double) shippingCharge != null) {
            jsonObject.put("shipping_charge", shippingCharge);
        }
        if ((Double) adjustment != null) {
            jsonObject.put("adjustment", adjustment);
        }

        if (lineItems != null) {
            JSONArray lineItem = new JSONArray();
            for (int i = 0; i < lineItems.size(); i++) {
                lineItem.put(lineItems.get(i).toJSON());
            }
            jsonObject.put("line_items", lineItem);
        }

        if (taxId != null && !taxId.equals("")) {
            jsonObject.put("tax_id", taxId);
        }
        if (taxAuthorityId != null && !taxAuthorityId.equals("")) {
            jsonObject.put("tax_authority_id", taxAuthorityId);
        }
        if (taxExemptionId != null && !taxExemptionId.equals("")) {
            jsonObject.put("tax_exemption_id", taxExemptionId);
        }

        return jsonObject;
    }


}
