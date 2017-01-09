/* $Id$ */

package com.zoho.books.service;

import com.zoho.books.api.*;

/**
 * ZohoBooks is used to provide all api instances for the Zoho Books services.
 */

public class ZohoBooks {

    private String authToken;

    private String organizationId;

    /**
     * Initialize ZohoBooks using user's authtoken and organization id.
     *
     * @param authToken      User's authtoken.
     * @param organizationId ID of the organization.
     */

    public void initialize(String authToken, String organizationId) {

        this.authToken = authToken;
        this.organizationId = organizationId;

    }


    /**
     * get an instance of invoices api.
     *
     * @return Returns the InvoicesApi object.
     */

    public InvoicesApi getInvoicesApi() {
        InvoicesApi invoicesApi = new InvoicesApi(authToken, organizationId);

        return invoicesApi;
    }


    /**
     * get an instance of recurring invoices api.
     *
     * @return Returns the RecurringInvoicesApi object.
     */

    public RecurringInvoicesApi getRecurringInvoicesApi() {
        RecurringInvoicesApi recurringInvoicesApi = new RecurringInvoicesApi(authToken, organizationId);

        return recurringInvoicesApi;
    }


    /**
     * get an instance of creditnotes api.
     *
     * @return Returns the CreditNotesApi object.
     */

    public CreditNotesApi getCreditNotesApi() {
        CreditNotesApi creditNotesApi = new CreditNotesApi(authToken, organizationId);

        return creditNotesApi;
    }


    /**
     * get an instance of estimates api.
     *
     * @return Returns the EstimatesApi object.
     */

    public EstimatesApi getEstimatesApi() {
        EstimatesApi estimatesApi = new EstimatesApi(authToken, organizationId);

        return estimatesApi;
    }


    /**
     * get an instance of customer payments api.
     *
     * @return Returns the CustomerPaymentsApi object.
     */

    public CustomerPaymentsApi getCustomerPaymentsApi() {
        CustomerPaymentsApi customerPaymentsApi = new CustomerPaymentsApi(authToken, organizationId);

        return customerPaymentsApi;
    }


    /**
     * get an instance of expenses api.
     *
     * @return Returns the ExpensesApi object.
     */

    public ExpensesApi getExpensesApi() {
        ExpensesApi expensesApi = new ExpensesApi(authToken, organizationId);

        return expensesApi;
    }


    /**
     * get an instance of recurring expenses api.
     *
     * @return Returns the RecurringExpensesApi object.
     */

    public RecurringExpensesApi getRecurringExpensesApi() {
        RecurringExpensesApi recurringExpensesApi = new RecurringExpensesApi(authToken, organizationId);

        return recurringExpensesApi;
    }


    /**
     * get an instance of chart of accounts api.
     *
     * @return Returns the ChartOfAccountsApi object.
     */

    public ChartOfAccountsApi getChartOfAccountsApi() {
        ChartOfAccountsApi chartOfAccountsApi = new ChartOfAccountsApi(authToken, organizationId);

        return chartOfAccountsApi;
    }


    /**
     * get an instance of journals api.
     *
     * @return Returns the JournalsApi object.
     */

    public JournalsApi getJournalsApi() {
        JournalsApi journalsApi = new JournalsApi(authToken, organizationId);

        return journalsApi;
    }


    /**
     * get an instance of base currency adjustments api.
     *
     * @return Returns the BaseCurrencyAdjustmentsApi object.
     */

    public BaseCurrencyAdjustmentsApi getBaseCurrencyAdjustmentsApi() {
        BaseCurrencyAdjustmentsApi baseCurrencyAdjustmentsApi = new BaseCurrencyAdjustmentsApi(authToken, organizationId);

        return baseCurrencyAdjustmentsApi;
    }


    /**
     * get an instance of contacts api.
     *
     * @return Returns the ContactsApi object.
     */

    public ContactsApi getContactsApi() {
        ContactsApi contactsApi = new ContactsApi(authToken, organizationId);

        return contactsApi;
    }

