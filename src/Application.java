import base.CommandParser;
import base.ProjectManagementSystem;
import commands.Command;
import commands.CommandType;
import models.TicketPriority;
import models.TodoState;
import models.base.IValidateItem;
import models.base.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application  implements IValidateItem{
    private static final String EXIT_STATE = "EXIT";
    private final CommandParser commandParser;
    ProjectManagementSystem system;

    public Application(CommandParser commandParser, ProjectManagementSystem system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() throws ParseException {
        Scanner in = new Scanner(System.in);
        while (true) {
            String commandString = in.nextLine();
            Command command = this.commandParser.parseCommand(commandString);
            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }
            
            switch (command.getCommandType()) {
                case ADD_TODO:
                    String title = command.getParams()[0];
                    String description = command.getParams()[1];
                    TodoState state = TodoState.fromName(command.getParams()[2]);
                    system.addTodo(title, description, state);
                    break;
                case ADD_TASK:
        			String title1 = command.getParams()[0];
                	String description2 = command.getParams()[1];
                	//fix date
                	String dueDateString =  command.getParams()[2];
                	Date dueDate = convertDate(dueDateString); 
                	TicketPriority priority = TicketPriority.fromName(command.getParams()[2]);
                	//fix date
                	String plannedTimeString = command.getParams()[4];
                	Date plannedTime  = convertDate(plannedTimeString); 
                	String assignee = command.getParams()[5];
                	system.addTask(title1, description2, dueDate, priority, plannedTime, assignee);
                    break;
                case ADD_TICKET:
        			String title3 = command.getParams()[0];
                	String description3 = command.getParams()[1];
                	//fix date 
                	String dueDateString2 =  command.getParams()[2];
                	Date dueDate2 = convertDate(dueDateString2); 
                	TicketPriority priority2 = TicketPriority.fromName(command.getParams()[3]);
                	String sender = command.getParams()[4];
                	String owner = command.getParams()[5];
        			system.addTicket(title3, description3, dueDate2, priority2, sender, owner);
                    break;
                case LIST_ALL:
                    system.listAll(); 
                    break;
                case LIST_TASKS:
                	system.listTasks(); 
                	break;
                case LIST_TODOS:
                	system.listTodos(); 
                	break;
                case UPDATE_TODO:
                	String title4 = command.getParams()[0];
                    system.changeTodoState(title4);  
                    break;
                case LIST_TICKETS:
                    system.listTickets(); 
                    break;
                case LIST_TODOS_NOT_DONE:
                    system.listTodos(TodoState.NOT_DONE); 
                    break;
            }
        }
    }
    
    private Date convertDate(String userInput) throws ParseException{
    	String expectedPattern = "MM/dd/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
        Date date = formatter.parse(userInput);
        return date; 
     }
    
    @Override
	public boolean validateTitle(String title) {
		if(title.length() >= 5 && title.length() <= 20 ) {
			return true; 
		}
		return false;
	}

	@Override
	public boolean validateDescription(String description) {
		if(description.length() >= 5 && description.length() <= 40 ) {
			return true; 
		}
		return false;
	}
	
	public boolean validateIfDateInTheFuture(Date date) {
		
		return false;
	}
	
}
