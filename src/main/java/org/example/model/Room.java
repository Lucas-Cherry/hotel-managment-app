package org.example.model;


import org.example.database.DatabaseService;

import java.sql.SQLException;

public class Room {

    private int id;
    private int roomNumber;
    private int floor;
    private boolean privateRestroom;
    private int hotelId;
    private int categoryId;

    public int getHotelId() {
        return this.hotelId;
    }
    public int getCategoryId() {
        return this.categoryId;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isPrivateRestroom() {
        return privateRestroom;
    }

    public void setPrivateRestroom(boolean privateRestroom) {
        this.privateRestroom = privateRestroom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void displayInfo() {
        String sql = "SELECT rooms.id, rooms.room_number, hotels.name, rooms.floor FROM rooms INNER JOIN hotels ON hotels.id = rooms.hotel_id WHERE rooms.id = "+id+" ORDER BY rooms.id;";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                if(resultSet.next()) {
                    System.out.println(resultSet.getInt("id")+": Room number "+resultSet.getInt("room_number")+" in " + resultSet.getString("name")+" is on floor "+ resultSet.getInt("floor"));
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
