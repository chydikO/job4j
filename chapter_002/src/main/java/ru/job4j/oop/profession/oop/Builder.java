package ru.job4j.oop.profession.oop;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void buildHose(House house) {
        System.out.printf("Builder $s build house %s", this.getName(), house.getName());
    }
}
