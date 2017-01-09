/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * RecurringInvoiceParser is used to parse the json response and make it into the respective objects.
 */

public class RecurringInvoiceParser {

    /**
     * Parse the json response and returns the RecurringInvoiceList object.
     *
     * @param response This json response contains list of recurring invoices details.
     * @return Returns the RecurringInvoiceList object.
     */

    public RecurringInvoiceList getRecurringInvoices(String response) throws Exception {

        RecurringInvoiceList recurringInvoiceList = new RecurringInvoiceList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("recurring_invoices"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            RecurringInvoice recurringInvoice = new RecurringInvoice();

            recurringInvoice.setRecurringInvoiceId(jsonArray.getJSONObject(i).getString("recurring_invoice_id"));
            recurringInvoice.setRecurrenceName(jsonArray.getJSONObject(i).getString("recurrence_name"));
            recurringInvoice.setStatus(jsonArray.getJSONObject(i).getString("status"));
            if (jsonArray.getJSONObject(i).has("sub_total")) {
                recurringInvoice.setSubTotal(jsonArray.getJSONObject(i).getDouble("sub_total")); //No I18N
            }
            recurringInvoice.setTotal(jsonArray.getJSONObject(i).getDouble("total")); //No I18N
            recurringInvoice.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            recurringInvoice.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            recurringInvoice.setStartDate(jsonArray.getJSONObject(i).getString("start_date"));
            recurringInvoice.setEndDate(jsonArray.getJSONObject(i).getString("end_date"));
            recurringInvoice.setLastSentDate(jsonArray.getJSONObject(i).getString("last_sent_date"));
            recurringInvoice.setNextInvoiceDate(jsonArray.getJSONObject(i).getString("next_invoice_date"));
            recurringInvoice.setRecurrenceFrequency(jsonArray.getJSONObject(i).getString("recurrence_frequency"));
            recurringInvoice.setRepeatEvery(jsonArray.getJSONObject(i).getInt("repeat_every")); //No I18N
            recurringInvoice.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));

            recurringInvoiceList.add(recurringInvoice);
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

        recurringInvoiceList.setPageContext(pageContext);

