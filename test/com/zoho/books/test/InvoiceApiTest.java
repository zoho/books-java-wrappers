/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.InvoicesApi;

import com.zoho.books.model.Invoice;
import com.zoho.books.model.Address;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Credit;
import com.zoho.books.model.Payment;
import com.zoho.books.model.InvoicePayment;
import com.zoho.books.model.ApplyCreditnote;
import com.zoho.books.model.Comment;
import com.zoho.books.model.Email;
import com.zoho.books.model.Contact;
import com.zoho.books.model.InvoiceList;
import com.zoho.books.model.TemplateList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.PaymentList;
import com.zoho.books.model.CreditList;
import com.zoho.books.model.PageContext;


import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.util.HashMap;

public class InvoiceApiTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
		
		InvoicesApi invoiceApi = service.getInvoicesApi();
		
		

		String customerId = "36991000000025001"; 
		
		String contactPersonId = "36991000000026003"; 
		
		String contactId = "36991000000041005";	
		
		String description = "This is the testing invoice";	//No I18N
		
		boolean send = false;
		
		boolean ignore_auto_number_generation = false;
		
		boolean e_mail = true;
		
		boolean snailMail = false;
		
		String paymentId = "36991000000051035";
		
		String creditNoteId = "36991000000035019";
		
		String amountapplied = "20.00";
		
		String amountApplied = "30.00";
		
		String creditId = "36991000000035019";
		
		boolean show_comment_to_clients = true;
		
		File file1 = new File("{Dir_name}/file.jpg");
		
		String invoicePaymentId = "36991000000051035";
		
		String paymentExpectedDate = "2014-02-21";
		
		boolean showCommentToClients = true;
		
		
		ArrayList<File> file = new ArrayList<File>();
		file.add(0, file1);
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		/*hashMap.put("filter_by", "Status.Paid");
		hashMap.put("sort_column", "invoice_number");*/
		
		//hashMap.put("can_send_in_mail", "true");
		
		hashMap.put("ignore_auto_number_generation", "true");

		Invoice newInvoice = new Invoice();
		
		newInvoice.setReferenceNumber("Ref-211");	//No I18N
		newInvoice.setPaymentTerms(15);
		newInvoice.setPaymentTermsLabel("Net 15");	//No I18N
		
		newInvoice.setCustomerId(customerId);
		
		String[] contactPersons = {contactPersonId};
		newInvoice.setContactPersons(contactPersons);
		
		newInvoice.setInvoiceNumber("INV-47");
		newInvoice.setDate("2014-02-21");
		newInvoice.setDueDate("2014-02-28");
		newInvoice.setNotes("Thanks for your business.");	//No I18N
		newInvoice.setTerms("Thanks to accept out terms and conditions.");	//No I18N
		
		LineItem lineItem = new LineItem();
		lineItem.setItemOrder(1);
		lineItem.setItemId("36991000000035001");
		lineItem.setRate(1000.00);
		lineItem.setName("sample");		//No I18N
		lineItem.setDescription("sample item");	//No I18N
		lineItem.setQuantity(4.00);
		lineItem.setDiscount(0.00);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(0, lineItem);
		
		newInvoice.setLineItems(lineItems);
		
		newInvoice.setAllowPartialPayments(false);
		newInvoice.setExchangeRate(1.00);
		newInvoice.setIsDiscountBeforeTax(true);
		newInvoice.setDiscount("0.00");
		newInvoice.setDiscountType("entity_level");	//No I18N
		newInvoice.setShippingCharge(0.00);
		newInvoice.setAdjustment(0.00);
		newInvoice.setAdjustmentDescription("Rounding off");	//No I18N


		Email email = new Email();
		String[] str = {"sahaya.ramesh@zohocorp.com"};	//No I18N
		
		email.setToMailIds(str);
		email.setSubject("Invoice from SSR (Invoice#: INV-22)");	//No I18N
		email.setBody("Dear Customer,         \n\nThanks for your business.         \n\nThe invoice INV-22 is attached with this email. You can choose the easy way out and <a href=\"https://books3.localzoho.com:443/portal/sahayaramesh/login?CInvoiceID=c32a40aee4e9cb36330cbaf3f3d6ce5be41d4d2eb4e1ea93a970c52c8f39fdaa3525df1b68f0136a7e4d9af80b938f18\">pay online for this invoice.</a>         \nHere's an overview of the invoice for your reference.         \n\nInvoice Overview:         \nInvoice # : INV-22         \nDate : 23 Sep 2013         \nAmount : Rs.0.00         \n\nIt was great working with you. Looking forward to working with you again.<br><br><br><br>Regards<br><br>SSR<br><br>");	//No I18N
		email.setSendFromOrgEmailId(true);
		
		email.setAttachments(file);
		
		
		Address shippingAddress = new Address();
		shippingAddress.setAddress("3/2,Rammathapuram");	//No I18N
		shippingAddress.setCity("Tirunelveli");			//No I18N
		shippingAddress.setState("TamilNadu");			//No I18N
		shippingAddress.setZip("627 654");
		shippingAddress.setCountry("India");			//No I18N
		shippingAddress.setFax("");
		
		Address billingAddress = new Address();
		billingAddress.setAddress("3/2,Rammathapuram");		//No I18N
		billingAddress.setCity("Tirunelveli");			//No I18N
		billingAddress.setState("TamilNadu");			//No I18N
		billingAddress.setZip("627 654");
		billingAddress.setCountry("India");			//No I18N
		billingAddress.setFax("");
		
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = new Contact();
		
		contact.setContactId(contactId);
		contact.setIsEmail(e_mail);
		contact.setIsSnailMail(snailMail);
		
		contacts.add(0, contact);
		
		
		InvoicePayment invoicePayment = new InvoicePayment();
		
		invoicePayment.setPaymentId("36991000000051035");
		invoicePayment.setAmountApplied(0.00);
		
		List<InvoicePayment> invoicePayments = new ArrayList<InvoicePayment>();
		invoicePayments.add(0, invoicePayment);
		
		
		ApplyCreditnote applyCreditnote = new ApplyCreditnote();
		
		applyCreditnote.setCreditnoteId("36991000000035019");
		applyCreditnote.setAmountApplied(0.00);
		
		List<ApplyCreditnote> applyCreditnotes = new ArrayList<ApplyCreditnote>();
		applyCreditnotes.add(0, applyCreditnote);


		try
		{
		
			InvoiceList invoices = invoiceApi.getInvoices(hashMap);
			
			String invoiceId = invoices.get(0).getInvoiceId();
			
			Invoice invoice = invoiceApi.get(invoiceId);
			
			invoice.setAllowPartialPayments(true);
		
			Invoice create = invoiceApi.create(customerId, contactPersonId, description);
		
			Invoice createInvoice = invoiceApi.create(newInvoice, hashMap); 
		
			Invoice update = invoiceApi.update(invoice, hashMap);
		
			String sendEmail = invoiceApi.sendEmail(invoiceId, email, hashMap);
		
			String sendEmailInvoices = invoiceApi.sendEmailInvoices(contacts, hashMap);
		
			Email getEmailContent = invoiceApi.getEmailContent(invoiceId, hashMap);
		
			String sendPaymentReminder = invoiceApi.sendPaymentReminder(invoiceId, email, hashMap);
		
			String sendBulkInvoiceReminder = invoiceApi.sendBulkInvoiceReminder(hashMap);
		
			Email getPaymentReminder = invoiceApi.getPaymentReminder(invoiceId);
		
			String markAsSent = invoiceApi.markAsSent(invoiceId);
		
			String markAsDraft = invoiceApi.markAsDraft(invoiceId);
		
			String markAsVoid = invoiceApi.markAsVoid(invoiceId);
			
			hashMap.put("invoice_ids", invoiceId);
		
			File getPdf = invoiceApi.bulkExport(hashMap);
		
			File print = invoiceApi.bulkPrint(hashMap);
		
			String enablePaymentReminder = invoiceApi.enablePaymentReminder(invoiceId);
		
			String disablePaymentReminder = invoiceApi.disablePaymentReminder(invoiceId);
		
			String writeOffInvoice = invoiceApi.writeOffInvoice(invoiceId);
		
			String cancelWriteOff = invoiceApi.cancelWriteOff(invoiceId);
		
			String updateBillingAddress = invoiceApi.updateBillingAddress(invoiceId, billingAddress);
		
			String updateShippingAddress = invoiceApi.updateShippingAddress(invoiceId, shippingAddress);
		
			TemplateList getTemplates = invoiceApi.getTemplates();
			
			String templateId = getTemplates.get(0).getTemplateId();
		
			String updateTemplate = invoiceApi.updateTemplate(invoiceId, templateId);
		
		
		
			PaymentList payments = invoiceApi.getPayments(invoiceId);
		
			CreditList getCreditsApplied = invoiceApi.getCreditsApplied(invoiceId);
		
			Credit addCredits = invoiceApi.addCredits(invoiceId, invoicePayments, applyCreditnotes);
		
			String deletePayment = invoiceApi.deletePayment(invoiceId, invoicePaymentId);
		
			String deleteCredit = invoiceApi.deleteAppliedCredit(invoiceId, creditId);
		
		
		
		
			String addAttachment = invoiceApi.addAttachment(invoiceId, file1, hashMap);
		
			File getAttachment = invoiceApi.getAttachment(invoiceId, hashMap);
		
			String updateAttachment = invoiceApi.updateAttachment(invoiceId, hashMap);
		
			String deleteAttachment = invoiceApi.deleteAttachment(invoiceId);
		
			String deleteExpenseReceipt = invoiceApi.deleteExpenseReceipt(invoiceId);
		
		
		
		
			Comment addComment = invoiceApi.addComment(invoiceId, description, paymentExpectedDate, showCommentToClients);
		
			CommentList getComments = invoiceApi.getComments(invoiceId);
			
			String commentId = getComments.get(0).getCommentId();
		
			Comment updateComment = invoiceApi.updateComment(invoiceId, commentId, description, show_comment_to_clients);
		
			String deleteComment = invoiceApi.deleteComment(invoiceId, commentId);
		
			
			
			String delete = invoiceApi.delete(invoiceId);
			
			
			//System.out.println(createInvoice);
		
		}
		catch(BooksException be)
		{
			//System.out.println("Code: "+be.getCode()+"	Message: "+be.getMessage());
			
			throw be;
		}
		catch(Exception e)
		{
		
			throw e;
		}
		
		
	}
}
