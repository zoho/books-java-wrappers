/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.CommentList;
import com.zoho.books.model.RecurringInvoice;
import com.zoho.books.model.RecurringInvoiceList;
import com.zoho.books.parser.RecurringInvoiceParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.util.HashMap;


/**
 * RecurringInvoicesApi is used to create a new recurring invoice for the customer.
 * <p>
 * It is used to get: <br><br>
 * <p>
 * The list of all recurring invoices.<br>
 * <p>
 * The details of a recurring invoice.<br>
 * <p>
 * The list of recurring invoice history.<br><br>
 * <p>
 * It is used to: <br><br>
 * <p>
 * Update the details of a recurring invoice.<br>
 * <p>
 * Stop an active recurring invoice.<br>
 * <p>
 * Resume a stopped recurring invoice.<br>
 * <p>
 * Update the recurring invoice template.<br>
 * <p>
 * Delete a recurring invoice. <br>
 */

public class RecurringInvoicesApi extends API {

    private static String url = baseURL + "/recurringinvoices"; //No I18N

    /**
     * Construct a new RecurringInvoicesApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public RecurringInvoicesApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private RecurringInvoiceParser recurringInvoiceParser = new RecurringInvoiceParser();


    /**
     * Create a recurring invoice for your customer.
     * <p>
     * Pass the RecurringInvoice object to create a new recurring invoice for the customer.
     * <p>
     * The recurringInvoice object which contains recurrenceName, customerId, and recurrenceFrequency are the mandatory parameters.
     * <p>
     * It returns the RecurringInvoice object.
     *
     * @param recurringInvoice RecurringInvoice object.
     * @return Returns the RecurringInvoice object.
     */

