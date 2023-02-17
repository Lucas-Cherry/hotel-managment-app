package org.example.command.clientcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ClientService;


public class CommandCreateClient extends Command {
    public CommandCreateClient() {
        super(Constants.COMMAND_CREATE_CLIENT);
    }

    @Override
    public void execute() {
        ClientService clientService = new ClientService(DatabaseService.getInstance());
        clientService.createClient();
    }
}
