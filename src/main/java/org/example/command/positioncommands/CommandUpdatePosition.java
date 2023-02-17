package org.example.command.positioncommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.PositionService;


public class CommandUpdatePosition extends Command {

    PositionService positionService = new PositionService(DatabaseService.getInstance());
    public CommandUpdatePosition() {
        super(Constants.COMMAND_UPDATE_POSITION);
    }

    @Override
    public void execute() {
        positionService.updatePosition();
    }
}
