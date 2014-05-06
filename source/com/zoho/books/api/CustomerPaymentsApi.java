/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.CustomerPaymentParser;

import com.zoho.books.model.CustomerPayment;
import com.zoho.books.model.CustomerPaymentList;

import java.util.HashMap;

import org.json.JSONObject;

/**

* CustomerPaymentsApi is used to create a payment made by the customer.

* It is used to get: <br><br>

	The list of payments made by the customer.<br>
	
	The details of a customer payment.<br><br>
	
* It is used to update the details of a customer payment.<br>

* It is used to delete an existing customer payment. 

*/

public class CustomerPaymentsApi extends API
{
	private static String url = baseURL+"/customerpayments"; //No I18N

	/**
	
	* Construct a new CustomerPaymentsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public CustomerPaymentsApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	
	private CustomerPaymentParser customerPaymentParser = new CustomerPaymentParser();
	
	
	
	/**
	
	* Create a payment made by your customer and you can also apply them to invoices either partially or fully.
	
	* Pass the CustomerPayment object to create a payment made by your customer.
	
	* The CustomerPayment object which contains date and amount are the mandatory parameters.
	
	* It returns the CustomerPayment object.
	 
	
	* @param customerPayment CustomerPayment object.
	
	* @return Returns the CustomerPayment object.
	
	*/
	
	public CustomerPayment create(CustomerPayment customerPayment)throws Exception
	{
		
		HashMap requestBody = getQueryMap();
		
		requestBody.put("JSONString", customerPayment.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		return customerPaymentParser.getCustomerPayment(response);
	}
	
	/**
	
	* Get the details of a customer payment.
	
	* Pass the paymentId to get the details of a customer payment.
	
	* It returns the CustomerPayment object.
	
	
	* @param paymentId ID of the CustomerPayment. 
	
	* @return Returns the CustomerPayment object.
	
	*/
	
	public CustomerPayment get(String paymentId)throws Exception
	{
		
		String urlString = url+"/"+paymentId;
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap());
		
		CustomerPayment customerPayment = customerPaymentParser.getCustomerPayment(response);
		
		return customerPayment;
	}
	
	/**
	
	* Update an existing customer payment (You can also modify the amount applied to the invoices).
	
	* Pass the CustomerPayment object to update the details of a customer payment.
	
	* The CustomerPayment object which contains customerPaymentId is the mandatory parameter for which customer payment has to be updated.
	
	* It returns the CustomerPayment object.
	
	
	* @param customerPayment CustomerPayment object.
	
	* @return Returns the CustomerPayment object.
	
	*/
	
	public CustomerPayment update(CustomerPayment customerPayment)throws Exception
	{
		String urlString = url+"/"+customerPayment.getPaymentId();
		
		HashMap requestBody = getQueryMap();
		
		requestBody.put("JSONString", customerPayment.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		return customerPaymentParser.getCustomerPayment(response);
	}
	
	/**
	
	* Delete an existing customer payment.
	
	* Pass the paymentId to delete the customer payment.
	
	* If the customer payment has been deleted it returns the success message.
	
	* The success message is "The payment has been deleted."
	
	
	* @param paymentId ID of the CustomerPayment.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String paymentId)throws Exception
	{
		
		String urlString = url+"/"+paymentId;
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap());
		
		JSONObject jsonObject = new JSONObject(response.trim());
		
		String success = jsonObject.getString("message");
		
		return success;
	}
	
	/**
	
	* List all the payments made by your customer.
	
	* Pass the filters to get all the customer payments based on the filters.
	
	* It returns the CustomerPaymentList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below: <br><br>
		
		<table border = "1">
			
			<tbody>
		
				<tr><td>customer_name</td><td>Search payments by customer name. <br>
Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
		
				<tr><td>reference_number</td><td>Search payments by reference number.<br>
Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
		
				<tr><td>date</td><td>Search payments by payment made date.<br>
Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
		
				<tr><td>amount</td><td>Search payments by payment amount.<br>
Variants: <i>amount_less_than, amount_less_equals, amount_greater_than</i> and <i>amount_greater_equals</i></td></tr>
		
				<tr><td>payment_mode</td><td>Search payments by payment mode.<br>
Variants: <i>payment_mode_startswith</i> and <i>payment_mode_contains</i></td></tr>
		
				<tr><td>notes</td><td>Search payments by customer notes.<br>
Variants: <i>notes_startswith</i> and <i>notes_contains</i></td></tr>
		
				<tr><td>customer_id</td><td>Search payments by customer id.</td></tr>
		
				<tr><td>invoice_id</td><td>Search payments by invoice id.</td></tr>
		
				<tr><td>search_text</td><td>Search payments by reference number or customer name or payment description.</td></tr>
	
				<tr><td>filter_by</td><td>Filter payments by mode.<br>
Allowed Values: <i>PaymentMode.All, PaymentMode.Check, PaymentMode.Cash, PaymentMode.BankTransfer, PaymentMode.Paypal, PaymentMode.CreditCard, PaymentMode.GoogleCheckout, PaymentMode.Credit, PaymentMode.Authorizenet, PaymentMode.BankRemittance, PaymentMode.Payflowpro, PaymentMode.Stripe, PaymentMode.TwoCheckout, PaymentMode.Braintree</i> and <i>PaymentMode.Others</i></td></tr>
		
				<tr><td>sort_column</td><td>Sort the payment list. <br>
Allowed Values: <i>customer_name, unused_amount, amount, bcy_amount, date, reference_number, account_name</i> and <i>payment_mode</i></td></tr>
				
			</tbody>
			
		</table>
		
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the CustomerPaymentList object.
	
	*/
	
	public CustomerPaymentList getCustomerPayments(HashMap queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));
		
		CustomerPaymentList customerPaymentList = customerPaymentParser.getCustomerPayments(response);
		
		return customerPaymentList;
	}
}
