package org.example.command.reservationcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ReservationService;

public class CommandReservationGetAll extends Command {
    ReservationService reservationService = new ReservationService(DatabaseService.getInstance());

    public CommandReservationGetAll() {
        super(Constants.COMMAND_GET_ALL_RESERVATIONS);
    }

    @Override
    public void execute() {
        reservationService.getAllReservations();
    }
}
