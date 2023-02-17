package org.example.model;

public class Category {

    private int id;
    private boolean familyRoom;
    private boolean luxurious;

    private String name;

    public int getId() {
        return id;
    }
    public boolean isFamilyRoom() {
        return familyRoom;
    }
    public boolean isLuxurious() {
        return luxurious;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setFamilyRoom(boolean familyRoom) {
        this.familyRoom = familyRoom;
    }
    public void setLuxurious(boolean luxurious) {
        this.luxurious = luxurious;
    }


    public void displayInfo() {
        System.out.print(id + ": " + name + " is a ");
    }

}
