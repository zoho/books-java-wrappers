# ZohoBooks Java Client Library

The java library for integrating with ZohoBooks.

## Installation

### Maven users

Add the below dependency to your `pom.xml`:

	<dependency>
	  <groupId>com.zoho.books</groupId>
	  <artifactId>books-java</artifactId>
	  <version>1.0</version>
	</dependency>
	

# Documentation

[API Documentation](https://www.zoho.com/books/api/v3/contacts/)

# Usage


If you want to use all our zoho books services API you should have a valid Zoho username, password and a valid authtoken.

How to generate your authtoken? [Refer Here](https://www.zoho.com/books/api/v3/) 

If you have a valid authtoken, you are able to access our Zoho Books API wrappers. 

How to access our wrapper classes? Here is a sample example code for accessing Zoho Books Organization.

You have to import these classes:


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
		
		
You have two ways to create a new instance for OrganizationApi.

1.Pass your authtoken and organizationid into ZohoBooks object to get the instance for OrganizationApi.

Here is the example code,
				
				
			ZohoBooks service = new ZohoBooks();
			service.initialize("{auth_token}", "{organization_id}");

			OrganizationsApi organizationsApi = service.getOrganizationsApi();
			

2.Pass your authtoken to create a new OrganizationApi instance.

Here is the example code,
		
		
			OrganizationsApi organizationsApi = new OrganizationsApi(authtoken);

## Create an organization: 			

- - -

When you sign up Zoho Books for the first time, you need to create your organization.

You need to create a new Organization object and set the information in that object.


			Organization organization = new Organization();

				organization.setName("ZOHO");
				organization.setFiscalYearStartMonth("january");
				organization.setCurrencyCode("INR");
				organization.setTimeZone("Asia/Calcutta");
				organization.setDateFormat("dd MMM yyyy");
				organization.setLanguageCode("en");
				organization.setTaxBasis("accrual");
				organization.setTaxType("tax");
					
					
You need to create an Address object and set the address details in that object.

Then you need to set the Address object into the Organization object.

			
			Address address = new Address();

				address.setStreetAddress1("1/124,Shivaji Garden");
				address.setStreetAddress2("Ramapuram");
				address.setCity("Chennai");
				address.setState("Tamil Nadu");
				address.setCountry("India");
				address.setZip("600 089");

				organization.setAddress(address);

			try
			{
			
			
Pass the Organization object into the `create()` method; it creates a new organization.

				
				Organization newOrganization = organizationsApi.create(organization);

## Get the list of organizations:

- - -

If you want to get all your organizations, you need to call the `getOrganizations()` method. It returns the OrganizationList object.

				
				OrganizationList orgList = organizationsApi.getOrganizations();


If you want to parse the organization id from the OrganizationList object then you need to write your code as mentioned below:
 
 
				String orgId = orgList.get(0).getOrganizationId();

## Get the details of an organization:

- - -

If you want to get a particular Organization, you need to call `get()` method by passing the organization id.

				
				Organization org = organizationsApi.get(orgId);

## Update the details of an organization:	

- - -			
				
If you want to update the details of an organization then you need to fetch the Organization object by calling the `get()` method.

If you want to change the date format and tax basis you need to write your code as mentioned below: 


				org.setDateFormat("yyyy mmm dd");
				org.setTaxBasis("cash");


When you pass the Organization object into the `update()` method, the organization date format and tax basis will be changed.

				
				Organization updateOrg = organizationsApi.update(org);
				
				
If you want to get the organization name from the Organization object then your code needs to be as mentioned below:

				
				System.out.println(updateOrg.getName());
				
			}

## Catch the exception:

- - -	

When calling Zoho Books API wrappers if there is any error then the respective class throws the BooksException. You need to catch the BooksException as mentioned below:

			
			catch(BooksException be)
			{
				System.out.println("Code : "+ be.getCode() +" Message : "+ be.getMessage());
			}

		}
	}
	
See [Here](../../tree/master/test/com/zoho/books/test) for more examples.

