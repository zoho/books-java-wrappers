/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for invoice.
 */

public class Invoice {

    private String invoiceId = "";
    private String customerName = "";
    private String customerId = "";
    private String status = "";
    private String invoiceNumber = "";
    private String referenceNumber = "";
    private String date = "";
    private String dueDate = "";
    private String dueDays = "";
    private String currencyId = "";
    private String currencyCode = "";
    private double total = 0.00;
    private double balance = 0.00;
    private boolean isEmailed = false;
    private int remindersSent = 0;
    private String paymentExpectedDate = "";
    private String lastPaymentDate = "";


    private int paymentTerms = 0;
    private String paymentTermsLabel = "";
    private String terms = "";
    private String unbilledExpensesCount = "";
    private String templateId = "";
    private String discountType = null;
    private double shippingCharge = 0.00;
    private boolean isDiscountBeforeTax = true;
    private boolean allowPartialPayments = true;
    private String recurringInvoiceId = "";
    private String discount = null;
    private double taxTotal = 0.00;
    private String templateName = "";
    private String attachmentName = "";
    private String lastReminderSentDate = "";
    private int pricePrecision = 0;
    private String adjustmentDescription = "";
    private String salespersonName = "";
    private double adjustment = 0.00;
    private String expectedPaymentDate = "";
    private double writeOffAmount = 0.00;
    private String salespersonId = "";
    private double exchangeRate = 0.00;
    private double subTotal = 0.00;
    private boolean paymentReminderEnabled = true;
    private boolean canSendInMail = true;
    private String lastModifiedTime = "";
    private String notes = "";
    private String createdTime = "";
    private double paymentMade = 0.00;
    private double creditsApplied = 0.00;
    private double taxAmountWithheld = 0.00;

    private double amountApplied = 0.00;


    private String invoicePaymentId = "";

    private String name = "";
    private String value = "";

    private String[] contactPersons = {};

    private List<LineItem> lineItems = new ArrayList<LineItem>();

    private List<Tax> taxes = new ArrayList<Tax>();

    private Address billingAddress = new Address();

    private Address shippingAddress = new Address();

    private List<PaymentGateway> paymentGateways = new ArrayList<PaymentGateway>();

    private List<CustomField> customFields = new ArrayList<CustomField>();


    private boolean isViewedByClient;
    private String clientViewedTime;
    private boolean stopReminderUntilPaymentExpectedDate;
    private String templateType;
    private boolean isAutobillEnabled;
    private String invoiceUrl;

    private String taxId;
    private String taxAuthorityId;
    private String taxExemptionId;


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
     * set the customer name.
     *
     * @param customerName Name of the customer the invoice has to be created.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the Name of the customer the invoice has to be created.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer the invoice has to be created.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the id of the customer the invoice has to be created.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the status.
     *
     * @param status Status of the invoice.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the invoice.
     */

    public String getStatus() {
        return this.status;
    }

    /**
     * set the invoice number.
     *
     * @param invoiceNumber Mandatory if auto number generation is disabled.
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
     * set the reference number.
     *
     * @param referenceNumber Reference number of the invoice.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number of the invoice.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the date.
     *
     * @param date The date the invoice is created.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date the invoice is created.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the due date.
     *
     * @param dueDate Date invoice is due.
     */

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * get the due date.
     *
     * @return Returns the date the invoice is due.
     */

    public String getDueDate() {
        return dueDate;
    }

    /**
     * set the due days.
     *
     * @param dueDays Due days of the invoice.
     */

    public void setDueDays(String dueDays) {
        this.dueDays = dueDays;
    }

    /**
     * get the due days.
     *
     * @return Returns the due days of the invoice.
     */

