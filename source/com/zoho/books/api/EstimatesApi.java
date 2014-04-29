/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;
import com.zoho.books.util.BooksUtil;

import com.zoho.books.parser.EstimateParser;

import com.zoho.books.model.Estimate;
import com.zoho.books.model.Address;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.Email;
import com.zoho.books.model.Comment;
import com.zoho.books.model.EstimateList;
import com.zoho.books.model.TemplateList;
import com.zoho.books.model.CommentList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import org.json.JSONObject;

/**

* EstimatesApi is used to create a new estimate for the customer.

* It is used to get:<br><br>

	The details of an estimate.<br>
	
	The list of all estimates.<br>
	
	The estimate email content.<br>
	
	The estimate in a single pdf.<br>
	
	The estimate in a single pdf and print it.<br>
	
	The list estimate templates.<br>
	
	The list of estimate comments.<br><br>
	
* It is used to update:<br><br>

	The details of an estimate.<br>
	
	The billing address of an estimate.<br>
	
	The shipping address of an estimate.<br>
	
	The templates of an estimate.<br>
	
	The comment of an estimate.<br><br>
	
* It is used to change the status:<br><br>

	Mark an estimate as sent.<br>
	
	Mark an estimate as accepted.<br>
	
	Mark an estimate as declined.<br><br>
	
* It is used to delete an estimate.<br>

* It is used to add the comment for an estimate.<br>

* It is used to delete the comment for an estimate.
	 

*/

public class EstimatesApi
{
	
	private static String url = BooksUtil.baseURL+"/estimates"; //No I18N

	private String authToken;
	private String organizationId;
	
	/**
	
	* Construct a new EstimatesApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public EstimatesApi(String authToken, String organizationId)
	{
		this.authToken = authToken;
		this.organizationId = organizationId;
	}
	
	
	private EstimateParser estimateParser = new EstimateParser();
	
	
	/**
	
	* Create an estimate for your customer.
	
	* Pass customerId and itemName to create a new estimate for the customer.
	
	* It returns the Estimate object.
	
	
	* @param customerId ID of the customer the estimate has to be created.
	
	* @param itemName Name of the line item.
	
	* @return Returns an Estimate object.
	
	*/
	
