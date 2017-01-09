/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;

/**
 * This class is used to create an object for time entry list.
 */


public class TimeEntryList extends ArrayList<TimeEntry> {

    private PageContext pageContext = new PageContext();


    /**
     * set the page context.
     *
     * @param pageContext PageContext object.
     */

    public void setPageContext(PageContext pageContext) throws Exception {
        this.pageContext = pageContext;
    }

    /**
     * get the page context.
     *
     * @return Returns the PageContext object.
     */

    public PageContext getPageContext() {
        return pageContext;
    }

}
