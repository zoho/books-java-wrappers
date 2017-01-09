/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * PurchaseOrder class is used to create an object for purchase order.
 *
 * @author ramesh-2099
 */

public class PurchaseOrder {

    private String purchaseorderId;
    private String vendorId;
    private String vendorName;
    private String status;
    private String purchaseorderNumber;
    private String referenceNumber;
    private String date;
    private String deliveryDate;
    private String currencyId;
    private String currencyCode;
    private int pricePrecision;
    private double total;
    private String createdTime;
    private String lastModifiedTime;


    private String expectedDeliveryDate;
    private String currencySymbol;
    private double exchangeRate;
    private boolean isEmailed;
    private double subTotal;
    private double taxTotal;
    private String notes;
    private String terms;
    private String shipVia;
    private String shipViaId;
    private String attention;
    private String deliveryOrgAddressId;
    private String deliveryCustomerId;
    private String attachmentName;
    private boolean canSendInMail;
    private String templateId;
    private String templateName;
    private String templateType;
    private boolean canMarkAsBill;
    private boolean canMarkAsUnbill;

    private String[] contactPersons = new String[]{};
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private List<Tax> taxes = new ArrayList<Tax>();
    private Address billingAddress;
    private Address deliveryAddress;
    private List<CustomField> customFields = new ArrayList<CustomField>();


    /**
     * Get the purchase order id.
     *
     * @return Returns the purchase order id.
     */

    public String getPurchaseorderId() {
        return purchaseorderId;
    }

    /**
     * Set the purchase order id.
     *
     * @param purchaseorderId ID of the purchase order.
     */

