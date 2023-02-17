package org.example.command.contractcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ContractService;


public class CommandReadContract extends Command {

    ContractService contractService = new ContractService(DatabaseService.getInstance());
    public CommandReadContract() {
        super(Constants.COMMAND_READ_CONTRACT);
    }

    @Override
    public void execute() {
        contractService.readContracts();
    }
}
