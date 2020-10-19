/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.ChartOfAccountParser;

import com.zoho.books.model.ChartOfAccount;
import com.zoho.books.model.ChartOfAccountList;
import com.zoho.books.model.TransactionList;

import java.util.HashMap;


/**

* ChartOfAccountsApi is used to create a chart of account.

* It is used to get:<br><br>

	The list of all chart of accounts.<br>
	
	The details of a chart of account.<br>
	
	The list transaction for an account.<br><br>
	
* It is used to change the status:<br><br>

	Mark an account as active.<br>
	
	Mark an account as inactive.<br><br>
	
* It is used to update the details of a chart of account.<br>

* It is used to delete:<br><br>

	The particular chart of account.<br>
	
	The transaction for an account.<br>
	

*/

public class ChartOfAccountsApi extends API
{
	
	private static String url = baseURL+"/chartofaccounts"; //No I18N


	/**
	
	* Construct a new ChartOfAccountsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public ChartOfAccountsApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	
	private ChartOfAccountParser chartOfAccountParser = new ChartOfAccountParser();
	
	
	/**
	
	* Create an account with the given account type.
	
	* Pass the ChartOfAccount object to create a chart of account.
	
	* The ChartOfAccount object which contains accountType is the mandatory parameter.
	
	* It returns the ChartOfAccount object.
	
	
	* @param chartOfAccount ChartOfAccount object.
	
	* @return Returns the ChartOfAccount object.
	
	*/
	
	public ChartOfAccount create(ChartOfAccount chartOfAccount)throws Exception
	{
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", chartOfAccount.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody, accessToken);
		
		return chartOfAccountParser.getChartOfAccount(response);
		
	}
	
	/**
	
	* Get the details of an account.
	
	* Pass the accountId to get the details of a chart of account.
	
	* It returns the ChartOfAccount object.
	
	
	* @param accountId ID of the account.
	
	* @return Returns the ChartOfAccount object.
	
	*/
	
	public ChartOfAccount get(String accountId)throws Exception
	{
		
		String urlString = url+"/"+accountId;
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		ChartOfAccount chartOfAccount = chartOfAccountParser.getChartOfAccount(response);
		
		return chartOfAccount;
	}
	
	/**
	
	* Update the account information.
	
	* Pass the ChartOfAccount object to update the details of a chart of account.
	
	* The ChartOfAccount object which contains accountId is the mandatory parameter for which chart of account has to be changed.
	
	* It returns the ChartOfAccount object.
	 
	
	* @param chartOfAccount ChartOfAccount object.
	
	* @return Returns the ChartOfAccount object.
	
	*/
	
	public ChartOfAccount update(ChartOfAccount chartOfAccount)throws Exception
	{
		
		String urlString = url+"/"+chartOfAccount.getAccountId();
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", chartOfAccount.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return chartOfAccountParser.getChartOfAccount(response);
		
	}
	
	/**
	
	* Delete the given account (Accounts associated with any transaction/products cannot be deleted).
	
	* Pass the accountId to delete the chart of account.
	
	* If the chart of account has been deleted it returns the success message.
	
	* The success message is "The account has been deleted."
	
	
	* @param accountId ID of the account.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String accountId)throws Exception
	{
		
		String urlString = url+"/"+accountId;
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = chartOfAccountParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Update the account status as inactive.
	
	* Pass the accountId to change the status of a chart of account to 'inactive'.
	
	* If the chart of account status has been changed it returns the success message.
	
	* The success message is "The account has been marked as inactive."
	
	
	* @param accountId ID of the account.
	
	* @return Returns a String.
	
	*/
	
