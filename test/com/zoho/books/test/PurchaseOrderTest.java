/* $Id$ */

package com.zoho.books.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.zoho.books.api.PurchaseOrderApi;
import com.zoho.books.exception.BooksException;
import com.zoho.books.model.Address;
import com.zoho.books.model.Comment;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.Email;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.PurchaseOrder;
import com.zoho.books.model.PurchaseOrderList;
import com.zoho.books.model.TemplateList;

public class PurchaseOrderTest 
{
	
	public static void main(String[] args)throws Exception
	{
		
		PurchaseOrderApi purchaseOrderApi = new PurchaseOrderApi("{access_token}", "{organization_id}");	//No I18N
		
		try 
		{
			
			PurchaseOrderList purchaseOrders = purchaseOrderApi.getPurchaseOrders(null);
			
			String purchaseorderId = purchaseOrders.get(0).getPurchaseorderId();
			
			PurchaseOrder get = purchaseOrderApi.get(purchaseorderId);
			
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			
			purchaseOrder.setDeliveryDate("");
			
			purchaseOrder.setVendorId(get.getVendorId());
			
			Address address = new Address();
			address.setAddress("ZohoCorp");	//No I18N
			address.setCity("Chennai");	//No I18N
			address.setState("TamilNadu");	//No I18N
			address.setCountry("India");	//No I18N
			
			purchaseOrder.setDeliveryAddress(address);
			purchaseOrder.setPurchaseorderNumber("");
			
			List<LineItem> lineItems = new ArrayList<LineItem>();
			
			LineItem lineItem = new LineItem();
			
			lineItem.setLineItemId(get.getLineItems().get(0).getLineItemId());
			
			lineItems.add(lineItem);
			
			purchaseOrder.setLineItems(lineItems);
			
			File file = new File("{Dir_name}/file.jpg");
			
			PurchaseOrder create = purchaseOrderApi.create(null, purchaseOrder, file);
			
			PurchaseOrder update = purchaseOrderApi.update(null, get, file);
			
			String markAsOpen = purchaseOrderApi.markAsOpen(purchaseorderId);
			
			String markAsBilled = purchaseOrderApi.markAsBilled(purchaseorderId);
			
			String cancelPurchaseorder = purchaseOrderApi.cancelAPurchaseorder(purchaseorderId);
			
			Email email = purchaseOrderApi.getEmailContent(purchaseorderId, null);
			
			ArrayList<File> files = new ArrayList<File>();
			files.add(file);
			
			email.setAttachments(files);
			
			String sendEmail = purchaseOrderApi.sendEmail(purchaseorderId, null, email);
			
			String updateBillingAddress = purchaseOrderApi.updateBillingAddress(purchaseorderId, address);
			
			TemplateList getTemplates = purchaseOrderApi.getTemplates();
			
			String templateId = getTemplates.get(0).getTemplateId();
			
			String updateTemplate = purchaseOrderApi.updateTemplate(purchaseorderId, templateId);
			
			
			
			File getAttachment = purchaseOrderApi.getAttachment(purchaseorderId, null);
			
			String addAttachment = purchaseOrderApi.addAttachment(purchaseorderId, file);
			
			String updateAttachment = purchaseOrderApi.updateAttachment(purchaseorderId, null);
			
			String deleteAttachment = purchaseOrderApi.deleteAttachment(purchaseorderId);
			
			
			
			CommentList getComments = purchaseOrderApi.getComments(purchaseorderId);
			
			String commentId = getComments.get(0).getCommentId();
			
			String description = "This is the testing comment";	//No I18N
			
			String expectedDeliveryDate = "2014-11-30";	//No I18N
			
			Comment addComment = purchaseOrderApi.addComment(purchaseorderId, description, expectedDeliveryDate);
			
			Comment updateComment = purchaseOrderApi.updateComment(purchaseorderId, commentId, description, expectedDeliveryDate);
			
			String deleteComment = purchaseOrderApi.deleteComment(purchaseorderId, commentId);
			
			
			
			String delete = purchaseOrderApi.delete(purchaseorderId);
			
			//System.out.println(create);
			
		} 
		catch (BooksException be)
		{
			//System.out.println("Error Code: "+ be.getCode()+" Message: "+be.getMessage());
			throw be;
		}
		
	}

}
