package org.example.model;


public class Position {

    private int id;
    private String name;
    private int salary;

    private String seniority;

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println(id+ ": " + seniority + " " + name + " gets paid " + salary);
    }
}
