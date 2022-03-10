package com.company;

import java.util.Objects;

public class Event {
    private String name;
    private Integer size;
    private Integer start;
    private Integer end;

    //constructor default
    public Event() {
        this.name = "UNKNOWN";
        this.size = 0;
        this.start = -1;
        this.end = -1;
    }

    //constructor cu valorile atributelor primite ca argumente
    public Event(String name, Integer size, Integer start, Integer end) {
        if (size > 100) {
            System.out.println("The size of the event is too big!");
            System.exit(-1);
        } else {
            this.size = size;
        }
        this.name = name;

        if(start > end ) {
            System.out.println("The start time cannot be later than the end time");    //asta presupune ca evenimentele nu se termina noaptea
            System.exit(-1);
        }

        this.start = start;
        this.end = end;

    }


    //getters si setters
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //override toString generat
    @Override
    public String toString() {
        return "Event{" +
                "name=" + name +
                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    //equals override generat
    //verifica daca doua obiecte de tip Event sunt identice sau nu

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return size == event.size && start == event.start && end == event.end && name.equals(event.name);
    }


}
