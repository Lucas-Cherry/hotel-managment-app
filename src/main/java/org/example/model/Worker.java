package org.example.model;

import org.example.database.DatabaseService;

import java.sql.SQLException;

public class Worker {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int positionId;

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPositionId() {
        return this.positionId;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public void displayInfo() {
        String sql = "SELECT workers.id, workers.first_name, positions.name FROM workers INNER JOIN positions ON workers.position_id = positions.id WHERE workers.id = "+id+" ORDER BY workers.id;";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                if(resultSet.next()) {
                    System.out.println(resultSet.getInt("id")+": "+resultSet.getString("first_name")+" works as a " + resultSet.getString("name"));
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
