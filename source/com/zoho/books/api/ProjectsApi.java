/* $Id$ */

package com.zoho.books.api;

import com.zoho.books.util.ZohoHTTPClient;

import com.zoho.books.parser.ProjectParser;

import com.zoho.books.model.Project;
import com.zoho.books.model.Task;
import com.zoho.books.model.User;
import com.zoho.books.model.TimeEntry;
import com.zoho.books.model.Comment;
import com.zoho.books.model.ProjectList;
import com.zoho.books.model.TaskList;
import com.zoho.books.model.UserList;
import com.zoho.books.model.TimeEntryList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.InvoiceList;

import java.util.List;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

/**

* ProjectsApi is used to create projects for the customer.

* It is used to get: <br><br>

	The list of all projects.<br>
	
	The details of a project.<br>
	
	The list of all tasks.<br>
	
	The details of a task.<br>
	
	The list of all users.<br>
	
	The details of an user.<br>
	
	The list of all time entries.<br>
	
	The details of a time entry.<br>
	
	The list of all comments.<br>
	
	The list of all invoices created for this project.<br><br>
	
* It is used to:<br><br>

	Mark a project as active.<br>
	
	Mark a project as inactive.<br>
	
	Clone a project.<br>
	
	Add a task to a project.<br>
	
	Assign users to a project.<br>
	
	Invite and add user to  a project.<br>
	
	Log time entries.<br>
	
	Start tracking time spent.<br>
	
	Stop tracking time.<br>
	
	Add a comment to a project.<br><br>
	
* It is used to update:<br><br>

	The details of a project.<br>
	
	The details of a task.<br>
	
	The details of a user.<br>
	
	The details of a time entry.<br><br>
	
* It is used to delete:<br><br>

	The existing project.<br>
	
	The task to a project.<br>
	
	The user from the project.<br>
	
	The time entry for the project.<br>
	
	The comment for the project.<br>
	

*/

public class ProjectsApi extends API
{
	private static String url = baseURL+"/projects"; //No I18N

	
	/**
	
	* Construct a new ProjectsApi using user's authtoken and organizationid.
	
	* @param authToken user's authToken. 
	
	* @param organizationId user's organization id.
	
	*/

	public ProjectsApi(String authToken, String organizationId)
	{
		
		super(authToken, organizationId);
		
	}
	
	
	private ProjectParser projectParser = new ProjectParser();
	

	/**
	
	* List all projects with pagination.
	
	* Pass the filters to get all the projects based on the filters.
	
	* It returns the ProjectList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
			
				<tr><td>filter_by</td><td>Filter projects by any status.<br>
Allowed Values: <i>Status.All, Status.Active</i> and <i>Status.Inactive</i></td></tr>

				<tr><td>customer_id</td><td>Search projects by customer id.</td></tr>
				
				<tr><td>sort_column</td><td>Sort projects. <br>
Allowed Values: <i>project_name, customer_name, rate</i> and <i>created_time</i></td></tr>
			
			</tbody>
		
		</table> 
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the ProjectList object.
	
	*/
	
	public ProjectList getProjects(HashMap<String, Object> queryMap)throws Exception
	{
		
		String response = ZohoHTTPClient.get(url, getQueryMap(queryMap), accessToken);
		
		ProjectList projectList = projectParser.getProjects(response);
		
		return projectList;
	}
	
	
	/**
	
	* Get the details of a project.
	
	* Pass the projectId to get the details of a project.
	
	* It returns the Project object.
	
	
	* @param projectId ID of the project.
	
	* @return Returns the Project object.
	
	*/
	
	public Project get(String projectId)throws Exception
	{
		String urlString = url+"/"+projectId;
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		Project projects = projectParser.getProject(response);
		
		return projects;
	}
	
	
	/**
	
	* Create a project for your customer.
	
	* Pass the Project object to create a project for the customer.
	
	* The project object which contains projectName, customerId, billingType, userId, and taskName are the mandatory parameters.
	
	* It returns the Project object.
	
	
	* @param project Project object.
	
	* @return Returns the Project object.
	
	*/
	
