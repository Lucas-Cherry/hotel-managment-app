package org.example.command.roomcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.RoomService;


public class CommandUpdateRoom extends Command {
    RoomService roomService = new RoomService(DatabaseService.getInstance());
    public CommandUpdateRoom() {
        super(Constants.COMMAND_UPDATE_ROOM);
    }

    @Override
    public void execute() {
        roomService.updateRoom();
    }
}
