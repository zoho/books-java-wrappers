/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.BaseCurrencyAdjustment;
import com.zoho.books.model.BaseCurrencyAdjustmentList;
import com.zoho.books.parser.BaseCurrencyAdjustmentParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.util.HashMap;


/**
 * BaseCurrencyAdjustmentsApi is used to create the basecurrency adjustments.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of all  base currency adjustments.<br>
 * <p>
 * The details of a base currency adjsutment.<br>
 * <p>
 * The list of all account details for the base currency adjustment.<br><br>
 * <p>
 * It is used to delete the base currency adjustment.
 */

public class BaseCurrencyAdjustmentsApi extends API {

    private static String url = baseURL + "/basecurrencyadjustment"; //No I18N

    /**
     * Construct a new BaseCurrencyAdjustmentsApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public BaseCurrencyAdjustmentsApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private BaseCurrencyAdjustmentParser baseCurrencyAdjustmentParser = new BaseCurrencyAdjustmentParser();


    /**
     * List of accounts having transaction with effect to the given exchange rate.
     * <p>
     * Pass the filters to get all the base currency adjustment accounts based on the filters.
     * <p>
     * It returns the BaseCurrencyAdjustment object.<br>
     * <p>
     * The queryMap contains the possible keys as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <tbody>
     * <tr><td>currency_id*</td><td>ID of currency for which we need to post adjustment.</td></tr>
     * <p>
     * <tr><td>adjustment_date*</td><td>Date of adjustment.</td></tr>
     * <p>
     * <tr><td>exchange_rate*</td><td>Exchange rate of the currency.</td></tr>
     * <p>
     * <tr><td>notes*</td><td>Notes for the base currency adjustment.</td></tr>
     * </tbody>
     * </table>
     *
     * @param queryMap It contains the query string values in the form of key-value pair.
     * @return Returns the BaseCurrencyAdjustment object.
     */

    public BaseCurrencyAdjustment getBaseCurrencyAdjustmentAccounts(HashMap<String, Object> queryMap) throws Exception {

        String urlString = url + "/accounts"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap));

        BaseCurrencyAdjustment baseCurrencyAdjustment = baseCurrencyAdjustmentParser.getBaseCurrencyAdjustment(response);

        return baseCurrencyAdjustment;
    }

    /**
     * Creates a base currency adjustment for the given information.
     * <p>
     * Pass the querystring parameter and BaseCurrencyAdjustment object to create a base currency adjustment.
     * <p>
     * The BasCurrencyAdjustment object which contains currencyId, adjustmentDate, exchangeRate, and notes are the mandatory parameters.
     * <p>
     * It returns the BaseCurrencyAdjustment object.<br>
     * <p>
     * The paramMap contains the possible key as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <tr><td>account_ids*</td><td>ID of the accounts for which base currency adjustments need to be posted.</td></tr>
     * </tbody>
     * <p>
     * </table>
     *
     * @param paramMap               It contains query string values in the form of key-value pair.
     * @param baseCurrencyAdjustment BaseCurrencyAdjustment object.
     * @return Returns the BaseCurrencyAdjustment object.
     */

    public BaseCurrencyAdjustment create(HashMap<String, Object> paramMap, BaseCurrencyAdjustment baseCurrencyAdjustment) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap(paramMap);

        requestBody.put("JSONString", baseCurrencyAdjustment.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return baseCurrencyAdjustmentParser.getBaseCurrencyAdjustment(response);
    }

    /**
     * Get the base currency adjustment details.
     * <p>
     * Pass the baseCurrencyAdjustmentId to get the details of a base currency adjustment.
     * <p>
     * It returns the BaseCurrencyAdjsutment object.
     *
     * @param baseCurrencyAdjustmentId ID of the BaseCurrencyAdjustment.
     * @return Returns the BaseCurrencyAdjustment object.
     */

    public BaseCurrencyAdjustment get(String baseCurrencyAdjustmentId) throws Exception {

        String urlString = url + "/" + baseCurrencyAdjustmentId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        BaseCurrencyAdjustment baseCurrencyAdjustment = baseCurrencyAdjustmentParser.getBaseCurrencyAdjustment(response);

        return baseCurrencyAdjustment;
    }

    /**
     * Delete the base currency adjustment.
     * <p>
     * Pass the baseCurrencyAdjsutmentId to delete the base currency adjsutment.
     * <p>
     * If the base currency adjustment has been deleted it returns the success message.
     * <p>
     * The success message is "The selected base currency adjustment has been deleted."
     *
     * @param baseCurrencyAdjustmentId ID of the BaseCurrencyAdjustment.
     * @return Returns a String.
     */

    public String delete(String baseCurrencyAdjustmentId) throws Exception {

        String urlString = url + "/" + baseCurrencyAdjustmentId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = baseCurrencyAdjustmentParser.getMessage(response);

        return success;
    }

    /**
     * List base currency adjustment.
     * <p>
     * Pass the filters to get all the base currency adjustments based on the filters.
     * <p>
     * It returns the BaseCurrencyAdjsutmentList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <tr><td>filter_by<td><td>Filter base currency adjustment list. <br>
     * Allowed Values: <i>Date.All, Date.Today, Date.ThisWeek, Date.ThisMonth, Date.ThisQuarter</i> and <i>Date.ThisYear</i></td></tr>
     * <p>
     * <tr><td>sort_column<td><td>Sort base currency adjustment list. <br>
     * Allowed Values: <i>adjustment_date, exchange_rate, currency_code, debit_or_credit</i> and <i>gain_or_loss</i></td></tr>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the BaseCurrencyAdjustmentList object.
     */

    public BaseCurrencyAdjustmentList getBaseCurrencyAdjustments(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        BaseCurrencyAdjustmentList baseCurrencyAdjustmentList = baseCurrencyAdjustmentParser.getBaseCurrencyAdjustments(response);

        return baseCurrencyAdjustmentList;
    }

}
