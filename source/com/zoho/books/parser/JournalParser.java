/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.Journal;
import com.zoho.books.model.JournalList;
import com.zoho.books.model.LineItem;
import com.zoho.books.model.PageContext;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * JournalParser is used to parse the json response and make it into the respective objects.
 */

public class JournalParser {

    /**
     * Parse the json response and returns the Journal object.
     *
     * @param response This json response contains the journal details.
     * @return Returns the Journal object.
     */

    public Journal getJournal(String response) throws Exception {
        Journal journals = new Journal();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject journal = jsonObject.getJSONObject("journal"); //No I18N

        journals.setJournalId(journal.getString("journal_id"));
        journals.setEntryNumber(journal.getString("entry_number"));
        journals.setReferenceNumber(journal.getString("reference_number"));
        journals.setNotes(journal.getString("notes"));
        journals.setCurrencyId(journal.getString("currency_id"));
        journals.setCurrencyCode(journal.getString("currency_code"));
        journals.setCurrencySymbol(journal.getString("currency_symbol"));
        journals.setJournalDate(journal.getString("journal_date"));

        JSONArray lineItems = journal.getJSONArray("line_items"); //No I18N

        List<LineItem> lineItemsList = new ArrayList<LineItem>();

        for (int i = 0; i < lineItems.length(); i++) {
            LineItem lineItem = new LineItem();

            lineItem.setLineId(lineItems.getJSONObject(i).getString("line_id"));
            lineItem.setAccountId(lineItems.getJSONObject(i).getString("account_id"));
            lineItem.setAccountName(lineItems.getJSONObject(i).getString("account_name"));
            lineItem.setDescription(lineItems.getJSONObject(i).getString("description"));
            lineItem.setDebitOrCredit(lineItems.getJSONObject(i).getString("debit_or_credit"));
            lineItem.setTaxId(lineItems.getJSONObject(i).getString("tax_id"));
            lineItem.setTaxName(lineItems.getJSONObject(i).getString("tax_name"));
            lineItem.setTaxType(lineItems.getJSONObject(i).getString("tax_type"));
            //lineItem.setTaxPercentage(lineItems.getJSONObject(i).getDouble("tax_percentage")); //No I18N
            lineItem.setAmount(lineItems.getJSONObject(i).getDouble("amount")); //No I18N

            lineItemsList.add(i, lineItem);
        }

        journals.setLineItems(lineItemsList);

        journals.setLineItemTotal(journal.getDouble("line_item_total")); //No I18N
        journals.setTotal(journal.getDouble("total"));            //No I18N
        journals.setPricePrecision(journal.getInt("price_precision"));    //No I18N

        journals.setCreatedTime(journal.getString("created_time"));
        journals.setLastModifiedTime(journal.getString("last_modified_time"));

        return journals;

    }

    /**
     * Parse the json response and returns the JournalList object.
     *
     * @param response This json response contains list of journals details.
     * @return Returns the JournalList object.
     */

    public JournalList getJournals(String response) throws Exception {

        JournalList journalList = new JournalList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("journals"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Journal journal = new Journal();

            journal.setJournalId(jsonArray.getJSONObject(i).getString("journal_id"));
            journal.setJournalDate(jsonArray.getJSONObject(i).getString("journal_date"));
            journal.setEntryNumber(jsonArray.getJSONObject(i).getString("entry_number"));
            journal.setReferenceNumber(jsonArray.getJSONObject(i).getString("reference_number"));
            journal.setNotes(jsonArray.getJSONObject(i).getString("notes"));
            journal.setTotal(jsonArray.getJSONObject(i).getDouble("total")); //No I18N

            journalList.add(journal);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        journalList.setPageContext(pageContext);

        return journalList;
    }

    /**
     * Parse the json response and returns a string object.
     *
     * @param response This json response contains the success message of post or update or delete requests.
     * @return Returns the success message.
     */

    public String getMessage(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        String success = jsonObject.getString("message");

        return success;
    }
}
