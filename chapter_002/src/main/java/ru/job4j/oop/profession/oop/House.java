package ru.job4j.oop.profession.oop;

public class House {
    public String name;
    public int floors;

    public House(String name, int floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return this.name;
    }

    public int getFloors() {
        return this.floors;
    }
}
