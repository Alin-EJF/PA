package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Assign {
    public static void main(String[] args) {

        Event[] events = new Event[5];
        events[0] = new Event("C1", 100, 8, 10);
        events[1] = new Event("C2", 100, 10, 12);
        events[2] = new Event("L1", 30, 8, 10);
        events[3] = new Event("L2", 30, 8, 10);
        events[4] = new Event("L3", 30, 10, 12);
        System.out.println("Events: ");
        for (Event i : events)
            System.out.println(i.toString());


        Room[] rooms = new Room[4];
        rooms[0] = new Room("401", 30, Type.LAB);
        rooms[1] = new Room("403", 30, Type.LAB);
        rooms[2] = new Room("405", 30, Type.LAB);
        rooms[3] = new Room("309", 100, Type.LECTURE_HALL);

        System.out.println("Rooms: ");
        for (Room i : rooms)
            System.out.println(i.toString());


    }
}

