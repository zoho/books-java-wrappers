/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.*;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * BankTransactionsApi is used to create a transaction for an account.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of all transactions.<br>
 * <p>
 * The details of a transaction.<br>
 * <p>
 * The matching transactions.<br>
 * <p>
 * The list of all associated transactions.<br><br>
 * <p>
 * It is used to update the details of a transaction.<br><br>
 * <p>
 * It is used to:<br><br>
 * <p>
 * Match a transaction.<br>
 * <p>
 * Unmatch a matched transaction.<br>
 * <p>
 * Exclude a transaction.<br>
 * <p>
 * Restore an excluded transaction.<br>
 * <p>
 * Categorize an uncategorized transaction.<br>
 * <p>
 * Categorize as credit note refunds.<br>
 * <p>
 * Categorize as vendor payment.<br>
 * <p>
 * Categorize as customer payment.<br>
 * <p>
 * Categorize as expense.<br>
 * <p>
 * Uncategorize a categorized transaction.<br><br>
 * <p>
 * It is used to delete a transaction.
 */

public class BankTransactionsApi extends API {

    private static String url = baseURL + "/banktransactions"; //No I18N

    /**
     * Construct a new BankTransactionsApi using user's authtoken and organization id.
     *
     * @param authToken      user's authtoken.
     * @param organizationId user's organization id.
     */

