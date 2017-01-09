/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;

/**
 * This class is used to create an object for contact list.
 */

public class ContactList extends ArrayList<Contact> {

    private PageContext pageContext = new PageContext();


    /**
     * set the page context.
     *
     * @param pageContext PageContext object.
     */

    public void setPageContext(PageContext pageContext) {
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