	public Estimate create(String customerId, String itemName)throws Exception
	{
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		Estimate estimateObj = new Estimate();
		
		estimateObj.setCustomerId(customerId);
		
		List<LineItem> lineItems = new ArrayList<LineItem>();
		
		LineItem lineItem = new LineItem();
		
		lineItem.setName(itemName);
		
		lineItems.add(0, lineItem);
		
		estimateObj.setLineItems(lineItems);
		
		
		requestBody.put("JSONString", estimateObj.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		Estimate estimate = estimateParser.getEstimate(response);
		
		return estimate;
	}
	
	/**
	
	* Create an estimate for your customer.
	
	* Pass the Estimate object to create a new estimate for the customer.
	
	* The Estimate object which contains customerId and itemName are the mandatory parameters.
	
	* The paramMap contains the query string paramters in the form of key-value pair.<br>
	
	* The possible keys and values are as mentioned below: <br><br>
	
		send = 'true' or 'false' <br>
		
		ignore_auto_number_generation = 'true' or 'false' <br><br>
	
	* It returns the Estimate object.
	
	
	* @param estimate Estimate object.
	
	* @param paramMap It contains the parameter value in the form of key-value pair.
	
	* @return Returns an Estimate object.
	
	*/
	
	public Estimate create(Estimate estimate, HashMap paramMap)throws Exception
	{
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		paramMap.put("JSONString", estimate.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, paramMap);
		
		return estimateParser.getEstimate(response);
	}
	
	/**
	
	* Get the details of an estimate.
	
	* Pass the estimateId to get the details of a particular estimate.
	
	* It returns the Estimate object.
	
	
	* @param estimateId ID of an estimate.
	
	* @return Returns an Estimate object.
	
	*/
	
	public Estimate get(String estimateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId;
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Estimate estimate = estimateParser.getEstimate(response);
		
		return estimate;
	}
	
	/**
	
	* Update an existing estimate. (To delete a line item remove it from the line_items list.)
	
	* Pass the Estimate object to update the details of a particular estimate.
	
	* The estimate object must contain the estimateId for which estimate details has to be updated.
	
	* The paramMap contains the query string paramters in the form of key-value pair.
	
	* The paramMap contains the key and value as mentioned below: <br><br>
	
		ignore_auto_number_generation = 'true' or 'false'<br><br>
	
	* It returns the Estimate object.
	
	
	
	* @param paramMap Ignore auto estimate number generation for this estimate. This mandates the estimate number.
	
	* @param estimate Estimate object.
	
	* @return Returns an Estimate object.
	
	*/
	
	public Estimate update(Estimate estimate, HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/"+estimate.getEstimateId();
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		
		paramMap.put("JSONString", estimate.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, paramMap);
		
		return estimateParser.getEstimate(response);
	}
	
	/**
	
	* Delete an existing estimate.
	
	* Pass the estimateId to delete an estimate.
	
	* It returns the success message.
	
	* The success message is "The estimate has been deleted."

	
	* @param estimateId ID of an estimate.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String estimateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId;
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List all estimates with pagination.
	
	* Pass the filters in the form of key-value pair to get all the estimates based on the filter.
	
	* It returns EstimateList object.<br>
	
	* The queryMap contains the  possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
		
				<tr><td>estimate_number</td><td>Search estimates by estimate number.<br>
Variants: <i>estimate_number_startswith</i> and <i>estimate_number_contains</i></td></tr>

				<tr><td>reference_number</td><td>Search estimates by estimates reference number.<br>
Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
				
				<tr><td>customer_name</td><td>Search estimates by customer name.<br>
Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
				
				<tr><td>total</td><td>Search estimates by estimate total.<br>
Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>

				<tr><td>customer_id</td><td>Search estimates by customer id.</td></tr>
				
				<tr><td>item_name</td><td>Search estimates by item name.<br>
Variants: <i>item_name_startswith</i> and <i>item_name_contains</i></td></tr>
		
				<tr><td>item_id</td><td>Search estimates by item id.</td></tr>
		
				<tr><td>item_description</td><td>Search estimates by item description.<br>
Variants: <i>item_description_startswith</i> and <i>item_description_contains</i></td></tr>
		
				<tr><td>custom_field</td><td>Search estimates by custom field.
Variants: <i>custom_field_startswith</i> and <i>custom_field_contains</i></td></tr>
		
				<tr><td>expiry_date</td><td>Search estimates by expiry date.
Variants: <i>expiry_date_start, expiry_date_end, expiry_date_before</i> and <i>expiry_date_after</td></tr>
				
				<tr><td>date</td><td>Search estimates by invoice date.<br>
Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
		
				<tr><td>status</td><td>Search estimates by status.<br>
Allowed Values: <i>draft, sent, invoiced, accepted, declined</i> and <i>expired</i></td></tr>
		
				<tr><td>search_text</td><td>Search estimates by estimate number or reference or customer name.</td></tr>
		
				<tr><td>filter_by</td><td>Filter estimates by status.<br>
Allowed Values: <i>Status.All, Status.Sent, Status.Draft, Status.Invoiced, Status.Accepted, Status.Declined</i> and <i>Status.Expired</i> </td></tr>
		
				<tr><td>sort_column</td><td>Sort estimates. <br>
Allowed Values: <i>customer_name, estimate_number, date, total</i> and <i>created_time</i></td></tr>
				
			</tbody>
			
		</table>
	 
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns an EstimateList object.
	
	*/
	
	public EstimateList getEstimates(HashMap queryMap)throws Exception
	{
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(url, queryMap);
		
		EstimateList estimateList = estimateParser.getEstimates(response);
		
		return estimateList;
	}
	
	
	/**
	
	* Email an estimate to the customer (If the Email object is empty, email will be sent with default email content).
	
	* Pass the estimateId and Email object to send the email to the customer.
	
	* If the email has been sent to the customer it returns the success message.
	
	* The success message is "Your estimate has been sent."
	  
	
	* @param estimateId ID of an estimate.
	
	* @param email Email object.
	
	* @return Returns a String.
	
	*/
	
	public String sendEmail(String estimateId, Email email)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/email"; //No I18N
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("JSONString", email.toJSON().toString());
		
		ArrayList<File> files = email.getAttachments();
		
		HashMap fileBody = new HashMap(files.size());
		
		fileBody.put("attachments", files);
		
		
		String response = ZohoHTTPClient.post(urlString, queryMap, requestBody, fileBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Send estimates to your customers by email. (Maximum of 10 estimates can be sent at once.)
	
	* Pass the estimate ids to send an email to the customers.
	
	* If the email has been sent to the customer it returns the success message.
	
	* The success message is "Mission accomplished! We've sent all the estimates."
	 
	
	* @param paramMap Comma separated estimate ids which are to be emailed.
	
	* @return Returns a String.
	
	*/
	
	public String sendEmailEstimates(HashMap paramMap)throws Exception
	{
		
		String urlString = url+"/email"; //No I18N
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, paramMap);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get the email content of an estimate.
	
	* Pass the estimateId and filters to get the email content.
	
	* The queryMap contains the possible key as mentioned below:<br><br>
	
		email_template_id - Get the email content based on a specific email template.<br><br>
	
	* It returns the Email object.
	
	
	* @param estimateId ID of an estimate.
	
	* @param queryMap Get the email content based on a specific email template.
	
	* @return Returns an Email object.
	
	*/
	
	public Email getEmailContent(String estimateId, HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/email"; //No I18N
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Email email = estimateParser.getEmailContent(response);
		
		return email;
	}
	
	/**
	
	* Mark a draft estimate as sent.
	
	* Pass the estimateId to change the status of an estimate to 'sent'.
	
	* If the estimate status has been changed it returns the success message.
	
	* The success message is "Estimate status has been changed to Sent."
	  
	
	* @param estimateId ID of an estimate.
	
	* @return Returns a String.
	
	*/
	
	public String markAsSent(String estimateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/status/sent"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark a sent estimate as accepted if the customer has accepted it.
	
	* Pass the estimateId to change the status of an estimate to 'accepted'.
	
	* If the estimate status has been changed it returns the success message.
	
	* The success message is "Estimate status has been changed to Accepted."
	
	
	* @param estimateId ID of an estimate.
	
	* @return Returns a String.
	
	*/
	
	public String markAsAccepted(String estimateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/status/accepted"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark a sent estimate as declined if the customer has rejected it.
	
	* Pass the estimateId to change the status of an estimate to 'declined'.
	
	* If the estimate status has been changed it returns the success message.
	
	* The success message is "Estimate status has been changed to Declined."
	
	
	* @param estimateId ID of an estimate.
	
	* @return Returns a String.
	
	*/
	
	public String markAsDeclined(String estimateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/status/declined"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Maximum of 25 estimates can be exported in a single pdf.
	
	* Pass the estimateIds to get the estimates in a single pdf.
	
	* It returns the File object.
	
	
	* @param queryMap Comma separated estimate ids which are to be exported as pdf.
	
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
	
	* Export estimates as pdf and print them (Maximum of 25 estimates can be printed).
	
	* Pass the estimateIds to get the estimates as pdf.
	
	* It returns the File object.
	
	
	* @param queryMap Comma separated estimate ids which are to be printed.
	
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
	
	* Update the billing address for this estimate alone (You can set this address as default billing address for your customer by specifying 'is_update_customer' param as true).
	
	* Pass the estimateId and Address object to update the billing address for the estimate.
	
	* If the billing address has been updated it returns the success message.
	
	* The success message is "Billing address updated."
	
	
	* @param estimateId ID of an estimate.
	
	* @param billingAddress Address object.
	
	* @return Returns a String.
	
	*/
	
	public String updateBillingAddress(String estimateId, Address billingAddress)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/address/billing"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		requestBody.put("JSONString", billingAddress.toJSON().put("is_update_customer", billingAddress.isUpdateCustomer()).toString());
	
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Update the shipping address for an existing estimate alone (You can set this address as default shipping address for your customer by specifying 'is_update_customer' param as true).
	
	* Pass the estimateId and Address object to update the shipping address for the estimate.
	
	* If the billing address has been updated it returns the success message.
	
	* The success message is "Shipping address updated"
	
	
	* @param estimateId ID of an estimate.
	
	* @param shippingAddress Address object.
	
	* @return Returns a String.
	
	*/
	
	public String updateShippingAddress(String estimateId, Address shippingAddress)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/address/shipping"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
	
		
		requestBody.put("JSONString", shippingAddress.toJSON().put("is_update_customer", shippingAddress.isUpdateCustomer()).toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get all estimate pdf templates.
	
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
		
		TemplateList templateList = estimateParser.getTemplates(response);
		
		return templateList;
	}
	
	/**
	
	* Update the pdf template associated with the estimate.
	
	* Pass the estimateId and templateId to update the respective template for the estimate.
	
	* It returns the success message.
	
	* The success message is "Estimate information has been updated."
	
	
	* @param estimateId ID of an estimate.
	
	* @param templateId ID of a template.
	
	* @return Returns a String.
	
	*/
	
	public String updateTemplate(String estimateId, String templateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/templates/"+templateId; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		String success = estimateParser.getMessage(response);
		
		return success;
		
	}
	
	
//=======================================================================================================================================



	/**
	
	* Get the complete history and comments of an estimate.
	
	* Pass the estimateId to get all the comments for the estimate.
	
	* It returns the CommentList object.
	
	
	* @param estimateId ID of an estimate.
	
	* @return Returns the CommentList object.
	
	*/
	
	public CommentList getComments(String estimateId)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/comments"; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		CommentList commentList = estimateParser.getComments(response);
		
		return commentList;
	} 

	/**
	
	* Add a comment for an estimate.
	
	* Pass the estimateId, description, and showCommentToClients to add a comment for the estimate.
	
	* If the comment has been added it returns the Comment object.
	
	
	* @param estimateId ID of an estimate.
	
	* @param description Description of an estimate.
	
	* @param showCommentToClients Boolean to show the comments to contacts in portal.
	
	* @return Returns the Comment object.
	
	*/
	
	public Comment addComment(String estimateId, String description, boolean showCommentToClients)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/comments"; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("description", description);
		jsonObject.put("show_comment_to_clients", showCommentToClients);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		Comment comment = estimateParser.getComment(response);
		
		return comment;
	}
	
	/**
	
	* Update an existing comment of an estimate.
	
	* Pass the estimateId, commentId, description, and showCommentToClients to update the comment for the estimate.
	
	* If the comment has been updated it returns the Comment object.
	
	
	* @param estimateId ID of an estimate.
	
	* @param commentId ID of the comment.
	
	* @param description Description of an estimate.
	
	* @param showCommentToClients Boolean to show the comments to contacts in portal.
	
	* @return Returns the Comment object.
	
	*/
	
	public Comment updateComment(String estimateId, String commentId, String description, boolean showCommentToClients)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/comments/"+commentId; //No I18N
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("description", description);
		jsonObject.put("show_comment_to_clients", showCommentToClients);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		Comment comment = estimateParser.getComment(response);
		
		return comment;
	}
	
	/**
	
	* Delete an estimate comment.
	
	* Pass the estimateId and commentId to delete the comment for the estimate.
	
	* If the comment has been deleted it returns the success message.
	
	* The success message is "The comment has been deleted."
	
	
	* @param estimateId ID of an estimate.
	
	* @param commentId ID of the comment.
	
	* @return Returns a String.
	
	*/
	
	public String deleteComment(String estimateId, String commentId)throws Exception
	{
		
		String urlString = url+"/"+estimateId+"/comments/"+commentId; //No I18N
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = estimateParser.getMessage(response);
		
		return success;
	}
	
	
	
}
