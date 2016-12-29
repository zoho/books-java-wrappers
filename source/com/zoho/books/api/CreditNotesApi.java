/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.CreditNoteParser;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CreditNotesApi is used to create a new credit note for a customer.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of credit notes.<br>
 * <p>
 * The details of a credit note.<br>
 * <p>
 * The email history of a credit note.<br>
 * <p>
 * The email content of a credit note.<br>
 * <p>
 * The list of credit note templates.<br>
 * <p>
 * The list of invoice credits.<br>
 * <p>
 * The list of credit note refunds.<br>
 * <p>
 * The list of refunds of a credit note.<br>
 * <p>
 * The details of a credit note refund.<br>
 * <p>
 * The list of credit note comments.<br><br>
 * <p>
 * It is used to:<br><br>
 * <p>
 * Send an email to a customer.<br>
 * <p>
 * Apply credit note to an invoice.<br>
 * <p>
 * Add a credit note refund.<br>
 * <p>
 * Add a comment for the credit note.<br><br>
 * <p>
 * It is used to update:<br><br>
 * <p>
 * The details of a credit note.<br>
 * <p>
 * The billing address of a credit note.<br>
 * <p>
 * The shipping address of a credit note.<br>
 * <p>
 * The pdf template of a credit note.<br>
 * <p>
 * The details of a credit note refund. <br><br>
 * <p>
 * It is used to change the status:<br><br>
 * <p>
 * Mark a credit note status to open.<br>
 * <p>
 * Mark a credit note as void.<br><br>
 * <p>
 * It is used to delete:<br><br>
 * <p>
 * The existing credit note.<br>
 * <p>
 * The credits applied to an invoice.<br>
 * <p>
 * The credit note refund.<br>
 * <p>
 * The credit note comment.<br>
 */

public class CreditNotesApi extends API {


    private static String url = baseURL + "/creditnotes"; //No I18N


    /**
     * Construct a new CreditNotesApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public CreditNotesApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private CreditNoteParser creditNoteParser = new CreditNoteParser();


    /**
     * Create a credit note for a customer.
     * <p>
     * Pass the customerId, accountId, and itemName to create a new Credit note for a customer.
     * <p>
     * It returns the CreditNote object.
     *
     * @param customerId ID of the customer the credit note has to be created.
     * @param accountId  ID of the account, the line item is associated with.
     * @param itemName   Name of the line item.
     * @return Returns the CreditNote object.
     */

    public CreditNote create(String customerId, String accountId, String itemName) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        CreditNote creditNote = new CreditNote();

        creditNote.setCustomerId(customerId);

        List<LineItem> lineItems = new ArrayList<LineItem>();

        LineItem lineItem = new LineItem();

        lineItem.setAccountId(accountId);
        lineItem.setName(itemName);

        lineItems.add(0, lineItem);

        creditNote.setLineItems(lineItems);


        requestBody.put("JSONString", creditNote.toJSON().toString());

        String resp = ZohoHTTPClient.post(url, requestBody);

