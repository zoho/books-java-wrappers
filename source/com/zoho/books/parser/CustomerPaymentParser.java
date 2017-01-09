/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.CustomerPayment;
import com.zoho.books.model.CustomerPaymentList;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.PageContext;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomerPaymentParser is used to parse the json response and make it into the respective objects.
 */

public class CustomerPaymentParser {

    /**
     * Parse the json response and returns the CustomerPayment object.
     *
     * @param response This json response contains the customer payment details.
     * @return Returns the CustomerPayment object.
     */

    public CustomerPayment getCustomerPayment(String response) throws Exception {
        CustomerPayment customerPayments = new CustomerPayment();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject payment = jsonObject.getJSONObject("payment"); //No I18N

        customerPayments.setPaymentId(payment.getString("payment_id"));
        customerPayments.setCustomerId(payment.getString("customer_id"));
        customerPayments.setCustomerName(payment.getString("customer_name"));
        customerPayments.setPaymentMode(payment.getString("payment_mode"));
        customerPayments.setDate(payment.getString("date"));
        customerPayments.setAccountId(payment.getString("account_id"));
        customerPayments.setAccountName(payment.getString("account_name"));
        customerPayments.setExchangeRate(payment.getDouble("exchange_rate"));   //No I18N
        customerPayments.setAmount(payment.getDouble("amount"));        //No I18N
        customerPayments.setBankCharges(payment.getDouble("bank_charges"));    //No I18N
        customerPayments.setTaxAccountId(payment.getString("tax_account_id"));
        customerPayments.setTaxAccountName(payment.getString("tax_account_name"));
        customerPayments.setTaxAmountWithheld(payment.getDouble("tax_amount_withheld")); //No I18N
        customerPayments.setDescription(payment.getString("description"));
        customerPayments.setReferenceNumber(payment.getString("reference_number"));
        //customerPayments.setIsSingleInvoicePayment(payment.getBoolean("is_single_invoice_payment"));

        JSONArray invoices = payment.getJSONArray("invoices"); //No I18N

        List<Invoice> invoicesList = new ArrayList<Invoice>();

        for (int i = 0; i < invoices.length(); i++) {
            Invoice invoice = new Invoice();

            invoice.setInvoiceNumber(invoices.getJSONObject(i).getString("invoice_number"));
            invoice.setInvoicePaymentId(invoices.getJSONObject(i).getString("invoice_payment_id"));
            invoice.setInvoiceId(invoices.getJSONObject(i).getString("invoice_id"));
            invoice.setAmountApplied(invoices.getJSONObject(i).getDouble("amount_applied"));        //No I18N
            invoice.setTaxAmountWithheld(invoices.getJSONObject(i).getDouble("tax_amount_withheld"));    //No I18N
            invoice.setTotal(invoices.getJSONObject(i).getDouble("total"));                    //No I18N
            invoice.setBalance(invoices.getJSONObject(i).getDouble("balance"));                //No I18N
            invoice.setDate(invoices.getJSONObject(i).getString("date"));
            invoice.setDueDate(invoices.getJSONObject(i).getString("due_date"));

            invoicesList.add(i, invoice);
        }

        customerPayments.setInvoices(invoicesList);

        return customerPayments;
    }

    /**
     * Parse the json response and returns the CustomerPaymentList object.
     *
     * @param response This json response contains list of customer payments details.
     * @return Returns the CustomerPaymentList object.
     */

    public CustomerPaymentList getCustomerPayments(String response) throws Exception {

        CustomerPaymentList customerPaymentList = new CustomerPaymentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray customerpayments = jsonObject.getJSONArray("customerpayments"); //No I18N

        for (int i = 0; i < customerpayments.length(); i++) {
            CustomerPayment customerPayment = new CustomerPayment();

            customerPayment.setPaymentId(customerpayments.getJSONObject(i).getString("payment_id"));
            customerPayment.setPaymentNumber(customerpayments.getJSONObject(i).getString("payment_number"));
            customerPayment.setInvoiceNumbers(customerpayments.getJSONObject(i).getString("invoice_numbers"));
            customerPayment.setDate(customerpayments.getJSONObject(i).getString("date"));
            customerPayment.setPaymentMode(customerpayments.getJSONObject(i).getString("payment_mode"));
            customerPayment.setAmount(customerpayments.getJSONObject(i).getDouble("amount"));            //No I18N
            customerPayment.setBcyAmount(customerpayments.getJSONObject(i).getDouble("bcy_amount"));        //No I18N
            customerPayment.setUnusedAmount(customerpayments.getJSONObject(i).getDouble("unused_amount"));        //No I18N
            customerPayment.setBcyUnusedAmount(customerpayments.getJSONObject(i).getDouble("bcy_unused_amount"));    //No I18N
            customerPayment.setAccountId(customerpayments.getJSONObject(i).getString("account_id"));
            customerPayment.setAccountName(customerpayments.getJSONObject(i).getString("account_name"));
            customerPayment.setDescription(customerpayments.getJSONObject(i).getString("description"));
            customerPayment.setReferenceNumber(customerpayments.getJSONObject(i).getString("reference_number"));
            customerPayment.setCustomerId(customerpayments.getJSONObject(i).getString("customer_id"));
            customerPayment.setCustomerName(customerpayments.getJSONObject(i).getString("customer_name"));

            customerPaymentList.add(customerPayment);
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

        customerPaymentList.setPageContext(pageContext);

        return customerPaymentList;
    }

}
