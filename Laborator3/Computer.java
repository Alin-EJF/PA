package com.company;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;
    protected String MAC;


    public Computer(String name, String location, String MAC){
        super(name,location);
        this.MAC=MAC;
    }
    public Computer(String name){
        super(name);
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

}
