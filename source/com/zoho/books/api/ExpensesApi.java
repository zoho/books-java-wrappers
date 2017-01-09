/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.CommentList;
import com.zoho.books.model.Expense;
import com.zoho.books.model.ExpenseList;
import com.zoho.books.parser.ExpenseParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.io.File;
import java.util.HashMap;


/**
 * ExpensesApi is used to create a new expense.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of all expenses.<br>
 * <p>
 * The details of a particular expense.<br>
 * <p>
 * The list of all expenses' history.<br>
 * <p>
 * The expense receipt.<br><br>
 * <p>
 * It is used to update the details of an expense.<br>
 * <p>
 * It is used to add a receipt for the expense.<br><br>
 * <p>
 * It is used to delete:<br><br>
 * <p>
 * The particular expense.<br>
 * <p>
 * The receipt attched to the expense.<br>
 */

public class ExpensesApi extends API {

    private static String url = baseURL + "/expenses"; //No I18N


    /**
     * Construct a new ExpensesApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public ExpensesApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private ExpenseParser expenseParser = new ExpenseParser();


    /**
     * Create a billable or non-billable expense.
     * <p>
     * Pass the accountId, paidThroughAccountId, and amount to create a new expense.
     * <p>
     * It returns the Expense object.
     *
     * @param accountId            ID of the expense account.
     * @param paidThroughAccountId ID of the cash/ bank account the expense is paid.
     * @param amount               Expense amount.
     * @return Returns the Expense object.
     */

    public Expense create(String accountId, String paidThroughAccountId, double amount) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        Expense expense = new Expense();

        expense.setAccountId(accountId);
        expense.setPaidThroughAccountId(paidThroughAccountId);
        expense.setAmount(amount);

        requestBody.put("JSONString", expense.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return expenseParser.getExpense(response);
    }

    /**
     * Create a billable or non-billable expense.
     * <p>
     * Pass the Expense object to create a new expense.
     * <p>
     * The Expense object which contains accountId, paidThroughAccountId, and amount are the mandatory parameters.
     * <p>
     * It returns the Expense object.
     *
     * @param expense Expense object.
     * @return Returns the Expense object.
     */