	public Project create(Project project)throws Exception
	{
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", project.toJSON().toString());
		
		String response = ZohoHTTPClient.post(url, requestBody, accessToken);
		
		return projectParser.getProject(response);
		
	}
	
	
	/**
	
	* Update details of a project.
	
	* Pass the Project object to update the details of a project.
	
	* The Project object which contains projectId is the mandatory parameter for which project details has to be updated.
	
	* It returns the Project object.
	
	
	* @param project Project object.
	
	* @return Returns the Project object.
	
	*/
	
	public Project update(Project project)throws Exception
	{
		
		String urlString = url+"/"+project.getProjectId();
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", project.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return projectParser.getProject(response);
	}
	
	
	/**
	
	* Deleting a existing project.
	
	* Pass the projectId to delete the project.
	
	* If the project has been deleted it returns the success message.
	
	* The success message is "The project has been deleted."
	
	
	* @param projectId ID of the project.
	
	* @return Returns a String.
	
	*/
	
	public String delete(String projectId)throws Exception
	{
		
		String urlString = url+"/"+projectId;
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	/**
	
	* Mark project as active.
	
	* Pass the projectId to change the status of a project to 'active'.
	
	* If the project status has been changed it returns the success message.
	
	* The success message is "The selected Projects have been marked as active."
	
	
	* @param projectId ID of the project.
	
	* @return Returns a String.
	
	*/
	
	public String activate(String projectId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/active"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	/**
	
	* Marking a project as inactive.
	
	* Pass the projectId to change the status of a project to 'inactive'.
	
	* If the project status has been changed it returns the success message.
	
	* The success message is "The selected projects have been marked as inactive."
	
	
	* @param projectId ID of the project.
	
	* @return Returns a String.
	
	*/
	
	public String inactivate(String projectId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/inactive"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	/**
	
	* Cloning a project.
	
	* Pass the projectId, projectName, and description to clone the project.
	
	* It returns the Project object.
	
	
	* @param projectId ID of the project.
	
	* @param projectName Name of the project.
	
	* @param description Project description.
	
	* @return Returns the Project object.
	
	*/
	
	public Project clone(String projectId, String projectName, String description)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/clone"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("project_name", projectName);
		jsonObject.put("description", description);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		Project projects = projectParser.getProject(response);
		
		return projects;
	}
	
	
//=========================================================================================================================================



	/**
	
	* Get list of tasks added to a project.
	
	* Pass the projectId and filters to get all the tasks for the project based on the filter.
	
	* It returns the TaskList object.<br>
	
	* The queryMap contains the possible key and value as mentioned below: <br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>sort_column</td><td>Sort tasks. <br>
Allowed Values: <i>task_name, billed_hours, log_time</i> and <i>un_billed_hours</i></td></tr>
			</tbody>
		
		</table> 
		
	
	* @param projectId ID of the project.
	
	* @param queryMap Sort tasks.
	
	* @return Returns the TaskList object.
	
	*/
	
	public TaskList getTasks(String projectId, HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/tasks"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);
		
		TaskList taskList = projectParser.getTasks(response);
		
		return taskList;
	}
	
	
	/**
	
	* Add task to a project.
	
	* Pass the projectId and Task object to add a task for the project.
	
	* The Task object which contains taskName is the mandatory parameter.
	
	* It returns the Task object.
	
	
	* @param projectId ID of the project.
	
	* @param task Task object.
	
	* @return Returns the Task object.
	
	*/
	
	public Task addTask(String projectId, Task task)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/tasks"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", task.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		return projectParser.getTask(response);
	}
	
	
	/**
	
	* Get details of a task.
	
	* Pass the projectId and taskId to get the details of a task for the project.
	
	* It returns the Task object.
	
	
	* @param projectId ID of the project.
	
	* @param taskId ID of the Task.
	
	* @return Returns the Task object.
	
	*/
	
	public Task getTask(String projectId, String taskId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/tasks/"+taskId; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		Task task = projectParser.getTask(response);
		
		return task;
	}
	
	
	/**
	
	* Update details of a task.
	
	* Pass the projectId and Task object to update the details of a task for the project.
	
	* The Task object which contains taskId is the mandatory prameter for which task has to be updated.
	
	* It returns the Task object.
	
	
	* @param projectId ID of the project.
	
	* @param task Task object.
	
	* @return Returns the Task object.
	
	*/
	
	public Task updateTask(String projectId, Task task)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/tasks/"+task.getTaskId(); //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", task.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return projectParser.getTask(response);
	}
	
	
	/**
	
	* Deleting task added to a project.
	
	* Pass the projectId and taskId to delete the task from the project.
	
	* If the task has been deleted it returns the success message.
	
	* The success message is "The task has been deleted."
	
	
	* @param projectId ID of the project.
	
	* @param taskId ID of the Task.
	
	* @return Returns a String.
	
	*/
	
