package ru.job4j.profession;

public class Engineer extends Profession{
    private House house;

    public Engineer(String name, String profession, House house) {
        super(name, profession);
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void buildHouse(House house) {
        System.out.println("Engineer " + this.name + " build house " + house.getAddress());
    }
}
