/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;

public class VendorCreditRefundList extends ArrayList<VendorCreditRefund> {

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
