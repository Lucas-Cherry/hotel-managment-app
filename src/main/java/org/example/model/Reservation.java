package org.example.model;


import org.example.database.DatabaseService;

import java.sql.SQLException;
import java.util.Date;

public class Reservation {

    private int id;

    private int clientId;
    private int roomId;

    private Date startDate;

    private Date endDate;

    public int getRoomId() {
        return this.roomId;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void displayInfo() {
        String sql = "SELECT reservations.id, clients.first_name, rooms.room_number, reservations.start_date, reservations.end_date FROM reservations INNER JOIN clients ON clients.id = reservations.client_id INNER JOIN rooms ON rooms.id = reservations.room_id WHERE reservations.id = "+id+";";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                if(resultSet.next()) {
                    System.out.println(resultSet.getInt("id")+": "+resultSet.getString("first_name")+" is reserving room number " + resultSet.getInt("room_number")+" from "+ resultSet.getDate("start_date") + " till " + resultSet.getDate("end_date"));
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
