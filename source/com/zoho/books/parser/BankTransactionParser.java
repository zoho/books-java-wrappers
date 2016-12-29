/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * BankTransactionParser is used to parse the json response and make it into the respective objects.
 */

public class BankTransactionParser {

    /**
     * Parse the json response and returns the TransactionList object.
     *
     * @param response This json response contains list of transactions details.
     * @return Returns the TransactionList object.
     */

    public TransactionList getTransactions(String response) throws Exception {

        TransactionList transactionList = new TransactionList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("banktransactions"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Transaction transaction = new Transaction();

            transaction.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            transaction.setDate(jsonArray.getJSONObject(i).getString("date"));
            transaction.setAmount(jsonArray.getJSONObject(i).getDouble("amount")); //No I18N
            transaction.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));
            transaction.setStatus(jsonArray.getJSONObject(i).getString("status"));
            transaction.setSource(jsonArray.getJSONObject(i).getString("source"));
            transaction.setAccountId(jsonArray.getJSONObject(i).getString("account_id"));
            transaction.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            transaction.setPayee(jsonArray.getJSONObject(i).getString("payee"));
            transaction.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            transaction.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            transaction.setDebitOrCredit(jsonArray.getJSONObject(i).getString("debit_or_credit"));
            transaction.setOffsetAccountName(jsonArray.getJSONObject(i).getString("offset_account_name"));
            transaction.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            transaction.setImportedTransactionId(jsonArray.getJSONObject(i).getString("imported_transaction_id"));

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

        if (pagecontext.has("search_criteria")) {
            List<Criteria> criterion = new ArrayList<Criteria>();

            JSONArray searchCriteria = pagecontext.getJSONArray("search_criteria"); //No I18N

            for (int i = 0; i < searchCriteria.length(); i++) {
                Criteria criteria = new Criteria();

                if (searchCriteria.getJSONObject(i).has("columnname")) {
                    criteria.setColumnName(searchCriteria.getJSONObject(i).getString("columnname"));
                }
                criteria.setSearchText(searchCriteria.getJSONObject(i).getString("search_text"));
                criteria.setComparator(searchCriteria.getJSONObject(i).getString("comparator"));

                criterion.add(i, criteria);
            }

            pageContext.setCriteria(criterion);
        }

        transactionList.setPageContext(pageContext);

        if (jsonObject.has("instrumentation")) {
            Instrumentation instrumentation = new Instrumentation();

            JSONObject instrumen = jsonObject.getJSONObject("instrumentation"); //No I18N

            instrumentation.setQueryExecutionTime(instrumen.getInt("query_execution_time"));    //No I18N
            instrumentation.setRequestHandlingTime(instrumen.getInt("request_handling_time"));    //No I18N
            instrumentation.setResponseWriteTime(instrumen.getInt("response_write_time"));        //No I18N
            instrumentation.setPageContextWriteTime(instrumen.getInt("page_context_write_time"));    //No I18N

            transactionList.setInstrumentation(instrumentation);
        }

        return transactionList;
    }


    /**
     * Parse the json response and returns the Transaction object.
     *
     * @param response This json response contains the transaction details.
     * @return Returns the Transaction object.
     */

    public Transaction getTransaction(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        Transaction transaction = new Transaction();

        JSONObject banktransaction = jsonObject.getJSONObject("banktransaction"); //No I18N

        transaction.setTransactionId(banktransaction.getString("transaction_id"));
        transaction.setFromAccountId(banktransaction.getString("from_account_id"));
        transaction.setFromAccountName(banktransaction.getString("from_account_name"));
        transaction.setToAccountId(banktransaction.getString("to_account_id"));
        transaction.setToAccountName(banktransaction.getString("to_account_name"));
        transaction.setTransactionType(banktransaction.getString("transaction_type"));
        transaction.setCurrencyId(banktransaction.getString("currency_id"));
        transaction.setCurrencyCode(banktransaction.getString("currency_code"));
        transaction.setAmount(banktransaction.getDouble("amount"));    //No I18N
        if (banktransaction.has("payment_mode")) {
            transaction.setPaymentMode(banktransaction.getString("payment_mode"));
        }
        transaction.setExchangeRate(banktransaction.getDouble("exchange_rate")); //No I18N
        transaction.setDate(banktransaction.getString("date"));
        if (banktransaction.has("customer_id")) {
            transaction.setCustomerId(banktransaction.getString("customer_id"));
        }
        if (banktransaction.has("customer_name")) {
            transaction.setCustomerName(banktransaction.getString("customer_name"));
        }
        transaction.setReferenceNumber(banktransaction.getString("reference_number"));
        transaction.setDescription(banktransaction.getString("description"));

        return transaction;
    }

    /**
     * Parse the json response and returns a Transaction object.
     *
     * @param response This json response contains the transaction details.
     * @return Returns the Transaction object.
     */

    public Transaction getAssociateTransaction(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        Transaction transaction = new Transaction();

        JSONObject banktransaction = jsonObject.getJSONObject("transaction"); //No I18N

        transaction.setImportedTransactionId(banktransaction.getString("imported_transaction_id"));
        transaction.setDate(banktransaction.getString("date"));
        transaction.setPayee(banktransaction.getString("payee"));
        transaction.setAmount(banktransaction.getDouble("amount")); //No I18N
        transaction.setReferenceNumber(banktransaction.getString("reference_number"));
        transaction.setDescription(banktransaction.getString("description"));
        transaction.setStatus(banktransaction.getString("status"));

        JSONArray assTransaction = banktransaction.getJSONArray("associated_transactions"); //No I18N

        List<Transaction> transactionList = new ArrayList<Transaction>();

        for (int i = 0; i < assTransaction.length(); i++) {

            Transaction associateTransaction = new Transaction();

            associateTransaction.setTransactionId(assTransaction.getJSONObject(i).getString("transaction_id"));
            associateTransaction.setDate(assTransaction.getJSONObject(i).getString("date"));
            associateTransaction.setDebitOrCredit(assTransaction.getJSONObject(i).getString("debit_or_credit"));
            associateTransaction.setTransactionType(assTransaction.getJSONObject(i).getString("transaction_type"));
            associateTransaction.setAmount(assTransaction.getJSONObject(i).getDouble("amount")); //No I18N
            associateTransaction.setCustomerId(assTransaction.getJSONObject(i).getString("customer_id"));
            associateTransaction.setCustomerName(assTransaction.getJSONObject(i).getString("customer_name"));

            transactionList.add(i, associateTransaction);
        }

        transaction.setAssociateTransactions(transactionList);


        return transaction;
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
