package org.example.command.hotelcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.HotelService;


public class CommandReadHotel extends Command {
    HotelService hotelService = new HotelService(DatabaseService.getInstance());
    public CommandReadHotel() {
        super(Constants.COMMAND_READ_HOTEL);
    }

    @Override
    public void execute() {
        hotelService.readHotel();
    }
}
