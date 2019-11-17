package ru.job4j.oop.profession.oop;

public class Programmer extends Engineer {
    private String skill;


    public Programmer(String name, String surname, String education, String birthday, String skill) {
        super(name, surname, education, birthday);
        this.skill = skill;
    }

    public void writeCode(Software software) {
        System.out.format("Programmer %s write code %s", this.getName(), software.getName());
    }
}


