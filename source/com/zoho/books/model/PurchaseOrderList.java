/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;

/**
 * PurchaseOrderList class is used to create an object for list of purchase orders.
 *
 * @author ramesh-2099
 */

public class PurchaseOrderList extends ArrayList<PurchaseOrder> {

    private PageContext pageContext;

    /**
     * Get the page context.
     *
     * @return Returns the PageContext object.
     */

    public PageContext getPageContext() {
        return pageContext;
    }

    /**
     * Set the page context.
     *
     * @param pageContext PageContext object.
     */

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }


}
