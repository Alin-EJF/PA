package com.company;

import java.util.Objects;

public abstract class Room {
    protected String name;
    protected Integer capacity;
    protected String type;


    //getters && setters
    public Integer getCapacity() {
        return this.capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }



    //override metoda toString (cu generator)
    @Override
    public String toString() {
        return name + " {" +
                "type=" + type +
                ", capacity=" + capacity +
                '}';
    }


    //override equals generat cu code generator

    //verifica daca doua obiecte de tip Room sunt identice sau nu
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Room)) return false;
        Room room = (Room) obj;
        return capacity == room.capacity && name.equals(room.name) && type.equals(room.type);
    }



}

