/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.PurchaseOrderParser;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * PurchaseorderApi is used to:
 * <p>
 * Get the list of purchase orders.
 * <p>
 * Get the details of a purchase order.
 * <p>
 * Get the email content.
 * <p>
 * Get the list of templates.
 * <p>
 * Get the attachment.
 * <p>
 * Get the list of comments.
 * <p>
 * <p>
 * Create a new purchase order.
 * <p>
 * Change the status of the purchase order into open.
 * <p>
 * Change the status of the purchase order into billed.
 * <p>
 * Change the status of the purchase order into cancelled.
 * <p>
 * Send email to the vendor.
 * <p>
 * Add a new attachment.
 * <p>
 * Add a new comment.
 * <p>
 * <p>
 * Update the details of a purchase order.
 * <p>
 * Update the billing address.
 * <p>
 * Update the template.
 * <p>
 * Update the details of an attachment.
 * <p>
 * Update the details of a comment.
 * <p>
 * <p>
 * Delete an existing purchase order.
 * <p>
 * Delete an existing attachment.
 * <p>
 * Delete an existing comment.
 *
 * @author ramesh-2099
 */

public class PurchaseOrderApi extends API {

    private String url = baseURL + "/purchaseorders";        //No I18N


    /**
     * Construct a new PurchaseOrderApi using user's authToken and organizationId.
     *
     * @param authToken      User's authToken.
     * @param organizationId User's organizationId
     */

    public PurchaseOrderApi(String authToken, String organizationId) {
        super(authToken, organizationId);
    }

    // PurchaseOrderParser is used to parse the JSON response and make it into the respective objects.

    private PurchaseOrderParser purchaseOrderParser = new PurchaseOrderParser();


    /**
     * List all purchase orders.
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the PurchaseOrderList object.
     * @throws Exception
     */

    public PurchaseOrderList getPurchaseOrders(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        return purchaseOrderParser.getPurchaseOrders(response);
    }

    /**
     * Get the details of a purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @return Returns the PuchaseOrder object.
     * @throws Exception
     */

    public PurchaseOrder get(String purchaseorderId) throws Exception {

        String urlString = url + "/" + purchaseorderId;    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return purchaseOrderParser.getPurchaseOrder(response);

    }

    /**
     * Create a purchase order for your vendor.
     *
     * @param paramMap      It contains the query string parameters in the form of key-value pair.
     * @param purchaseOrder PurchaseOrder object.
     * @param file          Attachment file for the purchase order.
     * @return Returns the PurchaseOrder object.
     * @throws Exception
     */

    public PurchaseOrder create(HashMap<String, Object> paramMap, PurchaseOrder purchaseOrder, File file) throws Exception {


        String response = "";

        if (file != null && file.exists()) {
            HashMap<String, Object> requestBody = new HashMap<String, Object>();

            requestBody.put("JSONString", purchaseOrder.toJSON().toString());

            HashMap<String, Object> fileBody = new HashMap<String, Object>();

            fileBody.put("attachment", file);

            response = ZohoHTTPClient.post(url, getQueryMap(paramMap), requestBody, fileBody);
        }

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", purchaseOrder.toJSON().toString());

        response = ZohoHTTPClient.post(url, requestBody);

        return purchaseOrderParser.getPurchaseOrder(response);

    }

    /**
     * Update an existing purchase order.
     *
     * @param paramMap      It contains the query string parameters in the form of key-value pair.
     * @param purchaseOrder PurchaseOrder object.
     * @param file          Attachment file for the purchase order.
     * @return Returns the PurchaseOrder object.
     * @throws Exception
     */

    public PurchaseOrder update(HashMap<String, Object> paramMap, PurchaseOrder purchaseOrder, File file) throws Exception {

        String urlString = url + "/" + purchaseOrder.getPurchaseorderId();    //No I18N

        String response = "";

        if (file != null && file.exists()) {
            HashMap<String, Object> requestBody = new HashMap<String, Object>();

            requestBody.put("JSONString", purchaseOrder.toJSON().toString());

            HashMap<String, Object> fileBody = new HashMap<String, Object>();

            fileBody.put("attachment", file);

            response = ZohoHTTPClient.put(urlString, getQueryMap(paramMap), requestBody, fileBody);
        }

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", purchaseOrder.toJSON().toString());

        response = ZohoHTTPClient.put(urlString, requestBody);

        return purchaseOrderParser.getPurchaseOrder(response);

    }

