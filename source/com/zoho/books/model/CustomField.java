/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for custome fields.
 */

public class CustomField {
    private int index = 1;
    private String value = "";
    private String label = "";
    private boolean showOnPdf = false;


    /**
     * set the index.
     *
     * @param index Index of the custom field.
     */

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * get the index.
     *
     * @return Returns the index of the custom field.
     */

    public int getIndex() {
        return index;
    }

    /**
     * set the value.
     *
     * @param value Value of the custom field.
     */

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * get the value.
     *
     * @return Returns the value of the custom field.
     */

    public String getValue() {
        return value;
    }

    /**
     * set the label.
     *
     * @param label Label of the custom field.
     */

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * get the label.
     *
     * @return Returns the label of the custom field.
     */

    public String getLabel() {
        return label;
    }

    /**
     * set show on pdf.
     *
     * @param showOnPdf Whther show in pdf or not.
     */

    public void setShowOnPdf(boolean showOnPdf) {
        this.showOnPdf = showOnPdf;
    }

    /**
     * get show on pdf.
     *
     * @return Returns true if show on pdf else returns false.
     */

    public boolean showOnPdf() {
        return showOnPdf;
    }


    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if ((Integer) index != null) {
            jsonObject.put("index", index);
        }

        if (value != null) {
            jsonObject.put("value", value);
        }

        return jsonObject;
    }
}

