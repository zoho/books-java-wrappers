/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.JournalsApi;

import com.zoho.books.model.Journal;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.JournalList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class JournalsApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		JournalsApi journalsApi = service.getJournalsApi();
		
		
		
		String accountId = "36991000000000361";
		
		String accountName = "account";	//No I18N
		
		String lineId = "36991000000056005"; 
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("filter_by", "JournalDate.All");
		hashMap.put("sort_column", "journal_date");
		
		
		
		Journal journals = new Journal();
		
		journals.setJournalDate("2014-10-04");
		journals.setReferenceNumber("Ref-1");		//No I18N
		journals.setNotes("Thanks for your business.");	//No I18N
		
		LineItem lineItem = new LineItem();
		lineItem.setAccountId(accountId);
		lineItem.setDescription("account payable");	//No I18N
		lineItem.setTaxId("36991000000057001");
		lineItem.setAmount(100.00);
		lineItem.setDebitOrCredit("credit");		//No I18N
		
		LineItem lineItem1 = new LineItem();
		lineItem1.setAccountId(accountId);
		lineItem1.setDescription("Interest Expense");	//No I18N
		lineItem1.setTaxId("36991000000057001");
		lineItem1.setAmount(10.00);
		lineItem1.setDebitOrCredit("debit");		//No I18N
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(0, lineItem);
		lineItems.add(1, lineItem1);
		
		journals.setLineItems(lineItems);
		
		
		try
		{
			
			JournalList getJournals = journalsApi.getJournals(hashMap);
			
			String journalId = getJournals.get(0).getJournalId();
		
			Journal create = journalsApi.create(journals);
		
			Journal get = journalsApi.get(journalId);
			
			get.setNotes("Thank you"); //No I18N
		
			Journal update = journalsApi.update(get);
		
			String delete = journalsApi.delete(journalId);
			
		
			//System.out.println(getJournals.get(0).getJornalId());
			
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
