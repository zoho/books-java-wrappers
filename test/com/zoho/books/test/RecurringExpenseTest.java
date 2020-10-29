/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.RecurringExpensesApi;

import com.zoho.books.model.RecurringExpense;
import com.zoho.books.model.Expense;
import com.zoho.books.model.Comment;
import com.zoho.books.model.RecurringExpenseList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.ExpenseList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class RecurringExpenseTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		RecurringExpensesApi recurringExpenseApi = service.getRecurringExpensesApi();
		
		
		
		String accountId = "36991000000000424";
		
		String paidThroughAccountId = "36991000000029003";
		
		double amount = 20.00;
		
		String taxId = "36991000000057001";
		
		String customerId = "36991000000041005"; 
		
		String sortColumn = "account_name";	//No I18N
		
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("filter_by", "RecExpenseStatus.Expired");
		hashMap.put("sort_column", "customer_name");
		
		try
		{
		
			RecurringExpenseList getRecurringExpenses = recurringExpenseApi.getRecurringExpenses(hashMap);
		
			String recurringExpenseId = getRecurringExpenses.get(0).getRecurringExpenseId();
		
		
			RecurringExpense recurringExpense = new RecurringExpense();
		
			recurringExpense.setRecurringExpenseId(recurringExpenseId);
		
			recurringExpense.setAccountId(accountId);
			recurringExpense.setPaidThroughAccountId(paidThroughAccountId);
			recurringExpense.setRecurrenceName("sahaya");	//No I18N
			recurringExpense.setStartDate("2014-02-21");
			recurringExpense.setEndDate("2014-02-28");
			recurringExpense.setRecurrenceFrequency("months");	//No I18N
			recurringExpense.setRepeatEvery(3);
			recurringExpense.setAmount(amount);
			recurringExpense.setTaxId(taxId);
			recurringExpense.setIsInclusiveTax(false);
			recurringExpense.setIsBillable(false);
			recurringExpense.setDescription("This is the recurring expense.");	//No I18N
			recurringExpense.setCustomerId(customerId);
			recurringExpense.setVendorId("36991000000041005");
			recurringExpense.setProjectId("");
			recurringExpense.setCurrencyId("36991000000000099");
			recurringExpense.setExchangeRate(1.00);		
		
		
		
			RecurringExpense create = recurringExpenseApi.create(recurringExpense);
		
			RecurringExpense get = recurringExpenseApi.get(recurringExpenseId);
			
			get.setDescription("Update the recurring expense"); //No I18N
		
			RecurringExpense update = recurringExpenseApi.update(get);
		
			String resumeRecurringExpense = recurringExpenseApi.resume(recurringExpenseId);
		
			String stopRecurringExpense = recurringExpenseApi.stop(recurringExpenseId);
		
			ExpenseList getExpensesCreated = recurringExpenseApi.getExpensesCreated(recurringExpenseId, hashMap);
		
			CommentList getComments = recurringExpenseApi.getComments(recurringExpenseId);
			
			String delete = recurringExpenseApi.delete(recurringExpenseId);
			
		
			//System.out.println(getComments);
			
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
