/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * EstimateParser is used to parse the json response and make it into the respective objects.
 */

public class EstimateParser {

    /**
     * Parse the json response and returns the Estimate object.
     *
     * @param response This json response contains the estimate details.
     * @return Returns the Estimate object.
     */

    public Estimate getEstimate(String response) throws Exception {
        Estimate estimates = new Estimate();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject estimate = jsonObject.getJSONObject("estimate"); //No I18N

        estimates.setEstimateId(estimate.getString("estimate_id"));
        estimates.setEstimateNumber(estimate.getString("estimate_number"));
        estimates.setDate(estimate.getString("date"));
        estimates.setReferenceNumber(estimate.getString("reference_number"));
        estimates.setStatus(estimate.getString("status"));
        estimates.setCustomerId(estimate.getString("customer_id"));
        estimates.setCustomerName(estimate.getString("customer_name"));

        JSONArray contactPersons = estimate.getJSONArray("contact_persons"); //No I18N

        String[] contactPersonsArr = new String[contactPersons.length()];

        for (int j = 0; j < contactPersons.length(); j++) {
            contactPersonsArr[j] = contactPersons.getString(j);
        }

        estimates.setContactPersons(contactPersonsArr);

        estimates.setCurrencyCode(estimate.getString("currency_code"));
        estimates.setExchangeRate(estimate.getDouble("exchange_rate"));    //No I18N
        estimates.setDiscount(estimate.getDouble("discount"));        //No I18N
        estimates.setIsDiscountBeforeTax(estimate.getBoolean("is_discount_before_tax")); //No I18N
        estimates.setDiscountType(estimate.getString("discount_type"));

        JSONArray lineItems = estimate.getJSONArray("line_items"); //No I18N

        List<LineItem> lineItemsList = new ArrayList<LineItem>();

        for (int i = 0; i < lineItems.length(); i++) {
            LineItem lineItem = new LineItem();

            lineItem.setItemId(lineItems.getJSONObject(i).getString("item_id"));
            lineItem.setLineItemId(lineItems.getJSONObject(i).getString("line_item_id"));
            lineItem.setName(lineItems.getJSONObject(i).getString("name"));
            lineItem.setDescription(lineItems.getJSONObject(i).getString("description"));
            lineItem.setItemOrder(lineItems.getJSONObject(i).getInt("item_order")); //No I18N
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));        //No I18N
            lineItem.setQuantity(lineItems.getJSONObject(i).getDouble("quantity")); //No I18N
            lineItem.setUnit(lineItems.getJSONObject(i).getString("unit"));
            lineItem.setDiscount(lineItems.getJSONObject(i).getDouble("discount")); //No I18N
            lineItem.setBcyRate(lineItems.getJSONObject(i).getDouble("bcy_rate"));  //No I18N
            lineItem.setRate(lineItems.getJSONObject(i).getDouble("rate"));        //No I18N
            lineItem.setTaxId(lineItems.getJSONObject(i).getString("tax_id"));
            lineItem.setTaxName(lineItems.getJSONObject(i).getString("tax_name"));
            lineItem.setTaxType(lineItems.getJSONObject(i).getString("tax_type"));
            lineItem.setTaxPercentage(lineItems.getJSONObject(i).getInt("tax_percentage")); //No I18N
            lineItem.setItemTotal(lineItems.getJSONObject(i).getDouble("item_total"));    //No I18N
            if (lineItems.getJSONObject(i).has("discount_amount")) {
                lineItem.setDiscountAmount(lineItems.getJSONObject(i).getDouble("discount_amount"));    //No I18N
            }
            if (lineItems.getJSONObject(i).has("tax_exemption_id")) {
                lineItem.setTaxExemptionId(lineItems.getJSONObject(i).getString("tax_exemption_id"));
            }

