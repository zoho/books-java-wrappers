/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.model.User;
import com.zoho.books.model.UserList;
import com.zoho.books.parser.SettingsParser;
import com.zoho.books.util.ZohoHTTPClient;

import java.util.HashMap;


/**
 * UsersApi is used to create the users of the Organization.
 * <p>
 * It is used to get and update the details of a particular user.<br>
 * <p>
 * It is used to get:<br><br>
 * <p>
 * The list of users for the organization.<br>
 * <p>
 * The current user for the organization.<br><br>
 * <p>
 * It is used to Invite a new user to the organization.<br>
 * <p>
 * It is used to Change the status of an user into active or inactive.<br>
 * <p>
 * It is used to Delete a particular user from the organization.
 */

public class UsersApi extends API {

    private static String url = baseURL + "/users"; //No I18N


    /**
     * Construct a new UsersApi using user's authtoken and organizationid.
     *
     * @param authToken      user's authToken.
     * @param organizationId user's organization id.
     */

    public UsersApi(String authToken, String organizationId) {

        super(authToken, organizationId);

    }


    private SettingsParser settingsParser = new SettingsParser();


    /**
     * Get the list of all users in the organization.
     * <p>
     * Pass the filters in the form of key, value pair to get all the users from the organization based on the filter.
     * <p>
     * It returns the UserList object.<br>
     * <p>
     * The queryMap contains the possible keys and values as mentioned below:<br><br>
     * <p>
     * <table border = "1">
     * <p>
     * <tbody>
     * <tr><td>filter_by</td><td>Filter through users with user status. <br>
     * Allowed Values: <i>Status.All, Status.Active, Status.Inactive, Status.Invited</i> and <i>Status.Deleted</i></td></tr>
     * <p>
     * <tr><td>sort_column</td><td>Sort users.<br>
     * Allowed Values: <i>name, email, user_role</i> and <i>status</i></td></tr>
     * </tbody>
     * <p>
     * </table>
     *
     * @param queryMap It contains the query string parameters in the form of key-value pair.
     * @return Returns the UserList object.
     */

    public UserList getUsers(HashMap<String, Object> queryMap) throws Exception {

        String response = ZohoHTTPClient.get(url, getQueryMap(queryMap));

        UserList userList = settingsParser.getUsers(response);

        return userList;
    }

    /**
     * Get the details of a user.
     * <p>
     * Pass the userId to get the details of a particular user.
     * <p>
     * It returns the User object.
     *
     * @param userId ID of the user.
     * @return Returns the User object.
     */

    public User get(String userId) throws Exception {

        String urlString = url + "/" + userId;

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        User user = settingsParser.getUser(response);

        return user;
    }

    /**
     * Get the details of the current user.
     * <p>
     * Call this method to get the current user for the organization.
     * <p>
     * It returns the User object.
     *
     * @return Returns the User object.
     */

    public User getCurrentUser() throws Exception {

        String urlString = url + "/me"; //No I18N

        String response = ZohoHTTPClient.get(urlString, getQueryMap());

        User user = settingsParser.getUser(response);

        return user;
    }

    /**
     * Create a user for your organization.
     * <p>
     * Pass the User object to create a new user for the organization.
     * <p>
     * The User object which contains name and email are mandatory parameters.
     * <p>
     * It returns the User object.
     *
     * @param user User object.
     * @return Returns the User object.
     */

    public User create(User user) throws Exception {

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", user.toJSON().toString());

        String response = ZohoHTTPClient.post(url, requestBody);

        return settingsParser.getUser(response);
    }

    /**
     * Update the details of a user.
     * <p>
     * Pass the User object to update the details of a particular user.
     * <p>
     * The User object must contain the userId for which user details has to be updated.
     * <p>
     * It returns the User object.
     *
     * @param user User object.
     * @return Returns the User object.
     */

    public User update(User user) throws Exception {

        String urlString = url + "/" + user.getUserId();

        HashMap<String, Object> requestBody = getQueryMap();

        requestBody.put("JSONString", user.toJSON().toString());

        String response = ZohoHTTPClient.put(urlString, requestBody);

        return settingsParser.getUser(response);
    }

    /**
     * Delete a user associated to the organization.
     * <p>
     * Pass the userId to delete the user from the users.
     * <p>
     * If the user has been deleted it returns the success message.
     * <p>
     * The success message is "The user has been removed from your organization."
     *
     * @param userId ID of the user.
     * @return Returns a String.
     */

    public String delete(String userId) throws Exception {

        String urlString = url + "/" + userId;

        String response = ZohoHTTPClient.delete(urlString, getQueryMap());

        String success = settingsParser.getMessage(response);

        return success;
    }

    /**
     * Send invitation email to a user.
     * <p>
     * Pass the user id to send an invitation for the user.
     * <p>
     * If the invitation has been sent to the user it returns the success message.
     * <p>
     * The success message is "Your invitation has been sent."
     *
     * @param userId ID of the user.
     * @return Returns a String.
     */

    public String inviteUser(String userId) throws Exception {

        String urlString = url + "/" + userId + "/invite"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = settingsParser.getMessage(response);

        return success;
    }

    /**
     * Mark an inactive user as active.
     * <p>
     * Pass the userId to change the status of an user to 'active'.
     * <p>
     * If the user status has been changed it returns the success message.
     * <p>
     * The success message is "The user has been marked as active."
     *
     * @param userId ID of the user.
     * @return Returns a String.
     */

    public String markUserAsActive(String userId) throws Exception {

        String urlString = url + "/" + userId + "/active"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = settingsParser.getMessage(response);

        return success;
    }

    /**
     * Mark an active user as inactive.
     * <p>
     * Pass the user id to change the status of an user to 'inactive'.
     * <p>
     * If the user status has been changed it returns the success message.
     * <p>
     * The success message is "The user has been marked as inactive."
     *
     * @param userId ID of the user.
     * @return Returns a String.
     */

    public String markUserAsInactive(String userId) throws Exception {

        String urlString = url + "/" + userId + "/inactive"; //No I18N

        String response = ZohoHTTPClient.post(urlString, getQueryMap());

        String success = settingsParser.getMessage(response);

        return success;
    }
}
