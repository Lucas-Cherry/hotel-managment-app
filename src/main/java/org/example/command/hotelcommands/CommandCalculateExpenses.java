package org.example.command.hotelcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.HotelService;

public class CommandCalculateExpenses extends Command {
    HotelService hotelService = new HotelService(DatabaseService.getInstance());

    public CommandCalculateExpenses() {
        super(Constants.COMMAND_CALCULATE_EXPENSES);
    }

    @Override
    public void execute() {
        hotelService.calculateHotelExpenses();
    }
}