            lineItemsList.add(i, lineItem);
        }

        estimates.setLineItems(lineItemsList);

        estimates.setShippingCharge(estimate.getDouble("shipping_charge"));    //No I18N
        estimates.setAdjustment(estimate.getDouble("adjustment"));        //No I18N
        estimates.setAdjustmentDescription(estimate.getString("adjustment_description"));
        estimates.setSubTotal(estimate.getDouble("sub_total")); //No I18N
        estimates.setTotal(estimate.getDouble("total"));    //No I18N
        estimates.setTaxTotal(estimate.getDouble("tax_total"));    //No I18N
        estimates.setPricePrecision(estimate.getInt("price_precision")); //No I18N

        JSONArray taxes = estimate.getJSONArray("taxes"); //No I18N

        List<Tax> taxesList = new ArrayList<Tax>();

        for (int k = 0; k < taxes.length(); k++) {
            Tax tax = new Tax();

            tax.setTaxName(taxes.getJSONObject(k).getString("tax_name"));
            tax.setTaxAmount(taxes.getJSONObject(k).getDouble("tax_amount")); //No I18N

            taxesList.add(k, tax);
        }

        estimates.setTaxes(taxesList);

        JSONObject billingAddress = estimate.getJSONObject("billing_address"); //No I18N

        Address billingAddressObj = new Address();

        billingAddressObj.setAddress(billingAddress.getString("address"));
        billingAddressObj.setCity(billingAddress.getString("city"));
        billingAddressObj.setState(billingAddress.getString("state"));
        billingAddressObj.setZip(billingAddress.getString("zip"));
        billingAddressObj.setCountry(billingAddress.getString("country"));
        billingAddressObj.setFax(billingAddress.getString("fax"));

        estimates.setBillingAddress(billingAddressObj);

        JSONObject shippingAddress = estimate.getJSONObject("shipping_address"); //No I18N

        Address shippingAddressObj = new Address();

        shippingAddressObj.setAddress(shippingAddress.getString("address"));
        shippingAddressObj.setCity(shippingAddress.getString("city"));
        shippingAddressObj.setState(shippingAddress.getString("state"));
        shippingAddressObj.setZip(shippingAddress.getString("zip"));
        shippingAddressObj.setCountry(shippingAddress.getString("country"));
        shippingAddressObj.setFax(shippingAddress.getString("fax"));

        estimates.setShippingAddress(shippingAddressObj);

        estimates.setNotes(estimate.getString("notes"));
        estimates.setTerms(estimate.getString("terms"));

        JSONArray customFields = estimate.getJSONArray("custom_fields"); //No I18N

        List<CustomField> customFieldsList = new ArrayList<CustomField>();

        for (int m = 0; m < customFields.length(); m++) {
            CustomField customField = new CustomField();

            customField.setIndex(customFields.getJSONObject(m).getInt("index")); //No I18N
            customField.setValue(customFields.getJSONObject(m).getString("value"));
            customField.setShowOnPdf(customFields.getJSONObject(m).getBoolean("show_on_pdf")); //No I18N
            customField.setLabel(customFields.getJSONObject(m).getString("label"));

            customFieldsList.add(m, customField);
        }

        estimates.setCustomFields(customFieldsList);

        estimates.setTemplateId(estimate.getString("template_id"));
        estimates.setTemplateName(estimate.getString("template_name"));
        estimates.setCreatedTime(estimate.getString("created_time"));
        estimates.setLastModifiedTime(estimate.getString("last_modified_time"));
        estimates.setSalespersonId(estimate.getString("salesperson_id"));
        estimates.setSalespersonName(estimate.getString("salesperson_name"));

        if (estimate.has("currency_symbol")) {
            estimates.setCurrencySymbol(estimate.getString("currency_symbol"));
        }
        if (estimate.has("template_type")) {
            estimates.setTemplateType(estimate.getString("template_type"));
        }
        if (estimate.has("allow_partial_payments")) {
            estimates.setAllowPartialPayments(estimate.getBoolean("allow_partial_payments"));    //No I18N
        }
        if (estimate.has("accept_retainer")) {
            estimates.setAcceptRetainer(estimate.getBoolean("accept_retainer"));    //No I18N
        }
        if (estimate.has("retainer_percentage")) {
            estimates.setRetainerPercentage(estimate.getString("retainer_percentage"));
        }
        if (estimate.has("is_viewed_by_client")) {
            estimates.setIsViewedByClient(estimate.getBoolean("is_viewed_by_client"));    //No I18N
        }
        if (estimate.has("client_viewed_time")) {
            estimates.setClientViewedTime(estimate.getString("client_viewed_time"));
        }

        if (estimate.has("payment_options")) {
            JSONObject paymentOptions = estimate.getJSONObject("payment_options");    //No I18N

            if (paymentOptions.has("payment_gateways")) {
                JSONArray paymentGateways = paymentOptions.getJSONArray("payment_gateways");    //No I18N

                List<PaymentGateway> paymentGatewaysList = new ArrayList<PaymentGateway>();

                PaymentGateway paymentGateway = new PaymentGateway();

                for (int i = 0; i < paymentGateways.length(); i++) {
                    if (paymentGateways.getJSONObject(i).has("gateway_name")) {
                        paymentGateway.setGatewayName(paymentGateways.getJSONObject(i).getString("gateway_name"));
                    }
                    if (paymentGateways.getJSONObject(i).has("additional_field1")) {
                        paymentGateway.setAdditionalField1(paymentGateways.getJSONObject(i).getString("additional_field1"));
                    }
                    if (paymentGateways.getJSONObject(i).has("configured")) {
                        paymentGateway.setConfigured(paymentGateways.getJSONObject(i).getBoolean("configured"));    //No I18N
                    }

                    paymentGatewaysList.add(paymentGateway);
                }

                estimates.setPaymentGateways(paymentGatewaysList);
            }
        }

        if (estimate.has("tax_id")) {
            estimates.setTaxId(estimate.getString("tax_id"));
        }
        if (estimate.has("tax_authority_id")) {
            estimates.setTaxAuthorityId(estimate.getString("tax_authority_id"));
        }
        if (estimate.has("tax_exemption_id")) {
            estimates.setTaxExemptionId(estimate.getString("tax_exemption_id"));
        }

        return estimates;
    }

    /**
     * Parse the json response and returns the EstimateList object.
     *
     * @param response This json response contains list of estimates details.
     * @return Returns the EstimateList object.
     */

    public EstimateList getEstimates(String response) throws Exception {

        EstimateList estimateList = new EstimateList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("estimates"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Estimate estimate = new Estimate();

            estimate.setEstimateId(jsonArray.getJSONObject(i).getString("estimate_id"));
            estimate.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            estimate.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            estimate.setStatus(jsonArray.getJSONObject(i).getString("status"));
            estimate.setEstimateNumber(jsonArray.getJSONObject(i).getString("estimate_number"));
            estimate.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            estimate.setDate(jsonArray.getJSONObject(i).getString("date"));
            estimate.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            estimate.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            estimate.setTotal(jsonArray.getJSONObject(i).getDouble("total"));         //No I18N
            estimate.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));
            estimate.setAcceptedDate(jsonArray.getJSONObject(i).getString("accepted_date"));
            estimate.setDeclinedDate(jsonArray.getJSONObject(i).getString("declined_date"));
            estimate.setExpiryDate(jsonArray.getJSONObject(i).getString("expiry_date"));
            if (jsonArray.getJSONObject(i).has("is_viewed_by_client")) {
                estimate.setIsViewedByClient(jsonArray.getJSONObject(i).getBoolean("is_viewed_by_client"));    //No I18N
            }
            if (jsonArray.getJSONObject(i).has("client_viewed_time")) {
                estimate.setClientViewedTime(jsonArray.getJSONObject(i).getString("client_viewed_time"));
            }

            estimateList.add(estimate);
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

        estimateList.setPageContext(pageContext);

        return estimateList;
    }


    /**
     * Parse the json response and returns the Email object.
     *
     * @param response This json response contains the email content details for estimate.
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
            if (fromEmails.getJSONObject(k).has("is_org_email_id")) {
                fromEmail.setOrgEmailId(fromEmails.getJSONObject(k).getBoolean("is_org_email_id")); //No I18N
            }

            fromEmailsList.add(k, fromEmail);
        }

        email.setFromEmails(fromEmailsList);

        if (data.has("attach_pdf")) {
            email.setAttachPdf(data.getBoolean("attach_pdf"));    //No I18N
        }
        if (data.has("customer_name")) {
            email.setCustomerName(data.getString("customer_name"));
        }
        if (data.has("file_name_without_extension")) {
            email.setFileNameWithoutExtension(data.getString("file_name_without_extension"));
        }

        return email;
    }

    /**
     * Parse the json response and returns the TemplateList object.
     *
     * @param response This json response contains list of templates details for estimate.
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
     * Parse the json respone and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for estimate.
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

            comment.setEstimateId(jsonArray.getJSONObject(i).getString("estimate_id"));
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
     * Parse the json respone and returns the Comment object.
     *
     * @param response This json response contains the comment details for estimate.
     * @return Returns the Comment object.
     */

    public Comment getComment(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject comment = jsonObject.getJSONObject("comment"); //No I18N

        Comment comments = new Comment();

        comments.setCommentId(comment.getString("comment_id"));
        comments.setDescription(comment.getString("description"));
        comments.setEstimateId(comment.getString("estimate_id"));
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
}
