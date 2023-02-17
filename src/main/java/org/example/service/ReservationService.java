package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Reservation;
import org.example.model.builder.ReservationBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.inputNum;
import static org.example.service.misc.ReadInput.inputStr;

public class ReservationService {

    private final DatabaseService databaseService;

    public ReservationService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
    public void createReservation() {
        try{
            System.out.println("Set ID");
            int id = inputNum();
            System.out.println("Set client id");
            int clientId = inputNum();
            System.out.println("Set room id");
            int roomId = inputNum();
            System.out.println("Set start date");
            String startDate = inputStr();
            System.out.println("Set end date");
            String endDate = inputStr();
        String sql = String.format("INSERT INTO `reservations`(`id`, `client_id`, `room_id`, `start_date`, `end_date`) VALUES ('%d','%d','%d','%s','%s')",id,clientId,roomId,startDate,endDate);
        this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void deleteReservation() {
        System.out.println("Input reservation id");
        try {
            int id = inputNum();
            String sql = String.format("DELETE FROM reservations WHERE id = '%d'",id);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void readReservation() {
        System.out.println("Input reservation id");
        int inputId = inputNum();
        String sql = String.format("SELECT * FROM reservations WHERE id = '%d';",inputId);
        this.databaseService.performSQL(sql, resultSet -> {
            try{
                Reservation reservation = new Reservation();
                if (resultSet.next()) {
                    reservation = (new ReservationBuilder()
                            .setId(resultSet.getInt("id"))
                            .setClientId(resultSet.getInt("client_id"))
                            .setRoomId(resultSet.getInt("room_id"))
                            .setStartDate(resultSet.getDate("start_date"))
                            .setEndDate(resultSet.getDate("end_date"))
                            .getReservation());
                }
                reservation.displayInfo();
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void getAllReservations() {
        String sql = String.format("SELECT * FROM reservations");
        this.databaseService.performSQL(sql, resultSet -> {
            try{
                List<Reservation> reservationList = new ArrayList<>();
                while(resultSet.next()) {
                    reservationList.add(new ReservationBuilder()
                            .setId(resultSet.getInt("id"))
                            .setClientId(resultSet.getInt("client_id"))
                            .setRoomId(resultSet.getInt("room_id"))
                            .setStartDate(resultSet.getDate("start_date"))
                            .setEndDate(resultSet.getDate("end_date"))
                            .getReservation());
                }
                for (Reservation reservation : reservationList) {
                    reservation.displayInfo();
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
    public void updateReservation() {
        System.out.println("Input the id of the reservation you want to update");
        try {
            int inputId = inputNum();
            System.out.println("Client id");
            int clientId = inputNum();
            System.out.println("Room id");
            int roomId = inputNum();
            System.out.println("Start date");
            String startDate = inputStr();
            System.out.println("End date");
            String endDate = inputStr();
            String sql = String.format("UPDATE `reservations` SET `client_id`='%d',`room_id`='%d',`start_date`='%s',`end_date`='%s' WHERE id = %d",clientId,roomId,startDate,endDate,inputId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }

    public void listActiveReservations() {
        String sql = "SELECT reservations.id FROM reservations WHERE reservations.start_date = CURRENT_DATE OR (reservations.start_date < CURRENT_DATE AND reservations.end_date > CURRENT_DATE);";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                while(resultSet.next()) {
                    System.out.println("Reservation number " + resultSet.getInt("reservations.id")+ " is currently active");
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
