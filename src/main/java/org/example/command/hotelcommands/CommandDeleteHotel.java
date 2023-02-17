package org.example.command.hotelcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.HotelService;


public class CommandDeleteHotel extends Command {
    HotelService hotelService = new HotelService(DatabaseService.getInstance());
    public CommandDeleteHotel() {
        super(Constants.COMMAND_DELETE_HOTEL);
    }

    @Override
    public void execute() {
        hotelService.deleteHotel();
    }
}
