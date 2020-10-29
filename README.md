# ZohoBooks Java Client Library

The Java library for integrating with the Zoho Books API.

## Installation

### Maven users

Add the below dependency to your `pom.xml`.

	<dependency>
	  <groupId>com.zoho.books</groupId>
	  <artifactId>books-java</artifactId>
	  <version>1.0</version>
	</dependency>
	

# Documentation

[API Reference](https://www.zoho.com/books/api/v3/index.html)

# Usage


In order to access the Zoho Books APIs, users need to have a valid Zoho account and a valid Auth Token.

## Sign up for a Zoho Account:

- - -

For setting up a Zoho account, access the Zoho Books [Sign Up](https://www.zoho.com/books/signup) page and enter the requisite details - email address and password.
 
## Generate Auth Token:

- - -
 
To generate the Auth Token, you need to send an authentication request to Zoho Accounts in a prescribed URL format. [Refer here](https://www.zoho.com/books/api/v3/index.html) 


## **Java Wrappers - Sample**

## How to access Zoho Books APIs through Java wrapper classes?

- - -
 
Below is a sample code for accessing the Zoho Books' Organization through Java wrapper classes. Please import these classes:


        import com.zoho.books.exception.BooksException;

        import com.zoho.books.service.ZohoBooks;

        import com.zoho.books.api.OrganizationsApi;

        import com.zoho.books.model.Organization;
        import com.zoho.books.model.OrganizationList;
        import com.zoho.books.model.Address;

        public class Sample
        {

		public static void main(String args[]) throws Exception
		{ 
		
Once you're done with importing the requisite classes, you'll have to proceed to create an instance of OrganisationsAPI.
		
## Create OrganisationsAPI instance:

- - -

Now, there are two ways of creating an instance of OrganisationsApi.

1.) Pass the access token and create a new OrganisationsApi instance. 

Sample code:

			OrganizationsApi organizationsApi = new OrganizationsApi(accessToken);
2.) Pass the access token and organisations id to first create an instance of ZohoBooks, and then proceed to get the instance of Organisations API. 

Sample code:

			ZohoBooks service = new ZohoBooks();        
			service.initialize("{access_token}", "{organization_id}");
			OrganizationsApi organizationsApi = service.getOrganizationsApi();

## Create a new organization:			

- - -

First time users signing up for Zoho Books need to create a new organization. Please follow the steps listed below:

**Step 1:** Create a new Organization object and set the relevant information in it.


			Organization organization = new Organization();

			organization.setName("ZOHO");
			organization.setFiscalYearStartMonth("january");
			organization.setCurrencyCode("USD");
			organization.setTimeZone("Asia/Calcutta");
			organization.setDateFormat("dd MMM yyyy");
			organization.setLanguageCode("en");
			organization.setTaxBasis("accrual");
			organization.setTaxType("tax");
					
					
**Step 2:** Create an Address object and set the address details in it. Once done, set the Address object into the Organization object.

			
			Address address = new Address();

			address.setStreetAddress1("9390 Research Blvd");
			address.setStreetAddress2("Bldg II, Suite 440");
			address.setCity("Austin");
			address.setState("Texas");
			address.setCountry("U.S.A");
			address.setZip("78759");

			organization.setAddress(address);

			try
			{
			
			
**Step 3:** Finally, pass the Organization object into the `create()` method to set up a new organization.
				
				Organization newOrganization = organizationsApi.create(organization);

## Get the list of organizations:

- - -

If you wish to get the list of all your Zoho Books organizations, you need to call the `getOrganizations()` method in the format below:

				OrganizationList orgList = organizationsApi.getOrganizations();
 
It returns the OrganizationList object as a response.

Similarly, if you wish to parse the organization id from the List of Organization objects, you need to send a request in the prescribed format below:

				String orgId = orgList.get(0).getOrganizationId();

## Get details of an organization:

- - -

In order to get the details of a organization, you need to call the `get()` method by passing  organization_id as a parameter.
				
				Organization org = organizationsApi.get(orgId);

## Update an existing organization:	

- - -			
				
Follow the steps listed below to update details of an existing organization.

**Step 1:** Select the the particular organization and fetch its Organization object by calling the `get()` method.

				Organization org = organizationsApi.get(orgId);

**Step 2:** Say you want to update the date format and tax basis details of that organization. Sample below:

				org.setDateFormat("yyyy mmm dd");            
				org.setTaxBasis("cash");
    
Now, pass the Organization object into the `update()` method to change the date format and taxbasis details. 
          
				Organization updateOrg = organizationsApi.update(org);

Similarly, if you want to fetch the organization name from the Organization object, you can make use of the sample code below:
				
				System.out.println(updateOrg.getName());
				
			}

## Catch Exceptions:

- - -	

If there is any error encountered while calling the Java Wrappers of Zoho Books API, the respective class will throw the BooksException. Use the below mentioned code to catch the BooksException:
			
			catch(BooksException be)
			{
				System.out.println("Code : "+ be.getCode() +" Message : "+ be.getMessage());
			}

		}
        }
	
For a full set of examples, click [here](../../tree/master/test/com/zoho/books/test).

