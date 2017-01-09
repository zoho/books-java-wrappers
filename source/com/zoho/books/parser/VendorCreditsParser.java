/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * VendorCreditsParser is used to parse the JSON response and make it into the respective objects.
 *
 * @author ramesh-2099
 */

public class VendorCreditsParser {


    /**
     * Parse the JSON response and make it into the VendorCreditList object.
     *
     * @param response JSON response contains the details of the list of vendor credits.
     * @return Returns the VendorCreditList object.
     * @throws JSONException
     */

    public VendorCreditList getVendorCredits(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response.trim());

        VendorCreditList vendorCreditList = new VendorCreditList();

        if (jsonObject.has("vendor_credits")) {
            JSONArray vendorcredits = jsonObject.getJSONArray("vendor_credits");    //No I18N

            for (int i = 0; i < vendorcredits.length(); i++) {
                vendorCreditList.add(this.jsonToVendorCredit(vendorcredits.getJSONObject(i)));
            }
        }

        if (jsonObject.has("page_context")) {
            PageContext pageContext = new PageContext();

            JSONObject pagecontext = jsonObject.getJSONObject("page_context");    //No I18N

            if (pagecontext.has("page")) {
                pageContext.setPage(pagecontext.getInt("page"));    //No I18N
            }
            if (pagecontext.has("per_page")) {
                pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
            }
            if (pagecontext.has("has_more_page")) {
                pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page"));    //No I18N
            }
            if (pagecontext.has("report_name")) {
                pageContext.setReportName(pagecontext.getString("report_name"));
            }
            if (pagecontext.has("applied_filter")) {
                pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
            }
            if (pagecontext.has("sort_column")) {
                pageContext.setSortColumn(pagecontext.getString("sort_column"));
            }
            if (pagecontext.has("sort_order")) {
                pageContext.setSortOrder(pagecontext.getString("sort_order"));
            }

            vendorCreditList.setPageContext(pageContext);
        }


