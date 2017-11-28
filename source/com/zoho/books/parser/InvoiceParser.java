/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * InvoiceParser is used to parse the json response and make it into the respective objects.
 */

public class InvoiceParser {

    /**
     * Parse the json response and returns the InvoiceList object.
     *
     * @param response This json respone contains list of invoices details.
     * @return Returns the InvoiceList object.
     */

    public InvoiceList getInvoices(String response) throws Exception {

        InvoiceList invoiceList = new InvoiceList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("invoices"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Invoice inv = new Invoice();

            inv.setInvoiceId(jsonArray.getJSONObject(i).getString("invoice_id"));
            inv.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            inv.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            inv.setStatus(jsonArray.getJSONObject(i).getString("status"));
            inv.setInvoiceNumber(jsonArray.getJSONObject(i).getString("invoice_number"));
            inv.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            inv.setDate(jsonArray.getJSONObject(i).getString("date"));
            inv.setDueDate(jsonArray.getJSONObject(i).getString("due_date"));
            inv.setDueDays(jsonArray.getJSONObject(i).getString("due_days"));
            inv.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            inv.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            inv.setTotal(jsonArray.getJSONObject(i).getDouble("total"));     //No I18N
            inv.setBalance(jsonArray.getJSONObject(i).getDouble("balance")); //No I18N
            inv.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));
            inv.setIsEmailed(jsonArray.getJSONObject(i).getBoolean("is_emailed"));        //No I18N
            inv.setRemindersSent(jsonArray.getJSONObject(i).getInt("reminders_sent"));    //No I18N
            inv.setPaymentExpectedDate(jsonArray.getJSONObject(i).getString("payment_expected_date"));
            inv.setLastPaymentDate(jsonArray.getJSONObject(i).getString("last_payment_date"));

            if (jsonArray.getJSONObject(i).has("is_viewed_by_client")) {
                inv.setViewedByClient(jsonArray.getJSONObject(i).getBoolean("is_viewed_by_client"));    //No I18N
            }
            if (jsonArray.getJSONObject(i).has("client_viewed_time")) {
                inv.setClientViewedTime(jsonArray.getJSONObject(i).getString("client_viewed_time"));
            }


            invoiceList.add(inv);
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

        invoiceList.setPageContext(pageContext);

