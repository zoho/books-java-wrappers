/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.RecurringInvoicesApi;

import com.zoho.books.model.RecurringInvoice;
import com.zoho.books.model.Address;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Comment;
import com.zoho.books.model.RecurringInvoiceList;
import com.zoho.books.model.CommentList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class RecurringInvoiceApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
		
		RecurringInvoicesApi recurringInvoiceApi = service.getRecurringInvoicesApi();
		

		
		String customerId = "36991000000042001"; 
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("filter_by", "Status.All");
		hashMap.put("sort_column", "customer_name");
		
		
		RecurringInvoice recurringInvoice = new RecurringInvoice();
		
		recurringInvoice.setRecurrenceName("ss");	//No I18N
		recurringInvoice.setStatus("active");		//No I18N
		recurringInvoice.setRecurrenceFrequency("months");	//No I18N
		recurringInvoice.setRepeatEvery(3);
		recurringInvoice.setStartDate("2014-02-21");
		recurringInvoice.setEndDate("2014-02-27");
		recurringInvoice.setLastSentDate("");
		recurringInvoice.setNextInvoiceDate("");
		recurringInvoice.setCustomerId(customerId);
		recurringInvoice.setCustomerName("RAMESH SAHAYA");	//No I18N
		recurringInvoice.setExchangeRate(0.00);
		recurringInvoice.setDiscount(0.00);
		recurringInvoice.setIsDiscountBeforeTax(true);
		recurringInvoice.setDiscountType("VAT");		//No I18N
		recurringInvoice.setPaymentTerms(15);
		recurringInvoice.setPaymentTermsLabel("Net 15");	//No I18N

		String[] contactPersons = {"36991000000026003"};
		recurringInvoice.setContactPersons(contactPersons);
		
		LineItem lineItem = new LineItem();
		lineItem.setItemOrder(0);
		lineItem.setItemId("36991000000054013");
		lineItem.setRate(1000.00);
		lineItem.setName("sample");		//No I18N
		lineItem.setDescription("sample item");	//No I18N
		lineItem.setQuantity(1.00);
		lineItem.setDiscount(0.00);
		lineItem.setTaxId("");
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(0, lineItem);
		
		recurringInvoice.setLineItems(lineItems);
		
		
		recurringInvoice.setShippingCharge(0.00);
		recurringInvoice.setAdjustment(2.00);
		recurringInvoice.setAdjustmentDescription("Adjustment");	//No I18N
		recurringInvoice.setSubTotal(10.00);
		recurringInvoice.setTaxTotal(5.00);
		recurringInvoice.setTotal(1000.00);
		recurringInvoice.setCreditsApplied(0.00);
		recurringInvoice.setBalance(0.00);
		recurringInvoice.setAllowPartialPayments(false);
		
		recurringInvoice.setTemplateId("36991000000000155");
		recurringInvoice.setTemplateName("Service - Professional");	//No I18N
		recurringInvoice.setNotes("Thanks for your business.");		//No I18N
		recurringInvoice.setTerms("Terms and conditions apply.");	//No I18N
		recurringInvoice.setSalespersonId("");
		recurringInvoice.setSalespersonName("");
		
		try
		{
			
			RecurringInvoiceList getRecurringInvoices = recurringInvoiceApi.getRecurringInvoices(hashMap);
			
			String recurringInvoiceId = getRecurringInvoices.get(0).getRecurringInvoiceId();
			
			RecurringInvoice create = recurringInvoiceApi.create(recurringInvoice);
		
			RecurringInvoice get = recurringInvoiceApi.get(recurringInvoiceId);
			
			get.setDiscount(3.00);
		
			RecurringInvoice update = recurringInvoiceApi.update(get);
		
			String stopRecurringInvoice = recurringInvoiceApi.stop(recurringInvoiceId);
		
			String resumeRecurringInvoice = recurringInvoiceApi.resume(recurringInvoiceId);
		
			CommentList getComments = recurringInvoiceApi.getComments(recurringInvoiceId);
			
			String delete = recurringInvoiceApi.delete(recurringInvoiceId);
			
		
			//System.out.println(getRecurringInvoices);
			
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