	public String deleteTask(String projectId, String taskId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/tasks/"+taskId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	
//======================================================================================================================================



	/**
	
	* Get list of user associated with a project.
	
	* Pass the projectId to get all the users for the project.
	
	* It returns the UserList object.
	
	
	* @param projectId ID of the project.
	
	* @return Returns the UserList object.
	
	*/
	
	public UserList getUsers(String projectId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/users"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		UserList userList = projectParser.getUsers(response);
		
		return userList;
	}
	
	
	/**
	
	* Get details of a user in a project.
	
	* Pass the projectId and userId to get the details of a user for the project.
	
	* It returns the User object.
	
	
	* @param projectId ID of the project.
	
	* @param userId ID of the user.
	
	* @return Returns the User object.
	
	*/
	
	public User getUser(String projectId, String userId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/users/"+userId; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		User user = projectParser.getUser(response);
		
		return user;
	}
	
	
	/**
	
	* Assign users to a project.
	
	* Pass the projectId and list of User object to assign the users for the project.
	
	* The User object which contains userId is the mandatory parameter.
	
	* It returns the UserList object.
	
	
	* @param projectId ID of the project.
	
	* @param users List of User object.
	
	* @return Returns the UserList object.
	
	*/
	
	public UserList assignUsers(String projectId, List<User> users)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/users"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < users.size(); i++)
		{
			JSONObject user = new JSONObject();
			
			user.put("user_id", users.get(i).getUserId());
			user.put("rate", users.get(i).getRate());
			user.put("budget_hours", users.get(i).getBudgetHours());
			
			jsonArray.put(user);
		}
		jsonObject.put("users", jsonArray);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		return projectParser.getUsers(response);
		
	}
	
	/**
	
	* Invite and add user to the project.
	
	* Pass the projectId and User object to invite the user for the project.
	
	* The User object which contains userName and email are the mandatory parameters.
	
	* It returns the User object.
	
	
	* @param projectId ID of the project.
	
	* @param user User object.
	
	* @return Returns the User object.
	
	*/
	
