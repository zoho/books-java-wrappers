/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactParser is used to parse the json response and make it into the respective objects.
 */

public class ContactParser {

    /**
     * Parse the json response and returns the Contact object.
     *
     * @param response This json Response contains the contact details.
     * @return Returns the Contact object.
     */

    public Contact getContact(String response) throws Exception {
        Contact contacts = new Contact();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject contact = jsonObject.getJSONObject("contact");    //No I18N

        contacts.setContactId(contact.getString("contact_id"));
        contacts.setContactName(contact.getString("contact_name"));
        contacts.setCompanyName(contact.getString("company_name"));
        contacts.setHasTransaction(contact.getBoolean("has_transaction"));    //No I18N
        contacts.setContactType(contact.getString("contact_type"));
        contacts.setIsCrmCustomer(contact.getBoolean("is_crm_customer"));    //No I18N
        contacts.setPrimaryContactId(contact.getString("primary_contact_id"));
        contacts.setPaymentTerms(contact.getInt("payment_terms"));        //No I18N
        contacts.setPaymentTermsLabel(contact.getString("payment_terms_label"));
        contacts.setCurrencyId(contact.getString("currency_id"));
        contacts.setCurrencyCode(contact.getString("currency_code"));
        contacts.setCurrencySymbol(contact.getString("currency_symbol"));
        contacts.setOutstandingReceivableAmount(contact.getDouble("outstanding_receivable_amount"));        //No I18N
        contacts.setOutstandingReceivableAmountBcy(contact.getDouble("outstanding_receivable_amount_bcy"));    //No I18N
        contacts.setUnusedCreditsReceivableAmount(contact.getDouble("unused_credits_receivable_amount"));    //No I18N
        contacts.setUnusedCreditsReceivableAmountBcy(contact.getDouble("unused_credits_receivable_amount_bcy"));//No I18N
        contacts.setStatus(contact.getString("status"));
        contacts.setPaymentReminderEnabled(contact.getBoolean("payment_reminder_enabled"));    //No I18N
        contacts.setNotes(contact.getString("notes"));
        contacts.setCreatedTime(contact.getString("created_time"));
        contacts.setLastModifiedTime(contact.getString("last_modified_time"));

        if (contact.has("website")) {
            contacts.setWebsite(contact.getString("website"));
        }
        if (contact.has("contact_salutation")) {
            contacts.setContactSalutation(contact.getString("contact_salutation"));
        }
        if (contact.has("source")) {
            contacts.setSource(contact.getString("source"));
        }
        if (contact.has("is_linked_with_zohocrm")) {
            contacts.setLinkedWithZohocrm(contact.getBoolean("is_linked_with_zohocrm"));    //No I18N
        }
        if (contact.has("price_precision")) {
            contacts.setPricePrecision(contact.getInt("price_precision"));    //No I18N
        }
        if (contact.has("pricebook_id")) {
            contacts.setPricebookId(contact.getString("pricebook_id"));
        }
        if (contact.has("pricebook_name")) {
            contacts.setPricebookName(contact.getString("pricebook_name"));
        }
        if (contact.has("associated_with_square")) {
            contacts.setAssociatedWithSquare(contact.getBoolean("associated_with_square"));    //No I18N
        }

        if (contact.has("track_1099")) {
            contacts.setTrack1099(contact.getBoolean("track_1099"));    //No I18N
        }
        if (contact.has("tax_id_type")) {
            contacts.setTaxIdType(contact.getString("tax_id_type"));
        }
        if (contact.has("tax_id_value")) {
            contacts.setTaxIdValue(contact.getString("tax_id_value"));
        }
        if (contact.has("is_taxable")) {
            contacts.setTaxable(contact.getBoolean("is_taxable"));    //No I18N
        }
        if (contact.has("tax_id")) {
            contacts.setTaxId(contact.getString("tax_id"));
        }
        if (contact.has("tax_authority_id")) {
            contacts.setTaxAuthorityId(contact.getString("tax_authority_id"));
        }
        if (contact.has("tax_exemption_id")) {
            contacts.setTaxExemptionId(contact.getString("tax_exemption_id"));
        }

        JSONObject billingAddress = contact.getJSONObject("billing_address");    //No I18N

        Address billingAddressObj = new Address();

        billingAddressObj.setAddress(billingAddress.getString("address"));
        billingAddressObj.setCity(billingAddress.getString("city"));
        billingAddressObj.setState(billingAddress.getString("state"));
        billingAddressObj.setZip(billingAddress.getString("zip"));
        billingAddressObj.setCountry(billingAddress.getString("country"));
        billingAddressObj.setFax(billingAddress.getString("fax"));

        contacts.setBillingAddress(billingAddressObj);

        JSONObject shippingAddress = contact.getJSONObject("shipping_address"); //No I18N

        Address shippingAddressObj = new Address();

        shippingAddressObj.setAddress(shippingAddress.getString("address"));
        shippingAddressObj.setCity(shippingAddress.getString("city"));
        shippingAddressObj.setState(shippingAddress.getString("state"));
        shippingAddressObj.setZip(shippingAddress.getString("zip"));
        shippingAddressObj.setCountry(shippingAddress.getString("country"));
        shippingAddressObj.setFax(shippingAddress.getString("fax"));

        contacts.setShippingAddress(shippingAddressObj);

        JSONArray contactPersons = contact.getJSONArray("contact_persons"); //No I18N

        List<ContactPerson> contactPersonsList = new ArrayList<ContactPerson>();

        for (int i = 0; i < contactPersons.length(); i++) {
            ContactPerson contactPerson = new ContactPerson();

            contactPerson.setContactPersonId(contactPersons.getJSONObject(i).getString("contact_person_id"));
            contactPerson.setSalutation(contactPersons.getJSONObject(i).getString("salutation"));
            contactPerson.setFirstName(contactPersons.getJSONObject(i).getString("first_name"));
            contactPerson.setLastName(contactPersons.getJSONObject(i).getString("last_name"));
            contactPerson.setEmail(contactPersons.getJSONObject(i).getString("email"));
            contactPerson.setPhone(contactPersons.getJSONObject(i).getString("phone"));
            contactPerson.setMobile(contactPersons.getJSONObject(i).getString("mobile"));
            contactPerson.setIsPrimaryContact(contactPersons.getJSONObject(i).getBoolean("is_primary_contact")); //No I18N
            if (contactPersons.getJSONObject(i).has("is_added_in_portal")) {
                contactPerson.setAddedInPortal(contactPersons.getJSONObject(i).getBoolean("is_added_in_portal"));    //No I18N
            }
            if (contactPersons.getJSONObject(i).has("can_invite")) {
                contactPerson.setCanInvite(contactPersons.getJSONObject(i).getBoolean("can_invite"));    //No I18N
            }

            contactPersonsList.add(i, contactPerson);
        }

        contacts.setContactPersons(contactPersonsList);

        JSONObject defaultTemplates = contact.getJSONObject("default_templates"); //No I18N

        DefaultTemplate defaultTemplatesObj = new DefaultTemplate();

        defaultTemplatesObj.setInvoiceTemplateId(defaultTemplates.getString("invoice_template_id"));
        defaultTemplatesObj.setInvoiceTemplateName(defaultTemplates.getString("invoice_template_name"));
        defaultTemplatesObj.setEstimateTemplateId(defaultTemplates.getString("estimate_template_id"));
        defaultTemplatesObj.setEstimateTemplateName(defaultTemplates.getString("estimate_template_name"));
        defaultTemplatesObj.setCreditnoteTemplateId(defaultTemplates.getString("creditnote_template_id"));
        defaultTemplatesObj.setCreditnoteTemplateName(defaultTemplates.getString("creditnote_template_name"));
        defaultTemplatesObj.setInvoiceEmailTemplateId(defaultTemplates.getString("invoice_email_template_id"));
        defaultTemplatesObj.setInvoiceEmailTemplateName(defaultTemplates.getString("invoice_email_template_name"));
        defaultTemplatesObj.setEstimateEmailTemplateId(defaultTemplates.getString("estimate_email_template_id"));
        defaultTemplatesObj.setEstimateEmailTemplateName(defaultTemplates.getString("estimate_email_template_name"));
        defaultTemplatesObj.setCreditnoteEmailTemplateId(defaultTemplates.getString("creditnote_email_template_id"));
        defaultTemplatesObj.setCreditnoteEmailTemplateName(defaultTemplates.getString("creditnote_email_template_name"));

        contacts.setDefaultTemplates(defaultTemplatesObj);

        return contacts;

    }

