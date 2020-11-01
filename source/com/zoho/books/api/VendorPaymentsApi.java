/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.VendorPaymentParser;

import com.zoho.books.model.VendorPayment;
import com.zoho.books.model.VendorPaymentList;

import java.util.HashMap;


/**

* VendorPaymentsApi is used to create a payment made for the vendor.

* It is used to get:<br><br>

	The list of vendor payments.<br>
	
	The details of a vendor payment.<br><br>
	
* It is ued to update the details of a vendor payment.<br>

* It is used to delete the vendor payment.

*/

public class VendorPaymentsApi extends API
{
	
	private static String url = baseURL+"/vendorpayments"; //No I18N

	
	/**
	
	* Construct a new VendorPaymentsApi using user's accessToken and organizationid.
	
	* @param accessToken user's accessToken.
	
	* @param organizationId user's organization id.
	
	*/

	public VendorPaymentsApi(String accessToken, String organizationId)
	{
		
		super(accessToken, organizationId);
		
	}
	
	
	private VendorPaymentParser vendorPaymentParser = new VendorPaymentParser();
	
	
	/**
	
	* Create a payment made to your vendor and you can also apply them to bills either partially or fully.
	
	* Pass the VendorPayment object to create a payment made to your vendor.
	
	* The VendorPayment object which contains vendorId and amount are the mandatory parameters.
	
	* It returns the VendorPayment object.
	
	
	* @param vendorPayment VendorPayment object.
	
	* @return Returns the VendorPayment object.
	
	*/
	
	public VendorPayment create(VendorPayment vendorPayment)throws Exception
	{
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", vendorPayment.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody, accessToken);
		
		return vendorPaymentParser.getVendorPayment(response);
	}
	
	/**
	
	* Get the details of a vendor payment.
	
	* Pass the paymentId to get the details of a vandor payment.
	
	* It returns the VendorPayment object.
	
	
	* @param paymentId ID of the vendor payment.
	
	* @return Returns the VendorPayment object.
	
	*/
	
	public VendorPayment get(String paymentId)throws Exception
	{
		
		String urlString = url+"/"+paymentId;
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		VendorPayment vendorPayment = vendorPaymentParser.getVendorPayment(response);
		
		return vendorPayment;
	}
	
	/**
	
	* Update an existing vendor payment (You can also modify the amount applied to the bills).
	
	* Pass the VendorPayment object to update the details of a vendor payment.
	
	* The VendorPayment object which contains paymentId is the mandatory parameter for which vendor payment details has to be updated.
	
	* It returns the VendorPayment object.
	
	
	* @param vendorPayment VendorPayment object.
	
	* @return Returns the VendorPayment object.
	
	*/
	
	public VendorPayment update(VendorPayment vendorPayment)throws Exception
	{
		
		String urlString = url+"/"+vendorPayment.getPaymentId();
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", vendorPayment.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return vendorPaymentParser.getVendorPayment(response);
	}
	
	/**
	
	* Delete an existing vendor payment.
	
	* Pass the paymentId to delete the vendor payment.
	
	* If the vendor payment has been deleted it returns the success message.
	
	* The success message is "The payment has been deleted."
	
	
	* @param paymentId ID of the vendor payment.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String paymentId)throws Exception
	{
		
		String urlString = url+"/"+paymentId;
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = vendorPaymentParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List all the payments made to your vendor.
	
	* Pass the filters to get all the vendor payments based on the filters.
	
	* It returns the VendorPaymentList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border="1">
		
			<tbody>
		
				<tr><td>vendor_name</td>  <td>Search payments by vendor name. <br>
Variants: <i>vendor_name_startswith and vendor_name_contains</i></td></tr>
		
				<tr><td>reference_number</td> <td>Search payments by reference number.<br>
Variants: <i>reference_number_startswith and reference_number_contains</i></td></tr>
		
				<tr><td>date</td>  <td>Search payments by payment made date.<br>
Variants: <i>date_start, date_end, date_before and date_after</i></td></tr>
		
				<tr><td>amount</td>  <td>Search payments by payment amount.<br>
Variants: <i>amount_less_than, amount_less_equals, amount_greater_than and amount_greater_equals</i></td></tr>
		
				<tr><td>payment_mode</td>  <td>Search payments by payment mode.<br>
Variants: <i>payment_mode_startswith and payment_mode_contains</i></td></tr>
		
				<tr><td>vendor_id</td>  <td>Search payments by vendor id.</td></tr>
		
				<tr><td>bill_id</td>  <td>Search payments by bill id.</td></tr>
		
				<tr><td>search_text</td>  <td>Search payments by reference number or vendor name or payment description.</td></tr>
		
				<tr><td>notes</td>  <td>Search payments by notes.<br>
Variants: <i>notes_startswith and notes_contains</i></td></tr>
	
				<tr><td>filter_by</td> <td>Filter payments by mode.<br>
Allowed Values: <i>PaymentMode.All, PaymentMode.Check, PaymentMode.Cash, PaymentMode.BankTransfer, PaymentMode.Paypal, PaymentMode.CreditCard, PaymentMode.GoogleCheckout, PaymentMode.Credit, PaymentMode.Authorizenet, PaymentMode.BankRemittance, PaymentMode.Payflowpro and PaymentMode.Others</i></td></tr>
		
				<tr><td>sort_column</td> <td>Sort the payment list.<br>
Allowed Values: <i>vendor_name, date, reference_number, amount and balance</i></td></tr>
		
			</tbody>
		
		</table>
		
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the VendorPaymentList object.
	
	*/
	
	public VendorPaymentList getVendorPayments(HashMap<String, Object> queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap), accessToken);
		
		VendorPaymentList vendorPaymentList = vendorPaymentParser.getVendorPayments(response);
		
		return vendorPaymentList;
	}
	
}
