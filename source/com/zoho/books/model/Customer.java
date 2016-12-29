/* $Id$ */

package com.zoho.books.model;

/**
 * This class is used to make an object for customer.
 */

public class Customer {
    private String name = "";
    private String value = "";

    private String defaultValue = "";


    /**
     * set the name.
     *
     * @param name Name for the customer.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name.
     *
     * @return Returns the name for the customer.
     */

    public String getName() {
        return name;
    }

    /**
     * set the value.
     *
     * @param value Value for the customer.
     */

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * get the value.
     *
     * @return Returns the value for the customer.
     */

    public String getValue() {
        return value;
    }


    /**
     * set the default value.
     *
     * @param defaultValue Default value for the customer.
     */

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * get the default value.
     *
     * @return Returns the default value for the customer.
     */

    public String getDefaultValue() {
        return defaultValue;
    }
}
