/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.BankAccountsApi;

import com.zoho.books.model.BankAccount;
import com.zoho.books.model.Statement;
import com.zoho.books.model.BankAccountList;

public class BankAccountTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}"); //No I18N
		
		BankAccountsApi bankAccountApi = service.getBankAccountsApi();
		
		try
		{
		
			BankAccountList getBankaccounts = bankAccountApi.getBankaccounts(null);
		
			String accountId = getBankaccounts.get(0).getAccountId();
		
			BankAccount bankAccount = new BankAccount();
		
			bankAccount.setAccountId(accountId);
		
			bankAccount.setAccountName("icici"); 		//No I18N
			bankAccount.setAccountNumber("123456789");	//No I18N
			bankAccount.setAccountType("bank");		//No I18N
			bankAccount.setCurrencyId(getBankaccounts.get(0).getCurrencyId());	//No I18N
			bankAccount.setCurrencyCode("INR");		//No I18N
			bankAccount.setUncategorizedTransactions(0);
			bankAccount.setIsActive(true);
			bankAccount.setBalance(10000.00);
			bankAccount.setBankName("IOB");			//No I18N
			bankAccount.setRoutingNumber("1122");
			bankAccount.setIsPrimaryAccount(false);
			bankAccount.setIsPaypalAccount(false);
		
			BankAccount create = bankAccountApi.create(bankAccount);
			
			BankAccount get = bankAccountApi.get(accountId);
			
			get.setAccountName("Test Account");	//No I18N
		
			BankAccount update = bankAccountApi.update(get);
		
			String deactivate = bankAccountApi.deactivateAccount(accountId);
		
			String activate = bankAccountApi.activateAccount(accountId);
		
			//Statement statement = bankAccountApi.getLastImportedStatement(accountId);
		
			String statementId = "36991000000000376";
		
			String deleteStatement = bankAccountApi.deleteLastImportedStatement(accountId, statementId);
			
			String delete = bankAccountApi.delete(accountId);
			
			
			//System.out.println(deleteStatement);
			
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
