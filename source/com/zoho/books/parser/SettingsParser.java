/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * SettingsParser is used to parse the json response and make it into the respective objects.
 */

public class SettingsParser {

    /**
     * Parse the json response and returns the Preference object.
     *
     * @param response This json response contains the preference details.
     * @return Returns the Preference object.
     */

    public Preference getPreferences(String response) throws Exception {
        Preference preferences = new Preference();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject preference = jsonObject.getJSONObject("preferences"); //No I18N

        preferences.setConvertToInvoice(preference.getBoolean("convert_to_invoice")); //No I18N
        preferences.setNotifyMeOnOnlinePayment(preference.getBoolean("notify_me_on_online_payment")); //No I18N
        preferences.setSendPaymentReceiptAcknowledgement(preference.getBoolean("send_payment_receipt_acknowledgement")); //No I18N
        preferences.setAutoNotifyRecurringInvoice(preference.getBoolean("auto_notify_recurring_invoice")); //No I18N
        preferences.setSnailMailIncludePaymentStub(preference.getBoolean("snail_mail_include_payment_stub")); //No I18N
        preferences.setIsShowPoweredBy(preference.getBoolean("is_show_powered_by")); //No I18N
        preferences.setAttachExpenseReceiptToInvoice(preference.getString("attach_expense_receipt_to_invoice"));
        preferences.setIsEstimateEnabled(preference.getBoolean("is_estimate_enabled")); //No I18N
        preferences.setIsProjectEnabled(preference.getBoolean("is_project_enabled")); //No I18N

        JSONArray autoReminders = preference.getJSONArray("auto_reminders"); //No I18N

        List<AutoReminder> autoRemindersList = new ArrayList<AutoReminder>();

        for (int i = 0; i < autoReminders.length(); i++) {
            AutoReminder autoReminder = new AutoReminder();

            autoReminder.setPaymentReminderId(autoReminders.getJSONObject(i).getString("payment_reminder_id"));
            autoReminder.setIsEnabled(autoReminders.getJSONObject(i).getBoolean("is_enabled")); //No I18N
            autoReminder.setNotificationType(autoReminders.getJSONObject(i).getString("notification_type"));
            autoReminder.setAddressType(autoReminders.getJSONObject(i).getString("address_type"));
            autoReminder.setNumberOfDays(autoReminders.getJSONObject(i).getInt("number_of_days")); //No I18N
            autoReminder.setSubject(autoReminders.getJSONObject(i).getString("subject"));
            autoReminder.setBody(autoReminders.getJSONObject(i).getString("body"));

            autoRemindersList.add(i, autoReminder);
        }

        preferences.setAutoReminders(autoRemindersList);

        JSONObject terms = preference.getJSONObject("terms"); //No I18N

        Term termsObj = new Term();

        termsObj.setInvoiceTerms(terms.getString("invoice_terms"));
        termsObj.setEstimateTerms(terms.getString("estimate_terms"));
        termsObj.setCreditnoteTerms(terms.getString("creditnote_terms"));

        preferences.setTerms(termsObj);


        return preferences;


    }

    /**
     * Parse the json response and returns the OrganizationList object.
     *
     * @param response This json response contains list of organizations details.
     * @return Returns the OrganizationList object.
     */

