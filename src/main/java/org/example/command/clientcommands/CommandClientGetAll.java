package org.example.command.clientcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ClientService;

public class CommandClientGetAll extends Command {
    public CommandClientGetAll() {
        super(Constants.COMMAND_GET_ALL_CLIENTS);
    }

    @Override
    public void execute() {
        ClientService clientService = new ClientService(DatabaseService.getInstance());
        clientService.getAll();
    }
}
