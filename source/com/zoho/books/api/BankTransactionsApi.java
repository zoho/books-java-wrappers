/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.BankTransactionParser;
import com.zoho.books.parser.CreditNoteParser;
import com.zoho.books.parser.VendorPaymentParser;
import com.zoho.books.parser.CustomerPaymentParser;
import com.zoho.books.parser.ExpenseParser;

import com.zoho.books.model.Transaction;
import com.zoho.books.model.TransactionList;
import com.zoho.books.model.CreditnoteRefund;
import com.zoho.books.model.VendorPayment;
import com.zoho.books.model.CustomerPayment;
import com.zoho.books.model.Expense;

import java.io.File;
import java.util.List;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

/**

* BankTransactionsApi is used to create a transaction for an account.

* It is used to get:<br><br>

	The list of all transactions.<br>
	
	The details of a transaction.<br>
	
	The matching transactions.<br>
	
	The list of all associated transactions.<br><br>
	
* It is used to update the details of a transaction.<br><br>

* It is used to:<br><br>

	Match a transaction.<br>
	
	Unmatch a matched transaction.<br>
	
	Exclude a transaction.<br>
	
	Restore an excluded transaction.<br>
	
	Categorize an uncategorized transaction.<br>
	
	Categorize as credit note refunds.<br>
	
	Categorize as vendor payment.<br>
	
	Categorize as customer payment.<br>
	
	Categorize as expense.<br>
	
	Uncategorize a categorized transaction.<br><br>
	
* It is used to delete a transaction.
	

*/

public class BankTransactionsApi extends API
{
	
	private static String url = baseURL+"/banktransactions"; //No I18N
	
	/**
	
	* Construct a new BankTransactionsApi using user's authtoken and organization id.
	
	* @param authToken user's authtoken.
	
	* @param organizationId user's organization id.
	
	*/

	public BankTransactionsApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	private BankTransactionParser bankTransactionParser = new BankTransactionParser();
	
	
	
	/**
	
	* Get all the transaction details involved in an account.
	
	* Pass the filters to get all the transactions based on the filters.
	
	* It returns the TransactionList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			<tbody>
				<tr><td>account_id*</td><td>Mandatory Account id for which transactions are to be listed.</td></tr>
				
				<tr><td>filter_by</td><td>Filters the transactions based on the allowed types.<br>
Allowed Values: <i>Status.All, Status.Uncategorized, Status.Categorized, Status.ManuallyAdded, Status.Excluded</i> and <i>Status.Matched</i></td></tr>

				<tr><td>date</td><td>Start and end date, to provide a range within which the transaction date exist.<br>
Variants: <i>date_start</i> and <i>date_end</i></td></tr>

				<tr><td>amount</td><td>Start and end amount, to provide a range within which the transaction amount exist.<br>
Variants: <i>amount_start</i> and <i>amount_end</i></td></tr>

				<tr><td>status</td><td>Transaction status wise list view - All, uncategorized, manually_added, matched, excluded, categorized</td></tr>
				
				<tr><td>reference_number</td><td>Reference Number of the transaction</td></tr>
				
				<tr><td>sort_column</td><td>Sorts the transactions based on the allowed sort types. <br>
Allowed Values: <i>date</i></td></tr>
			</tbody>
		</table>
	
	* @param queryMap It contains the querystring values in the form of key-value pair.
	
	* @return Returns the TransactionList object.
	
	*/
	
