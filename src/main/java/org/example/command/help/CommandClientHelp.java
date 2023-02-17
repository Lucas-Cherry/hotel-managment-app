package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandClientHelp extends Command {
    private List<Command> clientCommandList;
    public CommandClientHelp(List<Command> commandList) {
        super(Constants.COMMAND_CLIENT_HELP);
        this.clientCommandList = commandList;
    }

    public void execute() {
        for(Command command : clientCommandList) {
            if(command.getName().contains("client")) System.out.println(command.getName());;
        }
    }
}