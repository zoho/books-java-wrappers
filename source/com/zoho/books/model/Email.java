/* $Id$ */

package com.zoho.books.model;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

/**

* This class is used to make an object for email.

*/

public class Email
{
	
	private String[] toMailIds = {};
	private String[] ccMailIds = {};
	private String subject = "";
	private String body = "";
	private boolean sendFromOrgEmailId = false;
	
	private String fileName = "";
	
	private String contactId = "";
	
	private String customerId = "";
	
	private boolean gatewaysConfigured = false;
	private String attachmentName = "";
	
	private ArrayList<File> attachments;
	
	
	private List<Emailtemplate> emailtemplates;
	
	private List<ToContact> toContacts;
	
	private List<FromEmail> fromEmails;
	
	
	
	/**
	
	* set the to mail ids.
	
	* @param toMailIds  Array of email address of the recipients.
	
	*/
	
	public void setToMailIds(String[] toMailIds)throws Exception
	{
		this.toMailIds = toMailIds;
	}
	
	/**
	
	* get the to mail ids.
	
	* @return Returns array of to mail ids.
	
	*/
	
	public String[] getToMailIds()
	{
		return toMailIds;
	}
	
	/**
	
	* set the cc mail ids.
	
	* @param ccMailIds  Array of email address of the recipients to be cced.
	
	*/
	
	public void setCcMailIds(String[] ccMailIds)throws Exception
	{
		this.ccMailIds = ccMailIds;
	}
	
	/**
	
	* get the to mail ids.
	
	* @return Returns array of cc mail ids.
	
	*/
	
	public String[] getCcMailIds()
	{
		return ccMailIds;
	}
	
	/**
	
	* set the subject of the email.
	
	* @param subject  Subject of the email to be sent.
	
	*/
	
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	/**
	
	* get the subject of the email.
	
	* @return Returns the subject of the email.
	
	*/
	
	public String getSubject()
	{
		return subject;
	}
	
	/**
	
	* set the body of the email.
	
	* @param body  Message body of the email to be sent.
	
	*/
	
	public void setBody(String body)
	{
		this.body = body;
	}
	
	/**
	
	* get the body of the email.
	
	* @return Returns the body of the email.
	
	*/
	
	public String getBody()
	{
		return body;
	}
	
	/**
	
	* set send from org email id.
	
	* @param sendFromOrgEmailId  Boolean to trigger the email from the organization's email address.
	
	*/
	
	public void setSendFromOrgEmailId(boolean sendFromOrgEmailId)
	{
		this.sendFromOrgEmailId = sendFromOrgEmailId;
	}
	
	/**
	
	* get send from org email id.
	
	* @return Returns true if the email is sent from the org email id else returns false.
	
	*/
	
	public boolean sendFromOrgEmailId()
	{
		return sendFromOrgEmailId;
	}
	
	
	
	/**
	
	* set the file name.
	
	* @param fileName  Name of the file that has been attached to the email.
	
	*/
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	
	* get the file name.
	
	* @return Returns the file name that has been attached to the email.
	
	*/
	
	public String getFileName()
	{
		return fileName;
	}
	
	
	/**
        
        * set the contact id.
        
        * @param contactId  ID of the contact.
        
        */
        
        public void setContactId(String contactId)
        {
        	this.contactId = contactId;
        }
        
        /**
        
        * get the contact id.
        
        * @return Returns the contact id.
        
        */
        
        public String getContactId()
        {
        	return contactId;
        }
        
        
        
        /**
        
        * set the customer id.
        
        * @param customerId  ID of the customer.
        
        */
        
        public void setCustomerId(String customerId)
        {
        	this.customerId = customerId;
        }
        
        /**
        
        * get the customer id.
        
        * @return Returns the customer id.
        
        */
        
        public String getCustomerId()
        {
        	return customerId;
        }
        
        
        /**
	
	* set gateways configured.
	
	* @param gatewaysConfigured  To specify the gatewyas configured to the invoice or not.
	
	*/
	
	public void setGatewaysConfigured(boolean gatewaysConfigured)
	{
		this.gatewaysConfigured = gatewaysConfigured;
	}
	
	/**
	
	* get gateways configured.
	
	* @return Returns true if the gateways configured to the invoice else returns false.
	
	*/
	
	public boolean gatewaysConfigured()
	{
		return gatewaysConfigured;
	}
	
	
	/**
	
	* set the attachment name.
	
	* @param attachmentName  Name of the attached file associated with the invoice.
	
	*/
	
	public void setAttachmentName(String attachmentName)
	{
		this.attachmentName = attachmentName;
	}
	
	/**
	
	* get the attachment name.
	
	* @return Returns the name of the attached file associated with the invoice.
	
	*/
	
	public String getAttachmentName()
	{
		return attachmentName;
	}
        
        
        /**
	
	* set the attachments.
	
	* @param attachments  Attached files associated with the invoice.
	
	*/
        
        public void setAttachments(ArrayList<File> attachments)
        {
        	this.attachments = attachments;
        }
        
        /**
	
	* get the attachments.
	
	* @return Returns ArrayList of files.
	
	*/
        
        public ArrayList<File> getAttachments()
        {
        	return attachments;
        }
        
        
	
	/**
	
	* set the email templates.
	
	* @param emailtemplates  Email templates for an invoice.
	
	*/
	
	public void setEmailtemplates(List<Emailtemplate> emailtemplates)throws Exception
	{
		this.emailtemplates = emailtemplates;
	}
	
	/**
	
	* get the email templates.
	
	* @return Returns list of Emailtemplate object.
	
	*/
	
	public List<Emailtemplate> getEmailtemplates()
	{
		return emailtemplates;
	}
	
	
	
	
	/**
	
	* set the to contacts.
	
	* @param toContacts  To contacts for an invoice.
	
	*/
	
	public void setToContacts(List<ToContact> toContacts)throws Exception
	{
		this.toContacts = toContacts;
	}
	
	/**
	
	* get the to contacts.
	
	* @return Returns list of ToContact object.
	
	*/
	
	public List<ToContact> getToContacts()
	{
		return toContacts;
	}
	
	
	
	
	/**
	
	* set the from emails.
	
	* @param fromEmails  From emails for an invoice.
	
	*/
	
	public void setFromEmails(List<FromEmail> fromEmails)throws Exception
	{
		this.fromEmails = fromEmails;
	}
	
	/**
	
	* get the from emails.
	
	* @return Returns list of FromEmail object.
	
	*/
	
	public List<FromEmail> getFormEmails()
	{
		return fromEmails;
	}
	
	
	
	/**
	
	* Convert Email object into JSONObject.
	
	* @return Returns a JSONObject.
	
	*/
	
	public JSONObject toJSON()throws Exception
	{	
		JSONObject jsonObject = new JSONObject();
		
		if(toMailIds != null)
		{
			JSONArray toMailId = new JSONArray();
			
			for(int i = 0; i < toMailIds.length; i++)
			{
				toMailId.put(toMailIds[i]);
			}
			jsonObject.put("to_mail_ids", toMailId);
		}
		
		if(ccMailIds != null)
		{
			JSONArray ccMailId = new JSONArray();
			
			for(int j = 0; j < ccMailIds.length; j++)
			{
				ccMailId.put(ccMailIds[j]);
			}
			jsonObject.put("cc_mail_ids", ccMailId);
		}
		
		jsonObject.put("subject", subject);
		jsonObject.put("body", body);
		if((Boolean)sendFromOrgEmailId != null)
		{
			jsonObject.put("send_from_org_email_id", sendFromOrgEmailId);
		}
		
		return jsonObject;
	}
	
}
