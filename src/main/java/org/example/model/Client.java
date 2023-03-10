package org.example.model;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void displayInfo() {
        System.out.println(id+": Client " + firstName + " " + lastName +" \nContact info phone number - " + phoneNumber + ", email - " + email);
    }
}
