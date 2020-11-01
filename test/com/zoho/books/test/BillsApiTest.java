/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.BillsApi;

import com.zoho.books.model.Bill;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Address;
import com.zoho.books.model.Payment;
import com.zoho.books.model.Comment;
import com.zoho.books.model.BillList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.PaymentList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

import org.json.JSONObject;

public class BillsApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}"); 	//No I18N
	
		BillsApi billsApi = service.getBillsApi();
		
		
		
		String currencyId = "36991000000000099"; 
		
		String accountId = "36991000000029003";
		
		String accountName = "Advance Tax";	//No I18N
		
		String ruleId = "831000000081001";
		
		String vendorId = "36991000000025001";
		
		String paymentId = "36991000000056019";
		
		String transactionId = "36991000000031091";
		
		String billNumber = "13";
		
		String lineItemId = "36991000000035043";
		
		String billPaymentId = "36991000000056021";
		
		File  file = new File("/home/likewise-open/ZOHOCORP/ramesh-2099/inv.jpg");
		
		String description = "Payment has been made.";	//No I18N
		
		String commentId = "36991000000056025";
		
		
		
		HashMap hashMap = new HashMap();
		
		hashMap.put("filter_by", "Status.All");
		hashMap.put("sort_column", "vendor_name");
		
		
		
		Bill bills = new Bill();
		
		bills.setVendorId(vendorId);
		bills.setBillNumber("1");
		bills.setReferenceNumber("1234");
		bills.setDate("2014-01-28");
		bills.setDueDate("2014-03-28");
		bills.setExchangeRate(1.00);
		bills.setNotes("Thanks for your business.");	//No I18N
		bills.setTerms("Terms and conditions apply.");	//No I18N
		
		LineItem lineItem = new LineItem();
		
		lineItem.setLineItemId(lineItemId);
		lineItem.setAccountId(accountId);
		lineItem.setDescription("item");	//No I18N
		lineItem.setRate(1000.00);
		lineItem.setQuantity(0.00);
		lineItem.setTaxId("36991000000032001");
		lineItem.setItemOrder(2);
		
		LineItem lineItem1 = new LineItem();
		
		lineItem1.setLineItemId(lineItemId);
		lineItem1.setAccountId(accountId);
		lineItem1.setDescription("items");	//No I18N
		lineItem1.setRate(100.00);
		lineItem1.setQuantity(2.00);
		lineItem1.setTaxId("36991000000032001");
		lineItem1.setItemOrder(5);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(0, lineItem);
		lineItems.add(1, lineItem1);
		
		bills.setLineItems(lineItems);
		
		
		Address billingAddress = new Address();
		billingAddress.setAddress("1584,Ramnagar South, Madippakkam");	//No I18N
		billingAddress.setCity("Chennai");				//No I18N
		billingAddress.setState("Tamil Nadu");				//No I18N
		billingAddress.setZip("600 091");
		billingAddress.setCountry("India");				//No I18N
		billingAddress.setFax("");
		billingAddress.setIsUpdateCustomer(true);
		
		
		
		Payment payment = new Payment();
		
		payment.setPaymentId("36991000000056019");
		payment.setAmountApplied(100.00);
		
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(0, payment);
		
		
		try
		{
			
			BillList getBills = billsApi.getBills(hashMap);
			
			String billId = getBills.get(0).getBillId();
			
			
			Bill create = billsApi.create(bills, file);
		
			Bill createBill = billsApi.create(vendorId, billNumber, accountId);
		
			Bill createBill1 = billsApi.create(bills);
			
			Bill get = billsApi.get(billId);
			
			get.setDueDate("2014-06-12");	//No I18N
		
			Bill update = billsApi.update(get);
		
			Bill updateBill = billsApi.update(get, file);
		
			String voidABill = billsApi.voidABill(billId);
		
			String markABillAsOpen = billsApi.markABillAsOpen(billId);
		
			String updateBillingAddress = billsApi.updateBillingAddress(billId, billingAddress);
		
		
		
			PaymentList getPayments = billsApi.getPayments(billId);
		
			String applyCredits = billsApi.applyCredits(billId, payments);
		
			String deletePayment = billsApi.deletePayment(billId, billPaymentId);
		
		
		
		
			File getAttachment = billsApi.getAttachment(billId);
		
			String addAttachment = billsApi.addAttachment(billId, file);
		
			String deleteAttachment = billsApi.deleteAttachment(billId);
		
		
			CommentList getComments = billsApi.getComments(billId);
		
			Comment addComment = billsApi.addComment(billId, description);
		
			String deleteComment = billsApi.deleteComment(billId, commentId);
			
			
			
			String delete = billsApi.delete(billId);
			
			
		
			//System.out.println(addAttachment);
			
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
