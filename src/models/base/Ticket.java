package models.base;

import java.util.Date;

import models.TicketPriority;

public class Ticket extends Item  implements IValidateOwnerOrSender{
	
	private String sender; 
	private String owner; 
	private Date dueDate; 
	private TicketPriority priority;


	public Ticket(String title, String description, Date dueDate, TicketPriority priority, String sender,
			String owner) {
		super(title, description);
		this.sender = sender;
		this.owner = owner;
		this.dueDate = dueDate;
		this.priority = priority;
	}


	@Override
	public boolean validateOwnerOrSender(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
