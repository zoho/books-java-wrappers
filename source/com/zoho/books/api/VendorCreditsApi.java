/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.*;
import com.zoho.books.parser.VendorCreditsParser;
import com.zoho.books.util.ZohoHTTPClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * VendorCreditsApi is used to:
 * <p>
 * Get the list of vendor credits.
 * <p>
 * Get the details of a vendor credit.
 * <p>
 * Get the list of vendor credit refunds.
 * <p>
 * Get the refunds of vendor credit.
 * <p>
 * Get the details of a vendor credit.
 * <p>
 * Get the list of comments.
 * <p>
 * <p>
 * Create a new vendor credit.
 * <p>
 * Convert the vendor credit into open.
 * <p>
 * Convert the vendor credit into void.
 * <p>
 * Apply bills to a vendor credit.
 * <p>
 * Refund a vendor credit.
 * <p>
 * Add a comment.
 * <p>
 * <p>
 * Update the details of a vendor credit.
 * <p>
 * Update the details of a vendor credit refund.
 * <p>
 * <p>
 * Delete an existing vendor credit.
 * <p>
 * Delete an existing bills credited.
 * <p>
 * Delete an existing vendor credit refund.
 * <p>
 * Delete an existing comment.
 *
 * @author ramesh-2099
 */

public class VendorCreditsApi extends API {

    private String url = baseURL + "/vendorcredits";    //No I18N

    /**
     * Construct a new VendorCreditsApi using user's authToken and organizationId.
     *
     * @param authToken      User's authToken.
     * @param organizationId User's organizationId.
     */

    public VendorCreditsApi(String authToken, String organizationId) {
        super(authToken, organizationId);
    }

    //VendorCreditsParser is used to parse the JSON response into respective objects.

    VendorCreditsParser vendorCreditsParser = new VendorCreditsParser();


    /**
     * List vendor credits with pagination.
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the VendorCreditList object.
     * @throws Exception
     */

    public VendorCreditList getVendorCredits(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        return vendorCreditsParser.getVendorCredits(response);

    }

    /**
     * Get details of a vendor credit.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the VendorCredit object.
     * @throws Exception
     */

    public VendorCredit get(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId;    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return vendorCreditsParser.getVendorCredit(response);
    }

    /**
     * Create a vendor credit for a vendor.
     *
     * @param paramMap     It contains the query string parameters in the form of key-value pair.
     * @param vendorCredit VendorCredit object.
     * @return Returns the VendorCredit object.
     * @throws Exception
     */

