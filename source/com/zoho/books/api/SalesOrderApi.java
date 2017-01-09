/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.SalesOrderParser;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * SalesOrderApi is used to:<br><br>
 * <p>
 * Get list of sales orders.<br>
 * <p>
 * Get the details of a sales order.<br>
 * <p>
 * Bulk export of sales orders.<br>
 * <p>
 * Bulk print of sales orders.<br>
 * <p>
 * Get list of templates.<br>
 * <p>
 * Get an attachment of the sales order.<br>
 * <p>
 * Get list of comments.<br><br>
 * <p>
 * <p>
 * Create a new sales order.<br>
 * <p>
 * Mark a sales order as open.<br>
 * <p>
 * Mark a sales order as void.<br>
 * <p>
 * Send email for the sales order.<br>
 * <p>
 * Add an attachment for the sales order.<br>
 * <p>
 * Add a comment for the sales order.<br><br>
 * <p>
 * <p>
 * Update the details of a sales order.<br>
 * <p>
 * Update the template.<br>
 * <p>
 * Update an attachment details.<br>
 * <p>
 * Update a comment.<br><br>
 * <p>
 * <p>
 * Delete an existing sales order.<br>
 * <p>
 * Delete an existing attachment.<br>
 * <p>
 * Delete an existing comment.<br><br>
 *
 * @author ramesh-2099
 */

public class SalesOrderApi extends API {


    private String url = baseURL + "/salesorders";    //No I18N


    /**
     * Construct a new SalesOrderApi using user's authToken and organizationId.
     *
     * @param authToken      User's authToken.
     * @param organizationId User's organizationId.
     */

    public SalesOrderApi(String authToken, String organizationId) {
        super(authToken, organizationId);
    }


    // SalesOrderParser is used to parse the JSON response into respective objects.

    private SalesOrderParser salesOrderParser = new SalesOrderParser();


    /**
     * Get list of sales orders.
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the SalesOrderList object.
     * @throws Exception
     */

    public SalesOrderList getSalesOrders(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        return salesOrderParser.getSalesOrders(response);

    }

    /**
     * Get the details of a sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param queryMap     It contains the query string parameters in the form of key-value pair.
     * @return Returns the SalesOrder object.
     * @throws Exception
     */

    public SalesOrder get(String salesorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + salesorderId;    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        return salesOrderParser.getSalesOrder(response);

    }

    /**
     * Create a sales order for your customer.
     *
     * @param queryMap   It contains the query string parameters in the form of key-value pair.
     * @param salesOrder SalesOrder object.
     * @return Returns the SalesOrder object.
     * @throws Exception
     */

    public SalesOrder create(HashMap<String, Object> queryMap, SalesOrder salesOrder) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap(queryMap);

        requestBody.put("JSONString", salesOrder.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return salesOrderParser.getSalesOrder(response);

    }

    /**
     * Update an existing sales order. To delete a line item just remove it from the line_items list.
     *
     * @param queryMap   It contains the query string parameters in the form of key-value pair.
     * @param salesOrder SalesOrder object.
     * @return Returns the SalesOrder object.
     * @throws Exception
     */