    /**
     * Parse the json response and returns the ContactList object.
     *
     * @param response This Response contains list of contacts details.
     * @return Returns the ContactList object.
     */

    public ContactList getContacts(String response) throws Exception {
        ContactList contactList = new ContactList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("contacts"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Contact contact = new Contact();

            contact.setContactId(jsonArray.getJSONObject(i).getString("contact_id"));
            contact.setContactName(jsonArray.getJSONObject(i).getString("contact_name"));
            contact.setContactType(jsonArray.getJSONObject(i).getString("contact_type"));
            contact.setStatus(jsonArray.getJSONObject(i).getString("status"));
            contact.setPaymentTerms(jsonArray.getJSONObject(i).getInt("payment_terms"));    //No I18N
            contact.setPaymentTermsLabel(jsonArray.getJSONObject(i).getString("payment_terms_label"));
            contact.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            contact.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            contact.setOutstandingReceivableAmount(jsonArray.getJSONObject(i).getDouble("outstanding_receivable_amount")); //No I18N
            contact.setUnusedCreditsReceivableAmount(jsonArray.getJSONObject(i).getDouble("unused_credits_receivable_amount"));//No I18N
            contact.setFirstName(jsonArray.getJSONObject(i).getString("first_name"));
            contact.setLastName(jsonArray.getJSONObject(i).getString("last_name"));
            contact.setEmail(jsonArray.getJSONObject(i).getString("email"));
            contact.setPhone(jsonArray.getJSONObject(i).getString("phone"));
            contact.setMobile(jsonArray.getJSONObject(i).getString("mobile"));
            contact.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));
            contact.setLastModifiedTime(jsonArray.getJSONObject(i).getString("last_modified_time"));
            if (jsonArray.getJSONObject(i).has("source")) {
                contact.setSource(jsonArray.getJSONObject(i).getString("source"));
            }
            if (jsonArray.getJSONObject(i).has("is_linked_with_zohocrm")) {
                contact.setLinkedWithZohocrm(jsonArray.getJSONObject(i).getBoolean("is_linked_with_zohocrm"));    //No I18N
            }