    public void setPurchaseorderId(String purchaseorderId) {
        this.purchaseorderId = purchaseorderId;
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
     * @param status Status of the order.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the purchase order number.
     *
     * @return Returns the purchase order number.
     */

    public String getPurchaseorderNumber() {
        return purchaseorderNumber;
    }

    /**
     * Set the purchase order number.
     *
     * @param purchaseorderNumber Number of the purchase order.
     */

    public void setPurchaseorderNumber(String purchaseorderNumber) {
        this.purchaseorderNumber = purchaseorderNumber;
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
     * @param referenceNumber Number of the reference.
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
     * @param date Date of the purchase order.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the delivery date.
     *
     * @return Returns the delivery date.
     */

    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Set the delivery date.
     *
     * @param deliveryDate Delivery date of the order.
     */

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
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
     * @param pricePrecision Price precision for the order.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
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
     * @param total Total for the order.
     */

    public void setTotal(double total) {
        this.total = total;
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
     * @param createdTime Created time for the order.
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
     * @param lastModifiedTime Last modified time of the order.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * Get the expected delivery date.
     *
     * @return Returns the expected delivery date.
     */

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    /**
     * Set the expected delivery date.
     *
     * @param expectedDeliveryDate Expected delivery date of the order.
     */

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
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
     * Get the purchase order is emailed or not.
     *
     * @return Returns true if the purchase order is emailed else returns false.
     */

    public boolean isEmailed() {
        return isEmailed;
    }

    /**
     * Set the purchase order is emailed or not.
     *
     * @param isEmailed True or false to set the purchase order is emailed or not.
     */

    public void setEmailed(boolean isEmailed) {
        this.isEmailed = isEmailed;
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
     * @param subTotal Sub total of the purchase order.
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
     * @param taxTotal Tax total of the purchase order.
     */

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
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
     * @param notes Notes for the purchase order.
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
     * @param terms Terms for the purchase order.
     */

    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * Get the ship via for the purchase order.
     *
     * @return Returns the ship via for the purchase order.
     */

    public String getShipVia() {
        return shipVia;
    }

    /**
     * Set the ship via for the purchase order.
     *
     * @param shipVia Ship via for the purchase order.
     */

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    /**
     * Get the ship via id.
     *
     * @return Returns the ship via id.
     */

    public String getShipViaId() {
        return shipViaId;
    }

    /**
     * Set the ship via id.
     *
     * @param shipViaId ID of the ship via.
     */

    public void setShipViaId(String shipViaId) {
        this.shipViaId = shipViaId;
    }

    /**
     * Get the attention.
     *
     * @return Returns the attention.
     */

    public String getAttention() {
        return attention;
    }

    /**
     * Set the attention.
     *
     * @param attention Attention for the order.
     */

    public void setAttention(String attention) {
        this.attention = attention;
    }

    /**
     * Get the delivery org address id.
     *
     * @return Returns the delivery org address id.
     */

    public String getDeliveryOrgAddressId() {
        return deliveryOrgAddressId;
    }

    /**
     * Set the delivery org address id.
     *
     * @param deliveryOrgAddressId ID of the delivery org address.
     */

    public void setDeliveryOrgAddressId(String deliveryOrgAddressId) {
        this.deliveryOrgAddressId = deliveryOrgAddressId;
    }

    /**
     * Get the delivery customer id.
     *
     * @return Returns the delivery customer id.
     */

    public String getDeliveryCustomerId() {
        return deliveryCustomerId;
    }

    /**
     * Set the delivery customer id.
     *
     * @param deliveryCustomerId ID of the delivery customer.
     */

    public void setDeliveryCustomerId(String deliveryCustomerId) {
        this.deliveryCustomerId = deliveryCustomerId;
    }

    /**
     * Get the attachment name.
     *
     * @return Returns the attachment name.
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
     * Get the order can send in mail or not.
     *
     * @return Returns true if the order can send in mail else returns false.
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
     * Get the order can mark as bill or not.
     *
     * @return Returns true if the order can mark as bill else returns false.
     */

    public boolean canMarkAsBill() {
        return canMarkAsBill;
    }

    /**
     * Set the order can mark as bill or not.
     *
     * @param canMarkAsBill True or flase to set the order can mark as bill or not.
     */

    public void setCanMarkAsBill(boolean canMarkAsBill) {
        this.canMarkAsBill = canMarkAsBill;
    }

    /**
     * Get the order can mark as unbill or not.
     *
     * @return Returns true if the order can mark as unbill else returns false.
     */

    public boolean canMarkAsUnbill() {
        return canMarkAsUnbill;
    }

    /**
     * Set the order can mark as unbill or not.
     *
     * @param canMarkAsUnbill True or false to set the order can mark as bill or not.
     */

    public void setCanMarkAsUnbill(boolean canMarkAsUnbill) {
        this.canMarkAsUnbill = canMarkAsUnbill;
    }

    /**
     * Get the contact persons.
     *
     * @return Retruns array of contact persons.
     */

    public String[] getContactPersons() {
        return contactPersons;
    }

    /**
     * Set the list of contact persons.
     *
     * @param contactPersons Array of contact persons.
     */

    public void setContactPersons(String[] contactPersons) {
        this.contactPersons = contactPersons;
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
     * Set the line items.
     *
     * @param lineItems List of LineItem object.
     */

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Get the taxes.
     *
     * @return Returns List of Tax object.
     */

    public List<Tax> getTaxes() {
        return taxes;
    }

    /**
     * Set the taxes.
     *
     * @param taxes List of Tax object.
     */

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    /**
     * Get the billing address.
     *
     * @return Returns the billing address.
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
     * Get the delivery address.
     *
     * @return Returns the delivery address.
     */

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Set the delivery address.
     *
     * @param deliveryAddress Address object.
     */

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Get the list of custom fields.
     *
     * @return Returns List of CustomField object.
     */

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    /**
     * Set the custom fields.
     *
     * @param customFields List of CustomField object.
     */

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }


    /**
     * Convert the PurchaseOrder object into JSONObject.
     *
     * @return Returns the JSONObject.
     * @throws Exception
     */

    public JSONObject toJSON() throws Exception {

        JSONObject jsonObject = new JSONObject();

        if (vendorId != null && !vendorId.equals("")) {
            jsonObject.put("vendor_id", vendorId);
        }
        if (purchaseorderNumber != null) {
            jsonObject.put("purchaseorder_number", purchaseorderNumber);
        }
        if (referenceNumber != null) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if (templateId != null) {
            jsonObject.put("template_id", templateId);
        }
        if (date != null) {
            jsonObject.put("date", date);
        }
        if (deliveryDate != null) {
            jsonObject.put("due_date", deliveryDate);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (notes != null) {
            jsonObject.put("notes", notes);
        }
        if (shipVia != null) {
            jsonObject.put("ship_via", shipVia);
        }
        if (attention != null) {
            jsonObject.put("attention", attention);
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

        if (deliveryAddress != null) {
            jsonObject.put("delivery_address", deliveryAddress.toJSON());
        }

        return jsonObject;
    }

}
