package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Room;
import org.example.model.builder.RoomBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.*;

public class RoomService {

    private final DatabaseService databaseService;

    public RoomService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
    public  void createRoom() {
        try {
            System.out.println("Set ID");
            int id = inputNum();
        System.out.println("Input room number");
        int roomNumber = inputNum();
        System.out.println("Input room floor");
        int floor = inputNum();
        System.out.println("Does the room have a private restroom(y/n)");
        int hasPrivateRestroom = inputTinyInt();
        System.out.println("Input room category id");
        int categoryId = inputNum();
        System.out.println("Input hotel id");
        int hotelId = inputNum();
            String sql = String.format("INSERT INTO `rooms`(`id`, `room_number`, `floor`, `private_restroom`, `hotel_id`, `category_id`) VALUES ('%d','%d','%d','%d','%d','%d')",id,roomNumber,floor,hasPrivateRestroom,hotelId,categoryId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void deleteRoom() {
        System.out.println("Input room id");
        try {
            int roomId = inputNum();
            String sql = String.format("DELETE FROM rooms WHERE id = '%d'",roomId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void readRoom() {
        System.out.println("Input room id");
        int inputId = inputNum();
        String sql = String.format("SELECT * FROM rooms WHERE id = '%d';",inputId);
        this.databaseService.performSQL(sql, resultSet -> {
            try{
                Room room = new Room();
                if (resultSet.next()) {
                    room = (new RoomBuilder()
                            .setId(resultSet.getInt("id"))
                            .setRoomNumber(resultSet.getInt("room_number"))
                            .setFloor(resultSet.getInt("floor"))
                            .setPrivateRestroom(resultSet.getBoolean("private_restroom"))
                            .setHotelId(resultSet.getInt("hotel_id"))
                            .setCategoryId(resultSet.getInt("category_id"))
                            .getRoom());
                }
                room.displayInfo();
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void getAllRooms() {
        String sql = String.format("SELECT * FROM rooms");
        this.databaseService.performSQL(sql, resultSet -> {
            try{
                List<Room> roomList = new ArrayList<>();
                while (resultSet.next()) {
                    roomList.add(new RoomBuilder()
                            .setId(resultSet.getInt("id"))
                            .setRoomNumber(resultSet.getInt("room_number"))
                            .setFloor(resultSet.getInt("floor"))
                            .setPrivateRestroom(resultSet.getBoolean("private_restroom"))
                            .setHotelId(resultSet.getInt("hotel_id"))
                            .setCategoryId(resultSet.getInt("category_id"))
                            .getRoom());
                }
                for (Room room : roomList) {
                    room.displayInfo();
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
    public void updateRoom() {
        System.out.println("Input the id of the room you want to update");
        try {
            int inputId = inputNum();
            System.out.println("Room number");
            int roomNumber = inputNum();
            System.out.println("Floor");
            int floor = inputNum();
            System.out.println("Private restroom(y/n)");
            int privateRestroom = inputTinyInt();
            System.out.println("Hotel id");
            int hotelId = inputNum();
            System.out.println("Category id");
            int categoryId = inputNum();
            String sql = String.format("UPDATE `rooms` SET `room_number`='%d',`floor`='%d',`private_restroom`='%d',`hotel_id`='%d',`category_id`='%d' WHERE id = '%d'",roomNumber,floor,privateRestroom,hotelId,categoryId,inputId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void roomProblem() {

    }
}
