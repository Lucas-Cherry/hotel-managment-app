package org.example.command.positioncommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.PositionService;

public class CommandDeletePosition extends Command {

    PositionService positionService = new PositionService(DatabaseService.getInstance());
    public CommandDeletePosition() {
        super(Constants.COMMAND_DELETE_POSITION);
    }

    @Override
    public void execute() {
        positionService.deletePosition();
    }
}
