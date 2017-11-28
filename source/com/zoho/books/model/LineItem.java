/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class is used to make an object for line item.
 */

public class LineItem {
    private String taxName = "";
    private String taxType = "";
    private String expenseId = "";
    private String expenseItemId = "";
    private String lineItemId = "";
    private double discount = 0.00;
    private String expenseReceiptName = "";
    private String unit = "";
    private int itemOrder = 0;
    private double rate = 0.00;
    private double bcyRate = 0.00;
    private String itemId = "";
    private String timeEntryIds = "";
    private String description = "";
    private String projectId = "";
    private String name = "";
    private String taxId = "";
    private double quantity = 0.00;
    private double taxPercentage = 0.00;
    private double itemTotal = 0.00;

    private String accountId = "";
    private String accountName = "";

    private String lineId = "";
    private String debitOrCredit = "";
    private double amount = 0.00;


    private double discountAmount;

    private String taxExemptionId;
    private String salesorderItemId;
    private String stockOnHand;
    private boolean isInvoiced;

    /**
     * set the tax name.
     *
     * @param taxName Name of the tax or tax group applied to the line item.
     */

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * get the tax name.
     *
     * @return Returns the name of the tax or tax group applied to the line item.
     */

    public String getTaxName() {
        return taxName;
    }

    /**
     * set the tax type.
     *
     * @param taxType Type of the tax or tax group applied to the line item.
     */

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    /**
     * get the tax type.
     *
     * @return Returns the type of the tax or tax group applied to the line item.
     */

    public String getTaxType() {
        return taxType;
    }

    /**
     * set the expense id.
     *
     * @param expenseId ID of the expense which is invoiced.
     */

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    /**
     * get the expense id.
     *
     * @return Returns the id of the expense which is invoiced.
     */

    public String getExpenseId() {
        return expenseId;
    }

    /**
     * set the expense item id.
     *
     * @param expenseItemId ID of the expense item which is invoiced.
     */

    public void setExpenseItemId(String expenseItemId) {
        this.expenseItemId = expenseItemId;
    }

    /**
     * get the expense item id.
     *
     * @return Returns the id of the expense item which is invoiced.
     */

    public String getExpenseItemId() {
        return expenseItemId;
    }

    /**
     * set the line item id.
     *
     * @param lineItemId ID of the line item.
     */

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    /**
     * get the line item id.
     *
     * @return Returns the id of the line item.
     */

    public String getLineItemId() {
        return lineItemId;
    }

    /**
     * set the discount.
     *
     * @param discount Discount applied to the line item. It can be either in % or in amount. e.g. 12.5% or 190.
     */

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * get the discount.
     *
     * @return Returns the discount applied to the line item.
     */

    public double getDiscount() {
        return discount;
    }

    /**
     * set the expense receipt name.
     *
     * @param expenseReceiptName Expense receipt name for the line item.
     */

    public void setExpenseReceiptName(String expenseReceiptName) {
        this.expenseReceiptName = expenseReceiptName;
    }

    /**
     * get the expense receipt name.
     *
     * @return Returns the expense receipt name for the line item.
     */

    public String getExpenseReceiptName() {
        return expenseReceiptName;
    }

    /**
     * set the unit.
     *
     * @param unit Unit of the line item e.g. kgs, Nos.
     */

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * get the unit.
     *
     * @return Returns the unit of the line item.
     */

    public String getUnit() {
        return unit;
    }

