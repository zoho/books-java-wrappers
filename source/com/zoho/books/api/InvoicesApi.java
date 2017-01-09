/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.InvoiceParser;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * InvoicesApi is used to create a new invoice for the customer.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of all invoices.<br>
 * <p>
 * The details of an invoice.<br>
 * <p>
 * The invoice email content.<br>
 * <p>
 * The payment reminder email content.<br>
 * <p>
 * The invoices as pdf.<br>
 * <p>
 * The invoice templates.<br>
 * <p>
 * The list of invoice payments.<br>
 * <p>
 * The list of credits applied for an invoice.<br>
 * <p>
 * The invoice attachment.<br>
 * <p>
 * The list of comments for an invoice.<br><br>
 * <p>
 * It is used to update:<br><br>
 * <p>
 * The details of an invoice.<br>
 * <p>
 * The billing address of an invoice.<br>
 * <p>
 * The shipping address of an invoice.<br>
 * <p>
 * The templates of an invoice.<br>
 * <p>
 * The attachment preference of an invoice.<br>
 * <p>
 * The comment of an invoice.<br><br>
 * <p>
 * It is used to change the status:<br><br>
 * <p>
 * Mark an invoice as sent.<br>
 * <p>
 * Mark an invoice as void.<br>
 * <p>
 * Mark an invoice as draft.<br>
 * <p>
 * Enable payment reminder for an invoice.<br>
 * <p>
 * Disable payment reminder for an invoice.<br>
 * <p>
 * Write off the invoice balance amount of an invoice.<br>
 * <p>
 * Cancel write off amount of an invoice.<br><br>
 * <p>
 * It is used to send:<br><br>
 * <p>
 * Invoice to your customer by email.<br>
 * <p>
 * Invoices to your customers by email.<br>
 * <p>
 * Reminder to your customer by email.<br>
 * <p>
 * Reminder to your multiple customers by email.<br><br>
 * <p>
 * It is used to:<br><br>
 * <p>
 * Apply creditnotes to an invoice.<br>
 * <p>
 * Attach a file to an invoice.<br>
 * <p>
 * Add a comment for an invoice.<br><br>
 * <p>
 * It is used to delete:<br><br>
 * <p>
 * The existing invoice.<br>
 * <p>
 * The payment made to an invoice.<br>
 * <p>
 * The credit particularly applied to an invoice.<br>
 * <p>
 * The file attached to an invoice.<br>
 * <p>
 * The expense receipts attached to an invoice.<br>
 * <p>
 * The comment to an invoice.<br>
 */

public class InvoicesApi extends API {

    private static String url = baseURL + "/invoices"; //No I18N


    /**
     * Construct a new InvoicesApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public InvoicesApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private InvoiceParser invoiceParser = new InvoiceParser();


    /**
     * Get list of invoices.
     * <p>
     * Pass the filters in the form of key-value pair to get all the invoices based on the filters.
     * <p>
     * It returns the InvoiceList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>invoice_number</td><td>Search invoices by invoice number.<br>
     * Variants: <i>invoice_number_startswith</i> and <i>invoice_number_contains</i></td></tr>
     * <p>
     * <tr><td>item_name</td><td>Search invoices by item name.<br>
     * Variants: <i>item_name_startswith</i> and <i>item_name_contains</i></td></tr>
     * <p>
     * <tr><td>item_id</td><td>Search invoices by item id.</td></tr>
     * <p>
     * <tr><td>item_description</td><td>Search invoices by item description.<br>
     * Variants: <i>item_description_startswith</i> and <i>item_description_contains</i></td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Search invoices by invoice reference number (i.e., P.O.#).<br>
     * Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
     * <p>
     * <tr><td>customer_name</td><td>Search invoices by customer name.<br>
     * Variants: <i>customer_name_startswith</i> and <i>customer_name_contains</i></td></tr>
     * <p>
     * <tr><td>recurring_invoice_id</td><td>Search invoices by recurring profile id.</td></tr>
     * <p>
     * <tr><td>email</td><td>Search invoices by customer contact persons email.</td></tr>
     * <p>
     * <tr><td>total</td><td>Search invoices by invoice total.<br>
     * Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>
     * <p>
     * <tr><td>balance</td><td>Search invoices by invoice total.<br>
     * Variants: <i>balance_less_than, balance_less_equals, balance_greater_than</i> and <i>balance_greater_equals</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Search invoices by invoice date.<br>
     * Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
     * <p>
     * <tr><td>due_date</td><td>Search invoices by due date.<br>
     * Variants: <i>due_date_start, due_date_end, due_date_before</i> and <i>due_date_after</i></td></tr>
     * <p>
     * <tr><td>status</td><td>Search invoices by invoice status.<br>
     * Allowed Values: <i>sent, draft, overdue, paid, void, unpaid, partiallypaid</i> and <i>viewed</i></td></tr>
     * <p>
     * <tr><td>customer_id</td><td>Search invoices by customer id.</td></tr>
     * <p>
     * <tr><td>custom_field</td><td>Search invoices by custom fields.<br>
     * Variants: <i>custom_field_startswith</i> and <i>custom_field_contains</i></td></tr>
     * <p>
     * <tr><td>search_text</td><td>Search invoices by invoice number or purchase order or customer name.</td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter invoices by any status or payment expected date.<br>
     * Allowed Values: <i>Status.All, Status.Sent, Status.Draft, Status.OverDue, Status.Paid, Status.Void, Status.Unpaid, Status.PartiallyPaid, Status.Viewed</i> and <i>Date.PaymentExpectedDate</i> </td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort invoices.<br>
     * Allowed Values: <i>customer_name, invoice_number, date, due_date, total, balance</i> and <i>created_time</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the InvoiceList object.
     */

