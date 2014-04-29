/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;
import com.zoho.books.util.BooksUtil;

import com.zoho.books.parser.InvoiceParser;

import com.zoho.books.model.Invoice;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Address;
import com.zoho.books.model.Email;
import com.zoho.books.model.InvoicePayment;
import com.zoho.books.model.ApplyCreditnote;
import com.zoho.books.model.Credit;
import com.zoho.books.model.Comment;
import com.zoho.books.model.Contact;
import com.zoho.books.model.InvoiceList;
import com.zoho.books.model.TemplateList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.PaymentList;
import com.zoho.books.model.CreditList;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;

/**
	
* InvoicesApi is used to create a new invoice for the customer.

* It is used to get:<br><br>

	The list of all invoices.<br>
	
	The details of an invoice.<br>
	
	The invoice email content.<br>
	
	The payment reminder email content.<br>
	
	The invoices as pdf.<br>
	
	The invoice templates.<br>
	
	The list of invoice payments.<br>
	
	The list of credits applied for an invoice.<br>
	
	The invoice attachment.<br>
	
	The list of comments for an invoice.<br><br>
	
* It is used to update:<br><br>

	The details of an invoice.<br>
	
	The billing address of an invoice.<br>
	
	The shipping address of an invoice.<br>
	
	The templates of an invoice.<br>
	
	The attachment preference of an invoice.<br>
	
	The comment of an invoice.<br><br>
	
* It is used to change the status:<br><br>

	Mark an invoice as sent.<br>
	
	Mark an invoice as void.<br>
	
	Mark an invoice as draft.<br>
	
	Enable payment reminder for an invoice.<br>
	
	Disable payment reminder for an invoice.<br>
	
	Write off the invoice balance amount of an invoice.<br>
	
	Cancel write off amount of an invoice.<br><br>
	
* It is used to send:<br><br>

	Invoice to your customer by email.<br>
	
	Invoices to your customers by email.<br>
	
	Reminder to your customer by email.<br>
	
	Reminder to your multiple customers by email.<br><br>
	
* It is used to:<br><br>

	Apply creditnotes to an invoice.<br>
	
	Attach a file to an invoice.<br>
	
	Add a comment for an invoice.<br><br>
	
* It is used to delete:<br><br>

	The existing invoice.<br>
	
	The payment made to an invoice.<br>
	
	The credit particularly applied to an invoice.<br>
	
	The file attached to an invoice.<br>
	
	The expense receipts attached to an invoice.<br>
	
	The comment to an invoice.<br>
	
	

*/

public class InvoicesApi
{
	
	private static String url = BooksUtil.baseURL+"/invoices"; //No I18N

	private String authToken;
	private String organizationId;
	
