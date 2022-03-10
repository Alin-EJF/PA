package com.company;

public class LectureHall extends Room {

    private boolean videoProjector;

    //constructor default
    public LectureHall() {
        this.name = "UNKNOWN";
        this.capacity = 0;
        this.type = "Lecture hall";
        this.videoProjector = false;
    }

    //constructor cu valorile atributelor primite ca argumente
    public LectureHall(String name, Integer capacity, boolean videoProjector) {
        this.name = name;
        this.type = "Lecture hall";
        this.capacity = capacity;
        this.videoProjector = videoProjector;
    }



    public boolean getVideoProjector () {
            return this.videoProjector;
    } //getter

    public void setVideoProjector ( boolean projector){
            this.videoProjector = projector;
    }  //setter



    }


