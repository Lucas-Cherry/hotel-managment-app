package org.example.command.contractcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ContractService;


public class CommandUpdateContract extends Command {

    ContractService contractService = new ContractService(DatabaseService.getInstance());
    public CommandUpdateContract() {
        super(Constants.COMMAND_UPDATE_CONTRACT);
    }

    @Override
    public void execute() {
        contractService.updateContract();
    }
}
