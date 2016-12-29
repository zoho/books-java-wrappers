/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for expense.
 */

public class Expense {
    private String expenseId = "";
    private String expenseItemId = "";
    private String accountId = "";
    private String accountName = "";
    private String paidThroughAccountId = "";
    private String paidThroughAccountName = "";
    private String vendorId = "";
    private String vendorName = "";
    private String date = "";
    private String taxId = "";
    private String taxName = "";
    private double taxPercentage = 0.00;
    private String currencyId = "";
    private String currencyCode = "";
    private double exchangeRate = 0.00;
    private double taxAmount = 0.00;
    private double subTotal = 0.00;
    private double total = 0.00;
    private double bcyTotal = 0.00;
    private double amount = 0.00;
    private boolean isInclusiveTax = false;
    private String referenceNumber = "";
    private String description = "";
    private boolean isBillable = false;
    private String customerId = "";
    private String customerName = "";
    private String expenseReceiptName = "";
    private String createdTime = "";
    private String lastModifiedTime = "";
    private String status = "";
    private String invoiceId = "";
    private String invoiceNumber = "";
    private String projectId = "";
    private String projectName = "";


    /**
     * set the expense id.
     *
     * @param expenseId ID of the expense.
     */

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    /**
     * get the expense id.
     *
     * @return Returns the expense id.
     */

    public String getExpenseId() {
        return expenseId;
    }

    /**
     * set the expense item id.
     *
     * @param expenseItemId ID of the expense item.
     */

    public void setExpenseItemId(String expenseItemId) {
        this.expenseItemId = expenseItemId;
    }

    /**
     * get the expense item id.
     *
     * @return Returns the expense item id.
     */

    public String getExpenseItemId() {
        return expenseItemId;
    }

    /**
     * set the account id.
     *
     * @param accountId ID of the expense account.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * get the account id.
     *
     * @return Returns the id of the expense account.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * set the account name.
     *
     * @param accountName Name of the expense account.
     */

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * get the account name.
     *
     * @return Returns the name of the expense account.
     */

    public String getAccountName() {
        return accountName;
    }

    /**
     * set the paid through account id.
     *
     * @param paidThroughAccountId ID of the cash/ bank account the expense is paid.
     */

    public void setPaidThroughAccountId(String paidThroughAccountId) {
        this.paidThroughAccountId = paidThroughAccountId;
    }

    /**
     * get the paid through account id.
     *
     * @return Returns the id of the cash/ bank account the expense is paid.
     */

    public String getPaidThroughAccountId() {
        return paidThroughAccountId;
    }

    /**
     * set the paid through account name.
     *
     * @param paidThroughAccountName Name of the cash/ bank account the expense is paid.
     */

    public void setPaidThroughAccountName(String paidThroughAccountName) {
        this.paidThroughAccountName = paidThroughAccountName;
    }

    /**
     * get the paid through account name.
     *
     * @return Returns the name of the cash/ bank account the expense is paid.
     */

    public String getPaidThroughAccountName() {
        return paidThroughAccountName;
    }

    /**
     * set the vendor id.
     *
     * @param vendorId ID of the vendor the expense is made.
     */

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * get the vendor id.
     *
     * @return Returns the id of the vendor the expense is made.
     */

    public String getVendorId() {
        return vendorId;
    }

    /**
     * set the vendor name.
     *
     * @param vendorName Name of the vendor the expense is made.
     */

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * get the vendor name.
     *
     * @return Returns the name of the vendor the expense is made.
     */

    public String getVendorName() {
        return vendorName;
    }

    /**
     * set the date.
     *
     * @param date Date the expense is created.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date the expense is created.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the tax id.
     *
     * @param taxId ID of the tax or tax group applied to the expense.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * get the tax id.
     *
     * @return Returns the id of the tax or tax group applied to the expense.
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * set the tax name.
     *
     * @param taxName Name of the tax or tax group applied to the expense.
     */

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * get the tax name.
     *
     * @return Returns the name of the tax or tax group applied to the expense.
     */

    public String getTaxName() {
        return taxName;
    }

    /**
     * set the tax percentage.
     *
     * @param taxPercentage Percentage of the tax or tax group applied to the expense.
     */

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * get the tax percentage.
     *
     * @return Returns the percentage of the tax or tax group applied to the expense.
     */

