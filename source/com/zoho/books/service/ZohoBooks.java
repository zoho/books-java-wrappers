/* $Id$ */

package com.zoho.books.service;

import com.zoho.books.api.InvoicesApi;
import com.zoho.books.api.PurchaseOrderApi;
import com.zoho.books.api.RecurringInvoicesApi;
import com.zoho.books.api.CreditNotesApi;
import com.zoho.books.api.EstimatesApi;
import com.zoho.books.api.CustomerPaymentsApi;
import com.zoho.books.api.ExpensesApi;
import com.zoho.books.api.RecurringExpensesApi;
import com.zoho.books.api.ChartOfAccountsApi;
import com.zoho.books.api.JournalsApi;
import com.zoho.books.api.BaseCurrencyAdjustmentsApi;
import com.zoho.books.api.ContactsApi;
import com.zoho.books.api.ContactPersonsApi;
import com.zoho.books.api.SalesOrderApi;
import com.zoho.books.api.VendorCreditsApi;
import com.zoho.books.api.VendorPaymentsApi;
import com.zoho.books.api.BankAccountsApi;
import com.zoho.books.api.BankTransactionsApi;
import com.zoho.books.api.BankRulesApi;
import com.zoho.books.api.BillsApi;
import com.zoho.books.api.ProjectsApi;
import com.zoho.books.api.SettingsApi;
import com.zoho.books.api.OrganizationsApi;
import com.zoho.books.api.UsersApi;
import com.zoho.books.api.ItemsApi;

/**

* ZohoBooks is used to provide all api instances for the Zoho Books services.

*/

public class ZohoBooks
{
	
	private String accessToken;
	
	private String organizationId;
	
	/**
	
	* Initialize ZohoBooks using user's accessToken and organization id.
	
	* @param accessToken User's accessToken.
	
	* @param organizationId ID of the organization. 
	
	*/

	public void initialize(String accessToken, String organizationId)
	{
	
		this.accessToken = accessToken;
		this.organizationId = organizationId;
		
	}
	
	
	
	
	/**
	
	* get an instance of invoices api.
	
	* @return Returns the InvoicesApi object.
	
	*/
	
	public InvoicesApi getInvoicesApi()
	{
		InvoicesApi invoicesApi = new InvoicesApi(accessToken, organizationId);
		
		return invoicesApi;
	}
	
	
	/**
	
	* get an instance of recurring invoices api.
	
	* @return Returns the RecurringInvoicesApi object.
	
	*/
	
	public RecurringInvoicesApi getRecurringInvoicesApi()
	{
		RecurringInvoicesApi recurringInvoicesApi = new RecurringInvoicesApi(accessToken, organizationId);
		
		return recurringInvoicesApi;
	}
	
	
	
	/**
	
	* get an instance of creditnotes api.
	
	* @return Returns the CreditNotesApi object.
	
	*/
	
	public CreditNotesApi getCreditNotesApi()
	{
		CreditNotesApi creditNotesApi = new CreditNotesApi(accessToken, organizationId);
		
		return creditNotesApi;
	}
	
	
	
	
	
	/**
	
	* get an instance of estimates api.
	
	* @return Returns the EstimatesApi object.
	
	*/
	
	public EstimatesApi getEstimatesApi()
	{
		EstimatesApi estimatesApi = new EstimatesApi(accessToken, organizationId);
		
		return estimatesApi;
	}
	
	
	
	
	/**
	
	* get an instance of customer payments api.
	
	* @return Returns the CustomerPaymentsApi object.
	
	*/
	
	public CustomerPaymentsApi getCustomerPaymentsApi()
	{
		CustomerPaymentsApi customerPaymentsApi = new CustomerPaymentsApi(accessToken, organizationId);
		
		return customerPaymentsApi;
	}
	
	
	
	/**
	
	* get an instance of expenses api.
	
	* @return Returns the ExpensesApi object.
	
	*/
	
	public ExpensesApi getExpensesApi()
	{
		ExpensesApi expensesApi = new ExpensesApi(accessToken, organizationId);
		
		return expensesApi;
	}
	
	
	
	
	/**
	
	* get an instance of recurring expenses api.
	
	* @return Returns the RecurringExpensesApi object.
	
	*/
	
	public RecurringExpensesApi getRecurringExpensesApi()
	{
		RecurringExpensesApi recurringExpensesApi = new RecurringExpensesApi(accessToken, organizationId);
		
		return recurringExpensesApi;
	}
	
	
	
	/**
	
	* get an instance of chart of accounts api.
	
	* @return Returns the ChartOfAccountsApi object.
	
	*/
	
	public ChartOfAccountsApi getChartOfAccountsApi()
	{
		ChartOfAccountsApi chartOfAccountsApi = new ChartOfAccountsApi(accessToken, organizationId);
		
		return chartOfAccountsApi;
	}
	
	
	
	/**
	
	* get an instance of journals api.
	
	* @return Returns the JournalsApi object.
	
	*/
	
	public JournalsApi getJournalsApi()
	{
		JournalsApi journalsApi = new JournalsApi(accessToken, organizationId);
		
		return journalsApi;
	}
	
	
	
	/**
	
	* get an instance of base currency adjustments api.
	
	* @return Returns the BaseCurrencyAdjustmentsApi object.
	
	*/
	
