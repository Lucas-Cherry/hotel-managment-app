package org.example.service;

import org.example.database.DatabaseService;
import org.example.model.Client;
import org.example.model.builder.ClientBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.misc.PrintError.printError;
import static org.example.service.misc.ReadInput.inputNum;
import static org.example.service.misc.ReadInput.inputStr;

public class ClientService {

    private final DatabaseService databaseService;
    public ClientService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void getAll() {
        String sql = "SELECT * FROM clients;";
        this.databaseService.performSQL(sql , resultSet -> {
            try{
                List<Client> clientList = new ArrayList<>();
                while(resultSet.next()) {
                    clientList.add(new ClientBuilder()
                            .setId(resultSet.getInt("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .setEmail(resultSet.getString("email"))
                            .getClient());
                }
                for (Client client : clientList) {
                    client.displayInfo();
                };
                return null;
            } catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }
    public void createClient() {
        try {
            System.out.println("Set ID");
            int id = inputNum();
        System.out.println("Input client first name");
        String firstName = inputStr();
        System.out.println("Input client last name");
        String lastName = inputStr();
        System.out.println("Input client phone number");
        String phoneNumber = inputStr();
        System.out.println("Input client E-mail");
        String email = inputStr();
        String sql = String.format("INSERT INTO `clients`(`id`, `first_name`, `last_name`, `phone_number`, `email`) VALUES ('%d', '%s', '%s', '%s', '%s')", id,firstName,lastName,phoneNumber,email);
        this.databaseService.performDML(sql);
        } catch (Exception exception) {
            printError(exception);
        }
    }
    public void deleteClient() {
        System.out.println("Input client id");
        int id = inputNum();
        String sql = String.format("DELETE FROM clients WHERE id = '%d'", id);
        this.databaseService.performDML(sql);
    }
    public void readClients() {
        System.out.println("Input client id");
        int id = inputNum();
        String sql = String.format("SELECT * FROM clients WHERE id = '%d;",id);
        this.databaseService.performSQL(sql , resultSet -> {
            try{
                if(resultSet.next()) {
                    Client client = (new ClientBuilder()
                            .setId(resultSet.getInt("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .setEmail(resultSet.getString("email"))
                            .getClient());
                    client.displayInfo();
                }
                return null;
            } catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }
    public void updateClient(){
        System.out.println("Input the id of the client you want to update");
            int inputId = inputNum();
            System.out.println("First name");
            String firstName = inputStr();
        System.out.println("Last name");
        String lastName = inputStr();
        System.out.println("Phone number");
        String phoneNumber = inputStr();
        System.out.println("Email");
        String email = inputStr();
        String sql = String.format("UPDATE `clients` SET `first_name`='%s',`last_name`='%s',`phone_number`='%s',`email`='%s' WHERE id = '%d';",firstName,lastName,phoneNumber,email,inputId);
        try{
            this.databaseService.performDML(sql);
        } catch (Exception ass) {
            throw new IllegalStateException(ass);
        }

    }
}