    public String getDueDays() {
        return dueDays;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency associated with the invoice.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the id of the currency associated with the invoice.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the currency code.
     *
     * @param currencyCode Standard code to identify the currency.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the code of the currency.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the total.
     *
     * @param total Total of the invoice.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the invoice.
     */

    public double getTotal() {
        return this.total;
    }

    /**
     * set the balance.
     *
     * @param balance Balance of the invoice.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * get the balance.
     *
     * @return Returns the balance of the invoice.
     */

    public double getBalance() {
        return this.balance;
    }

    /**
     * set is emailed.
     *
     * @param isEmailed To specify the invoice is emailed or not.
     */

    public void setIsEmailed(boolean isEmailed) {
        this.isEmailed = isEmailed;
    }

    /**
     * get is emailed.
     *
     * @return Returns true if the invoice is emailed else return false.
     */

    public boolean isEmailed() {
        return isEmailed;
    }

    /**
     * set the reminders sent.
     *
     * @param remindersSent Number of invoices sent to the customer.
     */

    public void setRemindersSent(int remindersSent) {
        this.remindersSent = remindersSent;
    }

    /**
     * get the reminders sent.
     *
     * @return Returns the number of invoices sent to the customer.
     */

    public int getRemindersSent() {
        return remindersSent;
    }

    /**
     * set the payment expected date.
     *
     * @param paymentExpectedDate Payment expected date for the invoice.
     */

    public void setPaymentExpectedDate(String paymentExpectedDate) {
        this.paymentExpectedDate = paymentExpectedDate;
    }

    /**
     * get the payment expected date.
     *
     * @return Returns the payment expected date of the invoice.
     */

    public String getPaymentExpectedDate() {
        return paymentExpectedDate;
    }

    /**
     * set the last payment date.
     *
     * @param lastPaymentDate Last payment date for the invoice.
     */

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    /**
     * get the last payment date.
     *
     * @return Returns the last payment date of the invoice.
     */

    public String getLastPaymentDate() {
        return lastPaymentDate;
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
     * @return Returns the Payment terms in days.
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
     * set the unbilled expense count.
     *
     * @param unbilledExpensesCount Unbilled expense count for the invoice.
     */

    public void setUnbilledExpensesCount(String unbilledExpensesCount) {
        this.unbilledExpensesCount = unbilledExpensesCount;
    }

    /**
     * get the unbilled expense count.
     *
     * @return Returns the unbilled expense count for the invoice.
     */

    public String getUnbilledExpensesCount() {
        return unbilledExpensesCount;
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
     * @return Returns the id of the pdf template associated with the invoice.
     */

    public String getTemplateId() {
        return templateId;
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
     * @return Returns the discount type specified with the invoice.
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
     * @return Returns true if the invoice allow partial payments else returns false.
     */

    public boolean allowPartialPayments() {
        return allowPartialPayments;
    }

    /**
     * set the recurring invoice id.
     *
     * @param recurringInvoiceId ID of the recurring invoice from which the invoice is created.
     */

    public void setRecurringInvoiceId(String recurringInvoiceId) {
        this.recurringInvoiceId = recurringInvoiceId;
    }

    /**
     * get the recurring invoice id.
     *
     * @return Returns the id of the recurring invoice from which the invoice is created.
     */

    public String getRecurringInvoiceId() {
        return recurringInvoiceId;
    }

    /**
     * set the discount.
     *
     * @param discount Discount applied to the invoice. It can be either in % or in amount. e.g. 12.5% or 190.
     */

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * get the discount.
     *
     * @return Returns the discount applied to the invoice.
     */

    public String getDiscount() {
        return discount;
    }

    /**
     * set the tax total.
     *
     * @param taxTotal Total of the tax or tax group applied to the line item.
     */

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * get the tax total.
     *
     * @return Returns the total of the tax or tax group applied to the line item.
     */

    public double getTaxTotal() {
        return taxTotal;
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
     * set the attachment name.
     *
     * @param attachmentName Name of the attached file associated with the invoice.
     */

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * get the attachment name.
     *
     * @return Returns the name of the attached file associated with the invoice.
     */

    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * set the last reminder sent date.
     *
     * @param lastReminderSentDate Last reminder sent date for the invoice.
     */

    public void setLastReminderSentDate(String lastReminderSentDate) {
        this.lastReminderSentDate = lastReminderSentDate;
    }

    /**
     * get the last reminder sent date.
     *
     * @return Returns the last reminder sent date for the invoice.
     */

    public String getLastReminderSentDate() {
        return lastReminderSentDate;
    }

    /**
     * set the price precision.
     *
     * @param pricePrecision Price Precision of the invoice.
     */

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    /**
     * get the price precision.
     *
     * @return Returns the price precision of the invoice.
     */

    public int getPricePrecision() {
        return pricePrecision;
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
     * @return Returns the customize the adjustment description.
     */

    public String getAdjustmentDescription() {
        return adjustmentDescription;
    }

    /**
     * set the salesperson name.
     *
     * @param salespersonName Name of the sales person.
     */

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    /**
     * get the salesperson name.
     *
     * @return Returns the name of the sales person.
     */

    public String getSalespersonName() {
        return salespersonName;
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
     * @return Returns the adjustment made to the invoice.
     */

    public double getAdjustment() {
        return adjustment;
    }

    /**
     * set the expected payment date.
     *
     * @param expectedPaymentDate Expected payment date for the invoice.
     */

    public void setExpectedPaymentDate(String expectedPaymentDate) {
        this.expectedPaymentDate = expectedPaymentDate;
    }

    /**
     * get the expected payment date.
     *
     * @return Returns the expected payment date for the invoice.
     */

    public String getExpectedPaymentDate() {
        return expectedPaymentDate;
    }

    /**
     * set the write off amount.
     *
     * @param writeOffAmount Write off amount for the invoice.
     */

    public void setWriteOffAmount(double writeOffAmount) {
        this.writeOffAmount = writeOffAmount;
    }

    /**
     * get the write off amount.
     *
     * @return Returns the write off amount for the invoice.
     */

    public double getWriteOffAmount() {
        return writeOffAmount;
    }

    /**
     * set the salesperson id.
     *
     * @param salespersonId ID of the sales person.
     */

    public void setSalespersonId(String salespersonId) {
        this.salespersonId = salespersonId;
    }

    /**
     * get the salesperson id.
     *
     * @return Returns the id of the sales person.
     */

    public String getSalespersonId() {
        return salespersonId;
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
     * set the sub total.
     *
     * @param subTotal Sub total of the invoice.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the invoice.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set payment reminder enabled.
     *
     * @param paymentReminderEnabled To specify the payment reminder is enabled or disabled.
     */

    public void setPaymentReminderEnabled(boolean paymentReminderEnabled) {
        this.paymentReminderEnabled = paymentReminderEnabled;
    }

    /**
     * get payment reminder enabled.
     *
     * @return Returns true if the payment reminder is enabled for the invoice else return false.
     */

    public boolean isPaymentReminderEnabled() {
        return paymentReminderEnabled;
    }

    /**
     * set can send in mail.
     *
     * @param canSendInMail To specify the email is sent to the invoice or not.
     */

    public void setCanSendInMail(boolean canSendInMail) {
        this.canSendInMail = canSendInMail;
    }

    /**
     * get can send in mail.
     *
     * @return Returns true if the email has been sent for the invoice else return false.
     */

    public boolean canSendInMail() {
        return canSendInMail;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time for the invoice.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time for the invoice.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
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
     * set the created time.
     *
     * @param createdTime Created time for the invoice.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the invoice.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * set the payment made.
     *
     * @param paymentMade Payment made for the invoice.
     */

    public void setPaymentMade(double paymentMade) {
        this.paymentMade = paymentMade;
    }

    /**
     * get the payment made.
     *
     * @return Returns the payment made for the invoice.
     */

    public double getPaymentMade() {
        return paymentMade;
    }

    /**
     * set the credits applied.
     *
     * @param creditsApplied Credits applied to the invoice.
     */

    public void setCreditsApplied(double creditsApplied) {
        this.creditsApplied = creditsApplied;
    }

    /**
     * get the credits applied.
     *
     * @return Returns the credits applied to the invoice.
     */

    public double getCreditsApplied() {
        return creditsApplied;
    }

    /**
     * set the tax amount withheld.
     *
     * @param taxAmountWithheld Tax amount withheld for the invoice.
     */

    public void setTaxAmountWithheld(double taxAmountWithheld) {
        this.taxAmountWithheld = taxAmountWithheld;
    }

    /**
     * get the tax amount withheld.
     *
     * @return Returns the tax amount withheld for the invoice.
     */

    public double getTaxAmountWithheld() {
        return taxAmountWithheld;
    }

    /**
     * set the amount applied.
     *
     * @param amountApplied Amount applied for the invoice.
     */

    public void setAmountApplied(double amountApplied) {
        this.amountApplied = amountApplied;
    }

    /**
     * get the amount applied.
     *
     * @return Returns the amount applied for the invoice.
     */

    public double getAmountApplied() {
        return amountApplied;
    }


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
     * set the name.
     *
     * @param name Default name of the invoice.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name.
     *
     * @return Returns the default name of the invoice.
     */

    public String getName() {
        return name;
    }

    /**
     * set the value.
     *
     * @param value Default value of the invoice.
     */

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * get the value.
     *
     * @return Returns the default value of the invoice.
     */

    public String getValue() {
        return value;
    }


    /**
     * set the contact persons.
     *
     * @param contactPersons Array of contact person(s) for whom invoice has to be sent.
     */

    public void setContactPersons(String[] contactPersons) {
        this.contactPersons = contactPersons;
    }

    /**
     * get the contact persons.
     *
     * @return Returns the  array of contact person(s) for whom invoice has to be sent.
     */

    public String[] getContactPersons() {
        return contactPersons;
    }


    /**
     * set the line items.
     *
     * @param lineItems Line items of an invoice.
     */

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * get the line items.
     *
     * @return Returns list of LineItem object.
     */

    public List<LineItem> getLineItems() {
        return this.lineItems;
    }


    /**
     * set the taxes.
     *
     * @param taxes Taxes of an invoice.
     */

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    /**
     * get the Taxes.
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

    public void setBillingAddress(Address billingAddress) {
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

    public void setShippingAddress(Address shippingAddress) {
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
     * @param paymentGateways Online payment gateways through which payment can be made.
     */

    public void setPaymentGateways(List<PaymentGateway> paymentGateways) {
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
     * set the custom fields.
     *
     * @param customFields Custom fields for an invoice.
     */

    public void setCustomFields(List<CustomField> customFields) {
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
     * Get the invoice is viewed by client or not.
     *
     * @return Returns true if the invoice is viewed by client else returns false.
     */

    public boolean isViewedByClient() {
        return isViewedByClient;
    }

    /**
     * Set the invoice is viewed by client or not.
     *
     * @param isViewedByClient True or false to set the invoice is viewed by client or not.
     */

    public void setViewedByClient(boolean isViewedByClient) {
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
     * @param clientViewedTime Client viewed time for the invoice.
     */

    public void setClientViewedTime(String clientViewedTime) {
        this.clientViewedTime = clientViewedTime;
    }

    /**
     * Get the invoice is stop reminder until payment expected date.
     *
     * @return Returns true if the invoice is stop reminder until payment expected date else returns false.
     */

    public boolean isStopReminderUntilPaymentExpectedDate() {
        return stopReminderUntilPaymentExpectedDate;
    }

    /**
     * Set the invoice is stop reminder until payment expected date or not.
     *
     * @param stopReminderUntilPaymentExpectedDate True or false to set the invoice is stop reminder until payment expected date or not.
     */

    public void setStopReminderUntilPaymentExpectedDate(boolean stopReminderUntilPaymentExpectedDate) {
        this.stopReminderUntilPaymentExpectedDate = stopReminderUntilPaymentExpectedDate;
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
     * Get the invoice is auto bill enabled or not.
     *
     * @return Returns true if the invoice is auto bill enabled else returns false.
     */

    public boolean isAutobillEnabled() {
        return isAutobillEnabled;
    }

    /**
     * Set the invoice is auto bill enabled or not.
     *
     * @param isAutobillEnabled True or false to set the invoice is auto bill enabled or not.
     */

    public void setAutobillEnabled(boolean isAutobillEnabled) {
        this.isAutobillEnabled = isAutobillEnabled;
    }

    /**
     * Get the invoice URL.
     *
     * @return Returns the invoice URL.
     */

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    /**
     * Set the invoice URL.
     *
     * @param invoiceUrl URL for the invoice.
     */

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
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
     * Convert Invoice object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (invoiceNumber != null && !invoiceNumber.equals("")) {
            jsonObject.put("invoice_number", invoiceNumber);
        }
        if (referenceNumber != null && !referenceNumber.equals("")) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if ((Integer) paymentTerms != null) {
            jsonObject.put("payment_terms", paymentTerms);
        }
        if (paymentTermsLabel != null && !paymentTermsLabel.equals("")) {
            jsonObject.put("payment_terms_label", paymentTermsLabel);
        }

        if (paymentGateways != null) {

            JSONObject paymentOption = new JSONObject();

            JSONArray paymentGateway = new JSONArray();
            for (int i = 0; i < paymentGateways.size(); i++) {
                paymentGateway.put(paymentGateways.get(i).toJSON());
            }
            paymentOption.put("payment_gateways", paymentGateway);
            jsonObject.put("payment_options", paymentOption);
        }

        if (customerId != null && !customerId.equals("")) {
            jsonObject.put("customer_id", customerId);
        }

        if (contactPersons != null) {
            JSONArray contactPerson = new JSONArray();
            for (int j = 0; j < contactPersons.length; j++) {
                contactPerson.put(contactPersons[j]);
            }
            jsonObject.put("contact_persons", contactPerson);
        }

        if (date != null && !date.equals("")) {
            jsonObject.put("date", date);
        }
        if (dueDate != null && !dueDate.equals("")) {
            jsonObject.put("due_date", dueDate);
        }
        if (notes != null && !notes.equals("")) {
            jsonObject.put("notes", notes);
        }
        if (terms != null && !terms.equals("")) {
            jsonObject.put("terms", terms);
        }

        if (lineItems != null) {
            JSONArray lineItem = new JSONArray();
            for (int k = 0; k < lineItems.size(); k++) {
                lineItem.put(lineItems.get(k).toJSON());
            }
            jsonObject.put("line_items", lineItem);
        }

        if (customFields != null) {
            JSONArray customField = new JSONArray();
            for (int l = 0; l < customFields.size(); l++) {
                customField.put(customFields.get(l).toJSON());
            }
            jsonObject.put("custom_fields", customField);
        }

        if ((Boolean) allowPartialPayments != null) {
            jsonObject.put("allow_partial_payments", allowPartialPayments);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (templateId != null && !templateId.equals("")) {
            jsonObject.put("template_id", templateId);
        }
        if ((Boolean) isDiscountBeforeTax != null) {
            jsonObject.put("is_discount_before_tax", isDiscountBeforeTax);
        }
        if (discount != null && !discount.equals("")) {
            jsonObject.put("discount", discount + "%");
        }
        if (discountType != null && !discountType.equals("")) {
            jsonObject.put("discount_type", discountType);
        }
        if ((Double) shippingCharge != null) {
            jsonObject.put("shipping_charge", shippingCharge);
        }
        if ((Double) adjustment != null) {
            jsonObject.put("adjustment", adjustment);
        }
        if (adjustmentDescription != null && !adjustmentDescription.equals("")) {
            jsonObject.put("adjustment_description", adjustmentDescription);
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
