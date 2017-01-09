/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * RecurringExpenseParser is used to parse the json response and make it into the respective objects.
 */

public class RecurringExpenseParser {

    /**
     * Parse the json response and returns the RecurringExpense object.
     *
     * @param response This json response contains the recurring expense details.
     * @return Returns the RecurringExpense object.
     */

    public RecurringExpense getRecurringExpense(String response) throws Exception {
        RecurringExpense recurringExpense = new RecurringExpense();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject rExpense = jsonObject.getJSONObject("recurring_expense"); //No I18N

        recurringExpense.setRecurringExpenseId(rExpense.getString("recurring_expense_id"));
        recurringExpense.setRecurrenceName(rExpense.getString("recurrence_name"));
        recurringExpense.setStartDate(rExpense.getString("start_date"));
        recurringExpense.setEndDate(rExpense.getString("end_date"));
        recurringExpense.setRecurrenceFrequency(rExpense.getString("recurrence_frequency"));
        recurringExpense.setRepeatEvery(rExpense.getInt("repeat_every")); //No I18N
        recurringExpense.setLastCreatedDate(rExpense.getString("last_created_date"));
        recurringExpense.setNextExpenseDate(rExpense.getString("next_expense_date"));
        recurringExpense.setAccountId(rExpense.getString("account_id"));
        recurringExpense.setAccountName(rExpense.getString("account_name"));
        recurringExpense.setPaidThroughAccountId(rExpense.getString("paid_through_account_id"));
        recurringExpense.setPaidThroughAccountName(rExpense.getString("paid_through_account_name"));
        recurringExpense.setVendorId(rExpense.getString("vendor_id"));
        recurringExpense.setVendorName(rExpense.getString("vendor_name"));
        recurringExpense.setTaxId(rExpense.getString("tax_id"));
        recurringExpense.setTaxName(rExpense.getString("tax_name"));
        recurringExpense.setTaxPercentage(rExpense.getDouble("tax_percentage")); //No I18N
        recurringExpense.setCurrencyId(rExpense.getString("currency_id"));
        recurringExpense.setCurrencyCode(rExpense.getString("currency_code"));
        recurringExpense.setExchangeRate(rExpense.getDouble("exchange_rate"));    //No I18N
        recurringExpense.setTaxAmount(rExpense.getDouble("tax_amount"));    //No I18N
        recurringExpense.setSubTotal(rExpense.getDouble("sub_total"));        //No I18N
        recurringExpense.setTotal(rExpense.getDouble("total"));            //No I18N
        recurringExpense.setBcyTotal(rExpense.getDouble("bcy_total"));        //No I18N
        recurringExpense.setAmount(rExpense.getDouble("amount"));        //No I18N
        recurringExpense.setIsInclusiveTax(rExpense.getBoolean("is_inclusive_tax")); //No I18N
        recurringExpense.setIsBillable(rExpense.getBoolean("is_billable"));         //No I18N
        recurringExpense.setDescription(rExpense.getString("description"));
        recurringExpense.setCustomerId(rExpense.getString("customer_id"));
        recurringExpense.setCustomerName(rExpense.getString("customer_name"));
        recurringExpense.setCreatedTime(rExpense.getString("created_time"));
        recurringExpense.setLastModifiedTime(rExpense.getString("last_modified_time"));
        recurringExpense.setStatus(rExpense.getString("status"));
        recurringExpense.setProjectId(rExpense.getString("project_id"));
        recurringExpense.setProjectName(rExpense.getString("project_name"));

        return recurringExpense;
    }

    /**
     * Parse the json response and returns the RecurringExpenseList object.
     *
     * @param response This json response contains list of recurring expenses details.
     * @return Returns the RecurringExpenseList object.
     */

    public RecurringExpenseList getRecurringExpenses(String response) throws Exception {

        RecurringExpenseList recurringExpenseList = new RecurringExpenseList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("recurring_expenses"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            RecurringExpense recurringExpense = new RecurringExpense();

            recurringExpense.setRecurringExpenseId(jsonArray.getJSONObject(i).getString("recurring_expense_id"));
            recurringExpense.setRecurrenceName(jsonArray.getJSONObject(i).getString("recurrence_name"));
            recurringExpense.setRecurrenceFrequency(jsonArray.getJSONObject(i).getString("recurrence_frequency"));
            recurringExpense.setRepeatEvery(jsonArray.getJSONObject(i).getInt("repeat_every")); //No I18N
            recurringExpense.setLastCreatedDate(jsonArray.getJSONObject(i).getString("last_created_date"));
            recurringExpense.setNextExpenseDate(jsonArray.getJSONObject(i).getString("next_expense_date"));
            recurringExpense.setAccountName(jsonArray.getJSONObject(i).getString("account_name"));
            recurringExpense.setPaidThroughAccountName(jsonArray.getJSONObject(i).getString("paid_through_account_name"));
            recurringExpense.setDescription(jsonArray.getJSONObject(i).getString("description"));
            recurringExpense.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            recurringExpense.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            recurringExpense.setTotal(jsonArray.getJSONObject(i).getDouble("total"));        //No I18N
            recurringExpense.setIsBillable(jsonArray.getJSONObject(i).getBoolean("is_billable"));    //No I18N
            recurringExpense.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            recurringExpense.setVendorName(jsonArray.getJSONObject(i).getString("vendor_name"));
            recurringExpense.setStatus(jsonArray.getJSONObject(i).getString("status"));
            recurringExpense.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));

            recurringExpenseList.add(recurringExpense);
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

        recurringExpenseList.setPageContext(pageContext);

        return recurringExpenseList;
    }

    /**
     * Parse the json response and returns the ExpenseList object.
     *
     * @param response This json response contains list of expenses details for recurring expense.
     * @return Returns the ExpenseList object.
     */

    public ExpenseList getExpensehistory(String response) throws Exception {

        ExpenseList expenseList = new ExpenseList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("expensehistory"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Expense expense = new Expense();

            expense.setExpenseId(jsonArray.getJSONObject(i).getString("expense_id"));
            expense.setDate(jsonArray.getJSONObject(i).getString("date"));
            expense.setAccountName(jsonArray.getJSONObject(i).getString("account_name"));
            expense.setVendorName(jsonArray.getJSONObject(i).getString("vendor_name"));
            expense.setPaidThroughAccountName(jsonArray.getJSONObject(i).getString("paid_through_account_name"));
            expense.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            expense.setTotal(jsonArray.getJSONObject(i).getDouble("total")); //No I18N
            expense.setStatus(jsonArray.getJSONObject(i).getString("status"));

            expenseList.add(expense);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        if (pagecontext.has("applied_filter")) {
            pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        }
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        expenseList.setPageContext(pageContext);

        return expenseList;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for recurring expense.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String response) throws Exception {

        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("comments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Comment comment = new Comment();

            comment.setCommentId(jsonArray.getJSONObject(i).getString("comment_id"));
            comment.setRecurringExpenseId(jsonArray.getJSONObject(i).getString("recurring_expense_id"));
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
