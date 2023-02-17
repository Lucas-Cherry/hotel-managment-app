package org.example.command;


import java.util.List;

public class CommandHelp extends Command{
    private List<Command> commandList;
    public CommandHelp(List<Command> commandList) {
        super(Constants.COMMAND_NAME_HELP);
        this.commandList = commandList;
    }

    public void execute() {
        for(Command command : commandList) {
            System.out.println(command.getName());
        }
    }
}
