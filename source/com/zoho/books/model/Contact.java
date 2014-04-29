/* $Id$ */

package com.zoho.books.model;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

/**

* This class is used to make an object for contact.

*/

public class Contact
{
	private String contactId = "";
        private String contactName = "";
        private String companyName = "";
        private boolean hasTransaction = false;
        private String contactType = "";
        private boolean isCrmCustomer = false;
        private String primaryContactId = "";
        private int paymentTerms = 0;
        private String paymentTermsLabel = "";
        private String currencyId = "";
        private String currencyCode = "";
        private String currencySymbol = "";
        private double outstandingReceivableAmount = 0.00;
        private double outstandingReceivableAmountBcy = 0.00;
        private double outstandingPayableAmount = 0.00;
        private double outstandingPayableAmountBcy = 0.00;
        private double unusedCreditsReceivableAmount = 0.00;
        private double unusedCreditsReceivableAmountBcy = 0.00;
        private double unusedCreditsPayableAmount = 0.00;
        private double unusedCreditsPayableAmountBcy = 0.00;
        private String status = "";
        private boolean paymentReminderEnabled = false;
        private String notes = "";
        private String createdTime = "";
        private String lastModifiedTime = "";
        
        
        private String firstName = "";
        private String lastName = "";
        private String email = "";
        private String phone = "";
        private String mobile = "";
        
        
        private boolean isEmail = true;
        private boolean snailMail = false;
        
        
        private List<CustomField> customFields = new ArrayList<CustomField>();
        
        private Address billingAddress = new Address();
        
        private Address shippingAddress = new Address();
        
        private List<ContactPerson> contactPerson = new ArrayList<ContactPerson>();
        
        private DefaultTemplate defaultTemplates = new DefaultTemplate();
        
        
        /**
        
        * set the contact id.
        
        * @param contactId  ID of the contact.
        
        */
        
        public void setContactId(String contactId)
        {
        	this.contactId = contactId;
        }
        
        /**
        
        * get the contact id.
        
        * @return Returns the contact id.
        
        */
        
        public String getContactId()
        {
        	return contactId;
        }
        
        /**
        
        * set the contact name.
        
        * @param contactName  Name of the contact.
        
        */	
        
        public void setContactName(String contactName)
        {
        	this.contactName = contactName;
        }
        
        /**
        
        * get the contact name.
        
        * @return Returns the contact name.
        
        */
        
        public String getContactName()
        {
        	return contactName;
        }
        
        /**
        
        * set the company name.
        
        * @param companyName  Name of the company.
        
        */	
        
        public void setCompanyName(String companyName)
        {
        	this.companyName = companyName;
        }
        
        /**
        
        * get the company name.
        
        * @return Returns the company name.
        
        */
        
        public String getCompanyName()
        {
        	return companyName;
        }
        
        /**
        
        * set has transaction.
        
        * @param hasTransaction  Whether the contact has a transaction or not.
        
        */
        
        public void setHasTransaction(boolean hasTransaction)
        {
        	this.hasTransaction = hasTransaction;
        }
        
        /**
        
        * get has transaction.
        
        * @return Returns true if the contact has a transaction else returns false.
        
        */
        
        public boolean hasTransaction()
        {
        	return hasTransaction;
        }
        
        /**
        
        * set the contact type.
        
        * @param contactType  Type of the contact.
        
        */
        
        public void setContactType(String contactType)
        {
        	this.contactType = contactType;
        }
        
        /**
        
        * get the contact type.
        
        * @return Returns the contact type.
        
        */
        
        public String getContactType()
        {
        	return contactType;
        }
        
        /**
        
        * set is crm customer.
        
        * @param isCrmCustomer  Whether the contact has a crm customer or not.
        
        */
        
        public void setIsCrmCustomer(boolean isCrmCustomer)
        {
        	this.isCrmCustomer = isCrmCustomer;
        }
        
        /**
        
        * get is crm customer.
        
        * @return Returns true if the contact has a crm customer else returns false.
        
        */
        
