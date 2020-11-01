/* $Id$ */

package com.zoho.books.test;

import com.zoho.books.exception.BooksException;

import com.zoho.books.service.ZohoBooks;

import com.zoho.books.api.ProjectsApi;

import com.zoho.books.model.Project;
import com.zoho.books.model.Task;
import com.zoho.books.model.User;
import com.zoho.books.model.TimeEntry;
import com.zoho.books.model.Comment;
import com.zoho.books.model.Invoice;
import com.zoho.books.model.ProjectList;
import com.zoho.books.model.TaskList;
import com.zoho.books.model.UserList;
import com.zoho.books.model.TimeEntryList;
import com.zoho.books.model.CommentList;
import com.zoho.books.model.InvoiceList;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;

public class ProjectTest
{
	public static void main(String[] args)throws Exception
	{
		ZohoBooks service = new ZohoBooks();
		service.initialize("{access_token}", "{organization_id}");	//No I18N
		
		ProjectsApi projectsApi = service.getProjectsApi();
		
		
		
		
		String projectName = "zoho";	//No I18N
		
		String customerId = "36991000000025001"; 
		
		String description = "This is the test project.";	//No I18N
		
		String billingType = "fixed_cost_for_project";	//No I18N
		
		double rate = 500.00;
		
		String budgetType = "total_project_hours";	//No I18N
		
		String taskName = "Task1";	//No I18N
		
		String userId = "36991000000013001";
		
		
		
		HashMap hashMap = new HashMap();
		
		hashMap.put("filter_by", "Status.All");
		hashMap.put("sort_column", "invoice_number");
		
		
		
		Project projects = new Project();
		
		projects.setProjectName(projectName);
		projects.setCustomerId(customerId);
		projects.setDescription(description);
		projects.setBillingType(billingType);
		projects.setRate(rate);
		projects.setBudgetType(budgetType);
		projects.setBudgetHours(10);
		
		Task task = new Task();
		task.setTaskName(taskName);
		task.setDescription(description);
		task.setRate(1000.00);
		task.setBudgetHours(10);
		
		List<Task> tasksList = new ArrayList<Task>();
		tasksList.add(0, task);
		
		projects.setTasks(tasksList);
		
		User user = new User();
		
		user.setUserId(userId);
		user.setRate(1000.00);
		user.setBudgetHours(10);
		
		List<User> users = new ArrayList<User>();
		users.add(0, user);
		
		projects.setUsers(users);
		
		
		
		Task tasks = new Task();
		 
		tasks.setTaskName("task1");	//No I18N
		tasks.setDescription(description);
		tasks.setRate(100.00);
		tasks.setBudgetHours(5);
		
		
		User user1 = new User();
		
		user1.setUserId(userId);
		user1.setRate(1000.00);
		user1.setBudgetHours(10);
		
		List<User> usersList = new ArrayList<User>();
		usersList.add(0, user1);
		
		
		User newUser = new User();
		
		newUser.setUserName("ramesh");	//No I18N
		newUser.setEmail("sahaya.ramesh@zohocorp.com");	//No I18N
		newUser.setUserRole("staff");	//No I18N
		newUser.setRate(1000.00);
		newUser.setBudgetHours(1);
		
		
		
		try
		{
		
			ProjectList getProjects = projectsApi.getProjects(hashMap);
			
			String projectId = getProjects.get(0).getProjectId();
		
			Project create = projectsApi.create(projects);
		
			Project get = projectsApi.get(projectId);
			
			get.setBillingType("based_on_task_hours"); //No I18N
		
			Project update = projectsApi.update(get);
		
			String activateProject = projectsApi.activate(projectId);
		
			String inactivateProject = projectsApi.inactivate(projectId);
		
			Project cloneProject = projectsApi.clone(projectId, projectName, description);
		
		
			TaskList getTasks = projectsApi.getTasks(projectId, hashMap);
			
			String taskId = getTasks.get(0).getTaskId();
		
			Task addTask = projectsApi.addTask(projectId, tasks);
		
			Task getTask = projectsApi.getTask(projectId, taskId);
			
			getTask.setBudgetHours(2);
		
			Task updateTask = projectsApi.updateTask(projectId, getTask);
		
			String deleteTask = projectsApi.deleteTask(projectId, taskId);
		
		
		
			UserList getUsers = projectsApi.getUsers(projectId);
			
			UserList assignUsers = projectsApi.assignUsers(projectId, usersList);
		
			User inviteUser = projectsApi.inviteUser(projectId, newUser);
			
			User getUser = projectsApi.getUser(projectId, userId);
			
			getUser.setIsCurrentUser(true);
		
			User updateUser = projectsApi.updateUser(projectId, getUser);
		
			String deleteUser = projectsApi.deleteUser(projectId, userId);
		
		
		
			TimeEntryList getTimeEntries = projectsApi.getTimeEntries(hashMap);
			
			String timeEntryId = getTimeEntries.get(0).getTimeEntryId();
			
			TimeEntry timeEntries = new TimeEntry();
			
			timeEntries.setProjectId(projectId);
			timeEntries.setTaskId(taskId);
			timeEntries.setUserId(userId);
			timeEntries.setLogDate("2014-02-21");
			timeEntries.setLogTime("4:35");
			timeEntries.setNotes("Task has been finished.");	//No I18N
			timeEntries.setStartTimer(false);
		
			TimeEntry logTimeEntries = projectsApi.logTimeEntry(timeEntries);
		
			TimeEntry getTimeEntry = projectsApi.getTimeEntry(timeEntryId);
			
			getTimeEntry.setNotes("Complete the task."); //No I18N
		
			TimeEntry updateTimeEntry = projectsApi.updateTimeEntry(getTimeEntry);
		
			TimeEntry startTimer = projectsApi.startTimer(timeEntryId);
		
			TimeEntry stopTimer = projectsApi.stopTimer();
			
			String deleteTimeEntry = projectsApi.deleteTimeEntry(timeEntryId);
			
			hashMap.put("time_entry_ids", timeEntryId);
		
			String deleteTimeEntries = projectsApi.deleteTimeEntries(hashMap);
		
		
		
			CommentList getComments = projectsApi.getComments(projectId);
			
			String commentId = getComments.get(0).getCommentId();
		
			Comment addComment = projectsApi.addComment(projectId, description);
		
			String deleteComment = projectsApi.deleteComment(projectId, commentId);
		
		
		
			InvoiceList getInvoices = projectsApi.getInvoices(projectId, hashMap);
			
			
			String delete = projectsApi.delete(projectId);
			
		
		
			//System.out.println(getInvoices);
			
		}
		catch(BooksException be)
		{
			
			throw be;
		}
		catch(Exception e)
		{
		
			throw e;
		}
	}
}
