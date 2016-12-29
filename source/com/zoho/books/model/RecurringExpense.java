/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for recurring expense.
 */

public class RecurringExpense {
    private String recurringExpenseId = "";
    private String recurrenceName = "";
    private String startDate = "";
    private String endDate = "";
    private String recurrenceFrequency = "";
    private int repeatEvery = 0;
    private String lastCreatedDate = "";
    private String nextExpenseDate = "";
    private String accountId = "";
    private String accountName = "";
    private String paidThroughAccountId = "";
    private String paidThroughAccountName = "";
    private String vendorId = "";
    private String vendorName = "";
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
    private String description = "";
    private boolean isBillable = false;
    private String customerId = "";
    private String customerName = "";
    private String createdTime = "";
    private String lastModifiedTime = "";
    private String status = "";
    private String projectId = "";
    private String projectName = "";


    /**
     * set the recurring expense id.
     *
     * @param recurringExpenseId ID of the recurring expense.
     */

    public void setRecurringExpenseId(String recurringExpenseId) {
        this.recurringExpenseId = recurringExpenseId;
    }

    /**
     * get the recurring expense id.
     *
     * @return Returns the ID of the recurring expense.
     */

    public String getRecurringExpenseId() {
        return recurringExpenseId;
    }

    /**
     * set the recurrence name.
     *
     * @param recurrenceName Name of the recurring expense.
     */

    public void setRecurrenceName(String recurrenceName) {
        this.recurrenceName = recurrenceName;
    }

    /**
     * get the recurrence name.
     *
     * @return Returns the name of the recurring expense.
     */

    public String getRecurrenceName() {
        return recurrenceName;
    }

    /**
     * set the start date.
     *
     * @param startDate Start date of the recurring expense. Expenses will not be generated for dates prior to the current date.
     */

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * get the start date.
     *
     * @return Returns the start date of the recurring expense.
     */

    public String getStartDate() {
        return startDate;
    }

    /**
     * set the end date.
     *
     * @param endDate Date on which recurring expense has to expire. Can be left as empty to run forever.
     */

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * get the end date.
     *
     * @return Returns the date on which recurring expense has to expire.
     */

    public String getEndDate() {
        return endDate;
    }

    /**
     * set the recurrence frequency.
     *
     * @param recurrenceFrequency Frequency of the recurring expense. E.g. weekly, monthly, yearly.
     */

    public void setRecurrenceFrequency(String recurrenceFrequency) {
        this.recurrenceFrequency = recurrenceFrequency;
    }

    /**
     * get the recurrence frequency.
     *
     * @return Returns the frequency of the recurring expense.
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
     * @return Returns the frequency to repeat.
     */

    public int getRepeatEvery() {
        return repeatEvery;
    }

    /**
     * set the last created date.
     *
     * @param lastCreatedDate Last created date of the recurring expense.
     */

    public void setLastCreatedDate(String lastCreatedDate) {
        this.lastCreatedDate = lastCreatedDate;
    }

    /**
     * get the last created date.
     *
     * @return Returns the last created date of the recurring expense.
     */

    public String getLastCreatedDate() {
        return lastCreatedDate;
    }

    /**
     * set the next expense date.
     *
     * @param nextExpenseDate Next expense date of the recurring expense.
     */

    public void setNextExpenseDate(String nextExpenseDate) {
        this.nextExpenseDate = nextExpenseDate;
    }

    /**
     * get the next expense date.
     *
     * @return Returns the next expense date of the recurring expense.
     */