    public double getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency in which expense amount is specified.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the id of the currency in which expense amount is specified.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the currency code.
     *
     * @param currencyCode Code of the currency in which expense amount is specified.
     */

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * get the currency code.
     *
     * @return Returns the code of the currency in which expense amount is specified.
     */

    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * set the exchange rate.
     *
     * @param exchangeRate Exchange rate of the currency specified.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchange rate.
     *
     * @return Returns the exchange rate of the currency specified.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * set the tax amount.
     *
     * @param taxAmount Amount of the tax or tax group applied to the expense.
     */

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * get the tax amount.
     *
     * @return Returns the amount of the tax or tax group applied to the expense.
     */

    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * set the sub total.
     *
     * @param subTotal Sub total of the expense.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the expense.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set the total.
     *
     * @param total Total of the expense.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the expense.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the bcy total.
     *
     * @param bcyTotal Bcy total of the expense.
     */

    public void setBcyTotal(double bcyTotal) {
        this.bcyTotal = bcyTotal;
    }

    /**
     * get the bcy total.
     *
     * @return Returns the bcy total of the expense.
     */

    public double getBcyTotal() {
        return bcyTotal;
    }

    /**
     * set the amount.
     *
     * @param amount Expense amount.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the expense amount.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * set is inclusive tax.
     *
     * @param isInclusiveTax To specify if the tax is inclusive of the expense amount.
     */

    public void setIsInclusiveTax(boolean isInclusiveTax) {
        this.isInclusiveTax = isInclusiveTax;
    }

    /**
     * get is inclusive tax.
     *
     * @return Returns true if the expense inclusive the tax else return false.
     */

    public boolean isInclusiveTax() {
        return isInclusiveTax;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Reference number of the expense.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number of the expense.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the description.
     *
     * @param description Description of the expense.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the expense.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set is billable.
     *
     * @param isBillable To specify if the expense is billable.
     */

    public void setIsBillable(boolean isBillable) {
        this.isBillable = isBillable;
    }

    /**
     * get is billable.
     *
     * @return Returns true if the expense is billable else return false.
     */

    public boolean isBillable() {
        return isBillable;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer, if the expense is billable.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the id of the customer.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the customer name.
     *
     * @param customerName Name of the customer, if the expense is billable.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the name of the customer.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the expense receipt name.
     *
     * @param expenseReceiptName Name of the expense receipt.
     */

    public void setExpenseReceiptName(String expenseReceiptName) {
        this.expenseReceiptName = expenseReceiptName;
    }

    /**
     * get the expense receipt name.
     *
     * @return Returns the name of the expense receipt.
     */

    public String getExpenseReceiptName() {
        return expenseReceiptName;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time of the expense.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the expense.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time of the expense.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time of the expense.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * set the status.
     *
     * @param status Status of the expense.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the expense.
     */

    public String getStatus() {
        return status;
    }

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
     * @return Returns the id of the invoice.
     */

    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * set the invoice number.
     *
     * @param invoiceNumber Number of the invoice.
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
     * set the project id.
     *
     * @param projectId ID of the project associated with the customer.
     */

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * get the project id.
     *
     * @return Returns the id of the project associated with the customer.
     */

    public String getProjectId() {
        return projectId;
    }

    /**
     * set the project name.
     *
     * @param projectName Name of the project associated with the customer.
     */

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * get the project name.
     *
     * @return Returns the name of the project associated with the customer.
     */

    public String getProjectName() {
        return projectName;
    }


    /**
     * Convert Expense object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (accountId != null && !accountId.equals("")) {
            jsonObject.put("account_id", accountId);
        }
        if (paidThroughAccountId != null && !paidThroughAccountId.equals("")) {
            jsonObject.put("paid_through_account_id", paidThroughAccountId);
        }
        if (date != null && !date.equals("")) {
            jsonObject.put("date", date);
        }
        if ((Double) amount != null) {
            jsonObject.put("amount", amount);
        }
        if (taxId != null && !taxId.equals("")) {
            jsonObject.put("tax_id", taxId);
        }
        if ((Boolean) isInclusiveTax != null) {
            jsonObject.put("is_inclusive_tax", isInclusiveTax);
        }
        if ((Boolean) isBillable != null) {
            jsonObject.put("is_billable", isBillable);
        }
        if (referenceNumber != null && !referenceNumber.equals("")) {
            jsonObject.put("reference_number", referenceNumber);
        }
        if (description != null && !description.equals("")) {
            jsonObject.put("description", description);
        }
        if (customerId != null && !customerId.equals("")) {
            jsonObject.put("customer_id", customerId);
        }
        if (vendorId != null && !vendorId.equals("")) {
            jsonObject.put("vendor_id", vendorId);
        }
        if (currencyId != null && !currencyId.equals("")) {
            jsonObject.put("currency_id", currencyId);
        }
        if ((Double) exchangeRate != null && exchangeRate > 0) {
            jsonObject.put("exchange_rate", exchangeRate);
        }
        if (projectId != null && !projectId.equals("")) {
            jsonObject.put("project_id", projectId);
        }

        return jsonObject;
    }


}
