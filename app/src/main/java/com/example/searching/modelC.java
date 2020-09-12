package com.example.searching;

public class modelC {

        private String Name;
        private String Details;
        private String purl;

    public modelC(){}

    public modelC(String name, String details, String purl) {
        this.Name = name;
        this.Details = details;
        this.purl = purl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        this.Details = details;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
