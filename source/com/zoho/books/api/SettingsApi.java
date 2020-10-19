/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.SettingsParser;

import com.zoho.books.model.Preference;
import com.zoho.books.model.InvoiceSetting;
import com.zoho.books.model.NotesAndTerms;
import com.zoho.books.model.EstimateSetting;
import com.zoho.books.model.CreditnoteSetting;
import com.zoho.books.model.Currency;
import com.zoho.books.model.ExchangeRate;
import com.zoho.books.model.Tax;
import com.zoho.books.model.TaxGroup;
import com.zoho.books.model.OpeningBalance;
import com.zoho.books.model.AutoReminder;
import com.zoho.books.model.ManualReminder;
import com.zoho.books.model.CurrencyList;
import com.zoho.books.model.ExchangeRateList;
import com.zoho.books.model.TaxList;
import com.zoho.books.model.AutoReminderList;
import com.zoho.books.model.ManualReminderList;

import java.util.HashMap;

import org.json.JSONObject;

/**

* SettingsApi is used to get and update the prefernce and create, delete the unit.

* It is used to get:<br><br>

	The invoice, estimate and credit note settings.<br>
	
	The invoice, estimate and creditnote notes and terms.<br>
	
	The list of all currencies.<br>
	
	The details of a currency.<br>
	
	The list of all exchange rates.<br>
	
	The details of an exchange rate.<br>
	
	The list of all taxes.<br>
	
	The details of a tax.<br>
	
	The details of a tax group.<br>
	
	The details of an opening balance.<br>
	
	The list of all auto reminders.<br>
	
	The details of an auto reminder.<br>
	
	The list of all manual reminders.<br>
	
	The details of a manual reminder.<br><br>
	
It is used to create:<br><br>

	The currency for transactions.<br>
	
	The exchange for the currency.<br>
	
	The tax associated with an item.<br>
	
	The tax group associating multiple taxes.<br>
	
	The opening balance.<br><br>
	
* It is used to enable and disable auto reminders.<br><br>
	
* It is used to update:<br><br>

	The details of invoice, estimate and creditnotes settings.<br>
	
	The details of invoice, estimates and creditnotes notes and terms.<br>
	
	The details of a currency.<br>
	
	The details of an exchange rate.<br>
	
	The details of a tax.<br>
	
	The details of a tax group.<br>
	
	The details of an opening balance.<br>
	
	The details of an auto reminder.<br>
	
	The details of a manual reminder.<br><br>
	
* It is used to delete.<br><br>

	The existing currency.<br>
	
	The existing exchange rate.<br>
	
	The existing tax.<br>
	
	The existing tax group.<br>
	
	The existing opening balance.

*/

public class SettingsApi extends API
{
	private static String url = baseURL+"/settings"; //No I18N
	
	/**
	
	* Construct a new SettingsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public SettingsApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	
	private SettingsParser settingsParser = new SettingsParser();
	
	
	/**
	
	* List of preferences that are configured.
	
	* It returns the Preference object.
	
	
	* @return Returns the Preference object.
	
	*/
	
	public Preference getPreferences()throws Exception
	{
		
		String urlString = url+"/preferences"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		Preference preference = settingsParser.getPreferences(response);
		
		return preference;
	}
	
	/**
	
	* Update the preferences that has been configured.
	
	* Pass the preference object to update the details of a preference.
	
	* If the preference has been updated it returns the success message.
	
	* The success message is "Preferences have been saved."
	
	
	* @param preference Preference object.
	
	* @return Returns a String.
	
	*/
	
