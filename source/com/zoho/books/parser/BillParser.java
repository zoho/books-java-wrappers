/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * BillParser is used to parse the json response and make it into the respective objects.
 */

public class BillParser {

    /**
     * Parse the json response and returns the Bill object.
     *
     * @param response This json response contains the bill details.
     * @return Returns the Bill object.
     */

    public Bill getBill(String response) throws Exception {
        Bill bills = new Bill();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject bill = jsonObject.getJSONObject("bill"); //No I18N

        bills.setBillId(bill.getString("bill_id"));
        bills.setVendorId(bill.getString("vendor_id"));
        bills.setVendorName(bill.getString("vendor_name"));
        bills.setUnusedCreditsPayableAmount(bill.getDouble("unused_credits_payable_amount")); //No I18N
        bills.setStatus(bill.getString("status"));
        bills.setBillNumber(bill.getString("bill_number"));
        bills.setDate(bill.getString("date"));
        bills.setDueDate(bill.getString("due_date"));
        bills.setReferenceNumber(bill.getString("reference_number"));
        bills.setDueByDays(bill.getString("due_by_days"));
        bills.setDueInDays(bill.getString("due_in_days"));
        bills.setCurrencyId(bill.getString("currency_id"));
        bills.setCurrencyCode(bill.getString("currency_code"));
        bills.setCurrencySymbol(bill.getString("currency_symbol"));
        bills.setPricePrecision(bill.getInt("price_precision"));    //No I18N
        bills.setExchangeRate(bill.getDouble("exchange_rate"));    //No I18N
        bills.setSubTotal(bill.getDouble("sub_total"));            //No I18N
        bills.setTaxTotal(bill.getDouble("tax_total"));            //No I18N
        bills.setTotal(bill.getDouble("total"));            //No I18N
        bills.setPaymentMade(bill.getDouble("payment_made"));        //No I18N
        bills.setBalance(bill.getDouble("balance"));            //No I18N
        bills.setCreatedTime(bill.getString("created_time"));
        bills.setLastModifiedTime(bill.getString("last_modified_time"));
        bills.setReferenceId(bill.getString("reference_id"));
        bills.setNotes(bill.getString("notes"));
        bills.setTerms(bill.getString("terms"));
        bills.setAttachmentName(bill.getString("attachment_name"));

        JSONArray lineItems = bill.getJSONArray("line_items"); //No I18N

        List<LineItem> lineItemsList = new ArrayList<LineItem>();

        for (int i = 0; i < lineItems.length(); i++) {
            LineItem lineItem = new LineItem();

            lineItem.setLineItemId(lineItems.getJSONObject(i).getString("line_item_id"));
            lineItem.setAccountId(lineItems.getJSONObject(i).getString("account_id"));
            lineItem.setAccountName(lineItems.getJSONObject(i).getString("account_name"));
            lineItem.setDescription(lineItems.getJSONObject(i).getString("description"));
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));        //No I18N
            lineItem.setBcyRate(lineItems.getJSONObject(i).getDouble("bcy_rate"));    //No I18N
            lineItem.setQuantity(lineItems.getJSONObject(i).getDouble("quantity"));    //No I18N
            lineItem.setTaxId(lineItems.getJSONObject(i).getString("tax_id"));
            lineItem.setTaxName(lineItems.getJSONObject(i).getString("tax_name"));
            lineItem.setTaxType(lineItems.getJSONObject(i).getString("tax_type"));
            lineItem.setTaxPercentage(lineItems.getJSONObject(i).getDouble("tax_percentage"));    //No I18N
            lineItem.setItemTotal(lineItems.getJSONObject(i).getDouble("item_total"));        //No I18N
            lineItem.setItemOrder(lineItems.getJSONObject(i).getInt("item_order"));            //No I18N