    public BankTransactionsApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }

    private BankTransactionParser bankTransactionParser = new BankTransactionParser();


    /**
     * Get all the transaction details involved in an account.
     * <p>
     * Pass the filters to get all the transactions based on the filters.
     * <p>
     * It returns the TransactionList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <tbody>
     * <tr><td>account_id*</td><td>Mandatory Account id for which transactions are to be listed.</td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filters the transactions based on the allowed types.<br>
     * Allowed Values: <i>Status.All, Status.Uncategorized, Status.Categorized, Status.ManuallyAdded, Status.Excluded</i> and <i>Status.Matched</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Start and end date, to provide a range within which the transaction date exist.<br>
     * Variants: <i>date_start</i> and <i>date_end</i></td></tr>
     * <p>
     * <tr><td>amount</td><td>Start and end amount, to provide a range within which the transaction amount exist.<br>
     * Variants: <i>amount_start</i> and <i>amount_end</i></td></tr>
     * <p>
     * <tr><td>status</td><td>Transaction status wise list view - All, uncategorized, manually_added, matched, excluded, categorized</td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Reference Number of the transaction</td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sorts the transactions based on the allowed sort types. <br>
     * Allowed Values: <i>date</i></td></tr>
     * </tbody>
     * </table>
     *
     * @param queryMap It contains the querystring values in the form of key-value pair.
     * @return Returns the TransactionList object.
     */

    public TransactionList getTransactions(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        TransactionList transactionsList = bankTransactionParser.getTransactions(response);

        return transactionsList;
    }

    /**
     * Fetch the details of a transaction by specifying the transaction_id.
     * <p>
     * Pass the transactionId to get the details of a transaction.
     * <p>
     * It returns the Transaction object.
     *
     * @param transactionId ID of the transaction.
     * @return Returns the Transaction object.
     */

    public Transaction get(String transactionId) throws Exception {
        String urlString = url + "/" + transactionId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Transaction transaction = bankTransactionParser.getTransaction(response);

        return transaction;
    }

    /**
     * Create a bank transaction based on the allowed transaction types.
     * <p>
     * Pass the Transaction object to create a new bank transaction.
     * <p>
     * The Transaction object which contains transactionType is the mandatory parameter.
     * <p>
     * It returns the Transaction object.
     *
     * @param transaction Transaction object.
     * @return Returns the Transaction object.
     */

    public Transaction create(Transaction transaction) throws Exception {
        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", transaction.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return bankTransactionParser.getTransaction(response);
    }

    /**
     * Make changes in the applicable fields of a transaction and update it.
     * <p>
     * Pass the Transaction object to update the details of a bank transaction.
     * <p>
     * The Transaction object which contains transactionId is the mandatory parameter for which bank transaction has to be updated.
     * <p>
     * It returns the Transaction object.
     *
     * @param transaction Transaction object.
     * @return Returns the Transaction object.
     */

    public Transaction update(Transaction transaction) throws Exception {

        String urlString = url + "/" + transaction.getTransactionId(); //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", transaction.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return bankTransactionParser.getTransaction(response);
    }

    /**
     * Delete a transaction from an account by specifying the transactionId.
     * <p>
     * Pass the transactionId to delete the bank transaction.
     * <p>
     * If the transaction has been deleted it returns the success message.
     * <p>
     * The success message is "The transaction has been deleted."
     *
     * @param transactionId ID of the transaction.
     * @return Returns the String object.
     */

    public String delete(String transactionId) throws Exception {
        String urlString = url + "/" + transactionId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String message = bankTransactionParser.getMessage(response);

        return message;
    }

    /**
     * Provide criteria to search for matching uncategorised transactions.
     * <p>
     * Pass the transactionId and filters to get all the matching transactions based on the filters.
     * <p>
     * It returns the TransactionList object.<br>
     * <p>
     * The queryMap contains the below listed possible keys and values as mentioned below:<br>
     * <p>
     * <table border = "1">
     * <tbody>
     * <tr><td>transaction_type</td><td>The type of transaction. <br>
     * Allowed Values: <i>expense, deposit, refund, transfer_fund, card_payment, sales_without_invoices, expense_refund, owner_contribution, interest_income, other_income, owner_drawings, invoice, bill, credit_notes, creditnote_refund, customer_payment</i> and <i>vendor_payment</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Start and end date, to provide a range within which the transaction date exist.<br>
     * Variants: <i>date_start</i> and <i>date_end</i></td></tr>
     * <p>
     * <tr><td>amount</td><td>Initial and final amount range within which the search amount exists.<br>
     * Variants: <i>amount_start</i> and <i>amount_end</i></td></tr>
     * <p>
     * <tr><td>contact</td><td>Contact person name, involved in the transaction.</td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Reference Number of the transaction.</td></tr>
     * </tbody>
     * </table>
     *
     * @param transactionId ID of the transaction.
     * @param queryMap      It contains the querystring values in the form of key-value pair.
     * @return Returns the TransactionList object.
     */

    public TransactionList getMatchingTransactions(String transactionId, HashMap<String, Object> queryMap) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/match"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        TransactionList transactionsList = bankTransactionParser.getTransactions(response);

        return transactionsList;
    }

    /**
     * Match an uncategorized transaction with an existing transaction in the account.
     * <p>
     * Pass the transactionId and list of Transaction objects to match an uncategorized transaction.
     * <p>
     * The Transaction objects which contains transactionId and transactionType are the mandatory parameters.
     * <p>
     * If the transaction is uncategorized it returns the success message.
     * <p>
     * The success message is "The Uncategorized transaction is linked to the selected transaction(s) in Zoho Books."
     *
     * @param transactionId ID of the transaction.
     * @param transactions  List of Transaction object.
     * @return Returns the String object.
     */

    public String matchTransaction(String transactionId, List<Transaction> transactions) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/match"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();

        JSONArray transactionMatched = new JSONArray();

        for (int i = 0; i < transactions.size(); i++) {
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
     * <p>
     * Pass the transactionId to unmatch a matched transaction.
     * <p>
     * If the transaction has been unmatched it returns the success message.
     * <p>
     * The success message is "The transaction has been unmatched."
     *
     * @param transactionId ID of the transaction.
     * @return Returns the String object.
     */

    public String unmatchTransaction(String transactionId) throws Exception {
        String urlString = url + "/" + transactionId + "/unmatch"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String message = bankTransactionParser.getMessage(response);

        return message;
    }

    /**
     * Get a list of all the associated transactions that were matched or categorized to the given imported transaction.
     * <p>
     * Pass the transactionId and sortColumn to get the associated transaction based on the sort column.
     * <p>
     * It returns the Transaction object.
     *
     * @param transactionId ID of the transaction.
     * @param sortColumn    Sort column for the associate transaction.
     * @return Returns the Transaction object.
     */

    public Transaction getAssociateTransaction(String transactionId, String sortColumn) throws Exception {
        String urlString = url + "/" + transactionId + "/associated"; //No I18N

        HashMap<String, Object> queryMap = getQueryMap();

        if (sortColumn != null) {
            queryMap.put("sort_column", sortColumn);
        }

        String response = ZohoHTTPClient.get(urlString, queryMap);

        Transaction transaction = bankTransactionParser.getAssociateTransaction(response);

        return transaction;
    }

    /**
     * Exclude a transaction from your bank or credit card account.
     * <p>
     * Pass the transactionId to exclude a transaction from your bank account.
     * <p>
     * If the transaction has been excluded it returns the success message.
     * <p>
     * The success message is "The transaction has been excluded."
     *
     * @param transactionId ID of the transaction.
     * @return Returns the String object.
     */

    public String excludeTransaction(String transactionId) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/exclude"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String message = bankTransactionParser.getMessage(response);

        return message;
    }

    /**
     * Restore an excluded transaction in your account.
     * <p>
     * Pass the transactionId to restore the excluded transaction.
     * <p>
     * If the transaction has been restored it returns the success message.
     * <p>
     * The success message is "The excluded transaction has been restored."
     *
     * @param transactionId ID of the transaction.
     * @return Returns the String object.
     */

    public String restoreTransaction(String transactionId) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/restore"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String message = bankTransactionParser.getMessage(response);

        return message;
    }


