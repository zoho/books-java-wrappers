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
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		ChartOfAccountsApi chartOfAccountsApi = service.getChartOfAccountsApi();	
		
		String accountName = "Bank Account";	//No I18N
		
		String accountType = "cash";	//No I18N
		
		String description = "create a new Account";	//No I18N
		
		
		
		HashMap hashMap = new HashMap();
		
		hashMap.put("filter_by", "TransactionType.All"); 
		hashMap.put("sort_column", "transaction_date");
		
		try
		{
		
			ChartOfAccountList getChartOfAccounts = chartOfAccountsApi.getChartOfAccounts(hashMap);
			
			String accountId = getChartOfAccounts.get(0).getAccountId();
			
			
			ChartOfAccount chartOfAccount = new ChartOfAccount();
			
			chartOfAccount.setAccountId(accountId);
			chartOfAccount.setAccountName(accountName);
			chartOfAccount.setAccountType(accountType);
			chartOfAccount.setDescription(description);
			
			
			ChartOfAccount create = chartOfAccountsApi.create(chartOfAccount);
		
			ChartOfAccount get = chartOfAccountsApi.get(accountId);
			
			get.setAccountType(accountType);
		
			ChartOfAccount update = chartOfAccountsApi.update(get);
		
			String markAsInactive = chartOfAccountsApi.markAsInactive(accountId);
		
			String markAsActive = chartOfAccountsApi.markAsActive(accountId);
		
			TransactionList getTransactions = chartOfAccountsApi.getTransactions(accountId, hashMap);
			
			String transactionId = getTransactions.get(0).getImportedTransactionId();
			
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

