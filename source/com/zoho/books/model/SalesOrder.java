/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * SalesOrder class is used to create an object for sales order.
 *
 * @author ramesh-2099
 */

public class SalesOrder {

    private String salesorderId;
    private String customerName;
    private String customerId;
    private String status;
    private String salesorderNumber;
    private String referenceNumber;
    private String date;
    private String shipmentDate;
    private String shipmentDays;
    private String currencyId;
    private String currencyCode;
    private double total;
    private double bcyTotal;
    private String createdTime;
    private String lastModifiedTime;
    private boolean isEmailed;


    private String currencySymbol;
    private double exchangeRate;
    private double discount;
    private boolean isDiscountBeforeTax;
    private String discountType;
    private String estimateId;
    private String deliveryMethod;
    private String deliveryMethodId;
    private double shippingCharge;
    private double adjustment;
    private String adjustmentDescription;
    private double subTotal;
    private double taxTotal;
    private int pricePrecision;
    private String notes;
    private String terms;
    private String templateId;
    private String templateName;
    private String templateType;
    private String attachmentName;
    private boolean canSendInMail;
    private String salespersonId;
    private String salespersonName;

    private String[] contactPersons = new String[]{};

    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private List<Tax> taxes = new ArrayList<Tax>();
    private Address billingAddress;
    private Address shippingAddress;
    private List<CustomField> customFields = new ArrayList<CustomField>();

    private String taxId;
    private String taxAuthorityId;
    private String taxExemptionId;


    /**
     * Get the sales order id.
     *
     * @return Returns the sales order id.
     */

    public String getSalesorderId() {
        return salesorderId;
    }

    /**
     * Set the sales order id.
     *
     * @param salesorderId ID of the sales order.
     */

    public void setSalesorderId(String salesorderId) {
        this.salesorderId = salesorderId;
    }

    /**
     * Get the customer name.
     *
     * @return Returns the customer name.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the customer name.
     *
     * @param customerName Name of the customer.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get the customer id.
     *
     * @return Returns the customer id.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer id.
     *
     * @param customerId ID of the customer.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * @param status Status of the sales order.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the sales order number.
     *
     * @return Returns the sales order number.
     */

    public String getSalesorderNumber() {
        return salesorderNumber;
    }

    /**
     * Set the sales order number.
     *
     * @param salesorderNumber Number of the sales order.
     */

