/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for preference.
 */

public class Preference {
    private boolean convertToInvoice = false;
    private boolean notifyMeOnOnlinePayment = false;
    private boolean sendPaymentReceiptAcknowledgement = false;
    private boolean autoNotifyRecurringInvoice = false;
    private boolean snailMailIncludePaymentStub = false;
    private boolean isShowPoweredBy = false;
    private String attachExpenseReceiptToInvoice = "";
    private boolean allowAutoCategorize = false;
    private boolean isEstimateEnabled = false;
    private boolean isProjectEnabled = false;

    private List<AutoReminder> autoReminders = new ArrayList<AutoReminder>();

    private Term terms = new Term();


    /**
     * set convert to invoice.
     *
     * @param convertToInvoice To automatically convert accepted estimate to invoice.
     */

    public void setConvertToInvoice(boolean convertToInvoice) {
        this.convertToInvoice = convertToInvoice;
    }

    /**
     * get convert to invoice.
     *
     * @return Returns true if the estimate automatically converted to invoice else returns false.
     */

    public boolean isConvertToInvoice() {
        return convertToInvoice;
    }

    /**
     * set notify me on online payment.
     *
     * @param notifyMeOnOnlinePayment To get notified when customers pay online.
     */

    public void setNotifyMeOnOnlinePayment(boolean notifyMeOnOnlinePayment) {
        this.notifyMeOnOnlinePayment = notifyMeOnOnlinePayment;
    }

    /**
     * get notify me on online payment.
     *
     * @return Returns true if you get notified when customers pay online else returns false.
     */

    public boolean isNotifyMeOnOnlinePayment() {
        return notifyMeOnOnlinePayment;
    }

    /**
     * set send payment receipt acknowledgement.
     *
     * @param sendPaymentReceiptAcknowledgement To automate thank you note to customer on receipt of online payment.
     */

    public void setSendPaymentReceiptAcknowledgement(boolean sendPaymentReceiptAcknowledgement) {
        this.sendPaymentReceiptAcknowledgement = sendPaymentReceiptAcknowledgement;
    }

    /**
     * get send payment receipt acknowledgement.
     *
     * @return Returns true if you get automate thank you note to customer on receipt of online payment else returns false.
     */

    public boolean isSendPaymentReceiptAcknowledgement() {
        return sendPaymentReceiptAcknowledgement;
    }

    /**
     * set auto notify recurring invoice.
     *
     * @param autoNotifyRecurringInvoice To determine whether to send recurring invoices directly to the customer.
     */

    public void setAutoNotifyRecurringInvoice(boolean autoNotifyRecurringInvoice) {
        this.autoNotifyRecurringInvoice = autoNotifyRecurringInvoice;
    }

    /**
     * get auto notify recurring invoice.
     *
     * @return Returns true if the recurring invoices directly send to the customer else returns false.
     */

    public boolean isAutoNotifyRecurringInvoice() {
        return autoNotifyRecurringInvoice;
    }

    /**
     * set snail mail include payment stub.
     *
     * @param snailMailIncludePaymentStub To include payment stub and return envelope in snail mails.
     */

    public void setSnailMailIncludePaymentStub(boolean snailMailIncludePaymentStub) {
        this.snailMailIncludePaymentStub = snailMailIncludePaymentStub;
    }

    /**
     * get snail mail include payment stub.
     *
     * @return Returns true if the snail mail include payment stub else returns false.
     */

    public boolean isSnailMailIncludePaymentStub() {
        return snailMailIncludePaymentStub;
    }

    /**
     * set is show powered by.
     *
     * @param isShowPoweredBy To keep Zoho branding on your invoices and estimates.
     */

    public void setIsShowPoweredBy(boolean isShowPoweredBy) {
        this.isShowPoweredBy = isShowPoweredBy;
    }

    /**
     * get is show powered by.
     *
     * @return Returns true if the Zoho branding on your invoices and estimates else returns false.
     */

    public boolean isShowPoweredBy() {
        return isShowPoweredBy;
    }

    /**
     * set attach expense receipt to invoice.
     *
     * @param attachExpenseReceiptToInvoice To associate and display unbilled expense receipts in Invoice PDF.
     */

    public void setAttachExpenseReceiptToInvoice(String attachExpenseReceiptToInvoice) {
        this.attachExpenseReceiptToInvoice = attachExpenseReceiptToInvoice;
    }

    /**
     * get attach expense receipt to invoice.
     *
     * @return Returns the associate and display unbilled expense receipts in Invoice PDF.
     */

    public String getAttachExpenseReceiptToInvoice() {
        return attachExpenseReceiptToInvoice;
    }

    /**
     * set allow auto categorize.
     *
     * @param allowAutoCategorize To alow auto categorize the invoice.
     */

    public void setAllowAutoCategorize(boolean allowAutoCategorize) {
        this.allowAutoCategorize = allowAutoCategorize;
    }

    /**
     * get allow auto categorize.
     *
     * @return Returns true if the invoice is allow auto categorize else returns false.
     */

    public boolean isAllowAutoCategorize() {
        return allowAutoCategorize;
    }

    /**
     * set is estimate enabled.
     *
     * @param isEstimateEnabled To enable estimates.
     */

    public void setIsEstimateEnabled(boolean isEstimateEnabled) {
        this.isEstimateEnabled = isEstimateEnabled;
    }

    /**
     * get is estimate enabled.
     *
     * @return Returns true if the estimate is enable else returns false.
     */

    public boolean isEstimateEnabled() {
        return isEstimateEnabled;
    }

    /**
     * set is project enabled.
     *
     * @param isProjectEnabled To enable timesheet.
     */

    public void setIsProjectEnabled(boolean isProjectEnabled) {
        this.isProjectEnabled = isProjectEnabled;
    }

    /**
     * get is project enabled.
     *
     * @return Returns true if the timesheet is enable else returns false.
     */

    public boolean isProjectEnabled() {
        return isProjectEnabled;
    }


    /**
     * set the auto reminders.
     *
     * @param autoReminders Auto reminders for the payments.
     */

    public void setAutoReminders(List<AutoReminder> autoReminders) throws Exception {
        this.autoReminders = autoReminders;
    }

    /**
     * get the auto reminders.
     *
     * @return Returns list of AutoReminder object.
     */

    public List<AutoReminder> getAutoReminders() {
        return autoReminders;
    }


    /**
     * set the terms.
     *
     * @param terms terms of the service.
     */

    public void setTerms(Term terms) throws Exception {
        this.terms = terms;
    }

    /**
     * get the terms.
     *
     * @return Returns a Term object.
     */

    public Term getTerms() {
        return terms;
    }


    /**
     * Convert Preference object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("convert_to_invoice", convertToInvoice);
        jsonObject.put("notify_me_on_online_payment", notifyMeOnOnlinePayment);
        jsonObject.put("send_payment_receipt_acknowledgement", sendPaymentReceiptAcknowledgement);
        jsonObject.put("auto_notify_recurring_invoice", autoNotifyRecurringInvoice);
        jsonObject.put("snail_mail_include_payment_stub", snailMailIncludePaymentStub);
        jsonObject.put("is_show_powered_by", isShowPoweredBy);
        jsonObject.put("attach_expense_receipt_to_invoice", attachExpenseReceiptToInvoice);
        jsonObject.put("is_estimate_enabled", isEstimateEnabled);
        jsonObject.put("is_project_enabled", isProjectEnabled);

        return jsonObject;
    }
}
