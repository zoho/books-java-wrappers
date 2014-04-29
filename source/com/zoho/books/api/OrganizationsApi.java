/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;
import com.zoho.books.util.BooksUtil;

import com.zoho.books.parser.SettingsParser;

import com.zoho.books.model.Organization;
import com.zoho.books.model.OrganizationList;

import java.util.HashMap;


/**

* OrganizationsApi is used to create an Organization.

* It is used to get and update the details of an organization.
  
* Get the list of organizations for the user.

*/

public class OrganizationsApi
{
	private static String url = BooksUtil.baseURL+"/organizations"; //No I18N

	private String authToken;
	
	/**
	
	* Construct a new OrganizationsApi using user's authtoken.
	
	* @param authToken user's authToken. 
	
	*/

	public OrganizationsApi(String authToken)
	{
		this.authToken = authToken;
	}
	
	
	private SettingsParser settingsParser = new SettingsParser();
	
	
	/**
	
	* Get the list of organizations.
	
	* It returns the OrganizationList object.
	
	* @return Returns the OrganizationList object.
	
	*/
	
	public OrganizationList getOrganizations()throws Exception
	{
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		
		String response = ZohoHTTPClient.get(url, queryMap);
		
		OrganizationList organizationList = settingsParser.getOrganizations(response);
		
		return organizationList;
	}
	
	/**
	
	* Get the details of an organization.
	
	* Pass the organizationId to get the detatils of a particular organization.
	
	* It returns the Organization object.
	
	
	* @param organizationid  ID of an organization.
	
	* @return Returns the Organization object.
	
	*/
	
	public Organization get(String organizationid)throws Exception
	{
		
		String urlString = url+"/"+organizationid;
		
		HashMap queryMap = new HashMap();
		
		queryMap.put("authtoken", authToken);
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Organization organization = settingsParser.getOrganization(response);
		
		return organization;
	}
	
	/**
	
	* Create an organization.
	
	* Pass the Organization object to create a new organization for the user.
	
	* The Organization object which contains name, currencyId, and timeZone are the mandatory parameters.
	
	* It returns the Organization object.
	
	
	* @param organization Organization object.
	
	* @return Returns the Organization object.
	
	*/
	
	public Organization create(Organization organization)throws Exception
	{
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		
		
		requestBody.put("JSONString", organization.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		return settingsParser.getOrganization(response);
	}
	
	/**
	
	* Update the details of an organization.
	
	* Pass the Organization object to update the details of an organization.
	
	* The Organization object must contain the organizationId for which organization details has to be updated. 
	
	* It returns the Organization object.
	
	
	* @param organization Organization object.
	
	* @return Returns the Organization object.
	
	*/
	
	public Organization update(Organization organization)throws Exception
	{
		
		String urlString = url+"/"+organization.getOrganizationId();
		
		HashMap requestBody = new HashMap();
		
		requestBody.put("authtoken", authToken);
		
		
		requestBody.put("JSONString", organization.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		return settingsParser.getOrganization(response);
	}
	
}