	/**
	
	* Construct a new InvoicesApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public InvoicesApi(String authToken, String organizationId)
	{
		this.authToken = authToken;
		this.organizationId = organizationId;
	}
	
	
	
	private InvoiceParser invoiceParser = new InvoiceParser();
	
	
	/**
	
	* Get list of invoices.
	
	* Pass the filters in the form of key-value pair to get all the invoices based on the filters.
	
	* It returns the InvoiceList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
		
				<tr><td>invoice_number</td><td>Search invoices by invoice number.<br>
Variants: <i>invoice_number_startswith</i> and <i>invoice_number_contains</i></td></tr>
		
				<tr><td>item_name</td><td>Search invoices by item name.<br>
Variants: <i>item_name_startswith</i> and <i>item_name_contains</i></td></tr>
		
				<tr><td>item_id</td><td>Search invoices by item id.</td></tr>
		
				<tr><td>item_description</td><td>Search invoices by item description.<br>
Variants: <i>item_description_startswith</i> and <i>item_description_contains</i></td></tr>
		
				<tr><td>reference_number</td><td>Search invoices by invoice reference number (i.e., P.O.#).<br>
Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
		
				<tr><td>customer_name</td><td>Search invoices by customer name.<br>
Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
		
				<tr><td>recurring_invoice_id</td><td>Search invoices by recurring profile id.</td></tr>
		
				<tr><td>email</td><td>Search invoices by customer contact persons email.</td></tr>
		
				<tr><td>total</td><td>Search invoices by invoice total.<br>
Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>
		
				<tr><td>balance</td><td>Search invoices by invoice total.<br>
Variants: <i>balance_less_than, balance_less_equals, balance_greater_than</i> and <i>balance_greater_equals</i></td></tr>
		
				<tr><td>date</td><td>Search invoices by invoice date.<br>
Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
		
				<tr><td>due_date</td><td>Search invoices by due date.<br>
Variants: <i>due_date_start, due_date_end, due_date_before</i> and <i>due_date_after</i></td></tr>
		
				<tr><td>status</td><td>Search invoices by invoice status.<br>
Allowed Values: <i>sent, draft, overdue, paid, void, unpaid, partiallypaid</i> and <i>viewed</i></td></tr>
		
				<tr><td>customer_id</td><td>Search invoices by customer id.</td></tr>
		
				<tr><td>custom_field</td><td>Search invoices by custom fields.<br>
Variants: <i>custom_field_startswith</i> and <i>custom_field_contains</i></td></tr>
		
				<tr><td>search_text</td><td>Search invoices by invoice number or purchase order or customer name.</td></tr>
		
				<tr><td>filter_by</td><td>Filter invoices by any status or payment expected date.<br>
Allowed Values: <i>Status.All, Status.Sent, Status.Draft, Status.OverDue, Status.Paid, Status.Void, Status.Unpaid, Status.PartiallyPaid, Status.Viewed</i> and <i>Date.PaymentExpectedDate</i> </td></tr>
		
				<tr><td>sort_column</td><td>Sort invoices.<br>
Allowed Values: <i>customer_name, invoice_number, date, due_date, total, balance</i> and <i>created_time</i></td></tr>
				
			</tbody>
			
		</table>
		
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the InvoiceList object.
	
	*/
	
	public InvoiceList getInvoices(HashMap queryMap)throws Exception
	{
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(url, queryMap);
		
		InvoiceList invoiceList = invoiceParser.getInvoices(response);
		
		return invoiceList;
	}
	
	/**
	
	* Create an invoice for your customer.
	
	* Pass the customerId, contactPersonId, and description to create a new invoice.
	
	* It returns the Invoice object.
	
	
	* @param customerId ID of the customer for whom the invoice has to be created.
	
	* @param contactPersonId ID of the contact person for whom invoice has to be sent.
	
	* @param description Description of the line item.
	
	* @return returns the Invoice object.
	
	*/
	
