/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Parse the JSON response and make it into the respective objects.
 *
 * @author ramesh-2099
 */

public class PurchaseOrderParser {


    /**
     * Parse the JSON response and make it into the PurchaseOrderList object.
     *
     * @param response JSON response contains the details of list of purchase orders.
     * @return Returns the PurchaseOrderList object.
     * @throws Exception
     */

    public PurchaseOrderList getPurchaseOrders(String response) throws Exception {

        JSONObject jsonObject = new JSONObject(response.trim());

        PurchaseOrderList purchaseOrderList = new PurchaseOrderList();

        if (jsonObject.has("purchaseorders")) {
            JSONArray purchaseorders = jsonObject.getJSONArray("purchaseorders");    //No I18N

            for (int i = 0; i < purchaseorders.length(); i++) {
                purchaseOrderList.add(this.jsonToPurchaseOrder(purchaseorders.getJSONObject(i)));
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

            purchaseOrderList.setPageContext(pageContext);
        }

        return purchaseOrderList;

    }

    /**
     * Parse the JSON response and make it into the PurchaseOrder object.
     *
     * @param response JSON response contains the details of the purchase order.
     * @return Returns the PurchaseOrder object.
     * @throws Exception
     */

    public PurchaseOrder getPurchaseOrder(String response) throws Exception {

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject purchaseorder = jsonObject.getJSONObject("purchaseorder");    //No I18N

        return this.jsonToPurchaseOrder(purchaseorder);

    }

    /**
     * Parse the JSONObject into PurchaseOrder object.
     *
     * @param jsonObject JSONObject contains the details of the purchase order.
     * @return Returns the PurchaseOrder object.
     * @throws JSONException
     */

    public PurchaseOrder jsonToPurchaseOrder(JSONObject jsonObject) throws JSONException {

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        if (jsonObject.has("purchaseorder_id")) {
            purchaseOrder.setPurchaseorderId(jsonObject.getString("purchaseorder_id"));
        }
        if (jsonObject.has("vendor_id")) {
            purchaseOrder.setVendorId(jsonObject.getString("vendor_id"));
        }
        if (jsonObject.has("vendor_name")) {
            purchaseOrder.setVendorName(jsonObject.getString("vendor_name"));
        }
        if (jsonObject.has("status")) {
            purchaseOrder.setStatus(jsonObject.getString("status"));
        }
        if (jsonObject.has("purchaseorder_number")) {
            purchaseOrder.setPurchaseorderNumber(jsonObject.getString("purchaseorder_number"));
        }
        if (jsonObject.has("reference_number")) {
            purchaseOrder.setReferenceNumber(jsonObject.getString("reference_number"));
        }
        if (jsonObject.has("date")) {
            purchaseOrder.setDate(jsonObject.getString("date"));
        }
        if (jsonObject.has("delivery_date")) {
            purchaseOrder.setDeliveryDate(jsonObject.getString("delivery_date"));
        }
        if (jsonObject.has("currency_id")) {
            purchaseOrder.setCurrencyId(jsonObject.getString("currency_id"));
        }
        if (jsonObject.has("currency_code")) {
            purchaseOrder.setCurrencyCode(jsonObject.getString("currency_code"));
        }
        if (jsonObject.has("price_precision")) {
            if (!jsonObject.get("price_precision").equals("")) {
                purchaseOrder.setPricePrecision(jsonObject.getInt("price_precision"));    //No I18N
            }
        }
        if (jsonObject.has("total")) {
            purchaseOrder.setTotal(jsonObject.getDouble("total"));    //No I18N
        }
        if (jsonObject.has("created_time")) {
            purchaseOrder.setCreatedTime(jsonObject.getString("created_time"));
        }
        if (jsonObject.has("last_modified_time")) {
            purchaseOrder.setLastModifiedTime(jsonObject.getString("last_modified_time"));
        }


        if (jsonObject.has("expected_delivery_date")) {
            purchaseOrder.setExpectedDeliveryDate(jsonObject.getString("expected_delivery_date"));
        }
        if (jsonObject.has("currency_symbol")) {
            purchaseOrder.setCurrencySymbol(jsonObject.getString("currency_symbol"));
        }
        if (jsonObject.has("exchange_rate")) {
            purchaseOrder.setExchangeRate(jsonObject.getDouble("exchange_rate"));    //No I18N
        }
        if (jsonObject.has("is_emailed")) {
            purchaseOrder.setEmailed(jsonObject.getBoolean("is_emailed"));    //No I18N
        }
        if (jsonObject.has("sub_total")) {
            purchaseOrder.setSubTotal(jsonObject.getDouble("sub_total"));    //No I18N
        }
        if (jsonObject.has("tax_total")) {
            purchaseOrder.setTaxTotal(jsonObject.getDouble("tax_total"));    //No I18N
        }
        if (jsonObject.has("notes")) {
            purchaseOrder.setNotes(jsonObject.getString("notes"));
        }
        if (jsonObject.has("terms")) {
            purchaseOrder.setTerms(jsonObject.getString("terms"));
        }
        if (jsonObject.has("ship_via")) {
            purchaseOrder.setShipVia(jsonObject.getString("ship_via"));
        }
        if (jsonObject.has("ship_via_id")) {
            purchaseOrder.setShipViaId(jsonObject.getString("ship_via_id"));
        }
        if (jsonObject.has("attention")) {
            purchaseOrder.setAttention(jsonObject.getString("attention"));
        }
        if (jsonObject.has("delivery_org_address_id")) {
            purchaseOrder.setDeliveryOrgAddressId(jsonObject.getString("delivery_org_address_id"));
        }
        if (jsonObject.has("delivery_customer_id")) {
            purchaseOrder.setDeliveryCustomerId(jsonObject.getString("delivery_customer_id"));
        }
        if (jsonObject.has("attachment_name")) {
            purchaseOrder.setAttachmentName(jsonObject.getString("attachment_name"));
        }
        if (jsonObject.has("can_send_in_mail")) {
            purchaseOrder.setCanSendInMail(jsonObject.getBoolean("can_send_in_mail"));    //No I18N
        }
        if (jsonObject.has("template_id")) {
            purchaseOrder.setTemplateId(jsonObject.getString("template_id"));
        }
        if (jsonObject.has("template_name")) {
            purchaseOrder.setTemplateName(jsonObject.getString("template_name"));
        }
        if (jsonObject.has("template_type")) {
            purchaseOrder.setTemplateType(jsonObject.getString("template_type"));
        }
        if (jsonObject.has("can_mark_as_bill")) {
            purchaseOrder.setCanMarkAsBill(jsonObject.getBoolean("can_mark_as_bill"));    //No I18N
        }
        if (jsonObject.has("can_mark_as_unbill")) {
            purchaseOrder.setCanMarkAsUnbill(jsonObject.getBoolean("can_mark_as_unbill"));    //No I18N
        }

        if (jsonObject.has("contact_persons")) {

            JSONArray contactpersons = jsonObject.getJSONArray("contact_persons");    //No I18N

            String[] contactPersons = new String[contactpersons.length()];

            for (int i = 0; i < contactpersons.length(); i++) {
                contactPersons[i] = contactpersons.getString(i);
            }

            purchaseOrder.setContactPersons(contactPersons);
        }

        if (jsonObject.has("line_items")) {
            JSONArray lineitems = jsonObject.getJSONArray("line_items");    //No I18N

            List<LineItem> lineItems = new ArrayList<LineItem>(lineitems.length());

            for (int i = 0; i < lineitems.length(); i++) {
                lineItems.add(this.jsonToLineItem(lineitems.getJSONObject(i)));
            }

            purchaseOrder.setLineItems(lineItems);
        }

        if (jsonObject.has("taxes")) {
            JSONArray taxes = jsonObject.getJSONArray("taxes");    //No I18N

            List<Tax> taxList = new ArrayList<Tax>(taxes.length());

            for (int i = 0; i < taxes.length(); i++) {
                taxList.add(this.jsonToTax(taxes.getJSONObject(i)));
            }

            purchaseOrder.setTaxes(taxList);
        }

        if (jsonObject.has("custom_fields")) {
            JSONArray customfields = jsonObject.getJSONArray("custom_fields");    //No I18N

            List<CustomField> customFields = new ArrayList<CustomField>(customfields.length());

            for (int i = 0; i < customfields.length(); i++) {
                customFields.add(this.jsonToCustomField(customfields.getJSONObject(i)));
            }

            purchaseOrder.setCustomFields(customFields);

        }

        if (jsonObject.has("billing_address")) {
            JSONObject billingAddress = jsonObject.getJSONObject("billing_address");    //No I18N

            purchaseOrder.setBillingAddress(this.jsonToAddress(billingAddress));
        }

        if (jsonObject.has("delivery_address")) {
            JSONObject shippingAddress = jsonObject.getJSONObject("delivery_address");    //No I18N

            purchaseOrder.setDeliveryAddress(this.jsonToAddress(shippingAddress));
        }

        return purchaseOrder;

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
        if (jsonObject.has("organization_address_id")) {
            address.setOrganizationAddressId(jsonObject.getString("organization_address_id"));
        }

        return address;

    }

    /**
     * Parse the JSON response and make it into the Email object.
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
        if (data.has("customer_id")) {
            email.setCustomerId(data.getString("customer_id"));
        }

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
        if (data.has("attachment_name")) {
            email.setAttachmentName(data.getString("attachment_name"));
        }
        if (data.has("vendor_id")) {
            email.setVendorId(data.getString("vendor_id"));
        }
        if (data.has("vendor_name")) {
            email.setVendorName(data.getString("vendor_name"));
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
