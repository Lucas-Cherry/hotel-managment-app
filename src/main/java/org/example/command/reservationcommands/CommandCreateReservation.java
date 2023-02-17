package org.example.command.reservationcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ReservationService;


public class CommandCreateReservation extends Command {

    ReservationService reservationService = new ReservationService(DatabaseService.getInstance());
    public CommandCreateReservation() {
        super(Constants.COMMAND_CREATE_RESERVATION);
    }

    @Override
    public void execute() {
        reservationService.createReservation();
    }
}