//==============================================================================================================================================


    /**
     * Categorize an uncategorized transaction by creating a new transaction.
     * <p>
     * Pass the Transaction object to categorize the transaction by creating a new transaction.
     * <p>
     * The Transaction object which contains transactionType is the mandatory parameter.
     * <p>
     * It returns the Transaction object.
     *
     * @param transaction Transaction object.
     * @return Returns the Transaction object.
     */


    public Transaction categorizeAnUncategorizeTransaction(Transaction transaction) throws Exception {

        String urlString = url + "/uncategorized/" + transaction.getTransactionId() + "/categorize"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", transaction.toJSON().toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return bankTransactionParser.getTransaction(response);
    }

    /**
     * Categorize an Uncategorized transaction as a refund from a credit note.
     * <p>
     * Pass the transactionId and CreditnoteRefund object to categorize the transaction as a refund from the credit note.
     * <p>
     * The CreditnoteRefund object which contains creditNoteId and date are the mandatory parameters.
     * <p>
     * It returns the CreditnoteRefund object.
     *
     * @param transactionId    ID of the transaction.
     * @param creditnoteRefund CreditnoteRefund object.
     * @return Returns the CreditnoteRefund object.
     */

    public CreditnoteRefund categorizeAsCreditnoteRefunds(String transactionId, CreditnoteRefund creditnoteRefund) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/categorize/creditnoterefunds"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", creditnoteRefund.toJSON().put("creditnote_id", creditnoteRefund.getCreditnoteId()).toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        //String message = bankTransactionParser.getMessage(response);

        return new CreditNoteParser().getCreditnoteRefund(response);
    }

    /**
     * Categorize an uncategorized transaction as Vendor Payment.
     * <p>
     * Pass the transactionId and VendorPayment object to categorize the transaction as vendor payment.
     * <p>
     * The VendorPayment object which contains vendorId and amount are the mandatory parameters.
     * <p>
     * It returns the VendorPayment object.
     *
     * @param transactionId ID of the transaction.
     * @param vendorPayment VendorPayment object.
     * @return Returns the VendorPayment object.
     */

    public VendorPayment categorizeAsVendorPayment(String transactionId, VendorPayment vendorPayment) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/categorize/vendorpayments"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", vendorPayment.toJSON().toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return new VendorPaymentParser().getVendorPayment(response);
    }

    /**
     * Categorize an uncategorized transaction as Customer Payment.
     * <p>
     * Pass the transactionId and CustomerPayment object to categorize the transaction as customer payment.
     * <p>
     * The CustomerPayment object which contains date and amount are the mandatory parameters.
     * <p>
     * It returns the CustomerPayment object.
     *
     * @param transactionId   ID of the transaction.
     * @param customerPayment CustomerPayment object.
     * @return Returns the CustomerPayment object.
     */

    public CustomerPayment categorizeAsCustomerPayment(String transactionId, CustomerPayment customerPayment) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/categorize/customerpayments"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", customerPayment.toJSON().toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return new CustomerPaymentParser().getCustomerPayment(response);
    }

    /**
     * Categorize an uncategorized transaction as Expense.
     * <p>
     * Pass the transactionId, Expense object, and File object to categorize the transaction as expense.
     * <p>
     * The Expense object which contains accountId, paidThroughAccountId, and amount are the mandatory parameters.
     * <p>
     * It returns the Expense object.
     *
     * @param transactionId ID of the transaction.
     * @param expense       Expense object.
     * @param file          Receipt file for the expense.
     * @return Returns the Expense object.
     */

    public Expense categorizeAsExpense(String transactionId, Expense expense, File file) throws Exception {
        String urlString = url + "/uncategorized/" + transactionId + "/categorize/expense"; //No I18N

        HashMap<String, Object> requestBody = new HashMap<String, Object>();

        requestBody.put("JSONString", expense.toJSON().toString());

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("receipt", file);

        String response = ZohoHTTPClient.post(urlString, getQueryMap(), requestBody, fileBody);

        return new ExpenseParser().getExpense(response);
    }

    /**
     * Revert a categorized transaction as uncategorized.
     * <p>
     * Pass the transactionId to categorize the transaction as uncategorized.
     * <p>
     * If the transaction has been uncategorized it returns the success message.
     * <p>
     * The success message is "The transaction has been uncategorized."
     *
     * @param transactionId ID of the transaction.
     * @return Returns the String object.
     */

    public String uncategorizeACategorizedTransaction(String transactionId) throws Exception {
        String urlString = url + "/" + transactionId + "/uncategorize"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String message = bankTransactionParser.getMessage(response);

        return message;
    }
}
