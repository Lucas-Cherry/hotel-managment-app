package org.example.command.positioncommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.PositionService;


public class CommandReadPosition extends Command {

    PositionService positionService = new PositionService(DatabaseService.getInstance());
    public CommandReadPosition() {
        super(Constants.COMMAND_READ_POSITION);
    }

    @Override
    public void execute() {
        positionService.readPositions();
    }
}
