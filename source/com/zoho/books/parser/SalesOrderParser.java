/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * SalesOrderParser is used to parse the JSON response into respective objects.
 *
 * @author ramesh-2099
 */

public class SalesOrderParser {


    /**
     * Parse the JSON response and make it into the SalesOrderList object.
     *
     * @param response JSON response contains the details of list of sales orders.
     * @return Returns the SalesOrderList object.
     * @throws JSONException
     */

    public SalesOrderList getSalesOrders(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response.trim());

        SalesOrderList salesOrderList = new SalesOrderList();

        if (jsonObject.has("salesorders")) {
            JSONArray salesorders = jsonObject.getJSONArray("salesorders");    //No I18N

            for (int i = 0; i < salesorders.length(); i++) {
                salesOrderList.add(this.jsonToSalesOrder(salesorders.getJSONObject(i)));
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
            if (pagecontext.has("applied_filter")) {
                pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
            }
            if (pagecontext.has("sort_column")) {
                pageContext.setSortColumn(pagecontext.getString("sort_column"));
            }
            if (pagecontext.has("sort_order")) {
                pageContext.setSortOrder(pagecontext.getString("sort_order"));
            }

            salesOrderList.setPageContext(pageContext);
        }

        return salesOrderList;

    }

    /**
     * Parse the JSON response and make it into SalesOrder object.
     *
     * @param response JSON response contains the details of the sales order.
     * @return Returns the SalesOrder object.
     * @throws JSONException
     */

    public SalesOrder getSalesOrder(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject salesorder = jsonObject.getJSONObject("salesorder");    //No I18N

        return this.jsonToSalesOrder(salesorder);

    }

    /**
     * Parse the JSONObject into SalesOrder object.
     *
     * @param jsonObject JSONObject contains the details of the sales order.
     * @return Returns the SalesOrder object.
     * @throws JSONException
     */