    public Expense create(Expense expense) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", expense.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return expenseParser.getExpense(response);
    }

    /**
     * Create a billable or non-billable expense.
     * <p>
     * Pass the Expense object and File object to create a new expense with the receipt.
     * <p>
     * The Expense object which contains accountId, paidThroughAccountId, and amount are the mandatory parameters.
     * <p>
     * It returns the Expense object.
     *
     * @param expense Expense object.
     * @param file    Expense receipt file to attach.
     * @return Returns the Expense object.
     */

    public Expense create(Expense expense, File file) throws Exception {

        HashMap<String, Object> requestBody = new HashMap<String, Object>();

        requestBody.put("JSONString", expense.toJSON().toString());

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("receipt", file);


        String response = ZohoHTTPClient.post(url, getQueryMap(), requestBody, fileBody);

        return expenseParser.getExpense(response);
    }

    /**
     * Get the details of an expense.
     * <p>
     * Pass the expenseId to get the details of an expense.
     * <p>
     * It returns the Expense object.
     *
     * @param expenseId ID of an expense.
     * @return Returns the Expense object.
     */

    public Expense get(String expenseId) throws Exception {

        String urlString = url + "/" + expenseId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Expense expense = expenseParser.getExpense(response);

        return expense;
    }

    /**
     * Update an existing expense.
     * <p>
     * Pass the Expense object to update the details of an expense.
     * <p>
     * The Expense object which contains expenseId is the mandatory parameter for which expense has to be updated.
     * <p>
     * It returns the Expense object.
     *
     * @param expense Expense object.
     * @return Returns the Expense object.
     */

    public Expense update(Expense expense) throws Exception {

        String urlString = url + "/" + expense.getExpenseId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", expense.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return expenseParser.getExpense(response);
    }

    /**
     * Update an existing expense.
     * <p>
     * Pass the Expense object and File object to update the details and receipt of an expense.
     * <p>
     * The Expense object which contains expenseId is the mandatory parameter for which expense has to be updated.
     * <p>
     * It returns the Expense object.
     *
     * @param expense Expense object.
     * @param file    Expense receipt file to replace existing receipt.
     * @return Returns the Expense object.
     */

    public Expense update(Expense expense, File file) throws Exception {

        String urlString = url + "/" + expense.getExpenseId();

        HashMap<String, Object> requestBody = new HashMap<String, Object>();

        requestBody.put("JSONString", expense.toJSON().toString());

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("receipt", file);


        String response = ZohoHTTPClient.put(urlString, getQueryMap(), requestBody, fileBody);

        return expenseParser.getExpense(response);
    }

    /**
     * Delete an existing expense.
     * <p>
     * Pass the expenseId to delete the expense.
     * <p>
     * If the expense has been deleted it returns the success message.
     * <p>
     * The success message is "The expense has been deleted."
     *
     * @param expenseId ID of an expense.
     * @return Returns a String.
     */

    public String delete(String expenseId) throws Exception {

        String urlString = url + "/" + expenseId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = expenseParser.getMessage(response);

        return success;
    }

    /**
     * List expenses with pagination.
     * <p>
     * Pass the filters to get all the expenses based on the filters.
     * <p>
     * It returns the ExpenseList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>description</td><td>Search expenses by description.<br>
     * Variants: <i>description_startswith</i> and <i>description_contains</i></td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Search expenses by reference number.<br>
     * Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Search expenses by expense date.<br>
     * Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
     * <p>
     * <tr><td>account_name</td><td>Search expenses by expense account name.<br>
     * Variants: <i>account_name_startswith</i> and <i>account_name_contains</i></td></tr>
     * <p>
     * <tr><td>amount</td><td>Search expenses by amount.<br>
     * Variants: <i>amount_less_than, amount_less_equals, amount_greater_than</i> and <i>amount_greater_equals</i></td></tr>
     * <p>
     * <tr><td>customer_name</td><td>Search expenses by customer name.<br>
     * Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
     * <p>
     * <tr><td>vendor_name</td><td>Search expenses by vendor name.<br>
     * Variants: <i>vendor_name_startswith</i> and <i>vendor_name_contains</i></td></tr>
     * <p>
     * <tr><td>customer_id</td><td>Search expenses by customer id.</td></tr>
     * <p>
     * <tr><td>vendor_id</td><td>Search expenses by vendor id.</td></tr>
     * <p>
     * <tr><td>recurring_expense_id</td><td>Search expenses by recurring expense id.</td></tr>
     * <p>
     * <tr><td>paid_through_account_id</td><td>Search expenses by paid through account id.</td></tr>
     * <p>
     * <tr><td>search_text</td><td>Search expenses by category name or description or customer name or vendor name.</td></tr>
     * <p>
     * <tr><td>status</td><td>Search expenses by expense status.<br>
     * Allowed Values: <i>unbilled, invoiced, reimbursed, non-billable</i> and <i>billable</i></td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter expenses by expense status.<br>
     * Allowed Values: <i>Status.All, Status.Billable, Status.Nonbillable, Status.Reimbursed, Status.Invoiced</i> and <i>Status.Unbilled</i></td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort expenses. <br>
     * Allowed Values: <i>date, account_name, paid_through_account_name, total, bcy_total, reference_number, customer_name, vendor_name</i> and <i>created_time</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pairs.
     * @return Returns the ExpenseList object.
     */

    public ExpenseList getExpesnses(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        ExpenseList expenseList = expenseParser.getExpenses(response);

        return expenseList;
    }

    /**
     * Get comments of an expense.
     * <p>
     * Pass the expenseId to get all the comments for the expense.
     * <p>
     * It returns the CommentList object.
     *
     * @param expenseId ID of an expense.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String expenseId) throws Exception {

        String urlString = url + "/" + expenseId + "/comments"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CommentList commentList = expenseParser.getComments(response);

        return commentList;
    }


//=========================================================================================================================================


    /**
     * Attach a receipt to an expense.
     * <p>
     * Pass the expenseId and File object to add the receipt for the expense.
     * <p>
     * If the file has been attached to the expense it returns the success message.
     * <p>
     * The success message is "The expense receipt has been attached."
     *
     * @param expenseId ID of an expense.
     * @param file      Expense receipt file to attach.
     * @return Returns a String.
     */

    public String addReceipt(String expenseId, File file) throws Exception {

        String urlString = url + "/" + expenseId + "/receipt"; //No I18N

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("receipt", file);

        String response = ZohoHTTPClient.post(urlString, getQueryMap(), null, fileBody);

        String success = expenseParser.getMessage(response);

        return success;

    }

    /**
     * Returns the receipt attached to the expense.
     * <p>
     * Pass the expenseId to get the receipt attached to the exepense.
     * <p>
     * It returns the File object.
     *
     * @param expenseId ID of an expense.
     * @return Returns a File that is stored in a current directory.
     */

    public File getReceipt(String expenseId) throws Exception {

        String urlString = url + "/" + expenseId + "/receipt"; //No I18N

        File response = ZohoHTTPClient.getFile(urlString, getQueryMap());

        return response;
    }

    /**
     * Delete the receipt attached to the expense.
     * <p>
     * Pass the expenseId to delete the receipt attached to the expense.
     * <p>
     * If the receipt has been deleted it returns the success message.
     * <p>
     * The success message is "The attached expense receipt has been deleted."
     *
     * @param expenseId ID of an expense.
     * @return Returns a String.
     */

    public String deleteReceipt(String expenseId) throws Exception {

        String urlString = url + "/" + expenseId + "/receipt"; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = expenseParser.getMessage(response);

        return success;
    }
}