        return vendorCreditList;
    }

    /**
     * Parse the JSON response and make it into the VendorCredit object.
     *
     * @param response JSON response contains the details of a vendor credit.
     * @return Returns the VendorCredit object.
     * @throws JSONException
     */

    public VendorCredit getVendorCredit(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject vendorcredit = jsonObject.getJSONObject("vendor_credit");    //No I18N

        return this.jsonToVendorCredit(vendorcredit);

    }


    /**
     * Parse the JSONObject into VendorCredit object.
     *
     * @param jsonObject JSONObject contains the details of a vendor credit.
     * @return Returns the VendorCredit object.
     * @throws JSONException
     */

    public VendorCredit jsonToVendorCredit(JSONObject jsonObject) throws JSONException {

        VendorCredit vendorCredit = new VendorCredit();

        if (jsonObject.has("vendor_credit_id")) {
            vendorCredit.setVendorCreditId(jsonObject.getString("vendor_credit_id"));
        }
        if (jsonObject.has("vendor_credit_number")) {
            vendorCredit.setVendorCreditNumber(jsonObject.getString("vendor_credit_number"));
        }
        if (jsonObject.has("status")) {
            vendorCredit.setStatus(jsonObject.getString("status"));
        }
        if (jsonObject.has("reference_number")) {
            vendorCredit.setReferenceNumber(jsonObject.getString("reference_number"));
        }
        if (jsonObject.has("date")) {
            vendorCredit.setDate(jsonObject.getString("date"));
        }
        if (jsonObject.has("total")) {
            vendorCredit.setTotal(jsonObject.getDouble("total"));    //No I18N
        }
        if (jsonObject.has("balance")) {
            vendorCredit.setBalance(jsonObject.getDouble("balance"));    //No I18N
        }
        if (jsonObject.has("vendor_id")) {
            vendorCredit.setVendorId(jsonObject.getString("vendor_id"));
        }
        if (jsonObject.has("vendor_name")) {
            vendorCredit.setVendorName(jsonObject.getString("vendor_name"));
        }
        if (jsonObject.has("currency_id")) {
            vendorCredit.setCurrencyId(jsonObject.getString("currency_id"));
        }
        if (jsonObject.has("currency_code")) {
            vendorCredit.setCurrencyCode(jsonObject.getString("currency_code"));
        }
        if (jsonObject.has("created_time")) {
            vendorCredit.setCreatedTime(jsonObject.getString("created_time"));
        }
        if (jsonObject.has("last_modified_time")) {
            vendorCredit.setLastModifiedTime(jsonObject.getString("last_modified_time"));
        }

        if (jsonObject.has("exchange_rate")) {
            vendorCredit.setExchangeRate(jsonObject.getDouble("exchange_rate"));    //No I18N
        }
        if (jsonObject.has("price_precision")) {
            vendorCredit.setPricePrecision(jsonObject.getInt("price_precision"));    //No I18N
        }
        if (jsonObject.has("sub_total")) {
            vendorCredit.setSubTotal(jsonObject.getDouble("sub_total"));    //No I18N
        }
        if (jsonObject.has("total_credits_used")) {
            vendorCredit.setTotalCreditsUsed(jsonObject.getDouble("total_credits_used"));    //No I18N
        }
        if (jsonObject.has("total_refunded_amount")) {
            vendorCredit.setTotalRefundedAmount(jsonObject.getDouble("total_refunded_amount"));    //No I18N
        }
        if (jsonObject.has("balance")) {
            vendorCredit.setBalance(jsonObject.getDouble("balance"));    //No I18N
        }
        if (jsonObject.has("notes")) {
            vendorCredit.setNotes(jsonObject.getString("notes"));
        }


        if (jsonObject.has("line_items")) {
            JSONArray lineitems = jsonObject.getJSONArray("line_items");    //No I18N

            List<LineItem> lineItems = new ArrayList<LineItem>();

            for (int i = 0; i < lineitems.length(); i++) {
                lineItems.add(this.jsonToLineItem(lineitems.getJSONObject(i)));
            }

            vendorCredit.setLineItems(lineItems);
        }

        if (jsonObject.has("taxes")) {
            JSONArray taxes = jsonObject.getJSONArray("taxes");    //No I18N

            List<Tax> taxs = new ArrayList<Tax>();

            for (int i = 0; i < taxes.length(); i++) {
                taxs.add(this.jsonToTax(taxes.getJSONObject(i)));
            }

            vendorCredit.setTaxes(taxs);
        }

        if (jsonObject.has("comments")) {
            JSONArray comments = jsonObject.getJSONArray("comments");    //No I18N

            List<Comment> commentList = new ArrayList<Comment>();

            for (int i = 0; i < comments.length(); i++) {
                commentList.add(this.jsonToComment(comments.getJSONObject(i)));
            }

            vendorCredit.setComments(commentList);
        }

        if (jsonObject.has("vendor_credit_refunds")) {

            JSONArray vendorcreditRefunds = jsonObject.getJSONArray("vendor_credit_refunds");    //No I18N

            List<VendorCreditRefund> vendorCreditRefunds = new ArrayList<VendorCreditRefund>();

            for (int i = 0; i < vendorcreditRefunds.length(); i++) {
                vendorCreditRefunds.add(this.jsonToVendorCreditRefund(vendorcreditRefunds.getJSONObject(i)));
            }

            vendorCredit.setVendorCreditRefunds(vendorCreditRefunds);
        }

        if (jsonObject.has("bills_credited")) {
            JSONArray billscredited = jsonObject.getJSONArray("bills_credited");    //No I18N

            List<BillsCredited> billsCredited = new ArrayList<BillsCredited>();

            for (int i = 0; i < billscredited.length(); i++) {
                billsCredited.add(this.jsonToBillsCredited(billscredited.getJSONObject(i)));
            }

            vendorCredit.setBillsCredited(billsCredited);
        }

        return vendorCredit;

    }


    /**
     * Parse the JSON response and make it into the VendorCreditRefundList object.
     *
     * @param response JSON response contains the details of list of vendor credit refunds.
     * @return Returns the VendorCreditRefundList object.
     * @throws Exception
     */

    public VendorCreditRefundList getVendorCreditRefunds(String response) throws Exception {

        JSONObject jsonObject = new JSONObject(response.trim());

        VendorCreditRefundList vendorCreditRefundList = new VendorCreditRefundList();

        if (jsonObject.has("vendor_credit_refunds")) {
            JSONArray vendorCreditRefunds = jsonObject.getJSONArray("vendor_credit_refunds");    //No I18N

            for (int i = 0; i < vendorCreditRefunds.length(); i++) {
                vendorCreditRefundList.add(this.jsonToVendorCreditRefund(vendorCreditRefunds.getJSONObject(i)));
            }
        }

        PageContext pageContext = new PageContext();

        if (jsonObject.has("page_context")) {
            JSONObject pagecontext = jsonObject.getJSONObject("page_context");    //No I18N

            if (pagecontext.has("page")) {
                pageContext.setPage(pagecontext.getInt("page"));    //No I18N
            }
            if (pagecontext.has("per_page")) {
                pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
            }
            if (pagecontext.has("has_more_page")) {
                pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page"));    //No I18N
            }
            if (pagecontext.has("report_name")) {
                pageContext.setReportName(pagecontext.getString("report_name"));
            }
            if (pagecontext.has("sort_column")) {
                pageContext.setSortColumn(pagecontext.getString("sort_column"));
            }
            if (pagecontext.has("sort_order")) {
                pageContext.setSortOrder(pagecontext.getString("sort_order"));
            }

            vendorCreditRefundList.setPageContext(pageContext);
        }

        return vendorCreditRefundList;


    }

    /**
     * Parse the JSON response and make it into the VendorCreditRefund object.
     *
     * @param response JSON response contains the details of a vendor credit refund.
     * @return Returns the VendorCreditRefund object.
     * @throws JSONException
     */

    public VendorCreditRefund getVendorCreditRefund(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject vendorCreditRefund = jsonObject.getJSONObject("vendor_credit_refund");    //No I18N

        return this.jsonToVendorCreditRefund(vendorCreditRefund);

    }


    /**
     * Parse the JSONObject into LineItem object.
     *
     * @param jsonObject JSONObject contains the details of the line item.
     * @return Returns the LineItem object.
     * @throws JSONException
     */

    public LineItem jsonToLineItem(JSONObject jsonObject) throws JSONException {

        LineItem lineItem = new LineItem();

        if (jsonObject.has("line_item_id")) {
            lineItem.setLineItemId(jsonObject.getString("line_item_id"));
        }
        if (jsonObject.has("item_id")) {
            lineItem.setItemId(jsonObject.getString("item_id"));
        }
        if (jsonObject.has("name")) {
            lineItem.setName(jsonObject.getString("name"));
        }
        if (jsonObject.has("description")) {
            lineItem.setDescription(jsonObject.getString("description"));
        }
        if (jsonObject.has("item_order")) {
            lineItem.setItemOrder(jsonObject.getInt("item_order"));    //No I18N
        }
        if (jsonObject.has("bcy_rate")) {
            lineItem.setBcyRate(jsonObject.getDouble("bcy_rate"));    //No I18N
        }
        if (jsonObject.has("rate")) {
            lineItem.setRate(jsonObject.getDouble("rate"));    //No I18N
        }
        if (jsonObject.has("quantity")) {
            lineItem.setQuantity(jsonObject.getDouble("quantity"));    //No I18N
        }
        if (jsonObject.has("unit")) {
            lineItem.setUnit(jsonObject.getString("unit"));
        }
        if (jsonObject.has("discount_amount")) {
            lineItem.setDiscountAmount(jsonObject.getDouble("discount_amount"));    //No I18N
        }
        if (jsonObject.has("discount")) {
            lineItem.setDiscount(jsonObject.getDouble("discount"));    //No I18N
        }
        if (jsonObject.has("tax_id")) {
            lineItem.setTaxId(jsonObject.getString("tax_id"));
        }
        if (jsonObject.has("tax_name")) {
            lineItem.setTaxName(jsonObject.getString("tax_name"));
        }
        if (jsonObject.has("tax_type")) {
            lineItem.setTaxType(jsonObject.getString("tax_type"));
        }
        if (jsonObject.has("tax_percentage")) {
            lineItem.setTaxPercentage(jsonObject.getDouble("tax_percentage"));    //No I18N
        }
        if (jsonObject.has("item_total")) {
            lineItem.setItemTotal(jsonObject.getDouble("item_total"));    //No I18N
        }
        if (jsonObject.has("account_id")) {
            lineItem.setAccountId(jsonObject.getString("account_id"));
        }
        if (jsonObject.has("account_name")) {
            lineItem.setAccountName(jsonObject.getString("account_name"));
        }
        if (jsonObject.has("stock_on_hand")) {
            lineItem.setStockOnHand(jsonObject.getString("stock_on_hand"));
        }

        return lineItem;

    }

    /**
     * Parse the JSONObject into Tax object.
     *
     * @param jsonObject JSONObject contains the details of the tax.
     * @return Returns the Tax object.
     * @throws JSONException
     */

    public Tax jsonToTax(JSONObject jsonObject) throws JSONException {

        Tax tax = new Tax();

        if (jsonObject.has("tax_name")) {
            tax.setTaxName(jsonObject.getString("tax_name"));
        }
        if (jsonObject.has("tax_amount")) {
            tax.setTaxAmount(jsonObject.getDouble("tax_amount"));    //No I18N
        }

        return tax;

    }

    /**
     * Parse the JSON response and make it into the CommentList object.
     *
     * @param response JSON response contains the details of list of comments.
     * @return Returns the CommentList object.
     * @throws Exception
     */

    public CommentList getComments(String response) throws Exception {
        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("comments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            commentList.add(this.jsonToComment(jsonArray.getJSONObject(i)));
        }

        return commentList;
    }

    /**
     * Parse the JSON response into Comment object.
     *
     * @param response JSON response contains the details of the comment.
     * @return Returns the Comment object.
     * @throws Exception
     */

    public Comment getComment(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject comment = jsonObject.getJSONObject("comment"); //No I18N

        return this.jsonToComment(comment);
    }

    /**
     * Parse the JSONObject into Comment object.
     *
     * @param jsonObject JSONObject contains the details of the comment.
     * @return Returns the Comment object.
     * @throws JSONException
     */

    public Comment jsonToComment(JSONObject jsonObject) throws JSONException {

        Comment comment = new Comment();

        if (jsonObject.has("comment_id")) {
            comment.setCommentId(jsonObject.getString("comment_id"));
        }
        if (jsonObject.has("description")) {
            comment.setDescription(jsonObject.getString("description"));
        }
        if (jsonObject.has("commented_by_id")) {
            comment.setCommentedById(jsonObject.getString("commented_by_id"));
        }
        if (jsonObject.has("commented_by")) {
            comment.setCommentedBy(jsonObject.getString("commented_by"));
        }
        if (jsonObject.has("comment_type")) {
            comment.setCommentType(jsonObject.getString("comment_type"));
        }
        if (jsonObject.has("date")) {
            comment.setDate(jsonObject.getString("date"));
        }
        if (jsonObject.has("date_description")) {
            comment.setDateDescription(jsonObject.getString("date_description"));
        }
        if (jsonObject.has("time")) {
            comment.setTime(jsonObject.getString("time"));
        }
        if (jsonObject.has("operation_type")) {
            comment.setOperationType(jsonObject.getString("operation_type"));
        }
        if (jsonObject.has("transaction_id")) {
            comment.setTransactionId(jsonObject.getString("transaction_id"));
        }
        if (jsonObject.has("transaction_type")) {
            comment.setTransactionType(jsonObject.getString("transaction_type"));
        }
        if (jsonObject.has("vendor_credit_id")) {
            comment.setVendorCreditId(jsonObject.getString("vendor_credit_id"));
        }

        return comment;

    }

    /**
     * Parse the JSONObject into VendorCreditRefund object.
     *
     * @param jsonObject JSONObject contains the details of a vendor credit refund.
     * @return Returns the VendorCreditrefund object.
     * @throws JSONException
     */

    public VendorCreditRefund jsonToVendorCreditRefund(JSONObject jsonObject) throws JSONException {

        VendorCreditRefund vendorCreditRefund = new VendorCreditRefund();

        if (jsonObject.has("vendor_credit_refund_id")) {
            vendorCreditRefund.setVendorCreditRefundId(jsonObject.getString("vendor_credit_refund_id"));
        }
        if (jsonObject.has("vendor_credit_id")) {
            vendorCreditRefund.setVendorCreditId(jsonObject.getString("vendor_credit_id"));
        }
        if (jsonObject.has("date")) {
            vendorCreditRefund.setDate(jsonObject.getString("date"));
        }
        if (jsonObject.has("refund_mode")) {
            vendorCreditRefund.setRefundMode(jsonObject.getString("refund_mode"));
        }
        if (jsonObject.has("reference_number")) {
            vendorCreditRefund.setReferenceNumber(jsonObject.getString("reference_number"));
        }
        if (jsonObject.has("description")) {
            vendorCreditRefund.setDescription(jsonObject.getString("description"));
        }
        if (jsonObject.has("amount_bcy")) {
            vendorCreditRefund.setAmountBcy(jsonObject.getDouble("amount_bcy"));    //No I18N
        }
        if (jsonObject.has("amount_fcy")) {
            vendorCreditRefund.setAmountFcy(jsonObject.getDouble("amount_fcy"));    //No I18N
        }

        if (jsonObject.has("vendor_credit_number")) {
            vendorCreditRefund.setVendorCreditNumber(jsonObject.getString("vendor_credit_number"));
        }
        if (jsonObject.has("vendor_name")) {
            vendorCreditRefund.setVendorName(jsonObject.getString("vendor_name"));
        }

        if (jsonObject.has("customer_name")) {
            vendorCreditRefund.setCustomerName(jsonObject.getString("customer_name"));
        }
        if (jsonObject.has("account_id")) {
            vendorCreditRefund.setAccountId(jsonObject.getString("account_id"));
        }
        if (jsonObject.has("account_name")) {
            vendorCreditRefund.setAccountName(jsonObject.getString("account_name"));
        }
        if (jsonObject.has("amount")) {
            vendorCreditRefund.setAmount(jsonObject.getDouble("amount"));    //No I18N
        }
        if (jsonObject.has("exchange_rate")) {
            vendorCreditRefund.setExchangeRate(jsonObject.getDouble("exchange_rate"));    //No I18N
        }

        return vendorCreditRefund;

    }

    /**
     * Parse the JSONObject into BillsCredited object.
     *
     * @param jsonObject JSONObject contains the details of the bills credited.
     * @return Returns the BillsCredited object.
     * @throws JSONException
     */

    public BillsCredited jsonToBillsCredited(JSONObject jsonObject) throws JSONException {

        BillsCredited billsCredited = new BillsCredited();

        if (jsonObject.has("vendor_credit_id")) {
            billsCredited.setVendorCreditId(jsonObject.getString("vendor_credit_id"));
        }
        if (jsonObject.has("bill_id")) {
            billsCredited.setBillId(jsonObject.getString("bill_id"));
        }
        if (jsonObject.has("vendor_credit_bill_id")) {
            billsCredited.setVendorCreditBillId(jsonObject.getString("vendor_credit_bill_id"));
        }
        if (jsonObject.has("date")) {
            billsCredited.setDate(jsonObject.getString("date"));
        }
        if (jsonObject.has("bill_number")) {
            billsCredited.setBillNumber(jsonObject.getString("bill_number"));
        }
        if (jsonObject.has("vendor_credit_number")) {
            billsCredited.setVendorCreditNumber(jsonObject.getString("vendor_credit_number"));
        }
        if (jsonObject.has("amount")) {
            billsCredited.setAmount(jsonObject.getDouble("amount"));    //No I18N
        }

        return billsCredited;

    }


    /**
     * Parse the JSON response and returns a string object.
     *
     * @param response This JSON response contains the success message of post or update or delete requests.
     * @return Returns the success message.
     */

    public String getMessage(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        String success = jsonObject.getString("message");

        return success;
    }

}
