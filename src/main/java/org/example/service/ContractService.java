package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Contract;
import org.example.model.builder.ContractBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.*;

public class ContractService {

    private final DatabaseService databaseService;

    public ContractService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void getAllContracts() {
        String sql = "SELECT * FROM contracts;";
        this.databaseService.performSQL(sql, resultSet -> {
            try {
                List<Contract> contractList = new ArrayList<>();
                while (resultSet.next()) {
                    contractList.add(new ContractBuilder()
                            .setId(resultSet.getInt("id"))
                            .setHotelId(resultSet.getInt("hotel_id"))
                            .setWorkerId(resultSet.getInt("worker_id"))
                            .setContractType(resultSet.getString("contract_type"))
                            .setStartDate(resultSet.getDate("start_date"))
                            .setEndDate(resultSet.getDate("end_date"))
                            .getContract());
                }
                for (Contract contract : contractList) {
                    contract.displayInfo();
                };
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void createContract() {
        try {
            System.out.println("Set ID");
            int id = inputNum();
            System.out.println("Input contract type");
            String contractType = inputStr();
            System.out.println("Input hotel id");
            int hotelId = inputNum();
            System.out.println("Input worker id");
            int workerId = inputNum();
            System.out.println("Input start date");
            String startDate = inputStr();
            System.out.println("Input end date");
            String endDate = inputStr();
            String sql = String.format("INSERT INTO `contracts` (`id`, `hotel_id`, `worker_id`, `contract_type`, `start_date`, `end_date`) VALUES ('%d','$d','%d','%s','%s','%s')",id,hotelId,workerId,contractType,startDate,endDate);
            this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }

    public void deleteContract() {
        System.out.println("Input contract id");
        int id = inputNum();
        String sql = String.format("DELETE FROM contracts WHERE id = '%d'",id);
        this.databaseService.performDML(sql);
    }

    public void readContracts() {
        System.out.println("Input contract id");
        int inputId = inputNum();
        String sql = String.format("SELECT * FROM contracts WHERE id = '%d';",inputId);
        this.databaseService.performSQL(sql, resultSet -> {
            try {
                Contract contract = new Contract();
                if (resultSet.next()) {
                    contract = (new ContractBuilder()
                            .setId(resultSet.getInt("id"))
                            .setHotelId(resultSet.getInt("hotel_id"))
                            .setWorkerId(resultSet.getInt("worker_id"))
                            .setContractType(resultSet.getString("contract_type"))
                            .setStartDate(resultSet.getDate("start_date"))
                            .setEndDate(resultSet.getDate("end_date"))
                            .getContract());
                }
                contract.displayInfo();
                return null;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    public void updateContract() {
        System.out.println("Input the id of the contract you want to update");
        int inputId = inputNum();
        System.out.println("Hotel id");
        int hotelId = inputNum();
        System.out.println("Worker id");
        int workerId = inputNum();
        System.out.println("Contract type");
        String contractType = inputStr();
        System.out.println("Start date");
        String startDate = inputStr();
        System.out.println("End date");
        String endDate = inputStr();
        String sql = String.format("UPDATE `contracts` SET `hotel_id`='%d',`worker_id`='%d',`contract_type`='%s',`start_date`='%s',`end_date`='%s' WHERE id = '%d'",hotelId,workerId,contractType,startDate,endDate,inputId);
        try {
            this.databaseService.performDML(sql);
        } catch (Exception ass) {
            throw new IllegalStateException(ass);
        }
    }
}
