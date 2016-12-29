/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.Criterion;
import com.zoho.books.model.Rule;
import com.zoho.books.model.RuleList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * BankRuleParser is used to parse the json response and make it into the respective objects.
 */

public class BankRuleParser {
    /**
     * Parse the json response and returns the RuleList object.
     *
     * @param response This json response contains list of rules details.
     * @return Returns the RuleList object.
     */

    public RuleList getRules(String response) throws Exception {

        RuleList ruleList = new RuleList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("rules"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Rule rule = new Rule();

            rule.setRuleId(jsonArray.getJSONObject(i).getString("rule_id"));
            rule.setRuleName(jsonArray.getJSONObject(i).getString("rule_name"));
            rule.setRuleOrder(jsonArray.getJSONObject(i).getInt("rule_order")); //No I18N
            rule.setApplyTo(jsonArray.getJSONObject(i).getString("apply_to"));
            rule.setCriteriaType(jsonArray.getJSONObject(i).getString("criteria_type"));
            rule.setRecordAs(jsonArray.getJSONObject(i).getString("record_as"));
            rule.setAccountId(jsonArray.getJSONObject(i).getString("account_id"));
            rule.setAccountName(jsonArray.getJSONObject(i).getString("account_name"));

            List<Criterion> criterion = new ArrayList<Criterion>();

            JSONArray criterionList = jsonArray.getJSONObject(i).getJSONArray("criterion"); //No I18N

            for (int j = 0; j < criterionList.length(); j++) {
                Criterion criteria = new Criterion();

                criteria.setCriteriaId(criterionList.getJSONObject(j).getString("criteria_id"));
                criteria.setField(criterionList.getJSONObject(j).getString("field"));
                criteria.setComparator(criterionList.getJSONObject(j).getString("comparator"));
                criteria.setValue(criterionList.getJSONObject(j).getString("value"));

                criterion.add(j, criteria);
            }

            rule.setCriterion(criterion);

            ruleList.add(rule);
        }

        return ruleList;
    }

    /**
     * Parse the json response and returns the Rule object.
     *
     * @param response This json response contains the rule details.
     * @return Returns the Rule object.
     */

    public Rule getRule(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject rules = jsonObject.getJSONObject("rule"); //No I18N

        Rule rule = new Rule();

        rule.setRuleId(rules.getString("rule_id"));
        rule.setRuleName(rules.getString("rule_name"));
        rule.setRuleOrder(rules.getInt("rule_order")); //No I18N
        rule.setApplyTo(rules.getString("apply_to"));
        rule.setCriteriaType(rules.getString("criteria_type"));
        rule.setRecordAs(rules.getString("record_as"));
        rule.setAccountId(rules.getString("account_id"));
        rule.setAccountName(rules.getString("account_name"));
        rule.setTaxId(rules.getString("tax_id"));
        rule.setCustomerId(rules.getString("customer_id"));
        rule.setCustomerName(rules.getString("customer_name"));
        rule.setReferenceNumber(rules.getString("reference_number"));

        List<Criterion> criterion = new ArrayList<Criterion>();

        JSONArray jsonArray = rules.getJSONArray("criterion"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Criterion criteria = new Criterion();

            criteria.setCriteriaId(jsonArray.getJSONObject(i).getString("criteria_id"));
            criteria.setField(jsonArray.getJSONObject(i).getString("field"));
            criteria.setComparator(jsonArray.getJSONObject(i).getString("comparator"));
            criteria.setValue(jsonArray.getJSONObject(i).getString("value"));

            criterion.add(i, criteria);
        }

        rule.setCriterion(criterion);

        return rule;
    }

    /**
     * Parse the json response and returns a string object.
     *
     * @param response This json response contains the success message of post or update or delete requests.
     * @return Returns the success message.
     */

    public String getMessage(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        String success = jsonObject.getString("message");

        return success;
    }
}
