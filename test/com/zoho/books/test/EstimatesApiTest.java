/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.EstimatesApi;

import com.zoho.books.model.Estimate;
import com.zoho.books.model.Address;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Comment;
import com.zoho.books.model.Email;
import com.zoho.books.model.EstimateList;
import com.zoho.books.model.TemplateList;
import com.zoho.books.model.CommentList;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class EstimatesApiTest
{
	public static void main(String[] args)throws Exception
	{
	
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}"); //No I18N
	
		EstimatesApi estimatesApi = service.getEstimatesApi();
		
	
		String customerId = "36991000000041005"; 
	
		String contactPersonId = "36991000000048001"; 
		
		String templateId = "36991000000000203"; 
	
		String description = "This is a testing comment"; //No I18N
	
		String itemName = "Trial";	//No I18N
		
		String estimateIds = "36991000000051005";
		
		boolean show_comment_to_clients = true;
		
		File file1 = new File("{Dir_name}/file.jpg");
		
		ArrayList<File> file = new ArrayList<File>();
		file.add(0, file1);
		
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("filter_by", "Status.All");
		hashMap.put("sort_column", "estimate_number");
		hashMap.put("estimate_ids", estimateIds);
		
		Estimate estimates = new Estimate();
		
		estimates.setEstimateNumber("EST-9"); //No I18N
		//estimates.setTemplateId(templateId);
		estimates.setReferenceNumber("122");
		estimates.setCustomerId(customerId);
		estimates.setDate("2014-02-21");
		estimates.setExchangeRate(0.00);
		estimates.setDiscount(0.00);
		estimates.setNotes("Thanks for your business."); //No I18N
		estimates.setShippingCharge(0.00);
		estimates.setAdjustment(0.00);
		
		String[] contactPersons = {contactPersonId};
		estimates.setContactPersons(contactPersons);
		
		LineItem lineItem = new LineItem();
		lineItem.setItemOrder(1);
		lineItem.setItemId("36991000000035001");
		lineItem.setRate(500.00);
		lineItem.setName("Trial");  //No I18N
		lineItem.setDescription("trial item"); //No I18N
		lineItem.setQuantity(1.00);
		lineItem.setDiscount(0.00);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(0, lineItem);
		
		estimates.setLineItems(lineItems);
		
		
		Email email = new Email();
		String[] str = {"sahaya.ramesh@zohocorp.com"};	//No I18N
		
		email.setToMailIds(str);
		email.setSubject("Payment reminder for Invoice (Invoice#: INV-24)");	//No I18N
		email.setBody("Dear Customer, \nThanks for your business. The invoice INV-24 is attached with this email. You can choose the easy way. Here's an overview of the invoice for your reference. Invoice Overview: Invoice # : INV-24 Date : 24 Sep 2013 Amount : Rs.612.00 It was great working with you. Looking forward to working with you again.\n\n\n\n Regards\nSSR");	//No I18N
		email.setSendFromOrgEmailId(false);
		
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
		
		try
		{
			
			EstimateList getEstimates = estimatesApi.getEstimates(hashMap);
			
			String estimateId = getEstimates.get(0).getEstimateId();
			
			Estimate get = estimatesApi.get(estimateId);
			
			get.setIsDiscountBeforeTax(true);

			Estimate create = estimatesApi.create(customerId, itemName);
	
			Estimate createEstimate = estimatesApi.create(estimates, hashMap);
	
			Estimate update = estimatesApi.update(get, hashMap);
	
			String sendEmail = estimatesApi.sendEmail(estimateId, email);
	
			String sendEmailEstimates = estimatesApi.sendEmailEstimates(hashMap);
	
			Email getEmailContent = estimatesApi.getEmailContent(estimateId, hashMap);
	
			String markAsSent = estimatesApi.markAsSent(estimateId);
	
			String markAsAccepted = estimatesApi.markAsAccepted(estimateId);
	
			String markAsDeclined = estimatesApi.markAsDeclined(estimateId);
	
			File getPdf = estimatesApi.bulkExport(hashMap);
	
			File print = estimatesApi.bulkPrint(hashMap);
	
			String updateBillingAddress = estimatesApi.updateBillingAddress(estimateId, billingAddress);
	
			String updateShippingAddress = estimatesApi.updateShippingAddress(estimateId, shippingAddress);
	
			TemplateList getTemplates = estimatesApi.getTemplates();
	
			String updateTemplate = estimatesApi.updateTemplate(estimateId, templateId);
	
	
	
	
			CommentList getComments = estimatesApi.getComments(estimateId);
			
			String commentId = getComments.get(0).getCommentId();
	
			Comment addComment = estimatesApi.addComment(estimateId, description, show_comment_to_clients);
	
			Comment updateComment = estimatesApi.updateComment(estimateId, commentId, description, show_comment_to_clients);
	
			String deleteComment = estimatesApi.deleteComment(estimateId, commentId);
		
		
			String delete = estimatesApi.delete(estimateId);
		

			//System.out.println(getComments);
		
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
