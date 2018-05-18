import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import base.ProjectManagementSystem;
import models.TicketPriority;
import models.TodoState;
import models.base.IValidateItem;
import models.base.Item;
import models.base.Task;
import models.base.Ticket;
import models.base.Todo;

public class ProjectManagementSystemImpl implements ProjectManagementSystem, IValidateItem {
	private List<Item> todos ; 
	private List<Item> tickets ;
	private List<Item> tasks ;
	//private List<Item> all;  // ??? 
	
	@Override
	public void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender,
			String owner) {
		//
		Item ticket = new Ticket(title, description, dueDate, priority, sender, owner); 
		tickets.add(ticket); 
		
	}

	@Override
	public void addTodo(String title, String description, TodoState state) {
		Item todo = new Todo(title, description, state); 
		todos.add(todo); 
	}

	@Override
	public void addTask(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime,
			String assignee) {
		Item task = new Task(title, description, dueDate, priority, plannedTime, assignee); 
		tasks.add(task); 
	}

	@Override
	public List<Item> listAll() {
		List<Item> all = new ArrayList<>();  
		for (Item todo : getTodos()) {
			all.add(todo); 
		}
		for (Item ticket : getTickets()) {
			all.add(ticket); 
		}
		for (Item task : getTasks()) {
			all.add(task); 
		}
		
		return all;
	}

	@Override
	public List<Item> listTickets() {
		return getTickets(); 	
	}

	@Override
	public List<Item> listTodos() {
		return getTodos(); 
	}

	@Override
	public List<Item> listTodos(TodoState state) {
		List<Item> todosByState = new ArrayList<>();
		List<Item> allTodos = getTodos();
		for (Item item : allTodos) {
			Todo todo = (Todo) item ; 
			if(todo.getState() == state) {
				todosByState.add(todo); 
			}
		}
		return todosByState; 
	}

	@Override
	public List<Item> listTasks() {
		return getTasks(); 
	}

	@Override
	public List<Item> searchByTitleOrDescription(String pattern) {
		List<Item> all = listAll();  
		List<Item> found = new ArrayList<>();  
		
		for (Item item : all) {
			// TODO validate title and description 
			if(	Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE).matcher(item.getTitle()).find() || 
				Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE).matcher(item.getDescription()).find()) {
			}
		}
		return found;
	}

	@Override
	public void changeTodoState(Todo todo) {
		// TODO Auto-generated method stubs
		
		//if(todo.getState() == )
		
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

	@Override
	public boolean validateTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateDescription(String description) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
