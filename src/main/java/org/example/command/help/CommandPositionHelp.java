package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandPositionHelp extends Command {
    private List<Command> positionCommandList;
    public CommandPositionHelp(List<Command> commandList) {
        super(Constants.COMMAND_POSITION_HELP);
        this.positionCommandList = commandList;
    }

    public void execute() {
        for(Command command : positionCommandList) {
            if(command.getName().contains("position")) System.out.println(command.getName());;
        }
    }
}