    public void setSalesorderNumber(String salesorderNumber) {
        this.salesorderNumber = salesorderNumber;
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
     * @param referenceNumber Reference number of the sales order.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
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
     * @param date Date of the sales order.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the shipment date.
     *
     * @return Returns the shipment date.
     */

    public String getShipmentDate() {
        return shipmentDate;
    }

    /**
     * Set the shipment date.
     *
     * @param shipmentDate Date of the shipment.
     */

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    /**
     * Get the shipment days.
     *
     * @return Returns the shipment days.
     */

    public String getShipmentDays() {
        return shipmentDays;
    }

    /**
     * Set the shipment days.
     *
     * @param shipmentDays Shipment days for the sales order.
     */

    public void setShipmentDays(String shipmentDays) {
        this.shipmentDays = shipmentDays;
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
     * Get the total.
     *
     * @return Returns the total.
     */

    public double getTotal() {
        return total;
    }

    /**
     * Set the total.
     *
     * @param total Total of the sales order.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Get the bcy total.
     *
     * @return Returns the bcy total.
     */

    public double getBcyTotal() {
        return bcyTotal;
    }

    /**
     * Set the bcy total.
     *
     * @param bcyTotal BCY total of the sales order.
     */

    public void setBcyTotal(double bcyTotal) {
        this.bcyTotal = bcyTotal;
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
     * @param createdTime Created time of the sales order.
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
     * @param lastModifiedTime Last modified time of the sales order.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * Get the sales order is emailed or not.
     *
     * @return Returns true if the sales order is emailed else returns false.
     */

    public boolean isEmailed() {
        return isEmailed;
    }

    /**
     * Set the sales order is emailed or not.
     *
     * @param isEmailed True or false to set the sales order is emailed or not.
     */

    public void setEmailed(boolean isEmailed) {
        this.isEmailed = isEmailed;
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
     * @param exchangeRate Exchange rate of the currency.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * Get the discount.
     *
     * @return Returns the discount.
     */

    public double getDiscount() {
        return discount;
    }

    /**
     * Set the discount.
     *
     * @param discount Discount of the sales order.
     */

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Get the sales order is discount before tax or not.
     *
     * @return Returns true if the sales order is discount before tax else returns false.
     */

    public boolean isDiscountBeforeTax() {
        return isDiscountBeforeTax;
    }

    /**
     * Set the sales order is discount before tax or not.
     *
     * @param isDiscountBeforeTax True or false to set the sales order is discount before tax or not.
     */

    public void setDiscountBeforeTax(boolean isDiscountBeforeTax) {
        this.isDiscountBeforeTax = isDiscountBeforeTax;
    }

    /**
     * Get the discount type.
     *
     * @return Returns the discount type.
     */

    public String getDiscountType() {
        return discountType;
    }

    /**
     * Set the discunt type.
     *
     * @param discountType Type of the disocunt.
     */

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * Get the estimate id.
     *
     * @return Returns the estimate id.
     */

    public String getEstimateId() {
        return estimateId;
    }

    /**
     * Set the estimate id.
     *
     * @param estimateId ID of the estimate.
     */

    public void setEstimateId(String estimateId) {
        this.estimateId = estimateId;
    }

    /**
     * Get the delivery method.
     *
     * @return Returns the delivery method.
     */

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Set the delivery method.
     *
     * @param deliveryMethod Method of the order delivered.
     */

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Get the delivery method id.
     *
     * @return Returns the delivery method id.
     */

    public String getDeliveryMethodId() {
        return deliveryMethodId;
    }

    /**
     * Set the delivery method id.
     *
     * @param deliveryMethodId ID of the order delivery method.
     */

    public void setDeliveryMethodId(String deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    /**
     * Get the shipping charge.
     *
     * @return Returns the shipping charge.
     */

    public double getShippingCharge() {
        return shippingCharge;
    }

    /**
     * Set the shipping charge.
     *
     * @param shippingCharge Shipping charge of the order.
     */

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    /**
     * Get the adjustment.
     *
     * @return Returns the adjustment.
     */

    public double getAdjustment() {
        return adjustment;
    }

    /**
     * Set the adjustment.
     *
     * @param adjustment Adjustment of the order.
     */

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }

    /**
     * Get the adjustment description.
     *
     * @return Returns the adjustment description.
     */

    public String getAdjustmentDescription() {
        return adjustmentDescription;
    }

    /**
     * Set the adjustment description.
     *
     * @param adjustmentDescription Adjustment description of the order.
     */

    public void setAdjustmentDescription(String adjustmentDescription) {
        this.adjustmentDescription = adjustmentDescription;
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
     * @param subTotal Sub total of the order.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Get the tax total.
     *
     * @return Returns the tax total.
     */

    public double getTaxTotal() {
        return taxTotal;
    }

    /**
     * Set the tax total.
     *
     * @param taxTotal Tax total of the order.
     */

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * Get the price precision.
     *
     * @return Returns the price pricision.
     */

    public int getPricePrecision() {
        return pricePrecision;
    }

    /**
     * Set the price precision.
     *
     * @param pricePrecision Price precision of the order.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
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
     * @param notes Notes of the sales order.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Get the terms.
     *
     * @return Returns the terms.
     */

    public String getTerms() {
        return terms;
    }

    /**
     * Set the terms.
     *
     * @param terms Terms of the sales order.
     */

    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * Get the template id.
     *
     * @return Returns the template id.
     */

    public String getTemplateId() {
        return templateId;
    }

    /**
     * Set the template id.
     *
     * @param templateId ID of the template.
     */

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Get the template name.
     *
     * @return Returns the template name.
     */

    public String getTemplateName() {
        return templateName;
    }

    /**
     * Set the template name.
     *
     * @param templateName Name of the template.
     */

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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
     * @param templateType Type of the template.
     */

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    /**
     * Get the attachment name.
     *
     * @return Returns the attachemnt name.
     */

    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * Set the attachment name.
     *
     * @param attachmentName Name of the attachment.
     */

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * Get the order can send in email or not.
     *
     * @return Returns true of the order is send in email else returns false.
     */

    public boolean canSendInMail() {
        return canSendInMail;
    }

    /**
     * Set the order can send in mail or not.
     *
     * @param canSendInMail True or false to set the order can send in mail or not.
     */

    public void setCanSendInMail(boolean canSendInMail) {
        this.canSendInMail = canSendInMail;
    }

    /**
     * Get the salesperson id.
     *
     * @return Returns the salesperson id.
     */

    public String getSalespersonId() {
        return salespersonId;
    }

    /**
     * Set the salesperson id.
     *
     * @param salespersonId ID of the salesperson.
     */

    public void setSalespersonId(String salespersonId) {
        this.salespersonId = salespersonId;
    }

    /**
     * Get the salesperson name.
     *
     * @return Returns the salesperson name.
     */

    public String getSalespersonName() {
        return salespersonName;
    }

    /**
     * Set the salesperson name.
     *
     * @param salespersonName Name of the salesperson.
     */

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    /**
     * Get the contact persons.
     *
     * @return Returns array of contact persons.
     */

    public String[] getContactPersons() {
        return contactPersons;
    }

    /**
     * Set the contact persons.
     *
     * @param contactPersons Array of contact persons.
     */

    public void setContactPersons(String[] contactPersons) {
        this.contactPersons = contactPersons;
    }

    /**
     * Get list of line items.
     *
     * @return Returns List of LineItem object.
     */

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * Set list of line items.
     *
     * @param lineItems List of LineItem object.
     */

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Get list of taxes.
     *
     * @return Returns List of Tax object.
     */

    public List<Tax> getTaxes() {
        return taxes;
    }

    /**
     * Set list of taxes.
     *
     * @param taxes List of Tax object.
     */

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    /**
     * Get the billing address.
     *
     * @return Returns the Address object.
     */

    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Set the billing address.
     *
     * @param billingAddress Address object.
     */

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Get the shipping address.
     *
     * @return Returns the Address object.
     */

    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Set the shipping address.
     *
     * @param shippingAddress Address object.
     */

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Get list of custom fields.
     *
     * @return Returns Returns list of CustomField object.
     */

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    /**
     * Set list of custom fields.
     *
     * @param customFields List of CustomField object.
     */

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }


    /**
     * Get the tax id(US Edition only).
     *
     * @return Returns the tax id(US Edition only).
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * Set the tax id(US Edition only).
     *
     * @param taxId ID of the tax(US Edition only).
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * Get the tax authority id(US Edition only).
     *
     * @return Returns the tax authority id(US Edition only).
     */

    public String getTaxAuthorityId() {
        return taxAuthorityId;
    }

    /**
     * Set the tax authority id(US Edition only).
     *
     * @param taxAuthorityId ID of the tax authority(US Edition only).
     */

    public void setTaxAuthorityId(String taxAuthorityId) {
        this.taxAuthorityId = taxAuthorityId;
    }

    /**
     * Get the tax exemption id(US Edition only).
     *
     * @return Returns the tax exemption id(US Edition only).
     */

    public String getTaxExemptionId() {
        return taxExemptionId;
    }

    /**
     * Set the tax exemption id(US Edition only).
     *
     * @param taxExemptionId ID of the tax exemption(US Edition only).
     */

    public void setTaxExemptionId(String taxExemptionId) {
        this.taxExemptionId = taxExemptionId;
    }


    /**
     * Convert the SalesOrder object into JSONObject.
     *
     * @return Returns the JSONObject.
     * @throws Exception
     */

    public JSONObject toJSON() throws Exception {

        JSONObject jsonObject = new JSONObject();

        if (customerId != null && !customerId.equals("")) {
            jsonObject.put("customer_id", customerId);
        }
        if (salesorderNumber != null && !salesorderNumber.equals("")) {
            jsonObject.put("salesorder_number", salesorderNumber);
        }
        if (templateId != null && !templateId.equals("")) {
            jsonObject.put("template_id", templateId);
        }
        if (date != null && !date.equals("")) {
            jsonObject.put("date", date);
        }
        if (shipmentDate != null && !shipmentDate.equals("")) {
            jsonObject.put("shipment_date", shipmentDate);
        }
        if ((Double) discount != null) {
            jsonObject.put("discount", discount);
        }
        if ((Boolean) isDiscountBeforeTax != null) {
            jsonObject.put("is_discount_before_tax", isDiscountBeforeTax);
        }
        if (discountType != null && !discountType.equals("")) {
            jsonObject.put("discount_type", discountType);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (salespersonName != null && !salespersonName.equals("")) {
            jsonObject.put("salesperson_name", salespersonName);
        }
        if (estimateId != null && !estimateId.equals("")) {
            jsonObject.put("estimate_id", estimateId);
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

        if (contactPersons != null && contactPersons.length > 0) {
            JSONArray contactpersons = new JSONArray();

            for (int i = 0; i < contactPersons.length; i++) {
                contactpersons.put(contactPersons[i]);
            }

            jsonObject.put("contact_persons", contactpersons);
        }

        if (lineItems != null && lineItems.size() > 0) {
            JSONArray lineitems = new JSONArray();

            for (int i = 0; i < lineItems.size(); i++) {
                lineitems.put(lineItems.get(i).toJSON());
            }

            jsonObject.put("line_items", lineitems);
        }

        if (customFields != null && customFields.size() > 0) {
            JSONArray customfields = new JSONArray();

            for (int i = 0; i < customFields.size(); i++) {
                customfields.put(customFields.get(i).toJSON());
            }

            jsonObject.put("custom_fields", customfields);
        }

        return jsonObject;

    }


}
