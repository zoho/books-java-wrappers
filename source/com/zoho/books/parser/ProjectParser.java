/* $Id$ */

package com.zoho.books.parser;

import com.zoho.books.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectParser is used to parse the json response and make it into the respective objects.
 */

public class ProjectParser {

    /**
     * Parse the json response and returns the ProjectList object.
     *
     * @param response This json response contains list of projects details.
     * @return Returns the ProjectList object.
     */

    public ProjectList getProjects(String response) throws Exception {

        ProjectList projectList = new ProjectList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("projects"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Project project = new Project();

            project.setProjectId(jsonArray.getJSONObject(i).getString("project_id"));
            project.setProjectName(jsonArray.getJSONObject(i).getString("project_name"));
            project.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            project.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            project.setDescription(jsonArray.getJSONObject(i).getString("description"));
            project.setStatus(jsonArray.getJSONObject(i).getString("status"));
            project.setBillingType(jsonArray.getJSONObject(i).getString("billing_type"));
			if (jsonArray.getJSONObject(i).has("rate")) {
				project.setRate(jsonArray.getJSONObject(i).getDouble("rate")); // No
																				// I18N
			}
            project.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));

            projectList.add(project);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        projectList.setPageContext(pageContext);

        return projectList;
    }

    /**
     * Parse the json response and returns the Project object.
     *
     * @param response This json response contains the project details.
     * @return Returns the Project object.
     */

    public Project getProject(String response) throws Exception {
        Project projects = new Project();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject project = jsonObject.getJSONObject("project"); //No I18N

        projects.setProjectId(project.getString("project_id"));
        projects.setProjectName(project.getString("project_name"));
        projects.setCustomerId(project.getString("customer_id"));
        projects.setCustomerName(project.getString("customer_name"));
        projects.setCurrencyCode(project.getString("currency_code"));
        projects.setDescription(project.getString("description"));
        projects.setStatus(project.getString("status"));
        projects.setBillingType(project.getString("billing_type"));
        projects.setBudgetType(project.getString("budget_type"));
        projects.setTotalHours(project.getString("total_hours"));
        projects.setBilledHours(project.getString("billed_hours"));
        projects.setUnBilledHours(project.getString("un_billed_hours"));
        projects.setCreatedTime(project.getString("created_time"));

        JSONArray jsonArray = project.getJSONArray("tasks"); //No I18N

        List<Task> tasks = new ArrayList<Task>();

        for (int i = 0; i < jsonArray.length(); i++) {
            Task task = new Task();

            task.setTaskId(jsonArray.getJSONObject(i).getString("task_id"));
            task.setTaskName(jsonArray.getJSONObject(i).getString("task_name"));
            task.setDescription(jsonArray.getJSONObject(i).getString("description"));
            task.setRate(jsonArray.getJSONObject(i).getDouble("rate"));        //No I18N
            task.setBudgetHours(jsonArray.getJSONObject(i).getInt("budget_hours")); //No I18N
            task.setTotalHours(jsonArray.getJSONObject(i).getString("total_hours"));
            task.setBilledHours(jsonArray.getJSONObject(i).getString("billed_hours"));
            task.setUnBilledHours(jsonArray.getJSONObject(i).getString("un_billed_hours"));

            tasks.add(i, task);
        }

        projects.setTasks(tasks);

        JSONArray usersArr = project.getJSONArray("users"); //No I18N

        List<User> users = new ArrayList<User>();

        for (int i = 0; i < usersArr.length(); i++) {
            User user = new User();

            user.setUserId(usersArr.getJSONObject(i).getString("user_id"));
            user.setIsCurrentUser(usersArr.getJSONObject(i).getBoolean("is_current_user")); //No I18N
            user.setUserName(usersArr.getJSONObject(i).getString("user_name"));
            user.setEmail(usersArr.getJSONObject(i).getString("email"));
            user.setUserRole(usersArr.getJSONObject(i).getString("user_role"));
            user.setStatus(usersArr.getJSONObject(i).getString("status"));
            user.setRate(usersArr.getJSONObject(i).getDouble("rate"));        //No I18N
            user.setBudgetHours(usersArr.getJSONObject(i).getInt("budget_hours"));    //No I18N
            user.setTotalHours(usersArr.getJSONObject(i).getString("total_hours"));
            user.setBilledHours(usersArr.getJSONObject(i).getString("billed_hours"));
            user.setUnBilledHours(usersArr.getJSONObject(i).getString("un_billed_hours"));

            users.add(i, user);
        }

        projects.setUsers(users);

        return projects;
    }

    /**
     * Parse the json response and returns a string object.
     *
     * @param response This json response contains the success message of post or update or delete requests.
     * @return Returns the success message.
     */

    public String getMessage(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response.trim());

        String success = jsonObject.getString("message");

        return success;
    }

    /**
     * Parse the json response and returns the TaskList object.
     *
     * @param response This json response contains list of tasks details for project.
     * @return Returns the TaskList object.
     */

    public TaskList getTasks(String response) throws Exception {

        TaskList taskList = new TaskList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("task"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            Task task = new Task();

            task.setProjectId(jsonArray.getJSONObject(i).getString("project_id"));
            task.setTaskId(jsonArray.getJSONObject(i).getString("task_id"));
            task.setCurrencyId(jsonArray.getJSONObject(i).getString("currency_id"));
            task.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            task.setTaskName(jsonArray.getJSONObject(i).getString("task_name"));
            task.setProjectName(jsonArray.getJSONObject(i).getString("project_name"));
            task.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            task.setBilledHours(jsonArray.getJSONObject(i).getString("billed_hours"));
            task.setLogTime(jsonArray.getJSONObject(i).getString("log_time"));
            task.setUnBilledHours(jsonArray.getJSONObject(i).getString("un_billed_hours"));
            try {
            	task.setRate(jsonArray.getJSONObject(i).getDouble("rate"));        //No I18N
            } catch (Exception e) {
            	
            }

            taskList.add(task);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        if (pagecontext.has("applied_filter")) {
            pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        }
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        taskList.setPageContext(pageContext);

        return taskList;
    }

    /**
     * Parse the json response and returns the Task object.
     *
     * @param response This json response contains the task details for project.
     * @return Returns the Task object.
     */

    public Task getTask(String response) throws Exception {

        Task tasks = new Task();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject task = jsonObject.getJSONObject("task"); //No I18N

        tasks.setProjectId(task.getString("project_id"));
        tasks.setProjectName(task.getString("project_name"));
        tasks.setTaskId(task.getString("task_id"));
        tasks.setTaskName(task.getString("task_name"));
        tasks.setDescription(task.getString("description"));
        tasks.setRate(task.getDouble("rate")); //No I18N

        return tasks;
    }

    /**
     * Parse the json response and returns the UserList object.
     *
     * @param response This json response contains list of users details for project.
     * @return Returns the UserList object.
     */

    public UserList getUsers(String response) throws Exception {

        UserList userList = new UserList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("users"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            User user = new User();

            user.setUserId(jsonArray.getJSONObject(i).getString("user_id"));
            user.setIsCurrentUser(jsonArray.getJSONObject(i).getBoolean("is_current_user")); //No I18N
            user.setUserName(jsonArray.getJSONObject(i).getString("user_name"));
            user.setEmail(jsonArray.getJSONObject(i).getString("email"));
            user.setUserRole(jsonArray.getJSONObject(i).getString("user_role"));
            user.setStatus(jsonArray.getJSONObject(i).getString("status"));
            user.setRate(jsonArray.getJSONObject(i).getDouble("rate"));    //No I18N
            user.setBudgetHours(jsonArray.getJSONObject(i).getInt("budget_hours")); //No I18N

            userList.add(user);
        }

        return userList;
    }

    /**
     * Parse the json response and returns the User object.
     *
     * @param response This json response contains the user details for project.
     * @return Returns the User object.
     */

    public User getUser(String response) throws Exception {
        User users = new User();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject user = jsonObject.getJSONObject("user"); //No I18N

        users.setProjectId(user.getString("project_id"));
        users.setUserId(user.getString("user_id"));
        users.setIsCurrentUser(user.getBoolean("is_current_user")); //No I18N
        users.setUserName(user.getString("user_name"));
        users.setEmail(user.getString("email"));
        users.setUserRole(user.getString("user_role"));

        return users;
    }

    /**
     * Parse the json response and returns the TimeEntryList object.
     *
     * @param response This json response contains list of time entries details for project.
     * @return Returns the TimeEntryList object.
     */

    public TimeEntryList getTimeEntries(String response) throws Exception {

        TimeEntryList timeEntryList = new TimeEntryList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray jsonArray = jsonObject.getJSONArray("time_entries"); //No I18N

        for (int i = 0; i < jsonArray.length(); i++) {
            TimeEntry timeEntry = new TimeEntry();

            timeEntry.setTimeEntryId(jsonArray.getJSONObject(i).getString("time_entry_id"));
            timeEntry.setProjectId(jsonArray.getJSONObject(i).getString("project_id"));
            timeEntry.setProjectName(jsonArray.getJSONObject(i).getString("project_name"));
            timeEntry.setCustomerId(jsonArray.getJSONObject(i).getString("customer_id"));
            timeEntry.setCustomerName(jsonArray.getJSONObject(i).getString("customer_name"));
            timeEntry.setTaskId(jsonArray.getJSONObject(i).getString("task_id"));
            timeEntry.setTaskName(jsonArray.getJSONObject(i).getString("task_name"));
            timeEntry.setUserId(jsonArray.getJSONObject(i).getString("user_id"));
            timeEntry.setIsCurrentUser(jsonArray.getJSONObject(i).getBoolean("is_current_user")); //No I18N
            timeEntry.setUserName(jsonArray.getJSONObject(i).getString("user_name"));
            timeEntry.setLogDate(jsonArray.getJSONObject(i).getString("log_date"));
            timeEntry.setLogTime(jsonArray.getJSONObject(i).getString("log_time"));
            timeEntry.setNotes(jsonArray.getJSONObject(i).getString("notes"));
            timeEntry.setTimerStartedAt(jsonArray.getJSONObject(i).getString("timer_started_at"));
            timeEntry.setTimerDurationInMinutes(jsonArray.getJSONObject(i).getInt("timer_duration_in_minutes")); //No I18N
            timeEntry.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));

            timeEntryList.add(timeEntry);

        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setAppliedFilter(pagecontext.getString("applied_filter"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        timeEntryList.setPageContext(pageContext);

        return timeEntryList;
    }

    /**
     * Parse the json response and returns the TimeEntry object.
     *
     * @param response This json response contains the time entry details for project.
     * @return Returns the TimeEntry object.
     */

    public TimeEntry getTimeEntry(String response) throws Exception {
        TimeEntry timeEntries = new TimeEntry();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject timeEntry = jsonObject.getJSONObject("time_entry"); //No I18N

        timeEntries.setTimeEntryId(timeEntry.getString("time_entry_id"));
        timeEntries.setProjectId(timeEntry.getString("project_id"));
        timeEntries.setProjectName(timeEntry.getString("project_name"));
        timeEntries.setTaskId(timeEntry.getString("task_id"));
        timeEntries.setTaskName(timeEntry.getString("task_name"));
        timeEntries.setUserId(timeEntry.getString("user_id"));
        timeEntries.setUserName(timeEntry.getString("user_name"));
        timeEntries.setIsCurrentUser(timeEntry.getBoolean("is_current_user")); //No I18N
        timeEntries.setLogDate(timeEntry.getString("log_date"));
        timeEntries.setLogTime(timeEntry.getString("log_time"));
        timeEntries.setNotes(timeEntry.getString("notes"));
        timeEntries.setTimerStartedAt(timeEntry.getString("timer_started_at"));
        timeEntries.setTimerDurationInMinutes(timeEntry.getInt("timer_duration_in_minutes")); //No I18N
        timeEntries.setCreatedTime(timeEntry.getString("created_time"));

        return timeEntries;
    }

    /**
     * Parse the json response and returns the CommentList object.
     *
     * @param response This json response contains list of comments details for project.
     * @return Returns the CommentList object.
     */

    public CommentList getComments(String response) throws Exception {

        CommentList commentList = new CommentList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray comments = jsonObject.getJSONArray("comments"); //No I18N

        for (int i = 0; i < comments.length(); i++) {
            Comment comment = new Comment();

            comment.setCommentId(comments.getJSONObject(i).getString("comment_id"));
            comment.setProjectId(comments.getJSONObject(i).getString("project_id"));
            comment.setDescription(comments.getJSONObject(i).getString("description"));
            comment.setCommentedById(comments.getJSONObject(i).getString("commented_by_id"));
            comment.setCommentedBy(comments.getJSONObject(i).getString("commented_by"));
            comment.setIsCurrentUser(comments.getJSONObject(i).getBoolean("is_current_user")); //No I18N
            comment.setDate(comments.getJSONObject(i).getString("date"));
            comment.setDateDescription(comments.getJSONObject(i).getString("date_description"));
            comment.setTime(comments.getJSONObject(i).getString("time"));

            commentList.add(comment);
        }

        return commentList;
    }

    /**
     * Parse the json response and returns the Comment object.
     *
     * @param response This json response contains the comment details for project.
     * @return Returns the Comment object.
     */

    public Comment getComment(String response) throws Exception {
        Comment comment = new Comment();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONObject comments = jsonObject.getJSONObject("comment"); //No I18N

        comment.setCommentId(comments.getString("comment_id"));
        comment.setProjectId(comments.getString("project_id"));
        comment.setDescription(comments.getString("description"));
        comment.setCommentedById(comments.getString("commented_by_id"));
        comment.setCommentedBy(comments.getString("commented_by"));
        comment.setDate(comments.getString("date"));
        comment.setDateDescription(comments.getString("date_description"));
        comment.setTime(comments.getString("time"));

        return comment;
    }

    /**
     * Parse the json response and returns the InvoiceList object.
     *
     * @param response This json response contains list of invoices details for project.
     * @return Returns the InvoiceList object.
     */

    public InvoiceList getInvoices(String response) throws Exception {

        InvoiceList invoiceList = new InvoiceList();

        JSONObject jsonObject = new JSONObject(response.trim());

        JSONArray invoices = jsonObject.getJSONArray("invoices"); //No I18N

        for (int i = 0; i < invoices.length(); i++) {
            Invoice invoice = new Invoice();

            invoice.setInvoiceId(invoices.getJSONObject(i).getString("invoice_id"));
            invoice.setCustomerName(invoices.getJSONObject(i).getString("customer_name"));
            invoice.setCustomerId(invoices.getJSONObject(i).getString("customer_id"));
            invoice.setStatus(invoices.getJSONObject(i).getString("status"));
            invoice.setInvoiceNumber(invoices.getJSONObject(i).getString("invoice_number"));
            invoice.setReferenceNumber(invoices.getJSONObject(i).getString("reference_number"));
            invoice.setDate(invoices.getJSONObject(i).getString("date"));
            invoice.setDueDate(invoices.getJSONObject(i).getString("due_date"));
            invoice.setTotal(invoices.getJSONObject(i).getDouble("total"));        //No I18N
            invoice.setBalance(invoices.getJSONObject(i).getDouble("balance"));    //No I18N
            invoice.setCreatedTime(invoices.getJSONObject(i).getString("created_time"));

            invoiceList.add(invoice);
        }

        PageContext pageContext = new PageContext();

        JSONObject pagecontext = jsonObject.getJSONObject("page_context"); //No I18N

        pageContext.setPage(pagecontext.getInt("page"));    //No I18N
        pageContext.setPerPage(pagecontext.getInt("per_page")); //No I18N
        pageContext.setHasMorePage(pagecontext.getBoolean("has_more_page")); //No I18N
        pageContext.setReportName(pagecontext.getString("report_name"));
        pageContext.setSortColumn(pagecontext.getString("sort_column"));
        pageContext.setSortOrder(pagecontext.getString("sort_order"));

        invoiceList.setPageContext(pageContext);

        return invoiceList;
    }

}
