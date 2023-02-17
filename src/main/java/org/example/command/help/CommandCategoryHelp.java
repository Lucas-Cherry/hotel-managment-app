package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandCategoryHelp extends Command {
    private List<Command> categoryCommandList;
    public CommandCategoryHelp(List<Command> commandList) {
        super(Constants.COMMAND_CATEGORY_HELP);
        this.categoryCommandList = commandList;
    }

    public void execute() {
        for(Command command : categoryCommandList) {
            if(command.getName().contains("category") || command.getName().contains("categories")) System.out.println(command.getName());;
        }
    }
}
