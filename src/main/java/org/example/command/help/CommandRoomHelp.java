package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandRoomHelp extends Command{
        private List<Command> roomCommandList;
        public CommandRoomHelp(List<Command> commandList) {
            super(Constants.COMMAND_ROOM_HELP);
            this.roomCommandList = commandList;
        }

        public void execute() {
            for(Command command : roomCommandList) {
                if(command.getName().contains("room") && !(command.getName().contains("category") || command.getName().contains("categories"))) System.out.println(command.getName());;
            }
        }
}
