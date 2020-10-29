/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.BankRuleParser;

import com.zoho.books.model.Rule;
import com.zoho.books.model.RuleList;

import java.util.HashMap;


/**

* BankRulesApi is used to create the bank rules and applied to the bank accounts.

* It is used to get:<br><br>

	The list of all bank rules.<br>
	
	The details of a bank rule.<br><br>
	
* It is used to update the details of a bank rule.<br>

* It is used to delete the bank rule.


*/

public class BankRulesApi extends API
{
	
	private static String url = baseURL+"/bankaccounts/rules"; //No I18N
	
	
	/**
	
	* Construct a new BankRulesApi using user's accessToken and organizationid.
	
	* @param accessToken user's accessToken.
	
	* @param organizationId user's organization id.
	
	*/
	
	public BankRulesApi(String accessToken, String organizationId)
	{
		
		super(accessToken, organizationId);
		
	}
	
	private BankRuleParser bankRuleParser = new BankRuleParser();
	
	
	/**
	
	* Fetch all the rules created for a specified bank or credit card account ID.
	
	* Pass the accountId to get all the rules for the account.
	
	* It returns the RuleList object.
	
	
	* @param accountId Mandatory parameter Account Id for which rules have to be listed.
	
	* @return Returns the RuleList object.
	
	*/
	
	
	public RuleList getRules(String accountId)throws Exception
	{
		HashMap<String, Object> queryMap = getQueryMap();
		
		if(accountId != null)
		{
			queryMap.put("account_id", accountId);
		} 
		
		String response = ZohoHTTPClient.get(url, queryMap, accessToken);
		
		RuleList ruleList = bankRuleParser.getRules(response); 
		
		return ruleList;
	}
	
	/**
	
	* Get details of a specific rule.
	
	* Pass the ruleId to get the details of a rule.
	
	* It returns the Rule object.
	
	
	* @param ruleId ID of the rule created.
	
	* @return Returns the Rule object.
	
	*/
	
	public Rule get(String ruleId)throws Exception
	{
		String urlString = url+"/"+ruleId;
	
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		Rule rule = bankRuleParser.getRule(response); 
		
		return rule;
	}
	
	/**
	
	* Create a rule and apply it on deposit/withdrawal for bank accounts and on refund/charges for credit card accounts.
	
	* Pass the Rule object to create a rule for the bank account.
	
	* The Rule object which contains ruleName, targetAccountId, applyTo, criteriaType, field, comparator, and recordAs are the mandatory parameters.
	
	* It returns the Rule object.
	
	
	* @param rule Rule object.
	
	* @return Returns the Rule object.
	
	*/
	
	public Rule create(Rule rule)throws Exception
	{
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", rule.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody, accessToken);
		
		return bankRuleParser.getRule(response);
	}
	
	/**
	
	* Make changes to the rule; add or modify it, and update.
	
	* Pass the Rule object to update the details of a rule.
	
	* The Rule object which contains ruleId is the mandatory parameter for which rule has to be updated.
	
	* It returns the Rule object.
	
	
	* @param rule Rule object.
	
	* @return Returns the Rule object.
	
	*/
	
	public Rule update(Rule rule)throws Exception
	{
		String urlString = url+"/"+rule.getRuleId();
	
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", rule.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return bankRuleParser.getRule(response);
	}
	
	/**
	
	* Delete a rule from your account, and make it no longer applicable on the transactions.
	
	* Pass the ruleId to delete the rule for the bank account.
	
	* If the rule has been deleted it returns the success message.
	
	* The success message is "The rule has been deleted."
	
	
	* @param ruleId ID of the rule created.
	
	* @return Returns a String object.
	
	*/
	
	public String delete(String ruleId)throws Exception
	{
		String urlString = url+"/"+ruleId;
	
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String message = bankRuleParser.getMessage(response); 
		
		return message;
	}
}