    public SalesOrder jsonToSalesOrder(JSONObject jsonObject) throws JSONException {

        SalesOrder salesOrder = new SalesOrder();

        if (jsonObject.has("salesorder_id")) {
            salesOrder.setSalesorderId(jsonObject.getString("salesorder_id"));
        }
        if (jsonObject.has("customer_name")) {
            salesOrder.setCustomerName(jsonObject.getString("customer_name"));
        }
        if (jsonObject.has("customer_id")) {
            salesOrder.setCustomerId(jsonObject.getString("customer_id"));
        }
        if (jsonObject.has("status")) {
            salesOrder.setStatus(jsonObject.getString("status"));
        }
        if (jsonObject.has("salesorder_number")) {
            salesOrder.setSalesorderNumber(jsonObject.getString("salesorder_number"));
        }
        if (jsonObject.has("reference_number")) {
            salesOrder.setReferenceNumber(jsonObject.getString("reference_number"));
        }
        if (jsonObject.has("date")) {
            salesOrder.setDate(jsonObject.getString("date"));
        }
        if (jsonObject.has("shipment_date")) {
            salesOrder.setShipmentDate(jsonObject.getString("shipment_date"));
        }
        if (jsonObject.has("shipment_days")) {
            salesOrder.setShipmentDays(jsonObject.getString("shipment_days"));
        }
        if (jsonObject.has("currency_id")) {
            salesOrder.setCurrencyId(jsonObject.getString("currency_id"));
        }
        if (jsonObject.has("currency_code")) {
            salesOrder.setCurrencyCode(jsonObject.getString("currency_code"));
        }
        if (jsonObject.has("total")) {
            salesOrder.setTotal(jsonObject.getDouble("total"));    //No I18N
        }
        if (jsonObject.has("bcy_total")) {
            salesOrder.setBcyTotal(jsonObject.getDouble("bcy_total"));    //No I18N
        }
        if (jsonObject.has("created_time")) {
            salesOrder.setCreatedTime(jsonObject.getString("created_time"));
        }
        if (jsonObject.has("last_modified_time")) {
            salesOrder.setLastModifiedTime(jsonObject.getString("last_modified_time"));
        }
        if (jsonObject.has("is_emailed")) {
            salesOrder.setEmailed(jsonObject.getBoolean("is_emailed"));    //No I18N
        }


        if (jsonObject.has("currency_symbol")) {
            salesOrder.setCurrencySymbol(jsonObject.getString("currency_symbol"));
        }
        if (jsonObject.has("exchange_rate")) {
            salesOrder.setExchangeRate(jsonObject.getDouble("exchange_rate"));    //No I18N
        }
        if (jsonObject.has("discount")) {
            salesOrder.setDiscount(jsonObject.getDouble("discount"));    //No I18N
        }
        if (jsonObject.has("is_discount_before_tax")) {
            salesOrder.setDiscountBeforeTax(jsonObject.getBoolean("is_discount_before_tax"));    //No I18N
        }
        if (jsonObject.has("discount_type")) {
            salesOrder.setDiscountType(jsonObject.getString("discount_type"));
        }
        if (jsonObject.has("estimate_id")) {
            salesOrder.setEstimateId(jsonObject.getString("estimate_id"));
        }
        if (jsonObject.has("delivery_method")) {
            salesOrder.setDeliveryMethod(jsonObject.getString("delivery_method"));
        }
        if (jsonObject.has("delivery_method_id")) {
            salesOrder.setDeliveryMethodId(jsonObject.getString("delivery_method_id"));
        }
        if (jsonObject.has("shipping_charge")) {
            salesOrder.setShippingCharge(jsonObject.getDouble("shipping_charge"));    //No I18N
        }
        if (jsonObject.has("adjustment")) {
            salesOrder.setAdjustment(jsonObject.getDouble("adjustment"));    //No I18N
        }
        if (jsonObject.has("adjustment_description")) {
            salesOrder.setAdjustmentDescription(jsonObject.getString("adjustment_description"));
        }
        if (jsonObject.has("sub_total")) {
            salesOrder.setSubTotal(jsonObject.getDouble("sub_total"));    //No I18N
        }
        if (jsonObject.has("tax_total")) {
            salesOrder.setTaxTotal(jsonObject.getDouble("tax_total"));    //No I18N
        }
        if (jsonObject.has("price_precision")) {
            salesOrder.setPricePrecision(jsonObject.getInt("price_precision"));    //No I18N
        }
        if (jsonObject.has("notes")) {
            salesOrder.setNotes(jsonObject.getString("notes"));
        }
        if (jsonObject.has("terms")) {
            salesOrder.setTerms(jsonObject.getString("terms"));
        }
        if (jsonObject.has("template_id")) {
            salesOrder.setTemplateId(jsonObject.getString("template_id"));
        }
        if (jsonObject.has("template_name")) {
            salesOrder.setTemplateName(jsonObject.getString("template_name"));
        }
        if (jsonObject.has("template_type")) {
            salesOrder.setTemplateType(jsonObject.getString("template_type"));
        }
        if (jsonObject.has("attachment_name")) {
            salesOrder.setAttachmentName(jsonObject.getString("attachment_name"));
        }
        if (jsonObject.has("can_send_in_mail")) {
            salesOrder.setCanSendInMail(jsonObject.getBoolean("can_send_in_mail"));    //No I18N
        }
        if (jsonObject.has("salesperson_id")) {
            salesOrder.setSalespersonId(jsonObject.getString("salesperson_id"));
        }
        if (jsonObject.has("salesperson_name")) {
            salesOrder.setSalespersonName(jsonObject.getString("salesperson_name"));
        }

        if (jsonObject.has("contact_persons")) {
            JSONArray contactpersons = jsonObject.getJSONArray("contact_persons");    //No I18N

            String[] contactPersons = new String[contactpersons.length()];

            for (int i = 0; i < contactpersons.length(); i++) {
                contactPersons[i] = contactpersons.getString(i);
            }

            salesOrder.setContactPersons(contactPersons);
        }

        if (jsonObject.has("line_items")) {
            JSONArray lineitems = jsonObject.getJSONArray("line_items");    //No I18N

            List<LineItem> lineItems = new ArrayList<LineItem>(lineitems.length());

            for (int i = 0; i < lineitems.length(); i++) {
                lineItems.add(this.jsonToLineItem(lineitems.getJSONObject(i)));
            }

            salesOrder.setLineItems(lineItems);
        }

        if (jsonObject.has("taxes")) {
            JSONArray taxes = jsonObject.getJSONArray("taxes");    //No I18N

            List<Tax> taxList = new ArrayList<Tax>(taxes.length());

            for (int i = 0; i < taxes.length(); i++) {
                taxList.add(this.jsonToTax(taxes.getJSONObject(i)));
            }

            salesOrder.setTaxes(taxList);
        }

        if (jsonObject.has("custom_fields")) {
            JSONArray customfields = jsonObject.getJSONArray("custom_fields");    //No I18N

            List<CustomField> customFields = new ArrayList<CustomField>(customfields.length());

            for (int i = 0; i < customfields.length(); i++) {
                customFields.add(this.jsonToCustomField(customfields.getJSONObject(i)));
            }

            salesOrder.setCustomFields(customFields);

        }

        if (jsonObject.has("billing_address")) {
            JSONObject billingAddress = jsonObject.getJSONObject("billing_address");    //No I18N

            salesOrder.setBillingAddress(this.jsonToAddress(billingAddress));
        }

        if (jsonObject.has("shipping_address")) {
            JSONObject shippingAddress = jsonObject.getJSONObject("shipping_address");    //No I18N

            salesOrder.setShippingAddress(this.jsonToAddress(shippingAddress));
        }

        return salesOrder;

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
        if (jsonObject.has("is_invoiced")) {
            lineItem.setInvoiced(jsonObject.getBoolean("is_invoiced"));    //No I18N
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
     * Parse the JSONObject into CustomField object.
     *
     * @param jsonObject JSONObject contains the details of the custom field.
     * @return Returns the CustomField object.
     * @throws JSONException
     */

    public CustomField jsonToCustomField(JSONObject jsonObject) throws JSONException {

        CustomField customField = new CustomField();

        if (jsonObject.has("index")) {
            customField.setIndex(jsonObject.getInt("index"));    //No I18N
        }
        if (jsonObject.has("show_on_pdf")) {
            customField.setShowOnPdf(jsonObject.getBoolean("show_on_pdf"));    //No I18N
        }
        if (jsonObject.has("value")) {
            customField.setValue(jsonObject.getString("value"));
        }
        if (jsonObject.has("label")) {
            customField.setLabel(jsonObject.getString("label"));
        }

        return customField;

    }

    /**
     * Parse the JSONObject into Address object.
     *
     * @param jsonObject JSONObject contains the details of the shipping or billing address.
     * @return Returns the Address object.
     * @throws JSONException
     */

    public Address jsonToAddress(JSONObject jsonObject) throws JSONException {

        Address address = new Address();

        if (jsonObject.has("address")) {
            address.setAddress(jsonObject.getString("address"));
        }
        if (jsonObject.has("city")) {
            address.setCity(jsonObject.getString("city"));
        }
        if (jsonObject.has("state")) {
            address.setState(jsonObject.getString("state"));
        }
        if (jsonObject.has("zip")) {
            address.setZip(jsonObject.getString("zip"));
        }
        if (jsonObject.has("country")) {
            address.setCountry(jsonObject.getString("country"));
        }
        if (jsonObject.has("fax")) {
            address.setFax(jsonObject.getString("fax"));
        }

        return address;

    }


    /**
     * Parse the JSON response into Email object.
     *
     * @param response JSON response contains the details of the email content.
     * @return Returns the Email object.
     * @throws Exception
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
     * Parse the JSON response into TemplateList object.
     *
     * @param response JSON response contains the details of list of templates.
     * @return Returns the TemplateList object.
     * @throws Exception
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

        return comment;

    }

    /**
     * Parse the JSON response and make it into the String object.
     *
     * @param response JSON response contains the success message.
     * @return Returns the success message.
     * @throws JSONException
     */

    public String getMessage(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response.trim());

        String message = jsonObject.getString("message");

        return message;

    }

}
