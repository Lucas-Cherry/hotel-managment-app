package org.example.model;


public class Hotel {

    private int id;
    private String name;
    private String street;
    private boolean pool;
    private boolean restaurant;
    private int rating;

    private String city;

    public String getName() {
        return name;
    }
    public String getStreet() {
        return street;
    }

    public int getId() {
        return id;
    }

    public boolean isPool() {
        return pool;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void displayInfo() {
        System.out.println(id +": "+ name + " on street " + street + " in city "+city + " with a rating of " + rating);
    }
}
