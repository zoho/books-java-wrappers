/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.SettingsParser;

import com.zoho.books.model.User;
import com.zoho.books.model.UserList;

import java.util.HashMap;


/**

* UsersApi is used to create the users of the Organization.

* It is used to get and update the details of a particular user.<br>

* It is used to get:<br><br>
	
	The list of users for the organization.<br>

	The current user for the organization.<br><br>

* It is used to Invite a new user to the organization.<br>

* It is used to Change the status of an user into active or inactive.<br>

* It is used to Delete a particular user from the organization.

*/

public class UsersApi extends API
{
	
	private static String url = baseURL+"/users"; //No I18N

	
	/**
	
	* Construct a new UsersApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public UsersApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	
	private SettingsParser settingsParser = new SettingsParser();
	
	
	
	/**
	
	* Get the list of all users in the organization.
	
	* Pass the filters in the form of key, value pair to get all the users from the organization based on the filter.
	
	* It returns the UserList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>filter_by</td><td>Filter through users with user status. <br>
Allowed Values: <i>Status.All, Status.Active, Status.Inactive, Status.Invited</i> and <i>Status.Deleted</i></td></tr>

				<tr><td>sort_column</td><td>Sort users.<br>
Allowed Values: <i>name, email, user_role</i> and <i>status</i></td></tr>
			</tbody>
		
		</table> 
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the UserList object.
	
	*/
	
	public UserList getUsers(HashMap queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));
		
		UserList userList = settingsParser.getUsers(response);
		
		return userList;
	}
	
	/**
	
	* Get the details of a user.
	
	* Pass the userId to get the details of a particular user.
	
	* It returns the User object.
	
	
	* @param userId ID of the user.
	
	* @return Returns the User object.
	
	*/

	public User get(String userId)throws Exception
	{
		
		String urlString = url+"/"+userId;
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap());
		
		User user = settingsParser.getUser(response);
		
		return user;
	}
	
	/**
	
	* Get the details of the current user.
	
	* Call this method to get the current user for the organization.
	
	* It returns the User object.
	
	
	* @return Returns the User object.
	
	*/
	
	public User getCurrentUser()throws Exception
	{
		
		String urlString = url+"/me"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap());
		
		User user = settingsParser.getUser(response);
		
		return user;
	}
	
	/**
	
	* Create a user for your organization.
	
	* Pass the User object to create a new user for the organization.
	
	* The User object which contains name and email are mandatory parameters.
	
	* It returns the User object.
	
	
	* @param user User object.
	
	* @return Returns the User object.
	
	*/
	
	public User create(User user)throws Exception
	{
		
		HashMap	requestBody = getQueryMap();
		
		requestBody.put("JSONString", user.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		return settingsParser.getUser(response);
	}
	
	/**
	
	* Update the details of a user.
	
	* Pass the User object to update the details of a particular user.
	
	* The User object must contain the userId for which user details has to be updated.
	
	* It returns the User object.
	
	
	* @param user User object.
	
	* @return Returns the User object.
	
	*/
	
	public User update(User user)throws Exception
	{
		
		String urlString = url+"/"+user.getUserId();
		
		HashMap	requestBody = getQueryMap();
		
		requestBody.put("JSONString", user.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		return settingsParser.getUser(response);
	}
	
	/**
	
	* Delete a user associated to the organization.
	
	* Pass the userId to delete the user from the users.
	
	* If the user has been deleted it returns the success message.
	
	* The success message is "The user has been removed from your organization."
	
	
	* @param userId ID of the user.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String userId)throws Exception
	{
		
		String urlString = url+"/"+userId;
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap());
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Send invitation email to a user.
	
	* Pass the user id to send an invitation for the user.
	
	* If the invitation has been sent to the user it returns the success message.
	
	* The success message is "Your invitation has been sent."
	 
	
	* @param userId ID of the user.
	
	* @return Returns a String.
	
	*/
	
	public String inviteUser(String userId)throws Exception
	{
		
		String urlString = url+"/"+userId+"/invite"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark an inactive user as active.
	
	* Pass the userId to change the status of an user to 'active'.
	
	* If the user status has been changed it returns the success message.
	
	* The success message is "The user has been marked as active."
	
	
	* @param userId ID of the user.
	
	* @return Returns a String.
	
	*/
	
	public String markUserAsActive(String userId)throws Exception
	{
		
		String urlString = url+"/"+userId+"/active"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Mark an active user as inactive.
	
	* Pass the user id to change the status of an user to 'inactive'.
	
	* If the user status has been changed it returns the success message.
	
	* The success message is "The user has been marked as inactive."
	
	
	* @param userId ID of the user.
	
	* @return Returns a String.
	
	*/
	
	public String markUserAsInactive(String userId)throws Exception
	{
		
		String urlString = url+"/"+userId+"/inactive"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String success = settingsParser.getMessage(response);
		
		return success;
	}
}
