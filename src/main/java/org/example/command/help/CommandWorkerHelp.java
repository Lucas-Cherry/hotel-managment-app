package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandWorkerHelp extends Command {
    private List<Command> workerCommandList;
    public CommandWorkerHelp(List<Command> commandList) {
        super(Constants.COMMAND_WORKER_HELP);
        this.workerCommandList = commandList;
    }

    public void execute() {
        for(Command command : workerCommandList) {
            if(command.getName().contains("worker")) System.out.println(command.getName());;
        }
    }
}
