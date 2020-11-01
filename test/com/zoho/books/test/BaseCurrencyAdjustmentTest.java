/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.BaseCurrencyAdjustmentsApi;

import com.zoho.books.model.BaseCurrencyAdjustment;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.BaseCurrencyAdjustmentList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseCurrencyAdjustmentTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		BaseCurrencyAdjustmentsApi baseCurrencyAdjustmentApi = service.getBaseCurrencyAdjustmentsApi();
		
		String accountId = "36991000000000424";
		
		String accountIds = "36991000000000424,36991000000000426";
		
		String currencyId = "36991000000000099";
		
		String date = "2014-02-21";
		
		String adjustmentDate = "2014-02-21";
		
		double exchangeRate = 1.00;
		
		String notes = "Thanks for your business.";	//No I18N
		
		String baseCurrencyAdjustmentId = "36991000000072005";
		
		String journalId = "36991000000056001";
		
		
		
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("currency_id", currencyId);
		queryMap.put("adjustment_date", adjustmentDate);
		queryMap.put("exchange_rate", exchangeRate);
		queryMap.put("notes", notes);
		
		queryMap.put("account_ids", accountIds);
		
		queryMap.put("filter_by", "Date.All");
		
		
		BaseCurrencyAdjustment baseCurrencyAdjustment = new BaseCurrencyAdjustment();
		
		baseCurrencyAdjustment.setCurrencyId(currencyId);
		baseCurrencyAdjustment.setAdjustmentDate(adjustmentDate);
		baseCurrencyAdjustment.setExchangeRate(exchangeRate);
		baseCurrencyAdjustment.setNotes(notes);
		
		
		try
		{		
		
			BaseCurrencyAdjustment getBaseCurrencyAdjustmentAccounts = baseCurrencyAdjustmentApi.getBaseCurrencyAdjustmentAccounts(queryMap);
		
			BaseCurrencyAdjustment create = baseCurrencyAdjustmentApi.create(queryMap, baseCurrencyAdjustment);
		
			BaseCurrencyAdjustment get = baseCurrencyAdjustmentApi.get(baseCurrencyAdjustmentId);
			
			BaseCurrencyAdjustmentList getBaseCurrencyAdjustments = baseCurrencyAdjustmentApi.getBaseCurrencyAdjustments(queryMap);
			
			String delete = baseCurrencyAdjustmentApi.delete(baseCurrencyAdjustmentId);
			
			
		
			//System.out.println(getBaseCurrencyAdjustments);
			
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