        public boolean isCrmCustomer()
        {
        	return isCrmCustomer;
        }
        
        /**
        
        * set the primary contact id.
        
        * @param primaryContactId  ID of the primary contact.
        
        */
        
        public void setPrimaryContactId(String primaryContactId)
        {
        	this.primaryContactId = primaryContactId;
        }
        
        /**
        
        * get the primary contact id.
        
        * @return Returns the primary contact id.
        
        */
        
        public String getPrimaryContactId()
        {
        	return primaryContactId;
        }
        
        /**
        
        * set the payment terms.
        
        * @param paymentTerms  Payment terms of the contact.
        
        */
        
        public void setPaymentTerms(int paymentTerms)
        {
        	this.paymentTerms = paymentTerms;
        }
        
        /**
        
        * get the payment terms.
        
        * @return Returns the payment terms of the contact.
        
        */
        
        public int getPaymentTerms()
        {
        	return paymentTerms;
        }
        
        /**
        
        * set the payment terms label.
        
        * @param paymentTermsLabel  Payment terms label of the contact.
        
        */
        
        public void setPaymentTermsLabel(String paymentTermsLabel)
        {
        	this.paymentTermsLabel = paymentTermsLabel;
        }
        
        /**
        
        * get the payment terms label.
        
        * @return Returns the payment terms label of the contact.
        
        */
        
        public String getPaymentTermsLabel()
        {
        	return paymentTermsLabel;
        }
        
        /**
        
        * set the currency id.
        
        * @param currencyId  ID of the currency.
        
        */
        
        public void setCurrencyId(String currencyId)
        {
        	this.currencyId = currencyId;
        }
        
        /**
        
        * get the currency id.
        
        * @return Returns the currency id.
        
        */
        
        public String getCurrencyId()
        {
        	return currencyId;
        }
        
        /**
        
        * set the currency code.
        
        * @param currencyCode  Code of the currency.
        
        */
        
        public void setCurrencyCode(String currencyCode)
        {
        	this.currencyCode = currencyCode;
        }
        
        /**
        
        * get the currency code.
        
        * @return Returns the currency code.
        
        */
        
        public String getCurrencyCode()
        {
        	return currencyCode;
        }
        
        /**
        
        * set the currency symbol.
        
        * @param currencySymbol  Symbol of the currency.
        
        */
        
        public void setCurrencySymbol(String currencySymbol)
        {
        	this.currencySymbol = currencySymbol;
        }
        
        /**
        
        * get the currency symbol.
        
        * @return Returns the currency symbol.
        
        */
        
        public String getCurrencySymbol()
        {
        	return currencySymbol;
        }
        
        /**
        
        * set the outstanding receivable amount.
        
        * @param outstandingReceivableAmount  Outstanding receivable amount of the contact.
        
        */
        
        public void setOutstandingReceivableAmount(double outstandingReceivableAmount)
        {
        	this.outstandingReceivableAmount = outstandingReceivableAmount;
        }
        
        /**
        
        * get the outstanding receivable amount.
        
        * @return Returns the outstanding receivable amount of the contact.
        
        */
        
        public double getOutstandingReceivableAmount()
        {
        	return outstandingReceivableAmount;
        }
        
        /**
        
        * set the outstanding receivable amount bcy.
        
        * @param outstandingReceivableAmountBcy  Outstanding receivable amount bcy of the contact.
        
        */
        
        public void setOutstandingReceivableAmountBcy(double outstandingReceivableAmountBcy)
        {
        	this.outstandingReceivableAmountBcy = outstandingReceivableAmountBcy;
        }
        
        /**
        
        * get the outstanding receivable amount bcy.
        
        * @return Returns the outstanding receivable amount bcy of the contact.
        
        */
        
        public double getOutstandingReceivableAmountBcy()
        {
        	return outstandingReceivableAmountBcy;
        }
        
        /**
        
        * set the outstanding payable amount.
        
        * @param outstandingPayableAmount  Outstanding payable amount of the contact.
        
        */
        
