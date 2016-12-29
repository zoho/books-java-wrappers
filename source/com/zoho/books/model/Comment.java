/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for comments.
 *
 * @author ramesh-2099
 */

public class Comment {
    private String commentId = "";
    private String description = "";

    private String invoiceId = "";
    private String commentedById = "";
    private String commentedBy = "";
    private String commentType = "";
    private String date = "";
    private String entityId = "";
    private String entityType = "";

    private String transactionId = "";
    private String transactionType = "";

    private String expenseId = "";
    private String dateDescription = "";
    private String time = "";

    private String recurringExpenseId = "";

    private boolean isEntityDeleted = false;

    private String billId = "";
    private String recurringInvoiceId = "";
    private String estimateId = "";
    private String creditnoteId = "";

    private String contactId = "";
    private String contactName = "";
    private String commentedDate = "";
    private String operationType = "";


    private String projectId = "";
    private boolean isCurrentUser = false;

    private String salesorderId;

    private String vendorCreditId;


    /**
     * set the comment id.
     *
     * @param commentId ID of the comment.
     */

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * get the comment id.
     *
     * @return Returns the comment id.
     */

    public String getCommentId() {
        return commentId;
    }

    /**
     * set the description.
     *
     * @param description Description of the comment.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the comment.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the invoice id.
     *
     * @param invoiceId ID of the invoice.
     */

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * get the invoice id.
     *
     * @return Returns the invoice id of the comment.
     */

    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * set the commented by id.
     *
     * @param commentedById ID of the person who comment this.
     */

    public void setCommentedById(String commentedById) {
        this.commentedById = commentedById;
    }

    /**
     * get the commented by id.
     *
     * @return Returns the id of the person who comment this.
     */

    public String getCommentedById() {
        return commentedById;
    }

