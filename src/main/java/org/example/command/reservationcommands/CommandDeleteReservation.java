package org.example.command.reservationcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ReservationService;


public class CommandDeleteReservation extends Command {

    ReservationService reservationService = new ReservationService(DatabaseService.getInstance());
    public CommandDeleteReservation() {
        super(Constants.COMMAND_DELETE_RESERVATION);
    }

    @Override
    public void execute() {
        reservationService.deleteReservation();
    }
}
