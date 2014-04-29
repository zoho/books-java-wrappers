/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;
import com.zoho.books.util.BooksUtil;

import com.zoho.books.parser.CreditNoteParser;

import com.zoho.books.model.CreditNote;
import com.zoho.books.model.CreditNoteList;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.Address;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Email;
import com.zoho.books.model.CreditnoteRefund;
import com.zoho.books.model.Comment;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.TemplateList;
import com.zoho.books.model.CreditnoteRefundList;
import com.zoho.books.model.InvoiceList;
import com.zoho.books.model.EmailHistoryList;
import com.zoho.books.model.InvoicesCreditedList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

import org.json.JSONObject;
import org.json.JSONArray;

/**

* CreditNotesApi is used to create a new credit note for a customer.

* It is used to get:<br><br>

	The list of credit notes.<br>
	
	The details of a credit note.<br>
	
	The email history of a credit note.<br>
	
	The email content of a credit note.<br>
	
	The list of credit note templates.<br>
	
	The list of invoice credits.<br>
	
	The list of credit note refunds.<br>
	
	The list of refunds of a credit note.<br>
	
	The details of a credit note refund.<br>

	The list of credit note comments.<br><br>
	
* It is used to:<br><br>

	Send an email to a customer.<br>
	
	Apply credit note to an invoice.<br>
	
	Add a creditnote refund.<br>
	
	Add a comment for the credit note.<br><br>
	
* It is used to update:<br><br>

	The details of a credit note.<br>
	
	The billing address of a credit note.<br>
	
	The shipping address of a credit note.<br>
	
	The pdf template of a credit note.<br>
	
	The details of a credit note refund. <br><br>
	
* It is used to change the status:<br><br>

	Mark a credit note status to open.<br>
	
	Mark a credit note as void.<br><br>
	
* It is used to delete:<br><br>

	The existing credit note.<br>
	
	The credits applied to an invoice.<br>
	
	The credit note refund.<br>
	
	The credit note comment.<br>
 

*/

public class CreditNotesApi
{
	
	
	private static String url = BooksUtil.baseURL+"/creditnotes"; //No I18N

	private String authToken;
	private String organizationId;
	
	/**
	
	* Construct a new CreditNotesApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public CreditNotesApi(String authToken, String organizationId)
	{
		this.authToken = authToken;
		this.organizationId = organizationId;
	}
	
	
	private CreditNoteParser creditNoteParser = new CreditNoteParser();
	
	
	
	
	
	/**
	
	* Create a credit note for a customer.
	
	* Pass the customerId, accountId, and itemName to create a new Credit note for a customer.
	
	* It returns the CreditNote object.
	
	
	* @param customerId ID of the customer the credit note has to be created.
	
	* @param accountId ID of the account, the line item is associated with.
	
	* @param itemName Name of the line item.
	
	* @return Returns the CreditNote object.
	
	*/
	
	public CreditNote create(String customerId, String accountId, String itemName)throws Exception
	{
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		CreditNote creditNote = new CreditNote();
		
		creditNote.setCustomerId(customerId);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		
		LineItem lineItem = new LineItem();
		
		lineItem.setAccountId(accountId);
		lineItem.setName(itemName);
		
		lineItems.add(0, lineItem);
		
		creditNote.setLineItems(lineItems);
		
		
		requestBody.put("JSONString", creditNote.toJSON().toString());
		
		String resp = ZohoHTTPClient.post(url, requestBody);
		
		return creditNoteParser.getCreditNote(resp);
	}
	
	
	
	/**
	
	* Create a credit note for a customer.
	
	* Pass the CreditNote object and query string to create a new credit note for a customer.<br>
	
	* The paramMap contains the possible keys as mentioned below:<br><br>
	
		invoice_id - Create a credit note and apply it to an invoice.<br>
		
		ignore_auto_number_generation - Ignore auto number generation for this credit note only. To enable this option credit note number is mandatory.<br><br>
		
	* It returns the CreditNote object.
	
	
	
	* @param creditNote CreditNote object.
	
	* @param paramMap It contains the query string in the form of key-value pair.
	
	* @return Returns the CreditNote object.
	
	*/
	
