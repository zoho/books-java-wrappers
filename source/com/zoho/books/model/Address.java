/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for address.
 */

public class Address {

    private String streetAddress1 = "";
    private String streetAddress2 = "";
    private String address = "";
    private String city = "";
    private String state = "";
    private String country = "";
    private String zip = "";
    private String fax = "";
    private boolean isUpdateCustomer = false;
    private String organizationAddressId;


    /**
     * set the street address1.
     *
     * @param streetAddress1 Address of the street.
     */

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    /**
     * get the street address1.
     *
     * @return Returns the street address1.
     */

    public String getStreetAddress1() {
        return streetAddress1;
    }

    /**
     * set the street address2.
     *
     * @param streetAddress2 Address of the street.
     */

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    /**
     * get the street address2.
     *
     * @return Returns the street address2.
     */

    public String getStreetAddress2() {
        return streetAddress2;
    }


    /**
     * set the address.
     *
     * @param address Billing address.
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get the address.
     *
     * @return Returns the billing address.
     */

    public String getAddress() {
        return address;
    }


    /**
     * set the city.
     *
     * @param city Address of the city.
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get the city.
     *
     * @return Returns the city of the address.
     */

    public String getCity() {
        return city;
    }

    /**
     * set the state.
     *
     * @param state Address of the state.
     */

    public void setState(String state) {
        this.state = state;
    }

    /**
     * get the state.
     *
     * @return Returns the state of the address.
     */

    public String getState() {
        return state;
    }

    /**
     * set the country.
     *
     * @param country Address of the country.
     */

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * get the country.
     *
     * @return Returns the country of the address.
     */

    public String getCountry() {
        return country;
    }

    /**
     * set the zip code.
     *
     * @param zip Address of the zip code.
     */

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * get the zip.
     *
     * @return Returns the zip code of the address.
     */

    public String getZip() {
        return zip;
    }

    /**
     * set the fax.
     *
     * @param fax Fax of the billing address.
     */

    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * get the fax.
     *
     * @return Returns the fax of the billing address.
     */

    public String getFax() {
        return fax;
    }

    /**
     * set is update customer.
     *
     * @param isUpdateCustomer You can set this address as default billing address for your customer from now on by specifying param as true.
     */

    public void setIsUpdateCustomer(boolean isUpdateCustomer) {
        this.isUpdateCustomer = isUpdateCustomer;
    }

    /**
     * get is update customer.
     *
     * @return Returns true if the customer is update else returns false.
     */

    public boolean isUpdateCustomer() {
        return isUpdateCustomer;
    }


    /**
     * Get the organization address id.
     *
     * @return Returns the organization address id.
     */

    public String getOrganizationAddressId() {
        return organizationAddressId;
    }

    /**
     * Set the organization address id.
     *
     * @param organizationAddressId ID of the organization address.
     */

    public void setOrganizationAddressId(String organizationAddressId) {
        this.organizationAddressId = organizationAddressId;
    }


    /**
     * Convert Address object into JSONObject.
     *
     * @return Returns a JSONObject.
     * @throws Exception
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (streetAddress1 != null && !streetAddress1.equals("")) {
            jsonObject.put("street_address1", streetAddress1);
        }

        if (streetAddress2 != null && !streetAddress2.equals("")) {
            jsonObject.put("street_address2", streetAddress2);
        }

        if (address != null) {
            jsonObject.put("address", address);
        }

        if (city != null) {
            jsonObject.put("city", city);
        }

        if (state != null) {
            jsonObject.put("state", state);
        }

        if (country != null) {
            jsonObject.put("country", country);
        }

        if (zip != null) {
            jsonObject.put("zip", zip);
        }

        if (fax != null && !fax.equals("")) {
            jsonObject.put("fax", fax);
        }

        if ((Boolean) isUpdateCustomer != null) {
            jsonObject.put("is_update_customer", isUpdateCustomer);
        }

        if (organizationAddressId != null && !organizationAddressId.equals("")) {
            jsonObject.put("organization_address_id", organizationAddressId);
        }

        return jsonObject;
    }
}
