/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.BillParser;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * BillsApi is used to create a Bill for the vendor.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of all the bills.<br>
 * <p>
 * The details of a bill.<br>
 * <p>
 * The list of bill payments.<br>
 * <p>
 * The bill attchment.<br>
 * <p>
 * The list of comments for the bill.<br><br>
 * <p>
 * It is used to:<br><br>
 * <p>
 * Apply credits to a bill.<br>
 * <p>
 * Add an attachment to a bill.<br>
 * <p>
 * Add a comment to a bill.<br><br>
 * <p>
 * It is used to update:<br><br>
 * <p>
 * The details of a bill.<br>
 * <p>
 * The billing address of a bill.<br><br>
 * <p>
 * It is used to change the status:<br><br>
 * <p>
 * Mark a bill status as void.<br>
 * <p>
 * Mark a void bill as open.<br><br>
 * <p>
 * It is used to delete:<br><br>
 * <p>
 * The particular bill.<br>
 * <p>
 * The payment made to a bill.<br>
 * <p>
 * The file attached to a bill.<br>
 * <p>
 * The bill comment.<br>
 */

public class BillsApi extends API {

    private static String url = baseURL + "/bills"; //No I18N

    /**
     * Construct a new BillsApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public BillsApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private BillParser billParser = new BillParser();


    /**
     * Create a bill received from your vendor.
     * <p>
     * Pass the vendorId, billNumber, and accountId to create a new bill for the vendor.
     * <p>
     * It returns the Bill object.
     *
     * @param vendorId   ID of the vendor for whom the bill has to be created.
     * @param billNumber The bill number.
     * @param accountId  ID of the account associated with the line item.
     * @return Returns the Bill object.
     */

    public Bill create(String vendorId, String billNumber, String accountId) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();


        Bill billObj = new Bill();

        billObj.setVendorId(vendorId);
        billObj.setBillNumber(billNumber);

        List<LineItem> lineItems = new ArrayList<LineItem>();

        LineItem lineItem = new LineItem();

        lineItem.setAccountId(accountId);

        lineItems.add(0, lineItem);

        billObj.setLineItems(lineItems);


        requestBody.put("JSONString", billObj.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        Bill bill = billParser.getBill(response);

        return bill;
    }

    /**
     * Create a bill received from your vendor.
     * <p>
     * Pass the Bill object to create a new bill for the vendor.
     * <p>
     * The Bill object which contains vendorId, billNumber, and accountId are the mandatory parameters.
     * <p>
     * It returns the Bill object.
     *
     * @param bill Bill object.
     * @return Returns the Bill object.
     */

