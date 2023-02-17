package org.example.command.positioncommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.PositionService;


public class CommandPositionGetAll extends Command {
    PositionService positionService = new PositionService(DatabaseService.getInstance());

    public CommandPositionGetAll() {
        super(Constants.COMMAND_GET_ALL_POSITIONS);
    }

    @Override
    public void execute() {
        positionService.getAllPositions();
    }
}
