package com.udemy;

public class Room {

    private Bed bed;
    private Desk desk;

    public Room(Bed bed, Desk desk) {
        this.bed = bed;
        this.desk = desk;
    }

    public void cleanRoom() {
        bed.getSheets().washSheets();
        bed.makeBed();
        desk.clean();
        System.out.println("Room cleaned");
    }

    public Desk getDesk() {
        return desk;
    }
}
