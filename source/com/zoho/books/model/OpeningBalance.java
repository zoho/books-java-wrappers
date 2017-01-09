/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for opening balance.
 */

public class OpeningBalance {
    private String openingBalanceId = "";
    private String date = "";

    private List<Account> accounts = new ArrayList<Account>();


    /**
     * set the opening balance id.
     *
     * @param openingBalanceId ID of the opening balance.
     */

    public void setOpeningBalanceId(String openingBalanceId) {
        this.openingBalanceId = openingBalanceId;
    }

    /**
     * get the opening balance id.
     *
     * @return Returns the ID of the opening balance.
     */

    public String getOpeningBalanceId() {
        return openingBalanceId;
    }

    /**
     * set the date.
     *
     * @param date Date on which the opening balance needs to be recorded.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get the date.
     *
     * @return Returns the date on which the opening balance needs to be recorded.
     */

    public String getDate() {
        return date;
    }


    /**
     * set the accounts.
     *
     * @param accounts Accounts for the opening balance.
     */

    public void setAccounts(List<Account> accounts) throws Exception {
        this.accounts = accounts;
    }

    /**
     * get the accounts.
     *
     * @return Returns list of Account object.
     */

    public List<Account> getAccounts() {
        return accounts;
    }


    /**
     * Convert OpeningBalance object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("date", date);

        if (accounts != null) {
            JSONArray account = new JSONArray();

            for (int i = 0; i < accounts.size(); i++) {
                account.put(accounts.get(i).toJSON());
            }

            jsonObject.put("accounts", accounts);
        }

        return jsonObject;
    }
}
