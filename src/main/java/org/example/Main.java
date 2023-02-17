package org.example;
import org.example.command.*;
import org.example.command.categorycommands.*;
import org.example.command.clientcommands.*;
import org.example.command.contractcommands.*;
import org.example.command.help.*;
import org.example.command.hotelcommands.*;
import org.example.command.positioncommands.*;
import org.example.command.reservationcommands.*;
import org.example.command.roomcommands.*;
import org.example.command.workercommands.*;

import java.util.*;


import static org.example.service.misc.ReadInput.inputStr;


public class Main {



    public static void main(String[] args) {



            CommandService commandService = new CommandService(); // add commands to use

            commandService.registerCommand(new CommandHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandHotelHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandClientHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandContractHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandCategoryHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandRoomHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandPositionHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandReservationHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandWorkerHelp(commandService.getCommandList()));
            commandService.registerCommand(new CommandExit());

            commandService.registerCommand(new CommandCalculateExpenses());
            commandService.registerCommand(new CommandPrintNumberOfRoomsInHotel());

            commandService.registerCommand(new CommandCreateHotel());
            commandService.registerCommand(new CommandReadHotel());
            commandService.registerCommand(new CommandHotelGetAll());
            commandService.registerCommand(new CommandUpdateHotel());
            commandService.registerCommand(new CommandDeleteHotel());

            commandService.registerCommand(new CommandCreateClient());
            commandService.registerCommand(new CommandReadClient());
            commandService.registerCommand(new CommandClientGetAll());
            commandService.registerCommand(new CommandUpdateClient());
            commandService.registerCommand(new CommandDeleteClient());

            commandService.registerCommand(new CommandCreateCategory());
            commandService.registerCommand(new CommandReadCategory());
            commandService.registerCommand(new CommandCategoryGetAll());
            commandService.registerCommand(new CommandUpdateCategory());
            commandService.registerCommand(new CommandDeleteCategory());

            commandService.registerCommand(new CommandCreateRoom());
            commandService.registerCommand(new CommandReadRoom());
            commandService.registerCommand(new CommandRoomGetAll());
            commandService.registerCommand(new CommandUpdateRoom());
            commandService.registerCommand(new CommandDeleteRoom());

            commandService.registerCommand(new CommandListActiveReservations());
            commandService.registerCommand(new CommandCreateReservation());
            commandService.registerCommand(new CommandReadReservation());
            commandService.registerCommand(new CommandReservationGetAll());
            commandService.registerCommand(new CommandUpdateReservation());
            commandService.registerCommand(new CommandDeleteReservation());

            commandService.registerCommand(new CommandCreatePosition());
            commandService.registerCommand(new CommandReadPosition());
            commandService.registerCommand(new CommandPositionGetAll());
            commandService.registerCommand(new CommandUpdatePosition());
            commandService.registerCommand(new CommandDeletePosition());

            commandService.registerCommand(new CommandCreateWorker());
            commandService.registerCommand(new CommandReadWorker());
            commandService.registerCommand(new CommandWorkerGetAll());
            commandService.registerCommand(new CommandUpdateWorker());
            commandService.registerCommand(new CommandDeleteWorker());

            commandService.registerCommand(new CommandCreateContract());
            commandService.registerCommand(new CommandReadContract());
            commandService.registerCommand(new CommandContractGetAll());
            commandService.registerCommand(new CommandUpdateContract());
            commandService.registerCommand(new CommandDeleteContract());


            System.out.println("Welcome to your very own hotel chain management app");

            while (true) {

                System.out.println("Enter command or type help to see list of commands");



                String input = inputStr();

                Optional<Command> optionalCommand = commandService.findCommandByName((input));

                if (optionalCommand.isPresent()) {
                    optionalCommand.get().execute();
                } else {
                    System.out.println("Command doesn't exist\n");
                }
            }
    }
}