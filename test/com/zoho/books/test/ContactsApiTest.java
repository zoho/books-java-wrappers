/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.ContactsApi;
import com.zoho.books.api.ContactPersonsApi;

import com.zoho.books.model.Contact;
import com.zoho.books.model.Address;
import com.zoho.books.model.ContactPerson;
import com.zoho.books.model.DefaultTemplate;
import com.zoho.books.model.CreditnoteRefund;
import com.zoho.books.model.Email;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.ContactList;
import com.zoho.books.model.ContactPersonList;
import com.zoho.books.model.CreditnoteRefundList;
import com.zoho.books.model.PageContext;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.json.JSONArray;

public class ContactsApiTest
{	
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
	
		ContactsApi contactsApi = service.getContactsApi();
		
		ContactPersonsApi contactPersonsApi = service.getContactPersonsApi();
		
		
		//String contactId = "36991000000025001";
		
		String contactName = "SSR";	//No I18N
		
		String currencyId = "36991000000000099";
		
		String customerId = "36991000000041005"; 
		
		String startDate = "2014-02-21";
		
		String endDate = "2014-02-21";
		
		File file1 = new File("{Dir_name}/file.jpg");
		File file2 = new File("{Dir_name}/file1.pem");
		File file3 = new File("{Dir_name}/file2.pdf");
		
		ArrayList file = new ArrayList();
		file.add(0, file1);
		//file.add(1, file2);
		//file.add(2, file3);
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		/*hashMap.put("filter_by", "Status.Active");
		hashMap.put("sort_column", "contact_name");
		
		hashMap.put("send_customer_statement", "false");*/
		
		hashMap.put("start_date", startDate);
		hashMap.put("end_date", endDate);
		
		Contact contacts = new Contact();
		
		contacts.setContactName(contactName);
		contacts.setPaymentTerms(15);
		contacts.setPaymentTermsLabel("Net 15");	//No I18N
		contacts.setCurrencyId(currencyId);
		contacts.setTaxable(true);
		contacts.setNotes("Thanks for your business.");	//No I18N
		
		Address billingAddress = new Address();
		
		billingAddress.setAddress("3/2, North Street, RammathaPuram");	//No I18N
		billingAddress.setCity("Tirunelveli");	//No I18N
		billingAddress.setState("TamilNadu");	//No I18N
		billingAddress.setZip("627 654");
		billingAddress.setCountry("India");	//No I18N
		billingAddress.setFax("");
		
		contacts.setBillingAddress(billingAddress);
		
		Address shippingAddress = new Address();
		
		shippingAddress.setAddress("3/2, North Street, RammathaPuram");	//No I18N
		shippingAddress.setCity("Tirunelveli");	//No I18N
		shippingAddress.setState("TamilNadu");	//No I18N
		shippingAddress.setZip("627 654");
		shippingAddress.setCountry("India");	//No I18N
		shippingAddress.setFax("");
		
		contacts.setShippingAddress(shippingAddress);
		
		ContactPerson contactPerson = new ContactPerson();
		contactPerson.setSalutation("Mr.");	//No I18N
		contactPerson.setFirstName("Sahaya");	//No I18N
		contactPerson.setLastName("Ramesh");	//No I18N
		contactPerson.setEmail("sahaya.ramesh91@gmail.com");	//No I18N
		contactPerson.setPhone("044471612");
		contactPerson.setMobile("8056200970");
		contactPerson.setIsPrimaryContact(true);
		
		List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
		contactPersons.add(0, contactPerson);
		
		contacts.setContactPersons(contactPersons);
		
		DefaultTemplate defaultTemplates = new DefaultTemplate();
		defaultTemplates.setInvoiceTemplateId("");
		defaultTemplates.setEstimateTemplateId("");
		defaultTemplates.setCreditnoteTemplateId("");
		defaultTemplates.setInvoiceEmailTemplateId("");
		defaultTemplates.setEstimateEmailTemplateId("");
		defaultTemplates.setCreditnoteEmailTemplateId("");
		
		contacts.setDefaultTemplates(defaultTemplates);
		
		
		ContactPerson contactPersons1 = new ContactPerson();
		
		contactPersons1.setSalutation("Mr.");	//No I18N
		contactPersons1.setFirstName("Ramesh");	//No I18N
		contactPersons1.setLastName("Sahaya");	//No I18N
		contactPersons1.setEmail("ramesh.saha91@gmail.com");	//No I18N
		contactPersons1.setPhone("044881721");
		contactPersons1.setMobile("2714567215");
		
		
		Email email = new Email();
		String[] str = {"sahaya.ramesh@zohocorp.com"};	//No I18N
		
		email.setToMailIds(str);
		email.setSubject("Payment reminder for Invoice (Invoice#: INV-24)");	//No I18N
		email.setBody("Dear Customer, \nThanks for your business. The invoice INV-24 is attached with this email. You can choose the easy way. Here's an overview of the invoice for your reference. Invoice Overview: Invoice # : INV-24 Date : 24 Sep 2013 Amount : Rs.612.00 It was great working with you. Looking forward to working with you again.\n\n\n\n Regards\nSSR");	//No I18N
		email.setSendFromOrgEmailId(true);
		email.setAttachments(file);
		
		
		try
		{
			
			ContactList getContacts = contactsApi.getContacts(hashMap);
			
			String contactId = getContacts.get(3).getContactId();
		
			Contact create = contactsApi.create(contactName, currencyId);
		
			Contact create1 = contactsApi.create(contacts);
			
			Contact get = contactsApi.get(contactId);
			
			get.setContactName("Sahaya Ramesh");	//No I18N
		
			Contact update = contactsApi.update(get);
		
			String markAsActive = contactsApi.markAsActive(contactId);
		
			String markAsInactive = contactsApi.markAsInactive(contactId);
		
			String enablePaymentReminder = contactsApi.enablePaymentReminder(contactId);
		
			String disablePaymentReminder = contactsApi.disablePaymentReminder(contactId);
		
			String sendEmailStatement = contactsApi.sendEmailStatement(contactId, email, hashMap);
		
			Email getStatementMailContent = contactsApi.getStatementMailContent(contactId, hashMap);
		
			String sendEmailContact = contactsApi.sendEmailContact(contactId, email, hashMap);
		
			CreditnoteRefundList getRefunds = contactsApi.getRefunds(contactId);
		
			CommentList getComments = contactsApi.getComments(contactId);
		
			String track1099 = contactsApi.track1099(contactId);
		
			String untrack1099 = contactsApi.untrack1099(contactId);
		
		
			
			ContactPersonList getContactPersons = contactPersonsApi.getContactPersons(contactId);
			
			String contactPersonId = getContactPersons.get(0).getContactPersonId();
			
			ContactPerson createContactPerson = contactPersonsApi.create(contactPersons1);
		
			ContactPerson getContactPerson = contactPersonsApi.get(contactId, contactPersonId);
			
			getContactPerson.setIsPrimaryContact(true);	
		
			ContactPerson updateContactPerson = contactPersonsApi.update(getContactPerson);
		
			String markAsPrimaryContactPerson = contactPersonsApi.markAsPrimaryContactPerson(contactPersonId);
		
			String deleteContactPerson = contactPersonsApi.delete(contactPersonId);
			
			
			String delete = contactsApi.delete(contactId);
		
			//System.out.println(create1.getContactPersons().get(0).isPrimaryContact());
			
		
		}
		catch(BooksException be)
		{
			//System.out.println("Code : "+be.getCode()+",  Message : "+be.getMessage());
			throw be;
		}
		catch(Exception e)
		{
		
			throw e;
		}
		
	}
}
