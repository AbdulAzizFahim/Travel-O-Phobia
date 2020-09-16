package com.example.searching;


public class Hotel_Item {

    private String Hotel_Name;
    private String Hotel_Details;
    private String Hotel_Img;
    private String Hotel_Address;

    public Hotel_Item(){}

    public Hotel_Item(String hotel_Name, String hotel_Details, String hotel_Img, String hotel_Address) {
        Hotel_Name = hotel_Name;
        Hotel_Details = hotel_Details;
        Hotel_Img = hotel_Img;
        Hotel_Address = hotel_Address;
    }

    public String getHotel_Name() {
        return Hotel_Name;
    }

    public void setHotel_Name(String hotel_Name) {
        Hotel_Name = hotel_Name;
    }

    public String getHotel_Details() {
        return Hotel_Details;
    }

    public void setHotel_Details(String hotel_Details) {
        Hotel_Details = hotel_Details;
    }

    public String getHotel_Img() {
        return Hotel_Img;
    }

    public void setHotel_Img(String hotel_Img) {
        Hotel_Img = hotel_Img;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String hotel_Address) {
        Hotel_Address = hotel_Address;
    }
}
