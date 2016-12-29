/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * CreditNoteParser is used to parse the json response and make it into the respective objects.
 */

public class CreditNoteParser {

    /**
     * Parse the json response and returns the CreditNoteList object.
     *
     * @param response This json response contains list of credit notes details.
     * @return Returns the CreditNoteList object.
     */

    public CreditNoteList getCreditNotes(String response) throws Exception {

        CreditNoteList creditNoteList = new CreditNoteList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("creditnotes");  //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            CreditNote creditNote = new CreditNote();

            creditNote.setCreditnoteId(jsonArray.getJSONObject(i).getString("creditnote_id"));
            creditNote.setCreditnoteNumber(jsonArray.getJSONObject(i).getString("creditnote_number"));
            creditNote.setStatus(jsonArray.getJSONObject(i).getString("status"));
            creditNote.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            creditNote.setDate(jsonArray.getJSONObject(i).getString("date"));
            creditNote.setTotal(jsonArray.getJSONObject(i).getDouble("total"));    //No I18N
            creditNote.setBalance(jsonArray.getJSONObject(i).getDouble("balance")); //No I18N
            creditNote.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            creditNote.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            creditNote.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            creditNote.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            creditNote.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));
            creditNote.setLastModifiedTime(jsonArray.getJSONObject(i).getString("last_modified_time"));
            creditNote.setIsEmailed(jsonArray.getJSONObject(i).getBoolean("is_emailed")); //No I18N

            creditNoteList.add(creditNote);
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

        creditNoteList.setPageContext(pageContext);

        return creditNoteList;
    }

    /**
     * Parse the json response and returns the CreditNote object.
     *
     * @param response This json response contains the credit note details.
     * @return Returns the CreditNote object.
     */

    public CreditNote getCreditNote(String response) throws Exception {
        CreditNote creditNotes = new CreditNote();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject creditNote = jsonObject.getJSONObject("creditnote"); //No I18N

        creditNotes.setCreditnoteId(creditNote.getString("creditnote_id"));
        creditNotes.setCreditnoteNumber(creditNote.getString("creditnote_number"));
        creditNotes.setDate(creditNote.getString("date"));
        creditNotes.setStatus(creditNote.getString("status"));
        creditNotes.setReferenceNumber(creditNote.getString("reference_number"));
        creditNotes.setCustomerId(creditNote.getString("customer_id"));
        creditNotes.setCustomerName(creditNote.getString("customer_name"));

        JSONArray contactPerson = creditNote.getJSONArray("contact_persons"); //No I18N

        String[] contactPersons = new String[contactPerson.length()];

        for (int j = 0; j < contactPerson.length(); j++) {
            contactPersons[j] = contactPerson.getString(j);
        }

        creditNotes.setContactPersons(contactPersons);

        creditNotes.setCurrencyId(creditNote.getString("currency_id"));
        creditNotes.setCurrencyCode(creditNote.getString("currency_code"));
        creditNotes.setExchangeRate(creditNote.getDouble("exchange_rate"));  //No I18N
        creditNotes.setPricePrecision(creditNote.getInt("price_precision")); //No I18N
        creditNotes.setTemplateId(creditNote.getString("template_id"));
        creditNotes.setIsEmailed(creditNote.getBoolean("is_emailed"));    //No I18N

        JSONArray lineItems = creditNote.getJSONArray("line_items"); //No I18N

        List<LineItem> lineItemsList = new ArrayList<LineItem>();

        for (int i = 0; i < lineItems.length(); i++) {
            LineItem lineItem = new LineItem();

            lineItem.setItemId(lineItems.getJSONObject(i).getString("item_id"));
            lineItem.setLineItemId(lineItems.getJSONObject(i).getString("line_item_id"));
            lineItem.setAccountId(lineItems.getJSONObject(i).getString("account_id"));
            lineItem.setAccountName(lineItems.getJSONObject(i).getString("account_name"));
            lineItem.setName(lineItems.getJSONObject(i).getString("name"));
            lineItem.setDescription(lineItems.getJSONObject(i).getString("description"));
            lineItem.setItemOrder(lineItems.getJSONObject(i).getInt("item_order")); //No I18N
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));        //No I18N
            lineItem.setQuantity(lineItems.getJSONObject(i).getDouble("quantity")); //No I18N
            lineItem.setUnit(lineItems.getJSONObject(i).getString("unit"));
            lineItem.setBcyRate(lineItems.getJSONObject(i).getDouble("bcy_rate"));  //No I18N
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));        //No I18N
            lineItem.setTaxId(lineItems.getJSONObject(i).getString("tax_id"));
            lineItem.setTaxName(lineItems.getJSONObject(i).getString("tax_name"));
            lineItem.setItemTotal(lineItems.getJSONObject(i).getDouble("item_total")); //No I18N

            lineItemsList.add(i, lineItem);
        }

        creditNotes.setLineItems(lineItemsList);

        creditNotes.setSubTotal(creditNote.getDouble("sub_total"));                //No I18N
        creditNotes.setTotal(creditNote.getDouble("total"));                        //No I18N
        creditNotes.setTotalCreditsUsed(creditNote.getDouble("total_credits_used"));        //No I18N
        creditNotes.setTotalRefundedAmount(creditNote.getDouble("total_refunded_amount"));    //No I18N
        creditNotes.setBalance(creditNote.getDouble("balance"));                //No I18N

        JSONArray taxes = creditNote.getJSONArray("taxes");    //No I18N

        List<Tax> taxesList = new ArrayList<Tax>();

        for (int k = 0; k < taxes.length(); k++) {
            Tax tax = new Tax();

            tax.setTaxName(taxes.getJSONObject(k).getString("tax_name"));
            tax.setTaxAmount(taxes.getJSONObject(k).getDouble("tax_amount"));  //No I18N

            taxesList.add(k, tax);
        }

        creditNotes.setTaxes(taxesList);

        creditNotes.setNotes(creditNote.getString("notes"));
        creditNotes.setTerms(creditNote.getString("terms"));

        JSONObject billingAddress = creditNote.getJSONObject("billing_address"); //No I18N

        Address billingAddressObj = new Address();

        billingAddressObj.setAddress(billingAddress.getString("address"));
        billingAddressObj.setCity(billingAddress.getString("city"));
        billingAddressObj.setState(billingAddress.getString("state"));
        billingAddressObj.setZip(billingAddress.getString("zip"));
        billingAddressObj.setCountry(billingAddress.getString("country"));
        billingAddressObj.setFax(billingAddress.getString("fax"));

        creditNotes.setBillingAddress(billingAddressObj);

        JSONObject shippingAddress = creditNote.getJSONObject("shipping_address"); //No I18N

        Address shippingAddressObj = new Address();

        shippingAddressObj.setAddress(shippingAddress.getString("address"));
        shippingAddressObj.setCity(shippingAddress.getString("city"));
        shippingAddressObj.setState(shippingAddress.getString("state"));
        shippingAddressObj.setZip(shippingAddress.getString("zip"));
        shippingAddressObj.setCountry(shippingAddress.getString("country"));
        shippingAddressObj.setFax(shippingAddress.getString("fax"));

        creditNotes.setShippingAddress(shippingAddressObj);

        creditNotes.setCreatedTime(creditNote.getString("created_time"));
        creditNotes.setCreatedTime(creditNote.getString("created_time"));
        creditNotes.setLastModifiedTime(creditNote.getString("last_modified_time"));

        return creditNotes;
    }

    /**
     * Parse the json response and returns the EmailHistoryList object.
     *
     * @param response This json response contains list of email histories details for credit note.
     * @return Returns the EmailHistoryList object.
     */

    public EmailHistoryList getEmailHistory(String response) throws Exception {

        EmailHistoryList emailHistoryList = new EmailHistoryList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("email_history"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            EmailHistory emailhistory = new EmailHistory();

            emailhistory.setMailhistoryId(jsonArray.getJSONObject(i).getString("mailhistory_id"));
            emailhistory.setFrom(jsonArray.getJSONObject(i).getString("from"));
            emailhistory.setToMailIds(jsonArray.getJSONObject(i).getString("to_mail_ids"));
            emailhistory.setSubject(jsonArray.getJSONObject(i).getString("subject"));
            emailhistory.setDate(jsonArray.getJSONObject(i).getString("date"));
            emailhistory.setType(jsonArray.getJSONObject(i).getString("type"));

            emailHistoryList.add(emailhistory);
        }

        return emailHistoryList;

    }


    /**
     * Parse the json response and returns the Email object.
     *
     * @param response This json response contains the email content details for credit note.
     * @return Returns the Email object.
     */


    public Email getEmailContent(String response) throws Exception {
        Email email = new Email();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject data = jsonObject.getJSONObject("data"); //No I18N

        email.setSubject(data.getString("subject"));
        email.setBody(data.getString("body"));
        email.setFileName(data.getString("file_name"));
        email.setCustomerId(data.getString("customer_id"));

        JSONArray emailtemplates = data.getJSONArray("emailtemplates"); //No I18N

        List<Emailtemplate> emailtemplatesList = new ArrayList<Emailtemplate>();

        for (int i = 0; i < emailtemplates.length(); i++) {
            Emailtemplate emailtemplate = new Emailtemplate();

            emailtemplate.setSelected(emailtemplates.getJSONObject(i).getBoolean("selected")); //No I18N
            emailtemplate.setName(emailtemplates.getJSONObject(i).getString("name"));
            emailtemplate.setEmailTemplateId(emailtemplates.getJSONObject(i).getString("email_template_id"));

            emailtemplatesList.add(i, emailtemplate);
        }

        email.setEmailtemplates(emailtemplatesList);

        JSONArray toContacts = data.getJSONArray("to_contacts"); //No I18N

        List<ToContact> toContactsList = new ArrayList<ToContact>();

        for (int j = 0; j < toContacts.length(); j++) {
            ToContact toContact = new ToContact();

            toContact.setFirstName(toContacts.getJSONObject(j).getString("first_name"));
            toContact.setLastName(toContacts.getJSONObject(j).getString("last_name"));
            toContact.setSelected(toContacts.getJSONObject(j).getBoolean("selected")); //No I18N
            toContact.setPhone(toContacts.getJSONObject(j).getString("phone"));
            toContact.setEmail(toContacts.getJSONObject(j).getString("email"));
            toContact.setContactPersonId(toContacts.getJSONObject(j).getString("contact_person_id"));
            toContact.setSalutation(toContacts.getJSONObject(j).getString("salutation"));
            toContact.setMobile(toContacts.getJSONObject(j).getString("mobile"));

            toContactsList.add(j, toContact);
        }

        email.setToContacts(toContactsList);

        JSONArray fromEmails = data.getJSONArray("from_emails"); //No I18N

        List<FromEmail> fromEmailsList = new ArrayList<FromEmail>();

        for (int k = 0; k < fromEmails.length(); k++) {
            FromEmail fromEmail = new FromEmail();

            fromEmail.setUserName(fromEmails.getJSONObject(k).getString("user_name"));
            fromEmail.setSelected(fromEmails.getJSONObject(k).getBoolean("selected")); //No I18N
            fromEmail.setEmail(fromEmails.getJSONObject(k).getString("email"));

            fromEmailsList.add(k, fromEmail);
        }

        email.setFromEmails(fromEmailsList);

        return email;
    }


    /**
     * Parse the json response and returns the InvoiceList object.
     *
     * @param response This json response contains list of invoices details for credit note.
     * @return Returns the InvoiceList object.
     */


    public InvoiceList getCreditToInvoice(String response) throws Exception {

        InvoiceList invoiceList = new InvoiceList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject applytoInvoices = jsonObject.getJSONObject("apply_to_invoices"); //No I18N

        JSONArray jsonArray = applytoInvoices.getJSONArray("invoices"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Invoice invoice = new Invoice();

            invoice.setInvoiceId(jsonArray.getJSONObject(i).getString("invoice_id"));
            invoice.setAmountApplied(jsonArray.getJSONObject(i).getDouble("amount_applied")); //No I18N

            invoiceList.add(invoice);
        }

        return invoiceList;
    }

    /**
     * Parse the json response and returns the InvoicesCreditedList object.
     *
     * @param response This json response contains list of invoices credited details for credit note.
     * @return Returns the InvoicesCreditedList object.
     */

    public InvoicesCreditedList getInvoicesCredited(String response) throws Exception {

        InvoicesCreditedList invoicesCreditedList = new InvoicesCreditedList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("invoices_credited"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            InvoicesCredited invoiceCredited = new InvoicesCredited();

            invoiceCredited.setCreditnoteId(jsonArray.getJSONObject(i).getString("creditnote_id"));
            invoiceCredited.setInvoiceId(jsonArray.getJSONObject(i).getString("invoice_id"));
            invoiceCredited.setCreditnoteInvoiceId(jsonArray.getJSONObject(i).getString("creditnote_invoice_id"));
            invoiceCredited.setDate(jsonArray.getJSONObject(i).getString("date"));
            invoiceCredited.setInvoiceNumber(jsonArray.getJSONObject(i).getString("invoice_number"));
            invoiceCredited.setCreditnoteNumber(jsonArray.getJSONObject(i).getString("creditnote_number"));
            invoiceCredited.setCreditedAmount(jsonArray.getJSONObject(i).getDouble("credited_amount")); //No I18N

            invoicesCreditedList.add(invoiceCredited);
        }

        return invoicesCreditedList;
    }


    /**
     * Parse the json response and returns the CreditnoteRefundList object.
     *
     * @param response This json response contains list of creditnote refunds details for credit note.
     * @return Returns the CreditnoteRefundList object.
     */

    public CreditnoteRefundList getRefunds(String response) throws Exception {

        CreditnoteRefundList creditnoteRefundList = new CreditnoteRefundList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("creditnote_refunds"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            CreditnoteRefund creditnoteRefund = new CreditnoteRefund();

            creditnoteRefund.setCreditnoteRefundId(jsonArray.getJSONObject(i).getString("creditnote_refund_id"));
            creditnoteRefund.setCreditnoteId(jsonArray.getJSONObject(i).getString("creditnote_id"));
            creditnoteRefund.setDate(jsonArray.getJSONObject(i).getString("date"));
            creditnoteRefund.setRefundMode(jsonArray.getJSONObject(i).getString("refund_mode"));
            creditnoteRefund.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            creditnoteRefund.setCreditnoteNumber(jsonArray.getJSONObject(i).getString("creditnote_number"));
            creditnoteRefund.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            creditnoteRefund.setDescription(jsonArray.getJSONObject(i).getString("description"));
            creditnoteRefund.setAmountBcy(jsonArray.getJSONObject(i).getDouble("amount_bcy")); //No I18N
            creditnoteRefund.setAmountFcy(jsonArray.getJSONObject(i).getDouble("amount_fcy")); //No I18N

            creditnoteRefundList.add(creditnoteRefund);
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

        creditnoteRefundList.setPageContext(pageContext);

        return creditnoteRefundList;
    }

    /**
     * Parse the json response and returns the CreditnoteRefund object.
     *
     * @param response This json response contains the creditnote refund details for credit note.
     * @return Returns the CreditnoteRefund object.
     */

    public CreditnoteRefund getCreditnoteRefund(String response) throws Exception {

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject creditnoteRefunds = jsonObject.getJSONObject("creditnote_refund"); //No I18N

        CreditnoteRefund creditnoteRefund = new CreditnoteRefund();

        creditnoteRefund.setCreditnoteRefundId(creditnoteRefunds.getString("creditnote_refund_id"));
        creditnoteRefund.setCreditnoteId(creditnoteRefunds.getString("creditnote_id"));
        creditnoteRefund.setDate(creditnoteRefunds.getString("date"));
        creditnoteRefund.setRefundMode(creditnoteRefunds.getString("refund_mode"));
        creditnoteRefund.setReferenceNumber(creditnoteRefunds.getString("reference_number"));
        creditnoteRefund.setAmount(creditnoteRefunds.getDouble("amount")); //No I18N
        creditnoteRefund.setExchangeRate(creditnoteRefunds.getDouble("exchange_rate")); //No I18N
        creditnoteRefund.setFromAccountId(creditnoteRefunds.getString("from_account_id"));
        creditnoteRefund.setFromAccountName(creditnoteRefunds.getString("from_account_name"));
        creditnoteRefund.setDescription(creditnoteRefunds.getString("description"));

        return creditnoteRefund;
    }

    /**
     * Parse the json response and returns the TemplateList object.
     *
     * @param response This json response contains list of templates details for credit note.
     * @return Returns the TemplateList object.
     */

    public TemplateList getTemplates(String response) throws Exception {

        TemplateList templateList = new TemplateList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("templates"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Template template = new Template();

            template.setTemplateName(jsonArray.getJSONObject(i).getString("template_name"));
            template.setTemplateId(jsonArray.getJSONObject(i).getString("template_id"));
            template.setTemplateType(jsonArray.getJSONObject(i).getString("template_type"));

            templateList.add(template);
        }

        return templateList;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for credit note.
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

            comment.setCreditnoteId(jsonArray.getJSONObject(i).getString("creditnote_id"));
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
     * @param response This json response contains the comment details for credit note.
     * @return Returns the Comment object.
     */

    public Comment getComment(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject comments = jsonObject.getJSONObject("comment"); //No I18N

        Comment comment = new Comment();

        comment.setCommentId(comments.getString("comment_id"));
        comment.setCreditnoteId(comments.getString("creditnote_id"));
        comment.setDescription(comments.getString("description"));
        comment.setCommentedById(comments.getString("commented_by_id"));
        comment.setCommentedBy(comments.getString("commented_by"));
        comment.setDate(comments.getString("date"));

        return comment;
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
