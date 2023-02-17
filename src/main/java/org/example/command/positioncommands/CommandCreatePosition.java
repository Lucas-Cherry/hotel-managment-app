package org.example.command.positioncommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.PositionService;


public class CommandCreatePosition extends Command {

    PositionService positionService = new PositionService(DatabaseService.getInstance());
    public CommandCreatePosition() {
        super(Constants.COMMAND_CREATE_POSITION);
    }

    @Override
    public void execute() {
        positionService.createPosition();
    }
}
