/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * BankAccountParser is used to parse the json response and make it into the respective objects.
 */

public class BankAccountParser {

    /**
     * Parse the json response and returns a BankAccountList object.
     *
     * @param response This json response contains list of Bank Accounts details.
     * @return Returns the BankAccountList object.
     */

    public BankAccountList getBankAccounts(String response) throws Exception {

        BankAccountList bankAccountList = new BankAccountList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("bankaccounts"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            BankAccount bankAccount = new BankAccount();

            bankAccount.setAccountId(jsonArray.getJSONObject(i).getString("account_id"));
            bankAccount.setAccountName(jsonArray.getJSONObject(i).getString("account_name"));
            if (jsonArray.getJSONObject(i).has("account_number")) {
                bankAccount.setAccountNumber(jsonArray.getJSONObject(i).getString("account_number"));
            }
            bankAccount.setAccountType(jsonArray.getJSONObject(i).getString("account_type"));
            bankAccount.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            bankAccount.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            bankAccount.setUncategorizedTransactions(jsonArray.getJSONObject(i).getInt("uncategorized_transactions")); //No I18N
            bankAccount.setIsActive(jsonArray.getJSONObject(i).getBoolean("is_active"));    //No I18N
            bankAccount.setBalance(jsonArray.getJSONObject(i).getDouble("balance"));    //No I18N
            bankAccount.setBankName(jsonArray.getJSONObject(i).getString("bank_name"));
            if (jsonArray.getJSONObject(i).has("routing_number")) {
                bankAccount.setRoutingNumber(jsonArray.getJSONObject(i).getString("routing_number"));
            }
            if (jsonArray.getJSONObject(i).has("is_primary_account")) {
                bankAccount.setIsPrimaryAccount(jsonArray.getJSONObject(i).getBoolean("is_primary_account")); //No I18N
            }
            if (jsonArray.getJSONObject(i).has("is_paypal_account")) {
                bankAccount.setIsPaypalAccount(jsonArray.getJSONObject(i).getBoolean("is_paypal_account")); //No I18N
            }
            if (jsonArray.getJSONObject(i).has("paypal_email_address")) {
                bankAccount.setPaypalEmailAddress(jsonArray.getJSONObject(i).getString("paypal_email_address"));
            }

            bankAccountList.add(bankAccount);
        }


        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        bankAccountList.setPageContext(pageContext);

        return bankAccountList;
    }

    /**
     * Parse the json response and returns a BankAccount object.
     *
     * @param response This json response contains the details of a Bank Account.
     * @return Returns the BankAccount object.
     */

    public BankAccount getBankAccount(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject bankAcc = jsonObject.getJSONObject("bankaccount"); //No I18N

        BankAccount bankAccount = new BankAccount();

        bankAccount.setAccountId(bankAcc.getString("account_id"));
        bankAccount.setAccountName(bankAcc.getString("account_name"));
        if (bankAcc.has("account_number")) {
            bankAccount.setAccountNumber(bankAcc.getString("account_number"));
        }
        bankAccount.setAccountType(bankAcc.getString("account_type"));
        bankAccount.setCurrencyId(bankAcc.getString("currency_id"));
        bankAccount.setCurrencyCode(bankAcc.getString("currency_code"));
        bankAccount.setUncategorizedTransactions(bankAcc.getInt("uncategorized_transactions")); //No I18N
        bankAccount.setIsActive(bankAcc.getBoolean("is_active"));    //No I18N
        bankAccount.setBalance(bankAcc.getDouble("balance"));        //No I18N
        bankAccount.setBankName(bankAcc.getString("bank_name"));
        if (bankAcc.has("routing_number")) {
            bankAccount.setRoutingNumber(bankAcc.getString("routing_number"));
        }
        if (bankAcc.has("is_primary_account")) {
            bankAccount.setIsPrimaryAccount(bankAcc.getBoolean("is_primary_account")); //No I18N
        }
        if (bankAcc.has("is_paypal_account")) {
            bankAccount.setIsPaypalAccount(bankAcc.getBoolean("is_paypal_account"));  //No I18N
        }
        if (bankAcc.has("paypal_email_address")) {
            bankAccount.setPaypalEmailAddress(bankAcc.getString("paypal_email_address"));
        }
        bankAccount.setDescription(bankAcc.getString("description"));

        return bankAccount;
    }

    /**
     * Parse the json response and returns a Statement object.
     *
     * @param response This json response contains the statement details of the account.
     * @return Returns the Statement object.
     */

    public Statement getStatement(String response) throws Exception {
        Statement statement = new Statement();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject stmt = jsonObject.getJSONObject("statement"); //No I18N

        statement.setStatementId(stmt.getString("statement_id"));
        statement.setFromDate(stmt.getString("from_date"));
        statement.setToDate(stmt.getString("to_date"));
        statement.setSource(stmt.getString("source"));

        JSONArray jsonArray = stmt.getJSONArray("transactions"); //No I18N

        List<Transaction> transactions = new ArrayList<Transaction>();

        for (int i = 0; i < jsonArray.length(); i++) {
            Transaction transaction = new Transaction();

            transaction.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            transaction.setDebitOrCredit(jsonArray.getJSONObject(i).getString("debit_or_credit"));
            transaction.setDate(jsonArray.getJSONObject(i).getString("date"));
            transaction.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            transaction.setPayee(jsonArray.getJSONObject(i).getString("payee"));
            transaction.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            transaction.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));
            transaction.setAmount(jsonArray.getJSONObject(i).getDouble("amount")); //No I18N
            transaction.setStatus(jsonArray.getJSONObject(i).getString("status"));

            transactions.add(i, transaction);
        }

        statement.setTransactions(transactions);

        return statement;
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
