package com.udemy;

public class Bed {

    private Sheets sheets;
    private boolean bedMade;
    private String size;

    public Bed(Sheets sheets, boolean bedMade, String size) {
        this.sheets = sheets;
        this.bedMade = bedMade;
        this.size = size;
    }

    public void makeBed() {
        System.out.println("Making bed");
        bedMade = true;
    }

    public Sheets getSheets() {
        return sheets;
    }


}
