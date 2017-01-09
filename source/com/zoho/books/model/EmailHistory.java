/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for email history.
 */

public class EmailHistory {


    private String mailhistoryId = "";
    private String from = "";
    private String toMailIds = "";
    private String subject = "";
    private String date = "";
    private String type = "";


    /**
     * set the mailhistory id.
     *
     * @param mailhistoryId ID of the mail history.
     */

    public void setMailhistoryId(String mailhistoryId) {
        this.mailhistoryId = mailhistoryId;
    }

    /**
     * get the mailhistory id.
     *
     * @return Returns the mail history id.
     */

    public String getMailhistoryId() {
        return mailhistoryId;
    }

    /**
     * set the from email.
     *
     * @param from From email id of the mail history.
     */

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * get the from email.
     *
     * @return Returns the from email id of the mail history.
     */

    public String getFrom() {
        return from;
    }

    /**
     * set the to mail ids.
     *
     * @param toMailIds To mail ids of the mail history.
     */

    public void setToMailIds(String toMailIds) {
        this.toMailIds = toMailIds;
    }

    /**
     * get the to mail ids.
     *
     * @return Returns the to mail ids of the mail history.
     */

    public String getToMailIds() {
        return toMailIds;
    }

    /**
     * set the subject.
     *
     * @param subject Subject of the mail history.
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * get the subject.
     *
     * @return Returns the subject of the mail history.
     */

    public String getSubject() {
        return subject;
    }

    /**
     * set the date.
     *
     * @param date Date the mail has to be sent.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date of the mail has to be sent.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the type.
     *
     * @param type Type of the mail history.
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * get the type.
     *
     * @return Returns the type of the mail history.
     */

    public String getType() {
        return type;
    }

}