        public void setOutstandingPayableAmount(double outstandingPayableAmount)
        {
        	this.outstandingPayableAmount = outstandingPayableAmount;
        }
        
        /**
        
        * get the outstanding payable amount.
        
        * @return Returns the outstanding payable amount of the contact.
        
        */
        
        public double getOutstandingPayableAmount()
        {
        	return outstandingPayableAmount;
        }
        
        /**
        
        * set the outstanding payable amount bcy.
        
        * @param outstandingPayableAmountBcy  Outstanding payable amount bcy of the contact.
        
        */
        
        public void setOutstandingPayableAmountBcy(double outstandingPayableAmountBcy)
        {
        	this.outstandingPayableAmountBcy = outstandingPayableAmountBcy;
        }
        
        /**
        
        * get the outstanding payable amount bcy.
        
        * @return Returns the outstanding payable amount bcy of the contact.
        
        */
        
        public double getOutstandingPayableAmountBcy()
        {
        	return outstandingPayableAmountBcy;
        }
        
        /**
        
        * set the unused credits receivable amount.
        
        * @param unusedCreditsReceivableAmount  unused credits receivable amount of the contact.
        
        */
        
        public void setUnusedCreditsReceivableAmount(double unusedCreditsReceivableAmount)
        {
        	this.unusedCreditsReceivableAmount = unusedCreditsReceivableAmount;
        }
        
        /**
        
        * get the unused credits receivable amount.
        
        * @return Returns the unused credits receivable amount of the contact.
        
        */
        
        public double getUnusedCreditsReceivableAmount()
        {
        	return unusedCreditsReceivableAmount;
        }
        
        /**
        
        * set the unused credits receivable amount bcy.
        
        * @param unusedCreditsReceivableAmountBcy  unused credits receivable amount bcy of the contact.
        
        */
        
        public void setUnusedCreditsReceivableAmountBcy(double unusedCreditsReceivableAmountBcy)
        {
        	this.unusedCreditsReceivableAmountBcy = unusedCreditsReceivableAmountBcy;
        }
        
        /**
        
        * get the unused credits receivable amount bcy.
        
        * @return Returns the unused credits receivable amount bcy of the contact.
        
        */
        
        public double getUnusedCreditsReceivableAmountBcy()
        {
        	return unusedCreditsReceivableAmountBcy;
        }
        
        /**
        
        * set the unused credits payable amount.
        
        * @param unusedCreditsPayableAmount  unused credits payable amount of the contact.
        
        */
        
        public void setUnusedCreditsPayableAmount(double unusedCreditsPayableAmount)
        {
        	this.unusedCreditsPayableAmount = unusedCreditsPayableAmount;
        }
        
        /**
        
        * get the unused credits payable amount.
        
        * @return Returns the unused credits payable amount of the contact.
        
        */
        
        public double getUnusedCreditsPayableAmount()
        {
        	return unusedCreditsPayableAmount;
        }
        
        /**
        
        * set the unused credits payable amount bcy.
        
        * @param unusedCreditsPayableAmountBcy  unused credits payable amount bcy of the contact.
        
        */
        
        public void setUnusedCreditsPayableAmountBcy(double unusedCreditsPayableAmountBcy)
        {
        	this.unusedCreditsPayableAmountBcy = unusedCreditsPayableAmountBcy;
        }
        
        /**
        
        * get the unused credits payable amount bcy.
        
        * @return Returns the unused credits payable amount bcy of the contact.
        
        */
        
        public double getUnusedCreditsPayableAmountBcy()
        {
        	return unusedCreditsPayableAmountBcy;
        }
        
        /**
        
        * set the status.
        
        * @param status  Status of the contact.
        
        */
        
        public void setStatus(String status)
        {
        	this.status = status;
        }
        
        /**
        
        * get the status.
        
        * @return Returns the status of the contact.
        
        */
        
        public String getStatus()
        {
        	return status;
        }
        
        /**
        
        * set payment reminder enabled.
        
        * @param paymentReminderEnabled  Whether the payment reminder is enabled or not.
        
        */
        