    public Bill create(Bill bill) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", bill.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return billParser.getBill(response);

    }

    /**
     * Create a bill received from your vendor.
     * <p>
     * Pass the Bill object and File object to create a new bill with the attachment for the vendor.
     * <p>
     * The Bill object which contains vendorId, billNumber, and accountId are the mandatory parameters.
     * <p>
     * It returns the Bill object.
     *
     * @param bill Bill object.
     * @param file File to attach.
     * @return Returns the Bill object.
     */

    public Bill create(Bill bill, File file) throws Exception {

        HashMap<String, Object> requestBody = new HashMap<String, Object>();

        requestBody.put("JSONString", bill.toJSON().toString());

        HashMap<String, Object> fileBody = new HashMap<String, Object>();
        fileBody.put("attachment", file);

        String response = ZohoHTTPClient.post(url, getQueryMap(), requestBody, fileBody);

        return billParser.getBill(response);

    }

    /**
     * Get the details of a bill.
     * <p>
     * Pass the billId to get the details of a bill.
     * <p>
     * It returns the Bill object.
     *
     * @param billId ID of the bill.
     * @return Returns the Bill object.
     */

    public Bill get(String billId) throws Exception {

        String urlString = url + "/" + billId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Bill bill = billParser.getBill(response);

        return bill;
    }

    /**
     * Update a bill, and delete a line item by removing it from the line_items list.
     * <p>
     * Pass the Bill object to update the details of a bill.
     * <p>
     * The Bill object which contains billId is the mandatory parameter for which bill details has to be updated.
     * <p>
     * It returns the Bill object.
     *
     * @param bill Bill object.
     * @return Returns the Bill object.
     */

    public Bill update(Bill bill) throws Exception {

        String urlString = url + "/" + bill.getBillId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", bill.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return billParser.getBill(response);
    }

    /**
     * Update a bill, and delete a line item by removing it from the line_items list.
     * <p>
     * Pass the Bill object and File object to update the details and attachement of a bill.
     * <p>
     * The Bill object which contains billId is the mandatory parameter for which bill details has to be updated.
     * <p>
     * It returns the Bill object.
     *
     * @param bill Bill object.
     * @param file File is an attachment(It can either be a replacement or new attachment).
     * @return Returns the Bill object.
     */

    public Bill update(Bill bill, File file) throws Exception {

        String urlString = url + "/" + bill.getBillId();

        HashMap<String, Object> requestBody = new HashMap<String, Object>();

        requestBody.put("JSONString", bill.toJSON().toString());

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("attachment", file);

        String response = ZohoHTTPClient.put(urlString, getQueryMap(), requestBody, fileBody);

        return billParser.getBill(response);
    }

    /**
     * Delete an existing bill. (Bills which have payments applied cannot be deleted.)
     * <p>
     * Pass the billId to delete the bill.
     * <p>
     * If the bill has been deleted it returns the success message.
     * <p>
     * The success message is "The bill has been deleted."
     *
     * @param billId ID of the bill.
     * @return Returns a String.
     */

    public String delete(String billId) throws Exception {

        String urlString = url + "/" + billId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = billParser.getMessage(response);

        return success;
    }

    /**
     * List all bills with pagination.
     * <p>
     * Pass the filters to get all the bills based on the filters.
     * <p>
     * It returns the BillList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>bill_number</td><td>Search bills by bill number.<br>
     * Variants: <i>bill_number_startswith</i> and <i>bill_number_contains</i></td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Search bills by reference number.<br>
     * Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Search bills by bill date.<br>
     * Variants: <i>date_start, date_end, date_before</i> and <i>date.after</i></td></tr>
     * <p>
     * <tr><td>description</td><td>Search bills by description.<br>
     * Variants: <i>description_startswith</i> and <i>description_contains</i></td></tr>
     * <p>
     * <tr><td>vendor_name</td><td>Search bills by vendor name.<br>
     * Variants: <i>vendor_name_startswith</i> and <i>vendor_name_contains</i></td></tr>
     * <p>
     * <tr><td>total</td><td>Search bills by bill total.<br>
     * Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>
     * <p>
     * <tr><td>vendor_id</td><td>Search bills by vendor id.</td></tr>
     * <p>
     * <tr><td>item_id</td><td>Search bills by bill item id.</td></tr>
     * <p>
     * <tr><td>search_text</td><td>Search bills by bill number or reference number or vendor name.</td></tr>
     * <p>
     * <tr><td>status</td><td>Search bills by bill status.<br>
     * Allowed Values: <i>paid, open, overdue, void</i> and <i>partially_paid</i></td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter bills by any status.<br>
     * Allowed Values: <i>Status.All, Status.PartiallyPaid, Status.Paid, Status.Overdue, Status.Void</i> and <i>Status.Open</i></td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort bills.<br>
     * Allowed Values: <i>vendor_name, bill_number, date, due_date, total, balance</i> and <i>created_time</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the BillList object.
     */

    public BillList getBills(HashMap<String, Object> queryMap) throws Exception {


        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        BillList billList = billParser.getBills(response);

        return billList;
    }

    /**
     * Mark a bill status as void.
     * <p>
     * Pass the billId to change the status of a bill to 'void'.
     * <p>
     * If the status of the bill has been changed it returns the success message.
     * <p>
     * The success message is "The bill has been marked as void."
     *
     * @param billId ID of the bill.
     * @return Returns a String.
     */

    public String voidABill(String billId) throws Exception {

        String urlString = url + "/" + billId + "/status/void";  //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = billParser.getMessage(response);

        return success;
    }

    /**
     * Mark a void bill as open.
     * <p>
     * Pass the billId to change the status of a bill to 'open'.
     * <p>
     * If the status of the bill has been changed it returns the success message.
     * <p>
     * The success message is "The status of the bill has been changed from void to open."
     *
     * @param billId ID of the bill.
     * @return Returns a String.
     */

    public String markABillAsOpen(String billId) throws Exception {

        String urlString = url + "/" + billId + "/status/open";  //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = billParser.getMessage(response);

        return success;
    }

    /**
     * Update the billing address for this bill.
     * <p>
     * Pass the billId and Address object to update the billing address of a bill.
     * <p>
     * If the billing address has been updated it returns the success message.
     * <p>
     * The success message is "Billing address updated."
     *
     * @param billId         ID of the bill.
     * @param billingAddress Address object.
     * @return Returns a String.
     */

    public String updateBillingAddress(String billId, Address billingAddress) throws Exception {

        String urlString = url + "/" + billId + "/address/billing";  //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", billingAddress.toJSON().put("is_update_customer", billingAddress.isUpdateCustomer()).toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        String success = billParser.getMessage(response);

        return success;
    }


