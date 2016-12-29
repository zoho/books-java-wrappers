/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for task.
 */

public class Task {
    private String taskId = "";
    private String taskName = "";
    private String description = "";
    private double rate = 0.00;
    private int budgetHours = 0;
    private String totalHours = "";
    private String billedHours = "";
    private String unBilledHours = "";


    private String projectId = "";
    private String currencyId = "";
    private String customerId = "";
    private String projectName = "";
    private String customerName = "";
    private String logTime = "";
    private String createdTime = "";


    /**
     * set the task id.
     *
     * @param taskId ID of the task.
     */

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * get the task id.
     *
     * @return Returns the ID of the task.
     */

    public String getTaskId() {
        return taskId;
    }

    /**
     * set the task name.
     *
     * @param taskName Name of the task.
     */

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * get the task name.
     *
     * @return Returns the name of the task.
     */

    public String getTaskName() {
        return taskName;
    }

    /**
     * set the description.
     *
     * @param description Description of the task.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get the description.
     *
     * @return Returns the description of the task.
     */

    public String getDescription() {
        return description;
    }

    /**
     * set the rate.
     *
     * @param rate Hourly rate for a task.
     */

    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * get the rate.
     *
     * @return Returns the hourly rate of the task.
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
     * @return Returns the budget hours of the task.
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
     * @return Returns the total hours of the task.
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
     * @return Returns the billed hours of the task.
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
     * @return Returns the un billed hours of the task.
     */

    public String getUnBilledHours() {
        return unBilledHours;
    }


    /**
     * set the project id.
     *
     * @param projectId ID of the project associated with the task.
     */

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * get the project id.
     *
     * @return Returns the ID of the project associated with the task.
     */

    public String getProjectId() {
        return projectId;
    }

    /**
     * set the currency id.
     *
     * @param currencyId ID of the currency.
     */

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * get the currency id.
     *
     * @return Returns the ID of the currency.
     */

    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * set the customer id.
     *
     * @param customerId ID of the customer.
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get the customer id.
     *
     * @return Returns the ID of the customer.
     */

    public String getCustomerId() {
        return customerId;
    }

    /**
     * set the project name.
     *
     * @param projectName Name of the project associated with the task.
     */

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * get the project name.
     *
     * @return Returns the name of the project associated with the task.
     */

    public String getProjectName() {
        return projectName;
    }

    /**
     * set the customer name.
     *
     * @param customerName Name of the customer.
     */

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get the customer name.
     *
     * @return Returns the name of the customer.
     */

    public String getCustomerName() {
        return customerName;
    }

    /**
     * set the log time.
     *
     * @param logTime Log time for the task.
     */

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    /**
     * get the log time.
     *
     * @return Returns the log time for the task.
     */

    public String getLogTime() {
        return logTime;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time for the task.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time for the task.
     */

    public String getCreatedTime() {
        return createdTime;
    }


    /**
     * Convert Task object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("task_name", taskName);
        jsonObject.put("description", description);
        jsonObject.put("rate", rate);
        jsonObject.put("budget_hours", budgetHours);

        return jsonObject;
    }
}