    public SalesOrder update(HashMap<String, Object> queryMap, SalesOrder salesOrder) throws Exception {

        String urlString = url + "/" + salesOrder.getSalesorderId();    //No I18N

        HashMap<String, Object> requestBody = getQueryMap(queryMap);

        requestBody.put("JSONString", salesOrder.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return salesOrderParser.getSalesOrder(response);

    }

    /**
     * Delete an existing sales order. Invoiced sales order cannot be deleted.
     *
     * @param salesorderId ID of the sales order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String delete(String salesorderId) throws Exception {

        String urlString = url + "/" + salesorderId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return salesOrderParser.getMessage(response);

    }

    /**
     * Mark a draft sales order as open.
     *
     * @param salesorderId ID of the sales order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String markAsOpen(String salesorderId) throws Exception {

        String urlString = url + "/" + salesorderId + "/status/open";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return salesOrderParser.getMessage(response);

    }

    /**
     * Mark a sales order as void.
     *
     * @param salesorderId ID of the sales order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String markAsVoid(String salesorderId) throws Exception {

        String urlString = url + "/" + salesorderId + "/status/void";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return salesOrderParser.getMessage(response);

    }

    /**
     * Email a sales order to the customer. Input json string is not mandatory. If input json string is empty,
     * mail will be send with default mail content.
     *
     * @param salesorderId ID of the sales order.
     * @param paramMap     It contains the query string parameters in the form of key-value pair.
     * @param email        Email object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String sendEmail(String salesorderId, HashMap<String, Object> paramMap, Email email) throws Exception {

        String urlString = url + "/" + salesorderId + "/email";    //No I18N

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

        return salesOrderParser.getMessage(response);
    }

    /**
     * Get the email content of a sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param queryMap     It contains the query string parameters in the form of key-value pair.
     * @return Returns the Email object.
     * @throws Exception
     */

    public Email getEmailContent(String salesorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + salesorderId + "/email";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        return salesOrderParser.getEmailContent(response);
    }

    /**
     * Maximum of 25 sales orders can be exported in a single pdf.
     *
     * @param queryMap Comma separated sales order ids which are to be export as pdf.
     * @return Returns the File, which is stored in the current working directory.
     * @throws Exception
     */

    public File bulkExport(HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/pdf";    //No I18N

        File file = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return file;

    }

    /**
     * Export sales orders as pdf and print them. Maximum of 25 sales orders can be printed.
     *
     * @param queryMap Comma separated sales order ids which are to be export as pdf.
     * @return Returns the File, which is stored in the current working directory.
     * @throws Exception
     */

    public File bulkPrint(HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/print";    //No I18N

        File file = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return file;

    }

    /**
     * Updates the billing address for this sales order alone.
     * You can set this address as default billing address for your customer by specifying 'is_update_customer' param as true.
     *
     * @param salesorderId ID of the sales order.
     * @param address      Address object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateBillingAddress(String salesorderId, Address address) throws Exception {
        String urlString = url + "/" + salesorderId + "/address/billing";    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", address.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return salesOrderParser.getMessage(response);

    }

    /**
     * Updates the shipping address for this sales order alone.
     * You can set this address as default shipping address for your customer by specifying 'is_update_customer' param as true.
     *
     * @param salesorderId ID of the sales order.
     * @param address      Address object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateShippingAddress(String salesorderId, Address address) throws Exception {

        String urlString = url + "/" + salesorderId + "/address/shipping";    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", address.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return salesOrderParser.getMessage(response);

    }

    /**
     * Get all sales order pdf templates.
     *
     * @return Returns TemplateList object.
     * @throws Exception
     */

    public TemplateList getTemplates() throws Exception {

        String urlString = url + "/templates";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return salesOrderParser.getTemplates(response);

    }

    /**
     * Update the pdf template associated with the sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param templateId   ID of the template.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateTemplate(String salesorderId, String templateId) throws Exception {

        String urlString = url + "/" + salesorderId + "/templates/" + templateId;    //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap());

        return salesOrderParser.getMessage(response);

    }


    //==============================================================================================================


    /**
     * Get the file attached to the sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param queryMap     It contains the query string parameters in the form of key-value pair.
     * @return Returns the File, which is stored in the current working directory.
     * @throws Exception
     */

    public File getAttachment(String salesorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + salesorderId + "/attachment";    //No I18N

        File attachment = ZohoHTTPClient.getFile(urlString, getQueryMap(queryMap));

        return attachment;

    }

    /**
     * Attach a file to a sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param queryMap     It contains the query string parameters in the form of key-value pair.
     * @param file         File object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String addAttachment(String salesorderId, HashMap<String, Object> queryMap, File file) throws Exception {

        String urlString = url + "/" + salesorderId + "/attachment";    //No I18N

        HashMap<String, Object> fileBody = new HashMap<String, Object>();
        fileBody.put("attachment", file);

        String response = ZohoHTTPClient.post(urlString, getQueryMap(queryMap), null, fileBody);

        return salesOrderParser.getMessage(response);

    }

    /**
     * Set whether you want to send the attached file while emailing the sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param queryMap     It contains the query string parameters in the form of key-value pair.
     * @return Returns the success message.
     * @throws Exception
     */

    public String updateAttachment(String salesorderId, HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/" + salesorderId + "/attachment";    //No I18N

        String response = ZohoHTTPClient.put(urlString, getQueryMap(queryMap));

        return salesOrderParser.getMessage(response);
    }

    /**
     * Delete the file attached to the sales order.
     *
     * @param salesorderId ID of the sales order.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deletAttachment(String salesorderId) throws Exception {

        String urlString = url + "/" + salesorderId + "/attachment";    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return salesOrderParser.getMessage(response);

    }


    //=============================================================================================================


    /**
     * Get the complete history and comments of sales order.
     *
     * @param salesorderId ID of the sales order.
     * @return Returns the CommentList object.
     * @throws Exception
     */

    public CommentList getComments(String salesorderId) throws Exception {

        String urlString = url + "/" + salesorderId + "/comments";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return salesOrderParser.getComments(response);

    }

    /**
     * Add a comment for a sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param description  Description for the comment.
     * @return Returns the Comment object.
     * @throws Exception
     */

    public Comment addComment(String salesorderId, String description) throws Exception {

        String urlString = url + "/" + salesorderId + "/comments";    //No I18N

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return salesOrderParser.getComment(response);

    }

    /**
     * Update existing comment of a sales order.
     *
     * @param salesorderId ID of the sales order.
     * @param commentId    ID of the comment.
     * @param description  Description for the comment.
     * @return Returns the Comment object.
     * @throws Exception
     */

    public Comment updateComment(String salesorderId, String commentId, String description) throws Exception {

        String urlString = url + "/" + salesorderId + "/comments/" + commentId;    //No I18N

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return salesOrderParser.getComment(response);

    }

    /**
     * Delete a sales order comment.
     *
     * @param salesorderId ID of the sales order.
     * @param commentId    ID of the comment.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deleteComment(String salesorderId, String commentId) throws Exception {

        String urlString = url + "/" + salesorderId + "/comments/" + commentId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return salesOrderParser.getMessage(response);

    }


}
