/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for email.
 */

public class Email {

    private String[] toMailIds = {};
    private String[] ccMailIds = {};
    private String subject = "";
    private String body = "";
    private boolean sendFromOrgEmailId = false;

    private String fileName = "";

    private String contactId = "";

    private String customerId = "";

    private boolean gatewaysConfigured = false;
    private String attachmentName = "";

    private ArrayList<File> attachments;


    private List<Emailtemplate> emailtemplates;

    private List<ToContact> toContacts;

    private List<FromEmail> fromEmails;


    private String entityId;
    private String fileNameWithoutExtension;

    private String customerName;
    private boolean attachPdf;
    private boolean gatewaysAssociated;

    private String vendorId;
    private String vendorName;


    /**
     * set the to mail ids.
     *
     * @param toMailIds Array of email address of the recipients.
     */

    public void setToMailIds(String[] toMailIds) {
        this.toMailIds = toMailIds;
    }

    /**
     * get the to mail ids.
     *
     * @return Returns array of to mail ids.
     */

    public String[] getToMailIds() {
        return toMailIds;
    }

    /**
     * set the cc mail ids.
     *
     * @param ccMailIds Array of email address of the recipients to be cced.
     */

    public void setCcMailIds(String[] ccMailIds) {
        this.ccMailIds = ccMailIds;
    }

    /**
     * get the to mail ids.
     *
     * @return Returns array of cc mail ids.
     */

    public String[] getCcMailIds() {
        return ccMailIds;
    }

    /**
     * set the subject of the email.
     *
     * @param subject Subject of the email to be sent.
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * get the subject of the email.
     *
     * @return Returns the subject of the email.
     */

    public String getSubject() {
        return subject;
    }

    /**
     * set the body of the email.
     *
     * @param body Message body of the email to be sent.
     */

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * get the body of the email.
     *
     * @return Returns the body of the email.
     */

    public String getBody() {
        return body;
    }

    /**
     * set send from org email id.
     *
     * @param sendFromOrgEmailId Boolean to trigger the email from the organization's email address.
     */

    public void setSendFromOrgEmailId(boolean sendFromOrgEmailId) {
        this.sendFromOrgEmailId = sendFromOrgEmailId;
    }

    /**
     * get send from org email id.
     *
     * @return Returns true if the email is sent from the org email id else returns false.
     */

    public boolean sendFromOrgEmailId() {
        return sendFromOrgEmailId;
    }


    /**
     * set the file name.
     *
     * @param fileName Name of the file that has been attached to the email.
     */

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * get the file name.
     *
     * @return Returns the file name that has been attached to the email.
     */

    public String getFileName() {
        return fileName;
    }


    /**
     * set the contact id.
     *
     * @param contactId ID of the contact.
     */

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     * get the contact id.
     *
     * @return Returns the contact id.
     */

    public String getContactId() {
        return contactId;
    }


    /**
     * set the customer id.
     *
     * @param customerId ID of the customer.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the customer id.
     */

    public String getCustomerId() {
        return customerId;
    }


    /**
     * set gateways configured.
     *
     * @param gatewaysConfigured To specify the gatewyas configured to the invoice or not.
     */

    public void setGatewaysConfigured(boolean gatewaysConfigured) {
        this.gatewaysConfigured = gatewaysConfigured;
    }

    /**
     * get gateways configured.
     *
     * @return Returns true if the gateways configured to the invoice else returns false.
     */

    public boolean gatewaysConfigured() {
        return gatewaysConfigured;
    }


    /**
     * set the attachment name.
     *
     * @param attachmentName Name of the attached file associated with the invoice.
     */

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * get the attachment name.
     *
     * @return Returns the name of the attached file associated with the invoice.
     */

    public String getAttachmentName() {
        return attachmentName;
    }


    /**
     * set the attachments.
     *
     * @param attachments Attached files associated with the invoice.
     */

    public void setAttachments(ArrayList<File> attachments) {
        this.attachments = attachments;
    }

    /**
     * get the attachments.
     *
     * @return Returns ArrayList of files.
     */

    public ArrayList<File> getAttachments() {
        return attachments;
    }


    /**
     * set the email templates.
     *
     * @param emailtemplates Email templates for an invoice.
     */

