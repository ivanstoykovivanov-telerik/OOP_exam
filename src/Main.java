import java.text.ParseException;

import base.CommandParser;
import base.ProjectManagementSystem;

public class Main {

    public static void main(String[] args) {
        CommandParser parser = new CommandParserImpl();
        ProjectManagementSystem system = new ProjectManagementSystemImpl();
        Application app = new Application(parser, system);
        try {
			app.run();
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
    }
}