        public void setPaymentReminderEnabled(boolean paymentReminderEnabled)
        {
        	this.paymentReminderEnabled = paymentReminderEnabled;
        }
        
        /**
        
        * get payment reminder enabled.
        
        * @return Returns true if the payment reminder is enabled else return false.
        
        */
        
        public boolean paymentReminderEnabled()
        {
        	return paymentReminderEnabled;
        }
        
        /**
        
        * set the notes.
        
        * @param notes  Notes of the contact.
        
        */
        
        public void setNotes(String notes)
        {
        	this.notes = notes;
        }
        
        /**
        
        * get the notes.
        
        * @return Returns the notes of the contact.
        
        */
        
        public String getNotes()
        {
        	return notes;
        }
        
        /**
        
        * set the created time.
        
        * @param createdTime  Which time the contact has been created.
        
        */
        
        public void setCreatedTime(String createdTime)
        {
        	this.createdTime = createdTime;
        }
        
        /**
        
        * get the created time.
        
        * @return Returns the created time of the contact.
        
        */
        
        public String getCreatedTime()
        {
        	return createdTime;
        }
        
        /**
        
        * set the last modified time.
        
        * @param lastModifiedTime  The last modified time of the contact.
        
        */
        
        public void setLastModifiedTime(String lastModifiedTime)
        {
        	this.lastModifiedTime = lastModifiedTime;
        }
        
        /**
        
        * get the last modified time.
        
        * @return Returns the last modified time of the contact.
        
        */
        
        public String getLastModifiedTime()
        {
        	return lastModifiedTime;
        }
        
        
        
        /**
        
        * set the first name.
        
        * @param firstName  First name of the contact person.
        
        */
        
        public void setFirstName(String firstName)
        {
        	this.firstName = firstName;
        }
        
        /**
        
        * get the first name.
        
        * @return Returns the first name of the contact person.
        
        */
        
        public String getFirstName()
        {
        	return firstName;
        }
        
        /**
        
        * set the last name.
        
        * @param lastName  Last name of the contact person.
        
        */
        
        public void setLastName(String lastName)
        {
        	this.lastName = lastName;
        }
        
        /**
        
        * get the last name.
        
        * @return Returns the last name of the contact person.
        
        */
        
        public String getLastName()
        {
        	return lastName;
        }
        
        /**
        
        * set the email.
        
        * @param email  Email of the contact person.
        
        */
        
        public void setEmail(String email)
        {
        	this.email = email;
        }
        
        /**
        
        * get the email.
        
        * @return Returns the email of the contact person.
        
        */
        
        public String getEmail()
        {
        	return email;
        }
        
        /**
        
        * set the phone number.
        
        * @param phone  Phone number of the contact person.
        
        */
        
        public void setPhone(String phone)
        {
        	this.phone = phone;
        }
        
        /**
        
        * get the phone number.
        
        * @return Returns the phone number of the contact person.
        
        */
        
        public String getPhone()
        {
        	return phone;
        }
        
        /**
        
        * set the mobile number.
        
        * @param mobile  Mobile number of the contact person.
        
        */
        
        public void setMobile(String mobile)
        {
        	this.mobile = mobile;
        }
        
        /**
        
        * get the mobile number.
        
        * @return Returns the mobile number of the contact person.
        
        */
        
        public String getMobile()
        {
        	return mobile;
        }
       
       
       
        
        
        /**
        
        * set is email.
        
        * @param isEmail  Specify is email or snailmail.
        
        */
        
        public void setIsEmail(boolean isEmail)
        {
        	this.isEmail = isEmail;
        }
        
        /**
        
        * get is email.
        
        * @return Returns true if it is email else return false.
        
        */
        
        public boolean isEmail()
        {
        	return isEmail;
        }
        
        /**
        
        * set is snail email.
        
        * @param snailMail  Specify is email or snailmail.
        
        */
        
        public void setIsSnailMail(boolean snailMail)
        {
        	this.snailMail = snailMail;
        }
        
