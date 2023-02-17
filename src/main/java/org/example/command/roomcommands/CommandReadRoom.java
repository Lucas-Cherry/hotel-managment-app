package org.example.command.roomcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.RoomService;


public class CommandReadRoom extends Command {
    RoomService roomService = new RoomService(DatabaseService.getInstance());
    public CommandReadRoom() {
        super(Constants.COMMAND_READ_ROOM);
    }

    @Override
    public void execute() {
        roomService.readRoom();
    }
}
