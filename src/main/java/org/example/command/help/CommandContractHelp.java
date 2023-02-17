package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandContractHelp extends Command{
    private List<Command> clientContractList;
    public CommandContractHelp(List<Command> commandList) {
        super(Constants.COMMAND_CONTRACT_HELP);
        this.clientContractList = commandList;
    }

    public void execute() {
        for(Command command : clientContractList) {
            if(command.getName().contains("contract")) System.out.println(command.getName());;
        }
    }
}
