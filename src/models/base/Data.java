package models.base;

import java.util.ArrayList;
import java.util.List;

public class Data implements IData {
	private List<Item> todos ; 
	private List<Item> tickets ;
	private List<Item> tasks ;
	
	
	public Data() {
		super();
		this.todos = new ArrayList<>();
		this.tickets = new ArrayList<>();
		this.tasks = new ArrayList<>();
	}
	
	
	
	
	
	
	public List<Item> getTodos() {
		return todos;
	}

	public List<Item> getTickets() {
		return tickets;
	}

	public List<Item> getTasks() {
		return tasks;
	}
	
	
	
	
	
	
	
	
	
}