            contactList.add(contact);

        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        if (pagecontext.has("page")) {
            pageContext.setPage(pagecontext.getInt("page")); //No I18N
        }
        if (pagecontext.has("per_page")) {
            pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        }
        if (pagecontext.has("has_more_page")) {
            pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
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

        contactList.setPageContext(pageContext);

        return contactList;
    }

    /**
     * Parse the given json response and returns the ContactPerson object.
     *
     * @param response This json response contains the contact person details.
     * @return Returns the ContactPerson object.
     */

    public ContactPerson getContactPerson(String response) throws Exception {
        ContactPerson contactPersons = new ContactPerson();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject contactPerson = jsonObject.getJSONObject("contact_person"); //No I18N

        contactPersons.setContactId(contactPerson.getString("contact_id"));
        contactPersons.setContactPersonId(contactPerson.getString("contact_person_id"));
        contactPersons.setSalutation(contactPerson.getString("salutation"));
        contactPersons.setFirstName(contactPerson.getString("first_name"));
        contactPersons.setLastName(contactPerson.getString("last_name"));
        contactPersons.setEmail(contactPerson.getString("email"));
        contactPersons.setPhone(contactPerson.getString("phone"));
        contactPersons.setMobile(contactPerson.getString("mobile"));
        contactPersons.setIsPrimaryContact(contactPerson.getBoolean("is_primary_contact")); //No I18N
        if (contactPerson.has("is_added_in_portal")) {
            contactPersons.setAddedInPortal(contactPerson.getBoolean("is_added_in_portal"));    //No I18N
        }
        if (contactPerson.has("can_invite")) {
            contactPersons.setCanInvite(contactPerson.getBoolean("can_invite"));    //No I18N
        }

        return contactPersons;

    }


    /**
     * Parse the json response and returns the ContactPersonList object.
     *
     * @param response This json response contains list of contact persons details.
     * @return Returns the ContactPersonList object.
     */

