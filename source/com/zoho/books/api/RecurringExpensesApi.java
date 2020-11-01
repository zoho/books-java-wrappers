/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.RecurringExpenseParser;

import com.zoho.books.model.RecurringExpense;
import com.zoho.books.model.RecurringExpenseList;
import com.zoho.books.model.ExpenseList;
import com.zoho.books.model.CommentList;

import java.util.HashMap;


/**

* RecurringExpensesApi is used to create a new recurring expense.

* It is used to get:<br><br>

	The list of all recurring expenses.<br>
	
	The details of a recurring expense.<br>
	
	The child expenses created from recurring expense.<br>
	
	The list of all comments for the recurring expense.<br><br>
	
* It is used to change the status:<br><br>

	Stop an active recurring expense.<br>
	
	Resume a stopped recurring expense.<br><br>
	
* It is used to update the details of a recurring expense.<br>

* It is used to delete an existing recurring expense.

*/

public class RecurringExpensesApi extends API
{
	private static String url = baseURL+"/recurringexpenses"; //No I18N

	
	/**
	
	* Construct a new RecurringExpensesApi using user's accessToken and organizationid.
	
	* @param accessToken user's accessToken.
	
	* @param organizationId user's organization id.
	
	*/

	public RecurringExpensesApi(String accessToken, String organizationId)
	{
		
		super(accessToken, organizationId);
		
	}
	
	
	private RecurringExpenseParser recurringExpenseParser = new RecurringExpenseParser();
	
	
	
	/**
	
	* Create a recurring expense.
	
	* Pass the RecurringExpense object to create a new recurring expense.
	
	* The RecurringExpense object which contains accountId, paidThroughAccountId, recurrenceName, startDate, recurrenceFrequency, repeatEvery, and amount are the mandatory parameters.
	
	* It returns the RecurringExpense object.
	
	
	* @param recurringExpense RecurringExpense object.
	
	* @return  Returns the RecurringExpense object. 
	
	*/
	
	public RecurringExpense create(RecurringExpense recurringExpense)throws Exception
	{
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", recurringExpense.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody, accessToken);
		
		return recurringExpenseParser.getRecurringExpense(response);
		
	}
	
	/**
	
	* Get the details of a recurring expense.
	
	* Pass the recurringExpenseId to get the details of a recurring expense.
	
	* It returns the RecurringExpense object.
	
	
	* @param recurringExpenseId ID of the recurring expense.
	
	* @return Returns the RecurringExpense object. 
	
	*/
	
	public RecurringExpense get(String recurringExpenseId)throws Exception
	{
		
		String urlString = url+"/"+recurringExpenseId;
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		RecurringExpense recurringExpense = recurringExpenseParser.getRecurringExpense(response);
		
		return recurringExpense;	
		
	}
	
	/**
	
	* Update an existing recurring expense.
	
	* Pass the RecurringExpense object to update the details of a recurring expense.
	
	* The RecurringExpense object which contains recurringExpenseId is the mandatory parameter for which recurring expense has to be updated.
	
	* It returns the RecurringExpense object.
	
	
	* @param recurringExpense RecurringExpense object.
	
	* @return Returns the RecurringExpense object. 
	
	*/
	
	public RecurringExpense update(RecurringExpense recurringExpense)throws Exception
	{
		String urlString = url+"/"+recurringExpense.getRecurringExpenseId();
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", recurringExpense.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return recurringExpenseParser.getRecurringExpense(response);
	}
	
	/**
	
	* Delete an existing recurring expense.
	
	* Pass the recurringExpenseId to delete the recurring expense.
	
	* If the recurring expense has been deleted it returns the success message.
	
	* The success message is "The recurring expense has been deleted."
	
	
	* @param recurringExpenseId ID of the recurring expense.
	
	* @return Returns a String. 
	
	*/
	
