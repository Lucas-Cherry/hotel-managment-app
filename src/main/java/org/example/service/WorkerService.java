package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Worker;
import org.example.model.builder.WorkerBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.inputNum;
import static org.example.service.misc.ReadInput.inputStr;

public class WorkerService {

    private final DatabaseService databaseService;

    public WorkerService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
    public void createWorker() {
        try {
            System.out.println("Set ID");
            int id = inputNum();
        System.out.println("Input workers first name");
        String firstName = inputStr();
        System.out.println("Input workers last name");
        String lastName = inputStr();
        System.out.println("Input workers phone number");
        String phoneNumber = inputStr();
        System.out.println("Input workers email");
        String email = inputStr();
        System.out.println("Input workers' position id");
        int positionId = inputNum();
            System.out.println("Input workers' city");
            String city = inputStr();
            String sql = String.format("INSERT INTO `workers`(`id`, `first_name`, `last_name`, `phone_number`, `email`, `position_id`, `city`) VALUES ('%d','%s','%s','%s','%s','%d','%s')",id,firstName,lastName,phoneNumber,email,positionId,city);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void deleteWorker() {
        System.out.println("Input worker id");
        try {
            int workerId = inputNum();
            String sql = String.format("DELETE FROM workers WHERE id = '%d'", workerId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void readWorkers() {
        System.out.println("Input worker id");
        int inputId = inputNum();
        String sql = String.format("SELECT * FROM workers WHERE id = '%d';",inputId);
        this.databaseService.performSQL(sql, resultSet -> {
            try{
                Worker worker = new Worker();
                if (resultSet.next()) {
                    worker = (new WorkerBuilder()
                            .setId(resultSet.getInt("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .setEmail(resultSet.getString("email"))
                            .setPositionId(resultSet.getInt("position_id"))
                            .setCity(resultSet.getString("city"))
                            .getWorker());
                }
                worker.displayInfo();
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void getAllWorkers() {
        String sql = String.format("SELECT * FROM workers");
        this.databaseService.performSQL(sql, resultSet -> {
            try{
                List<Worker> workerList = new ArrayList<>();
                while(resultSet.next()) {
                    workerList.add(new WorkerBuilder()
                            .setId(resultSet.getInt("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .setEmail(resultSet.getString("email"))
                            .setPositionId(resultSet.getInt("position_id"))
                            .setCity(resultSet.getString("city"))
                            .getWorker());
                }
                for (Worker worker : workerList) {
                    worker.displayInfo();
                }
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
    public void updateWorker(){
        System.out.println("Input the id of the worker you want to update");
        try {
            int inputId = inputNum();
            System.out.println("First name");
            String firstName = inputStr();
            System.out.println("Last name");
            String lastName = inputStr();
            System.out.println("Phone number");
            String phoneNumber = inputStr();
            System.out.println("Email");
            String email = inputStr();
            System.out.println("Position id");
            int positionId = inputNum();
            System.out.println("City");
            String city = inputStr();
            String sql = String.format("UPDATE `workers` SET `first_name`='%s',`last_name`='%s',`phone_number`='%s',`email`='%s',`position_id`='%d',`city`='%s' WHERE id = '%d'",firstName,lastName,phoneNumber,email,positionId,city,inputId);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
}