	public User inviteUser(String projectId, User user)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/users/invite"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", user.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		return projectParser.getUser(response);
	}
	
	
	/**
	
	* Update details of a user.
	
	* Pass the projectId and User object to update the details of a user for the project.
	
	* The User object which contains userId is the mandatory parameter for which user details has to be updated.
	
	* It returns the User object.
	
	
	* @param projectId ID of the project.
	
	* @param user User object.
	
	* @return Returns the User object.
	
	*/
	
	public User updateUser(String projectId, User user)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/users/"+user.getUserId(); //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", user.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return projectParser.getUser(response);
	}
	
	
	/**
	
	* Remove user from the project.
	
	* Pass the projectId and userId to delete the user from the project.
	
	* If the user has been deleted it returns the success message.
	
	* The success message is "The staff has been removed."
	
	
	* @param projectId ID of the project.
	
	* @param userId ID of an user.
	
	* @return Returns a String.
	
	*/
	
	public String deleteUser(String projectId, String userId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/users/"+userId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	
//=========================================================================================================================================



	/**
	
	* List all time entries with pagination.
	
	* Pass the filters to get all the time entries based on the filters.
	
	* It retuens the TimeEntryList object.<br>
	
	* The queryMap contains the possible keys and values as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>from_date</td><td>Date from which the time entries logged to be fetched</td></tr>
				
				<tr><td>to_date</td><td>Date up to which the time entries logged to be fetched</td></tr>
				
				<tr><td>filter_by</td><td>Filter time entries by date and status.<br>
Allowed Values: <i>Date.All, Date.Today, Date.ThisWeek, Date.ThisMonth, Date.ThisQuarter, Date.ThisYear, Date.PreviousDay, Date.PreviousWeek, Date.PreviousMonth, Date.PreviousQuarter, Date.PreviousYear, Date.CustomDate, Status.Unbilled</i> and <i>Status.Invoiced</i></td></tr>

				<tr><td>project_id</td><td>Search time entries by project_id.</td></tr>
				
				<tr><td>user_id</td><td>Search time entries by user_id.</td></tr>
				
				<tr><td>sort_column</td><td>Sort time entries.<br>
Allowed Values: <i>project_name, task_name, user_name, log_date, timer_started_at</i> and <i>customer_name</i></td></tr>
			</tbody>
		
		</table>  
	
	* @param queryMap It contains the query string parameters in the form of key-value pair.
	
	* @return Returns the TimeEntryList object.
	
	*/
	
	public TimeEntryList getTimeEntries(HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/timeentries"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);
		
		TimeEntryList timeEntryList = projectParser.getTimeEntries(response);
		
		return timeEntryList;
	}
	
	
	/**
	
	* Logging time entries.
	
	* Pass the TimeEntry object to log the time entry.
	
	* The TimeEntry object which contains projectId, taskId, userId, and logDate are the mandatory parameters.
	
	* It returns the TimeEntry object.
	
	
	* @param timeEntry TimeEntry object.
	
	* @return Returns the TimeEntry object.
	
	*/
	
	public TimeEntry logTimeEntry(TimeEntry timeEntry)throws Exception
	{
		
		String urlString = url+"/timeentries"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", timeEntry.toJSON().toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		return projectParser.getTimeEntry(response);

	}
	
	
	/**
	
	* Get details of a time entry.
	
	* Pass the timeEntryId to get the details of a time entry.
	
	* It returns the TimeEntry object.
	
	
	* @param timeEntryId ID of the TimeEntry.
	
	* @return Returns the TimeEntry object.
	
	*/
	
	public TimeEntry getTimeEntry(String timeEntryId)throws Exception
	{
		
		String urlString = url+"/timeentries/"+timeEntryId; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		TimeEntry timeEntry = projectParser.getTimeEntry(response);
		
		return timeEntry;
	}
	
	
	/**
	
	* Update logged time entry
	
	* Pass the TimeEntry object to update the details of a time entry.
	
	* The TimeEntry object which contains timeEntryId is the mandatory parameter for which time entry details has to be updated.
	
	* It returns the TimeEntry object.
	
	
	* @param timeEntry TimeEntry object.
	
	* @return Returns the TimeEntry object.
	
	*/
	
	public TimeEntry updateTimeEntry(TimeEntry timeEntry)throws Exception
	{
		
		String urlString = url+"/timeentries/"+timeEntry.getTimeEntryId(); //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		requestBody.put("JSONString", timeEntry.toJSON().toString());
		
		String response = ZohoHTTPClient.put(urlString, requestBody, accessToken);
		
		return projectParser.getTimeEntry(response);
		
	}
	
	
	/**
	
	* Deleting a logged time entry.
	
	* Pass the timeEntryId to delete the time entry.
	
	* If the time entry has been deleted it returns the success message.
	
	* The success message is "The time entry has been deleted."
	
	
	* @param timeEntryId ID of the TimeEntry.
	
	* @return Returns a String.
	
	*/
	
	public String deleteTimeEntry(String timeEntryId)throws Exception
	{
		
		String urlString = url+"/timeentries/"+timeEntryId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	/**
	
	* Deleting time entries.
	
	* Pass the timeEntryIds in the query param to delete the list of time entries.
	
	* The queryMap contains the key as mentioned below: <br><br>
	
		time_entry_ids* - ID of the time entries to be deleted.<br><br>
	
	* If the time entries has been deleted it returns the success message.
	
	* The success message is "The selected timesheet entries have been deleted."
	
	
	* @param queryMap ID of the time entries to be deleted.
	
	* @return Returns a String.
	
	*/
	
	public String deleteTimeEntries(HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/timeentries"; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(queryMap), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
	/**
	
	* Start tracking time spent.
	
	* Pass the timeEntryId to start the timer.
	
	* It returns the TimeEntry object.
	
	
	* @param timeEntryId ID of the time entry.
	
	* @return Returns the TimeEntry object.
	
	*/
	
	public TimeEntry startTimer(String timeEntryId)throws Exception
	{
		
		String urlString = url+"/timeentries/"+timeEntryId+"/timer/start"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		TimeEntry timeEntry = projectParser.getTimeEntry(response);
		
		return timeEntry;
	}
	
	
	/**
	
	* Stop tracking time, say taking a break or leaving.
	
	* This method is used to stop the timer.
	
	* It returns the TimeEntry object.
	
	
	* @return Returns the TimeEntry object.
	
	*/
	
	public TimeEntry stopTimer()throws Exception
	{
		
		String urlString = url+"/timeentries/timer/stop"; //No I18N
		
		String response = ZohoHTTPClient.post(urlString, getQueryMap(), accessToken);
		
		TimeEntry timeEntry = projectParser.getTimeEntry(response);
		
		return timeEntry;
	}
	
	
//=========================================================================================================================================



	/**
	
	* get list of comments for the project.
	
	* Pass the projectId to get all the comments for the project.
	
	* It returns the CommentList object.
	
	
	* @param projectId Id of the project.
	
	* @return Returns the CommentList object. 
	
	*/
	
	public CommentList getComments(String projectId)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/comments"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(), accessToken);
		
		CommentList commentList = projectParser.getComments(response);
		
		return commentList;
	}
	
	
	/**
	
	* add comment for the project.
	
	* Pass the projectId and description to add the comment for the project.
	
	* It returns the Comment object.
	
	
	* @param projectId Id of the project.
	
	* @param description Description of the project
	
	* @return Returns the Comment object. 
	
	*/
	
	
	public Comment addComment(String projectId, String description)throws Exception
	{
		String urlString = url+"/"+projectId+"/comments"; //No I18N
		
		HashMap<String, Object>	requestBody = getQueryMap();
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("description", description);
		
		requestBody.put("JSONString", jsonObject.toString());
		
		String response = ZohoHTTPClient.post(urlString, requestBody, accessToken);
		
		Comment comment = projectParser.getComment(response);
		
		return comment;
	}
	
	/**
	
	* delete comment for the project.
	
	* Pass the projectId and commentId to delete the comment from the project.
	
	* If the comment has been deleted it returns the success message.
	
	* The success message is "The comment has been deleted."
	
	
	* @param projectId Id of the project.
	
	* @param commentId Id of the comment for the project
	
	* @return Returns a String. 
	
	*/
	
	
	public String deleteComment(String projectId, String commentId)throws Exception
	{
		String urlString = url+"/"+projectId+"/comments/"+commentId; //No I18N
		
		String response = ZohoHTTPClient.delete(urlString, getQueryMap(), accessToken);
		
		String success = projectParser.getMessage(response);
		
		return success;
	}
	
	
//=========================================================================================================================================


	/**
	
	* get list of invoices for the project.
	
	* Pass the projectId and filters to get all the invoices created for this project.
	
	* It returns the InvoiceList object.<br>
	
	* The queryMap contains the possible key and value as mentioned below:<br><br>
	
		<table border = "1">
			
			<tbody>
				<tr><td>sort_column</td><td>Sort invoices raised. <br>
Allowed Values: <i>invoice_number, date, total, balance</i> and <i>created_time</i></td></tr>
			</tbody>
		
		</table> 
	
	
	* @param projectId Id of the project.
	
	* @param queryMap Sort invoices raised.
	
	* @return Retruns the InvoiceList object.
	
	*/
	
	
	public InvoiceList getInvoices(String projectId, HashMap<String, Object> queryMap)throws Exception
	{
		
		String urlString = url+"/"+projectId+"/invoices"; //No I18N
		
		String response = ZohoHTTPClient.get(urlString, getQueryMap(queryMap), accessToken);
		
		InvoiceList invoiceList = projectParser.getInvoices(response);
		
		return invoiceList;
	}
	
}
