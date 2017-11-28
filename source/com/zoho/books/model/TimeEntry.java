/* $Id$ */

package com.zoho.books.model;

import org.json.JSONObject;

/**
 * This class is used to make an object for time entry.
 */

public class TimeEntry {
    private String timeEntryId = "";
    private String projectId = "";
    private String projectName = "";
    private String customerId = "";
    private String customerName = "";
    private String taskId = "";
    private String taskName = "";
    private String userId = "";
    private boolean isCurrentUser = false;
    private String userName = "";
    private String logDate = "";
    private String logTime = "";
    private String billedStatus = "";
    private String notes = "";
    private String timerStartedAt = "";
    private int timerDurationInMinutes = 0;
    private String createdTime = "";


    private boolean startTimer = false;


    /**
     * set the time entry id.
     *
     * @param timeEntryId ID of the time entry.
     */

    public void setTimeEntryId(String timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    /**
     * get the time entry id.
     *
     * @return Returns the ID of the time entry.
     */

    public String getTimeEntryId() {
        return timeEntryId;
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
     * set the project name.
     *
     * @param projectName Name of the project.
     */

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * get the project name.
     *
     * @return Returns the name of the project.
     */

    public String getProjectName() {
        return projectName;
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
     * set is current user.
     *
     * @param isCurrentUser To specify the user is current user or not.
     */

    public void setIsCurrentUser(boolean isCurrentUser) {
        this.isCurrentUser = isCurrentUser;
    }

    /**
     * get is current user.
     *
     * @return Returns true if the user is current user else return false.
     */

    public boolean isCurrentUser() {
        return isCurrentUser;
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
     * set the log date.
     *
     * @param logDate Date on which the user spent on the task.
     */

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    /**
     * get the log date.
     *
     * @return Returns the date on which the user spent on the task.
     */

    public String getLogDate() {
        return logDate;
    }

    /**
     * set the log time.
     *
     * @param logTime Time the user spent on this task.
     */

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    /**
     * get the log time.
     *
     * @return Returns the time the user spent on this task.
     */

    public String getLogTime() {
        return logTime;
    }

    /**
     * set the billed status.
     *
     * @param billedStatus Billed status of the time entry.
     */

    public void setBilledStatus(String billedStatus) {
        this.billedStatus = billedStatus;
    }

    /**
     * get the billed status.
     *
     * @return Returns the billed status of the time entry.
     */

    public String getBilledStatus() {
        return billedStatus;
    }

    /**
     * set the notes.
     *
     * @param notes Description of the work done.
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the notes.
     *
     * @return Returns the description of the work done.
     */

    public String getNotes() {
        return notes;
    }

    /**
     * set the timer started at.
     *
     * @param timerStartedAt In which time the timer started.
     */

    public void setTimerStartedAt(String timerStartedAt) {
        this.timerStartedAt = timerStartedAt;
    }

    /**
     * get the timer started at.
     *
     * @return Returns in which time the timer started.
     */

    public String getTimerStartedAt() {
        return timerStartedAt;
    }

    /**
     * set the timer duration in minutes.
     *
     * @param timerDurationInMinutes Timer duration in minutes of the time entry.
     */

    public void setTimerDurationInMinutes(int timerDurationInMinutes) {
        this.timerDurationInMinutes = timerDurationInMinutes;
    }

    /**
     * get the timer duration in minutes.
     *
     * @return Returns the timer duration in minutes of the time entry.
     */

    public int getTimerDurationInMinutes() {
        return timerDurationInMinutes;
    }

    /**
     * set the created time.
     *
     * @param createdTime Created time of the time entry.
     */

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * get the created time.
     *
     * @return Returns the created time of the time entry.
     */

    public String getCreatedTime() {
        return createdTime;
    }


    /**
     * set start timer.
     *
     * @param startTimer Start timer.
     */

    public void setStartTimer(boolean startTimer) {
        this.startTimer = startTimer;
    }

    /**
     * get start timer.
     *
     * @return Returns true if the timer is started else returns false.
     */

    public boolean startTimer() {
        return startTimer;
    }


    /**
     * Convert TimeEntry object into JSONObject.
     *
     * @return Returns a JSONObject.
     */

    public JSONObject toJSON() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("project_id", projectId);
        jsonObject.put("task_id", taskId);
        jsonObject.put("user_id", userId);
        jsonObject.put("log_date", logDate);
        jsonObject.put("log_time", logTime);
        jsonObject.put("notes", notes);
        jsonObject.put("start_timer", startTimer);

        return jsonObject;
    }

}
