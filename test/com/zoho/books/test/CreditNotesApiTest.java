/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.CreditNotesApi;

import com.zoho.books.model.CreditNote;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.Address;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.InvoicesCredited;
import com.zoho.books.model.Comment;
import com.zoho.books.model.CreditnoteRefund;
import com.zoho.books.model.Template;
import com.zoho.books.model.EmailHistory;
import com.zoho.books.model.Email;
import com.zoho.books.model.CreditNoteList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.CreditnoteRefundList;
import com.zoho.books.model.TemplateList;
import com.zoho.books.model.InvoiceList;
import com.zoho.books.model.EmailHistoryList;
import com.zoho.books.model.InvoicesCreditedList;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;

public class CreditNotesApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
		
		CreditNotesApi creditNotesApi = service.getCreditNotesApi();
		
		
		
		String recurringInvoiceId = "36991000000056043"; 
		
		String customerId = "36991000000025001"; 
		
		String contactPersonId = "36991000000026003";
		
		boolean ignore_auto_number_generation = false;
		
		String invoiceId = "36991000000035007"; 
		
		String from_account_id = "36991000000029003";
		
		String currency_id = "831000000000099";
		
		String templateId = "36991000000000203";
		
		String payment_mode_id = "36991000000056069";
		
		String description = "This is a testing comment";	//No I18N
		
		String accountId = "36991000000000388"; 
		
		String itemName = "Trial";	//No I18N
		
		String creditnoteInvoiceId = "36991000000000390";
		
		File file1 = new File("{Dir_name}/file.jpg");
		File file2 = new File("{Dir_name}/file1.pem");
		
		ArrayList<File> file = new ArrayList<File>();
		
		file.add(0, file1);
		file.add(1, file2);
		
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("filter_by", "Status.Open");
		hashMap.put("sort_column", "refund_mode");
		
		hashMap.put("ignore_auto_number_generation", "false");
		
		hashMap.put("customer_id", customerId);
		
		
		CreditNote creditNotes = new CreditNote();
		
		creditNotes.setCustomerId(customerId);
		creditNotes.setTemplateId(templateId);
		creditNotes.setDate("2014-02-21");
		creditNotes.setExchangeRate(1.00);
		
		String[] contactPersons = {contactPersonId};
		creditNotes.setContactPersons(contactPersons);
		
		LineItem lineItem = new LineItem();
		lineItem.setItemId("36991000000035001");
		lineItem.setAccountId(accountId);
		lineItem.setRate(1000.00);
		lineItem.setName("mobile");		//No I18N
		lineItem.setDescription("new mobile");	//No I18N
		lineItem.setQuantity(1.00);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(0, lineItem);
		
		creditNotes.setLineItems(lineItems);
		
		
		
		Email email = new Email();
		String[] str = {"sahaya.ramesh@zohocorp.com"};	//No I18N
		
		email.setToMailIds(str);
		email.setSubject("Payment reminder for Invoice (Invoice#: INV-24)");	//No I18N
		email.setBody("Dear Customer, \nThanks for your business. The invoice INV-24 is attached with this email. You can choose the easy way. Here's an overview of the invoice for your reference. Invoice Overview: Invoice # : INV-24 Date : 24 Sep 2013 Amount : Rs.612.00 It was great working with you. Looking forward to working with you again.\n\n\n\n Regards\nSSR");	//No I18N
		email.setSendFromOrgEmailId(false);
		
		email.setAttachments(file);
		
		
		CreditnoteRefund creditnoteRefunds = new CreditnoteRefund();
		
		creditnoteRefunds.setDate("2014-02-21");
		creditnoteRefunds.setRefundMode("Cash");	//No I18N
		creditnoteRefunds.setReferenceNumber("Ref-1");	//No I18N
		creditnoteRefunds.setAmount(100.00);
		creditnoteRefunds.setExchangeRate(1.00);
		creditnoteRefunds.setFromAccountId("831000000000361");
		
		
		Address shippingAddress = new Address();
		
		shippingAddress.setAddress("3/2,Rammathapuram");	//No I18N
		shippingAddress.setCity("Tirunelveli");			//No I18N
		shippingAddress.setState("TamilNadu");			//No I18N
		shippingAddress.setZip("627 654");
		shippingAddress.setCountry("India");			//No I18N
		shippingAddress.setFax("");
		
		
		Address billingAddress = new Address();
		
		billingAddress.setAddress("3/2, North Street, RammathaPuram");	//No I18N
		billingAddress.setCity("Tirunelveli");				//No I18N
		billingAddress.setState("TamilNadu");				//No I18N
		billingAddress.setZip("627 654");
		billingAddress.setCountry("India");				//No I18N
		billingAddress.setFax("");
		
		
		Invoice invoice = new Invoice();
		
		invoice.setInvoiceId(invoiceId);
		invoice.setAmountApplied(100.00);
		
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices.add(0, invoice);
 		
		try
		{
			
			CreditNoteList getCreditNotes = creditNotesApi.getCreditNotes(hashMap);
			
			String creditNoteId = getCreditNotes.get(0).getCreditnoteId();
		
			CreditNote create = creditNotesApi.create(customerId, accountId, itemName);
		
			CreditNote create1 = creditNotesApi.create(creditNotes, hashMap);
		
			CreditNote get = creditNotesApi.get(creditNoteId);
			
			get.setBalance(0.00);
		
			CreditNote update = creditNotesApi.update(get, hashMap);
		
			String sendEmail = creditNotesApi.sendEmail(creditNoteId, email, hashMap);
		
			EmailHistoryList getEmailHistory = creditNotesApi.getEmailHistory(creditNoteId);
		
			Email getEmailContent = creditNotesApi.getEmailContent(creditNoteId, hashMap);
		
			String cnvertToOpen = creditNotesApi.convertToOpen(creditNoteId);
		
			String cnvertToVoid = creditNotesApi.convertToVoid(creditNoteId);
		
			String updateBillingAddress = creditNotesApi.updateBillingAddress(creditNoteId, billingAddress);
		
			String updateShippingAddress = creditNotesApi.updateShippingAddress(creditNoteId, shippingAddress);
		
			TemplateList getTemplates = creditNotesApi.getTemplates();
		
			String updateTemplate = creditNotesApi.updateTemplate(creditNoteId, templateId);
		
		
		
		
			InvoiceList creditToInvoice = creditNotesApi.creditToInvoice(creditNoteId, invoices);
		
			InvoicesCreditedList getInvoicesCredited = creditNotesApi.getInvoicesCredited(creditNoteId);
		
			String deleteInvoicesCredited = creditNotesApi.deleteInvoicesCredited(creditNoteId, creditnoteInvoiceId);
		
		
		
			
			CreditnoteRefundList getCreditnoteRefunds = creditNotesApi.getCreditnoteRefunds(hashMap);
			
			String creditnoteRefundId = getCreditnoteRefunds.get(0).getCreditnoteRefundId();
			
			CreditnoteRefund addCreditnoteRefund = creditNotesApi.addRefund(creditNoteId, creditnoteRefunds);
		
			CreditnoteRefund getCreditnoteRefund = creditNotesApi.getRefund(creditNoteId, creditnoteRefundId);
			
			getCreditnoteRefund.setCustomerName("Ramesh");	//No I18N
		
			CreditnoteRefund updateCreditnoteRefund = creditNotesApi.updateRefund(creditNoteId, getCreditnoteRefund);
		
			CreditnoteRefundList getRefundsOfCreditnotes = creditNotesApi.getRefundsOfCreditnotes(creditNoteId);
		
			String deleteCreditnoteRefund = creditNotesApi.deleteRefund(creditNoteId, creditnoteRefundId);
		
		
		
			Comment addComment = creditNotesApi.addComment(creditNoteId, description);
		
			CommentList getComments = creditNotesApi.getComments(creditNoteId);
			
			String commentId = getComments.get(0).getCommentId();
		
			String deleteComment = creditNotesApi.deleteComment(creditNoteId, commentId);
			
			
			String delete = creditNotesApi.delete(creditNoteId);
			
			
		
			//System.out.println(sendEmail);
			
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
