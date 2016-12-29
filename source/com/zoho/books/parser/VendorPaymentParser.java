/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.Bill;
import com.zoho.books.model.PageContext;
import com.zoho.books.model.VendorPayment;
import com.zoho.books.model.VendorPaymentList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * VendorPaymentParser is used to parse the json response and make it into the respective objects.
 */

public class VendorPaymentParser {


    /**
     * Parse the json response and retruns the VendorPayment object.
     *
     * @param response This json response contains the vendor payment details.
     * @return Returns the VendorPayment object.
     */

    public VendorPayment getVendorPayment(String response) throws Exception {
        VendorPayment vendorPayments = new VendorPayment();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject vendorPayment = jsonObject.getJSONObject("vendorpayment"); //No I18N

        vendorPayments.setPaymentId(vendorPayment.getString("payment_id"));
        vendorPayments.setVendorId(vendorPayment.getString("vendor_id"));
        vendorPayments.setVendorName(vendorPayment.getString("vendor_name"));
        vendorPayments.setPaymentMode(vendorPayment.getString("payment_mode"));
        vendorPayments.setDescription(vendorPayment.getString("description"));
        vendorPayments.setDate(vendorPayment.getString("date"));
        vendorPayments.setReferenceNumber(vendorPayment.getString("reference_number"));
        vendorPayments.setExchangeRate(vendorPayment.getDouble("exchange_rate"));    //No I18N
        vendorPayments.setAmount(vendorPayment.getDouble("amount"));            //No I18N
        vendorPayments.setCurrencySymbol(vendorPayment.getString("currency_symbol"));
        vendorPayments.setPaidThroughAccountId(vendorPayment.getString("paid_through_account_id"));
        vendorPayments.setPaidThroughAccountName(vendorPayment.getString("paid_through_account_name"));

        JSONArray bills = vendorPayment.getJSONArray("bills"); //No I18N

        List<Bill> billsList = new ArrayList<Bill>();

        for (int i = 0; i < bills.length(); i++) {
            Bill bill = new Bill();

            bill.setBillNumber(bills.getJSONObject(i).getString("bill_number"));
            bill.setBillPaymentId(bills.getJSONObject(i).getString("bill_payment_id"));
            bill.setBillId(bills.getJSONObject(i).getString("bill_id"));
            bill.setTotal(bills.getJSONObject(i).getDouble("total"));    //No I18N
            bill.setBalance(bills.getJSONObject(i).getDouble("balance"));    //No I18N
            bill.setAmountApplied(bills.getJSONObject(i).getDouble("amount_applied")); //No I18N
            bill.setDate(bills.getJSONObject(i).getString("date"));
            bill.setDueDate(bills.getJSONObject(i).getString("due_date"));

            billsList.add(i, bill);
        }

        vendorPayments.setBills(billsList);

        return vendorPayments;
    }

    /**
     * Parse the json response and returns the VendorPaymentList object.
     *
     * @param response This json response contains list of vendor payments details.
     * @return Returns the VendorPaymentList object.
     */

    public VendorPaymentList getVendorPayments(String response) throws Exception {

        VendorPaymentList vendorPaymentList = new VendorPaymentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("vendorpayments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            VendorPayment vendorPayment = new VendorPayment();

            vendorPayment.setPaymentId(jsonArray.getJSONObject(i).getString("payment_id"));
            vendorPayment.setVendorId(jsonArray.getJSONObject(i).getString("vendor_id"));
            vendorPayment.setVendorName(jsonArray.getJSONObject(i).getString("vendor_name"));
            vendorPayment.setPaymentMode(jsonArray.getJSONObject(i).getString("payment_mode"));
            vendorPayment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            vendorPayment.setDate(jsonArray.getJSONObject(i).getString("date"));
            vendorPayment.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            vendorPayment.setExchangeRate(jsonArray.getJSONObject(i).getDouble("exchange_rate"));    //No I18N
            vendorPayment.setAmount(jsonArray.getJSONObject(i).getDouble("amount"));        //No I18N
            vendorPayment.setPaidThroughAccountId(jsonArray.getJSONObject(i).getString("paid_through_account_id"));
            vendorPayment.setPaidThroughAccountName(jsonArray.getJSONObject(i).getString("paid_through_account_name"));
            vendorPayment.setBalance(jsonArray.getJSONObject(i).getDouble("balance")); //No I18N

            vendorPaymentList.add(vendorPayment);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        vendorPaymentList.setPageContext(pageContext);

        return vendorPaymentList;
    }

    /**
     * Parse the json response and returns a string object.
     *
     * @param response This json response contains the success message of post or update or delete requests.
     * @return Returns the success message.
     */

    public String getMessage(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        String success = jsonObject.getString("message");

        return success;
    }
}
