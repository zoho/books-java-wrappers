/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.ExpensesApi;

import com.zoho.books.model.Expense;
import com.zoho.books.model.Comment;
import com.zoho.books.model.Address;
import com.zoho.books.model.ExpenseList;
import com.zoho.books.model.CommentList;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class ExpenseApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		ExpensesApi expenseApi = service.getExpensesApi();
		
		
		String accountId = "36991000000000424";
		
		String paidThroughAccountId = "36991000000029003";
		
		double amount = 100.00;
		
		String customerId = "36991000000041005";
		
		String taxId = "36991000000032001";
		
		File file = new File("{Dir_name}/file.jpg");
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("filter_by", "Status.All");
		
		
		try
		{
			ExpenseList getExpenses = expenseApi.getExpesnses(hashMap);
			
			String expenseId = getExpenses.get(0).getExpenseId();
		
			Expense get = expenseApi.get(expenseId);
		
			Expense expense = new Expense();
		
			expense.setExpenseId(expenseId);
		
			expense.setAccountId(accountId);
			expense.setPaidThroughAccountId(paidThroughAccountId);
			expense.setDate("2014-02-21");
			expense.setAmount(amount);
			expense.setTaxId(taxId);
			expense.setIsInclusiveTax(true);
			expense.setIsBillable(false);
			expense.setReferenceNumber("Ref-1");	//No I18N
			expense.setDescription("New expense for the customer.");	//No I18N
			expense.setCustomerId(customerId);
			expense.setVendorId("36991000000041005");
			expense.setCurrencyId("36991000000000099");
			expense.setExchangeRate(0.00);
			expense.setProjectId("36991000000038011");
		
		
			Expense create = expenseApi.create(accountId, paidThroughAccountId, amount);
		
			Expense createExpense = expenseApi.create(expense);
		
			Expense create1 = expenseApi.create(get, file);
		
			Expense update = expenseApi.update(expense);
		
			Expense update1 = expenseApi.update(create1, file); 
		
			CommentList getComments = expenseApi.getComments(expenseId);
		
		
			String addReceipt = expenseApi.addReceipt(expenseId, file);
		
			File getReceipt = expenseApi.getReceipt(expenseId);
		
			String deleteReceipt = expenseApi.deleteReceipt(expenseId);
			
			
			String delete = expenseApi.delete(expenseId);
		
		
			//System.out.println(getExpenses);
			
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