    public InvoiceList getInvoices(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        InvoiceList invoiceList = invoiceParser.getInvoices(response);

        return invoiceList;
    }

    /**
     * Create an invoice for your customer.
     * <p>
     * Pass the customerId, contactPersonId, and description to create a new invoice.
     * <p>
     * It returns the Invoice object.
     *
     * @param customerId      ID of the customer for whom the invoice has to be created.
     * @param contactPersonId ID of the contact person for whom invoice has to be sent.
     * @param description     Description of the line item.
     * @return returns the Invoice object.
     */

    public Invoice create(String customerId, String contactPersonId, String description) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        Invoice invoiceObj = new Invoice();

        invoiceObj.setCustomerId(customerId);

        String[] contactPersons = {contactPersonId};

        invoiceObj.setContactPersons(contactPersons);

        List<LineItem> lineItems = new ArrayList<LineItem>();

        LineItem lineItem = new LineItem();

        lineItem.setDescription(description);

        lineItems.add(0, lineItem);

        invoiceObj.setLineItems(lineItems);


        requestBody.put("JSONString", invoiceObj.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        Invoice invoice = invoiceParser.getInvoice(response);

        return invoice;
    }

    /**
     * Create an invoice for your customer.
     * <p>
     * Pass the Invoice object to create a new invoice for your customer.
     * <p>
     * Pass Invoice object and query string parameters to create a new invoice.<br>
     * <p>
     * The possible keys and values are mentioned below:<br><br>
     * <p>
     * send - Send the invoice to the contact person(s) associated with the invoice.
     * Allowed Values: true and false <br>
     * <p>
     * ignore_auto_number_generation - Ignore auto invoice number generation for this invoice. This mandates the invoice number.
     * Allowed Values: true and false <br><br>
     * <p>
     * The Invoice object which contains customerId, contactPersonId, and description are the mandatory parameters.
     * <p>
     * It returns the Invoice object.
     *
     * @param newInvoice Invoice object.
     * @param paramMap   It contains the parameter values in the form of key-value pair.
     * @return Returns the Invoice object.
     */

    public Invoice create(Invoice newInvoice, HashMap<String, Object> paramMap) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap(paramMap);


        requestBody.put("JSONString", newInvoice.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        Invoice invoice = invoiceParser.getInvoice(response);

        return invoice;
    }

    /**
     * Get the details of an invoice.
     * <p>
     * Pass the invoiceId to get the details of a particular invoice.
     * <p>
     * It returns the Invoice object.
     *
     * @param invoiceId ID of an invoice.
     * @return Returns an Invoice object.
     */

    public Invoice get(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Invoice invoice = invoiceParser.getInvoice(response);

        return invoice;
    }