    /**
     * set the commented person.
     *
     * @param commentedBy The person who comment this.
     */

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }

    /**
     * get the commented person.
     *
     * @return Returns the person who comment this.
     */

    public String getCommentedBy() {
        return commentedBy;
    }

    /**
     * set the comment type.
     *
     * @param commentType Type of the comment.
     */

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    /**
     * get the commented type.
     *
     * @return Returns the comment type.
     */

    public String getCommentType() {
        return commentType;
    }

    /**
     * set the commented date.
     *
     * @param date Which date the comment made.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the commented date.
     *
     * @return Returns the commented date.
     */

    public String getDate() {
        return date;
    }

    /**
     * set the entity id.
     *
     * @param entityId Entity id of the comment.
     */

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    /**
     * get the entity id.
     *
     * @return Returns the entity id of the comment.
     */

    public String getEntityId() {
        return entityId;
    }

    /**
     * set the entity type.
     *
     * @param entityType Entity type of the comment.
     */

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * get the entity type.
     *
     * @return Returns the entity type of the comment.
     */

    public String getEntityType() {
        return entityType;
    }

    /**
     * set the transaction id.
     *
     * @param transactionId ID of the transaction.
     */

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * get the transaction id.
     *
     * @return Returns the transaction id.
     */

    public String getTransactionId() {
        return transactionId;
    }

    /**
     * set the transaction type.
     *
     * @param transactionType Type of the transaction.
     */

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * get the transaction type.
     *
     * @return Returns the transaction type.
     */

    public String getTransactionType() {
        return transactionType;
    }


    /**
     * set the expense id.
     *
     * @param expenseId ID of the expense.
     */

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    /**
     * get the expense id.
     *
     * @return Returns the expense id.
     */

    public String getExpenseId() {
        return expenseId;
    }

    /**
     * set the date description.
     *
     * @param dateDescription Description of the date.
     */

    public void setDateDescription(String dateDescription) {
        this.dateDescription = dateDescription;
    }

    /**
     * get the date description.
     *
     * @return Returns the date description.
     */

    public String getDateDescription() {
        return dateDescription;
    }

    /**
     * set the time.
     *
     * @param time Which time the comment has been created.
     */

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * get the time.
     *
     * @return Returns which time the comment has been created.
     */

    public String getTime() {
        return time;
    }

    /**
     * set the recurring expense id.
     *
     * @param recurringExpenseId ID of the recurring expense.
     */

    public void setRecurringExpenseId(String recurringExpenseId) {
        this.recurringExpenseId = recurringExpenseId;
    }

    /**
     * get the recurring expense id.
     *
     * @return Returns the recurring expense id.
     */

    public String getRecurringExpenseId() {
        return recurringExpenseId;
    }

    /**
     * set is entity deleted.
     *
     * @param isEntityDeleted Whether the entity is deleted or not.
     */

    public void setIsEntityDeleted(boolean isEntityDeleted) {
        this.isEntityDeleted = isEntityDeleted;
    }

    /**
     * get is entity deleted.
     *
     * @return Returns true if the entity is deleted else return false.
     */

    public boolean isEntityDeleted() {
        return isEntityDeleted;
    }

    /**
     * set the bill id.
     *
     * @param billId ID of the bill.
     */

    public void setBillId(String billId) {
        this.billId = billId;
    }

    /**
     * get the bill id.
     *
     * @return Returns the bill id.
     */

    public String getBillId() {
        return billId;
    }

    /**
     * set the recurring invoice id.
     *
     * @param recurringInvoiceId ID of the recurring invoice.
     */

    public void setRecurringInvoiceId(String recurringInvoiceId) {
        this.recurringInvoiceId = recurringInvoiceId;
    }

    /**
     * get the recurring invoice id.
     *
     * @return Returns the recurring invoice id.
     */

    public String getRecurringInvoiceId() {
        return recurringInvoiceId;
    }

    /**
     * set the estimate id.
     *
     * @param estimateId ID of the estimate.
     */

    public void setEstimateId(String estimateId) {
        this.estimateId = estimateId;
    }

    /**
     * get the estimate id.
     *
     * @return Returns the estimate id.
     */

    public String getEstimateId() {
        return estimateId;
    }

    /**
     * set the creditnote id.
     *
     * @param creditnoteId ID of the creditnote.
     */

    public void setCreditnoteId(String creditnoteId) {
        this.creditnoteId = creditnoteId;
    }

    /**
     * get the creditnote id.
     *
     * @return Returns the creditnote id.
     */

    public String getCreditnoteId() {
        return creditnoteId;
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
     * set the contact name.
     *
     * @param contactName Name of the contact.
     */

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * get the contact name.
     *
     * @return Returns the contact name.
     */

    public String getContactName() {
        return contactName;
    }

    /**
     * set the commented date.
     *
     * @param commentedDate In which date the comment has been made.
     */

    public void setCommentedDate(String commentedDate) {
        this.commentedDate = commentedDate;
    }

    /**
     * get the commented date.
     *
     * @return Returns the commented date.
     */

    public String getCommentedDate() {
        return commentedDate;
    }

    /**
     * set the operation type.
     *
     * @param operationType Type of the operation.
     */

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * get the operation type.
     *
     * @return Returns the operation type.
     */

    public String getOperationType() {
        return operationType;
    }


    /**
     * set the project id.
     *
     * @param projectId ID of the project.
     */

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * get the project id.
     *
     * @return Returns the project id.
     */

    public String getProjectId() {
        return projectId;
    }

    /**
     * set is current user.
     *
     * @param isCurrentUser Is the user is current or not.
     */

    public void setIsCurrentUser(boolean isCurrentUser) {
        this.isCurrentUser = isCurrentUser;
    }

    /**
     * get is current user.
     *
     * @return Returns true the user is current else returns false.
     */

    public boolean isCurrentUser() {
        return isCurrentUser;
    }

    /**
     * Get the sales order id.
     *
     * @return Returns the sales order id.
     */

    public String getSalesorderId() {
        return salesorderId;
    }

    /**
     * Set the sales order id.
     *
     * @param salesorderId ID of the sales order.
     */

    public void setSalesorderId(String salesorderId) {
        this.salesorderId = salesorderId;
    }


    /**
     * Get the vendor credit id.
     *
     * @return Returns the vendor credit id.
     */

    public String getVendorCreditId() {
        return vendorCreditId;
    }

    /**
     * Set the vendor credit id.
     *
     * @param vendorCreditId ID of the vendor credit.
     */

    public void setVendorCreditId(String vendorCreditId) {
        this.vendorCreditId = vendorCreditId;
    }


}