    public void setEmailtemplates(List<Emailtemplate> emailtemplates) {
        this.emailtemplates = emailtemplates;
    }

    /**
     * get the email templates.
     *
     * @return Returns list of Emailtemplate object.
     */

    public List<Emailtemplate> getEmailtemplates() {
        return emailtemplates;
    }


    /**
     * set the to contacts.
     *
     * @param toContacts To contacts for an invoice.
     */

    public void setToContacts(List<ToContact> toContacts) {
        this.toContacts = toContacts;
    }

    /**
     * get the to contacts.
     *
     * @return Returns list of ToContact object.
     */

    public List<ToContact> getToContacts() {
        return toContacts;
    }


    /**
     * set the from emails.
     *
     * @param fromEmails From emails for an invoice.
     */

    public void setFromEmails(List<FromEmail> fromEmails) {
        this.fromEmails = fromEmails;
    }

    /**
     * get the from emails.
     *
     * @return Returns list of FromEmail object.
     */

    public List<FromEmail> getFormEmails() {
        return fromEmails;
    }


    /**
     * Get the entity id of the email.
     *
     * @return Returns the entity id.
     */

    public String getEntityId() {
        return entityId;
    }

    /**
     * Set the entity id of the email.
     *
     * @param entityId Entity id of the email.
     */

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    /**
     * Get the file name without extension.
     *
     * @return Returns the attached file name without extension.
     */

    public String getFileNameWithoutExtension() {
        return fileNameWithoutExtension;
    }

    /**
     * Set the file name without extension.
     *
     * @param fileNameWithoutExtension Attached file name without extension.
     */

    public void setFileNameWithoutExtension(String fileNameWithoutExtension) {
        this.fileNameWithoutExtension = fileNameWithoutExtension;
    }


    /**
     * Get the customer name.
     *
     * @return Returns the customer name.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the customer name.
     *
     * @param customerName Name of the customer.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get the email is attached pdf.
     *
     * @return Returns true if the email attached pdf else returns false.
     */

    public boolean isAttachPdf() {
        return attachPdf;
    }

    /**
     * Set the email attached pdf or not.
     *
     * @param attachPdf True or false to set the email attached pdf or not.
     */

    public void setAttachPdf(boolean attachPdf) {
        this.attachPdf = attachPdf;
    }


    /**
     * Get the invoice is gateways associated or not.
     *
     * @return Returns true if the invoice is gateways associated else returns false.
     */

    public boolean isGatewaysAssociated() {
        return gatewaysAssociated;
    }

    /**
     * Set the invoice is gateways associated or not.
     *
     * @param gatewaysAssociated True or false to set the invoice is assciated with gateways or not.
     */

    public void setGatewaysAssociated(boolean gatewaysAssociated) {
        this.gatewaysAssociated = gatewaysAssociated;
    }


    /**
     * Get the vendor id.
     *
     * @return Returns the vendor id.
     */

    public String getVendorId() {
        return vendorId;
    }

    /**
     * Set the vendor id.
     *
     * @param vendorId ID of the vendor.
     */

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * Get the vendor name.
     *
     * @return Returns the vendor name.
     */

    public String getVendorName() {
        return vendorName;
    }

    /**
     * Set the vendor name.
     *
     * @param vendorName Name of the vendor.
     */

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * Convert Email object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (toMailIds != null) {
            JSONArray toMailId = new JSONArray();

            for (int i = 0; i < toMailIds.length; i++) {
                toMailId.put(toMailIds[i]);
            }
            jsonObject.put("to_mail_ids", toMailId);
        }

        if (ccMailIds != null) {
            JSONArray ccMailId = new JSONArray();

            for (int j = 0; j < ccMailIds.length; j++) {
                ccMailId.put(ccMailIds[j]);
            }
            jsonObject.put("cc_mail_ids", ccMailId);
        }
        if (!subject.equals("")) {
            jsonObject.put("subject", subject);
        }
        if (!body.equals("")) {
            jsonObject.put("body", body);
        }
        if ((Boolean) sendFromOrgEmailId != null) {
            jsonObject.put("send_from_org_email_id", sendFromOrgEmailId);
        }

        return jsonObject;
    }

}
