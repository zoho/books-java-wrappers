/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;
import com.zoho.books.util.BooksUtil;

import com.zoho.books.parser.BaseCurrencyAdjustmentParser;

import com.zoho.books.model.BaseCurrencyAdjustment;
import com.zoho.books.model.BaseCurrencyAdjustmentList;

import java.util.HashMap;


/**

* BaseCurrencyAdjustmentsApi is used to create the basecurrency adjustments.

* It is used to get:<br><br>

	The list of all  base currency adjustments.<br>
	
	The details of a base currency adjsutment.<br>
	
	The list of all account details for the base currency adjustment.<br><br>
	
* It is used to delete the base currency adjustment.

*/

public class BaseCurrencyAdjustmentsApi
{
	
	private static String url = BooksUtil.baseURL+"/basecurrencyadjustment"; //No I18N

	private String authToken;
	private String organizationId;
	
	/**
	
	* Construct a new BaseCurrencyAdjustmentsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public BaseCurrencyAdjustmentsApi(String authToken, String organizationId)
	{
		this.authToken = authToken;
		this.organizationId = organizationId;
	}
	
	
	private BaseCurrencyAdjustmentParser baseCurrencyAdjustmentParser = new BaseCurrencyAdjustmentParser();
	
	
	/**
	
	* List of accounts having transaction with effect to the given exchange rate.
	
	* Pass the filters to get all the base currency adjustment accounts based on the filters.
	
	* It returns the BaseCurrencyAdjustment object.<br>
	
	* The queryMap contains the possible keys as mentioned below:<br><br>
	
		<table border = "1">
			<tbody>
				<tr><td>currency_id*</td><td>ID of currency for which we need to post adjustment.</td></tr>
				
				<tr><td>adjustment_date*</td><td>Date of adjustment.</td></tr>
				
				<tr><td>exchange_rate*</td><td>Exchange rate of the currency.</td></tr>
				
				<tr><td>notes*</td><td>Notes for the base currency adjustment.</td></tr>
			</tbody>
		</table>
	
	* @param queryMap It contains the query string values in the form of key-value pair.
	
	* @return Returns the BaseCurrencyAdjustment object.
	
	*/
	
	public BaseCurrencyAdjustment getBaseCurrencyAdjustmentAccounts(HashMap queryMap)throws Exception
	{
		
		String urlString = url+"/accounts"; //No I18N
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		BaseCurrencyAdjustment baseCurrencyAdjustment = baseCurrencyAdjustmentParser.getBaseCurrencyAdjustment(response);
		
		return baseCurrencyAdjustment;
	}
	
	/**
	
	* Creates a base currency adjustment for the given information.
	
	* Pass the querystring parameter and BaseCurrencyAdjustment object to create a base currency adjustment.
	
	* The BasCurrencyAdjustment object which contains currencyId, adjustmentDate, exchangeRate, and notes are the mandatory parameters.
	
	* It returns the BaseCurrencyAdjustment object.<br>
	
	* The paramMap contains the possible key as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>account_ids*</td><td>ID of the accounts for which base currency adjustments need to be posted.</td></tr>
			</tbody>
		
		</table> 
	
	* @param paramMap It contains query string values in the form of key-value pair.
	
	* @param baseCurrencyAdjustment BaseCurrencyAdjustment object.
	
	* @return Returns the BaseCurrencyAdjustment object.
	
	*/
	
	public BaseCurrencyAdjustment create(HashMap paramMap, BaseCurrencyAdjustment baseCurrencyAdjustment)throws Exception
	{
		
		if(paramMap == null)
		{
			paramMap = new HashMap();
		}
		
		paramMap.put("authtoken", authToken);
		paramMap.put("organization_id", organizationId);
		
		paramMap.put("JSONString", baseCurrencyAdjustment.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, paramMap);
		
		return baseCurrencyAdjustmentParser.getBaseCurrencyAdjustment(response);
	}
	
	/**
	
	* Get the base currency adjustment details.
	
	* Pass the baseCurrencyAdjustmentId to get the details of a base currency adjustment.
	
	* It returns the BaseCurrencyAdjsutment object.
	
	
	* @param baseCurrencyAdjustmentId ID of the BaseCurrencyAdjustment.
	
	* @return Returns the BaseCurrencyAdjustment object.
	
	*/
	
	public BaseCurrencyAdjustment get(String baseCurrencyAdjustmentId)throws Exception
	{
		
		String urlString = url+"/"+baseCurrencyAdjustmentId;
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		BaseCurrencyAdjustment baseCurrencyAdjustment = baseCurrencyAdjustmentParser.getBaseCurrencyAdjustment(response);
		
		return baseCurrencyAdjustment;
	}
	
	/**
	
	* Delete the base currency adjustment.
	
	* Pass the baseCurrencyAdjsutmentId to delete the base currency adjsutment.
	
	* If the base currency adjustment has been deleted it returns the success message.
	
	* The success message is "The selected base currency adjustment has been deleted."
	
	
	* @param baseCurrencyAdjustmentId ID of the BaseCurrencyAdjustment.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String baseCurrencyAdjustmentId)throws Exception
	{
		
		String urlString = url+"/"+baseCurrencyAdjustmentId;
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(url, queryMap);
		
		String success = baseCurrencyAdjustmentParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List base currency adjustment.
	
	* Pass the filters to get all the base currency adjustments based on the filters.
	
	* It returns the BaseCurrencyAdjsutmentList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>filter_by<td><td>Filter base currency adjustment list. <br>
Allowed Values: <i>Date.All, Date.Today, Date.ThisWeek, Date.ThisMonth, Date.ThisQuarter</i> and <i>Date.ThisYear</i></td></tr>

				<tr><td>sort_column<td><td>Sort base currency adjustment list. <br>
Allowed Values: <i>adjustment_date, exchange_rate, currency_code, debit_or_credit</i> and <i>gain_or_loss</i></td></tr>
			</tbody>
			
		</table>
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the BaseCurrencyAdjustmentList object.  
	
	*/
	
	public BaseCurrencyAdjustmentList getBaseCurrencyAdjustments(HashMap queryMap)throws Exception
	{
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(url, queryMap);
		
		BaseCurrencyAdjustmentList baseCurrencyAdjustmentList = baseCurrencyAdjustmentParser.getBaseCurrencyAdjustments(response);
		
		return baseCurrencyAdjustmentList;
	}
	
}
