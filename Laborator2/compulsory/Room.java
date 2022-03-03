package com.company;

public class Room{
    private String name;
    private Type type;
    private int capacity;

    public Room() {
        setName("Unknown");
        setType(Type.UNKNOWN);
        setCapacity(-1);
    }

    public Room( String name, Integer capacity, Type type) {
        if (capacity > 100) {
            System.out.println("The capacity of the Room is exceeded!");
            System.exit(-1);
        }
        else {
            setCapacity(capacity);
            setName(name);
            setType(type);
        }

    }

    @Override
    public String toString() {
        return name +" {" + "type=" + type + ", capacity=" + capacity + '}';
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

