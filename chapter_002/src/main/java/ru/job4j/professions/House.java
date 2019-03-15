package ru.job4j.professions;

public class House {
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public House(Address address) {
        this.address = address;
    }
}
