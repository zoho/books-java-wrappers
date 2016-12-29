/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create an object for recurring invoice.
 */

public class RecurringInvoice {


    private String recurringInvoiceId = "";
    private String recurrenceName = "";
    private String status = "";
    private double subTotal = 0.00;
    private double total = 0.00;
    private String customerId = "";
    private String customerName = "";
    private String startDate = "";
    private String endDate = "";
    private String lastSentDate = "";
    private String nextInvoiceDate = "";
    private String recurrenceFrequency = "";
    private int repeatEvery = 0;
    private String createdTime = "";


    private int paymentTerms = 0;
    private String paymentTermsLabel = "";
    private String currencyId = "";
    private String currencyCode = "";
    private double exchangeRate = 0.00;
    private double discount = 0.00;
    private boolean isDiscountBeforeTax = true;
    private String discountType = "";


    private double shippingCharge = 0.00;
    private double adjustment = 0.00;
    private String adjustmentDescription = "";
    private double taxTotal = 0.00;
    private double balance = 0.00;
    private boolean allowPartialPayments = false;
    private double creditsApplied = 0.00;

    private String templateId = "";
    private String templateName = "";
    private String notes = "";
    private String terms = "";
    private String salespersonId = "";
    private String salespersonName = "";

    private String[] contactPersons = {};

    private List<LineItem> lineItems = new ArrayList<LineItem>();

    private List<Tax> taxes = new ArrayList<Tax>();

    private Address billingAddress = new Address();

    private Address shippingAddress = new Address();

    private List<PaymentGateway> paymentGateways = new ArrayList<PaymentGateway>();


    /**
     * set the recurring invoice id.
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     */

    public void setRecurringInvoiceId(String recurringInvoiceId) {
        this.recurringInvoiceId = recurringInvoiceId;
    }

    /**
     * get the recurring invoice id.
     *
     * @return Returns the ID of the recurring invoice.
     */

    public String getRecurringInvoiceId() {
        return recurringInvoiceId;
    }

    /**
     * set the recurrence name.
     *
     * @param recurrenceName Name of the recurring invoice.
     */

    public void setRecurrenceName(String recurrenceName) {
        this.recurrenceName = recurrenceName;
    }

    /**
     * get the recurrence name.
     *
     * @return Returns the name of the recurring invoice.
     */

    public String getRecurrenceName() {
        return recurrenceName;
    }

    /**
     * set the status.
     *
     * @param status Status of the recurring invoice.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the recurring invoice.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set the sub total.
     *
     * @param subTotal Sub total of the recurring invoice.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the recurring invoice.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set the total.
     *
     * @param total Total of the recurring invoice.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the recurring invoice.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer the recurring invoice has to be created.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the ID of the customer the recurring invoice has to be created.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the customer name.
     *
     * @param customerName Name of the customer the recurring invoice has to be created.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the name of the customer the recurring invoice has to be created.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the start date.
     *
     * @param startDate Start date of the recurring invoice. Invoices will not be generated for dates prior to the current date.
     */

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * get the start date.
     *
     * @return Returns the start date of the recurring invoice.
     */

    public String getStartDate() {
        return startDate;
    }

    /**
     * set the end date.
     *
     * @param endDate Date on which recurring invoice has to expire. Can be left as empty to run forever.
     */

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * get the end date.
     *
     * @return Returns the date on which recurring invoice has to expire.
     */

    public String getEndDate() {
        return endDate;
    }

    /**
     * set the last sent date.
     *
     * @param lastSentDate Last sent date of the recurring invoice.
     */

    public void setLastSentDate(String lastSentDate) {
        this.lastSentDate = lastSentDate;
    }

    /**
     * get the last sent date.
     *
     * @return Returns the last sent date of the recurring invoice.
     */

    public String getLastSentDate() {
        return lastSentDate;
    }

    /**
     * set the next invoice date.
     *
     * @param nextInvoiceDate Next sent date of the recurring invoice.
     */

    public void setNextInvoiceDate(String nextInvoiceDate) {
        this.nextInvoiceDate = nextInvoiceDate;
    }

    /**
     * get the next invoice date.
     *
     * @return Returns the next sent date of the recurring invoice.
     */

    public String getNextInvoiceDate() {
        return nextInvoiceDate;
    }

    /**
     * set the recurrence frequency.
     *
     * @param recurrenceFrequency Frequency of the recurring invoice. E.g. weekly, monthly, yearly.
     */

    public void setRecurrenceFrequency(String recurrenceFrequency) {
        this.recurrenceFrequency = recurrenceFrequency;
    }

    /**
     * get the recurrence frequency.
     *
     * @return Returns the frequency of the recurring invoice.
     */

    public String getRecurrenceFrequency() {
        return recurrenceFrequency;
    }

    /**
     * set the repeat every.
     *
     * @param repeatEvery Frequency to repeat. E.g. 1, 6, 12.
     */

    public void setRepeatEvery(int repeatEvery) {
        this.repeatEvery = repeatEvery;
    }

    /**
     * get the repeat every.
     *
     * @return Returns the frequency to repeat of the recurring invoice.
     */

