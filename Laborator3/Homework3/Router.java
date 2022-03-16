package com.company;

public class Router extends Node implements Identifiable {
    private String address;
    protected String MAC;

    public Router(String name, String MAC, String location, String address) {
        super(name, location);
        this.address = address;
        this.MAC=MAC;
    }


    @Override
    public String getAddress() {
        return this.address;
    }
}
