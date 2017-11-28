/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for rule.
 */

public class Rule {
    private String ruleId = "";
    private String ruleName = "";
    private int ruleOrder = 0;
    private String applyTo = "";
    private String criteriaType = "";
    private String recordAs = "";
    private String accountId = "";
    private String accountName = "";

    private String taxId = "";
    private String customerId = "";
    private String customerName = "";
    private String referenceNumber = "";
    private String targetAccountId = "";


    private List<Criterion> criterion = new ArrayList<Criterion>();


    /**
     * set the rule id.
     *
     * @param ruleId ID of the rule.
     */

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * get the rule id.
     *
     * @return Returns the ID of the rule.
     */

    public String getRuleId() {
        return ruleId;
    }

    /**
     * get the rule id.
     *
     * @return Returns the ID of the rule.
     */

    public String getId() {
        return ruleId;
    }

    /**
     * set the rule name.
     *
     * @param ruleName Name of the rule.
     */

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * get the rule name.
     *
     * @return Returns the name of the rule.
     */

    public String getRuleName() {
        return ruleName;
    }

    /**
     * get the rule name.
     *
     * @return Returns the name of the rule.
     */

    public String getName() {
        return ruleName;
    }

    /**
     * set the rule order.
     *
     * @param ruleOrder Order of the rule.
     */

    public void setRuleOrder(int ruleOrder) {
        this.ruleOrder = ruleOrder;
    }

    /**
     * get the rule order.
     *
     * @return Returns the order of the rule.
     */

    public int getRuleOrder() {
        return ruleOrder;
    }

    /**
     * get the rule order.
     *
     * @return Returns the order of the rule.
     */

    public int getOrder() {
        return ruleOrder;
    }

    /**
     * set the apply rules.
     *
     * @param applyTo Rule applies to either deposits or withdrawals for bank accounts and to refunds or charges for credit card account.
     */

    public void setApplyTo(String applyTo) {
        this.applyTo = applyTo;
    }

    /**
     * get the apply rules.
     *
     * @return Returns the applied rules.
     */

    public String getApplyTo() {
        return applyTo;
    }

    /**
     * set the criteria type.
     *
     * @param criteriaType Specifies whether all the criteria have to be satisfied or not.
     */

    public void setCriteriaType(String criteriaType) {
        this.criteriaType = criteriaType;
    }

    /**
     * get the criteria type.
     *
     * @return Returns the criteria type.
     */

    public String getCriteriaType() {
        return criteriaType;
    }

    /**
     * set the record.
     *
     * @param recordAs Record transaction based on value specified in apply_to node.
     */

    public void setRecordAs(String recordAs) {
        this.recordAs = recordAs;
    }

    /**
     * get the record.
     *
     * @return Returns the record.
     */

    public String getRecordAs() {
        return recordAs;
    }

    /**
     * set the account id.
     *
     * @param accountId Account which is involved in the rule with the target account.
     */

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * get the account id.
     *
     * @return Returns the account id.
     */

    public String getAccountId() {
        return accountId;
    }

    /**
     * set the account name.
     *
     * @param accountName Account which is involved in the rule with the target account.
     */

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * get the account name.
     *
     * @return Returns the account name.
     */

    public String getAccountName() {
        return accountName;
    }


    /**
     * set the tax id.
     *
     * @param taxId ID of the tax.
     */

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * get the tax id.
     *
     * @return Returns the ID of the tax.
     */

    public String getTaxId() {
        return taxId;
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
     * @return Returns the ID of the customer.
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
     * @return Returns the name of the customer.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the reference number.
     *
     * @param referenceNumber Specifies if Reference number is manual or generated from the statement.
     */

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * get the reference number.
     *
     * @return Returns the reference number.
     */

    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * set the target account id.
     *
     * @param targetAccountId The account on which the rule has to be applied.
     */

    public void setTargetAccountId(String targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    /**
     * get the target account id.
     *
     * @return Returns the target account id.
     */

    public String getTargetAccountId() {
        return targetAccountId;
    }


    /**
     * set the criterion.
     *
     * @param criterion list of Criterion object.
     */

    public void setCriterion(List<Criterion> criterion) {
        this.criterion = criterion;
    }

    /**
     * get the criterion.
     *
     * @return Returns list of Criterion object.
     */

    public List<Criterion> getCriterion() {
        return criterion;
    }


    /**
     * Convert Rule object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("rule_name", ruleName);
        jsonObject.put("target_account_id", targetAccountId);
        jsonObject.put("apply_to", applyTo);
        jsonObject.put("criteria_type", criteriaType);
        jsonObject.put("record_as", recordAs);
        jsonObject.put("account_id", accountId);
        jsonObject.put("reference_number", referenceNumber);
        jsonObject.put("customer_id", customerId);

        if (criterion != null) {
            JSONArray criteria = new JSONArray();

            for (int i = 0; i < criterion.size(); i++) {
                criteria.put(criterion.get(i).toJSON());
            }

            jsonObject.put("criterion", criteria);
        }

        return jsonObject;
    }
}