	public String delete(String recurringExpenseId)throws Exception
	{
		
		String urlString = url+"/"+recurringExpenseId;
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = recurringExpenseParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List recurring expenses with pagination.
	
	* Pass the filters to get all the recurring expenses based on the filters.
	
	* It returns the RecurringExpenseList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
		
				<tr><td>recurrence_name</td><td>Search recurring expenses by recurring expense name.<br>
Variants: <i>recurrence_name_startswith</i> and <i>recurrence_name_contains</i></td></tr>
		
				<tr><td>last_created_date</td><td>Search recurring expenses by date on when last expense was generated.<br>
Variants: <i>last_created_date_start, last_created_date_end, last_created_date_before</i> and <i>last_created_date_after</i></td></tr>
		
				<tr><td>next_expense_date</td><td>Search recurring expenses by date on which next expense will be generated.<br>
Variants: <i>next_expense_date_start, next_expense_date_end, next_expense_date_before</i> and <i>next_expense_date_after</i></td></tr>
		
				<tr><td>amount</td><td>Search recurring expenses by amount.<br>
Variants: <i>amount_less_than, amount_less_equals, amount_greater_than</i> and <i>amount_greater_equals</i></td></tr>
		
				<tr><td>account_name</td><td>Search recurring expenses by expense account.<br>
Variants: <i>account_name_startswith</i> and <i>account_name_contains</i></td></tr>
		
				<tr><td>customer_name</td><td>Search recurring expenses by customer name.<br>
Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
		
				<tr><td>vendor_name</td><td>Search recurring expenses by vendor name.<br>
Variants: <i>vendor_name_startswith</i> and <i>vendor_name_contains</i></td></tr>
		
				<tr><td>customer_id</td><td>Search recurring expenses by customer id.</td></tr>
		
				<tr><td>vendor_id</td><td>Search recurring expenses by vendor id.</td></tr>
		
				<tr><td>paid_through_account_id</td><td>Search expenses by paid through account id.</td></tr>
		
				<tr><td>description</td><td>Search recurring expenses by description.<br>
Variants: <i>description_startswith</i> and <i>description_contains</i></td></tr>
		
				<tr><td>search_text</td><td>Search recurring expenses by recurrence name or customer name.</td></tr>
	
				<tr><td>status</td><td>Search recurring expenses by recurring expense status.<br>
Allowed Values: <i>active, stopped</i> and <i>expired</i></td></tr>
		
				<tr><td>filter_by</td><td>Filter recurring expenses by status.<br>
Allowed Values: <i>RecExpenseStatus.All, RecExpenseStatus.Active, RecExpenseStatus.Stopped</i> and <i>RecExpenseStatus.Expired</i></td></tr>
		
				<tr><td>sort_column</td><td>Sort recurring expenses.<br>
Allowed Values: <i>recurrence_name, last_created_date, next_expense_date, account_name, paid_through_account_name, total, customer_name, vendor_name</i> and <i>created_time</i></td></tr>
		
		
			</tbody>
			
		</table>
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the RecurringExpenseList object. 
	
	*/
	
	public RecurringExpenseList getRecurringExpenses(HashMap<String, Object> queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap), accessToken);
		
		RecurringExpenseList recurringExpenseList = recurringExpenseParser.getRecurringExpenses(response);
		
		return recurringExpenseList;
	}
	
	/**
	
	* Resume a stopped recurring expense.
	
	* Pass the recurringExpenseId to chenge the status of a recurring expense to 'resume'.
	
	* If the recurring expense status has been changed it returns the success message.
	
	* The success message is "The recurring expense has been activated."
	
	
	* @param recurringExpenseId  ID of the recurring expense.
	
	* @return Returns a String. 
	
	*/
	
	public String resume(String recurringExpenseId)throws Exception
	{
		
		String urlString = url+"/"+recurringExpenseId+"/status/resume"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = recurringExpenseParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Stop an active recurring expense.
	
	* Pass the recurringExpenseId to chenge the status of a recurring expense to 'stop'.
	
	* If the recurring expense status has been changed it returns the success message.
	
	* The success message is "The recurring expense has been stopped."
	
	
	* @param recurringExpenseId ID of the recurring expense.
	
	* @return Returns a String. 
	
	*/
	
	public String stop(String recurringExpenseId)throws Exception
	{
		
		String urlString = url+"/"+recurringExpenseId+"/status/stop"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = recurringExpenseParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List child expenses created from recurring expense.
	
	* Pass the recurringExpenseId and filters to get all the child expenses based on the filters.
	
	* It returns the ExpenseList object.<br>
	
	* The queryMap contains the possible key and value as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>sort_column</td><td>Sort child expenses created.<br>
Allowed Values: <i>date, account_name, vendor_name, paid_through_account_name, customer_name</i> and <i>total</i></td></tr>
		
			</tbody>
			
		</table>
	
	* @param recurringExpenseId  ID of the recurring expense.
	
	* @param queryMap Sort child expenses created.
	
	* @return Returns the ExpenseList object. 
	
	*/
	
	public ExpenseList getExpensesCreated(String recurringExpenseId, HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/"+recurringExpenseId+"/expenses"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);
		
		ExpenseList expenseList = recurringExpenseParser.getExpensehistory(response);
		
		return expenseList;
	}
	
	/**
	
	* Get history and comments of a recurring expense.
	
	* Pass the recurringExpenseId to get all the comments for the recurring expense.
	
	* It returns the CommentList object.
	
	
	* @param recurringExpenseId  ID of the recurring expense.
	
	* @return Returns the CommentList object. 
	
	*/
	
	public CommentList getComments(String recurringExpenseId)throws Exception
	{
		
		String urlString = url+"/"+recurringExpenseId+"/comments"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		CommentList commentList = recurringExpenseParser.getComments(response);
		
		return commentList;
	}
}
