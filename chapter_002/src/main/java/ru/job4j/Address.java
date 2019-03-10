package ru.job4j;

public class Address {
    private String street;
    private String house;

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Address(String street, String house) {
        this.street = street;
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }
}
