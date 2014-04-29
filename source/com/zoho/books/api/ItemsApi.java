/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;
import com.zoho.books.util.BooksUtil;

import com.zoho.books.parser.SettingsParser;

import com.zoho.books.model.Item;
import com.zoho.books.model.ItemList;

import java.util.HashMap;


/**

* ItemsApi is used to create a new item for the organization.

* It is used to get:<br><br>

	The list of items from the organization.<br>
	
	The details of an item.<br><br>

* It is used to update the details of a particular item.<br>

* It is used to change the status:<br><br>

	Mark an inactive item as active.<br>
	
	Mark an active item as inactive. <br><br>
	
* It is used to delete a particular item from the list of items.

*/

public class ItemsApi
{
	private static String url = BooksUtil.baseURL+"/items"; //No I18N

	private String authToken;
	private String organizationId;
	
	/**
	
	* Construct a new ItemsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public ItemsApi(String authToken, String organizationId)
	{
		this.authToken = authToken;
		this.organizationId = organizationId;
	}
	
	
	private SettingsParser settingsParser = new SettingsParser();
	
	
	
	/**
	
	* Get the list of all active items with pagination.
	
	* Pass the filters in the form of key-value pair to get all the items from an organization based on the filter.
	
	* It returns the ItemList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>name</td><td>Search items by name.<br>
Variants: <i>name_startswith</i> and <i>name_contains</i></td></tr>

				<tr><td>description</td><td>Search items by description.<br>
Variants: <i>description_startswith</i> and <i>description_contains</i></td></tr>

				<tr><td>rate</td><td>Search items by rate.<br>
Variants: <i>rate_less_than, rate_less_equals, rate_greater_than</i> and <i>rate_greater_equals</i></td></tr>

				<tr><td>tax_id</td><td>Search items by tax id.</td></tr>

				<tr><td>search_text</td><td>Search items by name or description.</td></tr>

				<tr><td>filter_by</td><td>Filter items by status.<br>
Allowed Values: <i>Status.All, Status.Active</i> and <i>Status.Inactive</i></td></tr>


				<tr><td>sort_column</td><td>Sort items.<br>
Allowed Values: <i>name, rate</i> and <i>tax_name</i></td></tr>
			</tbody>
		
		</table> 
	
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the ItemList object.
	
	*/
	
	public ItemList getItems(HashMap queryMap)throws Exception
	{
		
		if(queryMap == null)
		{
			queryMap = new HashMap();
		}
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(url, queryMap);
		
		ItemList itemList = settingsParser.getItems(response);
		
		return itemList;
	}
	
	/**
	
	* Get the details of an item.
	
	* Pass the itemId to get the details of a particular item.
	
	* It returns the Item object.
	
	
	* @param itemId ID of an item.
	
	* @return Returns an Item object.
	
	*/
	
	public Item get(String itemId)throws Exception
	{
		
		String urlString = url+"/"+itemId;
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Item item = settingsParser.getItem(response);
		
		return item;
	}
	
	/**
	
	* Create a new item.
	
	* Pass the Item object to create a new item for the organization.
	
	* The Item object which contains name and rate are mandatory parameters.
	
	* It returns the Item object.
	
	
	* @param item Item object.
	
	* @return Returns the Item object.
	
	*/
	
	public Item create(Item item)throws Exception
	{
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		requestBody.put("JSONString", item.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		return settingsParser.getItem(response);
	}
	
	/**
	
	* Update the details of an item.
	
	* Pass the Item object to update the details of a particular item.
	
	* The Item object must contain the itemId for which item has to be updated.
	
	* It returns the Item object.
	
	
	* @param item Item object.
	
	* @return Returns the Item object.
	
	*/
	
	public Item update(Item item)throws Exception
	{
		
		String urlString = url+"/"+item.getItemId();
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		
		requestBody.put("JSONString", item.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		return settingsParser.getItem(response);
	}
	
	/**
	
	* Delete the item created. Items that are part of transaction cannot be deleted.
	
	* Pass the itemId to delete the particular item from the organization.
	
	* If the item has been deleted it returns the success message.
	
	* The success message is "The item has been deleted."
	
	
	* @param itemId ID of an item.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String itemId)throws Exception
	{
		
		String urlString = url+"/"+itemId;
		
		HashMap	queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		queryMap.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.delete(urlString, queryMap);
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark an inactive item as active.
	
	* Pass the itemId to change the status of an item to 'active'.
	
	* If the item status has been changed it returns the success message.
	
	* The successs message is "The item has been marked as active."
	
	
	* @param itemId ID of an item.
	
	* @return Returns a String.
	
	*/
	
	public String markItemAsActive(String itemId)throws Exception
	{
		
		String urlString = url+"/"+itemId+"/active"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark an active item as inactive.
	
	* Pass the itemId to change the status of an item to 'inactive'.
	
	* If the item status has been changed it returns the success message.
	
	* The success message is "The item has been marked as inactive."
	
	
	* @param itemId ID of an item.
	
	* @return Returns a String.
	
	*/
	
	public String markItemAsInactive(String itemId)throws Exception
	{
		
		String urlString = url+"/"+itemId+"/inactive"; //No I18N
		
		HashMap	requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		requestBody.put("organization_id", organizationId);
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
}