    public OrganizationList getOrganizations(String response) throws Exception {

        OrganizationList organizationList = new OrganizationList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("organizations"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Organization organization = new Organization();

            organization.setOrganizationId(jsonArray.getJSONObject(i).getString("organization_id"));
            organization.setName(jsonArray.getJSONObject(i).getString("name"));
            organization.setContactName(jsonArray.getJSONObject(i).getString("contact_name"));
            organization.setEmail(jsonArray.getJSONObject(i).getString("email"));
            organization.setIsDefaultOrg(jsonArray.getJSONObject(i).getBoolean("is_default_org")); //No I18N
            organization.setPlanType(jsonArray.getJSONObject(i).getInt("plan_type"));
            organization.setTaxGroupEnabled(jsonArray.getJSONObject(i).getBoolean("tax_group_enabled")); //No I18N
            organization.setPlanName(jsonArray.getJSONObject(i).getString("plan_name"));
            organization.setPlanPeriod(jsonArray.getJSONObject(i).getString("plan_period"));
            organization.setLanguageCode(jsonArray.getJSONObject(i).getString("language_code"));
            organization.setFiscalYearStartMonth(jsonArray.getJSONObject(i).getInt("fiscal_year_start_month"));
            organization.setAccountCreatedDate(jsonArray.getJSONObject(i).getString("account_created_date"));
            organization.setAccountCreatedDateFormatted(jsonArray.getJSONObject(i).getString("account_created_date_formatted"));
            organization.setTimeZone(jsonArray.getJSONObject(i).getString("time_zone"));
            organization.setIsOrgActive(jsonArray.getJSONObject(i).getBoolean("is_org_active")); //No I18N
            organization.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            organization.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            organization.setCurrencySymbol(jsonArray.getJSONObject(i).getString("currency_symbol"));
            organization.setCurrencyFormat(jsonArray.getJSONObject(i).getString("currency_format"));
            organization.setPricePrecision(jsonArray.getJSONObject(i).getInt("price_precision")); //No I18N

            organizationList.add(organization);
        }

        return organizationList;
    }

    /**
     * Parse the json response and returns the Organization object.
     *
     * @param response This json response contains the organization details.
     * @return Returns the Organization object.
     */

    public Organization getOrganization(String response) throws Exception {
        Organization organizations = new Organization();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject organization = jsonObject.getJSONObject("organization"); //No I18N

        organizations.setOrganizationId(organization.getString("organization_id"));
        organizations.setName(organization.getString("name"));
        organizations.setIsDefaultOrg(organization.getBoolean("is_default_org")); //No I18N
        organizations.setAccountCreatedDate(organization.getString("account_created_date"));
        organizations.setTimeZone(organization.getString("time_zone"));
        organizations.setLanguageCode(organization.getString("language_code"));
        organizations.setDateFormat(organization.getString("date_format"));
        organizations.setFieldSeparator(organization.getString("field_separator"));
        organizations.setFiscalYearStartMonth(organization.getInt("fiscal_year_start_month"));
        organizations.setContactName(organization.getString("contact_name"));
        organizations.setIndustryType(organization.getString("industry_type"));
        organizations.setIndustrySize(organization.getString("industry_size"));
        organizations.setCompanyIdLabel(organization.getString("company_id_label"));
        organizations.setCompanyIdValue(organization.getString("company_id_value"));
        organizations.setTaxIdLabel(organization.getString("tax_id_label"));
        organizations.setTaxIdValue(organization.getString("tax_id_value"));
        organizations.setCurrencyId(organization.getString("currency_id"));
        organizations.setCurrencyCode(organization.getString("currency_code"));
        organizations.setCurrencySymbol(organization.getString("currency_symbol"));
        organizations.setCurrencyFormat(organization.getString("currency_format"));
        organizations.setPricePrecision(organization.getInt("price_precision")); //No I18N

        JSONObject address = organization.getJSONObject("address"); //No I18N

        Address addressObj = new Address();

        addressObj.setStreetAddress1(address.getString("street_address1"));
        addressObj.setStreetAddress2(address.getString("street_address2"));
        addressObj.setCity(address.getString("city"));
        addressObj.setState(address.getString("state"));
        addressObj.setCountry(address.getString("country"));

        organizations.setAddress(addressObj);

        organizations.setOrgAddress(organization.getString("org_address"));
        organizations.setRemitToAddress(organization.getString("remit_to_address"));
        organizations.setPhone(organization.getString("phone"));
        organizations.setFax(organization.getString("fax"));
        organizations.setWebsite(organization.getString("website"));
        organizations.setEmail(organization.getString("email"));
        organizations.setTaxBasis(organization.getString("tax_basis"));
        organizations.setIsOrgActive(organization.getBoolean("is_org_active")); //No I18N

        return organizations;

    }

    /**
     * Parse the json response and returns the ItemList object.
     *
     * @param response This json response contains list of items details.
     * @return Returns the ItemList object.
     */