    /**
     * Delete an existing purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String delete(String purchaseorderId) throws Exception {

        String urlString = url + "/" + purchaseorderId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);
    }

    /**
     * Mark a draft purchase order as open.
     *
     * @param purchaseorderId ID of the purchase order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String markAsOpen(String purchaseorderId) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/status/open";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);

    }

    /**
     * Mark a purchase order as billed.
     *
     * @param puchaseorderId ID of the purchase order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String markAsBilled(String puchaseorderId) throws Exception {

        String urlString = url + "/" + puchaseorderId + "/status/billed";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);

    }

    /**
     * Mark a purchase order as cancelled.
     *
     * @param purchaseorderId ID of the purchase order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String cancelAPurchaseorder(String purchaseorderId) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/status/cancelled";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);

    }

    /**
     * Email a purchase order to the vendor. Input json string is not mandatory.
     * If input json string is empty, mail will be send with default mail content.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param paramMap        It contains the query string parameters in the form of key-value pair.
     * @param email           Email object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String sendEmail(String purchaseorderId, HashMap<String, Object> paramMap, Email email) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/email";    //No I18N
        String response = "";
        if (paramMap == null) {

            paramMap = new HashMap<String, Object>();
        }

        HashMap<String, Object> fileBody = null;
        if (email != null) {
            paramMap.put("JSONString", email.toJSON().toString());

            ArrayList<File> attachments = email.getAttachments();

            if (attachments != null && attachments.size() > 0) {
                fileBody = new HashMap<String, Object>();

                fileBody.put("attachments", attachments);
            }
        }

        response = ZohoHTTPClient.post(urlString, getQueryMap(), paramMap, fileBody);

        return purchaseOrderParser.getMessage(response);
    }

    /**
     * Get the email content of a purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param queryMap        It contains the query string parameters in the form of key-value pair.
     * @return Returns the Email object.
     * @throws Exception
     */

    public Email getEmailContent(String purchaseorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/email";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        return purchaseOrderParser.getEmailContent(response);
    }

    /**
     * Updates the billing address for this purchase order alone.
     * You can set this address as default billing address for your vendor by specifying 'is_update_customer' param as true.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param address         Address object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateBillingAddress(String purchaseorderId, Address address) throws Exception {
        String urlString = url + "/" + purchaseorderId + "/address/billing";    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", address.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return purchaseOrderParser.getMessage(response);

    }

    /**
     * Get all purchase order pdf templates.
     *
     * @return Returns the TemplateList object.
     * @throws Exception
     */

    public TemplateList getTemplates() throws Exception {

        String urlString = url + "/templates";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return purchaseOrderParser.getTemplates(response);

    }

    /**
     * Update the pdf template associated with the purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param templateId      ID of the template.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateTemplate(String purchaseorderId, String templateId) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/templates/" + templateId;    //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);

    }

    //==============================================================================================================//


    /**
     * Returns the file attached to the purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param queryMap        It contains the query string parameters in the form of key-value pair.
     * @return Returns the File, which is stored in the current working directory.
     * @throws Exception
     */

    public File getAttachment(String purchaseorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/attachment";    //No I18N

        File attachment = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return attachment;

    }

    /**
     * Attach a file to a purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param file            Attachment file for the purchase order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String addAttachment(String purchaseorderId, File file) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/attachment";    //No I18N

        HashMap<String, Object> fileBody = new HashMap<String, Object>();
        fileBody.put("attachment", file);

        String response = ZohoHTTPClient.post(urlString, getQueryMap(), null, fileBody);

        return purchaseOrderParser.getMessage(response);

    }

    /**
     * Set whether you want to send the attached file while emailing the purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param queryMap        It contains the query string parameters in the form of key-value pair.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateAttachment(String purchaseorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/attachment";    //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap(queryMap));

        return purchaseOrderParser.getMessage(response);

    }

    /**
     * Delete the file attached to the purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deleteAttachment(String purchaseorderId) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/attachment";    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);

    }


    //========================================================================================================


    /**
     * Get the complete history and comments of purchase order.
     *
     * @param purchaseorderId ID of the purchase order.
     * @return Returns the CommentList object.
     * @throws Exception
     */

    public CommentList getComments(String purchaseorderId) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/comments";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return purchaseOrderParser.getComments(response);

    }

    /**
     * Add a comment for a purchase order.
     *
     * @param purchaseorderId      ID of the purchase order.
     * @param description          Description for the comment.
     * @param expectedDeliveryDate Date the goods is expected to arrive.
     * @return Returns the Comment object.
     * @throws Exception
     */

    public Comment addComment(String purchaseorderId, String description, String expectedDeliveryDate) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/comments";    //No I18N

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);
        jsonObject.put("expected_delivery_date", expectedDeliveryDate);

        HashMap<String, Object> requestBody = getQueryMap();
        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return purchaseOrderParser.getComment(response);

    }

    /**
     * Update an existing comment of a purchase order.
     *
     * @param purchaseorderId      ID of the purchase order.
     * @param commentId            ID of the comment.
     * @param description          Description for the comment.
     * @param expectedDeliveryDate Date the goods is expected to arrive.
     * @return Returns the success message.
     * @throws Exception
     */

    public Comment updateComment(String purchaseorderId, String commentId, String description, String expectedDeliveryDate) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/comments/" + commentId;    //No I18N

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);
        jsonObject.put("expected_delivery_date", expectedDeliveryDate);

        HashMap<String, Object> requestBody = getQueryMap();
        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return purchaseOrderParser.getComment(response);
    }

    /**
     * Delete a purchase order comment.
     *
     * @param purchaseorderId ID of the purchase order.
     * @param commentId       ID of the comment.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deleteComment(String purchaseorderId, String commentId) throws Exception {

        String urlString = url + "/" + purchaseorderId + "/comments/" + commentId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return purchaseOrderParser.getMessage(response);
    }


}