        return invoiceList;

    }

    /**
     * Parse the json response and returns the Invoice object.
     *
     * @param response This json respone contains the invoice details.
     * @return Returns the Invoice object.
     */

    public Invoice getInvoice(String response) throws Exception {

        Invoice invoice = new Invoice();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject invoiceDetails = jsonObject.getJSONObject("invoice"); //No I18N

        invoice.setInvoiceId(invoiceDetails.getString("invoice_id"));
        invoice.setInvoiceNumber(invoiceDetails.getString("invoice_number"));
        invoice.setCustomerId(invoiceDetails.getString("customer_id"));
        invoice.setCustomerName(invoiceDetails.getString("customer_name"));
        invoice.setDate(invoiceDetails.getString("date"));
        invoice.setStatus(invoiceDetails.getString("status"));
        invoice.setPaymentTerms(invoiceDetails.getInt("payment_terms")); //No I18N
        invoice.setPaymentTermsLabel(invoiceDetails.getString("payment_terms_label"));
        invoice.setDueDate(invoiceDetails.getString("due_date"));
        invoice.setPaymentExpectedDate(invoiceDetails.getString("payment_expected_date"));
        invoice.setLastPaymentDate(invoiceDetails.getString("last_payment_date"));
        invoice.setReferenceNumber(invoiceDetails.getString("reference_number"));
        invoice.setCurrencyCode(invoiceDetails.getString("currency_code"));
        invoice.setExchangeRate(invoiceDetails.getDouble("exchange_rate")); //No I18N
        invoice.setDiscount(invoiceDetails.getString("discount"));
        invoice.setIsDiscountBeforeTax(invoiceDetails.getBoolean("is_discount_before_tax")); //No I18N
        invoice.setDiscountType(invoiceDetails.getString("discount_type"));
        invoice.setRecurringInvoiceId(invoiceDetails.getString("recurring_invoice_id"));

        JSONArray contactPerson = invoiceDetails.getJSONArray("contact_persons"); //No I18N

        String[] contactPersons = new String[contactPerson.length()];

        for (int j = 0; j < contactPerson.length(); j++) {
            contactPersons[j] = contactPerson.getString(j);
        }

        invoice.setContactPersons(contactPersons);

        JSONArray lineItems = invoiceDetails.getJSONArray("line_items"); //No I18N

        List<LineItem> lineItemsList = new ArrayList<LineItem>();

        for (int i = 0; i < lineItems.length(); i++) {
            LineItem lineItem = new LineItem();

            lineItem.setTaxName(lineItems.getJSONObject(i).getString("tax_name"));
            lineItem.setTaxType(lineItems.getJSONObject(i).getString("tax_type"));
            lineItem.setExpenseId(lineItems.getJSONObject(i).getString("expense_id"));
            lineItem.setLineItemId(lineItems.getJSONObject(i).getString("line_item_id"));
            lineItem.setDiscount(lineItems.getJSONObject(i).getDouble("discount")); //No I18N
            lineItem.setExpenseReceiptName(lineItems.getJSONObject(i).getString("expense_receipt_name"));
            lineItem.setUnit(lineItems.getJSONObject(i).getString("unit"));
            lineItem.setItemOrder(lineItems.getJSONObject(i).getInt("item_order")); //No I18N
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));    //No I18N
            lineItem.setBcyRate(lineItems.getJSONObject(i).getDouble("bcy_rate"));  //No I18N
            lineItem.setItemId(lineItems.getJSONObject(i).getString("item_id"));
            lineItem.setTimeEntryIds(lineItems.getJSONObject(i).getString("time_entry_ids"));
            lineItem.setDescription(lineItems.getJSONObject(i).getString("description"));
            lineItem.setProjectId(lineItems.getJSONObject(i).getString("project_id"));
            lineItem.setName(lineItems.getJSONObject(i).getString("name"));
            lineItem.setTaxId(lineItems.getJSONObject(i).getString("tax_id"));
            lineItem.setQuantity(lineItems.getJSONObject(i).getDouble("quantity")); //No I18N
            lineItem.setTaxPercentage(lineItems.getJSONObject(i).getDouble("tax_percentage")); //No I18N
            lineItem.setItemTotal(lineItems.getJSONObject(i).getDouble("item_total")); //No I18N
            if (lineItems.getJSONObject(i).has("salesorder_item_id")) {
                lineItem.setSalesorderItemId(lineItems.getJSONObject(i).getString("salesorder_item_id"));
            }
            if (lineItems.getJSONObject(i).has("stock_on_hand")) {
                lineItem.setStockOnHand(lineItems.getJSONObject(i).getString("stock_on_hand"));
            }
            if (lineItems.getJSONObject(i).has("tax_exemption_id")) {
                lineItem.setTaxExemptionId(lineItems.getJSONObject(i).getString("tax_exemption_id"));
            }

            lineItemsList.add(i, lineItem);
        }

        invoice.setLineItems(lineItemsList);

        invoice.setShippingCharge(invoiceDetails.getDouble("shipping_charge")); //No I18N
        invoice.setAdjustment(invoiceDetails.getDouble("adjustment"));        //No I18N
        invoice.setAdjustmentDescription(invoiceDetails.getString("adjustment_description"));
        invoice.setSubTotal(invoiceDetails.getDouble("sub_total")); //No I18N
        invoice.setTaxTotal(invoiceDetails.getDouble("tax_total")); //No I18N
        invoice.setTotal(invoiceDetails.getDouble("total"));        //No I18N

        JSONArray taxes = invoiceDetails.getJSONArray("taxes"); //No I18N

        List<Tax> taxesList = new ArrayList<Tax>();

        for (int k = 0; k < taxes.length(); k++) {
            Tax tax = new Tax();

            tax.setTaxName(taxes.getJSONObject(k).getString("tax_name"));
            tax.setTaxAmount(taxes.getJSONObject(k).getDouble("tax_amount")); //No I18N

            taxesList.add(k, tax);
        }

        invoice.setTaxes(taxesList);

        invoice.setPaymentReminderEnabled(invoiceDetails.getBoolean("payment_reminder_enabled")); //No I18N
        invoice.setPaymentMade(invoiceDetails.getDouble("payment_made"));        //No I18N
        invoice.setCreditsApplied(invoiceDetails.getDouble("credits_applied"));    //No I18N
        invoice.setTaxAmountWithheld(invoiceDetails.getDouble("tax_amount_withheld"));    //No I18N
        invoice.setBalance(invoiceDetails.getDouble("balance"));            //No I18N
        invoice.setWriteOffAmount(invoiceDetails.getDouble("write_off_amount"));    //No I18N
        invoice.setAllowPartialPayments(invoiceDetails.getBoolean("allow_partial_payments")); //No I18N
        invoice.setPricePrecision(invoiceDetails.getInt("price_precision"));        //No I18N

        JSONObject paymentOptions = invoiceDetails.getJSONObject("payment_options"); //No I18N

        JSONArray paymentGateways = paymentOptions.getJSONArray("payment_gateways"); //No I18N

        List<PaymentGateway> paymentGatewaysList = new ArrayList<PaymentGateway>();

        for (int l = 0; l < paymentGateways.length(); l++) {
            PaymentGateway paymentGateway = new PaymentGateway();

            paymentGateway.setGatewayName(paymentGateways.getJSONObject(l).getString("gateway_name"));

            if (paymentGateways.getJSONObject(l).has("additional_field1")) {
                paymentGateway.setAdditionalField1(paymentGateways.getJSONObject(l).getString("additional_field1"));
            }
            if (paymentGateways.getJSONObject(l).has("configured")) {
                paymentGateway.setConfigured(paymentGateways.getJSONObject(l).getBoolean("configured")); //No I18N
            }


            paymentGatewaysList.add(l, paymentGateway);
        }

        invoice.setPaymentGateways(paymentGatewaysList);

        invoice.setIsEmailed(invoiceDetails.getBoolean("is_emailed")); //No I18N
        invoice.setRemindersSent(invoiceDetails.getInt("reminders_sent")); //No I18N
        invoice.setLastReminderSentDate(invoiceDetails.getString("last_reminder_sent_date"));

        JSONObject billingAddress = invoiceDetails.getJSONObject("billing_address"); //No I18N

        Address billingAddressObj = new Address();

        billingAddressObj.setAddress(billingAddress.getString("address"));
        billingAddressObj.setCity(billingAddress.getString("city"));
        billingAddressObj.setState(billingAddress.getString("state"));
        billingAddressObj.setZip(billingAddress.getString("zip"));
        billingAddressObj.setCountry(billingAddress.getString("country"));
        billingAddressObj.setFax(billingAddress.getString("fax"));

        invoice.setBillingAddress(billingAddressObj);

        JSONObject shippingAddress = invoiceDetails.getJSONObject("shipping_address"); //No I18N

        Address shippingAddressObj = new Address();

        shippingAddressObj.setAddress(shippingAddress.getString("address"));
        shippingAddressObj.setCity(shippingAddress.getString("city"));
        shippingAddressObj.setState(shippingAddress.getString("state"));
        shippingAddressObj.setZip(shippingAddress.getString("zip"));
        shippingAddressObj.setCountry(shippingAddress.getString("country"));
        shippingAddressObj.setFax(shippingAddress.getString("fax"));

        invoice.setShippingAddress(shippingAddressObj);

        invoice.setNotes(invoiceDetails.getString("notes"));
        invoice.setTerms(invoiceDetails.getString("terms"));

        JSONArray customFields = invoiceDetails.getJSONArray("custom_fields"); //No I18N

        List<CustomField> customFieldsList = new ArrayList<CustomField>();

        for (int m = 0; m < customFields.length(); m++) {
            CustomField customField = new CustomField();

            customField.setIndex(customFields.getJSONObject(m).getInt("index")); //No I18N
            customField.setValue(customFields.getJSONObject(m).getString("value"));
            customField.setShowOnPdf(customFields.getJSONObject(m).getBoolean("show_on_pdf")); //No I18N
            customField.setLabel(customFields.getJSONObject(m).getString("label"));

            customFieldsList.add(m, customField);
        }

        invoice.setCustomFields(customFieldsList);

        invoice.setTemplateId(invoiceDetails.getString("template_id"));
        invoice.setTemplateName(invoiceDetails.getString("template_name"));
        invoice.setCreatedTime(invoiceDetails.getString("created_time"));
        invoice.setCreatedTime(invoiceDetails.getString("created_time"));
        invoice.setLastModifiedTime(invoiceDetails.getString("last_modified_time"));
        invoice.setAttachmentName(invoiceDetails.getString("attachment_name"));
        invoice.setCanSendInMail(invoiceDetails.getBoolean("can_send_in_mail")); //No I18N
        invoice.setSalespersonId(invoiceDetails.getString("salesperson_id"));
        invoice.setSalespersonName(invoiceDetails.getString("salesperson_name"));

        if (invoiceDetails.has("client_viewed_time")) {
            invoice.setClientViewedTime(invoiceDetails.getString("client_viewed_time"));
        }
        if (invoiceDetails.has("is_viewed_by_client")) {
            invoice.setViewedByClient(invoiceDetails.getBoolean("is_viewed_by_client"));    //No I18N
        }
        if (invoiceDetails.has("stop_reminder_until_payment_expected_date")) {
            invoice.setStopReminderUntilPaymentExpectedDate(invoiceDetails.getBoolean("stop_reminder_until_payment_expected_date"));//No I18N
        }
        if (invoiceDetails.has("template_type")) {
            invoice.setTemplateType(invoiceDetails.getString("template_type"));
        }
        if (invoiceDetails.has("is_autobill_enabled")) {
            invoice.setAutobillEnabled(invoiceDetails.getBoolean("is_autobill_enabled"));    //No I18N
        }
        if (invoiceDetails.has("invoice_url")) {
            invoice.setInvoiceUrl(invoiceDetails.getString("invoice_url"));
        }

        if (invoiceDetails.has("tax_id")) {
            invoice.setTaxId(invoiceDetails.getString("tax_id"));
        }
        if (invoiceDetails.has("tax_authority_id")) {
            invoice.setTaxAuthorityId(invoiceDetails.getString("tax_authority_id"));
        }
        if (invoiceDetails.has("tax_exemption_id")) {
            invoice.setTaxExemptionId(invoiceDetails.getString("tax_exemption_id"));
        }

        return invoice;
    }

    /**
     * Parse the json response and returns the Email object.
     *
     * @param response This json response contains the email content details for invoice.
     * @return Returns the Email object.
     */

    public Email getEmailContent(String response) throws Exception {
        Email email = new Email();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject data = jsonObject.getJSONObject("data"); //No I18N

        email.setGatewaysConfigured(data.getBoolean("gateways_configured")); //No I18N
        email.setSubject(data.getString("subject"));
        email.setBody(data.getString("body"));
        email.setAttachmentName(data.getString("attachment_name"));
        email.setFileName(data.getString("file_name"));
        email.setCustomerId(data.getString("customer_id"));

        if (data.has("emailtemplates")) {

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
        }

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
            if (fromEmails.getJSONObject(k).has("is_org_email_id")) {
                fromEmail.setOrgEmailId(fromEmails.getJSONObject(k).getBoolean("is_org_email_id"));    //No I18N
            }

            fromEmailsList.add(k, fromEmail);
        }

        email.setFromEmails(fromEmailsList);

        if (data.has("attach_pdf")) {
            email.setAttachPdf(data.getBoolean("attach_pdf"));    //No I18N
        }
        if (data.has("entity_id")) {
            email.setEntityId(data.getString("entity_id"));
        }
        if (data.has("file_name_without_extension")) {
            email.setFileNameWithoutExtension(data.getString("file_name_without_extension"));
        }
        if (data.has("gateways_associated")) {
            email.setGatewaysAssociated(data.getBoolean("gateways_associated"));    //No I18N
        }

        return email;
    }


    /**
     * Parse the json response and returns the PaymentList object.
     *
     * @param response This json response contains list of payments details for invoice.
     * @return Returns the PaymentList object.
     */

    public PaymentList getPayments(String response) throws Exception {

        PaymentList paymentList = new PaymentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("payments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Payment payment = new Payment();

            payment.setPaymentId(jsonArray.getJSONObject(i).getString("payment_id"));
            payment.setPaymentNumber(jsonArray.getJSONObject(i).getString("payment_number"));
            payment.setInvoiceId(jsonArray.getJSONObject(i).getString("invoice_id"));
            payment.setInvoicePaymentId(jsonArray.getJSONObject(i).getString("invoice_payment_id"));
            payment.setPaymentMode(jsonArray.getJSONObject(i).getString("payment_mode"));
            payment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            payment.setDate(jsonArray.getJSONObject(i).getString("date"));
            payment.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            payment.setExchangeRate(jsonArray.getJSONObject(i).getDouble("exchange_rate"));        //No I18N
            payment.setAmount(jsonArray.getJSONObject(i).getDouble("amount"));                //No I18N
            payment.setTaxAmountWithheld(jsonArray.getJSONObject(i).getDouble("tax_amount_withheld"));    //No I18N
            payment.setIsSingleInvoicePayment(jsonArray.getJSONObject(i).getBoolean("is_single_invoice_payment")); //No I18N

            paymentList.add(payment);
        }

        return paymentList;
    }

    /**
     * Parse the json response and returns the TemplateList object.
     *
     * @param response This json response contains list of templates details for invoice.
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
     * @param response This json response contains list of comments details for invoice.
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

            comment.setInvoiceId(jsonArray.getJSONObject(i).getString("invoice_id"));
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
     * @param response This json response contains the comment details for invoice.
     * @return Returns the Comment object.
     */

    public Comment getComment(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject comment = jsonObject.getJSONObject("comment"); //No I18N

        Comment comments = new Comment();

        comments.setCommentId(comment.getString("comment_id"));
        comments.setDescription(comment.getString("description"));
        comments.setInvoiceId(comment.getString("invoice_id"));
        comments.setCommentedById(comment.getString("commented_by_id"));
        comments.setCommentedBy(comment.getString("commented_by"));
        comments.setCommentType(comment.getString("comment_type"));
        comments.setDate(comment.getString("date"));
        comments.setDateDescription(comment.getString("date_description"));
        comments.setTime(comment.getString("time"));

        return comments;
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
     * Parse the json response and returns the CreditList object.
     *
     * @param response This json response contains list of credits details for invoice.
     * @return Returns the CreditList object.
     */

    public CreditList getCreditsApplied(String response) throws Exception {

        CreditList creditList = new CreditList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("credits"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Credit credit = new Credit();

            credit.setCreditnoteId(jsonArray.getJSONObject(i).getString("creditnote_id"));
            credit.setCreditnotesInvoiceId(jsonArray.getJSONObject(i).getString("creditnotes_invoice_id"));
            credit.setCreditnotesNumber(jsonArray.getJSONObject(i).getString("creditnotes_number"));
            credit.setCreditedDate(jsonArray.getJSONObject(i).getString("credited_date"));
            credit.setAmountApplied(jsonArray.getJSONObject(i).getDouble("amount_applied")); //No I18N

            creditList.add(credit);
        }

        return creditList;
    }

    /**
     * Parse the json response and returns the Credit object.
     *
     * @param response This json response contains the credit details for invoice.
     * @return Returns the Credit object.
     */

    public Credit getApplyCredits(String response) throws Exception {
        Credit credits = new Credit();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject useCredits = jsonObject.getJSONObject("use_credits"); //No I18N

        JSONArray invoicePayments = useCredits.getJSONArray("invoice_payments"); //No I18N

        List<InvoicePayment> invoicePaymentsList = new ArrayList<InvoicePayment>();

        for (int i = 0; i < invoicePayments.length(); i++) {
            InvoicePayment invoicePayment = new InvoicePayment();

            invoicePayment.setInvoicePaymentId(invoicePayments.getJSONObject(i).getString("invoice_payment_id"));
            invoicePayment.setPaymentId(invoicePayments.getJSONObject(i).getString("payment_id"));
            invoicePayment.setInvoiceId(invoicePayments.getJSONObject(i).getString("invoice_id"));
            invoicePayment.setAmountUsed(invoicePayments.getJSONObject(i).getDouble("amount_used")); //No I18N

            invoicePaymentsList.add(i, invoicePayment);
        }

        credits.setInvoicePayments(invoicePaymentsList);

        JSONArray applyCreditnotes = useCredits.getJSONArray("apply_creditnotes"); //No I18N

        List<ApplyCreditnote> applyCreditnotesList = new ArrayList<ApplyCreditnote>();

        for (int j = 0; j < applyCreditnotes.length(); j++) {
            ApplyCreditnote applyCreditnote = new ApplyCreditnote();

            applyCreditnote.setCreditnotesInvoiceId(applyCreditnotes.getJSONObject(j).getString("creditnotes_invoice_id"));
            applyCreditnote.setCreditnoteId(applyCreditnotes.getJSONObject(j).getString("creditnote_id"));
            applyCreditnote.setInvoiceId(applyCreditnotes.getJSONObject(j).getString("invoice_id"));
            applyCreditnote.setAmountApplied(applyCreditnotes.getJSONObject(j).getDouble("amount_applied")); //No I18N

            applyCreditnotesList.add(j, applyCreditnote);
        }

        credits.setApplyCreditnotes(applyCreditnotesList);

        return credits;
    }
}