	public String updatePreferences(Preference preference)throws Exception
	{
		
		String urlString = url+"/preferences"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", preference.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Create a unit the can be associated to a line item.
	
	* Pass the unit to create a new unit for the item.
	
	* If the unit has been added it returns the success message.
	
	* The success message is "Unit added."
	
	
	* @param unit Representation for the unit. For instance kg.
	
	* @return Returns a String.
	
	*/
	
	public String createUnit(String unit)throws Exception
	{
		
		String urlString = url+"/units"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("unit", unit);
		
		requestBody.put("JSONString", jsonObject.toString());

		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Delete a unit that has been associated to an item.
	
	* Pass the unitId to delete the unit.
	
	* If the unit has been deleted it returns the success message.
	
	* The success message is "You have successfully deleted the unit."
	
	
	* @param unitId ID of the unit.
	
	* @return Returns a String.
	
	*/
	
	public String deleteUnit(String unitId)throws Exception
	{
		
		String urlString = url+"/units/"+unitId; //No I18N

		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
		
	}
	
	
//=========================================================================================================================================



	/**
	
	* Get the details of invoice settings.
	
	* It returns the InvoiceSetting object.
	
	
	* @return Returns the InvoiceSetting object. 
	
	*/
	
	public InvoiceSetting getInvoiceSettings()throws Exception
	{
		String urlString = url+"/invoices"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		InvoiceSetting invoiceSetting = settingsParser.getInvoiceSettings(response);
		
		return invoiceSetting;
	}
	
	/**
	
	* Update the settings information for invoices.
	
	* Pass the InvoiceSetting object to update the details of a invoice settings.
	
	* It returns the InvoiceSetting object.
	
	
	* @param invoiceSetting InvoiceSetting object.
	
	* @return Returns the InvoiceSetting object.
	
	*/
	
	public InvoiceSetting updateInvoiceSettings(InvoiceSetting invoiceSetting)throws Exception
	{
	
		String urlString = url+"/invoices";  //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", invoiceSetting.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getInvoiceSettings(response);
	}
	
	/**
	
	* Get the details of invoice notes and terms.
	
	* It returns the NotesAndTerms object.
	
	
	* @return Returns NotesAndTerms object.
	
	*/
	
	public NotesAndTerms getInvoiceNotesAndTerms()throws Exception
	{
		
		String urlString = url+"/invoices/notesandterms"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		NotesAndTerms notesAndTerms = settingsParser.getNotesAndTerms(response);
		
		return notesAndTerms;
	}
	
	/**
	
	* Update the notes and terms for invoices.
	
	* Pass the notes and terms to update the invoice notes and terms.
	
	* It returns the NotesAndTerms object.
	
	
	* @param notes Notes to the customer.
	
	* @param terms Terms and conditions.
	
	* @return Returns the NotesAndTerms object.
	
	*/
	
	public NotesAndTerms updateInvoiceNotesAndTerms(String notes, String terms)throws Exception
	{
		
		String urlString = url+"/invoices/notesandterms"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("notes", notes);
		jsonObject.put("terms", terms);
		
		requestBody.put("JSONString", jsonObject.toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		NotesAndTerms notesAndTerms = settingsParser.getNotesAndTerms(response);
		
		return notesAndTerms;
	}
	
//=========================================================================================================================================



	/**
	
	* Get the details of estimate settings.
	
	* It retruns the EstimateSetting object.
	
	
	* @return Returns the EstimateSetting object.
	
	*/
	
	public EstimateSetting getEstimateSettings()throws Exception
	{
		
		String urlString = url+"/estimates";  //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		EstimateSetting estimateSetting = settingsParser.getEstimateSettings(response);
		
		return estimateSetting;
	}
	
	/**
	
	* Update the settings that are configured for estimates.
	
	* Pass the EstimateSetting object to update the details of an estimate setting.
	
	* It returns the EstimateSetting object.
	
	
	* @param estimateSetting EstimateSetting object.
	
	* @return Returns the EstimateSetting object.
	
	*/
	
	public EstimateSetting updateEstimateSettings(EstimateSetting estimateSetting)throws Exception
	{
		
		String urlString = url+"/estimates";  //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", estimateSetting.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getEstimateSettings(response);
	}
	
	
	/**
	
	* Get the details of estimate notes and terms.
	
	* It returns the estimates NotesAndTerms object.
	
	
	* @return Returns the NotesAndTerms object.
	
	*/
	
	public NotesAndTerms getEstimateNotesAndTerms()throws Exception
	{
		
		String urlString = url+"/estimates/notesandterms";  //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		NotesAndTerms notesAndTerms = settingsParser.getNotesAndTerms(response);
		
		return notesAndTerms;
	}
	
	/**
	
	* Update the details of the estimate notes and terms.
	
	* Pass the notes and terms to update the details of estimates notes and terms.
	
	* It returns the NotesAndTerms object.
	
	
	* @param notes Notes to the customer.
	
	* @param terms Terms and conditions.
	
	* @return Returns the NotesAndTerms object.
	
	*/
	
	public NotesAndTerms updateEstimateNotesAndTerms(String notes, String terms)throws Exception
	{
		
		String urlString = url+"/estimates/notesandterms";  //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("notes", notes);
		jsonObject.put("terms", terms);
		
		requestBody.put("JSONString", jsonObject.toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		NotesAndTerms notesAndTerms = settingsParser.getNotesAndTerms(response);
		
		return notesAndTerms;
	}
	
	
//=========================================================================================================================================



	/**
	
	* List of settings applied for creditnotes.
	
	* It returns the CreditnoteSetting object.
	
	
	* @return Returns the CreditnoteSetting object.
	
	*/
	
	public CreditnoteSetting getCreditnoteSettings()throws Exception
	{
		String urlString = url+"/creditnotes";  //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		CreditnoteSetting creditnoteSetting = settingsParser.getCreditnoteSettings(response);
		
		return creditnoteSetting;
	}
	
	/**
	
	* Update the settings associated to creditnotes.
	
	* Pass the CreditnoteSetting object to update the details of a credit note settings.
	
	* It retruns the CreditnoteSetting object.
	
	
	* @param creditnoteSetting CreditnoteSetting object.
	
	* @return Returns the CreditnoteSetting object.
	
	*/
	
	public CreditnoteSetting updateCreditnoteSettings(CreditnoteSetting creditnoteSetting)throws Exception
	{
		
		String urlString = url+"/creditnotes";  //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", creditnoteSetting.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getCreditnoteSettings(response);
	}
	
	/**
	
	* Get the contents of creditnote notes and terms.
	
	* It returns the creditnotes NotesAndTerms object.
	
	
	* @return Returns the NotesAndTerms object.
	
	*/
	
	public NotesAndTerms getCreditnotesNotesAndTerms()throws Exception
	{
		
		String urlString = url+"/creditnotes/notesandterms";  //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		NotesAndTerms notesAndTerms = settingsParser.getNotesAndTerms(response);
		
		return notesAndTerms;
	}
	
	/**
	
	* Update the notes and terms field for creditnotes.
	
	* Pass the notes and terms to update the creditnotes notes and terms.
	
	* It returns the NotesAndTerms object.
	
	
	* @param notes Notes to the customer.
	
	* @param terms Terms and conditions.
	
	* @return Returns the NotesAndTerms object.
	
	*/
	
	public NotesAndTerms updateCreditnotesNotesAndTerms(String notes, String terms)throws Exception
	{
		
		String urlString = url+"/creditnotes/notesandterms"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("notes", notes);
		jsonObject.put("terms", terms);
		
		requestBody.put("JSONString", jsonObject.toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		NotesAndTerms notesAndTerms = settingsParser.getNotesAndTerms(response);
		
		return notesAndTerms;
	}
	
	
//=========================================================================================================================================


	/**
	
	* List of configured currencies with pagination.
	
	* Pass the filters to get all the currencies based on the filter.
	
	* It returns the CurrencyList object.<br>
	
	* The queryMap contains the possible key and value as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>filter_by</td><td>Filter list of configured currencies excluding the base currency.<br>
Allowed Values: <i>Currencies.ExcludeBaseCurrency</i></td></tr>

			</tbody>
		
		</table> 
	
	* @param queryMap Filter list of configured currencies excluding the base currency.
	
	* @return Returns the CurrencyList object.
	
	*/
	
	public CurrencyList getCurrencies(HashMap<String, Object> queryMap)throws Exception
	{
	
		String urlString = url+"/currencies"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);

		CurrencyList currencyList = settingsParser.getCurrencies(response);
		
		return currencyList;
	}
	
	/**
	
	* Get the details of a currency.
	
	* Pass the currencyId to get the details of a currency.
	
	* It returns the Currency object.
	
	
	* @param currencyId ID of the currency.
	
	* @return Returns the Currency object.
	
	*/
	
	public Currency getCurrency(String currencyId)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		Currency currency = settingsParser.getCurrency(response);
		
		return currency;
	}
	
	/**
	
	* Create a currency for transactions.
	
	* Pass the Currency object to create a currency.
	
	* The Currency object which contains currencyCode, currencySymbol, and currencyFormat are the mandatory parameters.
	
	* It returns the Currency object.
	
	
	* @param currency Currency object.
	
	* @return Returns the Currency object.
	
	*/
	
	public Currency createCurrency(Currency currency)throws Exception
	{
		
		String urlString = url+"/currencies"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", currency.toJSON().toString());

		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);

		return settingsParser.getCurrency(response);
	}
	
	/**
	
	* Update the details of a currency.
	
	* Pass the Currency object to update the details of a currency.
	
	* The Currency object which contains currencyId is the mandatory parameter for which currency details has to be updated.
	
	* It returns the Currency object.
	
	
	* @param currency Currency object.
	
	* @return Returns the Currency object.
	
	*/
	
	public Currency updateCurrency(Currency currency)throws Exception
	{
		
		String urlString = url+"/currencies/"+currency.getCurrencyId(); //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", currency.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getCurrency(response);
	}
	
	/**
	
	* Delete a currency. Currency that is associated to transactions cannot be deleted.
	
	* Pass the currencyId to delete the currency.
	
	* If the currency has been deleted it returns the success message.
	
	* The success message is "The currency has been deleted."
	
	
	* @param currencyId ID of the Currency.
	
	* @return Returns a String.
	
	*/
	
	public String deleteCurrency(String currencyId)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId; //No I18N

		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List of exchange rates configured for the currency.
	
	* Pass the currencyId and filters to get all the exchange rates for the currency based on the filter.
	
	* It returns the ExchangeRateList object. <br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>from_date</td><td>Returns the exchange rate details from the given date or from previous closest match in the absence of the exchange rate on the given date.</td></tr>

				<tr><td>is_current_date</td><td>To return the exchange rate only if available for current date.</td></tr>

			</tbody>
		
		</table> 
	
	
	* @param currencyId ID of the Currency.
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the ExchangeRateList object.
	
	*/
	
	public ExchangeRateList getExchangeRates(String currencyId, HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId+"/exchangerates"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);

		ExchangeRateList exchangeRateList = settingsParser.getExchangeRates(response);
		
		return exchangeRateList;
	}
	
	/**
	
	* Get the details of an exchange rate that has been associated to the currency.
	
	* Pass the currencyId and exchangeRateId to get the details of an exchange rate.
	
	* It returns the ExchangeRate object.
	
	
	* @param currencyId ID of the currency.
	
	* @param exchangeRateId ID of the exchanege rate.
	
	* @return Returns the ExchangeRate object.
	
	*/
	
	public ExchangeRate getExchangeRate(String currencyId, String exchangeRateId)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId+"/exchangerates/"+exchangeRateId; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		ExchangeRate exchangeRate = settingsParser.getExchangeRate(response);
		
		return exchangeRate;
	}
	
