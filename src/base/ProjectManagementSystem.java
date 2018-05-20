package base;

import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import models.base.Task;
import models.base.Todo;

import java.util.Date;
import java.util.List;

public interface ProjectManagementSystem {

    void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner);

    void addTodo(String title, String description, TodoState state);

    void addTask(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee);

    List<Item> listAll();

    List<Item> listTickets();

    List<Item> listTodos();

    List<Item> listTodos(TodoState state);

    List<Item> listTasks();

    List<Item> searchByTitleOrDescription(String pattern);

	void changeTodoState(String todoTitle);
}
