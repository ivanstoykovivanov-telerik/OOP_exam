import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import base.ProjectManagementSystem;
import models.TicketPriority;
import models.TodoState;
import models.base.Data;
import models.base.IData;
import models.base.Item;
import models.base.Task;
import models.base.Ticket;
import models.base.Todo;

public class ProjectManagementSystemImpl implements ProjectManagementSystem {
	private List<Item> todos ; 
	private List<Item> tickets ;
	private List<Item> tasks ;
	private IData data; 
	
	public ProjectManagementSystemImpl() {
		super();
		this.todos = new ArrayList<>();
		this.tickets = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.data = new Data();
	}

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
		List<Item> tickets = new ArrayList<>(); 
		tickets = getTickets(); 
		Collections.sort(tickets);		
		return tickets; 	
	}

	@Override
	public List<Item> listTodos() {
		List<Item> todos = new ArrayList<>(); 
		todos = getTodos(); 
		//Sorting: 
		Collections.sort(todos);		
		return todos; 	
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
		List<Item> tasks = new ArrayList<>(); 
		tasks = getTasks(); 
		//Sorting: 
		Collections.sort(tasks);		
		return tasks; 
	}

	@Override
	public List<Item> searchByTitleOrDescription(String pattern) {
		List<Item> all = listAll();  
		List<Item> found = new ArrayList<>();  
		
		for (Item item : all) {
			if(	Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE).matcher(item.getTitle()).find() || 
						Pattern.compile(Pattern.quote(pattern), Pattern.CASE_INSENSITIVE).matcher(item.getDescription()).find()){
				found.add(item); 
			}
		}
		return found;
	}

	@Override
	public void changeTodoState(String todoTitle) {
		Todo searchedTodo = new Todo("", "", TodoState.NOT_DONE); 
		for (Item item : todos) {
			Todo todo = (Todo) item ; 
			if(todo.getTitle().equals(todoTitle)) {
				searchedTodo = todo ; 
			}
		}
		searchedTodo.setState(TodoState.DONE);
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
