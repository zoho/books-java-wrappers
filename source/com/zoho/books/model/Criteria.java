/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to create an object for criteria.
 */


public class Criteria {

    private String columnname = "";
    private String searchText = "";
    private String comparator = "";


    /**
     * set the column name.
     *
     * @param columnname Name of the column.
     */

    public void setColumnName(String columnname) {
        this.columnname = columnname;
    }

    /**
     * get the column name.
     *
     * @return Returns the Name of the column.
     */

    public String getColumnName() {
        return columnname;
    }

    /**
     * set the search text.
     *
     * @param searchText Search text.
     */

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * get the search text.
     *
     * @return Returns the search text.
     */

    public String getSearchText() {
        return searchText;
    }

    /**
     * set the comparator.
     *
     * @param comparator Comparator for the criteria.
     */

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

    /**
     * get the comparator.
     *
     * @return Returns the comparator.
     */

    public String getComparator() {
        return comparator;
    }

}
