package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Hotel;
import org.example.model.builder.HotelBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.*;

public class HotelService {

    private final DatabaseService databaseService;

    public HotelService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
    public void createHotel() {
        try {
            System.out.println("Set ID");
            int id = inputNum();
        System.out.println("Input hotel name");
        String hotelName = inputStr();
        System.out.println("Input hotel street");
        String hotelStreet = inputStr();
        System.out.println("Does the hotel have a pool?(Y/N)");
        int hasPool=inputTinyInt();
        System.out.println("Does the hotel have a restaurant?(Y/N)");
        int hasRestaurant = inputTinyInt();
        System.out.println("Input hotel rating");
        int rating = inputNum();
            System.out.println("Input hotel city");
            String city = inputStr();
            String sql = String.format("INSERT INTO `hotels`(`id`, `name`, `street`, `pool`, `restaurant`, `rating`, `city`) VALUES ('%d','%s','%s','%d','%d','%d','%s')",id,hotelName,hotelStreet,hasPool,hasRestaurant,rating,city);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }
    public void deleteHotel() {
        System.out.println("Input hotel id");
        int id = inputNum();
        String sql = String.format("DELETE FROM hotels WHERE id = '%d'",id);
        this.databaseService.performDML(sql);
    }
    public void readHotel() {
        System.out.println("Input hotel id");
        int inputId = inputNum();
        String sql = String.format("SELECT * FROM hotels WHERE id = '%d';",inputId);
        this.databaseService.performSQL(sql, resultSet -> {
            try {
                Hotel hotel = new Hotel();
                if (resultSet.next()) {
                    hotel = (new HotelBuilder()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setStreet(resultSet.getString("street"))
                            .setPool(resultSet.getBoolean("pool"))
                            .setRestaurant(resultSet.getBoolean("restaurant"))
                            .setRating(resultSet.getInt("rating"))
                            .setCity(resultSet.getString("city"))
                            .getHotel());
                }
                hotel.displayInfo();
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void getAllHotels() {
        String sql = "SELECT * FROM hotels";
        this.databaseService.performSQL(sql, resultSet -> {
            try {
                List<Hotel> hotelList = new ArrayList<>();
                while(resultSet.next()) {
                    hotelList.add(new HotelBuilder()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setStreet(resultSet.getString("street"))
                            .setPool(resultSet.getBoolean("pool"))
                            .setRestaurant(resultSet.getBoolean("restaurant"))
                            .setRating(resultSet.getInt("rating"))
                            .setCity(resultSet.getString("city"))
                            .getHotel());
                }
                for (Hotel hotel : hotelList) {
                    hotel.displayInfo();
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
    public void updateHotel() {
        System.out.println("Input the id of the hotel you want to update");
        try {
            int inputId = inputNum();
            System.out.println("Hotel name");
            String name = inputStr();
            System.out.println("Hotel street");
            String street = inputStr();
            System.out.println("Does it have a pool(y/n)");
            int pool = inputTinyInt();
            System.out.println("Does it have a restaurant(y/n)");
            int restaurant = inputTinyInt();
            System.out.println("Hotel rating");
            int rating = inputNum();
            System.out.println("Hotel city");
            String city = inputStr();
            String sql = String.format("UPDATE `hotels` SET `name`='%s',`street`='%s',`pool`='%d',`restaurant`='%d',`rating`='%d',`city`='%s' WHERE id = '%d';",name,street,pool,restaurant,rating,city,inputId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }

    public void printNumberOfRoomsInHotel() {
        String sql = "SELECT hotels.name, COUNT(rooms.id) as liczbaPokoi FROM hotels INNER JOIN rooms ON rooms.hotel_id = hotels.id GROUP BY hotels.name;";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                while(resultSet.next()) {
                    System.out.println(resultSet.getString("hotels.name")+" has "+resultSet.getInt("liczbaPokoi")+" rooms");
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void calculateHotelExpenses() {
        String sql = "SELECT hotels.name, SUM(positions.salary) as total_pay FROM hotels LEFT JOIN contracts ON hotels.id = contracts.hotel_id LEFT JOIN workers ON workers.id = contracts.worker_id LEFT JOIN positions ON workers.position_id = positions.id GROUP BY hotels.name;";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                while(resultSet.next()) {
                    System.out.println(resultSet.getString("hotels.name")+" spends "+resultSet.getInt("total_pay")+" monthly");
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
