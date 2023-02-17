package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandHotelHelp extends Command {
    private List<Command> HotelCommandList;
    public CommandHotelHelp(List<Command> commandList) {
        super(Constants.COMMAND_HOTEL_HELP);
        this.HotelCommandList = commandList;
    }

    public void execute() {
        for(Command command : HotelCommandList) {
            if(command.getName().contains("hotel")) System.out.println(command.getName());;
        }
    }
}
