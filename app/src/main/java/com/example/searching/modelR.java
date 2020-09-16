package com.example.searching;

public class modelR {

    String name,place,details,purl;

    public modelR(){}

    public modelR(String name, String place, String details, String purl) {
        this.name = name;
        this.place = place;
        this.details = details;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
