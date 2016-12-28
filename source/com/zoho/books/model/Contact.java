/* $Id$ */

package com.zoho.books.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        private double unusedCreditsReceivableAmount = 0.00;
        private double unusedCreditsReceivableAmountBcy = 0.00;
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
        
        
        
        private String website;
        private String contactSalutation; 
        private String source;
        private boolean isLinkedWithZohocrm;
        private int pricePrecision;
        private String pricebookId;
        private String pricebookName;
        private boolean associatedWithSquare;
        
        
        private boolean track1099;
        private String taxIdType;
        private String taxIdValue;
        private Boolean isTaxable;
        private String taxAuthorityId;
        private String taxExemptionId;
        private String taxId;
        
        
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
        
        public void setCustomFields(List<CustomField> customFields)
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
	
	public void setBillingAddress(Address billingAddress)
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
	
	public void setShippingAddress(Address shippingAddress)
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
	
	public void setContactPersons(List<ContactPerson> contactPerson)
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
	
	public void setDefaultTemplates(DefaultTemplate defaultTemplates)
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
	 * Get the website.
	 * 
	 * @return Returns the website.
	 */
	
        
    public String getWebsite() 
    {
		return website;
	}
    
    /**
     * Set the website.
     * 
     * @param website Website for the contact.
     */

	public void setWebsite(String website) 
	{
		this.website = website;
	}
	
	/**
	 * Get the contact salutation.
	 * 
	 * @return Returns the cantact salutation.
	 */

	public String getContactSalutation() 
	{
		return contactSalutation;
	}
	
	/**
	 * Set the contact salutation.
	 * 
	 * @param contactSalutation Salutation for the contact.
	 */

	public void setContactSalutation(String contactSalutation)
	{
		this.contactSalutation = contactSalutation;
	}
	
	/**
	 * Get the source.
	 * 
	 * @return Returns the source.
	 */

	public String getSource() 
	{
		return source;
	}
	
	/**
	 * Set the source of the request.
	 * 
	 * @param source Source of the request.
	 */

	public void setSource(String source) 
	{
		this.source = source;
	}
	
	/**
	 * Get the contact linked with zoho crm.
	 * 
	 * @return Returns true if the contact linked with zoho crm else returns false.
	 */

	public boolean isLinkedWithZohocrm() 
	{
		return isLinkedWithZohocrm;
	}
	
	/**
	 * Set the contact is linked with zoho crm or not.
	 * 
	 * @param isLinkedWithZohocrm True or false to set the contact linked with zoho crm or not.
	 */

	public void setLinkedWithZohocrm(boolean isLinkedWithZohocrm) 
	{
		this.isLinkedWithZohocrm = isLinkedWithZohocrm;
	}
	
	/**
	 * Get the price precision of the contact.
	 * 
	 * @return Returns the price precision for the contact.
	 */

	public int getPricePrecision() 
	{
		return pricePrecision;
	}
	
	/**
	 * Set the price precision for the contact.
	 * 
	 * @param pricePrecision Price precision for the contact.
	 */

	public void setPricePrecision(int pricePrecision) 
	{
		this.pricePrecision = pricePrecision;
	}
	
	/**
	 * Get the price book id.
	 * 
	 * @return Returns the price book id.
	 */

	public String getPricebookId() 
	{
		return pricebookId;
	}
	
	/**
	 * Set the price book id.
	 * 
	 * @param pricebookId ID of the price book.
	 */

	public void setPricebookId(String pricebookId)
	{
		this.pricebookId = pricebookId;
	}
	
	/**
	 * Get the price book name.
	 * 
	 * @return returns the price book name.
	 */

	public String getPricebookName() 
	{
		return pricebookName;
	}
	
	/**
	 * Set the price book name.
	 * 
	 * @param pricebookName Name of the price book.
	 */

	public void setPricebookName(String pricebookName)
	{
		this.pricebookName = pricebookName;
	}
	
	/**
	 * Get the contact associated with square or not.
	 * 
	 * @return Returns true if the contact associated with square.
	 */

	public boolean isAssociatedWithSquare() 
	{
		return associatedWithSquare;
	}
	
	/**
	 * Set the contact associated with square or not.
	 * 
	 * @param associatedWithSquare True or false to set the contact associated with square.
	 */

	public void setAssociatedWithSquare(boolean associatedWithSquare) 
	{
		this.associatedWithSquare = associatedWithSquare;
	}
	
	
	
	/**
	 * Get the contact is track1099.
	 * 
	 * @return Returns true if the contact is track1099 else returns false.
	 */

	public boolean isTrack1099() 
	{
		return track1099;
	}
	
	/**
	 * Set the contact is track1099 or not.
	 * 
	 * @param track1099 True or false to set the contact is track1099 or not.
	 */

	public void setTrack1099(boolean track1099) 
	{
		this.track1099 = track1099;
	}
	
	/**
	 * Get the tax id type.
	 * 
	 * @return Returns the tax id type.
	 */

	public String getTaxIdType() 
	{
		return taxIdType;
	}
	
	/**
	 * Set the tax id type.
	 * 
	 * @param taxIdType Type of the tax id.
	 */

	public void setTaxIdType(String taxIdType)
	{
		this.taxIdType = taxIdType;
	}
	
	/**
	 * Get the tax id value.
	 * 
	 * @return Returns the tax id value.
	 */

	public String getTaxIdValue() 
	{
		return taxIdValue;
	}
	
	/**
	 * Set the tax id value.
	 * 
	 * @param taxIdValue Value of the tax id.
	 */

	public void setTaxIdValue(String taxIdValue)
	{
		this.taxIdValue = taxIdValue;
	}
	
	/**
	 * Get the contact is taxable or not.
	 * 
	 * @return Returns true of the contact is taxable else returns false.
	 */

	public Boolean isTaxable()
	{
		return isTaxable;
	}
	
	/**
	 * Set the contact is taxable or not.
	 * 
	 * @param isTaxable True or false to set the contact is taxable or not.
	 */

	public void setTaxable(Boolean isTaxable)
	{
		this.isTaxable = isTaxable;
	}
	
	/**
	 * Get the tax authority id.
	 * 
	 * @return Returns the tax authority id.
	 */

	public String getTaxAuthorityId() 
	{
		return taxAuthorityId;
	}
	
	/**
	 * Set the tax authority id.
	 * 
	 * @param taxAuthorityId ID of the tax authority.
	 */

	public void setTaxAuthorityId(String taxAuthorityId)
	{
		this.taxAuthorityId = taxAuthorityId;
	}
	
	/**
	 * Get the tax exemption id.
	 * 
	 * @return Returns the tax exemption id.
	 */

	public String getTaxExemptionId() 
	{
		return taxExemptionId;
	}
	
	/**
	 * Set the tax exemption id.
	 * 
	 * @param taxExemptionId ID of the tax exemption.
	 */

	public void setTaxExemptionId(String taxExemptionId)
	{
		this.taxExemptionId = taxExemptionId;
	}
	
	/**
	 * Get the tax id.
	 * 
	 * @return Returns the tax id.
	 */

	public String getTaxId() 
	{
		return taxId;
	}
	
	/**
	 * Set the tax id.
	 * 
	 * @param taxId ID of the tax.
	 */

	public void setTaxId(String taxId)
	{
		this.taxId = taxId;
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
		
		if((Boolean)track1099 != null)
		{
			jsonObject.put("track_1099", track1099);
		}
		if(taxIdType != null && !taxIdType.equals(""))
		{
			jsonObject.put("tax_id_type", taxIdType);
		}
		if(taxIdValue != null && !taxIdValue.equals(""))
		{
			jsonObject.put("tax_id_value", taxIdValue);
		}
		if((Boolean)isTaxable != null)
		{
			jsonObject.put("is_taxable", isTaxable);
		}
		if(taxId != null && !taxId.equals(""))
		{
			jsonObject.put("tax_id", taxId);
		}
		if(taxAuthorityId != null && !taxAuthorityId.equals(""))
		{
			jsonObject.put("tax_authority_id", taxAuthorityId);
		}
		if(taxExemptionId != null && !taxExemptionId.equals(""))
		{
			jsonObject.put("tax_exemption_id", taxExemptionId);
		}
		
		return jsonObject;
	}
	
	
}
