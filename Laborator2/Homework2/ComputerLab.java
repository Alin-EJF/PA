package com.company;

public class ComputerLab extends Room{
    private String operatingSystem;

    //constructor default
    public ComputerLab() {
        this.name = "UNKNOWN";
        this.capacity = 0;
        this.type = "Computer Lab";
        this.operatingSystem = " ";
    }

    //constructor
    public ComputerLab(String name, int capacity, String operatingSystem) {
        this.name = name;
        this.type = "Computer Lab";
        this.capacity = capacity;
        this.operatingSystem = operatingSystem;
    }

    //getter si setter

    public String getOperatingSystem() { return this.operatingSystem; }

    public void setOperatingSystem(String opSystem) {
        this.operatingSystem = opSystem;
    }



}
