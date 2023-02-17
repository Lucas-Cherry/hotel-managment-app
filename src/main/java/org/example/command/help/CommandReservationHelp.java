package org.example.command.help;

import org.example.command.Command;
import org.example.command.Constants;

import java.util.List;

public class CommandReservationHelp extends Command {
    private List<Command> reservationCommandList;
    public CommandReservationHelp(List<Command> commandList) {
        super(Constants.COMMAND_RESERVATION_HELP);
        this.reservationCommandList = commandList;
    }

    public void execute() {
        for(Command command : reservationCommandList) {
            if(command.getName().contains("reservation")) System.out.println(command.getName());;
        }
    }
}
