/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.Journal;
import com.zoho.books.model.JournalList;
import com.zoho.books.parser.JournalParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.util.HashMap;


/**
 * JournalsApi is used to create a journal.
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of all journals.<br>
 * <p>
 * The details of a journal.<br><br>
 * <p>
 * It is used to update the details of a journal.<br>
 * <p>
 * It is used to delete the journal.
 */

public class JournalsApi extends API {
    private static String url = baseURL + "/journals"; //No I18N


    /**
     * Construct a new JournalsApi using user's authtoken and organizationid.
     *
     * @param authToken      User's authToken.
     * @param organizationId User's organization id.
     */

    public JournalsApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private JournalParser journalParser = new JournalParser();


    /**
     * Create a journal.
     * <p>
     * Pass the Journal object to create a journal.
     * <p>
     * The Journal object which contains journalDate, amount, and debitOrCredit are the mandatory parameters.
     * <p>
     * It returns the Journal object.
     *
     * @param journal Journal object.
     * @return Returns the Journal object.
     */

    public Journal create(Journal journal) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", journal.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return journalParser.getJournal(response);
    }

    /**
     * Get the details of the journal.
     * <p>
     * Pass the journalId to get the details of a jornal.
     * <p>
     * It returns the Journal object.
     *
     * @param journalId ID of the Journal.
     * @return Returns the Journal object.
     */

    public Journal get(String journalId) throws Exception {

        String urlString = url + "/" + journalId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        Journal journal = journalParser.getJournal(response);

        return journal;
    }

    /**
     * Updates the journal with given information.
     * <p>
     * Pass the Journal object to update the details of a journal.
     * <p>
     * The Journal object which contains journalId is the mandatory parameter for which journal has to be updated.
     * <p>
     * It returns the Journal object.
     *
     * @param journal Journal object.
     * @return Returns the Journal object.
     */

    public Journal update(Journal journal) throws Exception {

        String urlString = url + "/" + journal.getJournalId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", journal.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return journalParser.getJournal(response);
    }

    /**
     * Deletes the given journal.
     * <p>
     * Pass the journalId to delete the journal.
     * <p>
     * If the journal has been deleted it returns the success message.
     * <p>
     * The success message is "The selected journal entry has been deleted."
     *
     * @param journalId ID of the Journal.
     * @return Returns a String.
     */

    public String delete(String journalId) throws Exception {

        String urlString = url + "/" + journalId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = journalParser.getMessage(response);

        return success;
    }

    /**
     * Get journal list.
     * <p>
     * Pass the filters to get all the journals based on the filters.
     * <p>
     * It returns the JournalList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <tr><td>entry_number</td><td>Search journals by journal entry number. <br>
     * Variants: <i>entry_number_startswith</i> and <i>entry_number_contains</i></td></tr>
     * <p>
     * <tr><td>reference_number</td><td>Search journals by journal reference number. <br>
     * Variants: <i>reference_number_startswith</i> and <i>reference_number_contains</i></td></tr>
     * <p>
     * <tr><td>date</td><td>Search journals by journal date. <br>
     * Variants: <i>date_start, date_end, date_before</i> and <i>date_after</i></td></tr>
     * <p>
     * <tr><td>notes</td><td>Search journals by journal notes. <br>
     * Variants: <i>notes_startswith</i> and <i>notes_contains</i></td></tr>
     * <p>
     * <tr><td>total</td><td>Search journals by journal total. <br>
     * Variants: <i>total_less_than, total_less_equals, total_greater_than</i> and <i>total_greater_equals</i></td></tr>
     * <p>
     * <tr><td>filter_by</td><td>Filter journals by journal date. <br>
     * Allowed Values: <i>JournalDate.All, JournalDate.Today, JournalDate.ThisWeek, JournalDate.ThisMonth, JournalDate.ThisQuarter</i> and <i>JournalDate.ThisYear</i></td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort journal list. <br>
     * Allowed Values: <i>journal_date, entry_number, reference_number</i> and <i>total</i></td></tr>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the JournalList object.
     */

    public JournalList getJournals(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        JournalList journalList = journalParser.getJournals(response);

        return journalList;
    }
}
