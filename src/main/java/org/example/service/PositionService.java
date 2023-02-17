package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Position;
import org.example.model.builder.PositionBuilder;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.inputNum;
import static org.example.service.misc.ReadInput.inputStr;

public class PositionService {

    private final DatabaseService databaseService;

    public PositionService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
    public void createPosition() {
        try{
            System.out.println("Set ID");
            int id = inputNum();
        System.out.println("Input position name");
        String name = inputStr();
        System.out.println("Input salary");
        int salary = inputNum();
        System.out.println("Input seniority");
        String seniority = inputStr();
            String sql = String.format("INSERT INTO `positions`(`id`, `name`, `salary`, `seniority`) VALUES ('%d','%s','%d','%s')",id,name,salary,seniority);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void deletePosition() {
        System.out.println("Input position id");
        try {
            int id = inputNum();
            String sql = String.format("DELETE FROM hotels WHERE id = '%d'",id);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void readPositions() {
        System.out.println("Input position id");
        int inputId = inputNum();
        String sql = String.format("SELECT * FROM positions WHERE id = '%d';",inputId);
        this.databaseService.performSQL(sql, resultSet -> {
            try {
                Position position = new Position();
                if (resultSet.next()) {
                    position = (new PositionBuilder()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setSalary(resultSet.getInt("salary"))
                            .setSeniority(resultSet.getString("seniority"))
                            .getPosition());
                }
                position.displayInfo();
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void getAllPositions() {
        String sql = String.format("SELECT * FROM positions");
        this.databaseService.performSQL(sql, resultSet -> {
            try {
                List<Position> positionList = new ArrayList<>();
                while(resultSet.next()) {
                    positionList.add(new PositionBuilder()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setSalary(resultSet.getInt("salary"))
                            .setSeniority(resultSet.getString("seniority"))
                            .getPosition());
                }
                for (Position position : positionList) {
                    position.displayInfo();
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void updatePosition() {
        System.out.println("Input the id of the position you want to update");
        try {
            int id = inputNum();
            System.out.println("Position name");
            String name = inputStr();
            System.out.println("Position salary");
            int salary = inputNum();
            System.out.println("Position seniority");
            String seniority = inputStr();
            String sql = String.format("UPDATE `positions` SET `name`='%s',`salary`='%d',`seniority`='%s' WHERE '%d'",name,salary,seniority,id);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
}
