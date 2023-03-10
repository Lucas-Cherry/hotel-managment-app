package org.example.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandService {
    private final List<Command> commandList;
    public CommandService() {
        this.commandList = new ArrayList<>();
    }

    public void registerCommand(Command command) {
        this.commandList.add(command);
    }

    public Optional<Command> findCommandByName(String name) {
        return this.commandList.stream().filter( command -> command.getName().equals(name)).findFirst();
    }

    public List<Command> getCommandList() {
        return commandList;
    }

}
