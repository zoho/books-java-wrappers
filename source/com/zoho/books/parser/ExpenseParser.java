/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * ExpenseParser is used to parse the json response and make it into the respective objects.
 */

public class ExpenseParser {

    /**
     * Parse the json response and returns the Expense object.
     *
     * @param response This json response contains the expense details.
     * @return Returns the Expense object.
     */

    public Expense getExpense(String response) throws Exception {
        Expense expense = new Expense();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject expenses = jsonObject.getJSONObject("expense"); //No I18N

        expense.setExpenseId(expenses.getString("expense_id"));
        expense.setExpenseItemId(expenses.getString("expense_item_id"));
        expense.setAccountId(expenses.getString("account_id"));
        expense.setAccountName(expenses.getString("account_name"));
        expense.setPaidThroughAccountId(expenses.getString("paid_through_account_id"));
        expense.setPaidThroughAccountName(expenses.getString("paid_through_account_name"));
        expense.setVendorId(expenses.getString("vendor_id"));
        expense.setVendorName(expenses.getString("vendor_name"));
        expense.setDate(expenses.getString("date"));
        expense.setTaxId(expenses.getString("tax_id"));
        expense.setTaxName(expenses.getString("tax_name"));
        expense.setTaxPercentage(expenses.getDouble("tax_percentage"));    //No I18N
        expense.setCurrencyId(expenses.getString("currency_id"));
        expense.setCurrencyCode(expenses.getString("currency_code"));
        expense.setExchangeRate(expenses.getDouble("exchange_rate"));    //No I18N
        expense.setTaxAmount(expenses.getDouble("tax_amount"));        //No I18N
        expense.setSubTotal(expenses.getDouble("sub_total"));            //No I18N
        expense.setBcyTotal(expenses.getDouble("bcy_total"));            //No I18N
        expense.setTotal(expenses.getDouble("total"));                //No I18N
        expense.setAmount(expenses.getDouble("amount"));            //No I18N
        expense.setIsInclusiveTax(expenses.getBoolean("is_inclusive_tax"));    //No I18N
        expense.setReferenceNumber(expenses.getString("reference_number"));
        expense.setDescription(expenses.getString("description"));
        expense.setIsBillable(expenses.getBoolean("is_billable"));        //No I18N
        expense.setCustomerId(expenses.getString("customer_id"));
        expense.setCustomerName(expenses.getString("customer_name"));
        expense.setExpenseReceiptName(expenses.getString("expense_receipt_name"));
        expense.setCreatedTime(expenses.getString("created_time"));
        expense.setLastModifiedTime(expenses.getString("last_modified_time"));
        expense.setStatus(expenses.getString("status"));
        expense.setInvoiceId(expenses.getString("invoice_id"));
        expense.setInvoiceNumber(expenses.getString("invoice_number"));
        expense.setProjectId(expenses.getString("project_id"));
        expense.setProjectName(expenses.getString("project_name"));

        return expense;
    }

    /**
     * Parse the json response and returns the ExpenseList object.
     *
     * @param response This json response contains list of expenses details.
     * @return Returns the Expense object.
     */

    public ExpenseList getExpenses(String response) throws Exception {

        ExpenseList expenseList = new ExpenseList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("expenses"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Expense expense = new Expense();

            expense.setExpenseId(jsonArray.getJSONObject(i).getString("expense_id"));
            expense.setDate(jsonArray.getJSONObject(i).getString("date"));
            expense.setAccountName(jsonArray.getJSONObject(i).getString("account_name"));
            expense.setPaidThroughAccountName(jsonArray.getJSONObject(i).getString("paid_through_account_name"));
            expense.setDescription(jsonArray.getJSONObject(i).getString("description"));
            expense.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            expense.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            expense.setBcyTotal(jsonArray.getJSONObject(i).getDouble("bcy_total"));    //No I18N
            expense.setTotal(jsonArray.getJSONObject(i).getDouble("total"));        //No I18N
            expense.setIsBillable(jsonArray.getJSONObject(i).getBoolean("is_billable"));    //No I18N
            expense.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            expense.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            expense.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            expense.setVendorId(jsonArray.getJSONObject(i).getString("vendor_id"));
            expense.setVendorName(jsonArray.getJSONObject(i).getString("vendor_name"));
            expense.setStatus(jsonArray.getJSONObject(i).getString("status"));
            expense.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));
            expense.setExpenseReceiptName(jsonArray.getJSONObject(i).getString("expense_receipt_name"));

            expenseList.add(expense);

        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        expenseList.setPageContext(pageContext);

        return expenseList;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for expense.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String response) throws Exception {

        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("comments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Comment comment = new Comment();

            comment.setCommentId(jsonArray.getJSONObject(i).getString("comment_id"));
            comment.setExpenseId(jsonArray.getJSONObject(i).getString("expense_id"));
            comment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            comment.setCommentedById(jsonArray.getJSONObject(i).getString("commented_by_id"));
            comment.setCommentedBy(jsonArray.getJSONObject(i).getString("commented_by"));
            comment.setDate(jsonArray.getJSONObject(i).getString("date"));
            comment.setDateDescription(jsonArray.getJSONObject(i).getString("date_description"));
            comment.setTime(jsonArray.getJSONObject(i).getString("time"));
            comment.setOperationType(jsonArray.getJSONObject(i).getString("operation_type"));
            comment.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            comment.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));

            commentList.add(comment);
        }

        return commentList;
    }

    /**
     * Parse the json response and returns a string object.
     *
     * @param response This json response contains the success message of post or update or delete requests.
     * @return Returns the success message.
     */

    public String getMessage(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        String success = jsonObject.getString("message");

        return success;
    }
}