    /**
     * Update an existing invoice (To delete a line item just remove it from the line_items list).
     * <p>
     * Pass the Invoice object and query string parameters to update the details of a particular invoice.
     * <p>
     * The possible key and value are mentioned below: <br><br>
     * <p>
     * ignore_auto_number_generation - Ignore auto estimate number generation for this estimate. This mandates the estimate number.<br>
     * <p>
     * The Invoice object which contains invoiceId is the mandatory paramter for which invoice has to be updated.
     * <p>
     * It returns the Invoice object.
     *
     * @param newInvoice Invoice object.
     * @param paramMap   It contains the parameter values in the form of key-value pair.
     * @return Returns the Invoice object.
     */

    public Invoice update(Invoice newInvoice, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + newInvoice.getInvoiceId();

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", newInvoice.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        Invoice invoice = invoiceParser.getInvoice(response);

        return invoice;
    }

    /**
     * Delete an existing invoice (Invoices which have payment or credit notes applied cannot be deleted).
     * <p>
     * Pass the invoiceId to delete a particular invoice.
     * <p>
     * If the invoice has been deleted it returns the success message.
     * <p>
     * The success message is "The invoice has been deleted."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String delete(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }


    /**
     * Email an invoice to the customer (If the Email object is not inputted, mail will be send with default mail content).
     * <p>
     * Pass the invoiceId, Email object, and query string paramters to send the email to the customer.
     * <p>
     * The possible keys and values are mentioned below: <br><br>
     * <p>
     * send_customer_statement - Send customer statement pdf a with email.<br>
     * <p>
     * send_attachment - Send the invoice attachment a with the email.<br><br>
     * <p>
     * If the email has been sent to the customer it returns the success message.
     * <p>
     * The success message is "Your invoice has been sent."
     *
     * @param invoiceId ID of an Invoice.
     * @param email     Email object which contains an email content.
     * @param paramMap  It contains the parameter values in the form of key-value pair.
     * @return Returns a String.
     */

