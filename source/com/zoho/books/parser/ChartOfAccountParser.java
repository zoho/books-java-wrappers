/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * ChartOfAccountParser is used to parse the json response and make it into the respective objects.
 */

public class ChartOfAccountParser {

    /**
     * Parse the json response and returns the ChartOfAccount object.
     *
     * @param response This json response contains the chartofaccount details.
     * @return Returns the ChartOfAccount object.
     */

    public ChartOfAccount getChartOfAccount(String response) throws Exception {
        ChartOfAccount chartOfAccounts = new ChartOfAccount();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject chartOfAccount = jsonObject.getJSONObject("chart_of_account"); //No I18N

        chartOfAccounts.setAccountId(chartOfAccount.getString("account_id"));
        chartOfAccounts.setAccountName(chartOfAccount.getString("account_name"));
        chartOfAccounts.setIsActive(chartOfAccount.getBoolean("is_active"));      //No I18N
        chartOfAccounts.setAccountType(chartOfAccount.getString("account_type"));
        chartOfAccounts.setAccountTypeFormatted(chartOfAccount.getString("account_type_formatted"));
        chartOfAccounts.setDescription(chartOfAccount.getString("description"));

        return chartOfAccounts;
    }

    /**
     * Parse the json response and returns the ChartOfAccountList object.
     *
     * @param response This json response contains list of chartofaccounts details.
     * @return Returns the ChartOfAccountList object.
     */

    public ChartOfAccountList getChartOfAccounts(String response) throws Exception {

        ChartOfAccountList chartOfAccountList = new ChartOfAccountList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray accounts = jsonObject.getJSONArray("chartofaccounts"); //No I18N

        for (int i = 0; i < accounts.length(); i++) {
            ChartOfAccount chartofAccount = new ChartOfAccount();

            chartofAccount.setAccountId(accounts.getJSONObject(i).getString("account_id"));
            chartofAccount.setAccountName(accounts.getJSONObject(i).getString("account_name"));
            chartofAccount.setAccountType(accounts.getJSONObject(i).getString("account_type"));
            chartofAccount.setIsActive(accounts.getJSONObject(i).getBoolean("is_active"));            //No I18N
            chartofAccount.setIsUserCreated(accounts.getJSONObject(i).getBoolean("is_user_created"));    //No I18N
            chartofAccount.setIsInvolvedInTransaction(accounts.getJSONObject(i).getBoolean("is_involved_in_transaction")); //No I18N
            chartofAccount.setIsSystemAccount(accounts.getJSONObject(i).getBoolean("is_system_account"));    //No I18N

            chartOfAccountList.add(chartofAccount);
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

        chartOfAccountList.setPageContext(pageContext);

        return chartOfAccountList;
    }

    /**
     * Parse the json response and returns the TransactionList object.
     *
     * @param response This json response contains ist of transactions details.
     * @return Returns the TransactionList object.
     */

    public TransactionList getTransactions(String response) throws Exception {

        TransactionList transactionList = new TransactionList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("transactions"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Transaction transaction = new Transaction();

            transaction.setCategorizedTransactionId(jsonArray.getJSONObject(i).getString("categorized_transaction_id"));
            transaction.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));
            transaction.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            transaction.setTransactionDate(jsonArray.getJSONObject(i).getString("transaction_date"));
            transaction.setTransactionTypeFormatted(jsonArray.getJSONObject(i).getString("transaction_type_formatted"));
            transaction.setAccountId(jsonArray.getJSONObject(i).getString("account_id"));
            transaction.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            transaction.setPayee(jsonArray.getJSONObject(i).getString("payee"));
            transaction.setDescription(jsonArray.getJSONObject(i).getString("description"));
            transaction.setEntryNumber(jsonArray.getJSONObject(i).getString("entry_number"));
            transaction.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            transaction.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            transaction.setDebitOrCredit(jsonArray.getJSONObject(i).getString("debit_or_credit"));
            transaction.setOffsetAccountName(jsonArray.getJSONObject(i).getString("offset_account_name"));
            transaction.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            if (!jsonArray.getJSONObject(i).getString("debit_amount").equals("")) {
                transaction.setDebitAmount(jsonArray.getJSONObject(i).getDouble("debit_amount")); //No I18N
            }
            if (!jsonArray.getJSONObject(i).getString("credit_amount").equals("")) {
                transaction.setCreditAmount(jsonArray.getJSONObject(i).getDouble("credit_amount")); //No I18N
            }

            transactionList.add(transaction);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        if (pagecontext.has("report_name")) {
            pageContext.setReportName(pagecontext.getString("report_name"));
        }
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        transactionList.setPageContext(pageContext);

        return transactionList;
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
