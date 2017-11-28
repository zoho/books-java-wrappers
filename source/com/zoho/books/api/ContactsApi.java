/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.ContactParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * ContactsApi is used to create a new contact for the organization.
 * <p>
 * It is used to get and update the details of a particular contact.
 * <p>
 * It is used to get the list of contacts from the organization.
 * <p>
 * It is used to change the status:<br><br>
 * <p>
 * Mark a contact as active.<br>
 * <p>
 * Mark a contact as inactive.<br>
 * <p>
 * Enable automated payment reminders for a contact.<br>
 * <p>
 * Disable automated payment reminders for a contact.<br>
 * <p>
 * Activate the track1099.<br>
 * <p>
 * Deactivate the track1099.<br><br>
 * <p>
 * It is used to send:<br><br>
 * <p>
 * Email to the contact.<br>
 * <p>
 * Statement to the contact.<br><br>
 * <p>
 * It is used to get:<br><br>
 * <p>
 * Email statement of a contact.<br>
 * <p>
 * List of comments of a contact.<br>
 * <p>
 * List of refund history of a contact.<br><br>
 * <p>
 * It is used to delete a contact.
 */


public class ContactsApi extends API {

    private static String url = baseURL + "/contacts"; //No I18N

    /**
     * Construct a new ContactsApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public ContactsApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private ContactParser contactParser = new ContactParser();


    /**
     * Create a contact with given information.
     * <p>
     * Pass the contactName and currencyId to create a new contact with default values.
     * <p>
     * It returns the Contact object.
     *
     * @param contactName Name of the contact.
     * @param currencyId  ID of the currency.
     * @return Returns a Contact object.
     */

    public Contact create(String contactName, String currencyId) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        Contact contact = new Contact();

        contact.setContactName(contactName);
        contact.setCurrencyId(currencyId);

        requestBody.put("JSONString", contact.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return contactParser.getContact(response);
    }

    /**
     * Create a contact with given information.
     * <p>
     * Pass the Contact object to create a new contact.
     * <p>
     * The Contact object which contains contactName and currencyId are mandatory parameters.
     * <p>
     * It returns the Contact object.
     *
     * @param contact Contact object.
     * @return Returns a Contact object.
     */