        /**
        
        * get is email.
        
        * @return Returns true if it is snail email else return false.
        
        */
        
        public boolean isSnailMail()
        {
        	return snailMail;
        }
        
        
        
        
        
        
        
        
        
        /**
        
        * set the custom fields.
        
        * @param customFields  Custom fields of the contact.
        
        */
        
        public void setCustomFields(List<CustomField> customFields)throws Exception
        {
        	this.customFields = customFields;
        }
        
         /**
        
        * get the custom fields.
        
        * @return Returns list of CustomField object.
        
        */
        
        public List<CustomField> getCustomFields()
        {
        	return customFields;
        }
        
        
        
        
        
        /**
        
        * set the billing address.
        
        * @param billingAddress  Billing address of the contact.
        
        */
	
	public void setBillingAddress(Address billingAddress)throws Exception
	{
		this.billingAddress = billingAddress;
	}

	/**
        
        * get the billing address.
        
        * @return Returns the BillingAddress object.
        
        */
	
	public Address getBillingAddress()
	{
		return billingAddress;
	}
	
	
	
	
	/**
        
        * set the shipping address.
        
        * @param shippingAddress  Shipping address of the contact.
        
        */
	
	public void setShippingAddress(Address shippingAddress)throws Exception
	{
		this.shippingAddress = shippingAddress;
	}
	
	/**
        
        * get the shipping address.
        
        * @return Returns the ShippingAddress object.
        
        */
	
	public Address getShippingAddress()
	{
		return shippingAddress;
	}
	
	
	
	
	
	/**
        
        * set the contact persons.
        
        * @param contactPerson  Contact persons of a contact.
        
        */
	
	public void setContactPersons(List<ContactPerson> contactPerson)throws Exception
	{
		this.contactPerson = contactPerson;
	}
	
	/**
        
        * get the contact persons.
        
        * @return Returns list of ContactPerson object.
        
        */
	
	public List<ContactPerson> getContactPersons()
	{
		return contactPerson;
	}
	
	
	
	
	
	/**
        
        * set the default templates.
        
        * @param defaultTemplates  Default templates of a contact.
        
        */
	
	public void setDefaultTemplates(DefaultTemplate defaultTemplates)throws Exception
	{
		this.defaultTemplates = defaultTemplates;
	}
	
	/**
        
        * get the default templates.
        
        * @return Returns a DefaultTemplate object.
        
        */
	
	public DefaultTemplate getDefaultTemplates()
	{
		return defaultTemplates;
	}
        
        
        
        /**
	
	* Convert the Contact object into JSONObject.
	
	* @return  Returns the JSONObject.
	
	*/
	
	
	public JSONObject toJSON()throws Exception
	{
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("contact_name", contactName);
		jsonObject.put("company_name", companyName);
		jsonObject.put("payment_terms", paymentTerms);
		jsonObject.put("payment_terms_label", paymentTermsLabel);
		jsonObject.put("currency_id", currencyId);
		jsonObject.put("notes", notes);
		
		if(customFields != null && !customFields.isEmpty())
		{
			JSONArray customField = new JSONArray();
			
			for(int i = 0; i < customFields.size(); i++)
			{
				customField.put(customFields.get(i).toJSON());
			}
			
			jsonObject.put("custom_fields", customField);
		}
		
		if(billingAddress != null)
		{
			jsonObject.put("billing_address", billingAddress.toJSON());
		}
		
		if(shippingAddress != null)
		{
			jsonObject.put("shipping_address", shippingAddress.toJSON());
		}
		
		if(contactPerson != null && !contactPerson.isEmpty())
		{
			JSONArray contactPersons = new JSONArray();
			
			for(int i = 0; i < contactPerson.size(); i++)
			{
				contactPersons.put(contactPerson.get(i).toJSON());
			}
			
			jsonObject.put("contact_persons", contactPersons);
			
		}
		
		if(defaultTemplates != null)
		{
			jsonObject.put("default_templates", defaultTemplates.toJSON());
		}
		
		return jsonObject;
	}
	
	
}