        return recurringInvoiceList;
    }

    /**
     * Parse the json response and returns the RecurringInvoice object.
     *
     * @param response This json response contains the recurring invoice details.
     * @return Returns the RecurringInvoice object.
     */

    public RecurringInvoice getRecurringInvoice(String response) throws Exception {
        RecurringInvoice recurringInvoice = new RecurringInvoice();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject recurring = jsonObject.getJSONObject("recurring_invoice"); //No I18N

        recurringInvoice.setRecurringInvoiceId(recurring.getString("recurring_invoice_id"));
        recurringInvoice.setRecurrenceName(recurring.getString("recurrence_name"));
        recurringInvoice.setStatus(recurring.getString("status"));
        recurringInvoice.setRecurrenceFrequency(recurring.getString("recurrence_frequency"));
        recurringInvoice.setRepeatEvery(recurring.getInt("repeat_every")); //No I18N
        recurringInvoice.setStartDate(recurring.getString("start_date"));
        recurringInvoice.setEndDate(recurring.getString("end_date"));
        recurringInvoice.setLastSentDate(recurring.getString("last_sent_date"));
        recurringInvoice.setNextInvoiceDate(recurring.getString("next_invoice_date"));
        recurringInvoice.setCustomerId(recurring.getString("customer_id"));
        recurringInvoice.setCustomerName(recurring.getString("customer_name"));
        recurringInvoice.setCurrencyId(recurring.getString("currency_id"));
        recurringInvoice.setCurrencyCode(recurring.getString("currency_code"));
        recurringInvoice.setExchangeRate(recurring.getDouble("exchange_rate")); //No I18N
        recurringInvoice.setDiscount(recurring.getDouble("discount"));        //No I18N
        recurringInvoice.setIsDiscountBeforeTax(recurring.getBoolean("is_discount_before_tax")); //No I18N
        recurringInvoice.setDiscountType(recurring.getString("discount_type"));
        recurringInvoice.setPaymentTerms(recurring.getInt("payment_terms")); //No I18N
        recurringInvoice.setPaymentTermsLabel(recurring.getString("payment_terms_label"));


        JSONArray contactPerson = recurring.getJSONArray("contact_persons"); //No I18N

        String[] contactPersons = new String[contactPerson.length()];

        for (int j = 0; j < contactPerson.length(); j++) {
            contactPersons[j] = contactPerson.getString(j);
        }

        recurringInvoice.setContactPersons(contactPersons);

        JSONArray lineItems = recurring.getJSONArray("line_items"); //No I18N

        List<LineItem> lineItemsList = new ArrayList<LineItem>();

        for (int i = 0; i < lineItems.length(); i++) {
            LineItem lineItem = new LineItem();

            lineItem.setTaxName(lineItems.getJSONObject(i).getString("tax_name"));
            lineItem.setTaxType(lineItems.getJSONObject(i).getString("tax_type"));
            lineItem.setLineItemId(lineItems.getJSONObject(i).getString("line_item_id"));
            lineItem.setDiscount(lineItems.getJSONObject(i).getDouble("discount")); //No I18N
            lineItem.setUnit(lineItems.getJSONObject(i).getString("unit"));
            lineItem.setItemOrder(lineItems.getJSONObject(i).getInt("item_order")); //No I18N
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));    //No I18N
            lineItem.setItemId(lineItems.getJSONObject(i).getString("item_id"));
            lineItem.setDescription(lineItems.getJSONObject(i).getString("description"));
            lineItem.setName(lineItems.getJSONObject(i).getString("name"));
            lineItem.setTaxId(lineItems.getJSONObject(i).getString("tax_id"));
            lineItem.setQuantity(lineItems.getJSONObject(i).getDouble("quantity")); //No I18N
            lineItem.setTaxPercentage(lineItems.getJSONObject(i).getDouble("tax_percentage")); //No I18N
            lineItem.setItemTotal(lineItems.getJSONObject(i).getDouble("item_total")); //No I18N

            lineItemsList.add(i, lineItem);
        }

        recurringInvoice.setLineItems(lineItemsList);

        recurringInvoice.setShippingCharge(recurring.getDouble("shipping_charge"));    //No I18N
        recurringInvoice.setAdjustment(recurring.getDouble("adjustment"));        //No I18N
        recurringInvoice.setAdjustmentDescription(recurring.getString("adjustment_description"));
        recurringInvoice.setSubTotal(recurring.getDouble("sub_total")); //No I18N
        recurringInvoice.setTaxTotal(recurring.getDouble("tax_total"));    //No I18N
        recurringInvoice.setTotal(recurring.getDouble("total"));    //No I18N
        recurringInvoice.setAllowPartialPayments(recurring.getBoolean("allow_partial_payments")); //No I18N

        JSONArray taxes = recurring.getJSONArray("taxes"); //No I18N

        List<Tax> taxesList = new ArrayList<Tax>();

        for (int k = 0; k < taxes.length(); k++) {
            Tax tax = new Tax();

            tax.setTaxName(taxes.getJSONObject(k).getString("tax_name"));
            tax.setTaxAmount(taxes.getJSONObject(k).getDouble("tax_amount")); //No I18N

            taxesList.add(k, tax);
        }

        recurringInvoice.setTaxes(taxesList);

        JSONObject paymentOptions = recurring.getJSONObject("payment_options"); //No I18N

        JSONArray paymentGateways = paymentOptions.getJSONArray("payment_gateways"); //No I18N

        List<PaymentGateway> paymentGatewaysList = new ArrayList<PaymentGateway>();

        for (int l = 0; l < paymentGateways.length(); l++) {
            PaymentGateway paymentGateway = new PaymentGateway();

            paymentGateway.setGatewayName(paymentGateways.getJSONObject(l).getString("gateway_name"));

            if (paymentGateways.getJSONObject(l).has("additional_field1")) {
                paymentGateway.setAdditionalField1(paymentGateways.getJSONObject(l).getString("additional_field1"));
            }
            if (paymentGateways.getJSONObject(l).has("configured")) {
                paymentGateway.setConfigured(paymentGateways.getJSONObject(l).getBoolean("configured")); //No I18N
            }


            paymentGatewaysList.add(l, paymentGateway);
        }

        recurringInvoice.setPaymentGateways(paymentGatewaysList);

        JSONObject billingAddress = recurring.getJSONObject("billing_address"); //No I18N

        Address billingAddressObj = new Address();

        billingAddressObj.setAddress(billingAddress.getString("address"));
        billingAddressObj.setCity(billingAddress.getString("city"));
        billingAddressObj.setState(billingAddress.getString("state"));
        billingAddressObj.setZip(billingAddress.getString("zip"));
        billingAddressObj.setCountry(billingAddress.getString("country"));
        billingAddressObj.setFax(billingAddress.getString("fax"));

        recurringInvoice.setBillingAddress(billingAddressObj);

        JSONObject shippingAddress = recurring.getJSONObject("shipping_address"); //No I18N

        Address shippingAddressObj = new Address();

        shippingAddressObj.setAddress(shippingAddress.getString("address"));
        shippingAddressObj.setCity(shippingAddress.getString("city"));
        shippingAddressObj.setState(shippingAddress.getString("state"));
        shippingAddressObj.setZip(shippingAddress.getString("zip"));
        shippingAddressObj.setCountry(shippingAddress.getString("country"));
        shippingAddressObj.setFax(shippingAddress.getString("fax"));

        recurringInvoice.setShippingAddress(shippingAddressObj);

        recurringInvoice.setTemplateId(recurring.getString("template_id"));
        recurringInvoice.setTemplateName(recurring.getString("template_name"));
        recurringInvoice.setNotes(recurring.getString("notes"));
        recurringInvoice.setTerms(recurring.getString("terms"));
        recurringInvoice.setSalespersonId(recurring.getString("salesperson_id"));
        recurringInvoice.setSalespersonName(recurring.getString("salesperson_name"));

        return recurringInvoice;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for recurring invoices.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String response) throws Exception {

        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("comments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Comment comment = new Comment();

            comment.setCommentId(jsonArray.getJSONObject(i).getString("comment_id"));
            comment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            comment.setInvoiceId(jsonArray.getJSONObject(i).getString("recurring_invoice_id"));
            comment.setCommentedById(jsonArray.getJSONObject(i).getString("commented_by_id"));
            comment.setCommentedBy(jsonArray.getJSONObject(i).getString("commented_by"));
            comment.setCommentType(jsonArray.getJSONObject(i).getString("comment_type"));
            comment.setDate(jsonArray.getJSONObject(i).getString("date"));
            comment.setDateDescription(jsonArray.getJSONObject(i).getString("date_description"));
            comment.setTime(jsonArray.getJSONObject(i).getString("time"));
            comment.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            comment.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));
            comment.setOperationType(jsonArray.getJSONObject(i).getString("operation_type"));

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