	public TransactionList getTransactions(HashMap<String, Object> queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));
		
		TransactionList transactionsList = bankTransactionParser.getTransactions(response); 
		
		return transactionsList;
	}
	
	/**
	
	* Fetch the details of a transaction by specifying the transaction_id.
	
	* Pass the transactionId to get the details of a transaction.
	
	* It returns the Transaction object.
	
	
	* @param transactionId ID of the transaction.
	
	* @return Returns the Transaction object.
	
	*/
	
	public Transaction get(String transactionId)throws Exception
	{
		String urlString = url+"/"+transactionId; 
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap());
		
		Transaction transaction = bankTransactionParser.getTransaction(response); 
		
		return transaction;
	}
	
	/**
	
	* Create a bank transaction based on the allowed transaction types.
	
	* Pass the Transaction object to create a new bank transaction.
	
	* The Transaction object which contains transactionType is the mandatory parameter.
	
	* It returns the Transaction object.
	 
	
	* @param transaction Transaction object. 
	
	* @return Returns the Transaction object.
	
	*/
	
	public Transaction create(Transaction transaction)throws Exception
	{
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", transaction.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody);
		
		return bankTransactionParser.getTransaction(response);
	}
	
	/**
	
	* Make changes in the applicable fields of a transaction and update it.
	
	* Pass the Transaction object to update the details of a bank transaction.
	
	* The Transaction object which contains transactionId is the mandatory parameter for which bank transaction has to be updated.
	
	* It returns the Transaction object.
	
	
	* @param transaction Transaction object. 
	
	* @return Returns the Transaction object.
	
	*/
	
	public Transaction update(Transaction transaction)throws Exception
	{
		
		String urlString = url+"/"+transaction.getTransactionId(); //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", transaction.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody);
		
		return bankTransactionParser.getTransaction(response);
	}
	
	/**
	
	* Delete a transaction from an account by specifying the transactionId.
	
	* Pass the transactionId to delete the bank transaction.
	
	* If the transaction has been deleted it returns the success message.
	
	* The success message is "The transaction has been deleted."
	
	
	* @param transactionId ID of the transaction. 
	
	* @return Returns the String object.
	
	*/
	
	public String delete(String transactionId)throws Exception
	{
		String urlString = url+"/"+transactionId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap());
		
		String message = bankTransactionParser.getMessage(response); 
		
		return message;
	}
	
	/**
	
	* Provide criteria to search for matching uncategorised transactions.
	
	* Pass the transactionId and filters to get all the matching transactions based on the filters.
	
	* It returns the TransactionList object.<br>
	
	* The queryMap contains the below listed possible keys and values as mentioned below:<br>
	
		<table border = "1">
			<tbody>
				<tr><td>transaction_type</td><td>The type of transaction. <br>
Allowed Values: <i>expense, deposit, refund, transfer_fund, card_payment, sales_without_invoices, expense_refund, owner_contribution, interest_income, other_income, owner_drawings, invoice, bill, credit_notes, creditnote_refund, customer_payment</i> and <i>vendor_payment</i></td></tr>
				
				<tr><td>date</td><td>Start and end date, to provide a range within which the transaction date exist.<br>
Variants: <i>date_start</i> and <i>date_end</i></td></tr>

				<tr><td>amount</td><td>Initial and final amount range within which the search amount exists.<br>
Variants: <i>amount_start</i> and <i>amount_end</i></td></tr>

				<tr><td>contact</td><td>Contact person name, involved in the transaction.</td></tr>
				
				<tr><td>reference_number</td><td>Reference Number of the transaction.</td></tr>
			</tbody>
		</table>  
	
	* @param transactionId ID of the transaction. 
	
	* @param queryMap It contains the querystring values in the form of key-value pair.
	
	* @return Returns the TransactionList object.
	
	*/
	
	public TransactionList getMatchingTransactions(String transactionId, HashMap<String, Object> queryMap)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/match"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));
		
		TransactionList transactionsList = bankTransactionParser.getTransactions(response); 
		
		return transactionsList;
	}
	
	/**
	
	* Match an uncategorized transaction with an existing transaction in the account.
	
	* Pass the transactionId and list of Transaction objects to match an uncategorized transaction.
	
	* The Transaction objects which contains transactionId and transactionType are the mandatory parameters.
	
	* If the transaction is uncategorized it returns the success message.
	
	* The success message is "The Uncategorized transaction is linked to the selected transaction(s) in Zoho Books."
	
	
	* @param transactionId ID of the transaction. 
	
	* @param transactions List of Transaction object.
	
	* @return Returns the String object.
	
	*/
	
	public String matchTransaction(String transactionId, List<Transaction> transactions)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/match"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		JSONArray transactionMatched = new JSONArray();
		
		for(int i = 0; i < transactions.size(); i++)
		{
			JSONObject match = new JSONObject();
			
			match.put("transaction_id", transactions.get(i).getTransactionId());
			match.put("transaction_type", transactions.get(i).getTransactionType());
			
			transactionMatched.put(match);
		}
		
		jsonObject.put("transactions_to_be_matched", transactionMatched);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		String message = bankTransactionParser.getMessage(response); 
		
		return message;
	}
	
	/**
	
	* Unmatch a transaction that was previously matched and make it uncategorized.
	
	* Pass the transactionId to unmatch a matched transaction.
	
	* If the transaction has been unmatched it returns the success message.
	
	* The success message is "The transaction has been unmatched."
	
	
	* @param transactionId ID of the transaction. 
	
	* @return Returns the String object.
	
	*/
	
	public String unmatchTransaction(String transactionId)throws Exception
	{
		String urlString = url+"/"+transactionId+"/unmatch"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String message = bankTransactionParser.getMessage(response); 
		
		return message;
	}
	
	/**
	
	* Get a list of all the associated transactions that were matched or categorized to the given imported transaction.
	
	* Pass the transactionId and sortColumn to get the associated transaction based on the sort column.
	
	* It returns the Transaction object.
	
	
	* @param transactionId ID of the transaction.
	
	* @param sortColumn Sort column for the associate transaction. 
	
	* @return Returns the Transaction object.
	
	*/
	
	public Transaction getAssociateTransaction(String transactionId, String sortColumn)throws Exception
	{
		String urlString = url+"/"+transactionId+"/associated"; //No I18N
		
		HashMap<String, Object> queryMap = getQueryMap();
		
		if(sortColumn != null)
		{
			queryMap.put("sort_column", sortColumn);
		}
		
		String response = ZohoHTTPClient.get(urlString, queryMap);
		
		Transaction transaction = bankTransactionParser.getAssociateTransaction(response); 
		
		return transaction;
	}
	
	/**
	
	* Exclude a transaction from your bank or credit card account.
	
	* Pass the transactionId to exclude a transaction from your bank account.
	
	* If the transaction has been excluded it returns the success message.
	
	* The success message is "The transaction has been excluded."
	
	
	* @param transactionId ID of the transaction.
	
	* @return Returns the String object.
	
	*/
	
	public String excludeTransaction(String transactionId)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/exclude"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String message = bankTransactionParser.getMessage(response); 
		
		return message;
	}
	
	/**
	
	* Restore an excluded transaction in your account.
	
	* Pass the transactionId to restore the excluded transaction.
	
	* If the transaction has been restored it returns the success message.
	
	* The success message is "The excluded transaction has been restored."
	
	
	* @param transactionId ID of the transaction.
	
	* @return Returns the String object.
	
	*/
	
	public String restoreTransaction(String transactionId)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/restore"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String message = bankTransactionParser.getMessage(response); 
		
		return message;
	}
	