        return creditNoteParser.getCreditNote(resp);
    }


    /**
     * Create a credit note for a customer.
     * <p>
     * Pass the CreditNote object and query string to create a new credit note for a customer.<br>
     * <p>
     * The paramMap contains the possible keys as mentioned below:<br><br>
     * <p>
     * invoice_id - Create a credit note and apply it to an invoice.<br>
     * <p>
     * ignore_auto_number_generation - Ignore auto number generation for this credit note only. To enable this option credit note number is mandatory.<br><br>
     * <p>
     * It returns the CreditNote object.
     *
     * @param creditNote CreditNote object.
     * @param paramMap   It contains the query string in the form of key-value pair.
     * @return Returns the CreditNote object.
     */

    public CreditNote create(CreditNote creditNote, HashMap<String, Object> paramMap) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", creditNote.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return creditNoteParser.getCreditNote(response);
    }


    /**
     * Get details of a credit note.
     * <p>
     * Pass the creditNoteId to get the details of a credit note.
     * <p>
     * It returns the CreditNote object.
     *
     * @param creditNoteId ID of the CreditNote.
     * @return Returns the CreditNote object.
     */


    public CreditNote get(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CreditNote creditNote = creditNoteParser.getCreditNote(response);

        return creditNote;
    }

    /**
     * Update an existing credit note.
     * <p>
     * Pass the CreditNote object and query string parameters to update the details of a credit note.
     * <p>
     * The paramMap contains the possible key as mentioned below: <br><br>
     * <p>
     * ignore_auto_number_generation - Allow editing of credit note number.<br><br>
     * <p>
     * The CreditNote object which contains creditNoteId is the mandatory parameter for which credit note details has to be updated.
     * <p>
     * It returns the CreditNote object.
     *
     * @param creditNote CreditNote object.
     * @param paramMap   It contains the parameters in the form of key-value pair.
     * @return Returns a CreditNote object.
     */

    public CreditNote update(CreditNote creditNote, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + creditNote.getCreditnoteId();

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", creditNote.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return creditNoteParser.getCreditNote(response);

    }

    /**
     * Delete a credit note.
     * <p>
     * Pass the creditNoteId to delete a credit note.
     * <p>
     * If the credit note has been deleted it returns the success message.
     * <p>
     * The success message is "The credit note has been deleted."
     *
     * @param creditNoteId ID of the CreditNote.
     * @return Returns a String.
     */

    public String delete(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * List credit notes with pagination.
     * <p>
     * Pass the filters in the form of key-value pair to get all the credit notes based on the filter.
     * <p>
     * It returns the CreditNoteList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>creditnote_number</td><td>Search credit notes by credit note number.<br>
     * Variants: <i>creditnote_number_startswith</i> and <i>creditnote_number_contains</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Search credit notes by credit note date.<br>
     * Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
     * <p>
     * <tr><td>total</td><td>Search credit notes by credit note total amount.<br>
     * Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Search credit notes by credit note reference number.<br>
     * Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
     * <p>
     * <tr><td>customer_name</td><td>Search credit notes by customer name.<br>
     * Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
     * <p>
     * <tr><td>item_name</td><td>Search credit notes by item name.<br>
     * Variants: <i>item_name_startswith</i> and <i>item_name_contains</i></td></tr>
     * <p>
     * <tr><td>item_description</td><td>Search credit notes by credit note item description.<br>
     * Variants: <i>item_description_startswith</i> and <i>item_description_contains</i></td></tr>
     * <p>
     * <tr><td>customer_id</td><td>Search credit notes by customer id.</td></tr>
     * <p>
     * <tr><td>line_item_id</td><td>Search credit notes by credit note line item id.</td></tr>
     * <p>
     * <tr><td>item_id</td><td>Search credit notes by item id.</td></tr>
     * <p>
     * <tr><td>tax_id</td><td>Search credit notes by tax id.</td></tr>
     * <p>
     * <tr><td>search_text</td><td>Search credit notes by credit note number or customer name or credit note reference number.</td></tr>
     * <p>
     * <tr><td>status</td><td>Search credit notes by credit note status. Allowed statuses are draft,open,closed and void.<br>
     * Allowed Values: <i>open, closed</i> and <i>void</i></td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter credit notes by statuses.<br>
     * Allowed Values: <i>Status.All, Status.Open, Status.Draft, Status.Closed</i> and <i>Status.Void</td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort credit notes by following columns customer_name, creditnote_number, balance, total, date and created_time.<br>
     * Allowed Values: <i>customer_name, creditnote_number, balance, total, date</i> and <i>created_time</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the CreditNoteList object.
     */

    public CreditNoteList getCreditNotes(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        CreditNoteList creditNoteList = creditNoteParser.getCreditNotes(response);

        return creditNoteList;
    }


    /**
     * Email a credit note to the customer.
     * <p>
     * Pass the creditNoteId, Email object and query string parameters to send an email credit note to a customer.
     * <p>
     * The paramMap contains the possible key as mentioned below: <br><br>
     * <p>
     * customer_id - ID of the customer.<br><br>
     * <p>
     * If the email has been sent to the customer it returns the success message.
     * <p>
     * The success message is "Your credit note has been sent."
     *
     * @param creditNoteId ID of the CreditNote.
     * @param paramMap     It contains the ID of the customer.
     * @param email        Email object.
     * @return Returns a String.
     */

    public String sendEmail(String creditNoteId, Email email, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + creditNoteId + "/email"; //No I18N


        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }
        HashMap<String, Object> fileBody = null;
        if (email != null) {
            paramMap.put("JSONString", email.toJSON().toString());

            ArrayList<File> files = email.getAttachments();

            if (files != null && files.size() > 0) {
                fileBody = new HashMap<String, Object>(files.size());

                fileBody.put("attachments", files);
            }
        }


        String response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * Get email history of a credit note.
     * <p>
     * Pass the creditNoteId to get all the email history for the credit note.
     * <p>
     * It returns the EmailHistoryList object.
     *
     * @param creditNoteId ID of the CreditNote.
     * @return Returns the EmailHistoryList object.
     */

    public EmailHistoryList getEmailHistory(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/emailhistory"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        EmailHistoryList emailHistory = creditNoteParser.getEmailHistory(response);

        return emailHistory;
    }

    /**
     * Get email content of a credit note.
     * <p>
     * Pass the creditNoteId and query string parameters to get the email content for the credit note.
     * <p>
     * The queryMap contains the possible key as mentioned below:<br><br>
     * <p>
     * email_template_id - Get the email content based on a specific email template. <br><br>
     * <p>
     * It returns the Email object.
     *
     * @param creditNoteId ID of the CreditNote.
     * @param queryMap     Get the email content based on a specific email template.
     * @return Returns the Email object.
     */

    public Email getEmailContent(String creditNoteId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + creditNoteId + "/email"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        Email email = creditNoteParser.getEmailContent(response);

        return email;
    }

    /**
     * Change an existing credit note status to open (A void credit note can't be changed to open).
     * <p>
     * Pass the creditNoteId to change the status of a credit note to 'open'.
     * <p>
     * If the credit note status has been changed it returns the success message.
     * <p>
     * The success message is "The status of the credit note has been changed to open."
     *
     * @param creditNoteId ID of the CreditNote.
     * @return Returns a String.
     */

    public String convertToOpen(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/status/open"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * Mark an existing credit note as void.
     * <p>
     * Pass the creditNoteId to change the status of a credit note to 'void'.
     * <p>
     * If the credit note status has been changed it returns the success message.
     * <p>
     * The success message is "The credit note has been marked as void."
     *
     * @param creditNoteId ID of the CreditNote.
     * @return Returns a String.
     */

    public String convertToVoid(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/status/void"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * Update the billing address for an existing credit note alone (You can set this address as default billing address for your customer by specifying 'is_update_customer' node as true).
     * <p>
     * Pass the creditNoteId and Address object to update the billing address of a credit note.
     * <p>
     * If the billing address has been updated it returns the success message.
     * <p>
     * The success message is "Billing address updated".
     *
     * @param creditNoteId   ID of the CreditNote.
     * @param billingAddress Address object.
     * @return Returns a String.
     */

    public String updateBillingAddress(String creditNoteId, Address billingAddress) throws Exception {

        String urlString = url + "/" + creditNoteId + "/address/billing"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", billingAddress.toJSON().put("is_update_customer", billingAddress.isUpdateCustomer()).toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * Update the shipping address for an existing credit note alone (You can set this address as default shipping address for your customer by specifying 'is_update_customer' node as true).
     * <p>
     * Pass the creditNoteId and Address object to update the shipping address of a credit note.
     * <p>
     * If the shipping address has been updated it returns the success message.
     * <p>
     * The success message is "Shipping address updated".
     *
     * @param creditNoteId    ID of the CreditNote.
     * @param shippingAddress Address object.
     * @return Returns a String.
     */

    public String updateShippingAddress(String creditNoteId, Address shippingAddress) throws Exception {

        String urlString = url + "/" + creditNoteId + "/address/shipping"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", shippingAddress.toJSON().put("is_update_customer", shippingAddress.isUpdateCustomer()).toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * Get all credit note pdf templates.
     * <p>
     * It returns the TemplateList object.
     *
     * @return Returns the TemplateList object.
     */

    public TemplateList getTemplates() throws Exception {

        String urlString = url + "/templates"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        TemplateList templateList = creditNoteParser.getTemplates(response);

        return templateList;
    }

    /**
     * Update the pdf template associated with the credit note.
     * <p>
     * Pass the creditNoteId and templateId to update the respective template for the credit note.
     * <p>
     * If the template has been updated it returns the success message.
     * <p>
     * The success message is "The credit note has been updated."
     *
     * @param creditNoteId ID of the CreditNote.
     * @param templateId   ID of the template.
     * @return Returns a String.
     */

    public String updateTemplate(String creditNoteId, String templateId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/templates/" + templateId; //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;

    }


//===========================================================================================================================================


    /**
     * Apply credit note to existing invoices.
     * <p>
     * Pass the creditNoteId and list of Invoice objects to apply the credit to invoice.
     * <p>
     * It returns the InvoiceList object.
     *
     * @param creditNoteId ID of the CreditNote.
     * @param invoice      List of Invoice object.
     * @return Returns the InvoiceList object.
     */

    public InvoiceList creditToInvoice(String creditNoteId, List<Invoice> invoice) throws Exception {

        String urlString = url + "/" + creditNoteId + "/invoices"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();

        JSONArray invoices = new JSONArray();

        for (int i = 0; i < invoice.size(); i++) {
            JSONObject invoic = new JSONObject();

            invoic.put("invoice_id", invoice.get(i).getInvoiceId());
            invoic.put("amount_applied", invoice.get(i).getAmountApplied());

            invoices.put(invoic);
        }

        jsonObject.put("invoices", invoices);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return creditNoteParser.getCreditToInvoice(response);

    }

    /**
     * List invoices to which the credit note is applied.
     * <p>
     * Pass the creditNoteId to get the invoices credited list.
     * <p>
     * It returns the InvoicesCreditedList object.
     *
     * @param creditNoteId ID of the CreditNote.
     * @return Returns the InvoicesCreditedList object.
     */

    public InvoicesCreditedList getInvoicesCredited(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/invoices"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        InvoicesCreditedList invoicesCredited = creditNoteParser.getInvoicesCredited(response);

        return invoicesCredited;

    }

    /**
     * Delete the credits applied to an invoice.
     * <p>
     * Pass the creditNoteId and creditNoteInvoiceId to delete the invoices credited for the credit note.
     * <p>
     * If the credited invoices has been deleted it returns the success message.
     * <p>
     * The success message is "Credits applied to an invoice have been deleted."
     *
     * @param creditNoteId        ID of the CreditNote.
     * @param creditnoteInvoiceId ID of the invoice, the credit note is being applied.
     * @return Returns a String.
     */

    public String deleteInvoicesCredited(String creditNoteId, String creditnoteInvoiceId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/invoices/" + creditnoteInvoiceId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;
    }


//=========================================================================================================================================


    /**
     * Refund credit note amount.
     * <p>
     * Pass the creditNoteId, CreditnoteRefund object to add the refund amount for the credit note.
     * <p>
     * The CreditnoteRefund object which contains date and amount are the mandatory parameters.
     * <p>
     * It returns the CreditnoteRefund object.
     *
     * @param creditNoteId     ID of the creditnote.
     * @param creditnoteRefund CreditnoteRefund object.
     * @return Returns the CreditnoteRefund object.
     */

    public CreditnoteRefund addRefund(String creditNoteId, CreditnoteRefund creditnoteRefund) throws Exception {

        String urlString = url + "/" + creditNoteId + "/refunds"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", creditnoteRefund.toJSON().toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return creditNoteParser.getCreditnoteRefund(response);
    }

    /**
     * Get refund of a particular credit note.
     * <p>
     * Pass creditNoteId and creditnoteRefundId to get all the refunds for the credit note.
     * <p>
     * It returns the CreditnoteRefund object.
     *
     * @param creditNoteId       ID of the creditnote.
     * @param creditnoteRefundId ID of the Creditnote refund.
     * @return Returns the CreditnoteRefund object.
     */

    public CreditnoteRefund getRefund(String creditNoteId, String creditnoteRefundId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/refunds/" + creditnoteRefundId; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CreditnoteRefund creditnoteRefund = creditNoteParser.getCreditnoteRefund(response);

        return creditnoteRefund;

    }

    /**
     * Update the refunded transaction.
     * <p>
     * Pass the creditNoteId and CreditnoteRefund object to update the details of a creditnote refund.
     * <p>
     * The CreditnoteRefund object which contains creditnoteRefundId is the mandatory parameter.
     * <p>
     * It returns the CreditnoteRefund object.
     *
     * @param creditNoteId     ID of the creditnote.
     * @param creditnoteRefund CreditnoteRefund object.
     * @return Returns the CreditnoteRefund object.
     */

    public CreditnoteRefund updateRefund(String creditNoteId, CreditnoteRefund creditnoteRefund) throws Exception {

        String urlString = url + "/" + creditNoteId + "/refunds/" + creditnoteRefund.getCreditnoteRefundId(); //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", creditnoteRefund.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return creditNoteParser.getCreditnoteRefund(response);
    }

    /**
     * Delete a credit note refund.
     * <p>
     * Pass the creditNoteId and creditnoteRefundId to delete the creditnote refund.
     * <p>
     * If the creditnote refund has been deleted it returns the success message.
     * <p>
     * The success message is "The refund has been successfully deleted."
     *
     * @param creditNoteId       ID of the creditnote.
     * @param creditnoteRefundId ID of the credintnote refund.
     * @return Returns a String.
     */

    public String deleteRefund(String creditNoteId, String creditnoteRefundId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/refunds/" + creditnoteRefundId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;
    }

    /**
     * List all refunds of an existing credit note.
     * <p>
     * Pass the creditNoteId to get all the creditnote refunds for the credit note.
     * <p>
     * It returns the CreditnoteRefundList object.
     *
     * @param creditNoteId ID of the creditnote.
     * @return Returns the CreditnoteRefundList object.
     */

    public CreditnoteRefundList getRefundsOfCreditnotes(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/refunds"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CreditnoteRefundList creditnoteRefundList = creditNoteParser.getRefunds(response);

        return creditnoteRefundList;
    }

    /**
     * List all refunds with pagination.
     * <p>
     * Pass the filters to get all the refunds based on the filter.
     * <p>
     * It returns the CreditnoteRefundList object. <br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>customer_id</td><td>List credit note refunds made for a particular customer.</td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort refunds list. <br>
     * Allowed Values: <i>refund_mode, reference_number, date, creditnote_number, customer_name, amount_bcy</i> and <i>amount_fcy</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the CreditnoteRefundList object.
     */

    public CreditnoteRefundList getCreditnoteRefunds(HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/refunds"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        CreditnoteRefundList creditnoteRefundList = creditNoteParser.getRefunds(response);

        return creditnoteRefundList;
    }


//======================================================================================================================================


    /**
     * Add a comment to an existing credit note.
     * <p>
     * Pass the creditNoteId and description to add a comment for the credit note.
     * <p>
     * It returns the Comment object.
     *
     * @param creditNoteId ID of the creditnote.
     * @param description  Description for the refund recorded.
     * @return Returns the Comment object.
     */

    public Comment addComment(String creditNoteId, String description) throws Exception {

        String urlString = url + "/" + creditNoteId + "/comments"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        Comment comment = creditNoteParser.getComment(response);

        return comment;
    }

    /**
     * Get history and comments of a credit note.
     * <p>
     * Pass the creditNoteId to get all the comments for the credit note.
     * <p>
     * It returns the CommentList object.
     *
     * @param creditNoteId ID of the creditnote.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String creditNoteId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/comments"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CommentList commentList = creditNoteParser.getComments(response);

        return commentList;
    }


    /**
     * Delete a credit note comment.
     * <p>
     * Pass the creditNoteId and commentId to delete the comment for the credit note.
     * <p>
     * If the comment has been deleted it returns the success message.
     * <p>
     * The success message is "The comment has been deleted."
     *
     * @param creditNoteId ID of the creditnote.
     * @param commentId    ID of the Comment.
     * @return Returns a String.
     */

    public String deleteComment(String creditNoteId, String commentId) throws Exception {

        String urlString = url + "/" + creditNoteId + "/comments/" + commentId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = creditNoteParser.getMessage(response);

        return success;
    }


}
