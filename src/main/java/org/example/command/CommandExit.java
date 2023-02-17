package org.example.command;

public class CommandExit extends Command {

    public CommandExit() {
        super(Constants.COMMAND_NAME_EXIT);
    }

    public void execute() {
        System.out.println("Bye bye!");
        System.exit(0);
    }
}