	public Invoice create(String customerId, String contactPersonId, String description)throws Exception
	{	
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		Invoice invoiceObj = new Invoice();
		
		invoiceObj.setCustomerId(customerId);
		
		String[] contactPersons = {contactPersonId};
		
		invoiceObj.setContactPersons(contactPersons);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		
		LineItem lineItem = new LineItem();
		
		lineItem.setDescription(description);
		
		lineItems.add(0, lineItem);
		
		invoiceObj.setLineItems(lineItems);
		
		
		requestBody.put("JSONString", invoiceObj.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		Invoice invoice = invoiceParser.getInvoice(response);
		
		return invoice;
	}
	
	/**
	
	* Create an invoice for your customer.
	
	* Pass the Invoice object to create a new invoice for your customer.
	
	* Pass Invoice object and query string parameters to create a new invoice.<br>
	
	* The possible keys and values are mentioned below:<br><br>
	
		send - Send the invoice to the contact person(s) associated with the invoice.
Allowed Values: true and false <br>

		ignore_auto_number_generation - Ignore auto invoice number generation for this invoice. This mandates the invoice number.
Allowed Values: true and false <br><br>
	
	* The Invoice object which contains customerId, contactPersonId, and description are the mandatory parameters.
	
	* It returns the Invoice object.
	 
	
	* @param newInvoice Invoice object.
	
	* @param paramMap It contains the parameter values in the form of key-value pair.
	
	* @return Returns the Invoice object.
	
	*/
	
	public Invoice create(Invoice newInvoice, HashMap paramMap)throws Exception
	{
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		paramMap.put("JSONString", newInvoice.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, paramMap);
		
		Invoice invoice = invoiceParser.getInvoice(response);
		
		return invoice;
	}
	
	/**
	
	* Get the details of an invoice.
	
	* Pass the invoiceId to get the details of a particular invoice.
	
	* It returns the Invoice object.
	
	
	* @param invoiceId ID of an invoice.
	
	* @return Returns an Invoice object.
	
	*/
	
	public Invoice get(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId;
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Invoice invoice = invoiceParser.getInvoice(response);
		
		return invoice;
	}
	
	/**
	
	* Update an existing invoice (To delete a line item just remove it from the line_items list).
	
	* Pass the Invoice object and query string parameters to update the details of a particular invoice.
	
	* The possible key and value are mentioned below: <br><br>
	
		ignore_auto_number_generation - Ignore auto estimate number generation for this estimate. This mandates the estimate number.<br>
	
	* The Invoice object which contains invoiceId is the mandatory paramter for which invoice has to be updated.
	
	* It returns the Invoice object.
	
	
	* @param newInvoice Invoice object.
	
	* @param paramMap It contains the parameter values in the form of key-value pair.
	
	* @return Returns the Invoice object. 
	
	*/
	
	public Invoice update(Invoice newInvoice, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+newInvoice.getInvoiceId();
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		paramMap.put("JSONString", newInvoice.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, paramMap);
		
		Invoice invoice = invoiceParser.getInvoice(response);
		
		return invoice;
	}
	
	/**
	
	* Delete an existing invoice (Invoices which have payment or credit notes applied cannot be deleted).
	
	* Pass the invoiceId to delete a particular invoice.
	
	* If the invoice has been deleted it returns the success message.
	
	* The success message is "The invoice has been deleted."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId;
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	
	/**
	
	* Email an invoice to the customer (If the Email object is not inputted, mail will be send with default mail content).
	
	* Pass the invoiceId, Email object, and query string paramters to send the email to the customer.
	
	* The possible keys and values are mentioned below: <br><br>
	
		send_customer_statement - Send customer statement pdf a with email.<br>
		
		send_attachment - Send the invoice attachment a with the email.<br><br>
		
	* If the email has been sent to the customer it returns the success message.
	
	* The success message is "Your invoice has been sent."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param email Email object which contains an email content.
	
	* @param paramMap It contains the parameter values in the form of key-value pair.
	
	* @return Returns a String.
	
	*/
	
	public String sendEmail(String invoiceId, Email email, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/email"; //No I18N
		
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
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Send invoices to your customers by email (Maximum of 10 invoices can be sent at once).
	
	* Pass the list of Contact object and query string paramters to send the email to the customers.
	
	* The paramMap contains the possible key as mentioned below: <br><br>
	
		invoice_ids* - Comma separated invoice ids which are to be emailed. <br><br>
		
	* If the email has been sent to the customers it returns the success message.
	
	* The success message is "Mission accomplished! We've sent all the invoices."
	
	
	* @param contacts Contacts for whom email or snail mail has to be sent.
	
	* @param paramMap Comma separated invoice ids which are to be emailed.
	
	* @return Returns a String.
	
	*/
	
	public String sendEmailInvoices(List<Contact> contacts, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/email"; //No I18N
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		JSONObject jsonObject = new JSONObject();
		
		JSONArray contactss = new JSONArray();
		for(int i = 0; i < contacts.size(); i++)
		{
			JSONObject contact = new JSONObject();
			
			contact.put("contact_id", contacts.get(i).getContactId());
			contact.put("email", contacts.get(i).isEmail());
			contact.put("snail_mail", contacts.get(i).isSnailMail());
		
			contactss.put(contact);
		}
		
		jsonObject.put("contacts", contactss);
		
		paramMap.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, paramMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get the email content of an invoice.
	
	* Pass the invoiceId and query string parameters to get the email content of an invoice.
	
	* The queryMap contains the possible key as mentioned below: <br><br>
	
		email_template_id - Get the email content based on a specific email template. <br><br>
	
	* It returns the Email object.
	
	
	* @param invoiceId Id of an Invoice.
	
	* @param queryMap Get the email content based on a specific email template.
	
	* @return Returns an Email object which contains the email content.
	
	*/
	
	public Email getEmailContent(String invoiceId, HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/email"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Email email = invoiceParser.getEmailContent(response);
		
		return email;
	}
	
	
	/**
	
	* Remind your customer about an unpaid invoice by email (Reminder will be sent, only for the invoices which are in open or overdue status).
	
	* Pass the invoiceId, Email object, and query string parameters to send the reminder to the customer.
	
	* The paramMap contains the possible key and value as mentioned below: <br><br>
	
		send_customer_statement - Send customer statement pdf a with payment reminder. <br><br>
		
	* If the reminder has been sent to the customer it returns the success message.
	
	* The success message is "Your payment reminder has been sent."
	 
	
	* @param invoiceId ID of an Invoice.
	
	* @param email Email Object which contains email content.
	
	* @param paramMap It contains the parameter values in the form of key-value pair.
	
	* @return Returns a String. 
	
	*/
	
	public String sendPaymentReminder(String invoiceId, Email email, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/paymentreminder"; //No I18N
		
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
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Remind your customer about an unpaid invoices by email (Reminder mail will be sent, only for the invoices which are in open or overdue status. The customer can be reminded for maximum 10 invoices at once.)
	
	* Pass the query string parameters to send the reminder to the customer.
	
	* The paramMap contains the possible key as mentioned below: <br><br>
	
		invoice_ids* - Comma separated invoice ids which the reminder has to be sent.<br><br>
		
	* If the reminder has been sent to the customer it returns the success message.
	
	* The success message is "Success! All reminders have been sent."
	
	
	* @param paramMap Comma separated invoice ids for which the reminder has to be sent.
	
	* @return Returns a String. 
	
	*/
	
	public String sendBulkInvoiceReminder(HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/paymentreminder"; //No I18N
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, paramMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get the email content of the payment reminder.
	
	* Pass the invoiceId to get the email content of the payment reminder.
	
	* It returns the Email object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns the Email object.
	
	*/
	
	public Email getPaymentReminder(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/paymentreminder"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Email email = invoiceParser.getEmailContent(response);
		
		return email;
	}
	
	/**
	
	* Mark a draft invoice as sent.
	
	* Pass the invoiceId to change the status of an invoice to 'sent'.
	
	* If the invoice status has been changed it returns the success message.
	
	* The success message is "Invoice status has been changed to Sent."
	 
	
	* @param invoiceId Id of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String markAsSent(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/status/sent"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark a void invoice as draft.
	
	* Pass the invoiceId to change the status of an invoice to 'draft'.
	
	* If the invoice status has been changed it returns the success message.
	
	* The success message is "Status of invoice changed from void to draft."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String markAsDraft(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/status/draft"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success; 
	}
	
	/**
	
	* Mark an invoice status as void (Upon void, the payments and credits associated with the invoices will be unassociated and will be under customer credits).
	
	* Pass the invoiceId to change the status of an invoice to 'void'.
	
	* If the invoice status has been changed it returns the success message.
	
	* The success message is "Invoice status has been changed to void."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String markAsVoid(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/status/void"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;  
	}
	
	/**
	
	* Maximum of 25 invoices can be exported in a single pdf.
	
	* Pass the query string parameters to get multiple invoices in a single pdf.
	
	* The queryMap contains the possible key as mentioned below: <br><br>
	
		invoice_ids* - Comma separated invoice ids which are to be export as pdf.<br><br>
		
	* It returns a File object.
	
	
	* @param queryMap Comma separated invoice ids which are to be exported as pdf.
	
	* @return Returns a File that is stored in a current directory.
	
	*/
	
	public File bulkExport(HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/pdf"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		File file = ZohoHTTPClient.getFile(urlString, queryMap);
		
		return file;
	}
	
	/**
	
	* Export invoices as pdf, and print them (Maximum of 25 invoices can be printed).
	
	* Pass the query string parameters to get multiple invoices in a single pdf.
	
	* The queryMap contains the possible key as mentioned below: <br><br>
	
		invoice_ids* - Comma separated invoice ids which are to be printed.<br><br>
		
	* It returns a File object.
	
	
	* @param queryMap Comma separated invoice ids which are to be printed.
	
	* @return Returns a File that is stored in a current directory.
	
	*/
	
	public File bulkPrint(HashMap queryMap)throws Exception
	{
		String urlString = url+"/print"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		File file = ZohoHTTPClient.getFile(urlString, queryMap);
		
		return file; 
	}
	
	/**
	
	* Enable automated payment reminders for an invoice.
	
	* Pass the invoiceId to enable payment reminder for an invoice.
	
	* If the payment reminder has been enabled it returns the success message.
	
	* The success message is "Reminders enabled."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String enablePaymentReminder(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/paymentreminder/enable"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Disable automated payment reminders for an invoice.
	
	* Pass the invoiceId to disable payment reminder for an invoice.
	
	* If the payment reminder has been disabled it returns the success message.
	
	* The success message is "Reminders stopped."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String. 
	
	*/
	
	public String disablePaymentReminder(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/paymentreminder/disable"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Write off the invoice balance amount of an invoice.
	
	* Pass the invoiceId to change the status of an invoice to 'writeoff'.
	
	* If the invoice status has been changed it returns the success message.
	
	* The success message is "Invoice has been written off."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String. 
	
	*/
	
	public String writeOffInvoice(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/writeoff"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;  
	}
	
	/**
	
	* Cancel the write-off amount of an invoice.
	
	* Pass the invoiceId to cancel the write-off amount of an invoice.
	
	* If the invoice status has been changed it returns the success message.
	
	* The success message is "Invoice has been written off."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String. 
	
	*/
	
	public String cancelWriteOff(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/writeoff/cancel"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success; 
	}
	
	/**
	
	* Updates the billing address for this invoice alone (You can set this address as default billing address for your customer by specifying 'is_update_customer' param as true)
	
	* Pass the invoiceId and Address object to update the billing address of an invoice.
	
	* If the billing address has been updated it returns the success message.
	
	* The success message is "Billing address updated."
	
	
	* @param invoiceId Id of an Invoice.
	
	* @param billingAddress Address object.
	
	* @return Returns a String.
	
	*/
	
	public String updateBillingAddress(String invoiceId, Address billingAddress)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/address/billing"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		requestBody.put("JSONString", billingAddress.toJSON().put("is_update_customer", billingAddress.isUpdateCustomer()).toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Updates the shipping address for this invoice (You can set this address as default shipping address for your customer by specifying 'is_update_customer' param as true).
	
	* Pass the invoiceId and Address object to update the shipping address of an invoice.
	
	* If the shipping address has been updated it returns the success message.
	
	* The success message is "Shipping address updated."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param shippingAddress Address object.
	
	* @return Returns a String.
	
	*/
	
	public String updateShippingAddress(String invoiceId, Address shippingAddress)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/address/shipping"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		requestBody.put("JSONString", shippingAddress.toJSON().put("is_update_customer", shippingAddress.isUpdateCustomer()).toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get all invoice pdf templates.
	
	* It returns the TemplateList object.

	
	* @return Returns the TemplateList object.
	
	*/
	
	public TemplateList getTemplates()throws Exception
	{
		
		String urlString = url+"/templates"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		TemplateList templateList = invoiceParser.getTemplates(response);
		
		return templateList;
	}
	
	/**
	
	* Update the pdf template associated with the invoice.
	
	* Pass the invoiceId and templateId to update the respective template for an invoice.
	
	* If the template has been updated it returns the success message.
	
	* The success message is "Invoice information has been updated."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param templateId ID of the template associated with an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String updateTemplate(String invoiceId, String templateId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/templates/"+templateId; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
		
	}
	
	
	
//=============================================================================================================================================	
	
	
	
	/**
	
	* Get the list of payments made for an invoice.
	
	* Pass the invoiceId to get all the payments for an invoice.
	
	* It returns the PaymentList object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns the PaymentList object.
	
	*/
	
	public PaymentList getPayments(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/payments"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		PaymentList paymentList = invoiceParser.getPayments(response);
		
		return paymentList;
	} 
	
	/**
	
	* Get the list of credits applied for an invoice.
	
	* Pass the invoiceId to get all the credits for an invoice.
	
	* It returns the CreditList object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns the CreditList object.
	
	*/
	
	public CreditList getCreditsApplied(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/creditsapplied"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CreditList credits = invoiceParser.getCreditsApplied(response);
		
		return credits;
	}
	
	/**
	
	* Apply the customer credits either from credit notes or excess customer payments to an invoice (Multiple credits can be applied at once).
	
	* Pass the invoiceId, list of InvoicePayment objects, and list of ApplyCreditnote objects to add the credits for an invoice.
	
	* It returns the Credit object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param invoicePayments List of InvoicePayment object.
	
	* @param applyCreditnotes List of ApplyCreditnote object.
	
	* @return Returns the Credit object.
	
	*/
	
	public Credit addCredits(String invoiceId, List<InvoicePayment> invoicePayments, List<ApplyCreditnote> applyCreditnotes)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/credits"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		
		JSONArray ipayments = new JSONArray();
		for(int i = 0; i < invoicePayments.size(); i++)
		{
			JSONObject invoicePayment = new JSONObject();
			
			invoicePayment.put("payment_id", invoicePayments.get(i).getPaymentId());
			invoicePayment.put("amount_applied", invoicePayments.get(i).getAmountApplied());
			
			ipayments.put(invoicePayment);
		}
		jsonObject.put("invoice_payments", ipayments);
		
		JSONArray creditNotes = new JSONArray();
		for(int j = 0; j < applyCreditnotes.size(); j++)
		{
			JSONObject creditNote = new JSONObject();
			
			creditNote.put("creditnote_id", applyCreditnotes.get(j).getCreditnoteId());
			creditNote.put("amount_applied", applyCreditnotes.get(j).getAmountApplied());
			
			creditNotes.put(creditNote);
		}
		jsonObject.put("apply_creditnotes", creditNotes);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		Credit credit = invoiceParser.getApplyCredits(response);
		
		return credit;
	}
	
	/**
	
	* Delete a payment made to an invoice.
	
	* Pass the invoiceId and invoicePaymentId to delete a payment made for an invoice.
	
	* If the payment has been deleted it returns the success message.
	
	* The success message is "The payment has been deleted."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param invoicePaymentId ID of an InvoicePayment.
	
	* @return Returns a String.
	
	*/
	
	public String deletePayment(String invoiceId, String invoicePaymentId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/payments/"+invoicePaymentId; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;  
		
	}
	
	/**
	
	* Delete a particular credit applied to an invoice.
	
	* Pass the invoiceId and creditnotesInvoiceId to delete the credit applied for an invoice.
	
	* If the credit applied has been deleted it returns the success message.
	
	* The success message is "Credits applied to an invoice have been deleted."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param creditnotesInvoiceId ID of credit notes applied to an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String deleteAppliedCredit(String invoiceId, String creditnotesInvoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/creditsapplied/"+creditnotesInvoiceId; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;  
		
	}
	


//==============================================================================================================================================


	/**
	
	* Attach a file to an invoice.
	
	* Pass the invoiceId, File, and query string parameters to add an attachment to an invoice.
	
	* The paramMap contains the possible key and value as mentioned below: <br><br>
	
		can_send_in_mail - True to send the attachment with the invoice when emailed.<br><br>
		
	* If the file has been attached it returns the success message.
	
	* The success message is "Your file has been successfully attached to the invoice."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param file The file to be attached.
	
	* @param paramMap True to send the attachment with the invoice when emailed.
	
	* @return Returns a String.
	
	*/
	
	
	public String addAttachment(String invoiceId, File file, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/attachment"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);

		
		HashMap fileBody = new HashMap();
		
		fileBody.put("attachment", file);
		
		
		String response = ZohoHTTPClient.post(urlString, queryMap, paramMap, fileBody);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Returns the file attached to the invoice.
	
	* Pass the invoiceId and queryMap to get the attached file to the invoice.
	
	* The queryMap contains the possible key and value as mentioned below: <br><br>
	
		preview - Get the thumbnail of the attachment.<br><br>
		
	* It returns the File object.
			
	
	* @param invoiceId ID of an Invoice.
	
	* @param queryMap Get the thumbnail of the attachment.
	
	* @return Returns the File object which is saved in the current working directory.
	
	*/
	
	public File getAttachment(String invoiceId, HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/attachment"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		File file = ZohoHTTPClient.getFile(urlString, queryMap);
		
		return file;
	}
	
	/**
	
	* Set whether you want to send the attached file while emailing the invoice.
	
	* Pass the invoiceId and query string parameters to update the attachment for an invoice.
	
	* The paramMap contains the possible key and value as mentioned below: <br><br>
	
		can_send_in_mail* - Boolean to send the attachment with the invoice when emailed.<br><br>
		
	* If the attachment details has been updated it returns the success message.
	
	* The success message is "Invoice information has been updated."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param paramMap Boolean to send the attachment with the invoice when emailed.
	
	* @return Returns a String.
	
	*/
	
	public String updateAttachment(String invoiceId, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/attachment"; //No I18N
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.put(urlString, paramMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Delete the file attached to the invoice.
	
	* Pass the invoiceId to delete an attachment for an invoice.
	
	* If the attachment has been deleted it returns the success message.
	
	* The success message is "Your file is no longer attached to the invoice."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String deleteAttachment(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/attachment"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Delete the expense receipts attached to an invoice which is raised from an expense.
	
	* Pass the invoiceId to delete the expense receipt for an invoice.
	
	* If the expense receipt has been deleted it returns the success message.
	
	* The success message is "The attached expense receipt has been deleted."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns a String.
	
	*/
	
	public String deleteExpenseReceipt(String invoiceId)throws Exception
	{
		
		String urlString = url+"/expenses/"+invoiceId+"/receipt"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	
//==============================================================================================================================================




	/**
	
	* Get the complete history and comments of an invoice.
	
	* Pass the invoiceId to get all the comments for an invoice.
	
	* It returns the CommentList object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @return Returns the CommentList object.
	
	*/
	
	public CommentList getComments(String invoiceId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/comments"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CommentList commentList = invoiceParser.getComments(response);
		
		return commentList;
	} 
	
	/**
	
	* Add a comment for an invoice.
	
	* Pass the invoiceId, description, paymentExpectedDate, and showCommentToClients to add the comment for an invoice.
	
	* It returns the Comment object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param description Description is the comment of an Invoice.
	
	* @param paymentExpectedDate Expected date of payment for the invoice.
	
	* @param showCommentToClients Boolean to show the comments to contacts in portal.
	
	* @return Returns the Comment object.
	
	*/
	
	public Comment addComment(String invoiceId, String description, String paymentExpectedDate, boolean showCommentToClients)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/comments"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("description", description);
		jsonObject.put("payment_expected_date", paymentExpectedDate);
		jsonObject.put("show_comment_to_clients", showCommentToClients);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		Comment comment = invoiceParser.getComment(response);
		
		return comment;
	}
	
	/**
	
	* Update an existing comment of an invoice.
	
	* Pass the invoiceId, commentId, description, and showCommentToClients to update a comment for an invoice.
	
	* It returns the Comment object.
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param commentId ID of a Comment.
	
	* @param description Description is the comment of an Invoice.
	
	* @param showCommentToClients Boolean to show the comments to contacts in portal.
	
	* @return Returns the Comment object.
	
	*/
	
	public Comment updateComment(String invoiceId, String commentId, String description, boolean showCommentToClients)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/comments/"+commentId; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("description", description);
		jsonObject.put("show_comment_to_clients", showCommentToClients);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		Comment comment = invoiceParser.getComment(response);
		
		return comment;
	}
	
	/**
	
	* Delete an invoice comment.
	
	* Pass the invoiceId and commentId to delete the comment for an invoice.
	
	* If the comment has been deleted it returns the success message.
	
	* The success message is "The comment has been deleted."
	
	
	* @param invoiceId ID of an Invoice.
	
	* @param commentId ID of a Comment.
	
	* @return Returns a String.
	
	*/
	
	public String deleteComment(String invoiceId, String commentId)throws Exception
	{
		
		String urlString = url+"/"+invoiceId+"/comments/"+commentId; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = invoiceParser.getMessage(response);
		
		return success;
	}
	
	
}
