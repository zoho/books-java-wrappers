/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.BankTransactionsApi;
import com.zoho.books.api.BankAccountsApi;

import com.zoho.books.model.Transaction;
import com.zoho.books.model.BankAccount;
import com.zoho.books.model.BankAccountList;
import com.zoho.books.model.CreditnoteRefund;
import com.zoho.books.model.TransactionList;
import com.zoho.books.model.VendorPayment;
import com.zoho.books.model.Bill;
import com.zoho.books.model.CustomerPayment;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.Expense;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BankTransactionTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
		
		BankTransactionsApi bankTransactionApi = service.getBankTransactionsApi();
		
		BankAccountsApi bankAccountApi = service.getBankAccountsApi();
		
		File  file = new File("/home/likewise-open/ZOHOCORP/ramesh-2099/inv.jpg");
		
		try
		{
		
			BankAccountList getBankaccounts = bankAccountApi.getBankaccounts(null);
		
			String accountId = getBankaccounts.get(0).getAccountId();
		
			HashMap<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("account_id", accountId); 
		
			queryMap.put("transaction_type", "expense");
		
			TransactionList getTransactions = bankTransactionApi.getTransactions(queryMap);
		
			String transactionId = getTransactions.get(0).getTransactionId();
		
			
			Transaction transaction = new Transaction();
		
			transaction.setFromAccountId("36991000000029003");
			transaction.setToAccountId("36991000000028001");
			transaction.setTransactionType("transfer_fund");	//No I18N
			transaction.setAmount(2000.00);
			transaction.setDate("2014-02-21");
			transaction.setReferenceNumber("ref-1");		//No I18N
			transaction.setDescription("Amount transfer");		//No I18N
		
			Transaction create = bankTransactionApi.create(transaction);
			
			Transaction get = bankTransactionApi.get(transactionId);
			
			get.setDescription("Amount transferd");	//No I18N
		
			Transaction update = bankTransactionApi.update(get);
		
			TransactionList getMatchingTransactions = bankTransactionApi.getMatchingTransactions(transactionId, queryMap);
		
			List<Transaction> transactions = new ArrayList<Transaction>();
		
			Transaction transaction1 = new Transaction();
		
			transaction1.setTransactionId(transactionId);
			transaction1.setTransactionType("deposit");	//No I18N
		
			transactions.add(0, transaction1);
		
		
			String matchTransaction = bankTransactionApi.matchTransaction(transactionId, transactions);
		
			Transaction getAssociateTransaction = bankTransactionApi.getAssociateTransaction(transactionId, "statement_date"); //No I18N
		
			String excludeTransaction = bankTransactionApi.excludeTransaction(transactionId);
		
			String restoreTransaction = bankTransactionApi.restoreTransaction(transactionId);
		
			Transaction categorizeTransaction = new Transaction();
		
			categorizeTransaction.setTransactionId("36991000000031091");
		
			categorizeTransaction.setFromAccountId("36991000000029003");
			categorizeTransaction.setToAccountId("36991000000029005");
			categorizeTransaction.setTransactionType("transfer_fund");	//No I18N
			categorizeTransaction.setAmount(4000.00);
			categorizeTransaction.setDate("2014-02-21");
			categorizeTransaction.setReferenceNumber("ref-1234");		//No I18N
			categorizeTransaction.setDescription("Insurance payment");	//No I18N
			categorizeTransaction.setCurrencyId("36991000000000099");
		
			Transaction categorizeAnUncategorizeTransaction = bankTransactionApi.categorizeAnUncategorizeTransaction(categorizeTransaction);
		
			CreditnoteRefund creditnoteRefund = new CreditnoteRefund();
		
			creditnoteRefund.setCreditnoteId("36991000000035019");
			creditnoteRefund.setDate("2014-02-21");
			creditnoteRefund.setRefundMode("Cash");		//No I18N
			creditnoteRefund.setReferenceNumber("Ref-123");	//No I18N
			creditnoteRefund.setAmount(4000.00);
			creditnoteRefund.setExchangeRate(1.00);
			creditnoteRefund.setFromAccountId("36991000000029003");
			creditnoteRefund.setDescription("categorize a creditnote refund");	//No I18N
		
		
			CreditnoteRefund categorizeAsCreditnoteRefunds = bankTransactionApi.categorizeAsCreditnoteRefunds(transactionId, creditnoteRefund);
			
			VendorPayment vendorPayment = new VendorPayment();
			
			vendorPayment.setVendorId("36991000000025001");
			vendorPayment.setDate("2014-02-21");
			vendorPayment.setPaymentMode("Cash");		//No I18N
			vendorPayment.setReferenceNumber("Ref-9872");	//No I18N
			vendorPayment.setAmount(4000.00);
			vendorPayment.setExchangeRate(1.00);
			vendorPayment.setPaidThroughAccountId("36991000000029003");
			vendorPayment.setDescription("Insurance payment");	//No I18N
		
			List<Bill> billsList = new ArrayList<Bill>();
		
		
			Bill bill = new Bill();
		
			bill.setBillId("36991000000035035");
			bill.setAmountApplied(500.00);
			
			billsList.add(0, bill);
			
			vendorPayment.setBills(billsList);
		
			VendorPayment categorizeAsVendorPayment = bankTransactionApi.categorizeAsVendorPayment(transactionId, vendorPayment);
			
			CustomerPayment customerPayment = new CustomerPayment();
			
			customerPayment.setCustomerId("36991000000041005");
			customerPayment.setDate("2014-02-21");
			customerPayment.setPaymentMode("Cash");		//No I18N
			customerPayment.setReferenceNumber("Ref-1");	//No I18N
			customerPayment.setAmount(1000.00);
			customerPayment.setExchangeRate(1.00);
			customerPayment.setTaxAccountId("36991000000032001");
			customerPayment.setAccountId(accountId);
			customerPayment.setBankCharges(0.00);
			customerPayment.setDescription("Categorize a customer payment");	//No I18N
		
			List<Invoice> invoiceList = new ArrayList<Invoice>();
		
		
			Invoice invoice = new Invoice();
		
			invoice.setInvoiceId("36991000000035007");
			invoice.setAmountApplied(500.00);
			invoice.setTaxAmountWithheld(0.00);
			
			invoiceList.add(0, invoice);
			
			customerPayment.setInvoices(invoiceList);
			
			
			CustomerPayment categorizeAsCustomerPayment = bankTransactionApi.categorizeAsCustomerPayment("36991000000031091", customerPayment);
			
			Expense expense = new Expense();
			
			expense.setAccountId(accountId);
			expense.setPaidThroughAccountId("36991000000029003");
			expense.setDate("2014-02-21");
			expense.setAmount(1000.00);
			expense.setTaxId("36991000000034015");
			expense.setIsInclusiveTax(false);
			expense.setIsBillable(false);
			expense.setReferenceNumber("Ref-1");			//No I18N
			expense.setDescription("categorize an expense");	//No I18N
			expense.setCustomerId("36991000000025001");
			expense.setVendorId("36991000000031007");
			expense.setCurrencyId("36991000000000099");
			expense.setExchangeRate(1.00);
			expense.setProjectId("36991000000038011");
			
			
			Expense categorizeAsExpense = bankTransactionApi.categorizeAsExpense(transactionId, expense, file);
			
			String uncategorizeACategorizedTransaction = bankTransactionApi.uncategorizeACategorizedTransaction(transactionId);
			
			String delete = bankTransactionApi.delete(transactionId);
			
		
			//System.out.println(uncategorizeACategorizedTransaction);
		
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