    public ItemList getItems(String response) throws Exception {

        ItemList itemList = new ItemList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("items"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Item item = new Item();

            item.setItemId(jsonArray.getJSONObject(i).getString("item_id"));
            item.setName(jsonArray.getJSONObject(i).getString("name"));
            item.setStatus(jsonArray.getJSONObject(i).getString("status"));
            item.setDescription(jsonArray.getJSONObject(i).getString("description"));
            item.setRate(jsonArray.getJSONObject(i).getDouble("rate")); //No I18N
            item.setTaxId(jsonArray.getJSONObject(i).getString("tax_id"));
            item.setTaxName(jsonArray.getJSONObject(i).getString("tax_name"));
            item.setTaxPercentage(jsonArray.getJSONObject(i).getDouble("tax_percentage")); //No I18N

            itemList.add(item);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        itemList.setPageContext(pageContext);

        return itemList;
    }

    /**
     * Parse the json response and returns the Item object.
     *
     * @param response This json response contains the item details.
     * @return Returns the Item object.
     */

    public Item getItem(String response) throws Exception {
        Item items = new Item();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject item = jsonObject.getJSONObject("item"); //No I18N

        items.setItemId(item.getString("item_id"));
        items.setName(item.getString("name"));
        items.setStatus(item.getString("status"));
        items.setDescription(item.getString("description"));
        items.setRate(item.getDouble("rate")); //No I18N
        items.setUnit(item.getString("unit"));
        items.setAccountId(item.getString("account_id"));
        items.setAccountName(item.getString("account_name"));
        items.setTaxId(item.getString("tax_id"));
        items.setTaxName(item.getString("tax_name"));
        items.setTaxPercentage(item.getDouble("tax_percentage")); //No I18N
        items.setTaxType(item.getString("tax_type"));

        return items;
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

    /**
     * Parse the json response and returns the UserList object.
     *
     * @param response This json response contains list of users details.
     * @return Returns the UserList object.
     */

    public UserList getUsers(String response) throws Exception {

        UserList userList = new UserList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("users"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            User user = new User();

            user.setUserId(jsonArray.getJSONObject(i).getString("user_id"));
            user.setRoleId(jsonArray.getJSONObject(i).getString("role_id"));
            user.setName(jsonArray.getJSONObject(i).getString("name"));
            user.setEmail(jsonArray.getJSONObject(i).getString("email"));
            user.setUserRole(jsonArray.getJSONObject(i).getString("user_role"));
            user.setStatus(jsonArray.getJSONObject(i).getString("status"));
            user.setIsCurrentUser(jsonArray.getJSONObject(i).getBoolean("is_current_user")); //No I18N

            userList.add(user);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        userList.setPageContext(pageContext);

        return userList;
    }

    /**
     * Parse the json response and returns the User object.
     *
     * @param response This json response contains the user details.
     * @return Returns the User object.
     */

    public User getUser(String response) throws Exception {
        User users = new User();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject user = jsonObject.getJSONObject("user"); //No I18N

        users.setUserId(user.getString("user_id"));
        users.setName(user.getString("name"));
        users.setStatus(user.getString("status"));
        users.setUserRole(user.getString("user_role"));
        users.setCreatedTime(user.getString("created_time"));

        JSONArray emailIds = user.getJSONArray("email_ids"); //No I18N

        List<EmailId> emailIdsList = new ArrayList<EmailId>();

        for (int i = 0; i < emailIds.length(); i++) {
            EmailId emailId = new EmailId();

            emailId.setIsSelected(emailIds.getJSONObject(i).getBoolean("is_selected")); //No I18N
            emailId.setEmail(emailIds.getJSONObject(i).getString("email"));

            emailIdsList.add(i, emailId);
        }

        users.setEmailIds(emailIdsList);

        return users;
    }

    /**
     * Parse the json response and returns the InvoiceSetting object.
     *
     * @param response This json response contains the invoice setting details.
     * @return Returns the InvoiceSetting object.
     */

    public InvoiceSetting getInvoiceSettings(String response) throws Exception {
        InvoiceSetting invoiceSettings = new InvoiceSetting();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject invoiceSetting = jsonObject.getJSONObject("invoice_settings"); //No I18N

        invoiceSettings.setAutoGenerate(invoiceSetting.getBoolean("auto_generate")); //No I18N
        invoiceSettings.setPrefixString(invoiceSetting.getString("prefix_string"));
        invoiceSettings.setStartAt(invoiceSetting.getLong("start_at")); //No I18N
        invoiceSettings.setNextNumber(invoiceSetting.getString("next_number"));
        invoiceSettings.setQuantityPrecision(invoiceSetting.getInt("quantity_precision")); //No I18N
        invoiceSettings.setDiscountType(invoiceSetting.getString("discount_type"));
        invoiceSettings.setIsDiscountBeforeTax(invoiceSetting.getBoolean("is_discount_before_tax")); //No I18N
        invoiceSettings.setReferenceText(invoiceSetting.getString("reference_text"));
        invoiceSettings.setNotes(invoiceSetting.getString("notes"));
        invoiceSettings.setTerms(invoiceSetting.getString("terms"));
        invoiceSettings.setIsShippingChargeRequired(invoiceSetting.getBoolean("is_shipping_charge_required"));  //No I18N
        invoiceSettings.setIsAdjustmentRequired(invoiceSetting.getBoolean("is_adjustment_required"));        //No I18N
        invoiceSettings.setIsOpenInvoiceEditable(invoiceSetting.getBoolean("is_open_invoice_editable"));    //No I18N
        invoiceSettings.setWarnConvertToOpen(invoiceSetting.getBoolean("warn_convert_to_open"));        //No I18N
        invoiceSettings.setWarnCreateCreditnotes(invoiceSetting.getBoolean("warn_create_creditnotes"));        //No I18N
        invoiceSettings.setAttachExpenseReceiptToInvoice(invoiceSetting.getString("attach_expense_receipt_to_invoice"));
        invoiceSettings.setInvoiceItemType(invoiceSetting.getString("invoice_item_type"));
        invoiceSettings.setIsShowInvoiceSetup(invoiceSetting.getBoolean("is_show_invoice_setup"));        //No I18N
        invoiceSettings.setIsSalesPersonRequired(invoiceSetting.getBoolean("is_sales_person_required"));    //No I18N

        return invoiceSettings;

    }

    /**
     * Parse the json response and returns the NotesAndTerms object.
     *
     * @param response This json response contains the notes and terms details for invoice, estimate and creditnote settings.
     * @return Returns the NotesAndTerms object.
     */

    public NotesAndTerms getNotesAndTerms(String response) throws Exception {
        NotesAndTerms notesAndTerms = new NotesAndTerms();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject notesAndTerm = jsonObject.getJSONObject("notes_and_terms"); //No I18N

        notesAndTerms.setNotes(notesAndTerm.getString("notes"));
        notesAndTerms.setTerms(notesAndTerm.getString("terms"));

        return notesAndTerms;
    }

    /**
     * Parse the json response and returns the EstimateSetting object.
     *
     * @param response This json response contains the estimate setting details.
     * @return Returns the EstimateSetting object.
     */

    public EstimateSetting getEstimateSettings(String response) throws Exception {
        EstimateSetting estimateSettings = new EstimateSetting();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject estimateSetting = jsonObject.getJSONObject("estimate_settings"); //No I18N

        estimateSettings.setAutoGenerate(estimateSetting.getBoolean("auto_generate")); //No I18N
        estimateSettings.setPrefixString(estimateSetting.getString("prefix_string"));
        estimateSettings.setStartAt(estimateSetting.getLong("start_at")); //No I18N
        estimateSettings.setNextNumber(estimateSetting.getString("next_number"));
        estimateSettings.setQuantityPrecision(estimateSetting.getInt("quantity_precision")); //No I18N
        estimateSettings.setDiscountType(estimateSetting.getString("discount_type"));
        estimateSettings.setIsDiscountBeforeTax(estimateSetting.getBoolean("is_discount_before_tax")); //No I18N
        estimateSettings.setReferenceText(estimateSetting.getString("reference_text"));
        estimateSettings.setNotes(estimateSetting.getString("notes"));
        estimateSettings.setTerms(estimateSetting.getString("terms"));
        estimateSettings.setTermsToInvoice(estimateSetting.getBoolean("terms_to_invoice"));            //No I18N
        estimateSettings.setNotesToInvoice(estimateSetting.getBoolean("notes_to_invoice"));            //No I18N
        estimateSettings.setWarnEstimateToInvoice(estimateSetting.getBoolean("warn_estimate_to_invoice"));    //No I18N
        estimateSettings.setIsSalesPersonRequired(estimateSetting.getBoolean("is_sales_person_required"));    //No I18N

        return estimateSettings;
    }

    /**
     * Parse the json response and returns the CreditnoteSetting object.
     *
     * @param response This json response contains the creditnote setting details.
     * @return Returns the CreditnoteSetting object.
     */

    public CreditnoteSetting getCreditnoteSettings(String response) throws Exception {
        CreditnoteSetting creditnoteSettings = new CreditnoteSetting();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject creditnoteSetting = jsonObject.getJSONObject("creditnote_settings");    //No I18N

        creditnoteSettings.setAutoGenerate(creditnoteSetting.getBoolean("auto_generate")); //No I18N
        creditnoteSettings.setPrefixString(creditnoteSetting.getString("prefix_string"));
        creditnoteSettings.setReferenceText(creditnoteSetting.getString("reference_text"));
        creditnoteSettings.setNextNumber(creditnoteSetting.getString("next_number"));
        creditnoteSettings.setNotes(creditnoteSetting.getString("notes"));
        creditnoteSettings.setTerms(creditnoteSetting.getString("terms"));

        return creditnoteSettings;
    }

    /**
     * Parse the json response and returns the CurrencyList object.
     *
     * @param response This json response contains list of currencies details.
     * @return Returns the CurrencyList object.
     */

    public CurrencyList getCurrencies(String response) throws Exception {
        CurrencyList currencyList = new CurrencyList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("currencies"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Currency currency = new Currency();

            currency.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            currency.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            currency.setCurrencyName(jsonArray.getJSONObject(i).getString("currency_name"));
            currency.setCurrencySymbol(jsonArray.getJSONObject(i).getString("currency_symbol"));
            currency.setPricePrecision(jsonArray.getJSONObject(i).getInt("price_precision"));    //No I18N
            currency.setCurrencyFormat(jsonArray.getJSONObject(i).getString("currency_format"));
            currency.setIsBaseCurrency(jsonArray.getJSONObject(i).getBoolean("is_base_currency"));    //No I18N
            currency.setExchangeRate(jsonArray.getJSONObject(i).getDouble("exchange_rate"));    //No I18N
            currency.setEffectiveDate(jsonArray.getJSONObject(i).getString("effective_date"));

            currencyList.add(currency);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page"));    //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));

        currencyList.setPageContext(pageContext);

        return currencyList;
    }

    /**
     * Parse the json response and returns the Currency object.
     *
     * @param response This json response contains the currency details.
     * @return Returns the Currency object.
     */

    public Currency getCurrency(String response) throws Exception {
        Currency currencies = new Currency();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject currency = jsonObject.getJSONObject("currency"); //No I18N

        currencies.setCurrencyId(currency.getString("currency_id"));
        currencies.setCurrencyCode(currency.getString("currency_code"));
        currencies.setCurrencyName(currency.getString("currency_name"));
        currencies.setCurrencySymbol(currency.getString("currency_symbol"));
        currencies.setPricePrecision(currency.getInt("price_precision"));    //No I18N
        currencies.setCurrencyFormat(currency.getString("currency_format"));
        currencies.setIsBaseCurrency(currency.getBoolean("is_base_currency"));    //No I18N

        return currencies;

    }

    /**
     * Parse the json response and returns the ExchangeRateList object.
     *
     * @param response This json response contains list of exchange rates details.
     * @return Returns the ExchangeRateList object.
     */

    public ExchangeRateList getExchangeRates(String response) throws Exception {
        ExchangeRateList exchangeRateList = new ExchangeRateList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("exchange_rates"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            ExchangeRate exchangeRate = new ExchangeRate();

            exchangeRate.setExchangeRateId(jsonArray.getJSONObject(i).getString("exchange_rate_id"));
            exchangeRate.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            exchangeRate.setCurrencyCode(jsonArray.getJSONObject(i).getString("currency_code"));
            exchangeRate.setEffectiveDate(jsonArray.getJSONObject(i).getString("effective_date"));
            exchangeRate.setRate(jsonArray.getJSONObject(i).getDouble("rate")); //No I18N

            exchangeRateList.add(exchangeRate);
        }

        return exchangeRateList;
    }

    /**
     * Parse the json response and returns the ExchangeRate object.
     *
     * @param response This json response contains the exchange rate details.
     * @return Returns the ExchangeRate object.
     */

    public ExchangeRate getExchangeRate(String response) throws Exception {
        ExchangeRate exchangeRates = new ExchangeRate();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject exchangeRate = jsonObject.getJSONObject("exchange_rate"); //No I18N

        exchangeRates.setExchangeRateId(exchangeRate.getString("exchange_rate_id"));
        exchangeRates.setCurrencyId(exchangeRate.getString("currency_id"));
        exchangeRates.setCurrencyCode(exchangeRate.getString("currency_code"));
        exchangeRates.setEffectiveDate(exchangeRate.getString("effective_date"));
        exchangeRates.setRate(exchangeRate.getDouble("rate")); //No I18N


        return exchangeRates;
    }

    /**
     * Parse the json response and returns the TaxList object.
     *
     * @param response This json response contains list of taxes details.
     * @return Returns the TaxList object.
     */

    public TaxList getTaxes(String response) throws Exception {

        TaxList taxList = new TaxList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("taxes"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Tax tax = new Tax();

            tax.setTaxId(jsonArray.getJSONObject(i).getString("tax_id"));
            tax.setTaxName(jsonArray.getJSONObject(i).getString("tax_name"));
            tax.setTaxPercentage(jsonArray.getJSONObject(i).getDouble("tax_percentage")); //No I18N
            tax.setTaxType(jsonArray.getJSONObject(i).getString("tax_type"));

            taxList.add(tax);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        taxList.setPageContext(pageContext);

        return taxList;
    }

    /**
     * Parse the json response and returns the Tax object.
     *
     * @param response This json response contains the tax details.
     * @return Returns the Tax object.
     */

    public Tax getTax(String response) throws Exception {
        Tax taxes = new Tax();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject tax = jsonObject.getJSONObject("tax"); //No I18N

        taxes.setTaxId(tax.getString("tax_id"));
        taxes.setTaxName(tax.getString("tax_name"));
        taxes.setTaxPercentage(tax.getDouble("tax_percentage")); //No I18N
        taxes.setTaxType(tax.getString("tax_type"));

        return taxes;
    }

    /**
     * Parse the json response and returns the TaxGroup object.
     *
     * @param response This json response contains the tax group details.
     * @return Returns the TaxGroup object.
     */

    public TaxGroup getTaxGroup(String response) throws Exception {
        TaxGroup taxGroup = new TaxGroup();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject taxgroup = jsonObject.getJSONObject("tax_group"); //No I18N

        taxGroup.setTaxGroupId(taxgroup.getString("tax_group_id"));
        taxGroup.setTaxGroupName(taxgroup.getString("tax_group_name"));
        taxGroup.setTaxGroupPercentage(taxgroup.getDouble("tax_group_percentage")); //No I18N

        JSONArray taxes = taxgroup.getJSONArray("taxes"); //No I18N

        List<Tax> taxesList = new ArrayList<Tax>();

        for (int i = 0; i < taxes.length(); i++) {
            Tax tax = new Tax();

            tax.setTaxId(taxes.getJSONObject(i).getString("tax_id"));
            tax.setTaxName(taxes.getJSONObject(i).getString("tax_name"));
            tax.setTaxPercentage(taxes.getJSONObject(i).getDouble("tax_percentage")); //No I18N
            tax.setTaxType(taxes.getJSONObject(i).getString("tax_type"));

            taxesList.add(i, tax);
        }

        taxGroup.setTaxes(taxesList);

        return taxGroup;
    }

    /**
     * Parse the json response and returns the OpeningBalance object.
     *
     * @param response This json response contains the opening balance details.
     * @return Returns the OpeningBalance object.
     */

    public OpeningBalance getOpeningBalance(String response) throws Exception {
        OpeningBalance openingBalance = new OpeningBalance();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject openBalance = jsonObject.getJSONObject("opening_balance"); //No I18N

        openingBalance.setOpeningBalanceId(openBalance.getString("opening_balance_id"));
        openingBalance.setDate(openBalance.getString("date"));

        JSONArray accounts = openBalance.getJSONArray("accounts"); //No I18N

        List<Account> accountsList = new ArrayList<Account>();

        for (int i = 0; i < accounts.length(); i++) {
            Account account = new Account();

            account.setAccountSplitId(accounts.getJSONObject(i).getString("account_split_id"));
            account.setAccountId(accounts.getJSONObject(i).getString("account_id"));
            account.setAccountName(accounts.getJSONObject(i).getString("account_name"));
            account.setDebitOrCredit(accounts.getJSONObject(i).getString("debit_or_credit"));
            account.setExchangeRate(accounts.getJSONObject(i).getDouble("exchange_rate"));  //No I18N
            account.setCurrencyId(accounts.getJSONObject(i).getString("currency_id"));
            account.setCurrencyCode(accounts.getJSONObject(i).getString("currency_code"));
            account.setBcyAmount(accounts.getJSONObject(i).getDouble("bcy_amount"));    //No I18N
            account.setAmount(accounts.getJSONObject(i).getDouble("amount"));        //No I18N

            accountsList.add(i, account);
        }

        openingBalance.setAccounts(accountsList);

        return openingBalance;
    }


    /**
     * Parse the json response and returns the AutoReminderList object.
     *
     * @param response This json response contains list of auto reminders details.
     * @return Returns the AutoReminderList object.
     */

    public AutoReminderList getAutoReminders(String response) throws Exception {

        AutoReminderList autoReminderList = new AutoReminderList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("autoreminders"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            AutoReminder autoReminder = new AutoReminder();

            autoReminder.setAutoreminderId(jsonArray.getJSONObject(i).getString("autoreminder_id"));
            autoReminder.setIsEnabled(jsonArray.getJSONObject(i).getBoolean("is_enabled")); //No I18N
            autoReminder.setType(jsonArray.getJSONObject(i).getString("type"));
            autoReminder.setAddressType(jsonArray.getJSONObject(i).getString("address_type"));
            autoReminder.setNumberOfDays(jsonArray.getJSONObject(i).getInt("number_of_days")); //No I18N
            autoReminder.setSubject(jsonArray.getJSONObject(i).getString("subject"));
            autoReminder.setBody(jsonArray.getJSONObject(i).getString("body"));
            autoReminder.setOrder(jsonArray.getJSONObject(i).getInt("order")); //No I18N

            autoReminderList.add(autoReminder);
        }

        return autoReminderList;
    }

    /**
     * Parse the json response and returns the AutoReminder object.
     *
     * @param response This json response contains the auto reminder details.
     * @return Returns the AutoReminder object.
     */

    public AutoReminder getAutoReminder(String response) throws Exception {
        AutoReminder autoReminders = new AutoReminder();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject autoReminder = jsonObject.getJSONObject("autoreminder"); //No I18N

        autoReminders.setAutoreminderId(autoReminder.getString("autoreminder_id"));
        autoReminders.setIsEnabled(autoReminder.getBoolean("is_enabled")); //No I18N
        autoReminders.setType(autoReminder.getString("type"));
        autoReminders.setAddressType(autoReminder.getString("address_type"));
        autoReminders.setNumberOfDays(autoReminder.getInt("number_of_days")); //No I18N
        autoReminders.setSubject(autoReminder.getString("subject"));
        autoReminders.setBody(autoReminder.getString("body"));

        JSONObject placeholders = jsonObject.getJSONObject("placeholders"); //No I18N

        JSONArray invoices = placeholders.getJSONArray("Invoice"); //No I18N

        List<Invoice> invoicesList = new ArrayList<Invoice>();

        for (int i = 0; i < invoices.length(); i++) {
            Invoice invoice = new Invoice();

            invoice.setName(invoices.getJSONObject(i).getString("name"));
            invoice.setValue(invoices.getJSONObject(i).getString("value"));

            invoicesList.add(i, invoice);
        }

        autoReminders.setInvoice(invoicesList);

        JSONArray customers = placeholders.getJSONArray("Customer"); //No I18N

        List<Customer> customersList = new ArrayList<Customer>();

        for (int j = 0; j < customers.length(); j++) {
            Customer customer = new Customer();

            customer.setName(customers.getJSONObject(j).getString("name"));
            customer.setValue(customers.getJSONObject(j).getString("value"));

            customersList.add(j, customer);
        }

        autoReminders.setCustomer(customersList);

        JSONArray organizations = placeholders.getJSONArray("Organization"); //No I18N

        List<Organization> organizationsList = new ArrayList<Organization>();

        for (int k = 0; k < organizations.length(); k++) {
            Organization organization = new Organization();

            organization.setName(organizations.getJSONObject(k).getString("name"));
            organization.setValue(organizations.getJSONObject(k).getString("value"));

            organizationsList.add(k, organization);
        }

        autoReminders.setOrganization(organizationsList);

        return autoReminders;

    }

    /**
     * Parse the json response and returns the ManualReminderList object.
     *
     * @param response This json response contains list of manual reminders details.
     * @return Returns the ManualReminderList object.
     */

    public ManualReminderList getManualReminders(String response) throws Exception {

        ManualReminderList manualReminderList = new ManualReminderList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("manualreminders"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            ManualReminder manualReminder = new ManualReminder();

            manualReminder.setManualreminderId(jsonArray.getJSONObject(i).getString("manualreminder_id"));
            manualReminder.setType(jsonArray.getJSONObject(i).getString("type"));
            manualReminder.setSubject(jsonArray.getJSONObject(i).getString("subject"));
            manualReminder.setBody(jsonArray.getJSONObject(i).getString("body"));
            manualReminder.setCcMe(jsonArray.getJSONObject(i).getBoolean("cc_me")); //No I18N

            manualReminderList.add(manualReminder);
        }

        return manualReminderList;
    }


    /**
     * Parse the json response and returns the ManualReminder object.
     *
     * @param response This json response contains the manual reminder details.
     * @return Returns the ManualReminder object.
     */

    public ManualReminder getManualReminder(String response) throws Exception {
        ManualReminder manualReminders = new ManualReminder();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject manualReminder = jsonObject.getJSONObject("manualreminder"); //No I18N

        manualReminders.setManualreminderId(manualReminder.getString("manualreminder_id"));
        manualReminders.setType(manualReminder.getString("type"));
        manualReminders.setSubject(manualReminder.getString("subject"));
        manualReminders.setBody(manualReminder.getString("body"));
        manualReminders.setCcMe(manualReminder.getBoolean("cc_me")); //No I18N

        JSONObject placeholders = jsonObject.getJSONObject("placeholders"); //No I18N

        JSONArray invoices = placeholders.getJSONArray("Invoice"); //No I18N

        List<Invoice> invoicesList = new ArrayList<Invoice>();

        for (int i = 0; i < invoices.length(); i++) {
            Invoice invoice = new Invoice();

            invoice.setName(invoices.getJSONObject(i).getString("name"));
            invoice.setValue(invoices.getJSONObject(i).getString("value"));

            invoicesList.add(i, invoice);
        }

        manualReminders.setInvoice(invoicesList);

        JSONArray customers = placeholders.getJSONArray("Customer"); //No I18N

        List<Customer> customersList = new ArrayList<Customer>();

        for (int j = 0; j < customers.length(); j++) {
            Customer customer = new Customer();

            customer.setName(customers.getJSONObject(j).getString("name"));
            customer.setValue(customers.getJSONObject(j).getString("value"));

            customersList.add(j, customer);
        }

        manualReminders.setCustomer(customersList);

        JSONArray organizations = placeholders.getJSONArray("Organization"); //No I18N

        List<Organization> organizationsList = new ArrayList<Organization>();

        for (int k = 0; k < organizations.length(); k++) {
            Organization organization = new Organization();

            organization.setName(organizations.getJSONObject(k).getString("name"));
            organization.setValue(organizations.getJSONObject(k).getString("value"));

            organizationsList.add(k, organization);
        }

        manualReminders.setOrganization(organizationsList);

        return manualReminders;
    }


}
