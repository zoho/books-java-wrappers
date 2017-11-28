/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for criterion.
 */

public class Criterion {
    private String criteriaId = "";
    private String field = "";
    private String comparator = "";
    private String value = "";


    /**
     * set the criteria id.
     *
     * @param criteriaId ID of the criteria.
     */

    public void setCriteriaId(String criteriaId) {
        this.criteriaId = criteriaId;
    }

    /**
     * get the criteria id.
     *
     * @return Returns the ID of the criteria.
     */

    public String getCriteriaId() {
        return criteriaId;
    }

    /**
     * set the field.
     *
     * @param field Fields on which the conditions are to be applied.
     */

    public void setField(String field) {
        this.field = field;
    }

    /**
     * get the field.
     *
     * @return Returns the field.
     */

    public String getField() {
        return field;
    }

    /**
     * set the comparator.
     *
     * @param comparator Comparator for field and its value.
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

    /**
     * set the value.
     *
     * @param value Value for the criteria field.
     */

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * get the value.
     *
     * @return Returns the value.
     */

    public String getValue() {
        return value;
    }


    /**
     * Convert Criterion object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("field", field);
        jsonObject.put("comparator", comparator);
        jsonObject.put("value", value);


        return jsonObject;

    }
}