	public BaseCurrencyAdjustmentsApi getBaseCurrencyAdjustmentsApi()
	{
		BaseCurrencyAdjustmentsApi baseCurrencyAdjustmentsApi = new BaseCurrencyAdjustmentsApi(accessToken, organizationId);
		
		return baseCurrencyAdjustmentsApi;
	}
	
	
	
	/**
	
	* get an instance of contacts api.
	
	* @return Returns the ContactsApi object.
	
	*/
	
	public ContactsApi getContactsApi()
	{
		ContactsApi contactsApi = new ContactsApi(accessToken, organizationId);
		
		return contactsApi;
	}
	
	/**
	
	* get an instance of contact persons api.
	
	* @return Returns the ContactPersonsApi object.
	
	*/
	
	public ContactPersonsApi getContactPersonsApi()
	{
		ContactPersonsApi contactPersonsApi = new ContactPersonsApi(accessToken, organizationId);
		
		return contactPersonsApi;
	}
	
	
	
	/**
	
	* get an instance of vendor payments api.
	
	* @return Returns the VendorPaymentsApi object.
	
	*/
	
	public VendorPaymentsApi getVendorPaymentsApi()
	{
		VendorPaymentsApi vendorPaymentsApi = new VendorPaymentsApi(accessToken, organizationId);
		
		return vendorPaymentsApi;
	}
	
	/**
	
	* get an instance of bank accounts api.
	
	* @return Returns the BankAccountsApi object.
	
	*/
	
	public BankAccountsApi getBankAccountsApi()
	{	
		BankAccountsApi bankAccountsApi = new BankAccountsApi(accessToken, organizationId);
		
		return bankAccountsApi;
	}
	
	
	/**
	
	* get an instance of bank transactions api.
	
	* @return Returns the BankTransactionsApi object.
	
	*/
	
	public BankTransactionsApi getBankTransactionsApi()
	{	
		BankTransactionsApi bankTransactionsApi = new BankTransactionsApi(accessToken, organizationId);
		
		return bankTransactionsApi;
	}
	
	
	/**
	
	* get an instance of bank rules api.
	
	* @return Returns the BankRulesApi object.
	
	*/
	
	public BankRulesApi getBankRulesApi()
	{	
		BankRulesApi bankRulesApi = new BankRulesApi(accessToken, organizationId);
		
		return bankRulesApi;
	}
	
	
	/**
	
	* get an instance of bills api.
	
	* @return Returns the BillsApi object.
	
	*/
	
	public BillsApi getBillsApi()
	{
		BillsApi billsApi = new BillsApi(accessToken, organizationId);
		
		return billsApi;
	}
	
	
	
	
	
	/**
	
	* get an instance of projects api.
	
	* @return Returns the ProjectsApi object.
	
	*/
	
	public ProjectsApi getProjectsApi()
	{
		ProjectsApi projectsApi = new ProjectsApi(accessToken, organizationId);
		
		return projectsApi;
	}
	
	
	
	/**
	
	* get an instance of settings api.
	
	* @return Returns the SettingsApi object.
	
	*/
	
	public SettingsApi getSettingsApi()
	{
		SettingsApi settingsApi = new SettingsApi(accessToken, organizationId);
		
		return settingsApi;
	}
	
	/**
	
	* get an instance of organizations api.
	
	* @return Returns the OrganizationsApi object.
	
	*/
	
	public OrganizationsApi getOrganizationsApi()
	{
		OrganizationsApi organizationsApi = new OrganizationsApi(accessToken);
		
		return organizationsApi;
	}
	
	/**
	
	* get an instance of users api.
	
	* @return Returns the UsersApi object.
	
	*/
	
	public UsersApi getUsersApi()
	{
		UsersApi usersApi = new UsersApi(accessToken, organizationId);
		
		return usersApi;
	}
	
	/**
	
	* get an instance of items api.
	
	* @return Returns the ItemsApi object.
	
	*/
	
	public ItemsApi getItemsApi()
	{
		ItemsApi itemsApi = new ItemsApi(accessToken, organizationId);
		
		return itemsApi;
	}
	
	/**
	 * Get an instance of sales order api.
	 * 
	 * @return Returns the SalesOrderApi object.
	 */
	
	public SalesOrderApi getSalesOrderApi()
	{
		
		SalesOrderApi salesOrderApi = new SalesOrderApi(accessToken, organizationId);
		
		return salesOrderApi;
		
	}
	
	/**
	 * Get an instance of purchase order api.
	 * 
	 * @return Returns the PurchaseOrderApi object.
	 */
	
	public PurchaseOrderApi getPurchaseOrderApi()
	{
		
		PurchaseOrderApi purchaseOrderApi = new PurchaseOrderApi(accessToken, organizationId);
		
		return purchaseOrderApi;
		
	}
	
	/**
	 * Get the vendor credits api.
	 * 
	 * @return Returns the VendorCreditsApi object.
	 */
	
	public VendorCreditsApi getVendorCreditsApi()
	{
		
		VendorCreditsApi vendorCreditsApi = new VendorCreditsApi(accessToken, organizationId);
		
		return vendorCreditsApi;
		
	}
	
	
}
