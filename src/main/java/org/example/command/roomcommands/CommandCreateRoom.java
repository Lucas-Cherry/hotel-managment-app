package org.example.command.roomcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.RoomService;


public class CommandCreateRoom extends Command {

    RoomService roomService = new RoomService(DatabaseService.getInstance());
    public CommandCreateRoom() {
        super(Constants.COMMAND_CREATE_ROOM);
    }

    @Override
    public void execute() {
        roomService.createRoom();
    }
}
