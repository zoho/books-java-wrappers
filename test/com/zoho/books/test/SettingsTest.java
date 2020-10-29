/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.SettingsApi;
import com.zoho.books.api.OrganizationsApi;
import com.zoho.books.api.UsersApi;
import com.zoho.books.api.ItemsApi;

import com.zoho.books.model.Preference;
import com.zoho.books.model.Organization;
import com.zoho.books.model.Address;
import com.zoho.books.model.User;
import com.zoho.books.model.Item;
import com.zoho.books.model.InvoiceSetting;
import com.zoho.books.model.NotesAndTerms;
import com.zoho.books.model.EstimateSetting;
import com.zoho.books.model.CreditnoteSetting;
import com.zoho.books.model.Currency;
import com.zoho.books.model.ExchangeRate;
import com.zoho.books.model.Tax;
import com.zoho.books.model.TaxGroup;
import com.zoho.books.model.OpeningBalance;
import com.zoho.books.model.Account;
import com.zoho.books.model.AutoReminder;
import com.zoho.books.model.ManualReminder;
import com.zoho.books.model.UserList;
import com.zoho.books.model.CurrencyList;
import com.zoho.books.model.ExchangeRateList;
import com.zoho.books.model.TaxList;
import com.zoho.books.model.AutoReminderList;
import com.zoho.books.model.ManualReminderList;
import com.zoho.books.model.ItemList;
import com.zoho.books.model.OrganizationList;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class SettingsTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");//No I18N
		
		SettingsApi settingsApi = service.getSettingsApi();
		
		OrganizationsApi organizationsApi = service.getOrganizationsApi();
		
		UsersApi usersApi = service.getUsersApi();
		
		ItemsApi itemsApi = service.getItemsApi();
		
		
		
		
		
		String name = "SahayaRamesh";	//No I18N
		
		String email = "rameshsaha91@gmail.com";	//No I18N
		
		String notes = "Thanks for your business.";	//No I18N
		
		String terms = "Terms and conditions apply.";	//No I18N
		
		String taxGroupId = "36991000000057099";
		
		String taxGroupName = "Income Tax";	//No I18N
		
		String taxIds = "36991000000057097,36991000000057099";
		
		String accountId = "36991000000000370";
		
		String accountSplitId = "36991000000057065";
		
		String filterBy = "Currencies.ExcludeBaseCurrency";	//No I18N
		
		String type = "open_reminder";	//No I18N
		
		String unitId = "";
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("from_date", "2014-02-21");
		hashMap.put("is_current_date", "true");
		
		
		
		Organization organization = new Organization();
		
		organization.setName("SAHAYA");			//No I18N
		organization.setCurrencyCode("INR");		//No I18N
		organization.setTimeZone("Asia/Calcutta");	//No I18N
		
		
		
		User users = new User();
		
		users.setName(name);
		users.setEmail(email);
		users.setUserRole("staff");	//No I18N
		
		
		
		Currency currencies = new Currency();
		
		currencies.setCurrencyCode("INR");	//No I18N
		currencies.setCurrencySymbol("Rs.");	//No I18N
		currencies.setPricePrecision(2);
		currencies.setCurrencyFormat("1,234,567.89");
		
		
		ExchangeRate exchangeRates = new ExchangeRate();
		
		exchangeRates.setEffectiveDate("2013-10-25");
		exchangeRates.setRate(61.00);
		
		
		Tax taxes = new Tax();
			
		taxes.setTaxName("income");	//No I18N
		taxes.setTaxPercentage(2.5);
		taxes.setTaxType("tax");	//No I18N
		
		
		AutoReminder autoReminders = new AutoReminder();
		
		autoReminders.setIsEnabled(true);
		autoReminders.setType("days_after_due_date");	//No I18N
		autoReminders.setAddressType("remind_me");	//No I18N
		autoReminders.setNumberOfDays(0);
		autoReminders.setSubject("Payment Reminder");	//No I18N
		autoReminders.setBody("Dear Customer,\r\rMay we remind you that the invoice %InvoiceNumber% issued on %InvoiceDate% is overdue by %OverdueDays% day(s). If you have already paid for this invoice, accept our apologies and ignore this reminder. We have attached the invoice for your reference.                      \r\rPay online for this invoice by following this <a href= %OnlinePaymentURL% >link</a>. Feel free to get in touch with us for any clarifications.                      \r\rThanks in advance for the payment.");	//No I18N
		
		ManualReminder manualReminders = new ManualReminder();
		
		manualReminders.setSubject("overdue_reminder");	//No I18N
		manualReminders.setBody("Dear Customer,         \r\rMay we remind you that the invoice %InvoiceNumber% issued on %InvoiceDate% is due for payment. If you have already paid for this invoice, accept our apologies and ignore this reminder. We have attached the invoice for your reference.         \r\rTo pay online for this invoice <a href= %OnlinePaymentURL% >click here</a>.         \r\rFeel free to get in touch with us for any clarifications. Thanks in advance for the payment.");	//No I18N
		manualReminders.setCcMe(true);
		
		
		Preference preferences = new Preference();
		
		preferences.setConvertToInvoice(false);
		preferences.setNotifyMeOnOnlinePayment(true);
		preferences.setSendPaymentReceiptAcknowledgement(false);
		preferences.setAutoNotifyRecurringInvoice(true);
		preferences.setSnailMailIncludePaymentStub(false);
		preferences.setIsShowPoweredBy(true);
		preferences.setAttachExpenseReceiptToInvoice("");
		preferences.setAllowAutoCategorize(true);
		preferences.setIsEstimateEnabled(false);
		preferences.setIsProjectEnabled(false);
		
		
		
		Item items = new Item();
		
		items.setName("ITEM");	//No I18N
		items.setDescription("THIS IS THE ITEM.");	//No I18N
		items.setRate(300.00);
		items.setAccountId("831000000000391");
		
		
		try
		{
		
			Preference getPreferences = settingsApi.getPreferences();
		
			String updatePreferences = settingsApi.updatePreferences(preferences);
		
			String createUnit = settingsApi.createUnit("Km");	//No I18N
		
			String deleteUnit = settingsApi.deleteUnit(unitId);
		
		
			OrganizationList getOrganizations = organizationsApi.getOrganizations();
			
			String organizationId = getOrganizations.get(0).getOrganizationId();
		
			Organization createAnOrganization = organizationsApi.create(organization);
			
			Organization getAnOrganization = organizationsApi.get(organizationId);
			
			getAnOrganization.setDateFormat("dd-mm-yyyy"); //No I18N
		
			Organization updateAnOrganization = organizationsApi.update(getAnOrganization);
		
		
		
			UserList getUsers = usersApi.getUsers(hashMap);
			
			String userId = getUsers.get(0).getUserId();
		
			User getCurrentUser = usersApi.getCurrentUser();
		
			User createUser = usersApi.create(users);
			
			User getUser = usersApi.get(userId);
			
			getUser.setName("Ramesh");	//No I18N
		
			User updateUser = usersApi.update(getUser);
		
			String inviteUser = usersApi.inviteUser(userId);
		
			String markUserAsActive = usersApi.markUserAsActive(userId);
		
			String markUserAsInactive = usersApi.markUserAsInactive(userId);
			
			String deleteUser = usersApi.delete(userId);
		
		
		
			ItemList getItems = itemsApi.getItems(hashMap);
		
			String itemId = getItems.get(0).getItemId();
			
			Item createAnItem = itemsApi.create(items);
			
			Item getAnItem = itemsApi.get(itemId);
			
			getAnItem.setName("Gadgets"); //No I18N
		
			Item updateAnItem = itemsApi.update(getAnItem);
		
			String markItemAsActive = itemsApi.markItemAsActive(itemId);
		
			String markItemAsInactive = itemsApi.markItemAsInactive(itemId);
			
			String deleteAnItem = itemsApi.delete(itemId);
		
		
		
		
			InvoiceSetting getInvoiceSettings = settingsApi.getInvoiceSettings();
			
			getInvoiceSettings.setAutoGenerate(true);
		
			InvoiceSetting updateInvoiceSettings = settingsApi.updateInvoiceSettings(getInvoiceSettings);
		
			NotesAndTerms getInvoiceNotesAndTerms = settingsApi.getInvoiceNotesAndTerms();
		
			NotesAndTerms updateInvoiceNotesAndTerms = settingsApi.updateInvoiceNotesAndTerms(notes, terms);
		
		
		
			EstimateSetting getEstimateSettings = settingsApi.getEstimateSettings();
			
			getEstimateSettings.setAutoGenerate(true);
		
			EstimateSetting updateEstimateSettings = settingsApi.updateEstimateSettings(getEstimateSettings);
		
			NotesAndTerms getEstimateNotesAndTerms = settingsApi.getEstimateNotesAndTerms();
		
			NotesAndTerms updateEstimateNotesAndTerms = settingsApi.updateEstimateNotesAndTerms(notes, terms);
		
		
		
			CreditnoteSetting getCreditnoteSettings = settingsApi.getCreditnoteSettings();
			
			getCreditnoteSettings.setAutoGenerate(true);
		
			CreditnoteSetting updateCreditnoteSettings = settingsApi.updateCreditnoteSettings(getCreditnoteSettings);
		
			NotesAndTerms getCreditnoteNotesAndTerms = settingsApi.getCreditnotesNotesAndTerms();
		
			NotesAndTerms updateCreditnoteNotesAndTerms = settingsApi.updateCreditnotesNotesAndTerms(notes, terms);
		
		
		
		
			CurrencyList getCurrencies = settingsApi.getCurrencies(hashMap);
		
			String currencyId = getCurrencies.get(0).getCurrencyId();
		
			Currency createCurrency = settingsApi.createCurrency(currencies);
			
			Currency getCurrency = settingsApi.getCurrency(currencyId);
			
			getCurrency.setCurrencySymbol("Rs."); 	//No I18N
		
			Currency updateCurrency = settingsApi.updateCurrency(getCurrency);
		
			ExchangeRateList getExchangeRates = settingsApi.getExchangeRates(currencyId, null);
			
			String exchangeRateId = getExchangeRates.get(0).getExchangeRateId();
		
			ExchangeRate createExchangeRate = settingsApi.createExchangeRate(currencyId, exchangeRates);
			
			ExchangeRate getExchangeRate = settingsApi.getExchangeRate(currencyId, exchangeRateId);
			
			getExchangeRate.setCurrencyCode("INR");	//No I18N
		
			ExchangeRate updateExchangeRate = settingsApi.updateExchangeRate(currencyId, getExchangeRate);
		
			String deleteExchangeRate = settingsApi.deleteExchangeRate(currencyId, exchangeRateId);
			
			String deleteCurrency = settingsApi.deleteCurrency(currencyId);
		
		
			TaxList getTaxes = settingsApi.getTaxes();
			
			String taxId = getTaxes.get(0).getTaxId();
		
			Tax createTax = settingsApi.createTax(taxes);
			
			Tax getTax = settingsApi.getTax(taxId);
			
			getTax.setTaxName("VAT");	//No I18N
		
			Tax updateTax = settingsApi.updateTax(getTax);
		
			TaxGroup getTaxGroup = settingsApi.getTaxGroup(taxGroupId);
		
			TaxGroup createTaxGroup = settingsApi.createTaxGroup(taxGroupName, taxIds);
		
			String updateTaxGroup = settingsApi.updateTaxGroup(taxGroupId, taxGroupName, taxIds);
		
			String deleteTaxGroup = settingsApi.deleteTaxGroup(taxGroupId);
			
			String deleteTax = settingsApi.deleteTax(taxId);
		
		
		
			OpeningBalance getOpeningBalance = settingsApi.getOpeningBalance();
			
			String openingBalanceId = getOpeningBalance.getOpeningBalanceId();
			
			OpeningBalance openingBalance = new OpeningBalance();
			
			openingBalance.setDate("2013-12-03");
			
			Account account = new Account();
			
			account.setAccountSplitId(accountSplitId);
			account.setAccountId(accountId);
			account.setDebitOrCredit("debit");	//No I18N
			account.setExchangeRate(0.00);
			account.setCurrencyId(currencyId);
			account.setAmount(20.00);
			
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(0, account);
			
			openingBalance.setAccounts(accounts);
		
			OpeningBalance createOpeningBalance = settingsApi.createOpeningBalance(openingBalance);
			
			getOpeningBalance.setDate("2014-06-12");
		
			OpeningBalance updateOpeningBalance = settingsApi.updateOpeningBalance(getOpeningBalance);
		
			String deleteOpeningBalance = settingsApi.deleteOpeningBalance();
		
		
		
			AutoReminderList getAutoPaymentReminders = settingsApi.getAutoPaymentReminders();
			
			String autoreminderId = getAutoPaymentReminders.get(0).getAutoreminderId();
		
			String enableAutoReminder = settingsApi.enableAutoReminder(autoreminderId);
			
			AutoReminder getAutoPaymentReminder = settingsApi.getAutoPaymentReminder(autoreminderId);
			
			getAutoPaymentReminder.setIsEnabled(true);
		
			String updateAutoReminder = settingsApi.updateAutoReminder(autoreminderId, getAutoPaymentReminder);
		
			ManualReminderList getManualReminders = settingsApi.getManualReminders(hashMap);
			
			String manualreminderId = getManualReminders.get(0).getManualreminderId();
		
			ManualReminder getManualReminder = settingsApi.getManualReminder(manualreminderId);
			
			getManualReminder.setCcMe(true);
		
			String updateManualReminder = settingsApi.updateManualReminder(manualreminderId, getManualReminder);
			
			String disableAutoReminder = settingsApi.disableAutoReminder(autoreminderId);
		
		
		
			//System.out.println(updateManualReminder);
			
		}
		catch(BooksException be)
		{
			
			throw be;
		}
		catch(Exception e)
		{
		
			throw e;
		}
	}
}
