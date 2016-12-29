/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to create an object for instrumentation.
 */

public class Instrumentation {

    private int queryExecutionTime = 0;
    private int requestHandlingTime = 0;
    private int responseWriteTime = 0;
    private int pageContextWriteTime = 0;


    /**
     * set the query excecution of the request.
     *
     * @param queryExecutionTime Query execution time for the request.
     */

    public void setQueryExecutionTime(int queryExecutionTime) {
        this.queryExecutionTime = queryExecutionTime;
    }

    /**
     * get the query excecution of the request.
     *
     * @return Returns the query execution time for the request.
     */

    public int getQueryExecutionTime() {
        return queryExecutionTime;
    }

    /**
     * set the request handling time.
     *
     * @param requestHandlingTime Request handling time.
     */

    public void setRequestHandlingTime(int requestHandlingTime) {
        this.requestHandlingTime = requestHandlingTime;
    }

    /**
     * get the request handling time.
     *
     * @return Returns the request handling time.
     */

    public int getRequestHandlingTime() {
        return requestHandlingTime;
    }

    /**
     * set the response write time.
     *
     * @param responseWriteTime Response write time.
     */

    public void setResponseWriteTime(int responseWriteTime) {
        this.responseWriteTime = responseWriteTime;
    }

    /**
     * get the response write time.
     *
     * @return Returns the response write time.
     */

    public int getResponseWriteTime() {
        return responseWriteTime;
    }

    /**
     * set the page context write time.
     *
     * @param pageContextWriteTime Page context write time.
     */

    public void setPageContextWriteTime(int pageContextWriteTime) {
        this.pageContextWriteTime = pageContextWriteTime;
    }

    /**
     * get the page context write time.
     *
     * @return Returns the page context write time.
     */

    public int getPageContextWriteTime() {
        return pageContextWriteTime;
    }

}
