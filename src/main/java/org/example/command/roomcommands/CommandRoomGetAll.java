package org.example.command.roomcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.RoomService;

public class CommandRoomGetAll extends Command {
    RoomService roomService = new RoomService(DatabaseService.getInstance());

    public CommandRoomGetAll() {
        super(Constants.COMMAND_GET_ALL_ROOMS);
    }

    @Override
    public void execute() {
        roomService.getAllRooms();
    }
}
