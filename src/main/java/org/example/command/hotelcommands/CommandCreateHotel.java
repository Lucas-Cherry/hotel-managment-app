package org.example.command.hotelcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.HotelService;


public class CommandCreateHotel extends Command {

    HotelService hotelService = new HotelService(DatabaseService.getInstance());
    public CommandCreateHotel() {
        super(Constants.COMMAND_CREATE_HOTEL);
    }

    @Override
    public void execute() {
        hotelService.createHotel();
    }
}
