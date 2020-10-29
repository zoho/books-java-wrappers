/* $Id$ */

package com.zoho.books.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.zoho.books.api.SalesOrderApi;
import com.zoho.books.exception.BooksException;
import com.zoho.books.model.Address;
import com.zoho.books.model.Comment;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.Email;
import com.zoho.books.model.SalesOrder;
import com.zoho.books.model.SalesOrderList;
import com.zoho.books.model.TemplateList;

public class SalesOrderTest 
{
	
	public static void main(String[] args)throws Exception 
	{
		
		SalesOrderApi salesOrderApi = new SalesOrderApi("{access_token}", "{organization_id}");	//No I18N
		
		try
		{
		
			SalesOrderList getSalesOrders = salesOrderApi.getSalesOrders(null);
			
			String salesorderId = getSalesOrders.get(0).getSalesorderId();
			
			SalesOrder get = salesOrderApi.get(salesorderId, null);
			
			Address address = new Address();
			address.setAddress("ZohoCorp");	//No I18N
			address.setCity("Chennai");	//No I18N
			address.setCountry("India");	//No I18N
			address.setState("TamilNadu");	//No I18N
			
			get.setBillingAddress(address);
			get.setShippingAddress(address);
			
			SalesOrder create = salesOrderApi.create(null, get);
			
			SalesOrder update = salesOrderApi.update(null, get);
			
			String markAsOpen = salesOrderApi.markAsOpen(salesorderId);
			
			String markAsVoid = salesOrderApi.markAsVoid(salesorderId);
			
			Email emailContent = salesOrderApi.getEmailContent(salesorderId, null);
			
			File file = new File("{Dir_name}/file.jpg");
			
			ArrayList<File> files = new ArrayList<File>();
			files.add(file);
			
			emailContent.setAttachments(files);
			
			String sendEmail = salesOrderApi.sendEmail(salesorderId, null, emailContent);
			
			HashMap<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("salesorder_ids", salesorderId);
			
			File bulkExport = salesOrderApi.bulkExport(queryMap);
			
			File bultPrint = salesOrderApi.bulkPrint(queryMap);
			
			String updateBillingAddress = salesOrderApi.updateBillingAddress(salesorderId, address);
			
			String updateShippingAddress = salesOrderApi.updateShippingAddress(salesorderId, address);
			
			TemplateList templates = salesOrderApi.getTemplates();
			
			String templateId = templates.get(0).getTemplateId();
			
			String updateTemplate = salesOrderApi.updateTemplate(salesorderId, templateId);
			
			String delete = salesOrderApi.delete(salesorderId);
			
			
			
			
			File getAttachment = salesOrderApi.getAttachment(salesorderId, null);
			
			String addAttachment = salesOrderApi.addAttachment(salesorderId, null, file);
			
			String updateAttachment = salesOrderApi.updateAttachment(salesorderId, null);
			
			String deleteAttachment = salesOrderApi.deletAttachment(salesorderId);
			
			
			
			CommentList getComments = salesOrderApi.getComments(salesorderId);
			
			String description = "This is the test comment.";	//No I18N
			
			Comment addComment = salesOrderApi.addComment(salesorderId, description);
			
			String commentId = getComments.get(0).getCommentId();
			
			Comment updateComment = salesOrderApi.updateComment(salesorderId, commentId, description);
			
			String deleteComment = salesOrderApi.deleteComment(salesorderId, commentId);
			
			
			//System.out.println(deleteComment);
			
		}
		catch (BooksException be)
		{
			//System.out.println("Error Code: "+ be.getCode()+" Message: "+be.getMessage());
			
			throw be;
		}
			
	}

}
