package org.example.command.contractcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ContractService;


public class CommandCreateContract extends Command {

    ContractService contractService = new ContractService(DatabaseService.getInstance());
    public CommandCreateContract() {
        super(Constants.COMMAND_CREATE_CONTRACT);
    }

    @Override
    public void execute() {
        contractService.createContract();
    }
}
