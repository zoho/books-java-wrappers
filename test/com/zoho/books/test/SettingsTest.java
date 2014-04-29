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
		service.initialize("{auth_token}", "{organization_id}");//No I18N
		
		SettingsApi settingsApi = service.getSettingsApi();
		
		OrganizationsApi organizationsApi = service.getOrganizationsApi();
		
		UsersApi usersApi = service.getUsersApi();
		
		ItemsApi itemsApi = service.getItemsApi();
		
		
		
		
		String organizationId = "10578008";
		
		
		String userId = "36991000000013001";
		
		String name = "SahayaRamesh";	//No I18N
		
		String email = "rameshsaha91@gmail.com";	//No I18N
		
		String notes = "Thanks for your business.";	//No I18N
		
		String terms = "Terms and conditions apply.";	//No I18N
		
		String currencyId = "36991000000000099";
		
		String exchangeRateId = "36991000000051003";
		
		String taxId = "36991000000057001";
		
		String taxGroupId = "36991000000057099";
		
		String taxGroupName = "Income Tax";	//No I18N
		
		String taxIds = "36991000000057097,36991000000057099";
		
		String accountId = "36991000000000370";
		
		String openingBalanceId = "36991000000057061";
		
		String accountSplitId = "36991000000057065";
		
		String autoreminderId = "36991000000002001";
		
		String manualreminderId = "36991000000000076";
		
		String itemId = "36991000000054013";
		
		String filterBy = "Currencies.ExcludeBaseCurrency";	//No I18N
		
		String type = "open_reminder";	//No I18N
		
		String unitId = "";
		
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
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
		
		
		
		InvoiceSetting invoiceSettings = new InvoiceSetting();
		
		invoiceSettings.setAutoGenerate(true);
		invoiceSettings.setPrefixString("INV-");	//No I18N
		invoiceSettings.setStartAt(1);
		invoiceSettings.setNextNumber("45");
		invoiceSettings.setQuantityPrecision(0);
		invoiceSettings.setReferenceText("");
		invoiceSettings.setNotes("thanks for your business.");		//No I18N
		invoiceSettings.setTerms("terms and conditions apply.");	//No I18N
		invoiceSettings.setIsShippingChargeRequired(false);
		invoiceSettings.setIsAdjustmentRequired(true);
		invoiceSettings.setInvoiceItemType("");
		invoiceSettings.setIsShowInvoiceSetup(true);
		invoiceSettings.setDiscountType("");
		invoiceSettings.setWarnConvertToOpen(true);
		invoiceSettings.setWarnCreateCreditnotes(true);
		invoiceSettings.setIsOpenInvoiceEditable(true);
		invoiceSettings.setIsSalesPersonRequired(true);
		
		
		EstimateSetting estimateSettings = new EstimateSetting();
		
		estimateSettings.setAutoGenerate(true);
		estimateSettings.setPrefixString("EST-");	//No I18N
		estimateSettings.setStartAt(1);
		estimateSettings.setNextNumber("25");
		estimateSettings.setQuantityPrecision(0);
		estimateSettings.setReferenceText("");
		estimateSettings.setNotes("thanks for your business.");		//No I18N
		estimateSettings.setTerms("terms and conditions apply.");	//No I18N
		estimateSettings.setTermsToInvoice(true);
		estimateSettings.setNotesToInvoice(true);
		estimateSettings.setWarnEstimateToInvoice(true);
		estimateSettings.setDiscountType("");
		estimateSettings.setIsSalesPersonRequired(true);
		
		
		CreditnoteSetting creditnoteSettings = new CreditnoteSetting();
		
		creditnoteSettings.setAutoGenerate(true);
		creditnoteSettings.setPrefixString("CN-");	//No I18N
		creditnoteSettings.setNextNumber("15");
		creditnoteSettings.setReferenceText("");
		creditnoteSettings.setNotes("thanks for your business.");	//No I18N
		creditnoteSettings.setTerms("terms and conditions apply.");	//No I18N
		
		
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
		
		
		OpeningBalance openingBalance = new OpeningBalance();
		
		openingBalance.setOpeningBalanceId(openingBalanceId);
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
		
		items.setItemId(itemId);
		
		items.setName("ITEM");	//No I18N
		items.setDescription("THIS IS THE ITEM.");	//No I18N
		items.setRate(300.00);
		items.setAccountId("831000000000391");
		items.setTaxId(taxId);
		
		
		try
		{
		
			Preference getPreferences = settingsApi.getPreferences();
		
			String updatePreferences = settingsApi.updatePreferences(preferences);
		
			String createUnit = settingsApi.createUnit("Km");	//No I18N
		
			String deleteUnit = settingsApi.deleteUnit(unitId);
		
		
			OrganizationList getOrganizations = organizationsApi.getOrganizations();
		
			Organization getAnOrganization = organizationsApi.get(organizationId);
		
			Organization createAnOrganization = organizationsApi.create(organization);
		
			Organization updateAnOrganization = organizationsApi.update(organization);
		
		
		
			UserList getUsers = usersApi.getUsers(hashMap);
		
			User getUser = usersApi.get(userId);
		
			User getCurrentUser = usersApi.getCurrentUser();
		
			User createUser = usersApi.create(users);
		
			User updateUser = usersApi.update(users);
		
			String inviteUser = usersApi.inviteUser(userId);
		
			String markUserAsActive = usersApi.markUserAsActive(userId);
		
			String markUserAsInactive = usersApi.markUserAsInactive(userId);
			
			String deleteUser = usersApi.delete(userId);
		
		
		
			ItemList getItems = itemsApi.getItems(hashMap);
		
			Item getAnItem = itemsApi.get(itemId);
		
			Item createAnItem = itemsApi.create(items);
		
			Item updateAnItem = itemsApi.update(items);
		
			String markItemAsActive = itemsApi.markItemAsActive(itemId);
		
			String markItemAsInactive = itemsApi.markItemAsInactive(itemId);
			
			String deleteAnItem = itemsApi.delete(itemId);
		
		
		
		
			InvoiceSetting getInvoiceSettings = settingsApi.getInvoiceSettings();
		
			InvoiceSetting updateInvoiceSettings = settingsApi.updateInvoiceSettings(invoiceSettings);
		
			NotesAndTerms getInvoiceNotesAndTerms = settingsApi.getInvoiceNotesAndTerms();
		
			NotesAndTerms updateInvoiceNotesAndTerms = settingsApi.updateInvoiceNotesAndTerms(notes, terms);
		
		
		
			EstimateSetting getEstimateSettings = settingsApi.getEstimateSettings();
		
			EstimateSetting updateEstimateSettings = settingsApi.updateEstimateSettings(estimateSettings);
		
			NotesAndTerms getEstimateNotesAndTerms = settingsApi.getEstimateNotesAndTerms();
		
			NotesAndTerms updateEstimateNotesAndTerms = settingsApi.updateEstimateNotesAndTerms(notes, terms);
		
		
		
			CreditnoteSetting getCreditnoteSettings = settingsApi.getCreditnoteSettings();
		
			CreditnoteSetting updateCreditnoteSettings = settingsApi.updateCreditnoteSettings(creditnoteSettings);
		
			NotesAndTerms getCreditnoteNotesAndTerms = settingsApi.getCreditnotesNotesAndTerms();
		
			NotesAndTerms updateCreditnoteNotesAndTerms = settingsApi.updateCreditnotesNotesAndTerms(notes, terms);
		
		
		
		
			CurrencyList getCurrencies = settingsApi.getCurrencies(hashMap);
		
			String curId = getCurrencies.get(0).getCurrencyId();
		
			Currency getCurrency = settingsApi.getCurrency(currencyId);
		
			Currency createCurrency = settingsApi.createCurrency(currencies);
		
			Currency updateCurrency = settingsApi.updateCurrency(currencies);
		
			ExchangeRateList getExchangeRates = settingsApi.getExchangeRates(currencyId, null);
		
			ExchangeRate getExchangeRate = settingsApi.getExchangeRate(currencyId, exchangeRateId);
		
			ExchangeRate createExchangeRate = settingsApi.createExchangeRate(currencyId, exchangeRates);
		
			ExchangeRate updateExchangeRate = settingsApi.updateExchangeRate(currencyId, exchangeRates);
		
			String deleteExchangeRate = settingsApi.deleteExchangeRate(currencyId, exchangeRateId);
			
			String deleteCurrency = settingsApi.deleteCurrency(currencyId);
		
		
			TaxList getTaxes = settingsApi.getTaxes();
		
			Tax getTax = settingsApi.getTax(taxId);
		
			Tax createTax = settingsApi.createTax(taxes);
		
			Tax updateTax = settingsApi.updateTax(taxes);
		
			TaxGroup getTaxGroup = settingsApi.getTaxGroup(taxGroupId);
		
			TaxGroup createTaxGroup = settingsApi.createTaxGroup(taxGroupName, taxIds);
		
			String updateTaxGroup = settingsApi.updateTaxGroup(taxGroupId, taxGroupName, taxIds);
		
			String deleteTaxGroup = settingsApi.deleteTaxGroup(taxGroupId);
			
			String deleteTax = settingsApi.deleteTax(taxId);
		
		
		
			OpeningBalance getOpeningBalance = settingsApi.get();
		
			OpeningBalance createOpeningBalance = settingsApi.create(openingBalance);
		
			OpeningBalance updateOpeningBalance = settingsApi.update(openingBalance);
		
			String deleteOpeningBalance = settingsApi.delete();
		
		
		
			AutoReminderList getAutoPaymentReminders = settingsApi.getAutoPaymentReminders();
		
			AutoReminder getAutoPaymentReminder = settingsApi.getAutoPaymentReminder(autoreminderId);
		
			String enableAutoReminder = settingsApi.enableAutoReminder(autoreminderId);
		
			String updateAutoReminder = settingsApi.updateAutoReminder(autoreminderId, autoReminders);
		
			ManualReminderList getManualReminders = settingsApi.getManualReminders(hashMap);
		
			ManualReminder getManualReminder = settingsApi.getManualReminder(manualreminderId);
		
			String updateManualReminder = settingsApi.updateManualReminder(manualreminderId, manualReminders);
			
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