//==========================================================================================================================================


    /**
     * Get the list of payments made for a bill.
     * <p>
     * Pass the billId to get all the payments for the bill.
     * <p>
     * It returns the PaymentList object.
     *
     * @param billId ID of the bill.
     * @return Returns list of Payment object.
     */

    public PaymentList getPayments(String billId) throws Exception {

        String urlString = url + "/" + billId + "/payments";  //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        PaymentList payments = billParser.getPayments(response);

        return payments;
    }

    /**
     * Apply vendor credits from excess vendor payments to a bill. (Multiple credits can be applied at once.)
     * <p>
     * Pass the billId and list of Payment object to apply the credits for the bill.
     * <p>
     * The Payment object which contains amountApplied is the mandatory parameter.
     * <p>
     * If the credits has been applied to the bill it returns the success message.
     * <p>
     * The success message is "Credits have been applied to the bill(s)."
     *
     * @param billId  ID of the bill.
     * @param payment List of Payment object.
     * @return Returns a String.
     */

    public String applyCredits(String billId, List<Payment> payment) throws Exception {

        String urlString = url + "/" + billId + "/credits";  //No I18N

        HashMap<String, Object> requestBody = getQueryMap();


        JSONObject jsonObject = new JSONObject();

        JSONArray billPayments = new JSONArray();

        for (int i = 0; i < payment.size(); i++) {
            JSONObject billPayment = new JSONObject();

            billPayment.put("payment_id", payment.get(i).getPaymentId());
            billPayment.put("amount_applied", payment.get(i).getAmountApplied());

            billPayments.put(billPayment);
        }
        jsonObject.put("bill_payments", billPayments);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        String success = billParser.getMessage(response);

        return success;
    }

    /**
     * Delete a payment made to a bill.
     * <p>
     * Pass the billId and billPaymentId to delete the bill payment.
     * <p>
     * If the bill payment has been deleted it returns the success message.
     * <p>
     * The success message is "The payment has been deleted."
     *
     * @param billId        ID of the bill.
     * @param billPaymentId ID of the bill payment.
     * @return Returns a String.
     */

    public String deletePayment(String billId, String billPaymentId) throws Exception {

        String urlString = url + "/" + billId + "/payments/" + billPaymentId;  //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = billParser.getMessage(response);

        return success;
    }


//==========================================================================================================================================


    /**
     * Return the file attached to the bill.
     * <p>
     * Pass the billId to get the attachment of the bill.
     * <p>
     * It returns the File object.
     *
     * @param billId ID of the bill.
     * @return Returns the File that is stored in a current directory.
     */

    public File getAttachment(String billId) throws Exception {

        String urlString = url + "/" + billId + "/attachment";  //No I18N

        File file = ZohoHTTPClient.getFile(urlString, getQueryMap());

        return file;
    }

    /**
     * Attach a file to a bill.
     * <p>
     * Pass the billId and File object to add the attachment of the bill.
     * <p>
     * If the file has been attached to the bill it returns the success message.
     * <p>
     * The success message is "The document has been attached."
     *
     * @param billId ID of the bill.
     * @param file   File to attach.
     * @return Returns a String.
     */

    public String addAttachment(String billId, File file) throws Exception {

        String urlString = url + "/" + billId + "/attachment";  //No I18N

        HashMap<String, Object> fileBody = new HashMap<String, Object>();

        fileBody.put("attachment", file);


        String response = ZohoHTTPClient.post(urlString, getQueryMap(), null, fileBody);

        String success = billParser.getMessage(response);

        return success;
    }

    /**
     * Delete the file attached to a bill.
     * <p>
     * Pass the billId to delete the attachment of the bill.
     * <p>
     * If the attachment has been deleted it returns the success message.
     * <p>
     * The success message is "The attachment has been deleted."
     *
     * @param billId ID of the bill.
     * @return Returns a String.
     */

    public String deleteAttachment(String billId) throws Exception {


        String urlString = url + "/" + billId + "/attachment";  //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = billParser.getMessage(response);

        return success;
    }


//=============================================================================================================================================


    /**
     * Get the complete history and comments of a bill.
     * <p>
     * Pass the billId to get all the comments for the bill.
     * <p>
     * It returns the BillList object.
     *
     * @param billId ID of the bill.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String billId) throws Exception {

        String urlString = url + "/" + billId + "/comments";  //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        CommentList commentList = billParser.getComments(response);

        return commentList;
    }

    /**
     * Add a comment for a bill.
     * <p>
     * Pass the billId and description to add the comment for the bill.
     * <p>
     * It returns the Comment object.
     *
     * @param billId      ID of the bill.
     * @param description Description is the comment of the bill.
     * @return Returns the Comment object.
     */

    public Comment addComment(String billId, String description) throws Exception {

        String urlString = url + "/" + billId + "/comments";  //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("description", description);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        Comment comment = billParser.getComment(response);

        return comment;
    }

    /**
     * Delete a bill comment.
     * <p>
     * Pass the billId and commentId to delete the comment for the bill.
     * <p>
     * If the comment has been deleted it retuens the success message.
     * <p>
     * The success message is "The comment has been deleted."
     *
     * @param billId    ID of the bill.
     * @param commentId ID of the comment.
     * @return Returns a String.
     */

    public String deleteComment(String billId, String commentId) throws Exception {

        String urlString = url + "/" + billId + "/comments" + commentId;  //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = billParser.getMessage(response);

        return success;
    }


}
