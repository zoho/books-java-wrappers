/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.ChartOfAccountsApi;

import com.zoho.books.model.ChartOfAccount;
import com.zoho.books.model.ChartOfAccountList;
import com.zoho.books.model.TransactionList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ChartOfAccountsApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{auth_token}", "{organization_id}");	//No I18N
	
		ChartOfAccountsApi chartOfAccountsApi = service.getChartOfAccountsApi();	
		
		String accountName = "Bank Account";	//No I18N
		
		String accountType = "cash";	//No I18N
		
		String description = "create a new Account";	//No I18N
		
		String accountId = "36991000000027003";
		
		String transactionId = "36991000000031091";
		
		
		
		ChartOfAccount chartOfAccount = new ChartOfAccount();
		
		chartOfAccount.setAccountId(accountId);
		chartOfAccount.setAccountName(accountName);
		chartOfAccount.setAccountType(accountType);
		chartOfAccount.setDescription(description);
		
		
		HashMap hashMap = new HashMap();
		
		hashMap.put("filter_by", "TransactionType.All");
		hashMap.put("sort_column", "transaction_date");
		
		try
		{
		
			ChartOfAccount create = chartOfAccountsApi.create(chartOfAccount);
		
			ChartOfAccount get = chartOfAccountsApi.get(accountId);
		
			ChartOfAccount update = chartOfAccountsApi.update(chartOfAccount);
		
			String markAsInactive = chartOfAccountsApi.markAsInactive(accountId);
		
			String markAsActive = chartOfAccountsApi.markAsActive(accountId);
		
			ChartOfAccountList getChartOfAccounts = chartOfAccountsApi.getChartOfAccounts(hashMap);
		
			TransactionList getTransactions = chartOfAccountsApi.getTransactions(accountId, hashMap);
			
			String deleteTransaction = chartOfAccountsApi.deleteTransaction(transactionId);
			
			String delete = chartOfAccountsApi.delete(accountId);
			
		
			//System.out.println(getTransactions.get(0));
			
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

