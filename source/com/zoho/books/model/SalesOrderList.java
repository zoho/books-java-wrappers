/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;

public class SalesOrderList extends ArrayList<SalesOrder> {

    private PageContext pageContext;


    /**
     * Get the page context of the sales order list.
     *
     * @return Returns the PageContext object.
     */

    public PageContext getPageContext() {
        return pageContext;
    }

    /**
     * Set the page context for the sales order list.
     *
     * @param pageContext PageContext object.
     */

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }


}
