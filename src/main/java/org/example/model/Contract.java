package org.example.model;


import org.example.database.DatabaseService;
import org.example.model.builder.WorkerBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private int id;

    private int hotelId;
    private int workerId;
    private String contractType;

    private Date startDate;

    private Date endDate;

    public int getId() {
        return this.id;
    }

    public int getHotelId() {
        return this.hotelId;
    }

    public int getWorkerId() {
        return this.workerId;
    }

    public String getContractType() {
        return contractType;
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

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void displayInfo() {
        String sql = "SELECT contracts.id, workers.first_name, hotels.name as hotelname FROM contracts INNER JOIN workers ON contracts.worker_id = workers.id INNER JOIN hotels ON contracts.hotel_id = hotels.id WHERE contracts.id = "+id+" ORDER BY contracts.id;";
        DatabaseService.getInstance().performSQL(sql, resultSet -> {
            try{
                if(resultSet.next()) {
                    System.out.println(resultSet.getInt("id")+": "+resultSet.getString("first_name")+" works in " + resultSet.getString("hotelname"));
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }


}