//==============================================================================================================================================

	
	/**
	
	* Categorize an uncategorized transaction by creating a new transaction.
	
	* Pass the Transaction object to categorize the transaction by creating a new transaction.
	
	* The Transaction object which contains transactionType is the mandatory parameter.
	
	* It returns the Transaction object.
	
	
	* @param transaction Transaction object.
	
	* @return Returns the Transaction object.
	
	*/
	
	
	public Transaction categorizeAnUncategorizeTransaction(Transaction transaction)throws Exception
	{
		
		String urlString = url+"/uncategorized/"+transaction.getTransactionId()+"/categorize"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", transaction.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		return bankTransactionParser.getTransaction(response);
	}
	
	/**
	
	* Categorize an Uncategorized transaction as a refund from a credit note.
	
	* Pass the transactionId and CreditnoteRefund object to categorize the transaction as a refund from the credit note.
	
	* The CreditnoteRefund object which contains creditNoteId and date are the mandatory parameters.
	
	* It returns the CreditnoteRefund object.
	 
	
	* @param transactionId ID of the transaction.
	
	* @param creditnoteRefund CreditnoteRefund object.
	
	* @return Returns the CreditnoteRefund object.
	
	*/
	
	public CreditnoteRefund categorizeAsCreditnoteRefunds(String transactionId, CreditnoteRefund creditnoteRefund)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/categorize/creditnoterefunds"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", creditnoteRefund.toJSON().put("creditnote_id", creditnoteRefund.getCreditnoteId()).toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		//String message = bankTransactionParser.getMessage(response); 
		
		return new CreditNoteParser().getCreditnoteRefund(response);
	}
	
	/**
	
	* Categorize an uncategorized transaction as Vendor Payment.
	
	* Pass the transactionId and VendorPayment object to categorize the transaction as vendor payment.
	
	* The VendorPayment object which contains vendorId and amount are the mandatory parameters.
	
	* It returns the VendorPayment object.
	
	
	* @param transactionId ID of the transaction.
	
	* @param vendorPayment VendorPayment object.
	
	* @return Returns the VendorPayment object.
	
	*/
	
	public VendorPayment categorizeAsVendorPayment(String transactionId, VendorPayment vendorPayment)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/categorize/vendorpayments"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", vendorPayment.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		return new VendorPaymentParser().getVendorPayment(response);
	}
	
	/**
	
	* Categorize an uncategorized transaction as Customer Payment.
	
	* Pass the transactionId and CustomerPayment object to categorize the transaction as customer payment.
	
	* The CustomerPayment object which contains date and amount are the mandatory parameters.
	
	* It returns the CustomerPayment object.
	
	
	* @param transactionId ID of the transaction.
	
	* @param customerPayment CustomerPayment object.
	
	* @return Returns the CustomerPayment object.
	
	*/
	
	public CustomerPayment categorizeAsCustomerPayment(String transactionId, CustomerPayment customerPayment)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/categorize/customerpayments"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", customerPayment.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody);
		
		return new CustomerPaymentParser().getCustomerPayment(response);
	}
	
	/**
	
	* Categorize an uncategorized transaction as Expense.
	
	* Pass the transactionId, Expense object, and File object to categorize the transaction as expense.
	
	* The Expense object which contains accountId, paidThroughAccountId, and amount are the mandatory parameters.
	
	* It returns the Expense object.
	 
	
	* @param transactionId ID of the transaction.
	
	* @param expense Expense object.
	
	* @param file Receipt file for the expense.
	
	* @return Returns the Expense object.
	
	*/
	
	public Expense categorizeAsExpense(String transactionId, Expense expense, File file)throws Exception
	{
		String urlString = url+"/uncategorized/"+transactionId+"/categorize/expense"; //No I18N
		
		HashMap<String, Object> requestBody = new HashMap<String, Object>();
		
		requestBody.put("JSONString", expense.toJSON().toString());
		
		HashMap<String, Object> fileBody = new HashMap<String, Object>();
		
		fileBody.put("receipt", file);
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), requestBody, fileBody);
		
		return new ExpenseParser().getExpense(response);
	}
	
	/**
	
	* Revert a categorized transaction as uncategorized.
	
	* Pass the transactionId to categorize the transaction as uncategorized.
	
	* If the transaction has been uncategorized it returns the success message.
	
	* The success message is "The transaction has been uncategorized."
	
	
	* @param transactionId ID of the transaction.
	
	* @return Returns the String object.
	
	*/
	
	public String uncategorizeACategorizedTransaction(String transactionId)throws Exception
	{
		String urlString = url+"/"+transactionId+"/uncategorize"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap());
		
		String message = bankTransactionParser.getMessage(response); 
		
		return message;
	}
}
