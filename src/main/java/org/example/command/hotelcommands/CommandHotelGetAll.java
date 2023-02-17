package org.example.command.hotelcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.HotelService;

public class CommandHotelGetAll extends Command {
    HotelService hotelService = new HotelService(DatabaseService.getInstance());

    public CommandHotelGetAll() {
        super(Constants.COMMAND_GET_ALL_HOTELS);
    }

    @Override
    public void execute() {
        hotelService.getAllHotels();
    }
}
