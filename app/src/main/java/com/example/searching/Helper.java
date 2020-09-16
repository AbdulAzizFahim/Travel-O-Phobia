package com.example.searching;

public class Helper {

    String name,details,purl,place;

    public Helper(){}

    public Helper(String name, String details, String purl, String place) {
        this.name = name;
        this.details = details;
        this.purl = purl;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
