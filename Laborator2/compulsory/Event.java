package com.company;

public class Event{
    private String name;
    private int size;
    private int start;
    private int end;


    public Event(String name, Integer size, Integer start, Integer end) {
        if (size > 100) {
            System.out.println("The size of the event is too big!");
            System.exit(-1);
        } else
        {
            setSize(size);
            setName(name);
            setStart(start);
            setEnd(end);
        }
    }

    @Override
    public String toString() {
        return name + " {" + "size=" + size + ", start=" + start + ", end=" + end + '}';
    }

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

}