	/**
	
	* Create an exchange rate for the specified currency.
	
	* Pass the currencyId and ExcahngeRate object to create an exchange rate for the currency.
	
	* The ExchangeRate object which contains effectiveDate and rate are the mandatory parameters.
	
	* It returns the ExchangeRate object.
	
	
	* @param currencyId ID of the exchange rate.
	
	* @param exchangeRate ExchangeRate object.
	
	* @return Returns the ExchangeRate object.
	
	*/
	
	public ExchangeRate createExchangeRate(String currencyId, ExchangeRate exchangeRate)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId+"/exchangerates"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", exchangeRate.toJSON().toString());

		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);

		return settingsParser.getExchangeRate(response);
	}
	
	/**
	
	* Update the details of exchange rate for a currency.
	
	* Pass the currencyId and ExcahangeRate object to update the details of an exchange rate.
	
	* The ExchangeRate object which contains exchangeRateId is the mandatory parameter for which exchange rate details has to be updated.
	
	* It returns the ExchangeRate object.
	
	
	* @param currencyId ID of the currency.
	
	* @param exchangeRate ExchangeRate object.
	
	* @return Returns the ExchangeRate object.
	
	*/
	
	public ExchangeRate updateExchangeRate(String currencyId, ExchangeRate exchangeRate)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId+"/exchangerates/"+exchangeRate.getExchangeRateId(); //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", exchangeRate.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getExchangeRate(response);
	}
	
	/**
	
	* Delete an exchange rate for the specified currency.
	
	* Pass the currencyId and excahngeRateId to delete the exchange rate.
	
	* If the exchange rate has been deleted it returns the success message.
	
	* The success message is "Exchange rate successfully deleted."
	
	
	* @param currencyId ID of the currency.
	
	* @param exchangeRateId ID of the exchanege rate.
	
	* @return Returns a String.
	
	*/
	
	public String deleteExchangeRate(String currencyId, String exchangeRateId)throws Exception
	{
		
		String urlString = url+"/currencies/"+currencyId+"/exchangerates/"+exchangeRateId; //No I18N

		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
//=========================================================================================================================================


	/**
	
	* List of simple tax, compound tax and tax groups with pagination.
	
	* It returns the TaxList object.
	
	
	* @return Returns the TaxList object.
	
	*/
	
	public TaxList getTaxes()throws Exception
	{
		
		String urlString = url+"/taxes"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		TaxList taxList = settingsParser.getTaxes(response);
		
		return taxList;
	}
	
	/**
	
	* Get the details of a simple tax, compound tax or tax group.
	
	* Pass the taxId to get the details of a tax.
	
	* It returns the Tax object.
	
	
	* @param taxId ID of the tax.
	
	* @return Returns the Tax object.
	
	*/
	
	public Tax getTax(String taxId)throws Exception
	{
		
		String urlString = url+"/taxes/"+taxId; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		Tax tax = settingsParser.getTax(response);
		
		return tax;
	}
	
	/**
	
	* Create a simple or compound tax that can be associated with an item.
	
	* Pass the Tax object to create a tax.
	
	* The Tax object which contains taxName and taxPercentage are the mandatory parameters.
	
	* It returns the Tax object.
	 
	
	* @param tax Tax object.
	
	* @return Returns the Tax object.
	
	*/
	
	public Tax createTax(Tax tax)throws Exception
	{
		
		String urlString = url+"/taxes"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", tax.toJSON().toString());

		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);

		return settingsParser.getTax(response);
	}
	
	/**
	
	* Update the details of a simple or compound tax.
	
	* Pass the Tax object to update the details of a tax.
	
	* The Tax object which contains taxId is the mandatory parameter for which tax details has to be updated.
	
	* It returns the Tax object.
	
	
	* @param tax Tax object.
	
	* @return Returns the Tax object.
	
	*/
	
	public Tax updateTax(Tax tax)throws Exception
	{
		
		String urlString = url+"/taxes/"+tax.getTaxId(); //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", tax.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getTax(response);
	}
	
	/**
	
	* Delete a simple or compound tax.
	
	* Pass the taxId to delete the tax.
	
	* If the tax has been deleted it returns the success message.
	
	* The success message is "The record has been deleted."
	
	
	* @param taxId ID of the tax.
	
	* @return Returns a String.
	
	*/
	
	public String deleteTax(String taxId)throws Exception
	{
		
		String urlString = url+"/taxes/"+taxId; //No I18N

		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Get the details of a tax group with associated taxes.
	
	* Pass the taxGroupId to get the details of a tax group.
	
	* It returns the TaxGroup object.
	
	
	* @param taxGroupId ID of the tax group.
	
	* @return Returns the TaxGroup object.
	
	*/
	
	public TaxGroup getTaxGroup(String taxGroupId)throws Exception
	{
		
		String urlString = url+"/taxgroups/"+taxGroupId; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		TaxGroup taxGroup = settingsParser.getTaxGroup(response);
		
		return taxGroup;
	}
	
	/**
	
	* Create a tax group associating multiple taxes (A tax group should contain minimum of 2 taxes.Only one compund tax can be associated to a tax group along with other taxes).
	
	* Pass the taxGroupName and taxIds to create a tax group.
	
	* It Returns the TaxGroup object.
	
	
	* @param taxGroupName Name of the tax group.
	
	* @param taxes List of tax IDs that are to be associated to the tax group
	
	* @return Returns the TaxGroup object.
	
	*/
	
	public TaxGroup createTaxGroup(String taxGroupName, String taxes)throws Exception
	{
		
		String urlString = url+"/taxgroups"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("tax_group_name", taxGroupName);
		jsonObject.put("taxes", taxes);
		
		requestBody.put("JSONString", jsonObject.toString());

		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);

		TaxGroup taxGroup = settingsParser.getTaxGroup(response);
		
		return taxGroup;
	}
	
	/**
	
	* Update the details of a tax group.
	
	* Pass the taxGroupId, taxGroupName, and taxIds to update the details for the tax group.
	
	* If the tax group details has been updated it returns the success message.
	
	* The success message is "Tax Group information has been saved."
	
	
	* @param taxGroupId ID of the tax group.
	
	* @param taxGroupName Name of the tax group.
	
	* @param taxes List of tax IDs that are to be associated to the tax group.
	
	* @return Returns a String.
	
	*/
	
	public String updateTaxGroup(String taxGroupId, String taxGroupName, String taxes)throws Exception
	{
		
		String urlString = url+"/taxgroups/"+taxGroupId; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("tax_group_name", taxGroupName);
		jsonObject.put("taxes", taxes);
		
		requestBody.put("JSONString", jsonObject.toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Delete a created tax group.
	
	* Pass the taxGroupId to delete the tax group.
	
	* If the tax group has been deleted it returns the success message.
	
	* The success message is "The tax group has been deleted."
	
	
	* @param taxGroupId ID of the tax group.
	
	* @return Returns a String.
	
	*/
	
	public String deleteTaxGroup(String taxGroupId)throws Exception
	{
		
		String urlString = url+"/taxgroups/"+taxGroupId;  //No I18N

		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	

//=========================================================================================================================================



	/**
	
	* Get opening balance.
	
	* It returns the OpeningBalance object.
	
	
	* @return Returns the OpeningBalance object.
	
	*/
	
	public OpeningBalance getOpeningBalance()throws Exception
	{
		
		String urlString = url+"/openingbalances"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		OpeningBalance openingBalance = settingsParser.getOpeningBalance(response);
		
		return openingBalance;
	}
	
	/**
	
	* Creates opening balance with the given information.
	
	* Pass the OpeningBalance object to create a opening balance.
	
	* The OpeningBalance object which contains date and debitOrCredit are the mandatory parameters.
	
	* It returns the OpeningBalance object.
	
	
	* @param openingBalance OpeningBalance object.
	
	* @return Returns the OpeningBalance object.
	
	*/
	
	public OpeningBalance createOpeningBalance(OpeningBalance openingBalance)throws Exception
	{
		
		String urlString = url+"/openingbalances"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", openingBalance.toJSON().toString());

		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);

		return settingsParser.getOpeningBalance(response);
		
	}
	
	/**
	
	* Updates the existing opening balance information.
	
	* Pass the OpeningBalance object to update the details of an opening balance.
	
	* It returns the OpeningBalance object.
	
	
	* @param openingBalance OpeningBalance object.
	
	* @return Returns the OpeningBalance object.
	
	*/
	
	public OpeningBalance updateOpeningBalance(OpeningBalance openingBalance)throws Exception
	{
		
		String urlString = url+"/openingbalances"; //No I18N
		
		HashMap<String, Object> requestBody = getQueryMap();
		
		requestBody.put("JSONString", openingBalance.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		return settingsParser.getOpeningBalance(response);
	}
	
	/**
	
	* Delete the entered opening balance.
	
	* If the opening balance has been deleted it returns the success message.
	
	* The success message is "The entered opening balance has been deleted."
	
	
	* @return Returns a String.
	
	*/
	
	public String deleteOpeningBalance()throws Exception
	{
		
		String urlString = url+"/openingbalances";  //No I18N

		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	
//=========================================================================================================================================


	/**
	
	* List of automated payment reminders.
	
	* It returns the AutoReminderList object.
	
	
	* @return Returns the AutoReminderList object.
	
	*/
	
	public AutoReminderList getAutoPaymentReminders()throws Exception
	{
		
		String urlString = url+"/autoreminders"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		AutoReminderList autoReminderList = settingsParser.getAutoReminders(response);
		
		return autoReminderList;
	}
	
	/**
	
	* Get the details of an automated payment reminder.
	
	* Pass the templateId to get the details of an auto reminder.
	
	* It returns the AutoReminder object.
	
	
	* @param templateId ID of the template.
	
	* @return Returns the AutoReminder object.
	
	*/
	
	public AutoReminder getAutoPaymentReminder(String templateId)throws Exception
	{
		
		String urlString = url+"/autoreminders/"+templateId; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		AutoReminder autoReminder = settingsParser.getAutoReminder(response);
		
		return autoReminder;
	}
	
	/**
	
	* Enable an automated payment reminder.
	
	* Pass the reminderId to enable the auto reminder.
	
	* If the auto reminder has been enabled it returns the success message.
	
	* The success message is "Payment reminder has been enabled."
	
	
	* @param reminderId ID of the reminder.
	
	* @return Returns a String.
	
	*/
	
	public String enableAutoReminder(String reminderId)throws Exception
	{
		
		String urlString = url+"/autoreminders/"+reminderId+"/enable"; //No I18N

		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Disable an automated payment reminder.
	
	* Pass the reminderId to disable the auto reminder.
	
	* If the auto reminder has been disabled it returns the success message.
	
	* The success message is "Payment reminder has been disabled."
	
	
	* @param reminderId ID of the reminder.
	
	* @return Returns a String.
	
	*/
	
	public String disableAutoReminder(String reminderId)throws Exception
	{
		
		String urlString = url+"/autoreminders/"+reminderId+"/disable";  //No I18N

		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* Update the details of an automated payment reminder.
	
	* Pass the reminderId and AutoReminder object to update the details of an auto reminder.
	
	* If the auto reminder details has been updated it returns the success message.
	
	* The success message is "Your payment reminder preferences have been saved."
	
	
	* @param reminderId ID of the reminder.
	
	* @param autoReminder AutoReminder object.
	
	* @return Returns a String.
	
	*/
	
	public String updateAutoReminder(String reminderId, AutoReminder autoReminder)throws Exception
	{
		
		String urlString = url+"/autoreminders/"+reminderId; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", autoReminder.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
	}
	
	/**
	
	* List of manual reminders.
	
	* Pass the filters to get all the manual reminders based on the filters.
	
	* It returns the ManualReminderList object.<br>
	
	* The queryMap contains the possible key and value as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>type</td><td>Type to select between open or overdue reminder. <br>
Allowed Values: <i>overdue_reminder</i> and <i>open_reminder</i></td></tr>
			</tbody>
		
		</table> 
		
	
	* @param queryMap Type to select between open or overdue reminder.
	
	* @return Returns the ManualReminderList object.
	
	*/
	
	public ManualReminderList getManualReminders(HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/manualreminders"; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);

		ManualReminderList manualReminderList = settingsParser.getManualReminders(response);
		
		return manualReminderList;
	}
	
	/**
	
	* Get the details of a manual reminder.
	
	* Pass the reminderId to get the details of a manual reminder.
	
	* It returns the ManualReminder object.
	
	
	* @param reminderId ID of the reminder.
	
	* @return Returns the ManualReminder object.
	
	*/
	
	public ManualReminder getManualReminder(String reminderId)throws Exception
	{
		
		String urlString = url+"/manualreminders/"+reminderId; //No I18N

		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);

		ManualReminder manualReminder = settingsParser.getManualReminder(response);
		
		return manualReminder;
	}
	
	/**
	
	* Update the details of a manual reminder.
	
	* Pass the reminderId and ManualReminder object to update the details of a manual reminder.
	
	* If the manual reminder details has been updated it returns the success message.
	
	* The success message is "Your payment reminder preferences have been saved."
	
	
	* @param reminderId ID of the reminder.
	
	* @param manualReminder ManualReminder object.
	
	* @return Returns a String.
	
	*/
	
	public String updateManualReminder(String reminderId, ManualReminder manualReminder)throws Exception
	{
		
		String urlString = url+"/manualreminders/"+reminderId;  //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", manualReminder.toJSON().toString());

		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);

		String success = settingsParser.getMessage(response);
		
		return success;
		
	}
	
}