    public VendorCredit create(HashMap<String, Object> paramMap, VendorCredit vendorCredit) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", vendorCredit.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return vendorCreditsParser.getVendorCredit(response);

    }

    /**
     * Update an existing vendor credit.
     *
     * @param vendorCredit VendorCredit object.
     * @return Returns the VendorCredit object.
     * @throws Exception
     */

    public VendorCredit update(VendorCredit vendorCredit) throws Exception {

        String urlString = url + "/" + vendorCredit.getVendorCreditId();    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", vendorCredit.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return vendorCreditsParser.getVendorCredit(response);

    }

    /**
     * Delete a vendor credit.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the success message.
     * @throws Exception
     */

    public String delete(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return vendorCreditsParser.getMessage(response);

    }

    /**
     * Change an existing vendor credit status to open.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the success message.
     * @throws Exception
     */

    public String convertToOpen(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/status/open";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return vendorCreditsParser.getMessage(response);

    }

    /**
     * Mark an existing vendor credit as void.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the success message.
     * @throws Exception
     */

    public String convertToVoid(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/status/void";    //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        return vendorCreditsParser.getMessage(response);

    }


    //========================================================================================================


    /**
     * List bills to which the vendor credit is applied.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the JSON string response.
     * @throws Exception
     */

    public String getBillsCredited(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/applytobills";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return response;

    }

    /**
     * Apply vendor credit to existing bills.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @param bills          List of Bill object.
     * @return Returns the success message.
     * @throws Exception
     */

    public String applyCreditsToBill(String vendorCreditId, List<Bill> bills) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/bills";    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        JSONObject jsonObject = new JSONObject();

        JSONArray billsArray = new JSONArray();

        for (int i = 0; i < bills.size(); i++) {
            JSONObject bill = new JSONObject();

            bill.put("bill_id", bills.get(i).getBillId());
            bill.put("amount_applied", bills.get(i).getAmountApplied());

            billsArray.put(bill);
        }
        jsonObject.put("bills", billsArray);

        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return vendorCreditsParser.getMessage(response);
    }

    /**
     * Delete the credits applied to a bill.
     *
     * @param vendorCreditId     ID of the vendor credit.
     * @param vendorCreditBillId ID of the vendor credit bill.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deleteBillsCredited(String vendorCreditId, String vendorCreditBillId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/bills/" + vendorCreditBillId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return vendorCreditsParser.getMessage(response);

    }


    //=========================================================================================================


    /**
     * List all refunds with pagination.
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the VendorCreditRefundList object.
     * @throws Exception
     */

    public VendorCreditRefundList getVendorCreditRefunds(HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/refunds";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        return vendorCreditsParser.getVendorCreditRefunds(response);

    }

    /**
     * List all refunds of an existing vendor credit.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the VendorCreditRefundList object.
     * @throws Exception
     */

    public VendorCreditRefundList getRefundsOfVendorCredit(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/refunds";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return vendorCreditsParser.getVendorCreditRefunds(response);

    }

    /**
     * Get refund of a particular vendor credit.
     *
     * @param vendorCreditId       ID of the vendor credit.
     * @param vendorCreditRefundId ID of the vendor credit refund.
     * @return Returns the VendorCreditRefund object.
     * @throws Exception
     */

    public VendorCreditRefund getVendorCreditRefund(String vendorCreditId, String vendorCreditRefundId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/refunds/" + vendorCreditRefundId;    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return vendorCreditsParser.getVendorCreditRefund(response);

    }

    /**
     * Refund vendor credit amount.
     *
     * @param vendorCreditId     ID of the vendor credit.
     * @param vendorCreditRefund VendorCredit Refund object.
     * @return Returns the VendorCreditRefund object.
     * @throws Exception
     */

    public VendorCreditRefund refundAVendorCredit(String vendorCreditId, VendorCreditRefund vendorCreditRefund) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/refunds";    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", vendorCreditRefund.toJSON().toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return vendorCreditsParser.getVendorCreditRefund(response);
    }

    /**
     * Update the refunded transaction.
     *
     * @param vendorCreditId     ID of the vendor credit.
     * @param vendorCreditRefund VendorCreditRefund object.
     * @return Returns the VendorCreditRefund object.
     * @throws Exception
     */

    public VendorCreditRefund updateVendorCreditRefund(String vendorCreditId, VendorCreditRefund vendorCreditRefund) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/refunds/" + vendorCreditRefund.getVendorCreditRefundId();    //No I18N

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", vendorCreditRefund.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return vendorCreditsParser.getVendorCreditRefund(response);

    }

    /**
     * Delete a vendor credit refund.
     *
     * @param vendorCreditId       ID of the vendor credit.
     * @param vendorCreditRefundId ID of the vendor credit refund.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deleteVendorCreditRefund(String vendorCreditId, String vendorCreditRefundId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/refunds/" + vendorCreditRefundId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return vendorCreditsParser.getMessage(response);
    }


    //=======================================================================================================


    /**
     * Get history and comments of a vendor credit.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @return Returns the CommentList object.
     * @throws Exception
     */

    public CommentList getComments(String vendorCreditId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/comments";    //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        return vendorCreditsParser.getComments(response);

    }

    /**
     * Add a comment to an existing vendor credit.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @param description    Description of the comment.
     * @return Returns the Comment object.
     * @throws Exception
     */

    public Comment addComment(String vendorCreditId, String description) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/comments";    //No I18N

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);

        HashMap<String, Object> requestBody = getQueryMap();
        requestBody.put("JSONString", jsonObject.toString());

        String response = ZohoHTTPClient.post(urlString, requestBody);

        return vendorCreditsParser.getComment(response);

    }

    /**
     * Delete a vendor credit comment.
     *
     * @param vendorCreditId ID of the vendor credit.
     * @param commentId      ID of the comment.
     * @return Returns the success message.
     * @throws Exception
     */

    public String deleteComment(String vendorCreditId, String commentId) throws Exception {

        String urlString = url + "/" + vendorCreditId + "/comments/" + commentId;    //No I18N

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        return vendorCreditsParser.getMessage(response);

    }


}
