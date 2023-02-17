package org.example.command.reservationcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ReservationService;


public class CommandReadReservation extends Command {

    ReservationService reservationService = new ReservationService(DatabaseService.getInstance());
    public CommandReadReservation() {
        super(Constants.COMMAND_READ_RESERVATION);
    }

    @Override
    public void execute() {
        reservationService.readReservation();
    }
}
