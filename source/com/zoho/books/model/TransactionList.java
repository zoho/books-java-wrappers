/* $Id$ */

package com.zoho.books.model;

import java.util.ArrayList;

/**
 * This class is used to create an object for bank transaction list.
 */


public class TransactionList extends ArrayList<Transaction> {


    private PageContext pageContext = new PageContext();

    private Instrumentation instrumentation = new Instrumentation();


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


    /**
     * set the instrumentation.
     *
     * @param instrumentation Instrumentation object.
     */

    public void setInstrumentation(Instrumentation instrumentation) throws Exception {
        this.instrumentation = instrumentation;
    }

    /**
     * get the instrumentation.
     *
     * @return Returns the Instrumentation object.
     */

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

}