    public Contact create(Contact contact) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", contact.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return contactParser.getContact(response);

    }

    /**
     * Get details of a contact.
     * <p>
     * Pass the contactId to get the details of a particular contact.
     * <p>
     * It returns the Contact object.
     *
     * @param contactId Id of the contact.
     * @return Returns a Contact object.
     */

    public Contact get(String contactId) throws Exception {

        String urlString = url + "/" + contactId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Contact contact = contactParser.getContact(response);

        return contact;
    }

    /**
     * Update an existing contact (To delete a contact person remove it from the contact persons list).
     * <p>
     * Pass the Contact object to update the details of a particular contact.
     * <p>
     * The Contact object must contain the contactId for which contact has to be updated.
     * <p>
     * It returns the Contact object.
     *
     * @param contact Contact object.
     * @return Returns a Contact object.
     */

    public Contact update(Contact contact) throws Exception {

        String urlString = url + "/" + contact.getContactId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", contact.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return contactParser.getContact(response);
    }

    /**
     * Delete an existing contact.
     * <p>
     * Pass the contactId to delete the particular contact.
     * <p>
     * If the contact has been deleted it returns the success message.
     * <p>
     * The success message is "The contact has been deleted."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */

    public String delete(String contactId) throws Exception {

        String urlString = url + "/" + contactId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * List all contacts with pagination.
     * <p>
     * Pass the filters in the form of key-value pair to get all the contacts based on the filter.
     * <p>
     * It returns the ContactList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below: <br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>contact_name</td><td>Search contacts by contact name.<br>
     * Variants: <i>contact_name_startswith</i> and <i>contact_name_contains</i></td></tr>
     * <p>
     * <tr><td>first_name</td><td>Search contacts by first name of the contact person.<br>
     * Variants: <i>first_name_startswith</i> and <i>first_name_contains</i></td></tr>
     * <p>
     * <tr><td>last_name</td><td>Search contacts by last name of the contact person.<br>
     * Variants: <i>last_name_startswith</i> and <i>last_name_contains</i></td></tr>
     * <p>
     * <tr><td>address</td><td>Search contacts by any of the address fields.<br>
     * Variants: <i>address_startswith</i> and <i>address_contains</i></td></tr>
     * <p>
     * <tr><td>email</td><td>Search contacts by email of the contact person.<br>
     * Variants: <i>email_startswith</i> and <i>email_contains</i></td></tr>
     * <p>
     * <tr><td>phone</td><td>Search contacts by phone number of the contact person.<br>
     * Variants: <i>phone_startswith</i> and <i>phone_contains</i></td></tr>
     * <p>
     * <tr><td>search_text</td><td>contact name or notes. </td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter contacts by status.<br>
     * Allowed Values: <i>Status.All, Status.Active, Status.Inactive, Status.Duplicate, Status.Customers, Status.Vendors</i> and <i>Status.Crm</i> </td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort contacts.<br>
     * Allowed Values: <i>contact_name, first_name, last_name, email, outstanding_receivable_amount, outstanding_payable_amount, created_time</i> and <i>last_modified_time</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the ContactList object.
     */

    public ContactList getContacts(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        ContactList contactList = contactParser.getContacts(response);

        return contactList;
    }

    /**
     * Mark a contact as active.
     * <p>
     * Pass the contactId to change the status of a contact to 'active'.
     * <p>
     * If the contact status has been changed it returns the success message.
     * <p>
     * The success message is "The contact has been marked as active."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */

    public String markAsActive(String contactId) throws Exception {

        String urlString = url + "/" + contactId + "/active"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * Mark a contact as inactive.
     * <p>
     * Pass the contactId to change the status of a contact to 'inactive'.
     * <p>
     * If the contact status has been changed it returns the success message.
     * <p>
     * The success message is "The contact has been marked as inactive."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */

    public String markAsInactive(String contactId) throws Exception {

        String urlString = url + "/" + contactId + "/inactive"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * Enable automated payment reminders for a contact.
     * <p>
     * Pass the contactId to enable a contact's payment reminders.
     * <p>
     * If the payment reminders for a contact has been enabled it returns the success message.
     * <p>
     * The success message is "All reminders associated with this contact have been enabled."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */

    public String enablePaymentReminder(String contactId) throws Exception {

        String urlString = url + "/" + contactId + "/paymentreminder/enable"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * Disable automated payment reminders for a contact.
     * <p>
     * Pass the contactId to disable a contact's payment reminders.
     * <p>
     * If the payment reminders for a contact has been disabled it returns the success message.
     * <p>
     * The success message is "All reminders associated with this contact have been stopped."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */

    public String disablePaymentReminder(String contactId) throws Exception {

        String urlString = url + "/" + contactId + "/paymentreminder/disable"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * Email statement to the contact (If the Email object is not given, email will be sent with the default email content).
     * <p>
     * Pass the contactId and Email object to send the email statement to the contact.
     * <p>
     * In addition pass the array of attachments and also the parameters attached to the email.<br>
     * <p>
     * The parameter contains the possible keys as mentioned below: <br><br>
     * <p>
     * start_date - start date for the statement. <br>
     * <p>
     * end_date - End date for the statement. <br> <br>
     * <p>
     * If the email has been sent to the contact it returns the success message.
     * <p>
     * The success message is "Statement has been sent to the customer."
     *
     * @param contactId ID of the contact.
     * @param email     Email object.
     * @param paramMap  It contains the query string in the form of key-value pair.
     * @return Returns a String.
     */

    public String sendEmailStatement(String contactId, Email email, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + contactId + "/statements/email"; //No I18N

        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        paramMap.put("JSONString", email.toJSON().toString());

        ArrayList<File> files = email.getAttachments();

        HashMap<String, Object> fileBody = new HashMap<String, Object>();
        if (files != null && !files.isEmpty()) {
            fileBody.put("attachments", files);
        }

        String response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * Get the email statement content.
     * <p>
     * Pass the contactId to get the email statement content for the contact.
     * <p>
     * Pass the filters in the form of key-value pair to get the statement email content based on the filter.
     * <p>
     * The queryMap contains the possible keys as mentioned below: <br><br>
     * <p>
     * start_date - Start date for statement. <br>
     * <p>
     * end_date - End date for statement. <br>
     * <p>
     * The above mentioned filters are the mandatory paramters. <br><br>
     * <p>
     * It returns the Email object.
     *
     * @param contactId ID of the contact.
     * @param queryMap  It contains the query string in the form of key-value pair.
     * @return Returns the Email object.
     */

    public Email getStatementMailContent(String contactId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + contactId + "/statements/email"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        Email email = contactParser.getEmailContent(response);

        return email;
    }

    /**
     * Send email to contact.
     * <p>
     * Pass the contactId and Email object to send the email to the contact.
     * <p>
     * In addition pass the array of attachments and the parameters attached with the email.<br>
     * <p>
     * The paramMap contains the possible key as mentioned below: <br><br>
     * <p>
     * send_customer_statement - Send customer statement pdf with email. <br><br>
     * <p>
     * If the email has been sent it returns the success message.
     * <p>
     * The success message is "Email has been sent."
     *
     * @param contactId ID of the contact.
     * @param email     Email object.
     * @param paramMap  It contains the query string in the form of key-value pair.
     * @return Returns a String.
     */

    public String sendEmailContact(String contactId, Email email, HashMap<String, Object> paramMap) throws Exception {

        String urlString = url + "/" + contactId + "/email"; //No I18N

        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        paramMap.put("JSONString", email.toJSON().toString());

        ArrayList<File> files = email.getAttachments();

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        if (files != null && !files.isEmpty()) {
            fileBody.put("attachments", files);
        }

        String response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * List the refund history of a contact.
     * <p>
     * Pass the contactId to get the list of refund objects for the contact.
     * <p>
     * It returns the CreditnoteRefundList object.
     *
     * @param contactId ID of the contact.
     * @return Returns a CreditnoteRefundList Object.
     */

    public CreditnoteRefundList getRefunds(String contactId) throws Exception {

        String urlString = url + "/" + contactId + "/refunds"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CreditnoteRefundList creditnoteRefundList = contactParser.getRefunds(response);

        return creditnoteRefundList;
    }

    /**
     * List recent activities of a contact.
     * <p>
     * Pass the contactId to get the list of comments for the contact.
     * <p>
     * It returns the CommentList object.
     *
     * @param contactId ID of the contact.
     * @return Returns a CommentList object.
     */

    public CommentList getComments(String contactId) throws Exception {

        String urlString = url + "/" + contactId + "/comments"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CommentList commentList = contactParser.getComments(response);

        return commentList;
    }

    /**
     * Track a contact for 1099 reporting. (Note: This API is only available when the organization's country is U.S.A)
     * <p>
     * Pass the contactId to activate the track1099 for the contact.
     * <p>
     * It returns the success message.
     * <p>
     * The success message is "1099 tracking is enabled."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */


    public String track1099(String contactId) throws Exception {
        String urlString = url + "/" + contactId + "/track1099";  //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

    /**
     * Use this API to stop tracking payments to a vendor for 1099 reporting. (Note: This API is only available when the organization's country is U.S.A)
     * <p>
     * Pass the contactId to deactivate the track1099 for the contact.
     * <p>
     * It returns the success message.
     * <p>
     * The success message is "1099 tracking is disabled."
     *
     * @param contactId ID of the contact.
     * @return Returns a String.
     */

    public String untrack1099(String contactId) throws Exception {
        String urlString = url + "/" + contactId + "/untrack1099"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = contactParser.getMessage(response);

        return success;
    }

}

