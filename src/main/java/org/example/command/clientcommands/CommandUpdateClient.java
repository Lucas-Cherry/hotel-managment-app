package org.example.command.clientcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ClientService;


public class CommandUpdateClient extends Command {
    public CommandUpdateClient() {
        super(Constants.COMMAND_UPDATE_CLIENT);
    }

    @Override
    public void execute() {
        ClientService clientService = new ClientService(DatabaseService.getInstance());
        clientService.updateClient();
    }
}
