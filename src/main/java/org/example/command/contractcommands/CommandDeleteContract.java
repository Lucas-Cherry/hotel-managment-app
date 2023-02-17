package org.example.command.contractcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ContractService;


public class CommandDeleteContract extends Command {

    ContractService contractService = new ContractService(DatabaseService.getInstance());
    public CommandDeleteContract() {
        super(Constants.COMMAND_DELETE_CONTRACT);
    }

    @Override
    public void execute() {
        contractService.deleteContract();
    }
}
