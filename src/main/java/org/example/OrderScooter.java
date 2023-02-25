package org.example;

public class OrderScooter {
private String name;
    private String surname;
    private String address;
    private String subwayStation;
    private String phone;
    private int timeRent;
    private String dateBringScooter;
    private String messageForCourier;
    private String [] colorScooter;

    public OrderScooter() {
    }
    public OrderScooter(String name, String surname, String address, String subwayStation, String phone, int timeRent,
                        String dateBringScooter, String messageForCourier, String [] colorScooter) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.timeRent = timeRent;
        this.dateBringScooter = dateBringScooter;
        this.messageForCourier = messageForCourier;
        this.colorScooter = colorScooter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public void setSubwayStation(String subwayStation) {
        this.subwayStation = subwayStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(int timeRent) {
        this.timeRent = timeRent;
    }

    public String getDateBringScooter() {
        return dateBringScooter;
    }

    public void setDateBringScooter(String dateBringScooter) {
        this.dateBringScooter = dateBringScooter;
    }

    public String getMessageForCourier() {
        return messageForCourier;
    }

    public void setMessageForCourier(String messageForCourier) {
        this.messageForCourier = messageForCourier;
    }

    public String[] getColorScooter() {
        return colorScooter;
    }

    public void setColorScooter(String[] colorScooter) {
        this.colorScooter = colorScooter;
    }
}