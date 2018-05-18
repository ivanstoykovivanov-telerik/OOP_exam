package models.base;

import java.util.Date;
import models.TicketPriority;

public class Task extends Item {
	private TicketPriority priority; 
	private String assignee ; 
	private Date plannedTime; 
	private Date dueDate;
	
	
	public Task(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime,
			String assignee) {
		super(title, description);
		this.priority = priority;
		this.assignee = assignee;
		this.plannedTime = plannedTime;
		this.dueDate = dueDate;
	}


	public TicketPriority getPriority() {
		return priority;
	}


	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}


	public String getAssignee() {
		return assignee;
	}


	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}


	public Date getPlannedTime() {
		return plannedTime;
	}


	public void setPlannedTime(Date plannedTime) {
		this.plannedTime = plannedTime;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
