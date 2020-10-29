/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.CustomerPaymentsApi;

import com.zoho.books.model.CustomerPayment;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.CustomerPaymentList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerPaymentsApiTest
{
	public static void main(String[] args)throws Exception
	{
		
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		CustomerPaymentsApi customerPaymentsApi = service.getCustomerPaymentsApi();	
		
	
		String customerId = "36991000000041005";
		
		String invoiceId = "36991000000035007"; 
		
		String accountId = "36991000000029003";
		
		String invoicePaymentId = "36991000000037003";
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("filter_by", "PaymentMode.Cash");
		hashMap.put("sort_column", "customer_name");
		
		
		CustomerPayment customerPayments = new CustomerPayment();
		
		customerPayments.setCustomerId(customerId);
		customerPayments.setPaymentMode("Cash");	//No I18N
		customerPayments.setDate("2014-02-21");
		customerPayments.setReferenceNumber("Ref-1");	//No I18N
		customerPayments.setExchangeRate(1.00);
		customerPayments.setAmount(1000.00);
		customerPayments.setBankCharges(0.00);
		customerPayments.setAccountId(accountId);
		
		Invoice invoice = new Invoice();
		invoice.setInvoicePaymentId(invoicePaymentId);
		invoice.setInvoiceId(invoiceId);
		invoice.setAmountApplied(100.00);
		invoice.setTaxAmountWithheld(0.00);
		
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices.add(0, invoice);
		
		customerPayments.setInvoices(invoices);
		
		try
		{
			CustomerPaymentList getCustomerPayments = customerPaymentsApi.getCustomerPayments(hashMap);
			
			String customerPaymentId = getCustomerPayments.get(0).getPaymentId();
			
			CustomerPayment create = customerPaymentsApi.create(customerPayments);
		
			CustomerPayment get = customerPaymentsApi.get(customerPaymentId);
			
			get.setExchangeRate(2.00);
		
			CustomerPayment update = customerPaymentsApi.update(get);
		
			String delete = customerPaymentsApi.delete(customerPaymentId);
		
			//System.out.println(getCustomerPayments);
			
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
