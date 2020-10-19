/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.BankAccountParser;

import com.zoho.books.model.BankAccount;
import com.zoho.books.model.Statement;
import com.zoho.books.model.BankAccountList;

import java.util.HashMap;


/**

* BankAccountsApi is used to create a bank account or credit card account for the organization.

* It is used to get:<br><br>

	The list of bank accounts.<br>
	
	The details of a bank account.<br><br>
	
* It is used to change the status of an account:<br><br>

	Make an account active.<br>
	
	Make an account inactive.<br><br>

* It is used to update the details of an account.<br>

* It is used to delete an account.


*/

public class BankAccountsApi extends API
{
	
	private static String url = baseURL+"/bankaccounts"; //No I18N
	
	
	/**
	
	* Construct a new BankAccountsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/
	
	public BankAccountsApi(String authToken, String organizationId)
	{
			
			super(authToken, organizationId);
		
	}
	
	
	private BankAccountParser bankAccountParser = new BankAccountParser();
	
	
	/**
	
	* List all bank and credit card accounts for your organization.
	
	* Pass the filters to get all the bank accounts based on the filters.
	
	* It returns the BankAccountList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			<tbody>
				<tr><td>filter_by</td><td>Filter the account by their status.<br>
Allowed Values: <i>Status.All, Status.Active</i> and <i>Status.Inactive</i></td></tr>

				<tr><td>sort_column</td><td>Sort the values based on the allowed values.<br> 
Allowed Values: <i>account_name</i> and <i>account_type</i></td></tr>
			</tbody>
		</table>
	
	* @param queryMap It contains the query string values in the form of key-value pair.
	
	* @return Returns the BankAccountList object.
	
	*/
	
	public BankAccountList getBankaccounts(HashMap<String, Object> queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap), accessToken);
		
		BankAccountList bankAccountList = bankAccountParser.getBankAccounts(response); 
		
		return bankAccountList;
	}
	
	/**
	
	* Create a bank account or a credit card account for your organization.
	
	* Pass the BankAccount object to create a new bank account for the organization.
	
	* The BankAccount object which contains accountName, accountType are the mandatory parameters.
	
	* It returns the BankAccount object.
	
	
	* @param bankAccount BankAccount object.
	
	* @return Returns the BankAccount object.
	
	*/
	
	public BankAccount create(BankAccount bankAccount)throws Exception
	{
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", bankAccount.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody, accessToken);
		
		return bankAccountParser.getBankAccount(response);
		
	}
	
	/**
	
	* Get the details of the account specified.
	
	* Pass the accountId to get the details of a bank account.
	
	* It returns the BankAccount object.
	
	
	* @param accountId ID of the bank account.
	
	* @return Returns the BankAccount object.
	
	*/
	
	public BankAccount get(String accountId)throws Exception
	{
			
		String urlString = url+"/"+accountId; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		BankAccount bankAccount = bankAccountParser.getBankAccount(response);
		
		return bankAccount;
	}
	
	/**
	
	* Modify the account that was created.
	
	* Pass the BankAccount object to update the details of a bank account.
	
	* The BankAccount object which contains accountId is the mandatory parameter for which bank account details have to be updated.
	
	* It returns the BankAccount object.
	
	
	* @param bankAccount BankAccount object.
	
	* @return Returns the BankAccount object.
	
	*/
	
	public BankAccount update(BankAccount bankAccount)throws Exception
	{
		String urlString = url+"/"+bankAccount.getAccountId(); //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", bankAccount.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return bankAccountParser.getBankAccount(response);
	}
	
	/**
	
	* Delete a bank account from your organization.
	
	* Pass the accountId to delete a bank account from the organization.
	
	* If the account has been deleted it returns the success message.
	
	* The success message is "The account has been deleted."
	
	
	* @param accountId ID of the bank account.
	
	* @return Returns a String object.
	
	*/
	
	public String delete(String accountId)throws Exception
	{
		
		String urlString = url+"/"+accountId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String message = bankAccountParser.getMessage(response);
		
		return message;
	}
	
	/**
	
	* Make an account inactive.
	
	* Pass the accountId to change the status of a bank account to 'inactive'.
	
	* If the bank account status has been changed it returns the success message.
	
	* The success message is "The account has been marked as inactive."
	
	
	* @param accountId ID of the bank account.
	
	* @return Returns a String object.
	
	*/
	
	public String deactivateAccount(String accountId)throws Exception
	{
		
		String urlString = url+"/"+accountId+"/inactive"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String message = bankAccountParser.getMessage(response);
		
		return message;
	}
	
	/**
	
	* Make an account active.
	
	* Pass the accountId to change the status of a bank account to 'active'.
	
	* If the bank account status has been changed it returns the success message.
	
	* The success message is "The account has been marked as active."
	
	
	* @param accountId ID of the bank account.
	
	* @return Returns a String object.
	
	*/
	
	public String activateAccount(String accountId)throws Exception
	{
		
		String urlString = url+"/"+accountId+"/active"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String message = bankAccountParser.getMessage(response);
		
		return message;
	}
	
	/**
	
	* Get the details of previously imported statement for the account.
	
	* Pass the accountId to get the last imported statements of the bank account.
	
	* It returns the Statement object.
	
	
	* @param accountId ID of the bank account.
	
	* @return Returns the Statement object.
	
	*/
	
	public Statement getLastImportedStatement(String accountId)throws Exception
	{
		
		String urlString = url+"/"+accountId+"/statement/lastimported"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		Statement statement = bankAccountParser.getStatement(response);
		
		return statement;
	}
	
	/**
	
	* Delete the statement that was previously imported.
	
	* Pass the accountId and statementId to delete the last imported statement of the bank account.
	
	* If the last imported statement has been deleted it returns the success message.
	
	* The success message is "You have successfully deleted the last imported statement."
	
	
	* @param accountId ID of the bank account.
	
	* @param statementId Statement ID of the bank account.
	
	* @return Returns a String object.
	
	*/
	
	public String deleteLastImportedStatement(String accountId, String statementId)throws Exception
	{
		
		String urlString = url+"/"+accountId+"/statement/"+statementId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String message = bankAccountParser.getMessage(response);
		
		return message;
	}
	
}
