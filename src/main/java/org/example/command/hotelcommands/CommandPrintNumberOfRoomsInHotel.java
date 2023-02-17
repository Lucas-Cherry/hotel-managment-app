package org.example.command.hotelcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.HotelService;


public class CommandPrintNumberOfRoomsInHotel extends Command {
    HotelService hotelService = new HotelService(DatabaseService.getInstance());
    public CommandPrintNumberOfRoomsInHotel() {
        super(Constants.COMMAND_PRINT_NUMBER_OF_ROOMS_IN_HOTEL);
    }

    @Override
    public void execute() {
        hotelService.printNumberOfRoomsInHotel();
    }
}
