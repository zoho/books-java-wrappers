/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to make an object for user.
 */

public class User {
    private String userId = "";
    private String roleId = "";
    private String name = "";
    private String email = "";
    private String userRole = "";
    private String status = "";
    private boolean isCurrentUser = false;


    private String createdTime = "";


    private String userName = "";
    private double rate = 0.00;
    private int budgetHours = 0;
    private String totalHours = "";
    private String billedHours = "";
    private String unBilledHours = "";
    private String projectId = "";

    private List<EmailId> emailIds = new ArrayList<EmailId>();


    /**
     * set the user id.
     *
     * @param userId ID of the user.
     */

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * get the user id.
     *
     * @return Returns the ID of the user.
     */

    public String getUserId() {
        return userId;
    }

    /**
     * set the role id.
     *
     * @param roleId ID of the user role.
     */

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * get the role id.
     *
     * @return Returns the ID of the user role.
     */

    public String getRoleId() {
        return roleId;
    }

    /**
     * set the name.
     *
     * @param name Name of the user.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name.
     *
     * @return Returns the name of the user.
     */

    public String getName() {
        return name;
    }

    /**
     * set the email.
     *
     * @param email Email address of the user.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get the email.
     *
     * @return Returns the email address of the user.
     */

    public String getEmail() {
        return email;
    }

    /**
     * set the user role.
     *
     * @param userRole Role of the user. Sets the privileges for a user.
     */

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * get the user role.
     *
     * @return Returns the role of the user.
     */

    public String getUserRole() {
        return userRole;
    }

    /**
     * set the status.
     *
     * @param status Status of the user.
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the status.
     *
     * @return Returns the status of the user.
     */

    public String getStatus() {
        return status;
    }

    /**
     * set is current user.
     *
     * @param isCurrentUser To determine whether the user is current user or not.
     */

    public void setIsCurrentUser(boolean isCurrentUser) {
        this.isCurrentUser = isCurrentUser;
    }

    /**
     * get is current user.
     *
     * @return Returns true if the user is user is current user else returns false.
     */

    public boolean isCurrentUser() {
        return isCurrentUser;
    }


    /**
     * set the created time.
     *
     * @param createdTime Created time of the user.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the user.
     */

    public String getCreatedTime() {
        return createdTime;
    }


    /**
     * set the user name.
     *
     * @param userName Name of the user.
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * get the user name.
     *
     * @return Returns the name of the user.
     */

    public String getUserName() {
        return userName;
    }

    /**
     * set the rate.
     *
     * @param rate Hourly rate of the user.
     */

    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * get the rate.
     *
     * @return Returns the hourly rate of the user.
     */

    public double getRate() {
        return rate;
    }

    /**
     * set the budget hours.
     *
     * @param budgetHours Task budget hours.
     */

    public void setBudgetHours(int budgetHours) {
        this.budgetHours = budgetHours;
    }

    /**
     * get the budget hours.
     *
     * @return Returns the task budget hours.
     */

    public int getBudgetHours() {
        return budgetHours;
    }

    /**
     * set the total hours.
     *
     * @param totalHours Task total hours.
     */

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    /**
     * get the total hours.
     *
     * @return Returns the task total hours.
     */

    public String getTotalHours() {
        return totalHours;
    }

    /**
     * set the billed hours.
     *
     * @param billedHours Task billed hours.
     */

    public void setBilledHours(String billedHours) {
        this.billedHours = billedHours;
    }

    /**
     * get the billed hours.
     *
     * @return Returns the task billed hours.
     */

    public String getBilledHours() {
        return billedHours;
    }

    /**
     * set the un billed hours.
     *
     * @param unBilledHours Task un billed hours.
     */

    public void setUnBilledHours(String unBilledHours) {
        this.unBilledHours = unBilledHours;
    }

    /**
     * get the un billed hours.
     *
     * @return Returns the task un billed hours.
     */

    public String getUnBilledHours() {
        return unBilledHours;
    }

    /**
     * set the project id.
     *
     * @param projectId ID of the project.
     */

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * get the project id.
     *
     * @return Returns the ID of the project.
     */

    public String getProjectId() {
        return projectId;
    }


    /**
     * set the email ids.
     *
     * @param emailIds Email ids of the user.
     */

    public void setEmailIds(List<EmailId> emailIds) throws Exception {
        this.emailIds = emailIds;
    }

    /**
     * get the email ids.
     *
     * @return Returns list of EmailId object.
     */

    public List<EmailId> getEmailIds() {
        return emailIds;
    }


    /**
     * Convert User object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        if (name != null && !name.equals("")) {
            jsonObject.put("name", name);
        }
        if (email != null && !email.equals("")) {
            jsonObject.put("eamil", email);
        }
        if (userRole != null && !userRole.equals("")) {
            jsonObject.put("user_role", userRole);
        }
        if ((Double) rate != null) {
            jsonObject.put("rate", rate);
        }
        if ((Integer) budgetHours != null) {
            jsonObject.put("budget_hours", budgetHours);
        }

        return jsonObject;

    }
}
