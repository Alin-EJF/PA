package com.company;
import java.util.ArrayList;

public class Problem {
    //liste pentru camere, respectiv evenimente
    ArrayList<Room> rooms;
    ArrayList<Event> events;

    //constructor default cu initializarea listelor rooms si events
    public Problem() {
        this.rooms = new ArrayList<Room>();
        this.events = new ArrayList<Event>();
    }


    public void addRoom(Room room) {         //adaugarea unei camere

        if (rooms.contains(room)) {          //verificare daca camera deja exista
            System.out.format("Camera %s este deja existenta.%n", room.getName());
            System.exit(-1);
        } else
            this.rooms.add(room);
    }


    public void addEvent(Event event) {  //adaugarea unui eveniment

        if (events.contains(event)) {   //verificare daca evenimentul exista deja
            System.out.format("Evenimentul %s este deja existent.%n", event.getName());
            System.exit(-1);
        } else
            this.events.add(event);
    }
}
