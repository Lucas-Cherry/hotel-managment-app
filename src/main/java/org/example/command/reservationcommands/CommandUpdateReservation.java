package org.example.command.reservationcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ReservationService;


public class CommandUpdateReservation extends Command {
    ReservationService reservationService = new ReservationService(DatabaseService.getInstance());
    public CommandUpdateReservation() {
        super(Constants.COMMAND_UPDATE_RESERVATION);
    }

    @Override
    public void execute() {
        reservationService.updateReservation();
    }
}
