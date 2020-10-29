/* $Id$ */

package com.zoho.books.api;

import java.util.HashMap;

/**
 * API is the super class for all API class. It maintains the service URL and credential.
 * 
 * @author ramesh-2099
 *
 */

public class API
{
		
		/**
		 * This is the API base URL for Zoho Books service.
		 */
	
		public static String baseURL = "https://books.zoho.com/api/v3";	//No I18N
	
		protected String accessToken;
		
		protected String organizationId;
		
		/**
		 * Construct a new API using access token and organization ID.
		 * 
		 * @param accessToken OAuth access token.
		 * 
		 * @param organizationId User's organizationId.
		 */
	
		public API(String accessToken, String organizationId)
		{
				this.accessToken = accessToken;
				
				this.organizationId = organizationId;
		}
		
		
		/**
		 * Construct a queryMap containing organization_id.
		 * 
		 * @return Returns a HashMap.
		 */
		
		public HashMap<String, Object> getQueryMap() 
		{
			
				HashMap<String, Object> queryMap = new HashMap<String, Object>();
				
				queryMap.put("organization_id", organizationId);
				
				return queryMap;
			
		}
		
		
		/**
		 * Construct a queryMap with the provided query string parameters, and add organization_id.
		 *  
		 * @param queryMap This queryMap contains the query string parameters.
		 * 
		 * @return Returns a HashMap.
		 */
		
		public HashMap<String, Object> getQueryMap(HashMap<String, Object> queryMap) 
		{
			
				if(queryMap == null || queryMap.isEmpty())
				{
						queryMap = new HashMap<String, Object>();
				}
				
				queryMap.put("organization_id", organizationId);
				
				return queryMap;
			
		}
	
}
