/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create an object for pagecontext.
 */

public class PageContext {
    private int page = 1;
    private int perPage = 200;
    private boolean hasMorePage = false;
    private String reportName = "";
    private String appliedFilter = "";
    private String sortColumn = "";
    private String sortOrder = "";

    private List<Criteria> criteria = new ArrayList<Criteria>();


    /**
     * set the page number.
     *
     * @param page Number of the pages.
     */

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * get the page number.
     *
     * @return Returns the number of the pages.
     */

    public int getPage() {
        return page;
    }

    /**
     * set the details per page.
     *
     * @param perPage Details per page.
     */

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    /**
     * get the details per page.
     *
     * @return Returns the details per page.
     */

    public int getPerPage() {
        return perPage;
    }

    /**
     * set has more page.
     *
     * @param hasMorePage Details per page.
     */

    public void setHasMorePage(boolean hasMorePage) {
        this.hasMorePage = hasMorePage;
    }

    /**
     * get has more page.
     *
     * @return Returns true if it has more page else return false.
     */

    public boolean hasMorePage() {
        return hasMorePage;
    }

    /**
     * set the report name.
     *
     * @param reportName Name of the report.
     */

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     * get the report name.
     *
     * @return Returns the report name.
     */

    public String getReportName() {
        return reportName;
    }

    /**
     * set the applied filter.
     *
     * @param appliedFilter Applied filter for the report.
     */

    public void setAppliedFilter(String appliedFilter) {
        this.appliedFilter = appliedFilter;
    }

    /**
     * get the applied filter.
     *
     * @return Returns the applied filter.
     */

    public String getAppliedFilter() {
        return appliedFilter;
    }

    /**
     * set the sort column.
     *
     * @param sortColumn Sort column for the filter.
     */

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    /**
     * get the sort column.
     *
     * @return Returns the sort column.
     */

    public String getSortColumn() {
        return sortColumn;
    }

    /**
     * set the sort order.
     *
     * @param sortOrder Sorting order for the filter.
     */

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * get the sort order.
     *
     * @return Returns the sorting order.
     */

    public String getSortOrder() {
        return sortOrder;
    }


    /**
     * set the criteria.
     *
     * @param criteria List of Criteria object.
     */

    public void setCriteria(List<Criteria> criteria) throws Exception {
        this.criteria = criteria;
    }

    /**
     * get the criteria.
     *
     * @return Returns list of Criteria object.
     */

    public List<Criteria> getCriteria() {
        return criteria;
    }
}
