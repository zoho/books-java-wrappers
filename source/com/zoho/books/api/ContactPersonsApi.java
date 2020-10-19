/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.ContactParser;

import com.zoho.books.model.ContactPerson;
import com.zoho.books.model.ContactPersonList;

import java.util.HashMap;


/**

* ContactPersonsApi is used to create multiple contact persons for a contact. 

* It is also used to get and update the details of a contact person. 

* Get the details of contact persons for the particular contact.   
 
* Delete a particular contact person.
 
* Change the status of a particular contact person.

*/

public class ContactPersonsApi extends API
{
	private static String url = baseURL+"/contacts"; //No I18N


	/**
	
	* Construct a new ContactPersonsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public ContactPersonsApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	
	private ContactParser contactParser = new ContactParser();
	
	
	/**
	
	* Create a contact person for a contact. 
	  
	* Pass the ContactPerson object to create a new contact person for the contact. 
	  
	* The ContactPerson object which contains contactId is the mandatory parameter.
	  
	* If the contact person has been created it returns a ContactPerson object.  
	
	
	* @param contactPerson  ContactPerson object.
	
	* @return Returns a ContactPerson object.
	
	*/
	
	public ContactPerson create(ContactPerson contactPerson)throws Exception
	{
		
		String urlString = url+"/contactpersons"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", contactPerson.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		return contactParser.getContactPerson(response);
	}
	
	/**
	
	* Get the contact person details.
	
	* Pass the contactPersonId to get the full details of a particular contact person.
	  
	* It returns a ContactPerson object.
	
	* @param contactId ID of the contact.
	
	* @param contactPersonId ID of the contact person.
	
	* @return Returns a ContactPerson object.
	
	*/
	
	public ContactPerson get(String contactId, String contactPersonId)throws Exception
	{
		
		String urlString = url+"/"+contactId+"/contactpersons/"+contactPersonId;  //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		ContactPerson contactPerson = contactParser.getContactPerson(response);
		
		return contactPerson;
	}
	
	/**
	
	* Update an existing contact person.
	
	* Pass the ContactPerson object to update the details of a contact person.
	  
	* The ContactPerson object must contain the contactPersonId for which contact person details has to be updated.
	  
	* If the contact person details has been updated it returns a ContactPerson object.
	
	
	* @param contactPerson ContactPerson object.
	
	* @return Returns a ContactPerson object.
	
	*/
	
	public ContactPerson update(ContactPerson contactPerson)throws Exception
	{
		
		String urlString = url+"/contactpersons/"+contactPerson.getContactPersonId(); //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", contactPerson.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return contactParser.getContactPerson(response);
	}
	
	/**
	
	* Delete an existing contact person.
	
	* Pass the contact person id to delete the contact person.
	  
	* If the contact person has been deleted it returns the success message.
	  
	* The success message is "The contact person has been deleted."
	
	
	* @param contactPersonId ID of the contact person.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String contactPersonId)throws Exception
	{
		
		String urlString = url+"/contactpersons/"+contactPersonId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = contactParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark a contact person as primary for a contact.
	
	* Pass the contact person id to change the status of the particular contact person as primary for the contact.
	  
	* If the contact person status has been changed it returns the success message.
	  
	* The message is "This contact person has been marked as your primary contact person." 
	
	
	* @param contactPersonId ID of the contact person.
	
	* @return Returns a String.
	
	*/
	
	public String markAsPrimaryContactPerson(String contactPersonId)throws Exception
	{
		
		String urlString = url+"/contactpersons/"+contactPersonId+"/primary"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = contactParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List contact persons of a contact with pagination.
	
	* Pass the contact id to get all the contact persons for the contact.
	  
	* It will return the ContactPersonList object.

	
	* @param contactId ID of contact to which contact persons has to be created.
	
	* @return Returns list of ContactPerson object.
	
	*/
	
	public ContactPersonList getContactPersons(String contactId)throws Exception
	{
		
		String urlString = url+"/"+contactId+"/contactpersons"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		ContactPersonList contactPersonList = contactParser.getContactPersons(response);
		
		return contactPersonList;
	}
}