    /**
     * get an instance of contact persons api.
     *
     * @return Returns the ContactPersonsApi object.
     */

    public ContactPersonsApi getContactPersonsApi() {
        ContactPersonsApi contactPersonsApi = new ContactPersonsApi(authToken, organizationId);

        return contactPersonsApi;
    }


    /**
     * get an instance of vendor payments api.
     *
     * @return Returns the VendorPaymentsApi object.
     */

    public VendorPaymentsApi getVendorPaymentsApi() {
        VendorPaymentsApi vendorPaymentsApi = new VendorPaymentsApi(authToken, organizationId);

        return vendorPaymentsApi;
    }

    /**
     * get an instance of bank accounts api.
     *
     * @return Returns the BankAccountsApi object.
     */

    public BankAccountsApi getBankAccountsApi() {
        BankAccountsApi bankAccountsApi = new BankAccountsApi(authToken, organizationId);

        return bankAccountsApi;
    }


    /**
     * get an instance of bank transactions api.
     *
     * @return Returns the BankTransactionsApi object.
     */

    public BankTransactionsApi getBankTransactionsApi() {
        BankTransactionsApi bankTransactionsApi = new BankTransactionsApi(authToken, organizationId);

        return bankTransactionsApi;
    }


    /**
     * get an instance of bank rules api.
     *
     * @return Returns the BankRulesApi object.
     */

    public BankRulesApi getBankRulesApi() {
        BankRulesApi bankRulesApi = new BankRulesApi(authToken, organizationId);

        return bankRulesApi;
    }


    /**
     * get an instance of bills api.
     *
     * @return Returns the BillsApi object.
     */

    public BillsApi getBillsApi() {
        BillsApi billsApi = new BillsApi(authToken, organizationId);

        return billsApi;
    }


    /**
     * get an instance of projects api.
     *
     * @return Returns the ProjectsApi object.
     */

    public ProjectsApi getProjectsApi() {
        ProjectsApi projectsApi = new ProjectsApi(authToken, organizationId);

        return projectsApi;
    }


    /**
     * get an instance of settings api.
     *
     * @return Returns the SettingsApi object.
     */

    public SettingsApi getSettingsApi() {
        SettingsApi settingsApi = new SettingsApi(authToken, organizationId);

        return settingsApi;
    }

    /**
     * get an instance of organizations api.
     *
     * @return Returns the OrganizationsApi object.
     */

    public OrganizationsApi getOrganizationsApi() {
        OrganizationsApi organizationsApi = new OrganizationsApi(authToken);

        return organizationsApi;
    }

    /**
     * get an instance of users api.
     *
     * @return Returns the UsersApi object.
     */

    public UsersApi getUsersApi() {
        UsersApi usersApi = new UsersApi(authToken, organizationId);

        return usersApi;
    }

    /**
     * get an instance of items api.
     *
     * @return Returns the ItemsApi object.
     */

    public ItemsApi getItemsApi() {
        ItemsApi itemsApi = new ItemsApi(authToken, organizationId);

        return itemsApi;
    }

    /**
     * Get an instance of sales order api.
     *
     * @return Returns the SalesOrderApi object.
     */

    public SalesOrderApi getSalesOrderApi() {

        SalesOrderApi salesOrderApi = new SalesOrderApi(authToken, organizationId);

        return salesOrderApi;

    }

    /**
     * Get an instance of purchase order api.
     *
     * @return Returns the PurchaseOrderApi object.
     */

    public PurchaseOrderApi getPurchaseOrderApi() {

        PurchaseOrderApi purchaseOrderApi = new PurchaseOrderApi(authToken, organizationId);

        return purchaseOrderApi;

    }

    /**
     * Get the vendor credits api.
     *
     * @return Returns the VendorCreditsApi object.
     */

    public VendorCreditsApi getVendorCreditsApi() {

        VendorCreditsApi vendorCreditsApi = new VendorCreditsApi(authToken, organizationId);

        return vendorCreditsApi;

    }


}