    public String sendEmail(String invoiceId, Email email, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + invoiceId + "/email"; //No I18N


        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        HashMap<String, Object> fileBody = null;

        ArrayList<File> files = null;

        if (email != null) {
            paramMap.put("JSONString", email.toJSON().toString());

            files = email.getAttachments();

            if (files != null && files.size() > 0) {
                fileBody = new HashMap<String, Object>(files.size());

                fileBody.put("attachments", files);
            }
        }

        String response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Send invoices to your customers by email (Maximum of 10 invoices can be sent at once).
     * <p>
     * Pass the list of Contact object and query string paramters to send the email to the customers.
     * <p>
     * The paramMap contains the possible key as mentioned below: <br><br>
     * <p>
     * invoice_ids* - Comma separated invoice ids which are to be emailed. <br><br>
     * <p>
     * If the email has been sent to the customers it returns the success message.
     * <p>
     * The success message is "Mission accomplished! We've sent all the invoices."
     *
     * @param contacts Contacts for whom email or snail mail has to be sent.
     * @param paramMap Comma separated invoice ids which are to be emailed.
     * @return Returns a String.
     */

    public String sendEmailInvoices(List<Contact> contacts, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/email"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        JSONObject jsonObject = new JSONObject();

        JSONArray contactss = new JSONArray();
        if (contacts != null) {
            for (int i = 0; i < contacts.size(); i++) {
                JSONObject contact = new JSONObject();

                contact.put("contact_id", contacts.get(i).getContactId());
                contact.put("email", contacts.get(i).isEmail());
                contact.put("snail_mail", contacts.get(i).isSnailMail());

                contactss.put(contact);
            }
        }

        jsonObject.put("contacts", contactss);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Get the email content of an invoice.
     * <p>
     * Pass the invoiceId and query string parameters to get the email content of an invoice.
     * <p>
     * The queryMap contains the possible key as mentioned below: <br><br>
     * <p>
     * email_template_id - Get the email content based on a specific email template. <br><br>
     * <p>
     * It returns the Email object.
     *
     * @param invoiceId Id of an Invoice.
     * @param queryMap  Get the email content based on a specific email template.
     * @return Returns an Email object which contains the email content.
     */

    public Email getEmailContent(String invoiceId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + invoiceId + "/email"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        Email email = invoiceParser.getEmailContent(response);

        return email;
    }


    /**
     * Remind your customer about an unpaid invoice by email (Reminder will be sent, only for the invoices which are in open or overdue status).
     * <p>
     * Pass the invoiceId, Email object, and query string parameters to send the reminder to the customer.
     * <p>
     * The paramMap contains the possible key and value as mentioned below: <br><br>
     * <p>
     * send_customer_statement - Send customer statement pdf a with payment reminder. <br><br>
     * <p>
     * If the reminder has been sent to the customer it returns the success message.
     * <p>
     * The success message is "Your payment reminder has been sent."
     *
     * @param invoiceId ID of an Invoice.
     * @param email     Email Object which contains email content.
     * @param paramMap  It contains the parameter values in the form of key-value pair.
     * @return Returns a String.
     */

    public String sendPaymentReminder(String invoiceId, Email email, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + invoiceId + "/paymentreminder"; //No I18N

        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        HashMap<String, Object> fileBody = null;

        ArrayList<File> files = null;

        if (email != null) {
            paramMap.put("JSONString", email.toJSON().toString());

            files = email.getAttachments();

            if (files != null && files.size() > 0) {
                fileBody = new HashMap<String, Object>(files.size());

                fileBody.put("attachments", files);
            }
        }


        String response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Remind your customer about an unpaid invoices by email (Reminder mail will be sent, only for the invoices which are in open or overdue status. The customer can be reminded for maximum 10 invoices at once.)
     * <p>
     * Pass the query string parameters to send the reminder to the customer.
     * <p>
     * The paramMap contains the possible key as mentioned below: <br><br>
     * <p>
     * invoice_ids* - Comma separated invoice ids which the reminder has to be sent.<br><br>
     * <p>
     * If the reminder has been sent to the customer it returns the success message.
     * <p>
     * The success message is "Success! All reminders have been sent."
     *
     * @param paramMap Comma separated invoice ids for which the reminder has to be sent.
     * @return Returns a String.
     */

    public String sendBulkInvoiceReminder(HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/paymentreminder"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap(paramMap));

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Get the email content of the payment reminder.
     * <p>
     * Pass the invoiceId to get the email content of the payment reminder.
     * <p>
     * It returns the Email object.
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns the Email object.
     */

    public Email getPaymentReminder(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/paymentreminder"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Email email = invoiceParser.getEmailContent(response);

        return email;
    }

    /**
     * Mark a draft invoice as sent.
     * <p>
     * Pass the invoiceId to change the status of an invoice to 'sent'.
     * <p>
     * If the invoice status has been changed it returns the success message.
     * <p>
     * The success message is "Invoice status has been changed to Sent."
     *
     * @param invoiceId Id of an Invoice.
     * @return Returns a String.
     */

    public String markAsSent(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/status/sent"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Mark a void invoice as draft.
     * <p>
     * Pass the invoiceId to change the status of an invoice to 'draft'.
     * <p>
     * If the invoice status has been changed it returns the success message.
     * <p>
     * The success message is "Status of invoice changed from void to draft."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String markAsDraft(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/status/draft"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Mark an invoice status as void (Upon void, the payments and credits associated with the invoices will be unassociated and will be under customer credits).
     * <p>
     * Pass the invoiceId to change the status of an invoice to 'void'.
     * <p>
     * If the invoice status has been changed it returns the success message.
     * <p>
     * The success message is "Invoice status has been changed to void."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String markAsVoid(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/status/void"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Maximum of 25 invoices can be exported in a single pdf.
     * <p>
     * Pass the query string parameters to get multiple invoices in a single pdf.
     * <p>
     * The queryMap contains the possible key as mentioned below: <br><br>
     * <p>
     * invoice_ids* - Comma separated invoice ids which are to be export as pdf.<br><br>
     * <p>
     * It returns a File object.
     *
     * @param queryMap Comma separated invoice ids which are to be exported as pdf.
     * @return Returns a File that is stored in a current directory.
     */

    public File bulkExport(HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/pdf"; //No I18N

        File file = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return file;
    }

    /**
     * Export invoices as pdf, and print them (Maximum of 25 invoices can be printed).
     * <p>
     * Pass the query string parameters to get multiple invoices in a single pdf.
     * <p>
     * The queryMap contains the possible key as mentioned below: <br><br>
     * <p>
     * invoice_ids* - Comma separated invoice ids which are to be printed.<br><br>
     * <p>
     * It returns a File object.
     *
     * @param queryMap Comma separated invoice ids which are to be printed.
     * @return Returns a File that is stored in a current directory.
     */

    public File bulkPrint(HashMap<String, Object> queryMap) throws Exception {
        String urlString = url + "/print"; //No I18N

        File file = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return file;
    }

    /**
     * Enable automated payment reminders for an invoice.
     * <p>
     * Pass the invoiceId to enable payment reminder for an invoice.
     * <p>
     * If the payment reminder has been enabled it returns the success message.
     * <p>
     * The success message is "Reminders enabled."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String enablePaymentReminder(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/paymentreminder/enable"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Disable automated payment reminders for an invoice.
     * <p>
     * Pass the invoiceId to disable payment reminder for an invoice.
     * <p>
     * If the payment reminder has been disabled it returns the success message.
     * <p>
     * The success message is "Reminders stopped."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String disablePaymentReminder(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/paymentreminder/disable"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Write off the invoice balance amount of an invoice.
     * <p>
     * Pass the invoiceId to change the status of an invoice to 'writeoff'.
     * <p>
     * If the invoice status has been changed it returns the success message.
     * <p>
     * The success message is "Invoice has been written off."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String writeOffInvoice(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/writeoff"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Cancel the write-off amount of an invoice.
     * <p>
     * Pass the invoiceId to cancel the write-off amount of an invoice.
     * <p>
     * If the invoice status has been changed it returns the success message.
     * <p>
     * The success message is "Invoice has been written off."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String cancelWriteOff(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/writeoff/cancel"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Updates the billing address for this invoice alone (You can set this address as default billing address for your customer by specifying 'is_update_customer' param as true)
     * <p>
     * Pass the invoiceId and Address object to update the billing address of an invoice.
     * <p>
     * If the billing address has been updated it returns the success message.
     * <p>
     * The success message is "Billing address updated."
     *
     * @param invoiceId      Id of an Invoice.
     * @param billingAddress Address object.
     * @return Returns a String.
     */

    public String updateBillingAddress(String invoiceId, Address billingAddress) throws Exception {

        String urlString = url + "/" + invoiceId + "/address/billing"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", billingAddress.toJSON().put("is_update_customer", billingAddress.isUpdateCustomer()).toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Updates the shipping address for this invoice (You can set this address as default shipping address for your customer by specifying 'is_update_customer' param as true).
     * <p>
     * Pass the invoiceId and Address object to update the shipping address of an invoice.
     * <p>
     * If the shipping address has been updated it returns the success message.
     * <p>
     * The success message is "Shipping address updated."
     *
     * @param invoiceId       ID of an Invoice.
     * @param shippingAddress Address object.
     * @return Returns a String.
     */

    public String updateShippingAddress(String invoiceId, Address shippingAddress) throws Exception {

        String urlString = url + "/" + invoiceId + "/address/shipping"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", shippingAddress.toJSON().put("is_update_customer", shippingAddress.isUpdateCustomer()).toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Get all invoice pdf templates.
     * <p>
     * It returns the TemplateList object.
     *
     * @return Returns the TemplateList object.
     */

    public TemplateList getTemplates() throws Exception {

        String urlString = url + "/templates"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        TemplateList templateList = invoiceParser.getTemplates(response);

        return templateList;
    }

    /**
     * Update the pdf template associated with the invoice.
     * <p>
     * Pass the invoiceId and templateId to update the respective template for an invoice.
     * <p>
     * If the template has been updated it returns the success message.
     * <p>
     * The success message is "Invoice information has been updated."
     *
     * @param invoiceId  ID of an Invoice.
     * @param templateId ID of the template associated with an Invoice.
     * @return Returns a String.
     */

    public String updateTemplate(String invoiceId, String templateId) throws Exception {

        String urlString = url + "/" + invoiceId + "/templates/" + templateId; //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;

    }


//=============================================================================================================================================	


    /**
     * Get the list of payments made for an invoice.
     * <p>
     * Pass the invoiceId to get all the payments for an invoice.
     * <p>
     * It returns the PaymentList object.
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns the PaymentList object.
     */

    public PaymentList getPayments(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/payments"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        PaymentList paymentList = invoiceParser.getPayments(response);

        return paymentList;
    }

    /**
     * Get the list of credits applied for an invoice.
     * <p>
     * Pass the invoiceId to get all the credits for an invoice.
     * <p>
     * It returns the CreditList object.
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns the CreditList object.
     */

    public CreditList getCreditsApplied(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/creditsapplied"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CreditList credits = invoiceParser.getCreditsApplied(response);

        return credits;
    }

    /**
     * Apply the customer credits either from credit notes or excess customer payments to an invoice (Multiple credits can be applied at once).
     * <p>
     * Pass the invoiceId, list of InvoicePayment objects, and list of ApplyCreditnote objects to add the credits for an invoice.
     * <p>
     * It returns the Credit object.
     *
     * @param invoiceId        ID of an Invoice.
     * @param invoicePayments  List of InvoicePayment object.
     * @param applyCreditnotes List of ApplyCreditnote object.
     * @return Returns the Credit object.
     */

    public Credit addCredits(String invoiceId, List<InvoicePayment> invoicePayments, List<ApplyCreditnote> applyCreditnotes) throws Exception {

        String urlString = url + "/" + invoiceId + "/credits"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();

        JSONArray ipayments = new JSONArray();
        for (int i = 0; i < invoicePayments.size(); i++) {
            JSONObject invoicePayment = new JSONObject();

            invoicePayment.put("payment_id", invoicePayments.get(i).getPaymentId());
            invoicePayment.put("amount_applied", invoicePayments.get(i).getAmountApplied());

            ipayments.put(invoicePayment);
        }
        jsonObject.put("invoice_payments", ipayments);

        JSONArray creditNotes = new JSONArray();
        for (int j = 0; j < applyCreditnotes.size(); j++) {
            JSONObject creditNote = new JSONObject();

            creditNote.put("creditnote_id", applyCreditnotes.get(j).getCreditnoteId());
            creditNote.put("amount_applied", applyCreditnotes.get(j).getAmountApplied());

            creditNotes.put(creditNote);
        }
        jsonObject.put("apply_creditnotes", creditNotes);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        Credit credit = invoiceParser.getApplyCredits(response);

        return credit;
    }

    /**
     * Delete a payment made to an invoice.
     * <p>
     * Pass the invoiceId and invoicePaymentId to delete a payment made for an invoice.
     * <p>
     * If the payment has been deleted it returns the success message.
     * <p>
     * The success message is "The payment has been deleted."
     *
     * @param invoiceId        ID of an Invoice.
     * @param invoicePaymentId ID of an InvoicePayment.
     * @return Returns a String.
     */

    public String deletePayment(String invoiceId, String invoicePaymentId) throws Exception {

        String urlString = url + "/" + invoiceId + "/payments/" + invoicePaymentId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;

    }

    /**
     * Delete a particular credit applied to an invoice.
     * <p>
     * Pass the invoiceId and creditnotesInvoiceId to delete the credit applied for an invoice.
     * <p>
     * If the credit applied has been deleted it returns the success message.
     * <p>
     * The success message is "Credits applied to an invoice have been deleted."
     *
     * @param invoiceId            ID of an Invoice.
     * @param creditnotesInvoiceId ID of credit notes applied to an Invoice.
     * @return Returns a String.
     */

    public String deleteAppliedCredit(String invoiceId, String creditnotesInvoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/creditsapplied/" + creditnotesInvoiceId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;

    }


//==============================================================================================================================================


    /**
     * Attach a file to an invoice.
     * <p>
     * Pass the invoiceId, File, and query string parameters to add an attachment to an invoice.
     * <p>
     * The paramMap contains the possible key and value as mentioned below: <br><br>
     * <p>
     * can_send_in_mail - True to send the attachment with the invoice when emailed.<br><br>
     * <p>
     * If the file has been attached it returns the success message.
     * <p>
     * The success message is "Your file has been successfully attached to the invoice."
     *
     * @param invoiceId ID of an Invoice.
     * @param file      The file to be attached.
     * @param paramMap  True to send the attachment with the invoice when emailed.
     * @return Returns a String.
     */


    public String addAttachment(String invoiceId, File file, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + invoiceId + "/attachment"; //No I18N

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("attachment", file);


        String response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Returns the file attached to the invoice.
     * <p>
     * Pass the invoiceId and queryMap to get the attached file to the invoice.
     * <p>
     * The queryMap contains the possible key and value as mentioned below: <br><br>
     * <p>
     * preview - Get the thumbnail of the attachment.<br><br>
     * <p>
     * It returns the File object.
     *
     * @param invoiceId ID of an Invoice.
     * @param queryMap  Get the thumbnail of the attachment.
     * @return Returns the File object which is saved in the current working directory.
     */

    public File getAttachment(String invoiceId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + invoiceId + "/attachment"; //No I18N

        File file = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return file;
    }

    /**
     * Set whether you want to send the attached file while emailing the invoice.
     * <p>
     * Pass the invoiceId and query string parameters to update the attachment for an invoice.
     * <p>
     * The paramMap contains the possible key and value as mentioned below: <br><br>
     * <p>
     * can_send_in_mail* - Boolean to send the attachment with the invoice when emailed.<br><br>
     * <p>
     * If the attachment details has been updated it returns the success message.
     * <p>
     * The success message is "Invoice information has been updated."
     *
     * @param invoiceId ID of an Invoice.
     * @param paramMap  Boolean to send the attachment with the invoice when emailed.
     * @return Returns a String.
     */

    public String updateAttachment(String invoiceId, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + invoiceId + "/attachment"; //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap(paramMap));

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Delete the file attached to the invoice.
     * <p>
     * Pass the invoiceId to delete an attachment for an invoice.
     * <p>
     * If the attachment has been deleted it returns the success message.
     * <p>
     * The success message is "Your file is no longer attached to the invoice."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String deleteAttachment(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/attachment"; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }

    /**
     * Delete the expense receipts attached to an invoice which is raised from an expense.
     * <p>
     * Pass the invoiceId to delete the expense receipt for an invoice.
     * <p>
     * If the expense receipt has been deleted it returns the success message.
     * <p>
     * The success message is "The attached expense receipt has been deleted."
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns a String.
     */

    public String deleteExpenseReceipt(String invoiceId) throws Exception {

        String urlString = url + "/expenses/" + invoiceId + "/receipt"; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }


//==============================================================================================================================================


    /**
     * Get the complete history and comments of an invoice.
     * <p>
     * Pass the invoiceId to get all the comments for an invoice.
     * <p>
     * It returns the CommentList object.
     *
     * @param invoiceId ID of an Invoice.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String invoiceId) throws Exception {

        String urlString = url + "/" + invoiceId + "/comments"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CommentList commentList = invoiceParser.getComments(response);

        return commentList;
    }

    /**
     * Add a comment for an invoice.
     * <p>
     * Pass the invoiceId, description, paymentExpectedDate, and showCommentToClients to add the comment for an invoice.
     * <p>
     * It returns the Comment object.
     *
     * @param invoiceId            ID of an Invoice.
     * @param description          Description is the comment of an Invoice.
     * @param paymentExpectedDate  Expected date of payment for the invoice.
     * @param showCommentToClients Boolean to show the comments to contacts in portal.
     * @return Returns the Comment object.
     */

    public Comment addComment(String invoiceId, String description, String paymentExpectedDate, boolean showCommentToClients) throws Exception {

        String urlString = url + "/" + invoiceId + "/comments"; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);
        jsonObject.put("payment_expected_date", paymentExpectedDate);
        jsonObject.put("show_comment_to_clients", showCommentToClients);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        Comment comment = invoiceParser.getComment(response);

        return comment;
    }

    /**
     * Update an existing comment of an invoice.
     * <p>
     * Pass the invoiceId, commentId, description, and showCommentToClients to update a comment for an invoice.
     * <p>
     * It returns the Comment object.
     *
     * @param invoiceId            ID of an Invoice.
     * @param commentId            ID of a Comment.
     * @param description          Description is the comment of an Invoice.
     * @param showCommentToClients Boolean to show the comments to contacts in portal.
     * @return Returns the Comment object.
     */

    public Comment updateComment(String invoiceId, String commentId, String description, boolean showCommentToClients) throws Exception {

        String urlString = url + "/" + invoiceId + "/comments/" + commentId; //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);
        jsonObject.put("show_comment_to_clients", showCommentToClients);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        Comment comment = invoiceParser.getComment(response);

        return comment;
    }

    /**
     * Delete an invoice comment.
     * <p>
     * Pass the invoiceId and commentId to delete the comment for an invoice.
     * <p>
     * If the comment has been deleted it returns the success message.
     * <p>
     * The success message is "The comment has been deleted."
     *
     * @param invoiceId ID of an Invoice.
     * @param commentId ID of a Comment.
     * @return Returns a String.
     */

    public String deleteComment(String invoiceId, String commentId) throws Exception {

        String urlString = url + "/" + invoiceId + "/comments/" + commentId; //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = invoiceParser.getMessage(response);

        return success;
    }


}
