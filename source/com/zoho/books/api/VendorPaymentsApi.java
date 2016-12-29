/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.VendorPayment;
import com.zoho.books.model.VendorPaymentList;
import com.zoho.books.parser.VendorPaymentParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.util.HashMap;


/**
 * VendorPaymentsApi is used to create a payment made for the vendor.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of vendor payments.<br>
 * <p>
 * The details of a vendor payment.<br><br>
 * <p>
 * It is ued to update the details of a vendor payment.<br>
 * <p>
 * It is used to delete the vendor payment.
 */

public class VendorPaymentsApi extends API {

    private static String url = baseURL + "/vendorpayments"; //No I18N


    /**
     * Construct a new VendorPaymentsApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public VendorPaymentsApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private VendorPaymentParser vendorPaymentParser = new VendorPaymentParser();


    /**
     * Create a payment made to your vendor and you can also apply them to bills either partially or fully.
     * <p>
     * Pass the VendorPayment object to create a payment made to your vendor.
     * <p>
     * The VendorPayment object which contains vendorId and amount are the mandatory parameters.
     * <p>
     * It returns the VendorPayment object.
     *
     * @param vendorPayment VendorPayment object.
     * @return Returns the VendorPayment object.
     */

    public VendorPayment create(VendorPayment vendorPayment) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", vendorPayment.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return vendorPaymentParser.getVendorPayment(response);
    }

    /**
     * Get the details of a vendor payment.
     * <p>
     * Pass the paymentId to get the details of a vandor payment.
     * <p>
     * It returns the VendorPayment object.
     *
     * @param paymentId ID of the vendor payment.
     * @return Returns the VendorPayment object.
     */

    public VendorPayment get(String paymentId) throws Exception {

        String urlString = url + "/" + paymentId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        VendorPayment vendorPayment = vendorPaymentParser.getVendorPayment(response);

        return vendorPayment;
    }

    /**
     * Update an existing vendor payment (You can also modify the amount applied to the bills).
     * <p>
     * Pass the VendorPayment object to update the details of a vendor payment.
     * <p>
     * The VendorPayment object which contains paymentId is the mandatory parameter for which vendor payment details has to be updated.
     * <p>
     * It returns the VendorPayment object.
     *
     * @param vendorPayment VendorPayment object.
     * @return Returns the VendorPayment object.
     */

    public VendorPayment update(VendorPayment vendorPayment) throws Exception {

        String urlString = url + "/" + vendorPayment.getPaymentId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", vendorPayment.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return vendorPaymentParser.getVendorPayment(response);
    }

    /**
     * Delete an existing vendor payment.
     * <p>
     * Pass the paymentId to delete the vendor payment.
     * <p>
     * If the vendor payment has been deleted it returns the success message.
     * <p>
     * The success message is "The payment has been deleted."
     *
     * @param paymentId ID of the vendor payment.
     * @return Returns a String.
     */

    public String delete(String paymentId) throws Exception {

        String urlString = url + "/" + paymentId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = vendorPaymentParser.getMessage(response);

        return success;
    }

    /**
     * List all the payments made to your vendor.
     * <p>
     * Pass the filters to get all the vendor payments based on the filters.
     * <p>
     * It returns the VendorPaymentList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border="1">
     * <p>
     * <tbody>
     * <p>
     * <tr><td>vendor_name</td>  <td>Search payments by vendor name. <br>
     * Variants: <i>vendor_name_startswith and vendor_name_contains</i></td></tr>
     * <p>
     * <tr><td>reference_number</td> <td>Search payments by reference number.<br>
     * Variants: <i>reference_number_startswith and reference_number_contains</i></td></tr>
     * <p>
     * <tr><td>date</td>  <td>Search payments by payment made date.<br>
     * Variants: <i>date_start, date_end, date_before and date_after</i></td></tr>
     * <p>
     * <tr><td>amount</td>  <td>Search payments by payment amount.<br>
     * Variants: <i>amount_less_than, amount_less_equals, amount_greater_than and amount_greater_equals</i></td></tr>
     * <p>
     * <tr><td>payment_mode</td>  <td>Search payments by payment mode.<br>
     * Variants: <i>payment_mode_startswith and payment_mode_contains</i></td></tr>
     * <p>
     * <tr><td>vendor_id</td>  <td>Search payments by vendor id.</td></tr>
     * <p>
     * <tr><td>bill_id</td>  <td>Search payments by bill id.</td></tr>
     * <p>
     * <tr><td>search_text</td>  <td>Search payments by reference number or vendor name or payment description.</td></tr>
     * <p>
     * <tr><td>notes</td>  <td>Search payments by notes.<br>
     * Variants: <i>notes_startswith and notes_contains</i></td></tr>
     * <p>
     * <tr><td>filter_by</td> <td>Filter payments by mode.<br>
     * Allowed Values: <i>PaymentMode.All, PaymentMode.Check, PaymentMode.Cash, PaymentMode.BankTransfer, PaymentMode.Paypal, PaymentMode.CreditCard, PaymentMode.GoogleCheckout, PaymentMode.Credit, PaymentMode.Authorizenet, PaymentMode.BankRemittance, PaymentMode.Payflowpro and PaymentMode.Others</i></td></tr>
     * <p>
     * <tr><td>sort_column</td> <td>Sort the payment list.<br>
     * Allowed Values: <i>vendor_name, date, reference_number, amount and balance</i></td></tr>
     * <p>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the VendorPaymentList object.
     */

    public VendorPaymentList getVendorPayments(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        VendorPaymentList vendorPaymentList = vendorPaymentParser.getVendorPayments(response);

        return vendorPaymentList;
    }

}