    public int getRepeatEvery() {
        return repeatEvery;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time for the recurring invoice.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the recurring invoice.
     */

    public String getCreatedTime() {
        return createdTime;
    }


    /**
     * set the payment terms.
     *
     * @param paymentTerms Payment terms in days e.g. 15, 30, 60. Invoice due date will be calculated based on this.
     */

    public void setPaymentTerms(int paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    /**
     * get the payment terms.
     *
     * @return Returns the payment terms in days.
     */

    public int getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * set the payment terms label.
     *
     * @param paymentTermsLabel Used to override the default payment terms label. Default value for 15 days is "Net 15 Days".
     */

    public void setPaymentTermsLabel(String paymentTermsLabel) {
        this.paymentTermsLabel = paymentTermsLabel;
    }

    /**
     * get the payment terms label.
     *
     * @return Returns the default payment terms label.
     */

    public String getPaymentTermsLabel() {
        return paymentTermsLabel;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the ID of the currency.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the currency code.
     *
     * @param currencyCode Standard code of the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the standard code of the currency.
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
     * @return Returns the discount applied to the invoice.
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
     * @return Returns true if the discount applied to the invoice else returns false.
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
     * @return Returns the discount type of the recurring invoice.
     */

    public String getDiscountType() {
        return discountType;
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
     * @return Returns the adjustment description to the invoice.
     */

    public String getAdjustmentDescription() {
        return adjustmentDescription;
    }

    /**
     * set the tax total.
     *
     * @param taxTotal Tax total of the recurring invoice.
     */

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * get the tax total.
     *
     * @return Returns the tax total of the recurring invoice.
     */

    public double getTaxTotal() {
        return taxTotal;
    }

    /**
     * set the balance.
     *
     * @param balance Total balance of the recurring invoice.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get the balance.
     *
     * @return Returns the total balance of the recurring invoice.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * set allow partial payments.
     *
     * @param allowPartialPayments Can the payment be made partially for this invoice.
     */

    public void setAllowPartialPayments(boolean allowPartialPayments) {
        this.allowPartialPayments = allowPartialPayments;
    }

    /**
     * get allow partial payments.
     *
     * @return Returns true if the invoice allowed for partial payments else returns false.
     */

    public boolean isAllowPartialPayments() {
        return allowPartialPayments;
    }

    /**
     * set the credits applied.
     *
     * @param creditsApplied Credits applied for the invoice.
     */

    public void setCreditsApplied(double creditsApplied) {
        this.creditsApplied = creditsApplied;
    }

    /**
     * get the credits applied.
     *
     * @return Returns the credits applied for the invoice.
     */

    public double getCreditsApplied() {
        return creditsApplied;
    }


    /**
     * set the template id.
     *
     * @param templateId ID of the pdf template associated with the invoice.
     */

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * get the template id.
     *
     * @return Returns the ID of the pdf template associated with the invoice.
     */

    public String getTemplateId() {
        return templateId;
    }

    /**
     * set the template name.
     *
     * @param templateName Name of the pdf template associated with the invoice.
     */

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * get the template name.
     *
     * @return Returns the name of the pdf template associated with the invoice.
     */

    public String getTemplateName() {
        return templateName;
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
     * @return Returns the ID of the salesperson.
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
     * @return Returns the name of the salesperson.
     */

    public String getSalespersonName() {
        return salespersonName;
    }


    /**
     * set the contact persons.
     *
     * @param contactPersons Array of contact person(s) for whom invoice has to be sent.
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
     * @param lineItems Line items of an invoice.
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
     * @param taxes Taxes of an invoice.
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
     * @param billingAddress Billing address of an invoice.
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
     * @param shippingAddress Shipping address of an invoice.
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
     * set the payment gateways.
     *
     * @param paymentGateways Payment gateways of an invoice.
     */

    public void setPaymentGateways(List<PaymentGateway> paymentGateways) throws Exception {
        this.paymentGateways = paymentGateways;
    }

    /**
     * get the payment gateways.
     *
     * @return Returns list of PaymentGateway object.
     */

    public List<PaymentGateway> getPaymentGateways() {
        return paymentGateways;
    }


    /**
     * Convert RecurringInvoice object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("customer_id", customerId);

        if (contactPersons != null) {
            JSONArray contactPerson = new JSONArray();

            for (int i = 0; i < contactPersons.length; i++) {
                contactPerson.put(contactPersons[i]);
            }
            jsonObject.put("contact_persons", contactPerson);
        }

        jsonObject.put("recurrence_name", recurrenceName);

        if (paymentGateways != null && !paymentGateways.isEmpty()) {
            JSONObject paymentOption = new JSONObject();
            JSONArray paymentGateway = new JSONArray();
            for (int i = 0; i < paymentGateways.size(); i++) {
                paymentGateway.put(paymentGateways.get(i).toJSON());
            }
            paymentOption.put("payment_gateways", paymentGateway);
            jsonObject.put("payment_options", paymentOption);
        }

        jsonObject.put("payment_terms", paymentTerms);
        jsonObject.put("payment_terms_label", paymentTermsLabel);

        if (lineItems != null && !lineItems.isEmpty()) {
            JSONArray lineItem = new JSONArray();

            for (int i = 0; i < lineItems.size(); i++) {
                lineItem.put(lineItems.get(i).toJSON());
            }
            jsonObject.put("line_items", lineItem);
        }

        jsonObject.put("repeat_every", repeatEvery);
        jsonObject.put("recurrence_frequency", recurrenceFrequency);
        jsonObject.put("start_date", startDate);
        jsonObject.put("end_date", endDate);
        jsonObject.put("notes", notes);
        jsonObject.put("exchange_rate", exchangeRate);
        jsonObject.put("is_discount_before_tax", isDiscountBeforeTax);
        jsonObject.put("discount", discount);
        jsonObject.put("discount_type", discountType);
        jsonObject.put("allow_partial_payments", allowPartialPayments);
        jsonObject.put("salesperson_name", salespersonName);
        jsonObject.put("shipping_charge", shippingCharge);
        jsonObject.put("adjustment", adjustment);
        jsonObject.put("adjustment_description", adjustmentDescription);

        return jsonObject;
    }

}
