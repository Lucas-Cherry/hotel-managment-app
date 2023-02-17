package org.example.command.contractcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ContractService;

public class CommandContractGetAll extends Command {
    ContractService contractService = new ContractService(DatabaseService.getInstance());

    public CommandContractGetAll() {
        super(Constants.COMMAND_GET_ALL_CONTRACTS);
    }

    @Override
    public void execute() {
        contractService.getAllContracts();
    }
}