    public ContactPersonList getContactPersons(String response) throws Exception {

        ContactPersonList contactPersonList = new ContactPersonList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("contact_persons"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            ContactPerson contactPerson = new ContactPerson();

            contactPerson.setContactPersonId(jsonArray.getJSONObject(i).getString("contact_person_id"));
            contactPerson.setSalutation(jsonArray.getJSONObject(i).getString("salutation"));
            contactPerson.setFirstName(jsonArray.getJSONObject(i).getString("first_name"));
            contactPerson.setLastName(jsonArray.getJSONObject(i).getString("last_name"));
            contactPerson.setEmail(jsonArray.getJSONObject(i).getString("email"));
            contactPerson.setPhone(jsonArray.getJSONObject(i).getString("phone"));
            contactPerson.setMobile(jsonArray.getJSONObject(i).getString("mobile"));
            contactPerson.setIsPrimaryContact(jsonArray.getJSONObject(i).getBoolean("is_primary_contact")); //No I18N
            if (jsonArray.getJSONObject(i).has("is_added_in_portal")) {
                contactPerson.setAddedInPortal(jsonArray.getJSONObject(i).getBoolean("is_added_in_portal")); //No I18N
            }
            if (jsonArray.getJSONObject(i).has("can_invite")) {
                contactPerson.setCanInvite(jsonArray.getJSONObject(i).getBoolean("can_invite"));    //No I18N
            }

            contactPersonList.add(contactPerson);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        contactPersonList.setPageContext(pageContext);

        return contactPersonList;
    }

    /**
     * Parse the json response and returns the Email object.
     *
     * @param response This json response contains the email content details.
     * @return Returns the Email object.
     */

    public Email getEmailContent(String response) throws Exception {
        Email email = new Email();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject data = jsonObject.getJSONObject("data"); //No I18N

        email.setSubject(data.getString("subject"));
        email.setBody(data.getString("body"));
        email.setFileName(data.getString("file_name"));
        if (data.has("file_name_without_extension")) {
            email.setFileNameWithoutExtension(data.getString("file_name_without_extension"));
        }
        if (data.has("entity_id")) {
            email.setEntityId(data.getString("entity_id"));
        }
        email.setContactId(data.getString("contact_id"));

        JSONArray toContacts = data.getJSONArray("to_contacts"); //No I18N

        List<ToContact> toContactsList = new ArrayList<ToContact>();

        for (int i = 0; i < toContacts.length(); i++) {
            ToContact toContact = new ToContact();

            toContact.setFirstName(toContacts.getJSONObject(i).getString("first_name"));
            toContact.setLastName(toContacts.getJSONObject(i).getString("last_name"));
            toContact.setSelected(toContacts.getJSONObject(i).getBoolean("selected")); //No I18N
            toContact.setPhone(toContacts.getJSONObject(i).getString("phone"));
            toContact.setEmail(toContacts.getJSONObject(i).getString("email"));
            toContact.setContactPersonId(toContacts.getJSONObject(i).getString("contact_person_id"));
            toContact.setSalutation(toContacts.getJSONObject(i).getString("salutation"));
            toContact.setMobile(toContacts.getJSONObject(i).getString("mobile"));

            toContactsList.add(i, toContact);
        }

        email.setToContacts(toContactsList);

        JSONArray fromEmails = data.getJSONArray("from_emails"); //No I18N

        List<FromEmail> fromEmailsList = new ArrayList<FromEmail>();

        for (int j = 0; j < fromEmails.length(); j++) {
            FromEmail fromEmail = new FromEmail();

            fromEmail.setUserName(fromEmails.getJSONObject(j).getString("user_name"));
            fromEmail.setSelected(fromEmails.getJSONObject(j).getBoolean("selected")); //No I18N
            fromEmail.setEmail(fromEmails.getJSONObject(j).getString("email"));
            if (fromEmails.getJSONObject(j).has("is_org_email_id")) {
                fromEmail.setOrgEmailId(fromEmails.getJSONObject(j).getBoolean("is_org_email_id")); //No I18N
            }

            fromEmailsList.add(j, fromEmail);
        }

        email.setFromEmails(fromEmailsList);

        return email;
    }

    /**
     * Parse the json response and returns the CreditnoteRefundList object.
     *
     * @param response This json response contains list of creditnoteRefunds details for the contact.
     * @return Returns the creditnoteRefundList object.
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
        pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        if (pagecontext.has("applied_filter")) {
            pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        }
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        creditnoteRefundList.setPageContext(pageContext);

        return creditnoteRefundList;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for the contact.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String response) throws Exception {

        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("contact_comments"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Comment comment = new Comment();

            comment.setCommentId(jsonArray.getJSONObject(i).getString("comment_id"));
            comment.setDescription(jsonArray.getJSONObject(i).getString("description"));
            comment.setContactId(jsonArray.getJSONObject(i).getString("contact_id"));
            comment.setContactName(jsonArray.getJSONObject(i).getString("contact_name"));
            comment.setCommentedById(jsonArray.getJSONObject(i).getString("commented_by_id"));
            comment.setCommentedBy(jsonArray.getJSONObject(i).getString("commented_by"));
            comment.setDate(jsonArray.getJSONObject(i).getString("date"));
            comment.setDateDescription(jsonArray.getJSONObject(i).getString("date_description"));
            comment.setTime(jsonArray.getJSONObject(i).getString("time"));
            comment.setIsEntityDeleted(jsonArray.getJSONObject(i).getBoolean("is_entity_deleted")); //No I18N
            comment.setTransactionId(jsonArray.getJSONObject(i).getString("transaction_id"));
            comment.setTransactionType(jsonArray.getJSONObject(i).getString("transaction_type"));
            comment.setOperationType(jsonArray.getJSONObject(i).getString("operation_type"));

            commentList.add(comment);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        if (pagecontext.has("report_name")) {
            pageContext.setReportName(pagecontext.getString("report_name"));
        }
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        commentList.setPageContext(pageContext);

        return commentList;

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
