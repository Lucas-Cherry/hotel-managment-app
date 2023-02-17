package org.example.command.roomcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.RoomService;


public class CommandDeleteRoom extends Command {
    RoomService roomService = new RoomService(DatabaseService.getInstance());
    public CommandDeleteRoom() {
        super(Constants.COMMAND_DELETE_ROOM);
    }

    @Override
    public void execute() {
        roomService.deleteRoom();
    }
}
