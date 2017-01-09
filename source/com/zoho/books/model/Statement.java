/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for statement.
 */

public class Statement {
    private String statementId = "";
    private String fromDate = "";
    private String toDate = "";
    private String source = "";

    private List<Transaction> transactions = new ArrayList<Transaction>();


    /**
     * set the statement id.
     *
     * @param statementId ID of the statement.
     */

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    /**
     * get the statement id.
     *
     * @return Returns the statement id.
     */

    public String getStatementId() {
        return statementId;
    }

    /**
     * set the statement id.
     *
     * @param statementId ID of the statement.
     */

    public void setId(String statementId) {
        this.statementId = statementId;
    }

    /**
     * get the statement id.
     *
     * @return Returns the statement id.
     */

    public String getId() {
        return statementId;
    }

    /**
     * set the from date of the transaction made.
     *
     * @param fromDate From date of the transaction made.
     */

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * get the from date of the transaction made.
     *
     * @return Returns the from date of the transaction made.
     */

    public String getFromDate() {
        return fromDate;
    }

    /**
     * set the to date of the transaction made.
     *
     * @param toDate To date of the transaction made.
     */

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * get the to date of the transaction made.
     *
     * @return Returns the to date of the transaction made.
     */

    public String getToDate() {
        return toDate;
    }

    /**
     * set the source.
     *
     * @param source Source of the statement.
     */

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * get the source.
     *
     * @return Returns the source of the statement.
     */

    public String getSource() {
        return source;
    }


    /**
     * set the transactions.
     *
     * @param transactions List of Transaction object.
     */

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * get the transactions.
     *
     * @return Returns the list of Transaction object.
     */

    public List<Transaction> getTransactions() {
        return transactions;
    }

}
