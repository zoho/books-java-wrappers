/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for creditnote settings.
 */

public class CreditnoteSetting {
    private boolean autoGenerate = true;
    private String prefixString = "";
    private String referenceText = "";
    private String nextNumber = "";
    private String notes = "";
    private String terms = "";


    /**
     * set auto generate.
     *
     * @param autoGenerate To enable or disable auto number generation.
     */

    public void setAutoGenerate(boolean autoGenerate) {
        this.autoGenerate = autoGenerate;
    }

    /**
     * get auto generate.
     *
     * @return Returns true to enable auto number generation else returns false.
     */

    public boolean isAutoGenerate() {
        return autoGenerate;
    }

    /**
     * set the prefix string.
     *
     * @param prefixString Prefix string for entity auto number generation.
     */

    public void setPrefixString(String prefixString) {
        this.prefixString = prefixString;
    }

    /**
     * get the prefix string.
     *
     * @return Returns the prefix string for entity auto number generation.
     */

    public String getPrefixString() {
        return prefixString;
    }

    /**
     * set the reference text.
     *
     * @param referenceText Label for the reference number.
     */

    public void setReferenceText(String referenceText) {
        this.referenceText = referenceText;
    }

    /**
     * get the reference text.
     *
     * @return Returns the label for the reference number.
     */

    public String getReferenceText() {
        return referenceText;
    }

    /**
     * set the next number.
     *
     * @param nextNumber Number that will be next updated while creating an entity.
     */

    public void setNextNumber(String nextNumber) {
        this.nextNumber = nextNumber;
    }

    /**
     * get the next number.
     *
     * @return Returns the number that will be next updated while creating an entity.
     */

    public String getNextNumber() {
        return nextNumber;
    }

    /**
     * set the notes.
     *
     * @param notes Notes to the customer.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the notes to the customer.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * set the terms.
     *
     * @param terms Terms and conditions.
     */

    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * get the terms.
     *
     * @return Returns the terms and conditions.
     */

    public String getTerms() {
        return terms;
    }


    /**
     * Convert CreditnoteSetting object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("auto_generate", autoGenerate);
        jsonObject.put("prefix_string", prefixString);
        jsonObject.put("next_number", nextNumber);
        jsonObject.put("reference_text", referenceText);
        jsonObject.put("notes", notes);
        jsonObject.put("terms", terms);

        return jsonObject;
    }
}
