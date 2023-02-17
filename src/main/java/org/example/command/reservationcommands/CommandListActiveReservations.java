package org.example.command.reservationcommands;

import org.example.command.Command;
import org.example.command.Constants;
import org.example.database.DatabaseService;
import org.example.service.ReservationService;

public class CommandListActiveReservations extends Command {
    ReservationService reservationService = new ReservationService(DatabaseService.getInstance());

    public CommandListActiveReservations() {
        super(Constants.COMMAND_LIST_ACTIVE_RESERVATIONS);
    }

    @Override
    public void execute() {
        reservationService.listActiveReservations();
    }
}
