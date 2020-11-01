/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.VendorPaymentsApi;

import com.zoho.books.model.VendorPayment;
import com.zoho.books.model.Bill;
import com.zoho.books.model.VendorPaymentList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class VendorPaymentsTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		VendorPaymentsApi vendorPaymentsApi = service.getVendorPaymentsApi();
		
		
		String currencyId = "36991000000000099"; 
		
		String accountId = "36991000000000361";
		
		String accountName = "Petty Cash";	//No I18N
		
		String vendorId = "36991000000025001";
		
		String billId = "36991000000035035";
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("filter_by", "PaymentMode.All");
		
		
		
		VendorPayment vendorPayments = new VendorPayment();
		
		vendorPayments.setVendorId(vendorId);
		vendorPayments.setPaymentMode("Stripe");	//No I18N
		vendorPayments.setDescription("Payment applied by the vendor.");	//No I18N
		vendorPayments.setDate("2014-02-21");
		vendorPayments.setReferenceNumber("Ref-1");	//No I18N
		vendorPayments.setExchangeRate(1.00);
		vendorPayments.setAmount(100.00);
		vendorPayments.setPaidThroughAccountId(accountId);
		
		Bill bill = new Bill();
		
		bill.setBillPaymentId("36991000000056021");
		bill.setBillId(billId);
		bill.setAmountApplied(0.00);
		
		List<Bill> bills = new ArrayList<Bill>();
		bills.add(0, bill);
		vendorPayments.setBills(bills);
		
		
		try
		{
			
			VendorPaymentList getVendorPayments = vendorPaymentsApi.getVendorPayments(hashMap);
			
			String vendorPaymentId = getVendorPayments.get(0).getPaymentId(); 
		
			VendorPayment create = vendorPaymentsApi.create(vendorPayments);
		
			VendorPayment get = vendorPaymentsApi.get(vendorPaymentId);
			
			get.setExchangeRate(2.00);
		
			VendorPayment update = vendorPaymentsApi.update(get);
		
			String delete = vendorPaymentsApi.delete(vendorPaymentId);
		
			//System.out.println(getVendorPayments);
			
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