	public CreditNote create(CreditNote creditNote, HashMap paramMap)throws Exception
	{	
	
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		paramMap.put("JSONString", creditNote.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, paramMap);
		
		return creditNoteParser.getCreditNote(response);
	} 
	
	
	/**
	
	* Get details of a credit note.
	
	* Pass the creditNoteId to get the details of a credit note.
	
	* It returns the CreditNote object.
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @return Returns the CreditNote object.
	
	*/
	
	
	public CreditNote get(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId;
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CreditNote creditNote = creditNoteParser.getCreditNote(response);
		
		return creditNote;
	}
	
	/**
	
	* Update an existing credit note.
	
	* Pass the CreditNote object and query string parameters to update the details of a credit note.
	
	* The paramMap contains the possible key as mentioned below: <br><br>
	
		ignore_auto_number_generation - Allow editing of credit note number.<br><br>
		
	* The CreditNote object which contains creditNoteId is the mandatory parameter for which credit note details has to be updated.
	
	* It returns the CreditNote object.
	
	
	* @param creditNote CreditNote object.
	
	* @param paramMap It contains the parameters in the form of key-value pair.
	
	* @return Returns a CreditNote object.
	
	*/
	
	public CreditNote update(CreditNote creditNote, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+creditNote.getCreditnoteId();
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		paramMap.put("JSONString", creditNote.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, paramMap);
		
		return creditNoteParser.getCreditNote(response);
		
	}	
	
	/**
	
	* Delete a credit note.
	
	* Pass the creditNoteId to delete a credit note.
	
	* If the credit note has been deleted it returns the success message.
	
	* The success message is "The credit note has been deleted."
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId;
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List credit notes with pagination.
	
	* Pass the filters in the form of key-value pair to get all the credit notes based on the filter.
	
	* It returns the CreditNoteList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
	
				<tr><td>creditnote_number</td><td>Search credit notes by credit note number.<br>
Variants: <i>creditnote_number_startswith</i> and <i>creditnote_number_contains</i></td></tr>
		
				<tr><td>date</td><td>Search credit notes by credit note date.<br>
Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
		
				<tr><td>total</td><td>Search credit notes by credit note total amount.<br>
Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>
		
				<tr><td>reference_number</td><td>Search credit notes by credit note reference number.<br>
Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
		
				<tr><td>customer_name</td><td>Search credit notes by customer name.<br>
Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
		
				<tr><td>item_name</td><td>Search credit notes by item name.<br>
Variants: <i>item_name_startswith</i> and <i>item_name_contains</i></td></tr>
		
				<tr><td>item_description</td><td>Search credit notes by credit note item description.<br>
Variants: <i>item_description_startswith</i> and <i>item_description_contains</i></td></tr>
		
				<tr><td>customer_id</td><td>Search credit notes by customer id.</td></tr>
		
				<tr><td>line_item_id</td><td>Search credit notes by credit note line item id.</td></tr>
		
				<tr><td>item_id</td><td>Search credit notes by item id.</td></tr>
		
				<tr><td>tax_id</td><td>Search credit notes by tax id.</td></tr>
		
				<tr><td>search_text</td><td>Search credit notes by credit note number or customer name or credit note reference number.</td></tr>
		
				<tr><td>status</td><td>Search credit notes by credit note status. Allowed statuses are draft,open,closed and void.<br>
Allowed Values: <i>open, closed</i> and <i>void</i></td></tr>
		
				<tr><td>filter_by</td><td>Filter credit notes by statuses.<br>
Allowed Values: <i>Status.All, Status.Open, Status.Draft, Status.Closed</i> and <i>Status.Void</td></tr>
		
				<tr><td>sort_column</td><td>Sort credit notes by following columns customer_name, creditnote_number, balance, total, date and created_time.<br>
Allowed Values: <i>customer_name, creditnote_number, balance, total, date</i> and <i>created_time</i></td></tr>
		
			</tbody>
			
		</table>
		
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the CreditNoteList object.
	
	*/
	