            lineItemsList.add(i, lineItem);
        }

        bills.setLineItems(lineItemsList);

        JSONArray taxes = bill.getJSONArray("taxes"); //No I18N

        List<Tax> taxesList = new ArrayList<Tax>();

        for (int j = 0; j < taxes.length(); j++) {
            Tax tax = new Tax();

            tax.setTaxName(taxes.getJSONObject(j).getString("tax_name"));
            tax.setTaxAmount(taxes.getJSONObject(j).getDouble("tax_amount")); //No I18N

            taxesList.add(j, tax);
        }

        bills.setTaxes(taxesList);

        JSONObject billingAddress = bill.getJSONObject("billing_address"); //No I18N

        Address billingAddressObj = new Address();

        billingAddressObj.setAddress(billingAddress.getString("address"));
        billingAddressObj.setCity(billingAddress.getString("city"));
        billingAddressObj.setState(billingAddress.getString("state"));
        billingAddressObj.setZip(billingAddress.getString("zip"));
        billingAddressObj.setCountry(billingAddress.getString("country"));
        billingAddressObj.setFax(billingAddress.getString("fax"));

        bills.setBillingAddress(billingAddressObj);

        JSONArray payments = bill.getJSONArray("payments"); //No I18N

        List<Payment> paymentsList = new ArrayList<Payment>();

        for (int k = 0; k < payments.length(); k++) {
            Payment payment = new Payment();

            payment.setPaymentId(payments.getJSONObject(k).getString("payment_id"));
            payment.setBillId(payments.getJSONObject(k).getString("bill_id"));
            payment.setBillPaymentId(payments.getJSONObject(k).getString("bill_payment_id"));
            payment.setPaymentMode(payments.getJSONObject(k).getString("payment_mode"));
            payment.setDescription(payments.getJSONObject(k).getString("description"));
            payment.setDate(payments.getJSONObject(k).getString("date"));
            payment.setReferenceNumber(payments.getJSONObject(k).getString("reference_number"));
            payment.setExchangeRate(payments.getJSONObject(k).getDouble("exchange_rate"));    //No I18N
            payment.setAmount(payments.getJSONObject(k).getDouble("amount"));        //No I18N
            payment.setPaidThroughAccountId(payments.getJSONObject(k).getString("paid_through_account_id"));
            payment.setPaidThroughAccountName(payments.getJSONObject(k).getString("paid_through_account_name"));
            payment.setIsSingleBillPayment(payments.getJSONObject(k).getBoolean("is_single_bill_payment")); //No I18N

            paymentsList.add(k, payment);
        }

        bills.setPayments(paymentsList);

        return bills;
    }

    /**
     * Parse the json response and returns the BillList object.
     *
     * @param response This json response contains list of bills details.
     * @return Returns the BillList object.
     */

    public BillList getBills(String response) throws Exception {

        BillList billList = new BillList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("bills");    //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Bill bill = new Bill();

            bill.setBillId(jsonArray.getJSONObject(i).getString("bill_id"));
            bill.setVendorId(jsonArray.getJSONObject(i).getString("vendor_id"));
            bill.setVendorName(jsonArray.getJSONObject(i).getString("vendor_name"));
            bill.setStatus(jsonArray.getJSONObject(i).getString("status"));
            bill.setBillNumber(jsonArray.getJSONObject(i).getString("bill_number"));
            bill.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            bill.setDate(jsonArray.getJSONObject(i).getString("date"));
            bill.setDueDate(jsonArray.getJSONObject(i).getString("due_date"));
            bill.setDueDays(jsonArray.getJSONObject(i).getString("due_days"));
            bill.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            bill.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            bill.setTotal(jsonArray.getJSONObject(i).getDouble("total"));        //No I18N
            bill.setBalance(jsonArray.getJSONObject(i).getDouble("balance"));    //No I18N
            bill.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));

            billList.add(bill);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        billList.setPageContext(pageContext);

        return billList;
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

    /**
     * Parse the json response and returns the PaymentList object.
     *
     * @param response This json response contains list of payments details of the bill.
     * @return Returns the PaymentList object.
     */

    public PaymentList getPayments(String response) throws Exception {

        PaymentList paymentList = new PaymentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("payments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Payment payment = new Payment();

            payment.setPaymentId(jsonArray.getJSONObject(i).getString("payment_id"));
            payment.setBillId(jsonArray.getJSONObject(i).getString("bill_id"));
            payment.setBillPaymentId(jsonArray.getJSONObject(i).getString("bill_payment_id"));
            payment.setVendorId(jsonArray.getJSONObject(i).getString("vendor_id"));
            payment.setVendorName(jsonArray.getJSONObject(i).getString("vendor_name"));
            payment.setPaymentMode(jsonArray.getJSONObject(i).getString("payment_mode"));
            payment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            payment.setDate(jsonArray.getJSONObject(i).getString("date"));
            payment.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            payment.setExchangeRate(jsonArray.getJSONObject(i).getDouble("exchange_rate")); //No I18N
            payment.setAmount(jsonArray.getJSONObject(i).getDouble("amount"));        //No I18N
            payment.setPaidThrough(jsonArray.getJSONObject(i).getString("paid_through"));
            payment.setIsSingleBillPayment(jsonArray.getJSONObject(i).getBoolean("is_single_bill_payment")); //No I18N

            paymentList.add(payment);
        }

        return paymentList;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details of the bill.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String response) throws Exception {

        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("comments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Comment comment = new Comment();

            comment.setCommentId(jsonArray.getJSONObject(i).getString("comment_id"));
            comment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            comment.setBillId(jsonArray.getJSONObject(i).getString("bill_id"));
            comment.setCommentedById(jsonArray.getJSONObject(i).getString("commented_by_id"));
            comment.setCommentedBy(jsonArray.getJSONObject(i).getString("commented_by"));
            comment.setCommentType(jsonArray.getJSONObject(i).getString("comment_type"));
            comment.setDate(jsonArray.getJSONObject(i).getString("date"));
            comment.setDateDescription(jsonArray.getJSONObject(i).getString("date_description"));
            comment.setTime(jsonArray.getJSONObject(i).getString("time"));
            comment.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            comment.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));
            comment.setOperationType(jsonArray.getJSONObject(i).getString("operation_type"));

            commentList.add(comment);
        }

        return commentList;
    }

    /**
     * Parse the json response and returns the Comment object.
     *
     * @param response This json response contains the comment details of the bill.
     * @return Returns the Comment object.
     */

    public Comment getComment(String response) throws Exception {
        Comment comments = new Comment();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject comment = jsonObject.getJSONObject("comment"); //No I18N

        comments.setCommentId(comment.getString("comment_id"));
        comments.setDescription(comment.getString("description"));
        comments.setBillId(comment.getString("bill_id"));
        comments.setCommentedById(comment.getString("commented_by_id"));
        comments.setCommentedBy(comment.getString("commented_by"));
        comments.setCommentType(comment.getString("comment_type"));
        comments.setDate(comment.getString("date"));
        comments.setDateDescription(comment.getString("date_description"));
        comments.setTime(comment.getString("time"));

        return comments;
    }
}

