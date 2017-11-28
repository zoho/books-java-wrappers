/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.Account;
import com.zoho.books.model.BaseCurrencyAdjustment;
import com.zoho.books.model.BaseCurrencyAdjustmentList;
import com.zoho.books.model.PageContext;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseCurrencyAdjustmentParser is used to parse the json response and make it into the respective objects.
 */

public class BaseCurrencyAdjustmentParser {

    /**
     * Parse the json response and returns the BaseCurrencyAdjustment object.
     *
     * @param response The json response contains the basecurrency details.
     * @return Returns the BaseCurrencyAdjustment object.
     */

    public BaseCurrencyAdjustment getBaseCurrencyAdjustment(String response) throws Exception {
        BaseCurrencyAdjustment baseCurrencyAdjustment = new BaseCurrencyAdjustment();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject data = jsonObject.getJSONObject("base_currency_adjustment"); //No I18N

        baseCurrencyAdjustment.setAdjustmentDate(data.getString("adjustment_date"));
        baseCurrencyAdjustment.setExchangeRate(data.getDouble("exchange_rate")); //No I18N
        baseCurrencyAdjustment.setCurrencyId(data.getString("currency_id"));
        baseCurrencyAdjustment.setDescription(data.getString("description"));
        baseCurrencyAdjustment.setAdjustmentDateFormatted(data.getString("adjustment_date_formatted"));
        baseCurrencyAdjustment.setCurrencyCode(data.getString("currency_code"));
        baseCurrencyAdjustment.setBaseCurrencyAdjustmentId(data.getString("base_currency_adjustment_id"));

        JSONArray accounts = data.getJSONArray("accounts"); //No I18N

        List<Account> accountsList = new ArrayList<Account>();

        for (int i = 0; i < accounts.length(); i++) {
            Account account = new Account();

            account.setFcyBalanceFormatted(accounts.getJSONObject(i).getString("fcy_balance_formatted"));
            account.setGainOrLossFormatted(accounts.getJSONObject(i).getString("gain_or_loss_formatted"));
            account.setBcyBalanceFormatted(accounts.getJSONObject(i).getString("bcy_balance_formatted"));
            account.setFcyBalance(accounts.getJSONObject(i).getDouble("fcy_balance"));        //No I18N
            account.setGlSpecificType(accounts.getJSONObject(i).getInt("gl_specific_type"));    //No I18N
            account.setGainOrLoss(accounts.getJSONObject(i).getDouble("gain_or_loss"));        //No I18N
            account.setBcyBalance(accounts.getJSONObject(i).getDouble("bcy_balance"));        //No I18N
            account.setAdjustedBalance(accounts.getJSONObject(i).getDouble("adjustment_balance"));    //No I18N
            account.setAccountId(accounts.getJSONObject(i).getString("account_id"));
            account.setAdjustedBalanceFormatted(accounts.getJSONObject(i).getString("adjusted_balance_formatted"));
            account.setAccountName(accounts.getJSONObject(i).getString("account_name"));

            accountsList.add(i, account);
        }

        baseCurrencyAdjustment.setAccounts(accountsList);

        return baseCurrencyAdjustment;
    }

    /**
     * Parse the json response and returns the BaseCurrencyAdjustmentList object.
     *
     * @param response This json response contains list of the basecurrencies details.
     * @return Returns the BaseCurrencyAdjustmentList object.
     */

    public BaseCurrencyAdjustmentList getBaseCurrencyAdjustments(String response) throws Exception {
        BaseCurrencyAdjustmentList baseCurrencyAdjustmentList = new BaseCurrencyAdjustmentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray bca = jsonObject.getJSONArray("base_currency_adjustments"); //No I18N

        for (int i = 0; i < bca.length(); i++) {
            BaseCurrencyAdjustment baseCurrencyAdjustment = new BaseCurrencyAdjustment();

            baseCurrencyAdjustment.setBaseCurrencyAdjustmentId(bca.getJSONObject(i).getString("base_currency_adjustment_id"));
            baseCurrencyAdjustment.setAdjustmentDate(bca.getJSONObject(i).getString("adjustment_date"));
            baseCurrencyAdjustment.setExchangeRate(bca.getJSONObject(i).getDouble("exchange_rate")); //No I18N
            baseCurrencyAdjustment.setCurrencyId(bca.getJSONObject(i).getString("currency_id"));
            baseCurrencyAdjustment.setCurrencyCode(bca.getJSONObject(i).getString("currency_code"));
            baseCurrencyAdjustment.setDescription(bca.getJSONObject(i).getString("description"));
            baseCurrencyAdjustment.setGainOrLoss(bca.getJSONObject(i).getDouble("gain_or_loss"));    //No I18N

            baseCurrencyAdjustmentList.add(baseCurrencyAdjustment);
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

        baseCurrencyAdjustmentList.setPageContext(pageContext);

        return baseCurrencyAdjustmentList;
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