	public String markAsInactive(String accountId)throws Exception
	{	
		
		String urlString = url+"/"+accountId+"/inactive"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = chartOfAccountParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Update the account status as active.
	
	* Pass the accountId to change the status of a chart of account to 'active'.
	
	* If the chart of account status has been changed it returns the success message.
	
	* The success message is "The account has been marked as active."
	
	
	* @param accountId ID of the account.
	
	* @return Returns a String.
	
	*/
	
	public String markAsActive(String accountId)throws Exception
	{	
		
		String urlString = url+"/"+accountId+"/active"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = chartOfAccountParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List all chart of accounts along with pagination.
	
	* Pass the filters to get all the chart of accounts based on the filters.
	
	* It returns the ChartOfAccountList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1" >
			<tbody>
				<tr><td>showbalance</td><td>Boolean to get current balance of accounts.</td></tr>
				
				<tr><td>filter_by</td><td>Filter accounts based on its account type and status.<br>
Allowed Values: <i>AccountType.All, AccountType.Active, AccountType.Inactive, AccountType.Asset, AccountType.Liability, AccountType.Equity, AccountType.Income</i> and <i>AccountType.Expense</i></td></tr>
				
				<tr><td>sort_column</td><td>Sort accounts<br>
Allowed Values: <i>account_name</i> and <i>account_type</i></td></tr>
			</tbody>
		</table>
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the ChartOfAccountList object.
	
	*/
	
	public ChartOfAccountList getChartOfAccounts(HashMap<String, Object> queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap), accessToken);
		
		ChartOfAccountList chartOfAccountList = chartOfAccountParser.getChartOfAccounts(response);
		
		return chartOfAccountList;
	}
	
	/**
	
	* List all involved transactions for the given account.
	
	* Pass the accountId and filters to get all the transactions based on the filters.
	
	* It returns the TransactionList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			<tbody>
				<tr><td>account_id</td><td>ID of the account. List all transactions involved this account.</td></tr>
				
				<tr><td>date</td><td>Search account transactions with the given date range. Default date format is yyyy-mm-dd.<br>
Variants: <i>date.start, date.end, date.before</i> and <i>date.after</i></td></tr>

				<tr><td>amount</td><td>Search account transactions with given amount range. <br>
Variants: <i>amount.less_than, amount.less_equals, amount.greater_than</i> and <i>amount.greater_equals</i></td></tr>

				<tr><td>filter_by</td><td>Filter transactions based on its type. <br>
Allowed Values: <i>TransactionType.All, TransactionType.BaseCurrencyAdjustment, TransactionType.Bills, TransactionType.VendorPayment, TransactionType.CardPayment, TransactionType.CreditNotes, TransactionType.CreditNoteRefund, TransactionType.Deposit, TransactionType.Expense, TransactionType.Invoice, TransactionType.Journal, TransactionType.CustomerPayment, TransactionType.TransferFund</i> and <i>TransactionType.OpeningBalance</i></td></tr>

				<tr><td>transaction_type</td><td>Search transactions based on the given transaction type. <br>
Allowed Values: <i>invoice, customer_payment, bills, vendor_payment, credit_notes, creditnote_refund, expense, card_payment, purchase_or_charges, journal, deposit, refund, transfer_fund, base_currency_adjustment, opening_balance, sales_without_invoices, expense_refund, tax_refund, receipt_from_initial_debtors, owner_contribution, interest_income, other_income, owner_drawings</i> and <i>payment_to_initial_creditors</i></td></tr>

				<tr><td>sort_column</td><td>Sort transactions. <br>
Allowed Values: <i>transaction_date, payee, glname, transaction_type_formatted, reconcile_status, debit_amount</i> and <i>credit_amount</i></td></tr>
			</tbody>
		</table> 
	
	* @param accountId ID of the account. List all transactions involved this account.
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the TransactionList object.
	
	*/
	
	public TransactionList getTransactions(String accountId, HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/transactions"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);
		
		TransactionList transactionList = chartOfAccountParser.getTransactions(response);
		
		return transactionList;
	}
	
	/**
	
	* Delete the transaction.
	
	* Pass the transactionId to delete the transaction for the chart of account.
	
	* If the transaction has been deleted it returns the success message.
	
	* The success message is "The transaction has been deleted."
	
	
	* @param transactionId ID of the transaction.
	
	* @return Returns a String.
	
	*/
	
	public String deleteTransaction(String transactionId)throws Exception
	{
		
		String urlString = url+"/transactions/"+transactionId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = chartOfAccountParser.getMessage(response);
		
		return success;
	}
}