    public RecurringInvoice create(RecurringInvoice recurringInvoice) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", recurringInvoice.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return recurringInvoiceParser.getRecurringInvoice(response);
    }

    /**
     * Get the details of a recurring invoice.
     * <p>
     * Pass the recurringInvoiceId to get the details of a particular recurring invoice.
     * <p>
     * It returns the RecurringInvoice object.
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     * @return Returns the RecurringInvoice object.
     */

    public RecurringInvoice get(String recurringInvoiceId) throws Exception {

        String urlString = url + "/" + recurringInvoiceId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        RecurringInvoice recurringInvoice = recurringInvoiceParser.getRecurringInvoice(response);

        return recurringInvoice;
    }

    /**
     * Update an existing recurring invoice (To delete a line item just remove it from the line_items list).
     * <p>
     * Pass the RecurringInvoice object to update the details of a recurring invoice.
     * <p>
     * The recurringInvoice object which contains recurringInvoiceId is the mandatory parameter for which recurring invoice details has to be updated.
     * <p>
     * It returns the RecurringInvoice object.
     *
     * @param recurringInvoice RecurringInvoice object.
     * @return Returns the RecurringInvoice object.
     */

    public RecurringInvoice update(RecurringInvoice recurringInvoice) throws Exception {

        String urlString = url + "/" + recurringInvoice.getRecurringInvoiceId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", recurringInvoice.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return recurringInvoiceParser.getRecurringInvoice(response);

    }

    /**
     * Delete an existing recurring invoice.
     * <p>
     * Pass the recurringInvoiceId to delete the recurring invoice.
     * <p>
     * If the recurring invoice has been deleted it returns the success message.
     * <p>
     * The success message is "The recurring invoice has been deleted."
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     * @return Returns a String.
     */

    public String delete(String recurringInvoiceId) throws Exception {

        String urlString = url + "/" + recurringInvoiceId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        String success = recurringInvoiceParser.getMessage(response);

        return success;
    }

    /**
     * List all recurring invoices with pagination.
     * <p>
     * Pass the filters in the form of key-value pair to get all the recurringInvoices based on the filters.
     * <p>
     * It returns the RecurringInvoiceList object. <br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below: <br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>recurrence_name</td><td>Search recurring invoices by name.<br>
     * Variants: <i>recurrence_name_startswith</i> and <i>recurrence_name_contains</i></td></tr>
     * <p>
     * <tr><td>item_name</td><td>Search recurring invoices by item name.<br>
     * Variants: <i>item_name_startswith</i> and <i>profileitemname_contains</i></td></tr>
     * <p>
     * <tr><td>item_description</td><td>Search recurring invoices by item description.<br>
     * Variants: <i>item_description_startswith</i> and <i>item_description_contains</i></td></tr>
     * <p>
     * <tr><td>customer_name</td><td>Search recurring invoices by customer name.<br>
     * Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
     * <p>
     * <tr><td>line_item_id</td><td>Search recurring invoices by line item id.</td></tr>
     * <p>
     * <tr><td>item_id</td><td>Search recurring invoices by item id.</td></tr>
     * <p>
     * <tr><td>tax_id</td><td>Search recurring invoices by tax id.</td></tr>
     * <p>
     * <tr><td>notes</td><td>Search recurring invoices by notes.<br>
     * Variants: <i>notes_startswith</i> and <i>notes_contains</i></td></tr>
     * <p>
     * <tr><td>start_date</td><td>Search recurring invoices by start date.<br>
     * Variants: <i>start_date_start, start_date_end, start_date_before</i> and <i>start_date_after</i></td></tr>
     * <p>
     * <tr><td>end_date</td><td>Search recurring invoices by end date.<br>
     * Variants: <i>end_date_start, end_date_end, end_date_before</i> and <i>end_date_after</i></td></tr>
     * <p>
     * <tr><td>customer_id</td><td>Search recurring invoices by customer id.</td></tr>
     * <p>
     * <tr><td>search_text</td><td>Search recurring invoices by recurring invoice name or customer name.</td></tr>
     * <p>
     * <tr><td>status</td><td>Search recurring invoices by status.<br>
     * Allowed Values: <i>active, stopped</i> and <i>expired</i></td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter recurring invoices by any status.<br>
     * Allowed Values: <i>Status.All, Status.Active, Status.Stopped</i> and <i>Status.Expired</i></td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort recurring invoices. <br>
     * Allowed Values: <i>customer_name, recurrence_name, total, start_date, end_date, last_sent_date, next_invoice_date</i> and <i>created_time</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the RecurringInvoiceList object.
     */

    public RecurringInvoiceList getRecurringInvoices(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        RecurringInvoiceList recurringInvoiceList = recurringInvoiceParser.getRecurringInvoices(response);

        return recurringInvoiceList;
    }

    /**
     * Stop an active recurring invoice.
     * <p>
     * Pass the recurringInvoiceId to stop the active recurring invoice.
     * <p>
     * If the recurring invoice has been stopped it returns the success message.
     * <p>
     * The success message is "The recurring invoice has been stopped."
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     * @return Returns a String.
     */

    public String stop(String recurringInvoiceId) throws Exception {

        String urlString = url + "/" + recurringInvoiceId + "/status/stop"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = recurringInvoiceParser.getMessage(response);

        return success;
    }

    /**
     * Resume a stopped recurring invoice.
     * <p>
     * Pass the recurringInvoiceId to resume a stopped recurring invoice.
     * <p>
     * If the recurring invoice has been activated it returns the success message.
     * <p>
     * The success message is "The recurring invoice has been activated."
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     * @return Returns a String.
     */

    public String resume(String recurringInvoiceId) throws Exception {

        String urlString = url + "/" + recurringInvoiceId + "/status/resume"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = recurringInvoiceParser.getMessage(response);

        return success;
    }

    /**
     * Update the pdf template associated with the recurring invoice.
     * <p>
     * Pass the recurringInvoiceId, templateId to update the respective template for the recurring invoice.
     * <p>
     * If the the template has been updated it returns the success message.
     * <p>
     * The success message is "Recurring invoice information has been updated."
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     * @param templateId         ID of the template.
     * @return Returns a String.
     */

    public String updateTemplate(String recurringInvoiceId, String templateId) throws Exception {
        String urlString = url + "/" + recurringInvoiceId + "/templates/" + templateId; //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap());

        String success = recurringInvoiceParser.getMessage(response);

        return success;
    }

    /**
     * Get the complete history and comments of a recurring invoice.
     * <p>
     * Pass the recurringInvoiceId to get all the comments for the recurring invoice.
     * <p>
     * It returns the CommentList object.
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String recurringInvoiceId) throws Exception {

        String urlString = url + "/" + recurringInvoiceId + "/comments"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CommentList commentList = recurringInvoiceParser.getComments(response);

        return commentList;
    }

}
