/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.BankRulesApi;
import com.zoho.books.api.BankAccountsApi;

import com.zoho.books.model.BankAccount;
import com.zoho.books.model.Rule;
import com.zoho.books.model.Criterion;
import com.zoho.books.model.BankAccountList;
import com.zoho.books.model.RuleList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BankRuleTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
		
		BankRulesApi bankRuleApi = service.getBankRulesApi();
		
		BankAccountsApi bankAccountApi = service.getBankAccountsApi();
		
		try
		{
			BankAccountList getBankaccounts = bankAccountApi.getBankaccounts(null);
		
			String accountId = getBankaccounts.get(0).getAccountId();
		
			RuleList getRules = bankRuleApi.getRules(accountId);
		
			String ruleId = getRules.get(0).getRuleId();
		
			Rule rule = new Rule();
		
			rule.setRuleName("Minimum Deposit Rule");	//No I18N
			rule.setTargetAccountId(getRules.get(0).getTargetAccountId());
			rule.setApplyTo("deposits");		//No I18N
			rule.setCriteriaType("and");		//No I18N
		
			List<Criterion> criterion = new ArrayList<Criterion>();
		
			Criterion criteria = new Criterion();
		
			criteria.setField("amount");		//No I18N
			criteria.setComparator("greater_than");	//No I18N
			criteria.setValue("500.00");
		
			criterion.add(0, criteria);
		
			rule.setCriterion(criterion);
		
			rule.setRecordAs("deposit");			//No I18N
			rule.setAccountId("36991000000029003");
			rule.setReferenceNumber("from_statement");	//No I18N
			rule.setCustomerId("36991000000041005");
				
			Rule create = bankRuleApi.create(rule);
			
			Rule get = bankRuleApi.get(ruleId);
			
			get.setRuleName("Minimum Deposit");	//No I18N
		
			Rule update = bankRuleApi.update(get);
		
			String delete = bankRuleApi.delete(ruleId);
		
			//System.out.println(update);
			
		}
		catch(BooksException be)
		{
			
			throw be;
		}
		catch(Exception e)
		{
		
			throw e;
		}
	}	
}