    public String getNextExpenseDate() {
        return nextExpenseDate;
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
     * @return Returns the ID of the expense account.
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
     * @return Returns the ID of the cash/ bank account the expense is paid.
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
     * @return Returns the ID of the vendor the expense is made.
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
     * set the tax id.
     *
     * @param taxId ID of the tax or tax group applied to the recurring expense.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * get the tax id.
     *
     * @return Returns the ID of the tax or tax group applied to the recurring expense.
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * set the tax name.
     *
     * @param taxName Name of the tax or tax group applied to the recurring expense.
     */

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * get the tax name.
     *
     * @return Returns the name of the tax or tax group applied to the recurring expense.
     */

    public String getTaxName() {
        return taxName;
    }

    /**
     * set the tax percentage.
     *
     * @param taxPercentage Percentage of the tax or tax group applied to the recurring expense.
     */

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * get the tax percentage.
     *
     * @return Returns the percentage of the tax or tax group applied to the recurring expense.
     */

    public double getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the project associated with the expense.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the ID of the project associated with the expense.
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
     * set the exchnage rate.
     *
     * @param exchangeRate Exchange rate of the currency specified.
     */

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * get the exchnage rate.
     *
     * @return Returns the exchange rate of the currency specified.
     */

    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * set the tax amount.
     *
     * @param taxAmount Amount of the tax or tax group applied to the recurring expense.
     */

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * get the tax amount.
     *
     * @return Returns the amount of the tax or tax group applied to the recurring expense.
     */

    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * set the sub total.
     *
     * @param subTotal Sub total of the recurring expense.
     */

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get the sub total.
     *
     * @return Returns the sub total of the recurring expense.
     */

    public double getSubTotal() {
        return subTotal;
    }

    /**
     * set the total.
     *
     * @param total Total of the recurring expense.
     */

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get the total.
     *
     * @return Returns the total of the recurring expense.
     */

    public double getTotal() {
        return total;
    }

    /**
     * set the bcy total.
     *
     * @param bcyTotal Bcy total of the recurring expense.
     */

    public void setBcyTotal(double bcyTotal) {
        this.bcyTotal = bcyTotal;
    }

    /**
     * get the bcy total.
     *
     * @return Returns the bcy total of the recurring expense.
     */

    public double getBcyTotal() {
        return bcyTotal;
    }

    /**
     * set the amount.
     *
     * @param amount Recurring expense amount.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the recurring expense amount.
     */

    public double getAmount() {
        return amount;
    }

    /**
     * set is inclusive tax.
     *
     * @param isInclusiveTax Boolean to specify if the tax is inclusive of the expense amount.
     */

    public void setIsInclusiveTax(boolean isInclusiveTax) {
        this.isInclusiveTax = isInclusiveTax;
    }

    /**
     * get is inclusive tax.
     *
     * @return Returns true if the recurring expense amount is inclusive of tax else returns false.
     */

    public boolean isInclusiveTax() {
        return isInclusiveTax;
    }

    /**
     * set the description.
     *
     * @param description Description of the recurring expense.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the recurring expense.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set is billable.
     *
     * @param isBillable Boolean to specify if the expense is billable.
     */

    public void setIsBillable(boolean isBillable) {
        this.isBillable = isBillable;
    }

    /**
     * get is billable.
     *
     * @return Returns true if the expense is billable else returns false.
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
     * @return Returns the ID of the customer, if the expense is billable.
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
     * @return Returns the name of the customer, if the expense is billable.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time of the recurring expense.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the recurring expense.
     */

    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * set the last modified time.
     *
     * @param lastModifiedTime Last modified time of the recurring expense.
     */

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * get the last modified time.
     *
     * @return Returns the last modified time of the recurring expense.
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * set the status.
     *
     * @param status Status of the recurring expense.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the recurring expense.
     */

    public String getStatus() {
        return status;
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
     * @return Returns the ID of the project associated with the customer.
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
     * Convert RecurringExpense object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("account_id", accountId);
        jsonObject.put("paid_through_account_id", paidThroughAccountId);
        jsonObject.put("recurrence_name", recurrenceName);
        jsonObject.put("start_date", startDate);
        jsonObject.put("end_date", endDate);
        jsonObject.put("recurrence_frequency", recurrenceFrequency);
        jsonObject.put("repeat_every", repeatEvery);
        jsonObject.put("amount", amount);
        jsonObject.put("tax_id", taxId);
        jsonObject.put("is_inclusive_tax", isInclusiveTax);
        jsonObject.put("is_billable", isBillable);
        jsonObject.put("description", description);
        jsonObject.put("customer_id", customerId);
        jsonObject.put("vendor_id", vendorId);
        jsonObject.put("project_id", projectId);
        jsonObject.put("currency_id", currencyId);
        jsonObject.put("exchange_rate", exchangeRate);

        return jsonObject;
    }


}