    /**
     * set the item order.
     *
     * @param itemOrder Order of the line item.
     */

    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
    }

    /**
     * get the item order.
     *
     * @return Returns the order of the line item.
     */

    public int getItemOrder() {
        return itemOrder;
    }

    /**
     * set the rate.
     *
     * @param rate Rate of the line item.
     */

    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * get the rate.
     *
     * @return Returns the rate of the line item.
     */

    public double getRate() {
        return rate;
    }

    /**
     * set the bcy rate.
     *
     * @param bcyRate Bcy rate of the line item.
     */

    public void setBcyRate(double bcyRate) {
        this.bcyRate = bcyRate;
    }

    /**
     * get the bcy rate.
     *
     * @return Returns the bcy rate of the line item.
     */

    public double getBcyRate() {
        return bcyRate;
    }

    /**
     * set the item id.
     *
     * @param itemId ID of the item.
     */

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * get the item id.
     *
     * @return Returns the id of the item.
     */

    public String getItemId() {
        return itemId;
    }

    /**
     * set the time entry ids.
     *
     * @param timeEntryIds IDs of the time entries associated with the project.
     */

    public void setTimeEntryIds(String timeEntryIds) {
        this.timeEntryIds = timeEntryIds;
    }

    /**
     * get the time entry ids.
     *
     * @return Returns the IDs of the time entries associated with the project.
     */

    public String getTimeEntryIds() {
        return timeEntryIds;
    }

    /**
     * set the description.
     *
     * @param description Description of the line item.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the line item.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the project id.
     *
     * @param projectId ID of the project.
     */

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * get the project id.
     *
     * @return Returns the ID of the project.
     */

    public String getProjectId() {
        return projectId;
    }

    /**
     * set the name.
     *
     * @param name Name of the line item.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name.
     *
     * @return Returns the name of the line item.
     */

    public String getName() {
        return name;
    }

    /**
     * set the tax id.
     *
     * @param taxId ID of the tax or tax group applied to the line item.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * get the tax id.
     *
     * @return Returns the id of the tax or tax group applied to the line item.
     */

    public String getTaxId() {
        return taxId;
    }

    /**
     * set the quantity.
     *
     * @param quantity Quantity of the line item.
     */

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * get the quantity.
     *
     * @return Returns the quantity of the line item.
     */

    public double getQuantity() {
        return quantity;
    }

    /**
     * set the tax percentage.
     *
     * @param taxPercentage Percentage of the tax or tax group applied to the line item.
     */

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * get the tax percentage.
     *
     * @return Returns the percentage of the tax or tax group applied to the line item.
     */

    public double getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * set the item total.
     *
     * @param itemTotal Total of the line item.
     */

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    /**
     * get the item total.
     *
     * @return Returns the total of the line item.
     */

    public double getItemTotal() {
        return itemTotal;
    }


    /**
     * set the account id.
     *
     * @param accountId ID of the account associated with the line item.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * get the account id.
     *
     * @return Returns the ID of the account associated with the line item.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * set the account name.
     *
     * @param accountName Name of the account associated with the line item.
     */

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * get the account name.
     *
     * @return Returns the Name of the account associated with the line item.
     */

    public String getAccountName() {
        return accountName;
    }


    /**
     * set the line id.
     *
     * @param lineId ID of the line item.
     */

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    /**
     * get the line id.
     *
     * @return Returns the ID of the line item.
     */

    public String getLineId() {
        return lineId;
    }

    /**
     * set the debit or credit.
     *
     * @param debitOrCredit Whether the accounts needs to be debited or credited.
     */

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    /**
     * get the debit or credit.
     *
     * @return Returns the accounts needs to be debited or credited.
     */

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    /**
     * set the amount.
     *
     * @param amount Amount to be recorded for the journal.
     */

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get the amount.
     *
     * @return Returns the Amount to be recorded for the journal.
     */

    public double getAmount() {
        return amount;
    }


    /**
     * Get the discount amount.
     *
     * @return Returns the discount amount.
     */

    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Set the discount amount.
     *
     * @param discountAmount Discount amount of the item.
     */

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }


    /**
     * Get the tax exemption id(US Edition only).
     *
     * @return Returns the tax exemption id.
     */

    public String getTaxExemptionId() {
        return taxExemptionId;
    }

    /**
     * Set the tax exemption id(US Edition only).
     *
     * @param taxExemptionId Tax exemption id for US Edition.
     */

    public void setTaxExemptionId(String taxExemptionId) {
        this.taxExemptionId = taxExemptionId;
    }

    /**
     * Get the sales order item id.
     *
     * @return Returns the sales order item id.
     */

    public String getSalesorderItemId() {
        return salesorderItemId;
    }

    /**
     * Set the sales order item id.
     *
     * @param salesorderItemId ID of the sales order item.
     */

    public void setSalesorderItemId(String salesorderItemId) {
        this.salesorderItemId = salesorderItemId;
    }

    /**
     * Get the stack on hand.
     *
     * @return Returns the stack on hand.
     */

    public String getStockOnHand() {
        return stockOnHand;
    }

    /**
     * Set the stack on hand.
     *
     * @param stockOnHand Stack on hand.
     */

    public void setStockOnHand(String stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

    /**
     * Get the item is invoiced or not.
     *
     * @return Returns true if the item is invoiced else returns false.
     */

    public boolean isInvoiced() {
        return isInvoiced;
    }

    /**
     * Set the item is invoiced or not.
     *
     * @param isInvoiced True or flase to set the item is invoiced or not.
     */

    public void setInvoiced(boolean isInvoiced) {
        this.isInvoiced = isInvoiced;
    }

    /**
     * Convert Item object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (itemId != null && !itemId.equals("")) {
            jsonObject.put("item_id", itemId);
        }

        if (lineItemId != null && !lineItemId.equals("")) {
            jsonObject.put("line_item_id", lineItemId);
        }

        if (accountId != null && !accountId.equals("")) {
            jsonObject.put("account_id", accountId);
        }

        if (projectId != null && !projectId.equals("")) {
            jsonObject.put("project_id", projectId);
        }

        if (expenseId != null && !expenseId.equals("")) {
            jsonObject.put("expense_id", expenseId);
        }

        if (name != null && !name.equals("")) {
            jsonObject.put("name", name);
        }

        if (description != null && !description.equals("")) {
            jsonObject.put("description", description);
        }

        if ((Integer) itemOrder != null) {
            jsonObject.put("item_order", itemOrder);
        }

        if ((Double) rate != null) {
            jsonObject.put("rate", rate);
        }

        if (unit != null && !unit.equals("")) {
            jsonObject.put("unit", unit);
        }

        if ((Double) quantity != null) {
            jsonObject.put("quantity", quantity);
        }

        if ((Double) discount != null) {
            jsonObject.put("discount", discount);
        }

        if (taxId != null) {
            jsonObject.put("tax_id", taxId);
        }
        if (timeEntryIds != null) {
        	String[] splitted = timeEntryIds.split(",");
            JSONArray timeEntryIdsArray = new JSONArray();
            for (int j = 0; j < splitted.length; j++) {
            	timeEntryIdsArray.put(splitted[j]);
            }
            jsonObject.put("time_entry_ids", timeEntryIdsArray);
        }


        if (debitOrCredit != null && !debitOrCredit.equals("")) {
            jsonObject.put("debit_or_credit", debitOrCredit);
        }

        if (taxExemptionId != null && !taxExemptionId.equals("")) {
            jsonObject.put("tax_exemption_id", taxExemptionId);
        }

        return jsonObject;
    }

}
