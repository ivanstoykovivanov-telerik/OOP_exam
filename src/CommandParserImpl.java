import base.CommandParser;
import commands.Command;
import commands.CommandType;

import java.util.Arrays;

public class CommandParserImpl implements CommandParser {
    private static final String ADD_TODO_COMMAND_NAME = "ADD-TODO";

    @Override
    public Command parseCommand(String commandString) {
        String[] commandParts = commandString.split(" ");

        CommandType commandType = getCommandTypeByName(commandParts[0]);
        String[] args = Arrays.copyOfRange(commandParts, 1, commandParts.length);
        return new Command(commandType, args);
    }

    private CommandType getCommandTypeByName(String commandName) {
        if (commandName.equals(ADD_TODO_COMMAND_NAME)) {
            return CommandType.ADD_TASK;
        }

        //TODO: You code here
        return null;
    }
}
