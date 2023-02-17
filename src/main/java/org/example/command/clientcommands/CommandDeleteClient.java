package org.example.command.clientcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ClientService;


public class CommandDeleteClient extends Command {
    public CommandDeleteClient() {
        super(Constants.COMMAND_DELETE_CLIENT);
    }

    @Override
    public void execute() {
        ClientService clientService = new ClientService(DatabaseService.getInstance());
        clientService.deleteClient();
    }
}
