package org.example.model.builder;

import org.example.model.Reservation;

import java.util.Date;

public class ReservationBuilder {

    private Reservation reservation;

    public ReservationBuilder() {
        reservation = new Reservation();
    }

    public ReservationBuilder setClientId(int clientId) {
        this.reservation.setClientId(clientId);
        return this;
    }

    public ReservationBuilder setRoomId(int roomId) {
        this.reservation.setRoomId(roomId);
        return this;
    }

    public ReservationBuilder setId(int id) {
        this.reservation.setId(id);
        return this;
    }

    public ReservationBuilder setStartDate(Date startDate) {
        this.reservation.setStartDate(startDate);
        return this;
    }

    public ReservationBuilder setEndDate(Date endDate) {
        this.reservation.setEndDate(endDate);
        return this;
    }



    public Reservation getReservation() {
        return this.reservation;
    }
}