	public CreditNoteList getCreditNotes(HashMap queryMap)throws Exception
	{
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
			
		String response = ZohoHTTPClient.get(url, queryMap);	
		
		CreditNoteList creditNoteList = creditNoteParser.getCreditNotes(response);
		
		return creditNoteList;
	}
	
	
	/**
	
	* Email a credit note to the customer.
	
	* Pass the creditNoteId, Email object and query string parameters to send an email credit note to a customer.
	
	* The paramMap contains the possible key as mentioned below: <br><br>
	
		customer_id - ID of the customer.<br><br>
		
	* If the email has been sent to the customer it returns the success message.
	
	* The success message is "Your credit note has been sent."
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @param paramMap It contains the ID of the customer.
	
	* @param email Email object.
	
	* @return Returns a String.
	
	*/
	
	public String sendEmail(String creditNoteId, Email email, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/email"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("JSONString", email.toJSON().toString());
		
		ArrayList<File> files = email.getAttachments();
		
		HashMap fileBody = new HashMap(files.size());
		
		fileBody.put("attachments", files);
		
		
		String response = ZohoHTTPClient.post(urlString, queryMap, paramMap, fileBody);	
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get email history of a credit note.
	
	* Pass the creditNoteId to get all the email history for the credit note.
	
	* It returns the EmailHistoryList object.
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @return Returns the EmailHistoryList object.
	
	*/
	
	public EmailHistoryList getEmailHistory(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/emailhistory"; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		EmailHistoryList emailHistory = creditNoteParser.getEmailHistory(response);
		
		return emailHistory;
	}
	
	/**
	
	* Get email content of a credit note.
	
	* Pass the creditNoteId and query string parameters to get the email content for the credit note.
	
	* The queryMap contains the possible key as mentioned below:<br><br>
	
		email_template_id - Get the email content based on a specific email template. <br><br>
		
	* It returns the Email object.
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @param queryMap Get the email content based on a specific email template.
	
	* @return Returns the Email object.
	
	*/
	
	public Email getEmailContent(String creditNoteId, HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/email"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);	
		
		Email email = creditNoteParser.getEmailContent(response);
		
		return email;
	}
	
	/**
	
	* Change an existing credit note status to open (A void credit note can't be changed to open).
	
	* Pass the creditNoteId to change the status of a credit note to 'open'.
	
	* If the credit note status has been changed it returns the success message.
	
	* The success message is "The status of the credit note has been changed to open."
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @return Returns a String.
	
	*/
	
	public String convertToOpen(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/status/open"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark an existing credit note as void.
	
	* Pass the creditNoteId to change the status of a credit note to 'void'.
	
	* If the credit note status has been changed it returns the success message.
	
	* The success message is "The credit note has been marked as void."
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @return Returns a String.
	
	*/
	
	public String convertToVoid(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/status/void"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Update the billing address for an existing credit note alone (You can set this address as default billing address for your customer by specifying 'is_update_customer' node as true).
	
	* Pass the creditNoteId and Address object to update the billing address of a credit note.
	
	* If the billing address has been updated it returns the success message.
	
	* The success message is "Billing address updated".
	 
	
	* @param creditNoteId ID of the CreditNote.
	
	* @param billingAddress Address object.
	
	* @return Returns a String.
	
	*/
	
	public String updateBillingAddress(String creditNoteId, Address billingAddress)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/address/billing"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		requestBody.put("JSONString", billingAddress.toJSON().put("is_update_customer", billingAddress.isUpdateCustomer()).toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Update the shipping address for an existing credit note alone (You can set this address as default shipping address for your customer by specifying 'is_update_customer' node as true).
	
	* Pass the creditNoteId and Address object to update the shipping address of a credit note.
	
	* If the shipping address has been updated it returns the success message.
	
	* The success message is "Shipping address updated".
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @param shippingAddress Address object.
	
	* @return Returns a String.
	
	*/
	
	public String updateShippingAddress(String creditNoteId, Address shippingAddress)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/address/shipping"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		

		requestBody.put("JSONString", shippingAddress.toJSON().put("is_update_customer", shippingAddress.isUpdateCustomer()).toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get all credit note pdf templates.
	
	* It returns the TemplateList object.
	
	
	* @return Returns the TemplateList object.
	
	*/
	
	public TemplateList getTemplates()throws Exception
	{
		
		String urlString = url+"/templates"; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		TemplateList templateList = creditNoteParser.getTemplates(response);
		
		return templateList;
	}
	
	/**
	
	* Update the pdf template associated with the credit note.
	
	* Pass the creditNoteId and templateId to update the respective template for the credit note.
	
	* If the template has been updated it returns the success message.
	
	* The success message is "The credit note has been updated."
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @param templateId ID of the template.
	
	* @return Returns a String.
	
	*/
	
	public String updateTemplate(String creditNoteId, String templateId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/templates/"+templateId; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
		
	}
	
	
//===========================================================================================================================================


	
	/**
	
	* Apply credit note to existing invoices.
	
	* Pass the creditNoteId and list of Invoice objects to apply the credit to invoice.
	
	* It returns the InvoiceList object.
	 
	
	* @param creditNoteId  ID of the CreditNote.
	
	* @param invoice  List of Invoice object.
	
	* @return Returns the InvoiceList object. 
	
	*/
	
	public InvoiceList creditToInvoice(String creditNoteId, List<Invoice> invoice)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/invoices"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		
		JSONArray invoices = new JSONArray();
		
		for(int i = 0; i < invoice.size(); i++)
		{
			JSONObject invoic = new JSONObject();
			
			invoic.put("invoice_id", invoice.get(i).getInvoiceId());
			invoic.put("amount_applied", invoice.get(i).getAmountApplied());
			
			invoices.put(invoic);
		}
		
		jsonObject.put("invoices", invoices);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		return creditNoteParser.getCreditToInvoice(response);
		
	}
	
	/**
	
	* List invoices to which the credit note is applied.
	
	* Pass the creditNoteId to get the invoices credited list.
	
	* It returns the InvoicesCreditedList object.
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @return Returns the InvoicesCreditedList object.
	
	*/
	
	public InvoicesCreditedList getInvoicesCredited(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/invoices"; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response  = ZohoHTTPClient.get(urlString, queryMap);
		
		InvoicesCreditedList invoicesCredited = creditNoteParser.getInvoicesCredited(response);
		
		return invoicesCredited;
			
	}
	
	/**
	
	* Delete the credits applied to an invoice.
	
	* Pass the creditNoteId and creditNoteInvoiceId to delete the invoices credited for the credit note.
	
	* If the credited invoices has been deleted it returns the success message.
	
	* The success message is "Credits applied to an invoice have been deleted."
	
	
	* @param creditNoteId ID of the CreditNote.
	
	* @param creditnoteInvoiceId ID of the invoice, the credit note is being applied.
	
	* @return Returns a String.
	
	*/
	
	public String deleteInvoicesCredited(String creditNoteId, String creditnoteInvoiceId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/invoices/"+creditnoteInvoiceId; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	
//=========================================================================================================================================



	/**
	
	* Refund credit note amount.
	
	* Pass the creditNoteId, CreditnoteRefund object to add the refund amount for the credit note.
	
	* The CreditnoteRefund object which contains date and amount are the mandatory parameters.
	
	* It returns the CreditnoteRefund object.
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @param creditnoteRefund CreditnoteRefund object.
	
	* @return Returns the CreditnoteRefund object.
	
	*/
	
	public CreditnoteRefund addRefund(String creditNoteId, CreditnoteRefund creditnoteRefund)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/refunds"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		requestBody.put("JSONString", creditnoteRefund.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		return creditNoteParser.getCreditnoteRefund(response);
	}
	
	/**
	
	* Get refund of a particular credit note.
	
	* Pass creditNoteId and creditnoteRefundId to get all the refunds for the credit note.
	
	* It returns the CreditnoteRefund object.
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @param creditnoteRefundId ID of the Creditnote refund.
	
	* @return Returns the CreditnoteRefund object.
	
	*/
	
	public CreditnoteRefund getRefund(String creditNoteId, String creditnoteRefundId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/refunds/"+creditnoteRefundId; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CreditnoteRefund creditnoteRefund = creditNoteParser.getCreditnoteRefund(response);
		
		return creditnoteRefund;	
		
	}
	
	/**
	
	* Update the refunded transaction.
	
	* Pass the creditNoteId and CreditnoteRefund object to update the details of a creditnote refund.
	
	* The CreditnoteRefund object which contains creditnoteRefundId is the mandatory parameter.
	
	* It returns the CreditnoteRefund object.
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @param creditnoteRefund CreditnoteRefund object.
	
	* @return Returns the CreditnoteRefund object.
	
	*/
	
	public CreditnoteRefund updateRefund(String creditNoteId, CreditnoteRefund creditnoteRefund)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/refunds/"+creditnoteRefund.getCreditnoteRefundId(); //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		requestBody.put("JSONString", creditnoteRefund.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		return creditNoteParser.getCreditnoteRefund(response);
	}
	
	/**
	
	* Delete a credit note refund.
	
	* Pass the creditNoteId and creditnoteRefundId to delete the creditnote refund.
	
	* If the creditnote refund has been deleted it returns the success message.
	
	* The success message is "The refund has been successfully deleted."
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @param creditnoteRefundId ID of the credintnote refund.
	
	* @return Returns a String.
	
	*/
	
	public String deleteRefund(String creditNoteId, String creditnoteRefundId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/refunds/"+creditnoteRefundId; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List all refunds of an existing credit note.
	
	* Pass the creditNoteId to get all the creditnote refunds for the credit note.
	
	* It returns the CreditnoteRefundList object.
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @return Returns the CreditnoteRefundList object.
	
	*/
	
	public CreditnoteRefundList getRefundsOfCreditnotes(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/refunds"; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CreditnoteRefundList creditnoteRefundList = creditNoteParser.getRefunds(response);
		
		return creditnoteRefundList;	
	}
	
	/**
	
	* List all refunds with pagination.
	
	* Pass the filters to get all the refunds based on the filter.
	
	* It returns the CreditnoteRefundList object. <br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br>
	
		<table border = "1">
			
			<tbody>
	
				<tr><td>customer_id</td><td>List credit note refunds made for a particular customer.</td></tr>
	
				<tr><td>sort_column</td><td>Sort refunds list. <br>
Allowed Values: <i>refund_mode, reference_number, date, creditnote_number, customer_name, amount_bcy</i> and <i>amount_fcy</i></td></tr>
			
			</tbody>
			
		</table>
	
	
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the CreditnoteRefundList object.
	
	*/
	
	public CreditnoteRefundList getCreditnoteRefunds(HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/refunds"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CreditnoteRefundList creditnoteRefundList = creditNoteParser.getRefunds(response);
		
		return creditnoteRefundList;	
	}
	
	
//======================================================================================================================================

	
	
	/**
	
	* Add a comment to an existing credit note.
	
	* Pass the creditNoteId and description to add a comment for the credit note.
	
	* It returns the Comment object.
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @param description Description for the refund recorded.
	
	* @return Returns the Comment object.
		
	*/
	
	public Comment addComment(String creditNoteId, String description)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/comments"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("description", description);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		Comment comment = creditNoteParser.getComment(response);
		
		return comment;
	}
	
	/**
	
	* Get history and comments of a credit note.
	
	* Pass the creditNoteId to get all the comments for the credit note.
	
	* It returns the CommentList object.
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @return Returns the CommentList object.
	
	*/
	
	public CommentList getComments(String creditNoteId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/comments"; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CommentList commentList = creditNoteParser.getComments(response);
		
		return commentList;
	} 
	
	
	/**
	
	* Delete a credit note comment.
	
	* Pass the creditNoteId and commentId to delete the comment for the credit note.
	
	* If the comment has been deleted it returns the success message.
	
	* The success message is "The comment has been deleted."
	
	
	* @param creditNoteId ID of the creditnote.
	
	* @param commentId ID of the Comment.
	
	* @return Returns a String.
	
	*/
	
	public String deleteComment(String creditNoteId, String commentId)throws Exception
	{
		
		String urlString = url+"/"+creditNoteId+"/comments/"+commentId; //No I18N
		 
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = creditNoteParser.getMessage(response);
		
		return success;
	}
	
	
	
	
}
